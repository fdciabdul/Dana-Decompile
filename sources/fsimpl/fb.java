package fsimpl;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class fb {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference f7982a = new AtomicReference();

    private static Handler a() {
        Handler handler = (Handler) f7982a.get();
        if (handler != null) {
            return handler;
        }
        AtomicReference atomicReference = f7982a;
        Handler handler2 = new Handler(Looper.getMainLooper());
        atomicReference.set(handler2);
        return handler2;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }

    public static void a(Runnable runnable, long j) {
        a().postDelayed(runnable, j);
    }

    public static void b(Runnable runnable) {
        C0350eu.b("'postSync' MUST NOT be run on the UI thread.", new Object[0]);
        eM eMVar = new eM(runnable);
        a(eMVar);
        eMVar.a();
    }

    public static void c(Runnable runnable) {
        a().postAtFrontOfQueue(runnable);
    }
}
