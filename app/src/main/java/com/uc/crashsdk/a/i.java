package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    static volatile HandlerThread f7710a;
    static volatile HandlerThread b;
    static Handler c;
    static Handler d;
    private static HashMap<Object, a> e = new HashMap<>();

    public static boolean a(int i, Runnable runnable, long j) {
        Handler handler;
        StringBuilder sb = new StringBuilder("ThreadManager.post: ");
        sb.append(runnable);
        sb.append(", type: ");
        sb.append(i);
        sb.append(", delay: ");
        sb.append(j);
        sb.append("ms");
        c.a(sb.toString());
        if (runnable == null) {
            return false;
        }
        if (i == 0) {
            if (f7710a == null) {
                b();
            }
            handler = c;
        } else if (i == 1) {
            if (b == null) {
                c();
            }
            handler = d;
        } else {
            StringBuilder sb2 = new StringBuilder("unknown thread type: ");
            sb2.append(i);
            throw new RuntimeException(sb2.toString());
        }
        if (handler == null) {
            return false;
        }
        j jVar = new j(runnable);
        synchronized (e) {
            e.put(runnable, new a(jVar, i));
        }
        return handler.postDelayed(jVar, j);
    }

    public static boolean a(int i, Runnable runnable) {
        return a(i, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        a aVar;
        StringBuilder sb = new StringBuilder("ThreadManager.remove: ");
        sb.append(runnable);
        c.a(sb.toString());
        if (runnable == null) {
            return;
        }
        synchronized (e) {
            aVar = e.get(runnable);
        }
        if (aVar == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("found task in cache, item: ");
        sb2.append(aVar);
        sb2.append(", type: ");
        sb2.append(aVar.b);
        c.a(sb2.toString());
        Handler handler = null;
        int i = aVar.b;
        if (i == 0) {
            handler = c;
        } else if (i == 1) {
            handler = d;
        }
        if (handler != null) {
            handler.removeCallbacks(aVar.f7711a);
        }
        synchronized (e) {
            if (e.get(runnable) != null) {
                e.remove(runnable);
            }
        }
    }

    public static boolean b(Runnable runnable) {
        a aVar;
        if (runnable == null) {
            return false;
        }
        synchronized (e) {
            aVar = e.get(runnable);
        }
        return aVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f7711a;
        public int b;

        public a(Runnable runnable, int i) {
            this.f7711a = runnable;
            this.b = i;
        }
    }

    private static void b() {
        synchronized (i.class) {
            if (f7710a == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                f7710a = handlerThread;
                handlerThread.start();
                c = new Handler(f7710a.getLooper());
            }
        }
    }

    private static void c() {
        synchronized (i.class) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                b = handlerThread;
                handlerThread.start();
                d = new Handler(b.getLooper());
            }
        }
    }
}
