package com.fullstory.instrumentation;

import android.app.Application;
import android.content.Context;
import com.fullstory.instrumentation.init.Initialization;
import com.fullstory.util.Log;
import fsimpl.C0230ah;
import fsimpl.C0372v;
import fsimpl.K;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Bootstrap {

    /* renamed from: a */
    private static final C0372v f7424a = new C0372v();
    private static final Object b = new Object();

    public static void a(Application application, Context context) {
        boolean z;
        synchronized (b) {
            z = f7424a.f8003a;
            if (z) {
                f7424a.f8003a = false;
                try {
                    b(application, context);
                } catch (Throwable th) {
                    Log.e("Failed to initialize", th);
                    fail();
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        boolean z;
        K k;
        List list;
        List list2;
        synchronized (b) {
            z = f7424a.b;
            if (z) {
                return;
            }
            k = f7424a.d;
            if (k == null) {
                list = f7424a.e;
                if (list != null) {
                    list2 = f7424a.e;
                    list2.add(runnable);
                    return;
                }
            }
            runnable.run();
        }
    }

    public static void a(boolean z, Runnable runnable) {
        boolean z2;
        K k;
        List list;
        synchronized (b) {
            z2 = f7424a.b;
            if (z2) {
                return;
            }
            k = f7424a.d;
            if (k == null) {
                list = f7424a.e;
                if (list != null) {
                    f7424a.c = z;
                    return;
                }
            }
            runnable.run();
        }
    }

    private static void b(Application application, Context context) {
        synchronized (b) {
            new Initialization().init(application, context);
        }
    }

    public static void fail() {
        synchronized (b) {
            f7424a.f8003a = false;
            f7424a.b = true;
            f7424a.d = null;
            f7424a.e = null;
        }
    }

    public static C0230ah getCurrentSessionKnobs() {
        K impl = impl();
        if (impl == null) {
            return null;
        }
        return impl.getCurrentSessionKnobs();
    }

    public static K impl() {
        K k;
        synchronized (b) {
            k = f7424a.d;
        }
        return k;
    }

    public static void success(K k) {
        boolean z;
        List list;
        boolean z2;
        synchronized (b) {
            z = f7424a.b;
            if (z) {
                return;
            }
            f7424a.d = k;
            list = f7424a.e;
            f7424a.e = null;
            z2 = f7424a.c;
            if (!z2) {
                k.shutdown();
            }
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((Runnable) it.next()).run();
                    } catch (Throwable unused) {
                        Log.e("Failed to run deferred runnable");
                    }
                }
            }
            k.finishStartup();
        }
    }
}
