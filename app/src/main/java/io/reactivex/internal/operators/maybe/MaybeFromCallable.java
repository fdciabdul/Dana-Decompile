package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    final Callable<? extends T> getAuthRequestContext;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.getAuthRequestContext = callable;
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        maybeObserver.onSubscribe(authRequestContext);
        if (authRequestContext.isDisposed()) {
            return;
        }
        try {
            Object obj = (T) this.getAuthRequestContext.call();
            if (authRequestContext.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (!authRequestContext.isDisposed()) {
                maybeObserver.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return this.getAuthRequestContext.call();
    }
}
