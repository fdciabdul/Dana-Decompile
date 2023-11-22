package io.reactivex.internal.operators.single;

import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes9.dex */
public final class SingleMaterialize<T> extends Single<Notification<T>> {
    final Single<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Notification<T>> singleObserver) {
        this.PlaceComponentResult.MyBillsEntityDataFactory((SingleObserver) new MaterializeSingleObserver(singleObserver));
    }
}
