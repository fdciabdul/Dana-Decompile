package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Callable<? extends ObservableSource<? extends R>> BuiltInFictitiousFunctionClassFactory;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super T, ? extends ObservableSource<? extends R>> PlaceComponentResult;

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.PlaceComponentResult = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
        this.BuiltInFictitiousFunctionClassFactory = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.getAuthRequestContext.subscribe(new MapNotificationObserver(observer, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Callable<? extends ObservableSource<? extends R>> BuiltInFictitiousFunctionClassFactory;
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super ObservableSource<? extends R>> MyBillsEntityDataFactory;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> PlaceComponentResult;
        final Function<? super T, ? extends ObservableSource<? extends R>> getAuthRequestContext;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.MyBillsEntityDataFactory = observer;
            this.getAuthRequestContext = function;
            this.PlaceComponentResult = function2;
            this.BuiltInFictitiousFunctionClassFactory = callable;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            try {
                this.MyBillsEntityDataFactory.onNext((ObservableSource) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            try {
                this.MyBillsEntityDataFactory.onNext((ObservableSource) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(th), "The onError ObservableSource returned is null"));
                this.MyBillsEntityDataFactory.onComplete();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.MyBillsEntityDataFactory.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            try {
                this.MyBillsEntityDataFactory.onNext((ObservableSource) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The onComplete ObservableSource returned is null"));
                this.MyBillsEntityDataFactory.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.onError(th);
            }
        }
    }
}
