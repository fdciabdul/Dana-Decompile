package com.alibaba.griver.beehive.lottie.util;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.griver.base.common.executor.GriverExecutors;

/* loaded from: classes3.dex */
public class MultiThreadUtils {
    public static void runOnBackgroundThread(Runnable runnable) {
        GriverExecutors.getScheduledExecutor().execute(runnable);
    }

    public static void runOnBackgroundThreadOrder(Runnable runnable, Object obj) {
        GriverExecutors.getSingleMonitorThreadExecutor().execute(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }
}
