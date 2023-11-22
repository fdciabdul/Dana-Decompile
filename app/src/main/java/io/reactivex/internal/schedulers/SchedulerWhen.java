package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.SerializedProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable KClassImpl$Data$declaredNonStaticMembers$2 = new SubscribedDisposable();
    static final Disposable PlaceComponentResult = Disposables.BuiltInFictitiousFunctionClassFactory();
    private Disposable BuiltInFictitiousFunctionClassFactory;
    private final Scheduler MyBillsEntityDataFactory;
    private final FlowableProcessor<Flowable<Completable>> getAuthRequestContext;

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.MyBillsEntityDataFactory = scheduler;
        SerializedProcessor serializedProcessor = new SerializedProcessor(UnicastProcessor.PlaceComponentResult());
        this.getAuthRequestContext = serializedProcessor;
        try {
            this.BuiltInFictitiousFunctionClassFactory = function.apply(serializedProcessor).q_();
        } catch (Throwable th) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.MyBillsEntityDataFactory.createWorker();
        SerializedProcessor serializedProcessor = new SerializedProcessor(UnicastProcessor.PlaceComponentResult());
        CreateWorkerFunction createWorkerFunction = new CreateWorkerFunction(createWorker);
        ObjectHelper.PlaceComponentResult(createWorkerFunction, "mapper is null");
        Flowable<Completable> authRequestContext = RxJavaPlugins.getAuthRequestContext(new FlowableMap(serializedProcessor, createWorkerFunction));
        QueueWorker queueWorker = new QueueWorker(serializedProcessor, createWorker);
        this.getAuthRequestContext.onNext(authRequestContext);
        return queueWorker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        protected abstract Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver);

        ScheduledAction() {
            super(SchedulerWhen.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        void call(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable = get();
            if (disposable != SchedulerWhen.PlaceComponentResult && disposable == SchedulerWhen.KClassImpl$Data$declaredNonStaticMembers$2) {
                Disposable callActual = callActual(worker, completableObserver);
                if (compareAndSet(SchedulerWhen.KClassImpl$Data$declaredNonStaticMembers$2, callActual)) {
                    return;
                }
                callActual.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.PlaceComponentResult;
            do {
                disposable = get();
                if (disposable == SchedulerWhen.PlaceComponentResult) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.KClassImpl$Data$declaredNonStaticMembers$2) {
                disposable.dispose();
            }
        }
    }

    /* loaded from: classes9.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver));
        }
    }

    /* loaded from: classes9.dex */
    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    static class OnCompletedAction implements Runnable {
        final CompletableObserver BuiltInFictitiousFunctionClassFactory;
        final Runnable PlaceComponentResult;

        OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.PlaceComponentResult = runnable;
            this.BuiltInFictitiousFunctionClassFactory = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.PlaceComponentResult.run();
            } finally {
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Completable apply(ScheduledAction scheduledAction) throws Exception {
            return new WorkerCompletable(scheduledAction);
        }

        CreateWorkerFunction(Scheduler.Worker worker) {
            this.MyBillsEntityDataFactory = worker;
        }

        /* loaded from: classes9.dex */
        final class WorkerCompletable extends Completable {
            final ScheduledAction BuiltInFictitiousFunctionClassFactory;

            WorkerCompletable(ScheduledAction scheduledAction) {
                CreateWorkerFunction.this = r1;
                this.BuiltInFictitiousFunctionClassFactory = scheduledAction;
            }

            @Override // io.reactivex.Completable
            public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory.call(CreateWorkerFunction.this.MyBillsEntityDataFactory, completableObserver);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Scheduler.Worker MyBillsEntityDataFactory;
        private final AtomicBoolean getAuthRequestContext = new AtomicBoolean();

        QueueWorker(FlowableProcessor<ScheduledAction> flowableProcessor, Scheduler.Worker worker) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = flowableProcessor;
            this.MyBillsEntityDataFactory = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.getAuthRequestContext.compareAndSet(false, true)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
                this.MyBillsEntityDataFactory.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes9.dex */
    static final class SubscribedDisposable implements Disposable {
        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return false;
        }

        SubscribedDisposable() {
        }
    }
}
