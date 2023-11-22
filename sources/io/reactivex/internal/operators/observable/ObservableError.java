package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableError<T> extends Observable<T> {
    final Callable<? extends Throwable> getAuthRequestContext;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.getAuthRequestContext = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.MyBillsEntityDataFactory(th);
        }
        EmptyDisposable.error(th, observer);
    }
}
