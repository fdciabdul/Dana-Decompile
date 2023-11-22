package io.reactivex.processors;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    final Lock DatabaseTableConfigUtil;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<Object> NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicReference<>();
    final AtomicReference<Throwable> getErrorConfigVersion;
    final AtomicReference<BehaviorSubscription<T>[]> lookAheadTest;
    final Lock moveToNextValue;
    final ReadWriteLock scheduleImpl;
    static final Object[] getAuthRequestContext = new Object[0];
    static final BehaviorSubscription[] BuiltInFictitiousFunctionClassFactory = new BehaviorSubscription[0];
    static final BehaviorSubscription[] MyBillsEntityDataFactory = new BehaviorSubscription[0];

    BehaviorProcessor() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.scheduleImpl = reentrantReadWriteLock;
        this.moveToNextValue = reentrantReadWriteLock.readLock();
        this.DatabaseTableConfigUtil = reentrantReadWriteLock.writeLock();
        this.lookAheadTest = new AtomicReference<>(BuiltInFictitiousFunctionClassFactory);
        this.getErrorConfigVersion = new AtomicReference<>();
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (PlaceComponentResult((BehaviorSubscription) behaviorSubscription)) {
            if (behaviorSubscription.cancelled) {
                BuiltInFictitiousFunctionClassFactory((BehaviorSubscription) behaviorSubscription);
                return;
            } else {
                behaviorSubscription.emitFirst();
                return;
            }
        }
        Throwable th = this.getErrorConfigVersion.get();
        if (th == ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.getErrorConfigVersion.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getErrorConfigVersion.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        BuiltInFictitiousFunctionClassFactory(next);
        for (BehaviorSubscription<T> behaviorSubscription : this.lookAheadTest.get()) {
            behaviorSubscription.emitNext(next, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, null, th)) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorSubscription<T> behaviorSubscription : PlaceComponentResult(error)) {
            behaviorSubscription.emitNext(error, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, null, ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : PlaceComponentResult(complete)) {
                behaviorSubscription.emitNext(complete, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    private boolean PlaceComponentResult(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.lookAheadTest.get();
            if (behaviorSubscriptionArr == MyBillsEntityDataFactory) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    final void BuiltInFictitiousFunctionClassFactory(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.lookAheadTest.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (behaviorSubscriptionArr[i] == behaviorSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = BuiltInFictitiousFunctionClassFactory;
            } else {
                BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i);
                System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr3, i, (length - i) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    private BehaviorSubscription<T>[] PlaceComponentResult(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = this.lookAheadTest.get();
        BehaviorSubscription<T>[] behaviorSubscriptionArr2 = MyBillsEntityDataFactory;
        if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = this.lookAheadTest.getAndSet(behaviorSubscriptionArr2)) != behaviorSubscriptionArr2) {
            BuiltInFictitiousFunctionClassFactory(obj);
        }
        return behaviorSubscriptionArr;
    }

    private void BuiltInFictitiousFunctionClassFactory(Object obj) {
        Lock lock = this.DatabaseTableConfigUtil;
        lock.lock();
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.lazySet(obj);
        lock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.downstream = subscriber;
            this.state = behaviorProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this, j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.BuiltInFictitiousFunctionClassFactory((BehaviorSubscription) this);
        }

        final void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.moveToNextValue;
                lock.lock();
                this.index = behaviorProcessor.KClassImpl$Data$declaredNonStaticMembers$2;
                Object obj = behaviorProcessor.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        final void emitNext(Object obj, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.getAuthRequestContext(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.downstream.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.downstream.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.downstream.onNext((Object) NotificationLite.getValue(obj));
                    if (j != LongCompanionObject.MAX_VALUE) {
                        decrementAndGet();
                        return false;
                    }
                    return false;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }

        final void emitLoop() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            while (!this.cancelled) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(this);
            }
        }

        public final boolean isFull() {
            return get() == 0;
        }
    }
}
