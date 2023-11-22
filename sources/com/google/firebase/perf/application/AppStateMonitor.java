package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.FrameMetricsCalculator;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.ScreenTraceUtil;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class AppStateMonitor implements Application.ActivityLifecycleCallbacks {
    private static volatile AppStateMonitor instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final WeakHashMap<Activity, FragmentStateMonitor> activityToFragmentStateMonitorMap;
    private final WeakHashMap<Activity, FrameMetricsRecorder> activityToRecorderMap;
    private final WeakHashMap<Activity, Boolean> activityToResumedMap;
    private final WeakHashMap<Activity, Trace> activityToScreenTraceMap;
    private Set<AppColdStartCallback> appColdStartSubscribers;
    private final Set<WeakReference<AppStateCallback>> appStateSubscribers;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private ApplicationProcessState currentAppState;
    private boolean isColdStart;
    private boolean isRegisteredForLifecycleCallbacks;
    private final Map<String, Long> metricToCountMap;
    private Timer resumeTime;
    private final boolean screenPerformanceRecordingSupported;
    private Timer stopTime;
    private final TransportManager transportManager;
    private final AtomicInteger tsnsCount;

    /* loaded from: classes.dex */
    public interface AppColdStartCallback {
        void onAppColdStart();
    }

    /* loaded from: classes.dex */
    public interface AppStateCallback {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public static AppStateMonitor getInstance() {
        if (instance == null) {
            synchronized (AppStateMonitor.class) {
                if (instance == null) {
                    instance = new AppStateMonitor(TransportManager.getInstance(), new Clock());
                }
            }
        }
        return instance;
    }

    AppStateMonitor(TransportManager transportManager, Clock clock) {
        this(transportManager, clock, ConfigResolver.getInstance(), isScreenPerformanceRecordingSupported());
    }

    AppStateMonitor(TransportManager transportManager, Clock clock, ConfigResolver configResolver, boolean z) {
        this.activityToResumedMap = new WeakHashMap<>();
        this.activityToRecorderMap = new WeakHashMap<>();
        this.activityToFragmentStateMonitorMap = new WeakHashMap<>();
        this.activityToScreenTraceMap = new WeakHashMap<>();
        this.metricToCountMap = new HashMap();
        this.appStateSubscribers = new HashSet();
        this.appColdStartSubscribers = new HashSet();
        this.tsnsCount = new AtomicInteger(0);
        this.currentAppState = ApplicationProcessState.BACKGROUND;
        this.isRegisteredForLifecycleCallbacks = false;
        this.isColdStart = true;
        this.transportManager = transportManager;
        this.clock = clock;
        this.configResolver = configResolver;
        this.screenPerformanceRecordingSupported = z;
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        synchronized (this) {
            if (this.isRegisteredForLifecycleCallbacks) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                this.isRegisteredForLifecycleCallbacks = true;
            }
        }
    }

    public void unregisterActivityLifecycleCallbacks(Context context) {
        synchronized (this) {
            if (this.isRegisteredForLifecycleCallbacks) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
                    this.isRegisteredForLifecycleCallbacks = false;
                }
            }
        }
    }

    public void incrementCount(String str, long j) {
        synchronized (this.metricToCountMap) {
            Long l = this.metricToCountMap.get(str);
            if (l == null) {
                this.metricToCountMap.put(str, Long.valueOf(j));
            } else {
                this.metricToCountMap.put(str, Long.valueOf(l.longValue() + j));
            }
        }
    }

    public void incrementTsnsCount(int i) {
        this.tsnsCount.addAndGet(i);
    }

    private void startFrameMonitoring(Activity activity) {
        if (isScreenTraceSupported() && this.configResolver.isPerformanceMonitoringEnabled()) {
            FrameMetricsRecorder frameMetricsRecorder = new FrameMetricsRecorder(activity);
            this.activityToRecorderMap.put(activity, frameMetricsRecorder);
            if (activity instanceof FragmentActivity) {
                FragmentStateMonitor fragmentStateMonitor = new FragmentStateMonitor(this.clock, this.transportManager, this, frameMetricsRecorder);
                this.activityToFragmentStateMonitorMap.put(activity, fragmentStateMonitor);
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(fragmentStateMonitor, true);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        startFrameMonitoring(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.activityToRecorderMap.remove(activity);
        if (this.activityToFragmentStateMonitorMap.containsKey(activity)) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.activityToFragmentStateMonitorMap.remove(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        synchronized (this) {
            if (isScreenTraceSupported() && this.configResolver.isPerformanceMonitoringEnabled()) {
                if (!this.activityToRecorderMap.containsKey(activity)) {
                    startFrameMonitoring(activity);
                }
                this.activityToRecorderMap.get(activity).start();
                Trace trace = new Trace(getScreenTraceName(activity), this.transportManager, this.clock, this);
                trace.start();
                this.activityToScreenTraceMap.put(activity, trace);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        synchronized (this) {
            if (isScreenTraceSupported()) {
                sendScreenTrace(activity);
            }
            if (this.activityToResumedMap.containsKey(activity)) {
                this.activityToResumedMap.remove(activity);
                if (this.activityToResumedMap.isEmpty()) {
                    this.stopTime = this.clock.getTime();
                    sendSessionLog(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString(), this.resumeTime, this.stopTime);
                    updateAppState(ApplicationProcessState.BACKGROUND);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this) {
            if (this.activityToResumedMap.isEmpty()) {
                this.resumeTime = this.clock.getTime();
                this.activityToResumedMap.put(activity, Boolean.TRUE);
                if (this.isColdStart) {
                    updateAppState(ApplicationProcessState.FOREGROUND);
                    sendAppColdStartUpdate();
                    this.isColdStart = false;
                } else {
                    sendSessionLog(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString(), this.stopTime, this.resumeTime);
                    updateAppState(ApplicationProcessState.FOREGROUND);
                }
            } else {
                this.activityToResumedMap.put(activity, Boolean.TRUE);
            }
        }
    }

    public boolean isColdStart() {
        return this.isColdStart;
    }

    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    public void registerForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.appStateSubscribers) {
            this.appStateSubscribers.add(weakReference);
        }
    }

    public void unregisterForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.appStateSubscribers) {
            this.appStateSubscribers.remove(weakReference);
        }
    }

    public void registerForAppColdStart(AppColdStartCallback appColdStartCallback) {
        synchronized (this.appStateSubscribers) {
            this.appColdStartSubscribers.add(appColdStartCallback);
        }
    }

    private void updateAppState(ApplicationProcessState applicationProcessState) {
        this.currentAppState = applicationProcessState;
        synchronized (this.appStateSubscribers) {
            Iterator<WeakReference<AppStateCallback>> it = this.appStateSubscribers.iterator();
            while (it.hasNext()) {
                AppStateCallback appStateCallback = it.next().get();
                if (appStateCallback != null) {
                    appStateCallback.onUpdateAppState(this.currentAppState);
                } else {
                    it.remove();
                }
            }
        }
    }

    private void sendAppColdStartUpdate() {
        synchronized (this.appStateSubscribers) {
            for (AppColdStartCallback appColdStartCallback : this.appColdStartSubscribers) {
                if (appColdStartCallback != null) {
                    appColdStartCallback.onAppColdStart();
                }
            }
        }
    }

    public boolean isForeground() {
        return this.currentAppState == ApplicationProcessState.FOREGROUND;
    }

    private void sendScreenTrace(Activity activity) {
        Trace trace = this.activityToScreenTraceMap.get(activity);
        if (trace == null) {
            return;
        }
        this.activityToScreenTraceMap.remove(activity);
        Optional<FrameMetricsCalculator.PerfFrameMetrics> stop = this.activityToRecorderMap.get(activity).stop();
        if (!stop.isAvailable()) {
            logger.warn("Failed to record frame data for %s.", activity.getClass().getSimpleName());
            return;
        }
        ScreenTraceUtil.addFrameCounters(trace, stop.get());
        trace.stop();
    }

    private void sendSessionLog(String str, Timer timer, Timer timer2) {
        if (this.configResolver.isPerformanceMonitoringEnabled()) {
            TraceMetric.Builder addPerfSessions = TraceMetric.newBuilder().setName(str).setClientStartTimeUs(timer.getMicros()).setDurationUs(timer.getDurationMicros(timer2)).addPerfSessions(SessionManager.getInstance().perfSession().build());
            int andSet = this.tsnsCount.getAndSet(0);
            synchronized (this.metricToCountMap) {
                addPerfSessions.putAllCounters(this.metricToCountMap);
                if (andSet != 0) {
                    addPerfSessions.putCounters(Constants.CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
                }
                this.metricToCountMap.clear();
            }
            this.transportManager.log(addPerfSessions.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    protected boolean isScreenTraceSupported() {
        return this.screenPerformanceRecordingSupported;
    }

    private static boolean isScreenPerformanceRecordingSupported() {
        return FrameMetricsRecorder.isFrameMetricsRecordingSupported();
    }

    public static String getScreenTraceName(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.SCREEN_TRACE_PREFIX);
        sb.append(activity.getClass().getSimpleName());
        return sb.toString();
    }

    WeakHashMap<Activity, Boolean> getResumed() {
        return this.activityToResumedMap;
    }

    WeakHashMap<Activity, Trace> getActivity2ScreenTrace() {
        return this.activityToScreenTraceMap;
    }

    Timer getPauseTime() {
        return this.stopTime;
    }

    void setStopTime(Timer timer) {
        this.stopTime = timer;
    }

    Timer getResumeTime() {
        return this.resumeTime;
    }

    public void setIsColdStart(boolean z) {
        this.isColdStart = z;
    }
}
