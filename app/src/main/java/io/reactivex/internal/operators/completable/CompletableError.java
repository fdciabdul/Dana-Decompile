package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes9.dex */
public final class CompletableError extends Completable {
    final Throwable KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.KClassImpl$Data$declaredNonStaticMembers$2, completableObserver);
    }
}
