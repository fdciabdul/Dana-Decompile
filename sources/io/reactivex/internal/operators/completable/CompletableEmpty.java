package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class CompletableEmpty extends Completable {
    public static final Completable BuiltInFictitiousFunctionClassFactory = new CompletableEmpty();

    private CompletableEmpty() {
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        EmptyDisposable.complete(completableObserver);
    }
}
