package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelReduce<T, R> extends ParallelFlowable<R> {
    final Callable<R> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiFunction<R, ? super T, R> MyBillsEntityDataFactory;
    final ParallelFlowable<? extends T> PlaceComponentResult;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super R>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super Object>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                try {
                    subscriberArr2[i] = new ParallelReduceSubscriber(subscriberArr[i], ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.call(), "The initialSupplier returned a null value"), this.MyBillsEntityDataFactory);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    for (Subscriber<? super R> subscriber : subscriberArr) {
                        EmptySubscription.error(th, subscriber);
                    }
                    return;
                }
            }
            this.PlaceComponentResult.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.PlaceComponentResult.getAuthRequestContext();
    }

    /* loaded from: classes9.dex */
    static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final BiFunction<R, ? super T, R> reducer;

        ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.accumulator = r;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) ObjectHelper.PlaceComponentResult(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
