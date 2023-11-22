package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class SingleDefer<T> extends Single<T> {
    final Callable<? extends SingleSource<? extends T>> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.call(), "The singleSupplier returned a null SingleSource")).MyBillsEntityDataFactory(singleObserver);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
