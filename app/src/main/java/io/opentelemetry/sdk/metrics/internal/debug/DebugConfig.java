package io.opentelemetry.sdk.metrics.internal.debug;

import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Locale;

/* loaded from: classes6.dex */
public final class DebugConfig {
    private static final String ENABLE_METRICS_DEBUG_PROPERTY = "otel.experimental.sdk.metrics.debug";
    private static boolean enabled;

    public static String getHowToEnableMessage() {
        return "To enable better debugging, run your JVM with -Dotel.experimental.sdk.metrics.debug=true";
    }

    private DebugConfig() {
    }

    static {
        enabled = SummaryActivity.CHECKED.equalsIgnoreCase(System.getProperty(ENABLE_METRICS_DEBUG_PROPERTY)) || SummaryActivity.CHECKED.equalsIgnoreCase(System.getenv(ENABLE_METRICS_DEBUG_PROPERTY.toLowerCase(Locale.ROOT).replace('.', '_')));
    }

    public static boolean isMetricsDebugEnabled() {
        return enabled;
    }

    public static void enableForTesting(boolean z) {
        enabled = z;
    }
}
