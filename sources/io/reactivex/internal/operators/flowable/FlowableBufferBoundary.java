package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<? extends Open> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super Open, ? extends Publisher<? extends Close>> MyBillsEntityDataFactory;
    final Callable<U> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(bufferBoundarySubscriber);
    }

    /* loaded from: classes9.dex */
    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        final Publisher<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super C> downstream;
        long emitted;
        long index;
        final SpscLinkedArrayQueue<C> queue = new SpscLinkedArrayQueue<>(Flowable.BuiltInFictitiousFunctionClassFactory());
        final CompositeDisposable subscribers = new CompositeDisposable();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
            this.downstream = subscriber;
            this.bufferSupplier = callable;
            this.bufferOpen = publisher;
            this.bufferClose = function;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.getAuthRequestContext(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            BackpressureHelper.getAuthRequestContext(this.requested, j);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void open(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                    this.subscribers.getAuthRequestContext(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        final void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.MyBillsEntityDataFactory(bufferOpenSubscriber);
            if (this.subscribers.getAuthRequestContext() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                drain();
            }
        }

        final void close(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            boolean z;
            this.subscribers.MyBillsEntityDataFactory(bufferCloseSubscriber);
            if (this.subscribers.getAuthRequestContext() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        final void boundaryError(Disposable disposable, Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.MyBillsEntityDataFactory(disposable);
            onError(th);
        }

        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            Subscriber<? super C> subscriber = this.downstream;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    C poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j++;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        if (this.errors.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else if (spscLinkedArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                i = addAndGet(-i);
            } while (i != 0);
        }

        /* loaded from: classes9.dex */
        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public final void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public final void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // org.reactivestreams.Subscriber
            public final void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
            }

            @Override // org.reactivestreams.Subscriber
            public final void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundarySubscriber<T, C, ?, ?> parent;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.parent = bufferBoundarySubscriber;
            this.index = j;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
            Subscription subscription = get();
            if (subscription != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                subscription.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
