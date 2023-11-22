package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;
    final Callable<R> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiFunction<R, ? super T, R> MyBillsEntityDataFactory;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
        this.MyBillsEntityDataFactory = biFunction;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.MyBillsEntityDataFactory, ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
