package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new IgnoreElementsSubscriber(subscriber));
    }

    /* loaded from: classes9.dex */
    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super T> MyBillsEntityDataFactory;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 2;
        }

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.MyBillsEntityDataFactory = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        }
    }
}
