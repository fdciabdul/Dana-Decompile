package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean PlaceComponentResult;

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        this.PlaceComponentResult = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        observer.onSubscribe(onErrorNextObserver.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext.subscribe(onErrorNextObserver);
    }

    /* loaded from: classes6.dex */
    static final class OnErrorNextObserver<T> implements Observer<T> {
        final SequentialDisposable BuiltInFictitiousFunctionClassFactory = new SequentialDisposable();
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final boolean PlaceComponentResult;
        final Observer<? super T> getAuthRequestContext;
        boolean scheduleImpl;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.getAuthRequestContext = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
            this.PlaceComponentResult = z;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.replace(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.getAuthRequestContext.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.scheduleImpl) {
                if (this.MyBillsEntityDataFactory) {
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                } else {
                    this.getAuthRequestContext.onError(th);
                    return;
                }
            }
            this.scheduleImpl = true;
            if (this.PlaceComponentResult && !(th instanceof Exception)) {
                this.getAuthRequestContext.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.KClassImpl$Data$declaredNonStaticMembers$2.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.getAuthRequestContext.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.getAuthRequestContext.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.scheduleImpl = true;
            this.getAuthRequestContext.onComplete();
        }
    }
}
