package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    final ObservableSource<T> getAuthRequestContext;

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.getAuthRequestContext = observableSource;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Long> singleObserver) {
        this.getAuthRequestContext.subscribe(new CountObserver(singleObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<Long> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCount(this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class CountObserver implements Observer<Object>, Disposable {
        long KClassImpl$Data$declaredNonStaticMembers$2;
        final SingleObserver<? super Long> PlaceComponentResult;
        Disposable getAuthRequestContext;

        CountObserver(SingleObserver<? super Long> singleObserver) {
            this.PlaceComponentResult = singleObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onSuccess(Long.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }
}
