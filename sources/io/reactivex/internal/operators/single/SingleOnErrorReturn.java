package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* loaded from: classes6.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {
    final Function<? super Throwable, ? extends T> BuiltInFictitiousFunctionClassFactory;
    final T KClassImpl$Data$declaredNonStaticMembers$2;
    final SingleSource<? extends T> MyBillsEntityDataFactory;

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.MyBillsEntityDataFactory = singleSource;
        this.BuiltInFictitiousFunctionClassFactory = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(new OnErrorReturn(singleObserver));
    }

    /* loaded from: classes6.dex */
    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> BuiltInFictitiousFunctionClassFactory;

        OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            T apply;
            if (SingleOnErrorReturn.this.BuiltInFictitiousFunctionClassFactory != null) {
                try {
                    apply = SingleOnErrorReturn.this.BuiltInFictitiousFunctionClassFactory.apply(th);
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    this.BuiltInFictitiousFunctionClassFactory.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                apply = SingleOnErrorReturn.this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.BuiltInFictitiousFunctionClassFactory.onError(nullPointerException);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(apply);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
        }
    }
}
