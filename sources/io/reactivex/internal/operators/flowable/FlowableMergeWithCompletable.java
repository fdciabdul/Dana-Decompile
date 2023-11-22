package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(mergeWithSubscriber);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(mergeWithSubscriber.otherObserver);
    }

    /* loaded from: classes9.dex */
    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            HalfSerializer.getAuthRequestContext(this.downstream, t, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        final void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, th, this, this.error);
        }

        final void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
            }
        }

        /* loaded from: classes9.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
