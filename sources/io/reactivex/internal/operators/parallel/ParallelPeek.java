package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final Consumer<? super Throwable> KClassImpl$Data$declaredNonStaticMembers$2;
    final Action MyBillsEntityDataFactory;
    final ParallelFlowable<T> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Action PlaceComponentResult;
    final Consumer<? super T> getAuthRequestContext;
    final Consumer<? super Subscription> getErrorConfigVersion;
    final LongConsumer lookAheadTest;
    final Consumer<? super T> moveToNextValue;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super T>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new ParallelPeekSubscriber(subscriberArr[i], this);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext();
    }

    /* loaded from: classes9.dex */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        final ParallelPeek<T> MyBillsEntityDataFactory;
        boolean getAuthRequestContext;

        ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
            this.MyBillsEntityDataFactory = parallelPeek;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            try {
                LongConsumer longConsumer = this.MyBillsEntityDataFactory.lookAheadTest;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            try {
                this.MyBillsEntityDataFactory.PlaceComponentResult.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
            this.BuiltInFictitiousFunctionClassFactory.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                try {
                    this.MyBillsEntityDataFactory.getErrorConfigVersion.accept(subscription);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    subscription.cancel();
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.moveToNextValue.accept(t);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
                try {
                    this.MyBillsEntityDataFactory.getAuthRequestContext.accept(t);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            try {
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            try {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            try {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.run();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
                try {
                    this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th2);
            }
        }
    }
}
