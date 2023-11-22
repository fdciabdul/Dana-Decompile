package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> PlaceComponentResult;

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.PlaceComponentResult = biFunction;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new ScanObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class ScanObserver<T> implements Observer<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        final BiFunction<T, T, T> KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super T> MyBillsEntityDataFactory;
        T PlaceComponentResult;
        Disposable getAuthRequestContext;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.MyBillsEntityDataFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            Observer<? super T> observer = this.MyBillsEntityDataFactory;
            T t2 = this.PlaceComponentResult;
            if (t2 == null) {
                this.PlaceComponentResult = t;
                observer.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(t2, t), "The value returned by the accumulator is null");
                this.PlaceComponentResult = r4;
                observer.onNext(r4);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
