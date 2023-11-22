package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action KClassImpl$Data$declaredNonStaticMembers$2;
    private final LongConsumer MyBillsEntityDataFactory;
    private final Consumer<? super Subscription> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SubscriptionLambdaSubscriber(subscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final Consumer<? super Subscription> KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super T> MyBillsEntityDataFactory;
        final LongConsumer PlaceComponentResult;
        final Action getAuthRequestContext;

        SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.MyBillsEntityDataFactory = subscriber;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = consumer;
            this.getAuthRequestContext = action;
            this.PlaceComponentResult = longConsumer;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(subscription);
                if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                    this.BuiltInFictitiousFunctionClassFactory = subscription;
                    this.MyBillsEntityDataFactory.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                subscription.cancel();
                this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.MyBillsEntityDataFactory);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory != SubscriptionHelper.CANCELLED) {
                this.MyBillsEntityDataFactory.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory != SubscriptionHelper.CANCELLED) {
                this.MyBillsEntityDataFactory.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Subscription subscription = this.BuiltInFictitiousFunctionClassFactory;
            if (subscription != SubscriptionHelper.CANCELLED) {
                this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
                try {
                    this.getAuthRequestContext.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
                subscription.cancel();
            }
        }
    }
}
