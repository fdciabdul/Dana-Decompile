package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: classes9.dex */
public final class MaybeError<T> extends Maybe<T> {
    final Throwable BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.BuiltInFictitiousFunctionClassFactory());
        maybeObserver.onError(this.BuiltInFictitiousFunctionClassFactory);
    }
}
