package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    final AtomicLong DatabaseTableConfigUtil;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    volatile boolean MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    final BasicIntQueueSubscription<T> NetworkUserEntityData$$ExternalSyntheticLambda2;
    final AtomicReference<Subscriber<? super T>> getAuthRequestContext;
    final AtomicBoolean getErrorConfigVersion;
    Throwable lookAheadTest;
    final AtomicReference<Runnable> moveToNextValue;
    final SpscLinkedArrayQueue<T> scheduleImpl;

    @CheckReturnValue
    public static <T> UnicastProcessor<T> PlaceComponentResult() {
        return new UnicastProcessor<>(Flowable.PlaceComponentResult);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> MyBillsEntityDataFactory(int i) {
        return new UnicastProcessor<>(i);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> MyBillsEntityDataFactory(int i, Runnable runnable) {
        ObjectHelper.PlaceComponentResult(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    private UnicastProcessor(int i) {
        this(i, null, (byte) 0);
    }

    private UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, (byte) 0);
    }

    private UnicastProcessor(int i, Runnable runnable, byte b) {
        this.scheduleImpl = new SpscLinkedArrayQueue<>(ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint"));
        this.moveToNextValue = new AtomicReference<>(runnable);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getAuthRequestContext = new AtomicReference<>();
        this.getErrorConfigVersion = new AtomicBoolean();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new UnicastQueueSubscription();
        this.DatabaseTableConfigUtil = new AtomicLong();
    }

    final void MyBillsEntityDataFactory() {
        long j;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.getAuthRequestContext.get();
        int i = 1;
        while (subscriber == null) {
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda2.addAndGet(-i);
            if (i == 0) {
                return;
            }
            subscriber = this.getAuthRequestContext.get();
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.scheduleImpl;
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = 1;
            while (!this.BuiltInFictitiousFunctionClassFactory) {
                boolean z2 = this.MyBillsEntityDataFactory;
                if ((!z) != false && z2 && this.lookAheadTest != null) {
                    spscLinkedArrayQueue.clear();
                    this.getAuthRequestContext.lazySet(null);
                    subscriber.onError(this.lookAheadTest);
                    return;
                }
                subscriber.onNext(null);
                if (z2) {
                    this.getAuthRequestContext.lazySet(null);
                    Throwable th = this.lookAheadTest;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            this.getAuthRequestContext.lazySet(null);
            return;
        }
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.scheduleImpl;
        boolean z3 = !this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 1;
        do {
            long j2 = this.DatabaseTableConfigUtil.get();
            long j3 = 0;
            while (true) {
                if (j2 == j3) {
                    j = j3;
                    break;
                }
                boolean z4 = this.MyBillsEntityDataFactory;
                Object obj = (T) spscLinkedArrayQueue2.poll();
                boolean z5 = obj == null;
                j = j3;
                if (!PlaceComponentResult(z3, z4, z5, subscriber, spscLinkedArrayQueue2)) {
                    if (z5) {
                        break;
                    }
                    subscriber.onNext(obj);
                    j3 = j + 1;
                } else {
                    return;
                }
            }
            if (j2 == j && PlaceComponentResult(z3, this.MyBillsEntityDataFactory, spscLinkedArrayQueue2.isEmpty(), subscriber, spscLinkedArrayQueue2)) {
                return;
            }
            if (j != 0 && j2 != LongCompanionObject.MAX_VALUE) {
                this.DatabaseTableConfigUtil.addAndGet(-j);
            }
            i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.addAndGet(-i3);
        } while (i3 != 0);
    }

    private boolean PlaceComponentResult(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            spscLinkedArrayQueue.clear();
            this.getAuthRequestContext.lazySet(null);
            return true;
        } else if (z2) {
            if (z && this.lookAheadTest != null) {
                spscLinkedArrayQueue.clear();
                this.getAuthRequestContext.lazySet(null);
                subscriber.onError(this.lookAheadTest);
                return true;
            } else if (z3) {
                Throwable th = this.lookAheadTest;
                this.getAuthRequestContext.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.MyBillsEntityDataFactory || this.BuiltInFictitiousFunctionClassFactory) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.MyBillsEntityDataFactory || this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.scheduleImpl.offer(t);
        MyBillsEntityDataFactory();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.MyBillsEntityDataFactory || this.BuiltInFictitiousFunctionClassFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.lookAheadTest = th;
        this.MyBillsEntityDataFactory = true;
        Runnable andSet = this.moveToNextValue.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
        MyBillsEntityDataFactory();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.MyBillsEntityDataFactory || this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        Runnable andSet = this.moveToNextValue.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
        MyBillsEntityDataFactory();
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        if (!this.getErrorConfigVersion.get() && this.getErrorConfigVersion.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.getAuthRequestContext.set(subscriber);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.getAuthRequestContext.lazySet(null);
                return;
            } else {
                MyBillsEntityDataFactory();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    /* loaded from: classes6.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            return UnicastProcessor.this.scheduleImpl.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return UnicastProcessor.this.scheduleImpl.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            UnicastProcessor.this.scheduleImpl.clear();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                return 2;
            }
            return 0;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(UnicastProcessor.this.DatabaseTableConfigUtil, j);
                UnicastProcessor.this.MyBillsEntityDataFactory();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (UnicastProcessor.this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            UnicastProcessor.this.BuiltInFictitiousFunctionClassFactory = true;
            Runnable andSet = UnicastProcessor.this.moveToNextValue.getAndSet(null);
            if (andSet != null) {
                andSet.run();
            }
            UnicastProcessor.this.getAuthRequestContext.lazySet(null);
            if (UnicastProcessor.this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAndIncrement() == 0) {
                UnicastProcessor.this.getAuthRequestContext.lazySet(null);
                if (UnicastProcessor.this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    return;
                }
                UnicastProcessor.this.scheduleImpl.clear();
            }
        }
    }
}
