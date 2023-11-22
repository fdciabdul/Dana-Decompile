package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    final Callable<? extends T> BuiltInFictitiousFunctionClassFactory;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.BuiltInFictitiousFunctionClassFactory = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "Callable returned null"));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (!deferredScalarDisposable.isDisposed()) {
                observer.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return (T) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The callable returned a null value");
    }
}
