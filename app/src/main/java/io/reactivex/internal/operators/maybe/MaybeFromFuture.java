package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> BuiltInFictitiousFunctionClassFactory;
    final long MyBillsEntityDataFactory;
    final TimeUnit PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        maybeObserver.onSubscribe(authRequestContext);
        if (authRequestContext.isDisposed()) {
            return;
        }
        try {
            long j = this.MyBillsEntityDataFactory;
            if (j <= 0) {
                obj = (T) this.BuiltInFictitiousFunctionClassFactory.get();
            } else {
                obj = (T) this.BuiltInFictitiousFunctionClassFactory.get(j, this.PlaceComponentResult);
            }
            if (authRequestContext.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (Throwable th) {
            th = th;
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            Exceptions.MyBillsEntityDataFactory(th);
            if (authRequestContext.isDisposed()) {
                return;
            }
            maybeObserver.onError(th);
        }
    }
}
