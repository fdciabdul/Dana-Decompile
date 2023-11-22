package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableReduceMaybe<T> extends Maybe<T> {
    final BiFunction<T, T, T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<T> PlaceComponentResult;

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.PlaceComponentResult = observableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.PlaceComponentResult.subscribe(new ReduceObserver(maybeObserver, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class ReduceObserver<T> implements Observer<T>, Disposable {
        T BuiltInFictitiousFunctionClassFactory;
        final BiFunction<T, T, T> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final MaybeObserver<? super T> getAuthRequestContext;

        ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.getAuthRequestContext = maybeObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            T t2 = this.BuiltInFictitiousFunctionClassFactory;
            if (t2 == null) {
                this.BuiltInFictitiousFunctionClassFactory = t;
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory = (T) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            T t = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = null;
            if (t != null) {
                this.getAuthRequestContext.onSuccess(t);
            } else {
                this.getAuthRequestContext.onComplete();
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
