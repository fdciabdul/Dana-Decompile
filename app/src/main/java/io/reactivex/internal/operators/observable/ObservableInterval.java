package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableInterval extends Observable<Long> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final long MyBillsEntityDataFactory;
    final TimeUnit PlaceComponentResult;
    final long getAuthRequestContext;

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.getAuthRequestContext = j;
        this.MyBillsEntityDataFactory = j2;
        this.PlaceComponentResult = timeUnit;
        this.BuiltInFictitiousFunctionClassFactory = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.BuiltInFictitiousFunctionClassFactory;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalObserver, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
            return;
        }
        intervalObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalObserver, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes6.dex */
    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final Observer<? super Long> downstream;

        IntervalObserver(Observer<? super Long> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                observer.onNext(Long.valueOf(j));
            }
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
