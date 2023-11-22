package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.EndConsumerHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription PlaceComponentResult;

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.getAuthRequestContext(this.PlaceComponentResult, subscription, getClass())) {
            this.PlaceComponentResult = subscription;
            if (subscription != null) {
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }
    }
}
