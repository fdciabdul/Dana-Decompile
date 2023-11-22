package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FirebasePerfTraceValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final TraceMetric traceMetric;

    private boolean isValidCounterValue(Long l) {
        return l != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfTraceValidator(TraceMetric traceMetric) {
        this.traceMetric = traceMetric;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public final boolean isValidPerfMetric() {
        if (!isValidTrace(this.traceMetric, 0)) {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Trace:");
            sb.append(this.traceMetric.getName());
            androidLogger.warn(sb.toString());
            return false;
        } else if (!hasCounters(this.traceMetric) || areCountersValid(this.traceMetric)) {
            return true;
        } else {
            AndroidLogger androidLogger2 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid Counters for Trace:");
            sb2.append(this.traceMetric.getName());
            androidLogger2.warn(sb2.toString());
            return false;
        }
    }

    private boolean hasCounters(TraceMetric traceMetric) {
        if (traceMetric.getCountersCount() > 0) {
            return true;
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (it.next().getCountersCount() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean areCountersValid(TraceMetric traceMetric) {
        return areCountersValid(traceMetric, 0);
    }

    private boolean areCountersValid(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry<String, Long> entry : traceMetric.getCountersMap().entrySet()) {
            if (!isValidCounterId(entry.getKey())) {
                AndroidLogger androidLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("invalid CounterId:");
                sb.append(entry.getKey());
                androidLogger.warn(sb.toString());
                return false;
            } else if (!isValidCounterValue(entry.getValue())) {
                AndroidLogger androidLogger2 = logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("invalid CounterValue:");
                sb2.append(entry.getValue());
                androidLogger2.warn(sb2.toString());
                return false;
            }
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (!areCountersValid(it.next(), i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isScreenTrace(TraceMetric traceMetric) {
        return traceMetric.getName().startsWith(Constants.SCREEN_TRACE_PREFIX);
    }

    private boolean isValidScreenTrace(TraceMetric traceMetric) {
        Long l = traceMetric.getCountersMap().get(Constants.CounterNames.FRAMES_TOTAL.toString());
        return l != null && l.compareTo((Long) 0L) > 0;
    }

    private boolean isValidTrace(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            logger.warn("TraceMetric is null");
            return false;
        } else if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        } else if (!isValidTraceId(traceMetric.getName())) {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("invalid TraceId:");
            sb.append(traceMetric.getName());
            androidLogger.warn(sb.toString());
            return false;
        } else if (!isValidTraceDuration(traceMetric)) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid TraceDuration:");
            sb2.append(traceMetric.getDurationUs());
            androidLogger2.warn(sb2.toString());
            return false;
        } else if (!traceMetric.hasClientStartTimeUs()) {
            logger.warn("clientStartTimeUs is null.");
            return false;
        } else if (isScreenTrace(traceMetric) && !isValidScreenTrace(traceMetric)) {
            AndroidLogger androidLogger3 = logger;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("non-positive totalFrames in screen trace ");
            sb3.append(traceMetric.getName());
            androidLogger3.warn(sb3.toString());
            return false;
        } else {
            Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
            while (it.hasNext()) {
                if (!isValidTrace(it.next(), i + 1)) {
                    return false;
                }
            }
            return areAllAttributesValid(traceMetric.getCustomAttributesMap());
        }
    }

    private boolean isValidTraceId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return !trim.isEmpty() && trim.length() <= 100;
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        return traceMetric != null && traceMetric.getDurationUs() > 0;
    }

    private boolean isValidCounterId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            logger.warn("counterId is empty");
            return false;
        } else if (trim.length() > 100) {
            logger.warn("counterId exceeded max length 100");
            return false;
        } else {
            return true;
        }
    }

    private boolean areAllAttributesValid(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                validateAttribute(entry.getKey(), entry.getValue());
            } catch (IllegalArgumentException e) {
                logger.warn(e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }
}
