package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowablePublishAlt<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    final Publisher<T> BuiltInFictitiousFunctionClassFactory;
    final AtomicReference<PublishConnection<T>> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;

    @Override // io.reactivex.flowables.ConnectableFlowable
    public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = false;
        if (!publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishConnection);
            if (z) {
                this.BuiltInFictitiousFunctionClassFactory.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerSubscription<T> innerSubscription = new InnerSubscription<>(subscriber, publishConnection);
        subscriber.onSubscribe(innerSubscription);
        if (publishConnection.add(innerSubscription)) {
            if (innerSubscription.isCancelled()) {
                publishConnection.remove(innerSubscription);
                return;
            } else {
                publishConnection.drain();
                return;
            }
        }
        Throwable th = publishConnection.error;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public final void MyBillsEntityDataFactory(Disposable disposable) {
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, (PublishConnection) disposable, null);
    }

    /* loaded from: classes9.dex */
    static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        int consumed;
        final AtomicReference<PublishConnection<T>> current;
        volatile boolean done;
        Throwable error;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.current, this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                drain();
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
            this.done = true;
            drain();
        }

        final void drain() {
            long j;
            if (getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.queue;
            int i = this.consumed;
            int i2 = this.bufferSize;
            int i3 = i2 - (i2 >> 2);
            boolean z = this.sourceMode != 1;
            int i4 = 1;
            SimpleQueue<T> simpleQueue2 = simpleQueue;
            int i5 = i;
            while (true) {
                if (simpleQueue2 != null) {
                    long j2 = LongCompanionObject.MAX_VALUE;
                    InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    boolean z2 = false;
                    for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        long j3 = innerSubscription.get();
                        if (j3 != Long.MIN_VALUE) {
                            j2 = Math.min(j3 - innerSubscription.emitted, j2);
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        j2 = 0;
                    }
                    while (j2 != j) {
                        boolean z3 = this.done;
                        try {
                            T poll = simpleQueue2.poll();
                            boolean z4 = poll == null;
                            if (checkTerminated(z3, z4)) {
                                return;
                            }
                            if (z4) {
                                break;
                            }
                            for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                if (!innerSubscription2.isCancelled()) {
                                    innerSubscription2.downstream.onNext(poll);
                                    innerSubscription2.emitted++;
                                }
                            }
                            if (z && (i5 = i5 + 1) == i3) {
                                this.upstream.get().request(i3);
                                i5 = 0;
                            }
                            j2--;
                            j = innerSubscriptionArr == this.subscribers.get() ? 0L : 0L;
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            this.upstream.get().cancel();
                            simpleQueue2.clear();
                            this.done = true;
                            signalError(th);
                            return;
                        }
                    }
                    if (checkTerminated(this.done, simpleQueue2.isEmpty())) {
                        return;
                    }
                }
                this.consumed = i5;
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                if (simpleQueue2 == null) {
                    simpleQueue2 = this.queue;
                }
            }
        }

        final boolean checkTerminated(boolean z, boolean z2) {
            if (z && z2) {
                Throwable th = this.error;
                if (th != null) {
                    signalError(th);
                    return true;
                }
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    if (!innerSubscription.isCancelled()) {
                        innerSubscription.downstream.onComplete();
                    }
                }
                return true;
            }
            return false;
        }

        final void signalError(Throwable th) {
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onError(th);
                }
            }
        }

        final boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        final void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriptionArr[i] == innerSubscription) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        final Subscriber<? super T> downstream;
        long emitted;
        final PublishConnection<T> parent;

        InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.downstream = subscriber;
            this.parent = publishConnection;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            BackpressureHelper.MyBillsEntityDataFactory(this, j);
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public final boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
