package io.split.android.client.service.impressions;

/* loaded from: classes6.dex */
public class ImpressionUtils {
    private static final long TIME_INTERVAL_MS = 3600000;

    public static long truncateTimeframe(long j) {
        return j - (j % 3600000);
    }
}
