package io.reactivex.internal.operators.flowable;

import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SerializedSubscriber(subscriber));
    }
}
