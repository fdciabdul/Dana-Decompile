package com.alipay.mobile.embedview.mapbiz.core;

import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes6.dex */
public class H5AnimationThread {

    /* renamed from: a  reason: collision with root package name */
    private static volatile H5AnimationThread f7138a;
    private final HandlerThread b;

    private H5AnimationThread() {
        HandlerThread handlerThread = new HandlerThread("H5EmbedMapView-Animation");
        this.b = handlerThread;
        handlerThread.start();
    }

    public static H5AnimationThread getInstance() {
        if (f7138a == null) {
            synchronized (H5AnimationThread.class) {
                if (f7138a == null) {
                    f7138a = new H5AnimationThread();
                }
            }
        }
        return f7138a;
    }

    public Looper getLooper() {
        return this.b.getLooper();
    }
}
