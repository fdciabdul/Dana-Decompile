package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<U> BuiltInFictitiousFunctionClassFactory;
    final ObservableSource<? extends T> getAuthRequestContext;

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.getAuthRequestContext = observableSource;
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new DelayObserver(sequentialDisposable, observer));
    }

    /* loaded from: classes9.dex */
    final class DelayObserver implements Observer<U> {
        boolean BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> MyBillsEntityDataFactory;
        final SequentialDisposable getAuthRequestContext;

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.getAuthRequestContext = sequentialDisposable;
            this.MyBillsEntityDataFactory = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.update(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            onComplete();
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
            ObservableDelaySubscriptionOther.this.getAuthRequestContext.subscribe(new OnComplete());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DelayObserver.this.getAuthRequestContext.update(disposable);
            }

            @Override // io.reactivex.Observer
            public final void onNext(T t) {
                DelayObserver.this.MyBillsEntityDataFactory.onNext(t);
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                DelayObserver.this.MyBillsEntityDataFactory.onError(th);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                DelayObserver.this.MyBillsEntityDataFactory.onComplete();
            }
        }
    }
}
