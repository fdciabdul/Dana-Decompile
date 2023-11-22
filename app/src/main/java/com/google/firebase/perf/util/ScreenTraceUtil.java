package com.google.firebase.perf.util;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.FrameMetricsCalculator;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.util.Constants;

/* loaded from: classes.dex */
public class ScreenTraceUtil {
    private static final AndroidLogger logger = AndroidLogger.getInstance();

    public static Trace addFrameCounters(Trace trace, FrameMetricsCalculator.PerfFrameMetrics perfFrameMetrics) {
        if (perfFrameMetrics.getTotalFrames() > 0) {
            trace.putMetric(Constants.CounterNames.FRAMES_TOTAL.toString(), perfFrameMetrics.getTotalFrames());
        }
        if (perfFrameMetrics.getSlowFrames() > 0) {
            trace.putMetric(Constants.CounterNames.FRAMES_SLOW.toString(), perfFrameMetrics.getSlowFrames());
        }
        if (perfFrameMetrics.getFrozenFrames() > 0) {
            trace.putMetric(Constants.CounterNames.FRAMES_FROZEN.toString(), perfFrameMetrics.getFrozenFrames());
        }
        AndroidLogger androidLogger = logger;
        StringBuilder sb = new StringBuilder();
        sb.append("Screen trace: ");
        sb.append(trace.getName());
        sb.append(" _fr_tot:");
        sb.append(perfFrameMetrics.getTotalFrames());
        sb.append(" _fr_slo:");
        sb.append(perfFrameMetrics.getSlowFrames());
        sb.append(" _fr_fzn:");
        sb.append(perfFrameMetrics.getFrozenFrames());
        androidLogger.debug(sb.toString());
        return trace;
    }
}
