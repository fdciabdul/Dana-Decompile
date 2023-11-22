package com.alipay.iap.android.aplog.util;

/* loaded from: classes3.dex */
public class TraceIdUtil {
    private static final String PREFIX = "20000000";
    private static int SEQUENCE = 1;
    public static String UNDERLINE = "_";
    private static String currentTraceID = "";

    public static String getNewTraceId() {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        sb.append(getTimeStamp());
        sb.append(getSequence());
        String obj = sb.toString();
        currentTraceID = obj;
        return obj;
    }

    public static String getCurrentTraceID() {
        return currentTraceID;
    }

    private static String getSequence() {
        if (SEQUENCE == 10000) {
            SEQUENCE = 1;
        }
        int i = SEQUENCE;
        SEQUENCE = i + 1;
        return String.format("%04d", Integer.valueOf(i));
    }

    private static long getTimeStamp() {
        return System.currentTimeMillis();
    }
}
