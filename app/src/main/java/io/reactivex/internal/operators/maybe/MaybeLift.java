package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes9.dex */
public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final MaybeOperator<? extends R, ? super T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult((MaybeObserver) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.getAuthRequestContext(), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
