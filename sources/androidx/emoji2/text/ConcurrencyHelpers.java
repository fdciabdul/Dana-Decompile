package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
class ConcurrencyHelpers {
    private ConcurrencyHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor getAuthRequestContext(final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ConcurrencyHelpers.BuiltInFictitiousFunctionClassFactory(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread BuiltInFictitiousFunctionClassFactory(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler BuiltInFictitiousFunctionClassFactory() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.MyBillsEntityDataFactory(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }

    /* loaded from: classes6.dex */
    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler MyBillsEntityDataFactory(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
