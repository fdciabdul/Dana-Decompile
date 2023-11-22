package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    final long PlaceComponentResult;

    public ObservableSkip(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.PlaceComponentResult = j;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new SkipObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        Disposable PlaceComponentResult;
        long getAuthRequestContext;

        SkipObserver(Observer<? super T> observer, long j) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.getAuthRequestContext = j;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            long j = this.getAuthRequestContext;
            if (j != 0) {
                this.getAuthRequestContext = j - 1;
            } else {
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }
    }
}
