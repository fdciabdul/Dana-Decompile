package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.fuseable.ScalarCallable;

/* loaded from: classes9.dex */
public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {
    final T getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.BuiltInFictitiousFunctionClassFactory());
        maybeObserver.onSuccess((T) this.getAuthRequestContext);
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public final T call() {
        return this.getAuthRequestContext;
    }
}
