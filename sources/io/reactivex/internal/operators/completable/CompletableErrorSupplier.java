package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class CompletableErrorSupplier extends Completable {
    final Callable<? extends Throwable> MyBillsEntityDataFactory;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        try {
            th = (Throwable) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            Exceptions.MyBillsEntityDataFactory(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
