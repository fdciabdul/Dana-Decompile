package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final boolean getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
        try {
            ((Publisher) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    /* loaded from: classes9.dex */
    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final Subscriber<? super R> KClassImpl$Data$declaredNonStaticMembers$2;
        final MulticastProcessor<?> getAuthRequestContext;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
            this.getAuthRequestContext = multicastProcessor;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(R r) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(r);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            this.getAuthRequestContext.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
            this.getAuthRequestContext.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
            this.getAuthRequestContext.dispose();
        }
    }

    /* loaded from: classes9.dex */
    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] BuiltInFictitiousFunctionClassFactory = new MulticastSubscription[0];
        static final MulticastSubscription[] KClassImpl$Data$declaredNonStaticMembers$2 = new MulticastSubscription[0];
        int MyBillsEntityDataFactory;
        Throwable NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda1;
        final boolean getAuthRequestContext;
        final int getErrorConfigVersion;
        final int lookAheadTest;
        volatile SimpleQueue<T> moveToNextValue;
        volatile boolean scheduleImpl;
        final AtomicInteger NetworkUserEntityData$$ExternalSyntheticLambda2 = new AtomicInteger();
        final AtomicReference<Subscription> initRecordTimeStamp = new AtomicReference<>();
        final AtomicReference<MulticastSubscription<T>[]> GetContactSyncConfig = new AtomicReference<>(BuiltInFictitiousFunctionClassFactory);

        MulticastProcessor(int i, boolean z) {
            this.lookAheadTest = i;
            this.getErrorConfigVersion = i - (i >> 2);
            this.getAuthRequestContext = z;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.initRecordTimeStamp, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = requestFusion;
                        this.moveToNextValue = queueSubscription;
                        this.scheduleImpl = true;
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    } else if (requestFusion == 2) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = requestFusion;
                        this.moveToNextValue = queueSubscription;
                        QueueDrainHelper.MyBillsEntityDataFactory(subscription, this.lookAheadTest);
                        return;
                    }
                }
                this.moveToNextValue = QueueDrainHelper.MyBillsEntityDataFactory(this.lookAheadTest);
                QueueDrainHelper.MyBillsEntityDataFactory(subscription, this.lookAheadTest);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.initRecordTimeStamp);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAndIncrement() != 0 || (simpleQueue = this.moveToNextValue) == null) {
                return;
            }
            simpleQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.initRecordTimeStamp.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.scheduleImpl) {
                return;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == 0 && !this.moveToNextValue.offer(t)) {
                this.initRecordTimeStamp.get().cancel();
                onError(new MissingBackpressureException());
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.scheduleImpl) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = th;
            this.scheduleImpl = true;
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.scheduleImpl) {
                return;
            }
            this.scheduleImpl = true;
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        private boolean getAuthRequestContext(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.GetContactSyncConfig.get();
                if (multicastSubscriptionArr == KClassImpl$Data$declaredNonStaticMembers$2) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        final void MyBillsEntityDataFactory(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.GetContactSyncConfig.get();
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
                    multicastSubscriptionArr2 = BuiltInFictitiousFunctionClassFactory;
                } else {
                    MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                    System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.Flowable
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (getAuthRequestContext(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    MyBillsEntityDataFactory(multicastSubscription);
                    return;
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
            }
            Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            MulticastSubscription<T>[] multicastSubscriptionArr;
            Throwable th;
            Throwable th2;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.moveToNextValue;
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.getErrorConfigVersion;
            boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1 != 1;
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.GetContactSyncConfig;
            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference2.get();
            int i3 = 1;
            while (true) {
                int length = multicastSubscriptionArr2.length;
                if (simpleQueue == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr2.length;
                    long j = LongCompanionObject.MAX_VALUE;
                    long j2 = Long.MAX_VALUE;
                    int i4 = 0;
                    while (i4 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr2[i4];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j3 == Long.MIN_VALUE) {
                            length--;
                        } else if (j2 > j3) {
                            j2 = j3;
                        }
                        i4++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (length == 0) {
                        j2 = 0;
                    }
                    while (j2 != j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z2 = this.scheduleImpl;
                        if (z2 && !this.getAuthRequestContext && (th2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                            KClassImpl$Data$declaredNonStaticMembers$2(th2);
                            return;
                        }
                        try {
                            T poll = simpleQueue.poll();
                            boolean z3 = poll == null;
                            if (!z2 || !z3) {
                                if (z3) {
                                    break;
                                }
                                int length3 = multicastSubscriptionArr2.length;
                                int i5 = 0;
                                boolean z4 = false;
                                while (i5 < length3) {
                                    MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr2[i5];
                                    long j5 = multicastSubscription2.get();
                                    if (j5 != Long.MIN_VALUE) {
                                        if (j5 != j) {
                                            multicastSubscription2.emitted++;
                                        }
                                        multicastSubscription2.downstream.onNext(poll);
                                    } else {
                                        z4 = true;
                                    }
                                    i5++;
                                    j = LongCompanionObject.MAX_VALUE;
                                }
                                j2--;
                                if (z && (i = i + 1) == i2) {
                                    this.initRecordTimeStamp.get().request(i2);
                                    i = 0;
                                }
                                multicastSubscriptionArr = atomicReference.get();
                                if (!z4 && multicastSubscriptionArr == multicastSubscriptionArr2) {
                                    j4 = 0;
                                    j = LongCompanionObject.MAX_VALUE;
                                }
                                multicastSubscriptionArr2 = multicastSubscriptionArr;
                                atomicReference2 = atomicReference;
                            } else {
                                Throwable th3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                if (th3 != null) {
                                    KClassImpl$Data$declaredNonStaticMembers$2(th3);
                                    return;
                                } else {
                                    PlaceComponentResult();
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            Exceptions.MyBillsEntityDataFactory(th4);
                            SubscriptionHelper.cancel(this.initRecordTimeStamp);
                            KClassImpl$Data$declaredNonStaticMembers$2(th4);
                            return;
                        }
                    }
                    if (j2 == j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z5 = this.scheduleImpl;
                        if (z5 && !this.getAuthRequestContext && (th = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                            KClassImpl$Data$declaredNonStaticMembers$2(th);
                            return;
                        } else if (z5 && simpleQueue.isEmpty()) {
                            Throwable th5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (th5 != null) {
                                KClassImpl$Data$declaredNonStaticMembers$2(th5);
                                return;
                            } else {
                                PlaceComponentResult();
                                return;
                            }
                        }
                    }
                }
                this.MyBillsEntityDataFactory = i;
                i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.moveToNextValue;
                }
                multicastSubscriptionArr = atomicReference.get();
                multicastSubscriptionArr2 = multicastSubscriptionArr;
                atomicReference2 = atomicReference;
            }
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
            for (MulticastSubscription<T> multicastSubscription : this.GetContactSyncConfig.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        private void PlaceComponentResult() {
            for (MulticastSubscription<T> multicastSubscription : this.GetContactSyncConfig.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.MyBillsEntityDataFactory(this, j);
                this.parent.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.MyBillsEntityDataFactory(this);
                this.parent.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        public final boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
