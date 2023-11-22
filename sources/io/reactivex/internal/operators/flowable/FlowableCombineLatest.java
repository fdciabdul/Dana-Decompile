package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    final boolean BuiltInFictitiousFunctionClassFactory;
    final Publisher<? extends T>[] KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super Object[], ? extends R> MyBillsEntityDataFactory;
    final Iterable<? extends Publisher<? extends T>> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.PlaceComponentResult(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        EmptySubscription.error(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                EmptySubscription.error(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.MyBillsEntityDataFactory, i, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.subscribe(publisherArr, i);
        }
    }

    /* loaded from: classes9.dex */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = subscriber;
            this.combiner = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        final void subscribe(Publisher<? extends T>[] publisherArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                publisherArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }

        final void innerValue(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i2 = this.nonEmptySources;
                if (objArr[i] == null) {
                    i2++;
                    this.nonEmptySources = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    this.queue.PlaceComponentResult(this.subscribers[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i].requestOne();
            } else {
                drain();
            }
        }

        final void innerComplete(int i) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i] != null) {
                    int i2 = this.completedSources + 1;
                    if (i2 == objArr.length) {
                        this.done = true;
                    } else {
                        this.completedSources = i2;
                        return;
                    }
                } else {
                    this.done = true;
                }
                drain();
            }
        }

        final void innerError(int i, Throwable th) {
            if (ExceptionHelper.getAuthRequestContext(this.error, th)) {
                if (!this.delayErrors) {
                    cancelAll();
                    this.done = true;
                    drain();
                    return;
                }
                innerComplete(i);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        final void drainOutput() {
            Subscriber<? super R> subscriber = this.downstream;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (z && isEmpty) {
                    subscriber.onComplete();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        final void drainAsync() {
            Subscriber<? super R> subscriber = this.downstream;
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                        if (z2) {
                            break;
                        }
                        try {
                            subscriber.onNext((Object) ObjectHelper.PlaceComponentResult(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            cancelAll();
                            ExceptionHelper.getAuthRequestContext(this.error, th);
                            subscriber.onError(ExceptionHelper.getAuthRequestContext(this.error));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 == j && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0 && j != LongCompanionObject.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                return true;
            } else if (z) {
                if (this.delayErrors) {
                    if (z2) {
                        cancelAll();
                        Throwable authRequestContext = ExceptionHelper.getAuthRequestContext(this.error);
                        if (authRequestContext != null && authRequestContext != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                            subscriber.onError(authRequestContext);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable authRequestContext2 = ExceptionHelper.getAuthRequestContext(this.error);
                if (authRequestContext2 != null && authRequestContext2 != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                    cancelAll();
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(authRequestContext2);
                    return true;
                } else if (z2) {
                    cancelAll();
                    subscriber.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        final void cancelAll() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.cancel();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            this.outputFused = i2 != 0;
            return i2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) ObjectHelper.PlaceComponentResult(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return r;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.prefetch);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public final void requestOne() {
            int i = this.produced + 1;
            if (i == this.limit) {
                this.produced = 0;
                get().request(i);
                return;
            }
            this.produced = i;
        }
    }

    /* loaded from: classes9.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final R apply(T t) throws Exception {
            return FlowableCombineLatest.this.MyBillsEntityDataFactory.apply(new Object[]{t});
        }
    }
}
