package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

/* loaded from: classes2.dex */
public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> MyBillsEntityDataFactory;

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.MyBillsEntityDataFactory = observableSource2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.MyBillsEntityDataFactory.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.getAuthRequestContext.subscribe(skipUntilObserver);
    }

    /* loaded from: classes9.dex */
    static final class SkipUntilObserver<T> implements Observer<T> {
        final ArrayCompositeDisposable BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final Observer<? super T> PlaceComponentResult;
        volatile boolean getAuthRequestContext;

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.PlaceComponentResult = observer;
            this.BuiltInFictitiousFunctionClassFactory = arrayCompositeDisposable;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.BuiltInFictitiousFunctionClassFactory.setResource(0, disposable);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.PlaceComponentResult.onNext(t);
            } else if (this.getAuthRequestContext) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.PlaceComponentResult.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.PlaceComponentResult.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    final class SkipUntil implements Observer<U> {
        final SerializedObserver<T> BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        final SkipUntilObserver<T> PlaceComponentResult;
        final ArrayCompositeDisposable getAuthRequestContext;

        SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.getAuthRequestContext = arrayCompositeDisposable;
            this.PlaceComponentResult = skipUntilObserver;
            this.BuiltInFictitiousFunctionClassFactory = serializedObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.setResource(1, disposable);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            this.MyBillsEntityDataFactory.dispose();
            this.PlaceComponentResult.getAuthRequestContext = true;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getAuthRequestContext.dispose();
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult.getAuthRequestContext = true;
        }
    }
}
