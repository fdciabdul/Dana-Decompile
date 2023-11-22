package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final int getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super C> subscriber) {
        int i = this.getAuthRequestContext;
        int i2 = this.MyBillsEntityDataFactory;
        if (i == i2) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new PublisherBufferExactSubscriber(subscriber, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2));
        } else if (i2 > i) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new PublisherBufferSkipSubscriber(subscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new PublisherBufferOverlappingSubscriber(subscriber, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes9.dex */
    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        boolean BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super C> MyBillsEntityDataFactory;
        Subscription NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Callable<C> PlaceComponentResult;
        C getAuthRequestContext;
        final int lookAheadTest;

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.MyBillsEntityDataFactory = subscriber;
            this.lookAheadTest = i;
            this.PlaceComponentResult = callable;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.request(BackpressureHelper.MyBillsEntityDataFactory(j, this.lookAheadTest));
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, subscription)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            C c = this.getAuthRequestContext;
            if (c == null) {
                try {
                    c = (C) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.call(), "The bufferSupplier returned a null buffer");
                    this.getAuthRequestContext = c;
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            if (i == this.lookAheadTest) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                this.getAuthRequestContext = null;
                this.MyBillsEntityDataFactory.onNext(c);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            C c = this.getAuthRequestContext;
            if (c != null && !c.isEmpty()) {
                this.MyBillsEntityDataFactory.onNext(c);
            }
            this.MyBillsEntityDataFactory.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.upstream.request(BackpressureHelper.KClassImpl$Data$declaredNonStaticMembers$2(BackpressureHelper.MyBillsEntityDataFactory(j, this.size), BackpressureHelper.MyBillsEntityDataFactory(this.skip - this.size, j - 1)));
                    return;
                }
                this.upstream.request(BackpressureHelper.MyBillsEntityDataFactory(this.skip, j));
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            C c = this.buffer;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) ObjectHelper.PlaceComponentResult(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c;
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c);
                }
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            if (c != null) {
                this.downstream.onNext(c);
            }
            this.downstream.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        long produced;
        final int size;
        final int skip;
        Subscription upstream;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public final boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (!SubscriptionHelper.validate(j) || QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2(j, this.downstream, this.buffers, this, this)) {
                return;
            }
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                this.upstream.request(BackpressureHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.size, BackpressureHelper.MyBillsEntityDataFactory(this.skip, j - 1)));
                return;
            }
            this.upstream.request(BackpressureHelper.MyBillsEntityDataFactory(this.skip, j));
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((Collection) ObjectHelper.PlaceComponentResult(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.downstream.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j = this.produced;
            if (j != 0) {
                BackpressureHelper.PlaceComponentResult(this, j);
            }
            QueueDrainHelper.MyBillsEntityDataFactory(this.downstream, this.buffers, this, this);
        }
    }
}
