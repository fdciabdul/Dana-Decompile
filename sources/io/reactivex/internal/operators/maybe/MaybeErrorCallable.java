package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class MaybeErrorCallable<T> extends Maybe<T> {
    final Callable<? extends Throwable> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.BuiltInFictitiousFunctionClassFactory());
        try {
            th = (Throwable) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.MyBillsEntityDataFactory(th);
        }
        maybeObserver.onError(th);
    }
}
