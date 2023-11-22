package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    final Publisher<T> BuiltInFictitiousFunctionClassFactory;
    final ErrorMode KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final Function<? super T, ? extends Publisher<? extends R>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, subscriber, this.getAuthRequestContext)) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.subscribe(FlowableConcatMap.PlaceComponentResult(subscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
