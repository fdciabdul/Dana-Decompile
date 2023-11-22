package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    protected final Subscriber<? super R> NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected int getErrorConfigVersion;
    protected QueueSubscription<T> lookAheadTest;
    protected boolean moveToNextValue;
    protected Subscription scheduleImpl;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscriber;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.scheduleImpl, subscription)) {
            this.scheduleImpl = subscription;
            if (subscription instanceof QueueSubscription) {
                this.lookAheadTest = (QueueSubscription) subscription;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.moveToNextValue) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.moveToNextValue = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(Throwable th) {
        Exceptions.MyBillsEntityDataFactory(th);
        this.scheduleImpl.cancel();
        onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.moveToNextValue) {
            return;
        }
        this.moveToNextValue = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int MyBillsEntityDataFactory(int i) {
        QueueSubscription<T> queueSubscription = this.lookAheadTest;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            this.getErrorConfigVersion = requestFusion;
        }
        return requestFusion;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.scheduleImpl.request(j);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.scheduleImpl.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.lookAheadTest.isEmpty();
    }

    public void clear() {
        this.lookAheadTest.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
