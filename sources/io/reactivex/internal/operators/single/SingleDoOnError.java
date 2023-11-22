package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes9.dex */
public final class SingleDoOnError<T> extends Single<T> {
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final Consumer<? super Throwable> MyBillsEntityDataFactory;

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = singleSource;
        this.MyBillsEntityDataFactory = consumer;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new DoOnError(singleObserver));
    }

    /* loaded from: classes9.dex */
    final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> MyBillsEntityDataFactory;

        DoOnError(SingleObserver<? super T> singleObserver) {
            this.MyBillsEntityDataFactory = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            try {
                SingleDoOnError.this.MyBillsEntityDataFactory.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.MyBillsEntityDataFactory.onError(th);
        }
    }
}
