package com.alipay.alipaysecuritysdk.common.e;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f6873a;
    private ExecutorService b;
    private ExecutorService c;

    private f() {
        this.b = null;
        this.c = null;
        this.b = Executors.newSingleThreadExecutor();
        this.c = Executors.newFixedThreadPool(20);
    }

    public static f a() {
        f fVar;
        synchronized (f.class) {
            if (f6873a == null) {
                f6873a = new f();
            }
            fVar = f6873a;
        }
        return fVar;
    }

    public final void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    public final void b(Runnable runnable) {
        this.c.execute(runnable);
    }
}
