package com.alibaba.griver.lottie.utils;

import com.alibaba.griver.lottie.LottieLogger;

/* loaded from: classes6.dex */
public class Logger {
    private static LottieLogger INSTANCE = new LogcatLogger();

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void debug(String str) {
        INSTANCE.debug(str);
    }

    public static void debug(String str, Throwable th) {
        INSTANCE.debug(str, th);
    }

    public static void warning(String str) {
        INSTANCE.warning(str);
    }

    public static void warning(String str, Throwable th) {
        INSTANCE.warning(str, th);
    }
}
