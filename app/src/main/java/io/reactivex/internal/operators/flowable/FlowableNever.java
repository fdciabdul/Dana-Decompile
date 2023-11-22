package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> KClassImpl$Data$declaredNonStaticMembers$2 = new FlowableNever();

    private FlowableNever() {
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Object> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
