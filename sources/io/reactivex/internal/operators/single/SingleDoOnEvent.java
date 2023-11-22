package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;

/* loaded from: classes9.dex */
public final class SingleDoOnEvent<T> extends Single<T> {
    final SingleSource<T> BuiltInFictitiousFunctionClassFactory;
    final BiConsumer<? super T, ? super Throwable> MyBillsEntityDataFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new DoOnEvent(singleObserver));
    }

    /* loaded from: classes9.dex */
    final class DoOnEvent implements SingleObserver<T> {
        private final SingleObserver<? super T> BuiltInFictitiousFunctionClassFactory;

        DoOnEvent(SingleObserver<? super T> singleObserver) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                SingleDoOnEvent.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(t, null);
                this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            try {
                SingleDoOnEvent.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(null, th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }
    }
}
