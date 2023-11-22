package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* loaded from: classes9.dex */
public final class SingleDoOnTerminate<T> extends Single<T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new DoOnTerminate(singleObserver));
    }

    /* loaded from: classes9.dex */
    final class DoOnTerminate implements SingleObserver<T> {
        final SingleObserver<? super T> BuiltInFictitiousFunctionClassFactory;

        DoOnTerminate(SingleObserver<? super T> singleObserver) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                SingleDoOnTerminate.this.BuiltInFictitiousFunctionClassFactory.run();
                this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            try {
                SingleDoOnTerminate.this.BuiltInFictitiousFunctionClassFactory.run();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }
    }
}
