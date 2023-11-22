package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeTimer extends Maybe<Long> {
    final TimeUnit BuiltInFictitiousFunctionClassFactory;
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final long PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleDirect(timerDisposable, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final MaybeObserver<? super Long> downstream;

        TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.downstream = maybeObserver;
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
