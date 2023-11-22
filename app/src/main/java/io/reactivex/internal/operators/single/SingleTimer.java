package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class SingleTimer extends Single<Long> {
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final TimeUnit MyBillsEntityDataFactory;
    final long PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleDirect(timerDisposable, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final SingleObserver<? super Long> downstream;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.downstream.onSuccess(0L);
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
