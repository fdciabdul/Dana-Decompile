package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new HideSubscriber(subscriber));
    }

    /* loaded from: classes9.dex */
    static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;
        Subscription MyBillsEntityDataFactory;

        HideSubscriber(Subscriber<? super T> subscriber) {
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.MyBillsEntityDataFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.MyBillsEntityDataFactory.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}
