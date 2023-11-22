package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: classes6.dex */
public final class SingleJust<T> extends Single<T> {
    final T MyBillsEntityDataFactory;

    public SingleJust(T t) {
        this.MyBillsEntityDataFactory = t;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.BuiltInFictitiousFunctionClassFactory());
        singleObserver.onSuccess((T) this.MyBillsEntityDataFactory);
    }
}
