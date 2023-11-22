package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {
    private static final int CORE_POOL_SIZE = 0;
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    private static final int MAX_POOL_SIZE = 1;
    private static ExecutorService executorService;
    private static volatile AppStartTrace instance;
    private Context appContext;
    private WeakReference<Activity> appStartActivity;
    private final Clock clock;
    private WeakReference<Activity> launchActivity;
    private PerfSession startSession;
    private final TransportManager transportManager;
    private boolean isRegisteredForLifecycleCallbacks = false;
    private boolean isTooLateToInitUI = false;
    private Timer appStartTime = null;
    private Timer onCreateTime = null;
    private Timer onStartTime = null;
    private Timer onResumeTime = null;
    private boolean isStartedFromBackground = false;

    public static void setLauncherActivityOnCreateTime(String str) {
    }

    public static void setLauncherActivityOnResumeTime(String str) {
    }

    public static void setLauncherActivityOnStartTime(String str) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public static AppStartTrace getInstance() {
        return instance != null ? instance : getInstance(TransportManager.getInstance(), new Clock());
    }

    static AppStartTrace getInstance(TransportManager transportManager, Clock clock) {
        if (instance == null) {
            synchronized (AppStartTrace.class) {
                if (instance == null) {
                    instance = new AppStartTrace(transportManager, clock, new ThreadPoolExecutor(0, 1, 10 + MAX_LATENCY_BEFORE_UI_INIT, TimeUnit.SECONDS, new LinkedBlockingQueue(1)));
                }
            }
        }
        return instance;
    }

    AppStartTrace(TransportManager transportManager, Clock clock, ExecutorService executorService2) {
        this.transportManager = transportManager;
        this.clock = clock;
        executorService = executorService2;
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
                this.appContext = applicationContext;
            }
        }
    }

    public void unregisterActivityLifecycleCallbacks() {
        synchronized (this) {
            if (this.isRegisteredForLifecycleCallbacks) {
                ((Application) this.appContext).unregisterActivityLifecycleCallbacks(this);
                this.isRegisteredForLifecycleCallbacks = false;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this) {
            if (!this.isStartedFromBackground && this.onCreateTime == null) {
                this.launchActivity = new WeakReference<>(activity);
                this.onCreateTime = this.clock.getTime();
                if (FirebasePerfProvider.getAppStartTime().getDurationMicros(this.onCreateTime) > MAX_LATENCY_BEFORE_UI_INIT) {
                    this.isTooLateToInitUI = true;
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        synchronized (this) {
            if (!this.isStartedFromBackground && this.onStartTime == null && !this.isTooLateToInitUI) {
                this.onStartTime = this.clock.getTime();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this) {
            if (!this.isStartedFromBackground && this.onResumeTime == null && !this.isTooLateToInitUI) {
                this.appStartActivity = new WeakReference<>(activity);
                this.onResumeTime = this.clock.getTime();
                this.appStartTime = FirebasePerfProvider.getAppStartTime();
                this.startSession = SessionManager.getInstance().perfSession();
                AndroidLogger androidLogger = AndroidLogger.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("onResume(): ");
                sb.append(activity.getClass().getName());
                sb.append(": ");
                sb.append(this.appStartTime.getDurationMicros(this.onResumeTime));
                sb.append(" microseconds");
                androidLogger.debug(sb.toString());
                executorService.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.AppStartTrace$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppStartTrace.this.logAppStartTrace();
                    }
                });
                if (this.isRegisteredForLifecycleCallbacks) {
                    unregisterActivityLifecycleCallbacks();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppStartTrace() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(Constants.TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(getappStartTime().getMicros()).setDurationUs(getappStartTime().getDurationMicros(this.onResumeTime));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(TraceMetric.newBuilder().setName(Constants.TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(getappStartTime().getMicros()).setDurationUs(getappStartTime().getDurationMicros(this.onCreateTime)).build());
        TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
        newBuilder.setName(Constants.TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.onCreateTime.getMicros()).setDurationUs(this.onCreateTime.getDurationMicros(this.onStartTime));
        arrayList.add(newBuilder.build());
        TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
        newBuilder2.setName(Constants.TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.onStartTime.getMicros()).setDurationUs(this.onStartTime.getDurationMicros(this.onResumeTime));
        arrayList.add(newBuilder2.build());
        durationUs.addAllSubtraces(arrayList).addPerfSessions(this.startSession.build());
        this.transportManager.log(durationUs.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        synchronized (this) {
        }
    }

    /* loaded from: classes.dex */
    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.trace.onCreateTime == null) {
                this.trace.isStartedFromBackground = true;
            }
        }
    }

    Activity getLaunchActivity() {
        return this.launchActivity.get();
    }

    Activity getAppStartActivity() {
        return this.appStartActivity.get();
    }

    Timer getappStartTime() {
        return this.appStartTime;
    }

    Timer getOnCreateTime() {
        return this.onCreateTime;
    }

    Timer getOnStartTime() {
        return this.onStartTime;
    }

    Timer getOnResumeTime() {
        return this.onResumeTime;
    }

    void setIsStartFromBackground() {
        this.isStartedFromBackground = true;
    }
}
