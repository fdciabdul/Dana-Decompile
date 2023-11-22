package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    Throwable MyBillsEntityDataFactory;
    T PlaceComponentResult;
    Subscription getAuthRequestContext;

    public BlockingBaseSubscriber() {
        super(1);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
            this.getAuthRequestContext = subscription;
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            subscription.request(LongCompanionObject.MAX_VALUE);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }
}
