package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> PlaceComponentResult;

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.PlaceComponentResult = observableSource;
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.PlaceComponentResult.subscribe(new LastObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        T KClassImpl$Data$declaredNonStaticMembers$2;
        final MaybeObserver<? super T> PlaceComponentResult;
        Disposable getAuthRequestContext;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.PlaceComponentResult = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (t != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.PlaceComponentResult.onSuccess(t);
                return;
            }
            this.PlaceComponentResult.onComplete();
        }
    }
}
