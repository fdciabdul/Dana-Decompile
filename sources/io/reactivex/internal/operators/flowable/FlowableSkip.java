package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
    final long getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SkipSubscriber(subscriber, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        long BuiltInFictitiousFunctionClassFactory;
        final Subscriber<? super T> PlaceComponentResult;
        Subscription getAuthRequestContext;

        SkipSubscriber(Subscriber<? super T> subscriber, long j) {
            this.PlaceComponentResult = subscriber;
            this.BuiltInFictitiousFunctionClassFactory = j;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                long j = this.BuiltInFictitiousFunctionClassFactory;
                this.getAuthRequestContext = subscription;
                this.PlaceComponentResult.onSubscribe(this);
                subscription.request(j);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            long j = this.BuiltInFictitiousFunctionClassFactory;
            if (j != 0) {
                this.BuiltInFictitiousFunctionClassFactory = j - 1;
            } else {
                this.PlaceComponentResult.onNext(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.PlaceComponentResult.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.getAuthRequestContext.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.getAuthRequestContext.cancel();
        }
    }
}
