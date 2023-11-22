package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> BuiltInFictitiousFunctionClassFactory;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.BuiltInFictitiousFunctionClassFactory = callable;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        singleObserver.onSubscribe(authRequestContext);
        if (authRequestContext.isDisposed()) {
            return;
        }
        try {
            Object obj = (Object) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The callable returned a null value");
            if (authRequestContext.isDisposed()) {
                return;
            }
            singleObserver.onSuccess(obj);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (!authRequestContext.isDisposed()) {
                singleObserver.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }
}
