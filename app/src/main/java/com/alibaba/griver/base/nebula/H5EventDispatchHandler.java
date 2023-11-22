package com.alibaba.griver.base.nebula;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes6.dex */
public class H5EventDispatchHandler {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f6321a;

    public static Handler getAsyncHandler() {
        Handler handler;
        synchronized (H5EventDispatchHandler.class) {
            if (f6321a == null) {
                HandlerThread handlerThread = new HandlerThread("H5EvenDispatchHandler");
                handlerThread.start();
                f6321a = new Handler(handlerThread.getLooper());
            }
            handler = f6321a;
        }
        return handler;
    }
}
