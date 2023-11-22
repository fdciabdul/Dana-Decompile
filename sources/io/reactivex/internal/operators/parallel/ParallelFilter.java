package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelFilter<T> extends ParallelFlowable<T> {
    final ParallelFlowable<T> PlaceComponentResult;
    final Predicate<? super T> getAuthRequestContext;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super T>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.getAuthRequestContext);
                } else {
                    subscriberArr2[i] = new ParallelFilterSubscriber(subscriber, this.getAuthRequestContext);
                }
            }
            this.PlaceComponentResult.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.PlaceComponentResult.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> getAuthRequestContext;

        BaseFilterSubscriber(Predicate<? super T> predicate) {
            this.getAuthRequestContext = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.request(1L);
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> PlaceComponentResult;

        ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.PlaceComponentResult = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    this.PlaceComponentResult.onNext(t);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.PlaceComponentResult.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> MyBillsEntityDataFactory;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.MyBillsEntityDataFactory = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    return this.MyBillsEntityDataFactory.tryOnNext(t);
                }
                return false;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
