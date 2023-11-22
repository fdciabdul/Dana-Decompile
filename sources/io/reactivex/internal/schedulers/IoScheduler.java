package io.reactivex.internal.schedulers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class IoScheduler extends Scheduler {
    static final RxThreadFactory BuiltInFictitiousFunctionClassFactory;
    static final ThreadWorker KClassImpl$Data$declaredNonStaticMembers$2;
    static final RxThreadFactory PlaceComponentResult;
    static final CachedWorkerPool getAuthRequestContext;
    final AtomicReference<CachedWorkerPool> MyBillsEntityDataFactory;
    final ThreadFactory getErrorConfigVersion;
    private static final TimeUnit scheduleImpl = TimeUnit.SECONDS;
    private static final long moveToNextValue = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        KClassImpl$Data$declaredNonStaticMembers$2 = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        PlaceComponentResult = rxThreadFactory;
        BuiltInFictitiousFunctionClassFactory = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        getAuthRequestContext = cachedWorkerPool;
        cachedWorkerPool.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes6.dex */
    static final class CachedWorkerPool implements Runnable {
        final ThreadFactory BuiltInFictitiousFunctionClassFactory;
        final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;
        final ConcurrentLinkedQueue<ThreadWorker> MyBillsEntityDataFactory;
        private final ScheduledExecutorService PlaceComponentResult;
        final long getAuthRequestContext;
        private final Future<?> getErrorConfigVersion;

        CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.getAuthRequestContext = nanos;
            this.MyBillsEntityDataFactory = new ConcurrentLinkedQueue<>();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
            this.BuiltInFictitiousFunctionClassFactory = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.BuiltInFictitiousFunctionClassFactory);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.PlaceComponentResult = scheduledExecutorService;
            this.getErrorConfigVersion = scheduledFuture;
        }

        static long MyBillsEntityDataFactory() {
            return System.nanoTime();
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            Future<?> future = this.getErrorConfigVersion;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.PlaceComponentResult;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.MyBillsEntityDataFactory.isEmpty()) {
                return;
            }
            long nanoTime = System.nanoTime();
            Iterator<ThreadWorker> it = this.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                ThreadWorker next = it.next();
                if (next.BuiltInFictitiousFunctionClassFactory > nanoTime) {
                    return;
                }
                if (this.MyBillsEntityDataFactory.remove(next)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(next);
                }
            }
        }
    }

    public IoScheduler() {
        this(PlaceComponentResult);
    }

    private IoScheduler(ThreadFactory threadFactory) {
        this.getErrorConfigVersion = threadFactory;
        this.MyBillsEntityDataFactory = new AtomicReference<>(getAuthRequestContext);
        start();
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(moveToNextValue, scheduleImpl, this.getErrorConfigVersion);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, getAuthRequestContext, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.MyBillsEntityDataFactory.get();
            cachedWorkerPool2 = getAuthRequestContext;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.MyBillsEntityDataFactory.get());
    }

    /* loaded from: classes6.dex */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final ThreadWorker MyBillsEntityDataFactory;
        private final CachedWorkerPool getAuthRequestContext;
        final AtomicBoolean PlaceComponentResult = new AtomicBoolean();
        private final CompositeDisposable BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            ThreadWorker threadWorker;
            ThreadWorker threadWorker2;
            this.getAuthRequestContext = cachedWorkerPool;
            if (cachedWorkerPool.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed()) {
                threadWorker2 = IoScheduler.KClassImpl$Data$declaredNonStaticMembers$2;
                this.MyBillsEntityDataFactory = threadWorker2;
            }
            while (true) {
                if (!cachedWorkerPool.MyBillsEntityDataFactory.isEmpty()) {
                    threadWorker = cachedWorkerPool.MyBillsEntityDataFactory.poll();
                    if (threadWorker != null) {
                        break;
                    }
                } else {
                    threadWorker = new ThreadWorker(cachedWorkerPool.BuiltInFictitiousFunctionClassFactory);
                    cachedWorkerPool.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(threadWorker);
                    break;
                }
            }
            threadWorker2 = threadWorker;
            this.MyBillsEntityDataFactory = threadWorker2;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult.compareAndSet(false, true)) {
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                CachedWorkerPool cachedWorkerPool = this.getAuthRequestContext;
                ThreadWorker threadWorker = this.MyBillsEntityDataFactory;
                threadWorker.BuiltInFictitiousFunctionClassFactory = CachedWorkerPool.MyBillsEntityDataFactory() + cachedWorkerPool.getAuthRequestContext;
                cachedWorkerPool.MyBillsEntityDataFactory.offer(threadWorker);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(runnable, j, timeUnit, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes6.dex */
    static final class ThreadWorker extends NewThreadWorker {
        long BuiltInFictitiousFunctionClassFactory;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.BuiltInFictitiousFunctionClassFactory = 0L;
        }
    }
}
