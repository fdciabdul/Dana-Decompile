package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler MyBillsEntityDataFactory;
    final TimeUnit getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Timed<T>> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new TimeIntervalSubscriber(subscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
        long MyBillsEntityDataFactory;
        final Subscriber<? super Timed<T>> PlaceComponentResult;
        final Scheduler getAuthRequestContext;

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.PlaceComponentResult = subscriber;
            this.getAuthRequestContext = scheduler;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.MyBillsEntityDataFactory = this.getAuthRequestContext.now(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            long now = this.getAuthRequestContext.now(this.KClassImpl$Data$declaredNonStaticMembers$2);
            long j = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = now;
            this.PlaceComponentResult.onNext(new Timed(t, now - j, this.KClassImpl$Data$declaredNonStaticMembers$2));
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
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
        }
    }
}
