package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* loaded from: classes9.dex */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<R> MyBillsEntityDataFactory;
    final Publisher<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        try {
            this.PlaceComponentResult.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.KClassImpl$Data$declaredNonStaticMembers$2, ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
