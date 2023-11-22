package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {
    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        this.getAuthRequestContext.subscribe(new CountObserver(observer));
    }

    /* loaded from: classes9.dex */
    static final class CountObserver implements Observer<Object>, Disposable {
        final Observer<? super Long> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable PlaceComponentResult;
        long getAuthRequestContext;

        CountObserver(Observer<? super Long> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            this.getAuthRequestContext++;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Long.valueOf(this.getAuthRequestContext));
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
