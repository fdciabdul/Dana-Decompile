package io.reactivex.internal.operators.parallel;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {
    final BiFunction<T, T, T> BuiltInFictitiousFunctionClassFactory;
    final ParallelFlowable<? extends T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.MyBillsEntityDataFactory.getAuthRequestContext(), this.BuiltInFictitiousFunctionClassFactory);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.MyBillsEntityDataFactory.getAuthRequestContext(parallelReduceFullMainSubscriber.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<T>> current;
        final AtomicReference<Throwable> error;
        final BiFunction<T, T, T> reducer;
        final AtomicInteger remaining;
        final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelReduceFullInnerSubscriberArr[i2] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = biFunction;
            this.remaining.lazySet(i);
        }

        final SlotPair<T> addValue(T t) {
            SlotPair<T> slotPair;
            int tryAcquireSlot;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.current, null, slotPair)) {
                        continue;
                    }
                }
                tryAcquireSlot = slotPair.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.current, slotPair, null);
            }
            if (tryAcquireSlot == 0) {
                slotPair.first = t;
            } else {
                slotPair.second = t;
            }
            if (slotPair.releaseSlot()) {
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.current, slotPair, null);
                return slotPair;
            }
            return null;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public final void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.cancel();
            }
        }

        final void innerError(Throwable th) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.error, null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.error.get()) {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            if (r2.remaining.decrementAndGet() != 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        
            r3 = r2.current.get();
            r2.current.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r3 == null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        
            complete(r3.first);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        
            r2.downstream.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:2:0x0000, code lost:
        
            if (r3 != null) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
        
            r3 = addValue(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        
            if (r3 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        
            r3 = (T) io.reactivex.internal.functions.ObjectHelper.PlaceComponentResult(r2.reducer.apply(r3.first, r3.second), "The reducer returned a null value");
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        
            io.reactivex.exceptions.Exceptions.MyBillsEntityDataFactory(r3);
            innerError(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void innerComplete(T r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L21
            L2:
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = r2.addValue(r3)
                if (r3 == 0) goto L21
                io.reactivex.functions.BiFunction<T, T, T> r0 = r2.reducer     // Catch: java.lang.Throwable -> L19
                T r1 = r3.first     // Catch: java.lang.Throwable -> L19
                T r3 = r3.second     // Catch: java.lang.Throwable -> L19
                java.lang.Object r3 = r0.apply(r1, r3)     // Catch: java.lang.Throwable -> L19
                java.lang.String r0 = "The reducer returned a null value"
                java.lang.Object r3 = io.reactivex.internal.functions.ObjectHelper.PlaceComponentResult(r3, r0)     // Catch: java.lang.Throwable -> L19
                goto L2
            L19:
                r3 = move-exception
                io.reactivex.exceptions.Exceptions.MyBillsEntityDataFactory(r3)
                r2.innerError(r3)
                return
            L21:
                java.util.concurrent.atomic.AtomicInteger r3 = r2.remaining
                int r3 = r3.decrementAndGet()
                if (r3 != 0) goto L44
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r3 = r2.current
                java.lang.Object r3 = r3.get()
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = (io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair) r3
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r0 = r2.current
                r1 = 0
                r0.lazySet(r1)
                if (r3 == 0) goto L3f
                T r3 = r3.first
                r2.complete(r3)
                return
            L3f:
                org.reactivestreams.Subscriber<? super T> r3 = r2.downstream
                r3.onComplete()
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber.innerComplete(java.lang.Object):void");
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final ParallelReduceFullMainSubscriber<T> parent;
        final BiFunction<T, T, T> reducer;
        T value;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) ObjectHelper.PlaceComponentResult(this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.done = true;
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        final void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        SlotPair() {
        }

        final int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }

        final boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }
    }
}
