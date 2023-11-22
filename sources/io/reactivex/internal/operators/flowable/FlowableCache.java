package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    final AtomicReference<CacheSubscription<T>[]> GetContactSyncConfig;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    Node<T> NetworkUserEntityData$$ExternalSyntheticLambda1;
    int NetworkUserEntityData$$ExternalSyntheticLambda2;
    final Node<T> getErrorConfigVersion;
    Throwable lookAheadTest;
    volatile boolean moveToNextValue;
    volatile long scheduleImpl;
    static final CacheSubscription[] getAuthRequestContext = new CacheSubscription[0];
    static final CacheSubscription[] MyBillsEntityDataFactory = new CacheSubscription[0];

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        CacheSubscription<T> cacheSubscription = new CacheSubscription<>(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        do {
            cacheSubscriptionArr = this.GetContactSyncConfig.get();
            if (cacheSubscriptionArr == MyBillsEntityDataFactory) {
                break;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new CacheSubscription[length + 1];
            System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, cacheSubscriptionArr, cacheSubscriptionArr2));
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.compareAndSet(false, true)) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2((CacheSubscription) cacheSubscription);
        }
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(CacheSubscription<T> cacheSubscription) {
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j = cacheSubscription.index;
        int i = cacheSubscription.offset;
        Node<T> node = cacheSubscription.node;
        AtomicLong atomicLong = cacheSubscription.requested;
        Subscriber<? super T> subscriber = cacheSubscription.downstream;
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 1;
        while (true) {
            boolean z = this.moveToNextValue;
            boolean z2 = this.scheduleImpl == j;
            if (z && z2) {
                cacheSubscription.node = null;
                Throwable th = this.lookAheadTest;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z2) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    cacheSubscription.node = null;
                    return;
                } else if (j2 != j) {
                    if (i == i2) {
                        node = node.BuiltInFictitiousFunctionClassFactory;
                        i = 0;
                    }
                    subscriber.onNext((Object) node.KClassImpl$Data$declaredNonStaticMembers$2[i]);
                    i++;
                    j++;
                }
            }
            cacheSubscription.index = j;
            cacheSubscription.offset = i;
            cacheSubscription.node = node;
            i3 = cacheSubscription.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        subscription.request(LongCompanionObject.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Node<T> node = new Node<>(i);
            node.KClassImpl$Data$declaredNonStaticMembers$2[0] = t;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory = node;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = node;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2[i] = t;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i + 1;
        }
        this.scheduleImpl++;
        for (CacheSubscription<T> cacheSubscription : this.GetContactSyncConfig.get()) {
            KClassImpl$Data$declaredNonStaticMembers$2((CacheSubscription) cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.moveToNextValue) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.lookAheadTest = th;
        this.moveToNextValue = true;
        for (CacheSubscription<T> cacheSubscription : this.GetContactSyncConfig.getAndSet(MyBillsEntityDataFactory)) {
            KClassImpl$Data$declaredNonStaticMembers$2((CacheSubscription) cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.moveToNextValue = true;
        for (CacheSubscription<T> cacheSubscription : this.GetContactSyncConfig.getAndSet(MyBillsEntityDataFactory)) {
            KClassImpl$Data$declaredNonStaticMembers$2((CacheSubscription) cacheSubscription);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.getErrorConfigVersion;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.MyBillsEntityDataFactory(this.requested, j);
                this.parent.KClassImpl$Data$declaredNonStaticMembers$2((CacheSubscription) this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            CacheSubscription<T>[] cacheSubscriptionArr;
            CacheSubscription[] cacheSubscriptionArr2;
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                FlowableCache<T> flowableCache = this.parent;
                do {
                    cacheSubscriptionArr = flowableCache.GetContactSyncConfig.get();
                    int length = cacheSubscriptionArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (cacheSubscriptionArr[i] == this) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        cacheSubscriptionArr2 = FlowableCache.getAuthRequestContext;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[length - 1];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                        System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(flowableCache.GetContactSyncConfig, cacheSubscriptionArr, cacheSubscriptionArr2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Node<T> {
        volatile Node<T> BuiltInFictitiousFunctionClassFactory;
        final T[] KClassImpl$Data$declaredNonStaticMembers$2;

        Node(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (T[]) new Object[i];
        }
    }
}
