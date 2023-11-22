package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class FlowableTimer extends Flowable<Long> {
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final TimeUnit MyBillsEntityDataFactory;
    final long getAuthRequestContext;

    public FlowableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.getAuthRequestContext = j;
        this.MyBillsEntityDataFactory = timeUnit;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduler;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.onSubscribe(timerSubscriber);
        timerSubscriber.setResource(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleDirect(timerSubscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> downstream;
        volatile boolean requested;

        TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.requested = true;
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (this.requested) {
                    this.downstream.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onComplete();
                    return;
                }
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }
}
