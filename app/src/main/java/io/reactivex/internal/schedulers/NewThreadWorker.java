package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    public final ScheduledExecutorService KClassImpl$Data$declaredNonStaticMembers$2;
    public volatile boolean PlaceComponentResult;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = SchedulerPoolFactory.KClassImpl$Data$declaredNonStaticMembers$2(threadFactory);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.PlaceComponentResult) {
            return EmptyDisposable.INSTANCE;
        }
        return BuiltInFictitiousFunctionClassFactory(runnable, j, timeUnit, null);
    }

    public final Disposable BuiltInFictitiousFunctionClassFactory(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable));
        try {
            if (j <= 0) {
                schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.submit(scheduledDirectTask);
            } else {
                schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.PlaceComponentResult(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public final Disposable getAuthRequestContext(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
        if (j2 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2);
            try {
                if (j <= 0) {
                    schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.submit(instantPeriodicTask);
                } else {
                    schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.schedule(instantPeriodicTask, j, timeUnit);
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
            scheduledDirectPeriodicTask.setFuture(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.PlaceComponentResult(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public final ScheduledRunnable BuiltInFictitiousFunctionClassFactory(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable), disposableContainer);
        if (disposableContainer == null || disposableContainer.getAuthRequestContext(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.KClassImpl$Data$declaredNonStaticMembers$2.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.PlaceComponentResult(scheduledRunnable);
                }
                RxJavaPlugins.PlaceComponentResult(e);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.shutdownNow();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.PlaceComponentResult;
    }
}
