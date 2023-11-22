package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes9.dex */
public final class CompletableMaterialize<T> extends Single<Notification<T>> {
    final Completable BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Notification<T>> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new MaterializeSingleObserver(singleObserver));
    }
}
