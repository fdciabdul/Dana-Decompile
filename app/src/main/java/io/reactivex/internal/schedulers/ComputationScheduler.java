package io.reactivex.internal.schedulers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    static final PoolWorker KClassImpl$Data$declaredNonStaticMembers$2;
    static final int MyBillsEntityDataFactory;
    static final FixedSchedulerPool PlaceComponentResult;
    static final RxThreadFactory getAuthRequestContext;
    final AtomicReference<FixedSchedulerPool> BuiltInFictitiousFunctionClassFactory;
    final ThreadFactory NetworkUserEntityData$$ExternalSyntheticLambda0;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        MyBillsEntityDataFactory = availableProcessors;
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        KClassImpl$Data$declaredNonStaticMembers$2 = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        getAuthRequestContext = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        PlaceComponentResult = fixedSchedulerPool;
        for (PoolWorker poolWorker2 : fixedSchedulerPool.getAuthRequestContext) {
            poolWorker2.dispose();
        }
    }

    /* loaded from: classes6.dex */
    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        long BuiltInFictitiousFunctionClassFactory;
        final int MyBillsEntityDataFactory;
        final PoolWorker[] getAuthRequestContext;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.MyBillsEntityDataFactory = i;
            this.getAuthRequestContext = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.getAuthRequestContext[i2] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker BuiltInFictitiousFunctionClassFactory() {
            int i = this.MyBillsEntityDataFactory;
            if (i == 0) {
                return ComputationScheduler.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            PoolWorker[] poolWorkerArr = this.getAuthRequestContext;
            long j = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = 1 + j;
            return poolWorkerArr[(int) (j % i)];
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public final void PlaceComponentResult(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.MyBillsEntityDataFactory;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.KClassImpl$Data$declaredNonStaticMembers$2(i3, ComputationScheduler.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                return;
            }
            int i4 = ((int) this.BuiltInFictitiousFunctionClassFactory) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.KClassImpl$Data$declaredNonStaticMembers$2(i5, new EventLoopWorker(this.getAuthRequestContext[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = i4;
        }
    }

    public ComputationScheduler() {
        this(getAuthRequestContext);
    }

    private ComputationScheduler(ThreadFactory threadFactory) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = threadFactory;
        this.BuiltInFictitiousFunctionClassFactory = new AtomicReference<>(PlaceComponentResult);
        start();
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory());
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public final void PlaceComponentResult(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "number > 0 required");
        this.BuiltInFictitiousFunctionClassFactory.get().PlaceComponentResult(i, workerCallback);
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(runnable, j, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult, fixedSchedulerPool)) {
            return;
        }
        for (PoolWorker poolWorker : fixedSchedulerPool.getAuthRequestContext) {
            poolWorker.dispose();
        }
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.BuiltInFictitiousFunctionClassFactory.get();
            fixedSchedulerPool2 = PlaceComponentResult;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, fixedSchedulerPool, fixedSchedulerPool2));
        for (PoolWorker poolWorker : fixedSchedulerPool.getAuthRequestContext) {
            poolWorker.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class EventLoopWorker extends Scheduler.Worker {
        private final ListCompositeDisposable BuiltInFictitiousFunctionClassFactory;
        private final PoolWorker KClassImpl$Data$declaredNonStaticMembers$2;
        volatile boolean MyBillsEntityDataFactory;
        private final ListCompositeDisposable PlaceComponentResult;
        private final CompositeDisposable getAuthRequestContext;

        EventLoopWorker(PoolWorker poolWorker) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.BuiltInFictitiousFunctionClassFactory = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.getAuthRequestContext = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.PlaceComponentResult = listCompositeDisposable2;
            listCompositeDisposable2.getAuthRequestContext(listCompositeDisposable);
            listCompositeDisposable2.getAuthRequestContext(compositeDisposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            if (this.MyBillsEntityDataFactory) {
                return EmptyDisposable.INSTANCE;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(runnable, 0L, TimeUnit.MILLISECONDS, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.MyBillsEntityDataFactory) {
                return EmptyDisposable.INSTANCE;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(runnable, j, timeUnit, this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
