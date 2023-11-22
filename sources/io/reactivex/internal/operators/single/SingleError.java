package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class SingleError<T> extends Single<T> {
    final Callable<? extends Throwable> getAuthRequestContext;

    public SingleError(Callable<? extends Throwable> callable) {
        this.getAuthRequestContext = callable;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.MyBillsEntityDataFactory(th);
        }
        EmptyDisposable.error(th, singleObserver);
    }
}
