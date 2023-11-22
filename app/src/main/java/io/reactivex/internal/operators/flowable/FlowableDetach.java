package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DetachSubscriber(subscriber));
    }

    /* loaded from: classes9.dex */
    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription MyBillsEntityDataFactory;
        Subscriber<? super T> getAuthRequestContext;

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.getAuthRequestContext = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.MyBillsEntityDataFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Subscription subscription = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = EmptyComponent.INSTANCE;
            this.getAuthRequestContext = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.getAuthRequestContext.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.getAuthRequestContext;
            this.MyBillsEntityDataFactory = EmptyComponent.INSTANCE;
            this.getAuthRequestContext = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            Subscriber<? super T> subscriber = this.getAuthRequestContext;
            this.MyBillsEntityDataFactory = EmptyComponent.INSTANCE;
            this.getAuthRequestContext = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }
    }
}
