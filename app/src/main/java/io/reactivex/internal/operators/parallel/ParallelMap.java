package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelMap<T, R> extends ParallelFlowable<R> {
    final ParallelFlowable<T> MyBillsEntityDataFactory;
    final Function<? super T, ? extends R> PlaceComponentResult;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super R>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super R> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelMapConditionalSubscriber((ConditionalSubscriber) subscriber, this.PlaceComponentResult);
                } else {
                    subscriberArr2[i] = new ParallelMapSubscriber(subscriber, this.PlaceComponentResult);
                }
            }
            this.MyBillsEntityDataFactory.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    /* loaded from: classes9.dex */
    static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Function<? super T, ? extends R> getAuthRequestContext;

        ParallelMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
            this.getAuthRequestContext = function;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.onNext(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        final ConditionalSubscriber<? super R> MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final Function<? super T, ? extends R> getAuthRequestContext;

        ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.MyBillsEntityDataFactory = conditionalSubscriber;
            this.getAuthRequestContext = function;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.onNext(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.PlaceComponentResult) {
                return false;
            }
            try {
                return this.MyBillsEntityDataFactory.tryOnNext(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
