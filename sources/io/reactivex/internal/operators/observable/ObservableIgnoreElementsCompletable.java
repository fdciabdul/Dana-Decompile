package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> getAuthRequestContext;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.getAuthRequestContext = observableSource;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.getAuthRequestContext.subscribe(new IgnoreObservable(completableObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<T> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableIgnoreElements(this.getAuthRequestContext));
    }

    /* loaded from: classes6.dex */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final CompletableObserver MyBillsEntityDataFactory;

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
        }

        IgnoreObservable(CompletableObserver completableObserver) {
            this.MyBillsEntityDataFactory = completableObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory = disposable;
            this.MyBillsEntityDataFactory.onSubscribe(this);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }
    }
}
