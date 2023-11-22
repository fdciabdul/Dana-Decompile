package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<R> PlaceComponentResult;

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        this.PlaceComponentResult = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        try {
            this.getAuthRequestContext.subscribe(new ScanSeedObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final BiFunction<R, ? super T, R> KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super R> MyBillsEntityDataFactory;
        R PlaceComponentResult;
        boolean getAuthRequestContext;

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r) {
            this.MyBillsEntityDataFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
            this.PlaceComponentResult = r;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
                this.MyBillsEntityDataFactory.onNext((R) this.PlaceComponentResult);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            try {
                R r = (R) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(this.PlaceComponentResult, t), "The accumulator returned a null value");
                this.PlaceComponentResult = r;
                this.MyBillsEntityDataFactory.onNext(r);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                onError(th);
            }
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
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
