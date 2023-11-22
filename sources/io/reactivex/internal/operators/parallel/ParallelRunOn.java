package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final Scheduler MyBillsEntityDataFactory;
    final ParallelFlowable<? extends T> PlaceComponentResult;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super T>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.MyBillsEntityDataFactory;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).PlaceComponentResult(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    getAuthRequestContext(i, subscriberArr, subscriberArr2, this.MyBillsEntityDataFactory.createWorker());
                }
            }
            this.PlaceComponentResult.getAuthRequestContext(subscriberArr2);
        }
    }

    final void getAuthRequestContext(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new RunOnSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, spscArrayQueue, worker);
        }
    }

    /* loaded from: classes9.dex */
    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<T>[] KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super T>[] MyBillsEntityDataFactory;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.MyBillsEntityDataFactory = subscriberArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Scheduler.Worker worker) {
            ParallelRunOn.this.getAuthRequestContext(i, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, worker);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.PlaceComponentResult.getAuthRequestContext();
    }

    /* loaded from: classes9.dex */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                schedule();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> downstream;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.downstream;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                        i2++;
                        if (i2 == i3) {
                            i = i4;
                            this.upstream.request(i2);
                            i2 = 0;
                        } else {
                            i = i4;
                        }
                        i4 = i;
                    } else {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
                int i5 = i4;
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != LongCompanionObject.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i6 = get();
                if (i6 == i5) {
                    this.consumed = i2;
                    i6 = addAndGet(-i5);
                    if (i6 == 0) {
                        return;
                    }
                }
                i4 = i6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> downstream;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.downstream = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            Throwable th;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            int i3 = this.limit;
            int i4 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j2++;
                        }
                        i2++;
                        if (i2 == i3) {
                            i = i4;
                            this.upstream.request(i2);
                            i2 = 0;
                        } else {
                            i = i4;
                        }
                        i4 = i;
                    } else {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
                int i5 = i4;
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != LongCompanionObject.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i6 = get();
                if (i6 == i5) {
                    this.consumed = i2;
                    i6 = addAndGet(-i5);
                    if (i6 == 0) {
                        return;
                    }
                }
                i4 = i6;
            }
        }
    }
}
