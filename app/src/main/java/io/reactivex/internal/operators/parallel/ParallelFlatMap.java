package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {
    final boolean BuiltInFictitiousFunctionClassFactory;
    final ParallelFlowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final int PlaceComponentResult;
    final Function<? super T, ? extends Publisher<? extends R>> getAuthRequestContext;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super R>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableFlatMap.PlaceComponentResult(subscriberArr[i], this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(subscriberArr2);
        }
    }
}
