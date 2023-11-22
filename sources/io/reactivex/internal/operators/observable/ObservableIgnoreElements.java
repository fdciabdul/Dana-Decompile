package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: classes2.dex */
public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new IgnoreObservable(observer));
    }

    /* loaded from: classes6.dex */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> PlaceComponentResult;

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
        }

        IgnoreObservable(Observer<? super T> observer) {
            this.PlaceComponentResult = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory = disposable;
            this.PlaceComponentResult.onSubscribe(this);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }
    }
}
