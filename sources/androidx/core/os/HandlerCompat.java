package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class HandlerCompat {
    public static Handler MyBillsEntityDataFactory(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.MyBillsEntityDataFactory(looper);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException e) {
                e = e;
                InstrumentInjector.log_w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (InstantiationException e2) {
                e = e2;
                InstrumentInjector.log_w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (NoSuchMethodException e3) {
                e = e3;
                InstrumentInjector.log_w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (InvocationTargetException e4) {
                Throwable cause = e4.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException(cause);
            }
        }
        return new Handler(looper);
    }

    private HandlerCompat() {
    }

    /* loaded from: classes6.dex */
    static class Api29Impl {
        private Api29Impl() {
        }
    }

    /* loaded from: classes3.dex */
    static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler MyBillsEntityDataFactory(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
