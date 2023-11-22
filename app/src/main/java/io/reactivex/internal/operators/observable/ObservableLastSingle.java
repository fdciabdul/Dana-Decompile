package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class ObservableLastSingle<T> extends Single<T> {
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;
    final T getAuthRequestContext;

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.getAuthRequestContext = t;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new LastObserver(singleObserver, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        T BuiltInFictitiousFunctionClassFactory;
        final T MyBillsEntityDataFactory;
        final SingleObserver<? super T> PlaceComponentResult;
        Disposable getAuthRequestContext;

        LastObserver(SingleObserver<? super T> singleObserver, T t) {
            this.PlaceComponentResult = singleObserver;
            this.MyBillsEntityDataFactory = t;
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
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            T t = this.BuiltInFictitiousFunctionClassFactory;
            if (t != null) {
                this.BuiltInFictitiousFunctionClassFactory = null;
                this.PlaceComponentResult.onSuccess(t);
                return;
            }
            T t2 = this.MyBillsEntityDataFactory;
            if (t2 != null) {
                this.PlaceComponentResult.onSuccess(t2);
            } else {
                this.PlaceComponentResult.onError(new NoSuchElementException());
            }
        }
    }
}
