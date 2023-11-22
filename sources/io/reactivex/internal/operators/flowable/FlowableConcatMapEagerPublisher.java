package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    final int BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends Publisher<? extends R>> KClassImpl$Data$declaredNonStaticMembers$2;
    final ErrorMode MyBillsEntityDataFactory;
    final Publisher<T> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory));
    }
}
