package io.reactivex.internal.schedulers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class SingleScheduler extends Scheduler {
    static final RxThreadFactory PlaceComponentResult;
    static final ScheduledExecutorService getAuthRequestContext;
    final AtomicReference<ScheduledExecutorService> BuiltInFictitiousFunctionClassFactory;
    final ThreadFactory MyBillsEntityDataFactory;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        getAuthRequestContext = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        PlaceComponentResult = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(PlaceComponentResult);
    }

    private SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.BuiltInFictitiousFunctionClassFactory = atomicReference;
        this.MyBillsEntityDataFactory = threadFactory;
        atomicReference.lazySet(SchedulerPoolFactory.KClassImpl$Data$declaredNonStaticMembers$2(threadFactory));
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.BuiltInFictitiousFunctionClassFactory.get();
            if (scheduledExecutorService != getAuthRequestContext) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = SchedulerPoolFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.BuiltInFictitiousFunctionClassFactory.get();
        ScheduledExecutorService scheduledExecutorService2 = getAuthRequestContext;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.BuiltInFictitiousFunctionClassFactory.getAndSet(scheduledExecutorService2)) == scheduledExecutorService2) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.BuiltInFictitiousFunctionClassFactory.get());
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable));
        try {
            if (j <= 0) {
                schedule = this.BuiltInFictitiousFunctionClassFactory.get().submit(scheduledDirectTask);
            } else {
                schedule = this.BuiltInFictitiousFunctionClassFactory.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.PlaceComponentResult(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.BuiltInFictitiousFunctionClassFactory.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(KClassImpl$Data$declaredNonStaticMembers$2, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(instantPeriodicTask);
                } else {
                    schedule = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
                }
                instantPeriodicTask.getAuthRequestContext(schedule);
                return instantPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.PlaceComponentResult(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(KClassImpl$Data$declaredNonStaticMembers$2);
        try {
            scheduledDirectPeriodicTask.setFuture(this.BuiltInFictitiousFunctionClassFactory.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.PlaceComponentResult(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    static final class ScheduledWorker extends Scheduler.Worker {
        final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
        final ScheduledExecutorService MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.MyBillsEntityDataFactory = scheduledExecutorService;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.PlaceComponentResult) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable), this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.MyBillsEntityDataFactory.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.MyBillsEntityDataFactory.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                dispose();
                RxJavaPlugins.PlaceComponentResult(e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }
    }
}
