package org.reactivestreams;

import java.util.concurrent.Flow;

/* loaded from: classes9.dex */
public final class FlowAdapters {
    private FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    /* loaded from: classes9.dex */
    static final class FlowToReactiveSubscription implements Flow.Subscription {
        final Subscription PlaceComponentResult;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.PlaceComponentResult = subscription;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public final void request(long j) {
            this.PlaceComponentResult.request(j);
        }

        @Override // java.util.concurrent.Flow.Subscription
        public final void cancel() {
            this.PlaceComponentResult.cancel();
        }
    }

    /* loaded from: classes9.dex */
    static final class ReactiveToFlowSubscription implements Subscription {
        final Flow.Subscription getAuthRequestContext;

        public ReactiveToFlowSubscription(Flow.Subscription subscription) {
            this.getAuthRequestContext = subscription;
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

    /* loaded from: classes9.dex */
    static final class FlowToReactiveSubscriber<T> implements Flow.Subscriber<T> {
        final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;

        public FlowToReactiveSubscriber(Subscriber<? super T> subscriber) {
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onSubscribe(Flow.Subscription subscription) {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {
        final Flow.Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2;

        public ReactiveToFlowSubscriber(Flow.Subscriber<? super T> subscriber) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {
        final Flow.Processor<? super T, ? extends U> BuiltInFictitiousFunctionClassFactory;

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
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

        @Override // org.reactivestreams.Publisher
        public final void subscribe(Subscriber<? super U> subscriber) {
            this.BuiltInFictitiousFunctionClassFactory.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    /* loaded from: classes9.dex */
    static final class FlowToReactiveProcessor<T, U> implements Flow.Processor<T, U> {
        final Processor<? super T, ? extends U> MyBillsEntityDataFactory;

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onSubscribe(Flow.Subscription subscription) {
            this.MyBillsEntityDataFactory.onSubscribe(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // java.util.concurrent.Flow.Publisher
        public final void subscribe(Flow.Subscriber<? super U> subscriber) {
            this.MyBillsEntityDataFactory.subscribe(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }

    /* loaded from: classes9.dex */
    static final class ReactivePublisherFromFlow<T> implements Publisher<T> {
        final Flow.Publisher<? extends T> MyBillsEntityDataFactory;

        @Override // org.reactivestreams.Publisher
        public final void subscribe(Subscriber<? super T> subscriber) {
            this.MyBillsEntityDataFactory.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    /* loaded from: classes9.dex */
    static final class FlowPublisherFromReactive<T> implements Flow.Publisher<T> {
        final Publisher<? extends T> getAuthRequestContext;

        @Override // java.util.concurrent.Flow.Publisher
        public final void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.getAuthRequestContext.subscribe(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }
}
