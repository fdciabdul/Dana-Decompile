package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicReference<>();

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, subscription, getClass())) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
