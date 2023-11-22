package com.alibaba.griver.lottie;

import androidx.core.os.TraceCompat;

/* loaded from: classes6.dex */
public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static int depthPastMaxDepth;
    private static String[] sections;
    private static long[] startTimeNs;
    private static int traceDepth;
    private static boolean traceEnabled;

    public static void setTraceEnabled(boolean z) {
        if (traceEnabled == z) {
            return;
        }
        traceEnabled = z;
        if (z) {
            sections = new String[20];
            startTimeNs = new long[20];
        }
    }

    public static void beginSection(String str) {
        if (traceEnabled) {
            int i = traceDepth;
            if (i == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i] = str;
            startTimeNs[i] = System.nanoTime();
            TraceCompat.BuiltInFictitiousFunctionClassFactory(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        int i = depthPastMaxDepth;
        if (i > 0) {
            depthPastMaxDepth = i - 1;
            return 0.0f;
        } else if (traceEnabled) {
            int i2 = traceDepth - 1;
            traceDepth = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(sections[i2])) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unbalanced trace call ");
                sb.append(str);
                sb.append(". Expected ");
                sb.append(sections[traceDepth]);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            TraceCompat.BuiltInFictitiousFunctionClassFactory();
            return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
