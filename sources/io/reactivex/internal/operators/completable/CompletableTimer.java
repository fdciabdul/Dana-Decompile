package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableTimer extends Completable {
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final TimeUnit MyBillsEntityDataFactory;
    final long PlaceComponentResult;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.PlaceComponentResult = j;
        this.MyBillsEntityDataFactory = timeUnit;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduler;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleDirect(timerDisposable, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        final void setFuture(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
