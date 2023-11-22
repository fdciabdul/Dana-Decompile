package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class CompletableLift extends Completable {
    final CompletableOperator KClassImpl$Data$declaredNonStaticMembers$2;
    final CompletableSource getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        try {
            this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }
}
