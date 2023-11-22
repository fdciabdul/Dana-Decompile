package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(takeUntilMainObserver.otherObserver);
        this.getAuthRequestContext.subscribe(takeUntilMainObserver);
    }

    /* loaded from: classes9.dex */
    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        final AtomicThrowable error = new AtomicThrowable();

        TakeUntilMainObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
        }

        final void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        final void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
        }

        /* loaded from: classes9.dex */
        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            OtherObserver() {
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.Observer
            public final void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                TakeUntilMainObserver.this.otherError(th);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                TakeUntilMainObserver.this.otherComplete();
            }
        }
    }
}
