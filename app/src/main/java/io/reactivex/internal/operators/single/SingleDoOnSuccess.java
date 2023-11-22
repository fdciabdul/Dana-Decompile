package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> BuiltInFictitiousFunctionClassFactory;
    final SingleSource<T> MyBillsEntityDataFactory;

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.MyBillsEntityDataFactory = singleSource;
        this.BuiltInFictitiousFunctionClassFactory = consumer;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(new DoOnSuccess(singleObserver));
    }

    /* loaded from: classes6.dex */
    final class DoOnSuccess implements SingleObserver<T> {
        final SingleObserver<? super T> getAuthRequestContext;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.getAuthRequestContext = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                SingleDoOnSuccess.this.BuiltInFictitiousFunctionClassFactory.accept(t);
                this.getAuthRequestContext.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext.onError(th);
        }
    }
}
