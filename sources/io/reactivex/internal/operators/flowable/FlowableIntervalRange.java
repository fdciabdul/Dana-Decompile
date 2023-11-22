package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableIntervalRange extends Flowable<Long> {
    final long BuiltInFictitiousFunctionClassFactory;
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final long MyBillsEntityDataFactory;
    final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    final long getAuthRequestContext;
    final TimeUnit moveToNextValue;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext);
        subscriber.onSubscribe(intervalRangeSubscriber);
        Scheduler scheduler = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeSubscriber.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeSubscriber, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.moveToNextValue);
            return;
        }
        intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.moveToNextValue));
    }

    /* loaded from: classes9.dex */
    static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        long count;
        final Subscriber<? super Long> downstream;
        final long end;
        final AtomicReference<Disposable> resource = new AtomicReference<>();

        IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j, long j2) {
            this.downstream = subscriber;
            this.count = j;
            this.end = j2;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this, j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.resource.get() != DisposableHelper.DISPOSED) {
                long j = get();
                if (j != 0) {
                    long j2 = this.count;
                    this.downstream.onNext(Long.valueOf(j2));
                    if (j2 == this.end) {
                        if (this.resource.get() != DisposableHelper.DISPOSED) {
                            this.downstream.onComplete();
                        }
                        DisposableHelper.dispose(this.resource);
                        return;
                    }
                    this.count = j2 + 1;
                    if (j != LongCompanionObject.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                Subscriber<? super Long> subscriber = this.downstream;
                StringBuilder sb = new StringBuilder();
                sb.append("Can't deliver value ");
                sb.append(this.count);
                sb.append(" due to lack of requests");
                subscriber.onError(new MissingBackpressureException(sb.toString()));
                DisposableHelper.dispose(this.resource);
            }
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.resource, disposable);
        }
    }
}
