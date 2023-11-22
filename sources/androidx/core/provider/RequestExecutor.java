package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RequestExecutor {
    private RequestExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void PlaceComponentResult(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.BuiltInFictitiousFunctionClassFactory(), callable, consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T KClassImpl$Data$declaredNonStaticMembers$2(ExecutorService executorService, Callable<T> callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor BuiltInFictitiousFunctionClassFactory(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* loaded from: classes.dex */
    static class HandlerExecutor implements Executor {
        private final Handler KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.post((Runnable) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(runnable))) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(" is shutting down");
            throw new RejectedExecutionException(sb.toString());
        }
    }

    /* loaded from: classes.dex */
    static class ReplyRunnable<T> implements Runnable {
        private Handler KClassImpl$Data$declaredNonStaticMembers$2;
        private Consumer<T> MyBillsEntityDataFactory;
        private Callable<T> PlaceComponentResult;

        ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.PlaceComponentResult = callable;
            this.MyBillsEntityDataFactory = consumer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t;
            try {
                t = this.PlaceComponentResult.call();
            } catch (Exception unused) {
                t = null;
            }
            final Consumer<T> consumer = this.MyBillsEntityDataFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    static class DefaultThreadFactory implements ThreadFactory {
        private String PlaceComponentResult;
        private int getAuthRequestContext = 10;

        DefaultThreadFactory(String str) {
            this.PlaceComponentResult = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.PlaceComponentResult, this.getAuthRequestContext);
        }

        /* loaded from: classes.dex */
        static class ProcessPriorityThread extends Thread {
            private final int getAuthRequestContext;

            ProcessPriorityThread(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.getAuthRequestContext = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.getAuthRequestContext);
                super.run();
            }
        }
    }
}
