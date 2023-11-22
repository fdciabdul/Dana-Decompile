package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes9.dex */
public final class SingleNever extends Single<Object> {
    public static final Single<Object> MyBillsEntityDataFactory = new SingleNever();

    private SingleNever() {
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
