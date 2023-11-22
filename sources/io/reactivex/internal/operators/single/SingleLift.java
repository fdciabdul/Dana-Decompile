package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes9.dex */
public final class SingleLift<T, R> extends Single<R> {
    final SingleOperator<? extends R, ? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final SingleSource<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        try {
            this.PlaceComponentResult.MyBillsEntityDataFactory((SingleObserver) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
