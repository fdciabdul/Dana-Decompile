package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* loaded from: classes9.dex */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {
    final Maybe<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Notification<T>> singleObserver) {
        this.PlaceComponentResult.PlaceComponentResult(new MaterializeSingleObserver(singleObserver));
    }
}
