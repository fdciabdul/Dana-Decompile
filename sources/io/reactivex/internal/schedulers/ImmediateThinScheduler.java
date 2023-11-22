package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class ImmediateThinScheduler extends Scheduler {
    static final Disposable BuiltInFictitiousFunctionClassFactory;
    public static final Scheduler getAuthRequestContext = new ImmediateThinScheduler();
    static final Scheduler.Worker KClassImpl$Data$declaredNonStaticMembers$2 = new ImmediateThinWorker();

    static {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory = authRequestContext;
        authRequestContext.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable) {
        runnable.run();
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes9.dex */
    static final class ImmediateThinWorker extends Scheduler.Worker {
        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return false;
        }

        ImmediateThinWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }
}
