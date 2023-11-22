package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class MaybeFromAction<T> extends Maybe<T> implements Callable<T> {
    final Action KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        maybeObserver.onSubscribe(authRequestContext);
        if (authRequestContext.isDisposed()) {
            return;
        }
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.run();
            if (authRequestContext.isDisposed()) {
                return;
            }
            maybeObserver.onComplete();
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
        this.KClassImpl$Data$declaredNonStaticMembers$2.run();
        return null;
    }
}
