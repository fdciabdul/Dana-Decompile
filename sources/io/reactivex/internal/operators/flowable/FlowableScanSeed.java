package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<R> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ScanSeedSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "The seed supplied is null"), Flowable.PlaceComponentResult));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    /* loaded from: classes9.dex */
    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        Throwable error;
        final int limit;
        final int prefetch;
        final SimplePlainQueue<R> queue;
        final AtomicLong requested;
        Subscription upstream;
        R value;

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i) {
            this.downstream = subscriber;
            this.accumulator = biFunction;
            this.value = r;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request((long) (this.prefetch - 1));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) ObjectHelper.PlaceComponentResult(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        final void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            SimplePlainQueue<R> simplePlainQueue = this.queue;
            int i = this.limit;
            int i2 = this.consumed;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    Object obj = (R) simplePlainQueue.poll();
                    boolean z2 = obj == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j2++;
                        i2++;
                        if (i2 == i) {
                            this.upstream.request(i);
                            i2 = 0;
                        }
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 == j && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th2);
                        return;
                    } else if (simplePlainQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.PlaceComponentResult(this.requested, j2);
                }
                this.consumed = i2;
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }
}
