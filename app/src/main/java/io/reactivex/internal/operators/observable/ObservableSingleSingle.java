package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class ObservableSingleSingle<T> extends Single<T> {
    final ObservableSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final T getAuthRequestContext;

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.getAuthRequestContext = t;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new SingleElementObserver(singleObserver, this.getAuthRequestContext));
    }

    /* loaded from: classes6.dex */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final T BuiltInFictitiousFunctionClassFactory;
        T KClassImpl$Data$declaredNonStaticMembers$2;
        final SingleObserver<? super T> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        boolean getAuthRequestContext;

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t) {
            this.MyBillsEntityDataFactory = singleObserver;
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
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
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.getAuthRequestContext = true;
                this.PlaceComponentResult.dispose();
                this.MyBillsEntityDataFactory.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            if (t == null) {
                t = this.BuiltInFictitiousFunctionClassFactory;
            }
            if (t != null) {
                this.MyBillsEntityDataFactory.onSuccess(t);
            } else {
                this.MyBillsEntityDataFactory.onError(new NoSuchElementException());
            }
        }
    }
}
