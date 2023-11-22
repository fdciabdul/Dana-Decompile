package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    final int BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final Function<? super T, ? extends Publisher<? extends U>> getAuthRequestContext;
    final Publisher<T> moveToNextValue;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.getAuthRequestContext(this.moveToNextValue, subscriber, this.getAuthRequestContext)) {
            return;
        }
        this.moveToNextValue.subscribe(FlowableFlatMap.PlaceComponentResult(subscriber, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
    }
}
