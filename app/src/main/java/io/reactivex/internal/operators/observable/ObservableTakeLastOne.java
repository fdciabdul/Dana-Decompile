package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new TakeLastOneObserver(observer));
    }

    /* loaded from: classes9.dex */
    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
        T BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;

        TakeLastOneObserver(Observer<? super T> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.MyBillsEntityDataFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            T t = this.BuiltInFictitiousFunctionClassFactory;
            if (t != null) {
                this.BuiltInFictitiousFunctionClassFactory = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
