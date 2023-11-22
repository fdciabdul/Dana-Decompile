package io.split.android.client.service.synchronizer;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class ThreadUtils {
    public static boolean isCurrentThreadMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runInMainThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
