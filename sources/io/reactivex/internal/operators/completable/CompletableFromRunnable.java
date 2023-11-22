package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class CompletableFromRunnable extends Completable {
    final Runnable MyBillsEntityDataFactory;

    public CompletableFromRunnable(Runnable runnable) {
        this.MyBillsEntityDataFactory = runnable;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        completableObserver.onSubscribe(authRequestContext);
        try {
            this.MyBillsEntityDataFactory.run();
            if (authRequestContext.isDisposed()) {
                return;
            }
            completableObserver.onComplete();
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (!authRequestContext.isDisposed()) {
                completableObserver.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }
    }
}
