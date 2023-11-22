package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class CompletableFromAction extends Completable {
    final Action KClassImpl$Data$declaredNonStaticMembers$2;

    public CompletableFromAction(Action action) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = action;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        Disposable authRequestContext = Disposables.getAuthRequestContext();
        completableObserver.onSubscribe(authRequestContext);
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.run();
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
