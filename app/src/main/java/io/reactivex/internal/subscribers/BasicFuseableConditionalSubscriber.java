package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected Subscription getErrorConfigVersion;
    protected int lookAheadTest;
    protected final ConditionalSubscriber<? super R> moveToNextValue;
    protected QueueSubscription<T> scheduleImpl;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.moveToNextValue = conditionalSubscriber;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.getErrorConfigVersion, subscription)) {
            this.getErrorConfigVersion = subscription;
            if (subscription instanceof QueueSubscription) {
                this.scheduleImpl = (QueueSubscription) subscription;
            }
            this.moveToNextValue.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.moveToNextValue.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(Throwable th) {
        Exceptions.MyBillsEntityDataFactory(th);
        this.getErrorConfigVersion.cancel();
        onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.moveToNextValue.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        QueueSubscription<T> queueSubscription = this.scheduleImpl;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            this.lookAheadTest = requestFusion;
        }
        return requestFusion;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.getErrorConfigVersion.request(j);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.getErrorConfigVersion.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.scheduleImpl.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.scheduleImpl.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
