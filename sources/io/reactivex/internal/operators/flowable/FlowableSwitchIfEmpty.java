package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> getAuthRequestContext;

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.getAuthRequestContext = publisher;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.getAuthRequestContext);
        subscriber.onSubscribe(switchIfEmptySubscriber.KClassImpl$Data$declaredNonStaticMembers$2);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(switchIfEmptySubscriber);
    }

    /* loaded from: classes9.dex */
    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> PlaceComponentResult;
        final Publisher<? extends T> getAuthRequestContext;
        boolean MyBillsEntityDataFactory = true;
        final SubscriptionArbiter KClassImpl$Data$declaredNonStaticMembers$2 = new SubscriptionArbiter(false);

        SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.PlaceComponentResult = subscriber;
            this.getAuthRequestContext = publisher;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setSubscription(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
            }
            this.PlaceComponentResult.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
                this.getAuthRequestContext.subscribe(this);
                return;
            }
            this.PlaceComponentResult.onComplete();
        }
    }
}
