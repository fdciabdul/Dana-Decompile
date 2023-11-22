package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new OnErrorReturnObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes6.dex */
    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        final Function<? super Throwable, ? extends T> BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable PlaceComponentResult;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.BuiltInFictitiousFunctionClassFactory = function;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
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
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            try {
                T apply = this.BuiltInFictitiousFunctionClassFactory.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onError(nullPointerException);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(apply);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
