package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* loaded from: classes9.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {
    final SingleSource<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(singleObserver);
    }
}
