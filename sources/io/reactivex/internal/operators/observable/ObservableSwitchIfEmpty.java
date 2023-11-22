package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> MyBillsEntityDataFactory;

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.MyBillsEntityDataFactory = observableSource2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.MyBillsEntityDataFactory);
        observer.onSubscribe(switchIfEmptyObserver.getAuthRequestContext);
        this.getAuthRequestContext.subscribe(switchIfEmptyObserver);
    }

    /* loaded from: classes6.dex */
    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final ObservableSource<? extends T> BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory = true;
        final SequentialDisposable getAuthRequestContext = new SequentialDisposable();

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.BuiltInFictitiousFunctionClassFactory = observableSource;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.update(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
                this.BuiltInFictitiousFunctionClassFactory.subscribe(this);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
