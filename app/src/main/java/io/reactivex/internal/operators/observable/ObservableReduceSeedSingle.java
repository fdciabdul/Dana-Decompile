package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    final ObservableSource<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final R PlaceComponentResult;
    final BiFunction<R, ? super T, R> getAuthRequestContext;

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource;
        this.PlaceComponentResult = r;
        this.getAuthRequestContext = biFunction;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new ReduceSeedObserver(singleObserver, this.getAuthRequestContext, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        final BiFunction<R, ? super T, R> BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        final SingleObserver<? super R> PlaceComponentResult;
        R getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.PlaceComponentResult = singleObserver;
            this.getAuthRequestContext = r;
            this.BuiltInFictitiousFunctionClassFactory = biFunction;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            R r = this.getAuthRequestContext;
            if (r != null) {
                try {
                    this.getAuthRequestContext = (R) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.MyBillsEntityDataFactory.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext != null) {
                this.getAuthRequestContext = null;
                this.PlaceComponentResult.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            R r = this.getAuthRequestContext;
            if (r != null) {
                this.getAuthRequestContext = null;
                this.PlaceComponentResult.onSuccess(r);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }
    }
}
