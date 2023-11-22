package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* loaded from: classes9.dex */
public final class SingleContains<T> extends Single<Boolean> {
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiPredicate<Object, Object> MyBillsEntityDataFactory;
    final Object PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new ContainsSingleObserver(singleObserver));
    }

    /* loaded from: classes9.dex */
    final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> PlaceComponentResult;

        ContainsSingleObserver(SingleObserver<? super Boolean> singleObserver) {
            this.PlaceComponentResult = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.PlaceComponentResult.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                this.PlaceComponentResult.onSuccess(Boolean.valueOf(SingleContains.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(t, SingleContains.this.PlaceComponentResult)));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.PlaceComponentResult.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }
    }
}
