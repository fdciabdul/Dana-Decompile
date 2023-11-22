package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ObservableFromFuture<T> extends Observable<T> {
    final long BuiltInFictitiousFunctionClassFactory;
    final Future<? extends T> PlaceComponentResult;
    final TimeUnit getAuthRequestContext;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.PlaceComponentResult = future;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.getAuthRequestContext = timeUnit;
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
            TimeUnit timeUnit = this.getAuthRequestContext;
            deferredScalarDisposable.complete(ObjectHelper.PlaceComponentResult(timeUnit != null ? this.PlaceComponentResult.get(this.BuiltInFictitiousFunctionClassFactory, timeUnit) : this.PlaceComponentResult.get(), "Future returned null"));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            observer.onError(th);
        }
    }
}
