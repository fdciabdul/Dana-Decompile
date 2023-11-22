package io.reactivex.processors;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@SchedulerSupport("none")
@BackpressureSupport(BackpressureKind.FULL)
/* loaded from: classes3.dex */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    int BuiltInFictitiousFunctionClassFactory;
    final AtomicReference<Subscription> DatabaseTableConfigUtil;
    final AtomicInteger GetContactSyncConfig;
    final int MyBillsEntityDataFactory;
    volatile Throwable NetworkUserEntityData$$ExternalSyntheticLambda0;
    final AtomicReference<MulticastSubscription<T>[]> NetworkUserEntityData$$ExternalSyntheticLambda1;
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    final int getErrorConfigVersion;
    volatile SimpleQueue<T> initRecordTimeStamp;
    volatile boolean lookAheadTest;
    final AtomicBoolean moveToNextValue;
    int scheduleImpl;
    static final MulticastSubscription[] getAuthRequestContext = new MulticastSubscription[0];
    static final MulticastSubscription[] KClassImpl$Data$declaredNonStaticMembers$2 = new MulticastSubscription[0];

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.DatabaseTableConfigUtil, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.scheduleImpl = requestFusion;
                    this.initRecordTimeStamp = queueSubscription;
                    this.lookAheadTest = true;
                    PlaceComponentResult();
                    return;
                } else if (requestFusion == 2) {
                    this.scheduleImpl = requestFusion;
                    this.initRecordTimeStamp = queueSubscription;
                    subscription.request(this.MyBillsEntityDataFactory);
                    return;
                }
            }
            this.initRecordTimeStamp = new SpscArrayQueue(this.MyBillsEntityDataFactory);
            subscription.request(this.MyBillsEntityDataFactory);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (this.moveToNextValue.get()) {
            return;
        }
        if (this.scheduleImpl == 0) {
            ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.initRecordTimeStamp.offer(t)) {
                SubscriptionHelper.cancel(this.DatabaseTableConfigUtil);
                onError(new MissingBackpressureException());
                return;
            }
        }
        PlaceComponentResult();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.moveToNextValue.compareAndSet(false, true)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = th;
            this.lookAheadTest = true;
            PlaceComponentResult();
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.moveToNextValue.compareAndSet(false, true)) {
            this.lookAheadTest = true;
            PlaceComponentResult();
        }
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (PlaceComponentResult(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                BuiltInFictitiousFunctionClassFactory(multicastSubscription);
            } else {
                PlaceComponentResult();
            }
        } else if ((this.moveToNextValue.get() || !this.NetworkUserEntityData$$ExternalSyntheticLambda2) && (th = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    private boolean PlaceComponentResult(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
            if (multicastSubscriptionArr == KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    final void BuiltInFictitiousFunctionClassFactory(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
            int length = multicastSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (multicastSubscriptionArr[i] == multicastSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, multicastSubscriptionArr, KClassImpl$Data$declaredNonStaticMembers$2)) {
                        SubscriptionHelper.cancel(this.DatabaseTableConfigUtil);
                        this.moveToNextValue.set(true);
                        return;
                    }
                } else if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, multicastSubscriptionArr, getAuthRequestContext)) {
                    return;
                }
            } else {
                MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            }
        }
    }

    final void PlaceComponentResult() {
        T t;
        if (this.GetContactSyncConfig.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> atomicReference = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.getErrorConfigVersion;
        int i3 = this.scheduleImpl;
        int i4 = 1;
        while (true) {
            SimpleQueue<T> simpleQueue = this.initRecordTimeStamp;
            if (simpleQueue != null) {
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int length = multicastSubscriptionArr.length;
                    long j = -1;
                    long j2 = -1;
                    int i5 = 0;
                    while (i5 < length) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i5];
                        long j3 = multicastSubscription.get();
                        if (j3 >= 0) {
                            if (j2 == j) {
                                j2 = j3 - multicastSubscription.emitted;
                            } else {
                                j2 = Math.min(j2, j3 - multicastSubscription.emitted);
                            }
                        }
                        i5++;
                        j = -1;
                    }
                    int i6 = i;
                    while (j2 > 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                        if (multicastSubscriptionArr2 == KClassImpl$Data$declaredNonStaticMembers$2) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        boolean z = this.lookAheadTest;
                        try {
                            t = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            SubscriptionHelper.cancel(this.DatabaseTableConfigUtil);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = th;
                            this.lookAheadTest = true;
                            t = null;
                            z = true;
                        }
                        boolean z2 = t == null;
                        if (z && z2) {
                            Throwable th2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (th2 != null) {
                                for (MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                                    multicastSubscription2.onError(th2);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                                multicastSubscription3.onComplete();
                            }
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                            multicastSubscription4.onNext(t);
                        }
                        j2--;
                        if (i3 != 1 && (i6 = i6 + 1) == i2) {
                            this.DatabaseTableConfigUtil.get().request(i2);
                            i6 = 0;
                        }
                    }
                    if (j2 == 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                        MulticastSubscription<T>[] multicastSubscriptionArr4 = KClassImpl$Data$declaredNonStaticMembers$2;
                        if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                            simpleQueue.clear();
                            return;
                        } else if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                            i = i6;
                        } else if (this.lookAheadTest && simpleQueue.isEmpty()) {
                            Throwable th3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (th3 != null) {
                                for (MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                    multicastSubscription5.onError(th3);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                multicastSubscription6.onComplete();
                            }
                            return;
                        }
                    }
                    i = i6;
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = i;
            i4 = this.GetContactSyncConfig.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            long j2;
            long j3;
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                j3 = LongCompanionObject.MAX_VALUE;
                if (j2 == LongCompanionObject.MAX_VALUE) {
                    return;
                }
                long j4 = j2 + j;
                if (j4 >= 0) {
                    j3 = j4;
                }
            } while (!compareAndSet(j2, j3));
            this.parent.PlaceComponentResult();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.BuiltInFictitiousFunctionClassFactory(this);
            }
        }

        final void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        final void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            }
        }

        final void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
