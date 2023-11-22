package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final Scheduler MyBillsEntityDataFactory;
    final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda0;
    final boolean getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DelaySubscriber(!this.getAuthRequestContext ? new SerializedSubscriber(subscriber) : subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory.createWorker(), this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final boolean BuiltInFictitiousFunctionClassFactory;
        final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
        Subscription MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        final Subscriber<? super T> getAuthRequestContext;
        final Scheduler.Worker lookAheadTest;

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.getAuthRequestContext = subscriber;
            this.PlaceComponentResult = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
            this.lookAheadTest = worker;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.lookAheadTest.schedule(new OnNext(t), this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.lookAheadTest.schedule(new OnError(th), this.BuiltInFictitiousFunctionClassFactory ? this.PlaceComponentResult : 0L, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.lookAheadTest.schedule(new OnComplete(), this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.MyBillsEntityDataFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.MyBillsEntityDataFactory.cancel();
            this.lookAheadTest.dispose();
        }

        /* loaded from: classes9.dex */
        final class OnNext implements Runnable {
            private final T BuiltInFictitiousFunctionClassFactory;

            OnNext(T t) {
                this.BuiltInFictitiousFunctionClassFactory = t;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DelaySubscriber.this.getAuthRequestContext.onNext((T) this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        /* loaded from: classes9.dex */
        final class OnError implements Runnable {
            private final Throwable BuiltInFictitiousFunctionClassFactory;

            OnError(Throwable th) {
                this.BuiltInFictitiousFunctionClassFactory = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    DelaySubscriber.this.getAuthRequestContext.onError(this.BuiltInFictitiousFunctionClassFactory);
                } finally {
                    DelaySubscriber.this.lookAheadTest.dispose();
                }
            }
        }

        /* loaded from: classes9.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    DelaySubscriber.this.getAuthRequestContext.onComplete();
                } finally {
                    DelaySubscriber.this.lookAheadTest.dispose();
                }
            }
        }
    }
}
