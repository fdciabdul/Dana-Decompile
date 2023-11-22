package io.split.android.client.service.impressions;

/* loaded from: classes6.dex */
public enum ImpressionsMode {
    OPTIMIZED,
    DEBUG,
    NONE;

    public static ImpressionsMode fromString(String str) {
        if (str != null) {
            str = str.toUpperCase();
        }
        if ("DEBUG".equals(str)) {
            return DEBUG;
        }
        if ("NONE".equals(str)) {
            return NONE;
        }
        return OPTIMIZED;
    }
}
