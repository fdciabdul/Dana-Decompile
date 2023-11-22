package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTimer extends Observable<Long> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final long MyBillsEntityDataFactory;
    final TimeUnit getAuthRequestContext;

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.MyBillsEntityDataFactory = j;
        this.getAuthRequestContext = timeUnit;
        this.BuiltInFictitiousFunctionClassFactory = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.BuiltInFictitiousFunctionClassFactory.scheduleDirect(timerObserver, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
    }

    /* loaded from: classes6.dex */
    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Observer<? super Long> downstream;

        TimerObserver(Observer<? super Long> observer) {
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
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }
}
