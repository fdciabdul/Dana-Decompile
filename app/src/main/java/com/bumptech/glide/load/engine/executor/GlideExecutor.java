package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class GlideExecutor implements ExecutorService {
    private static volatile int KClassImpl$Data$declaredNonStaticMembers$2;
    private static final long PlaceComponentResult = TimeUnit.SECONDS.toMillis(10);
    private final ExecutorService getAuthRequestContext;

    public static GlideExecutor MyBillsEntityDataFactory() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, PlaceComponentResult, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.PlaceComponentResult, false)));
    }

    GlideExecutor(ExecutorService executorService) {
        this.getAuthRequestContext = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.getAuthRequestContext.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.getAuthRequestContext.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.getAuthRequestContext.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.getAuthRequestContext.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.getAuthRequestContext.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.getAuthRequestContext.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.getAuthRequestContext.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.getAuthRequestContext.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.getAuthRequestContext.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.getAuthRequestContext.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.getAuthRequestContext.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.getAuthRequestContext.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.getAuthRequestContext.awaitTermination(j, timeUnit);
    }

    public final String toString() {
        return this.getAuthRequestContext.toString();
    }

    /* loaded from: classes3.dex */
    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy BuiltInFictitiousFunctionClassFactory;
        public static final UncaughtThrowableStrategy KClassImpl$Data$declaredNonStaticMembers$2 = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public final void PlaceComponentResult(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy PlaceComponentResult;
        public static final UncaughtThrowableStrategy getAuthRequestContext;

        void PlaceComponentResult(Throwable th);

        static {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public final void PlaceComponentResult(Throwable th) {
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        InstrumentInjector.log_e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            getAuthRequestContext = uncaughtThrowableStrategy;
            BuiltInFictitiousFunctionClassFactory = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public final void PlaceComponentResult(Throwable th) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            };
            PlaceComponentResult = uncaughtThrowableStrategy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class DefaultThreadFactory implements ThreadFactory {
        private final String BuiltInFictitiousFunctionClassFactory;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final UncaughtThrowableStrategy MyBillsEntityDataFactory;
        private int getAuthRequestContext;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = uncaughtThrowableStrategy;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread;
            synchronized (this) {
                StringBuilder sb = new StringBuilder();
                sb.append("glide-");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("-thread-");
                sb.append(this.getAuthRequestContext);
                thread = new Thread(runnable, sb.toString()) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(9);
                        if (DefaultThreadFactory.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                        }
                        try {
                            super.run();
                        } catch (Throwable th) {
                            DefaultThreadFactory.this.MyBillsEntityDataFactory.PlaceComponentResult(th);
                        }
                    }
                };
                this.getAuthRequestContext++;
            }
            return thread;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        int BuiltInFictitiousFunctionClassFactory;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private long MyBillsEntityDataFactory;
        String PlaceComponentResult;
        int getAuthRequestContext;
        private UncaughtThrowableStrategy lookAheadTest = UncaughtThrowableStrategy.PlaceComponentResult;

        Builder(boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        public final GlideExecutor getAuthRequestContext() {
            if (TextUtils.isEmpty(this.PlaceComponentResult)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name must be non-null and non-empty, but given: ");
                sb.append(this.PlaceComponentResult);
                throw new IllegalArgumentException(sb.toString());
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.PlaceComponentResult, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2));
            if (this.MyBillsEntityDataFactory != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new GlideExecutor(threadPoolExecutor);
        }
    }

    public static GlideExecutor getAuthRequestContext() {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(4, RuntimeCompat.BuiltInFictitiousFunctionClassFactory());
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 >= 4 ? 2 : 1;
        Builder builder = new Builder(true);
        builder.getAuthRequestContext = i;
        builder.BuiltInFictitiousFunctionClassFactory = i;
        builder.PlaceComponentResult = DynamicLayerModel.FOR_ANIMATION;
        return builder.getAuthRequestContext();
    }

    public static GlideExecutor PlaceComponentResult() {
        Builder builder = new Builder(true);
        builder.getAuthRequestContext = 1;
        builder.BuiltInFictitiousFunctionClassFactory = 1;
        builder.PlaceComponentResult = "disk-cache";
        return builder.getAuthRequestContext();
    }

    public static GlideExecutor BuiltInFictitiousFunctionClassFactory() {
        Builder builder = new Builder(false);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(4, RuntimeCompat.BuiltInFictitiousFunctionClassFactory());
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2;
        builder.getAuthRequestContext = i;
        builder.BuiltInFictitiousFunctionClassFactory = i;
        builder.PlaceComponentResult = "source";
        return builder.getAuthRequestContext();
    }
}
