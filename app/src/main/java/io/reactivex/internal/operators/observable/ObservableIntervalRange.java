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
public final class ObservableIntervalRange extends Observable<Long> {
    final long BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final Scheduler MyBillsEntityDataFactory;
    final long PlaceComponentResult;
    final long getAuthRequestContext;
    final TimeUnit getErrorConfigVersion;

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j3;
        this.getAuthRequestContext = j4;
        this.getErrorConfigVersion = timeUnit;
        this.MyBillsEntityDataFactory = scheduler;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.PlaceComponentResult = j2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.MyBillsEntityDataFactory;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeObserver, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.getErrorConfigVersion);
            return;
        }
        intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.getErrorConfigVersion));
    }

    /* loaded from: classes9.dex */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final Observer<? super Long> downstream;
        final long end;

        IntervalRangeObserver(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.count = j;
            this.end = j2;
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
            if (isDisposed()) {
                return;
            }
            long j = this.count;
            this.downstream.onNext(Long.valueOf(j));
            if (j == this.end) {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
                return;
            }
            this.count = j + 1;
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
