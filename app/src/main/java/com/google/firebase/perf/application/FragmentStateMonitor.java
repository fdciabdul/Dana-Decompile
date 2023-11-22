package com.google.firebase.perf.application;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.FrameMetricsCalculator;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.ScreenTraceUtil;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class FragmentStateMonitor extends FragmentManager.FragmentLifecycleCallbacks {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final FrameMetricsRecorder activityFramesRecorder;
    private final AppStateMonitor appStateMonitor;
    private final Clock clock;
    private final WeakHashMap<Fragment, Trace> fragmentToTraceMap = new WeakHashMap<>();
    private final TransportManager transportManager;

    public FragmentStateMonitor(Clock clock, TransportManager transportManager, AppStateMonitor appStateMonitor, FrameMetricsRecorder frameMetricsRecorder) {
        this.clock = clock;
        this.transportManager = transportManager;
        this.appStateMonitor = appStateMonitor;
        this.activityFramesRecorder = frameMetricsRecorder;
    }

    public String getFragmentScreenTraceName(Fragment fragment) {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.SCREEN_TRACE_PREFIX);
        sb.append(fragment.getClass().getSimpleName());
        return sb.toString();
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        logger.debug("FragmentMonitor %s.onFragmentResumed", fragment.getClass().getSimpleName());
        Trace trace = new Trace(getFragmentScreenTraceName(fragment), this.transportManager, this.clock, this.appStateMonitor);
        trace.start();
        trace.putAttribute(Constants.PARENT_FRAGMENT_ATTRIBUTE_KEY, fragment.getParentFragment() == null ? Constants.PARENT_FRAGMENT_ATTRIBUTE_VALUE_NONE : fragment.getParentFragment().getClass().getSimpleName());
        if (fragment.getActivity() != null) {
            trace.putAttribute(Constants.ACTIVITY_ATTRIBUTE_KEY, fragment.getActivity().getClass().getSimpleName());
        }
        this.fragmentToTraceMap.put(fragment, trace);
        this.activityFramesRecorder.startFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        AndroidLogger androidLogger = logger;
        androidLogger.debug("FragmentMonitor %s.onFragmentPaused ", fragment.getClass().getSimpleName());
        if (!this.fragmentToTraceMap.containsKey(fragment)) {
            androidLogger.warn("FragmentMonitor: missed a fragment trace from %s", fragment.getClass().getSimpleName());
            return;
        }
        Trace trace = this.fragmentToTraceMap.get(fragment);
        this.fragmentToTraceMap.remove(fragment);
        Optional<FrameMetricsCalculator.PerfFrameMetrics> stopFragment = this.activityFramesRecorder.stopFragment(fragment);
        if (!stopFragment.isAvailable()) {
            androidLogger.warn("onFragmentPaused: recorder failed to trace %s", fragment.getClass().getSimpleName());
            return;
        }
        ScreenTraceUtil.addFrameCounters(trace, stopFragment.get());
        trace.stop();
    }

    WeakHashMap<Fragment, Trace> getFragmentToTraceMap() {
        return this.fragmentToTraceMap;
    }
}
