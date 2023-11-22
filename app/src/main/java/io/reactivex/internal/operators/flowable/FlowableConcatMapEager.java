package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final ErrorMode MyBillsEntityDataFactory;
    final Function<? super T, ? extends Publisher<? extends R>> getAuthRequestContext;
    final int getErrorConfigVersion;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.downstream = subscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i2, i));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                subscription.request(i == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            drainAndCancel();
        }

        final void drainAndCancel() {
            if (getAndIncrement() != 0) {
                return;
            }
            do {
                cancelAll();
            } while (decrementAndGet() != 0);
        }

        final void cancelAll() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll == null) {
                    return;
                }
                poll.cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public final void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public final void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public final void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public final void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i;
            long j;
            boolean z;
            SimpleQueue<R> queue;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int i2 = 1;
            while (true) {
                long j2 = this.requested.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else if (errorMode != ErrorMode.END && this.errors.get() != null) {
                    cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                } else {
                    boolean z2 = this.done;
                    innerQueuedSubscriber = this.subscribers.poll();
                    if (z2 && innerQueuedSubscriber == null) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (innerQueuedSubscriber != null) {
                        this.current = innerQueuedSubscriber;
                    }
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i = i2;
                    j = 0;
                    z = false;
                } else {
                    i = i2;
                    j = 0;
                    while (j != j2) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            boolean isDone = innerQueuedSubscriber.isDone();
                            try {
                                R poll = queue.poll();
                                boolean z3 = poll == null;
                                if (!isDone || !z3) {
                                    if (z3) {
                                        break;
                                    }
                                    subscriber.onNext(poll);
                                    j++;
                                    innerQueuedSubscriber.requestOne();
                                } else {
                                    this.current = null;
                                    this.upstream.request(1L);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                    break;
                                }
                            } catch (Throwable th) {
                                Exceptions.MyBillsEntityDataFactory(th);
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    z = false;
                    if (j == j2) {
                        if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            boolean isDone2 = innerQueuedSubscriber.isDone();
                            boolean isEmpty = queue.isEmpty();
                            if (isDone2 && isEmpty) {
                                this.current = null;
                                this.upstream.request(1L);
                                innerQueuedSubscriber = null;
                                z = true;
                            }
                        }
                    }
                }
                if (j != 0 && j2 != LongCompanionObject.MAX_VALUE) {
                    this.requested.addAndGet(-j);
                }
                int i3 = i;
                if (z) {
                    i2 = i3;
                } else {
                    i2 = addAndGet(-i3);
                    if (i2 == 0) {
                        return;
                    }
                }
                innerQueuedSubscriber2 = innerQueuedSubscriber;
            }
        }
    }
}
