package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class CompletableDefer extends Completable {
    final Callable<? extends CompletableSource> PlaceComponentResult;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        try {
            ((CompletableSource) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.call(), "The completableSupplier returned a null CompletableSource")).getAuthRequestContext(completableObserver);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
