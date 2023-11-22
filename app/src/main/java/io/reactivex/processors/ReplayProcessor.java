package io.reactivex.processors;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    final ReplayBuffer<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<ReplaySubscription<T>[]> NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean getAuthRequestContext;
    private static final Object[] scheduleImpl = new Object[0];
    static final ReplaySubscription[] MyBillsEntityDataFactory = new ReplaySubscription[0];
    static final ReplaySubscription[] BuiltInFictitiousFunctionClassFactory = new ReplaySubscription[0];

    /* loaded from: classes9.dex */
    interface ReplayBuffer<T> {
        void KClassImpl$Data$declaredNonStaticMembers$2(ReplaySubscription<T> replaySubscription);

        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th);

        void getAuthRequestContext();

        void getAuthRequestContext(T t);
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (PlaceComponentResult(replaySubscription) && replaySubscription.cancelled) {
            BuiltInFictitiousFunctionClassFactory(replaySubscription);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.getAuthRequestContext) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.getAuthRequestContext(t);
        for (ReplaySubscription<T> replaySubscription : this.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
            replayBuffer.KClassImpl$Data$declaredNonStaticMembers$2(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.getAuthRequestContext = true;
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.KClassImpl$Data$declaredNonStaticMembers$2(th);
        for (ReplaySubscription<T> replaySubscription : this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndSet(BuiltInFictitiousFunctionClassFactory)) {
            replayBuffer.KClassImpl$Data$declaredNonStaticMembers$2(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = true;
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.getAuthRequestContext();
        for (ReplaySubscription<T> replaySubscription : this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndSet(BuiltInFictitiousFunctionClassFactory)) {
            replayBuffer.KClassImpl$Data$declaredNonStaticMembers$2(replaySubscription);
        }
    }

    private boolean PlaceComponentResult(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
            if (replaySubscriptionArr == BuiltInFictitiousFunctionClassFactory) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    final void BuiltInFictitiousFunctionClassFactory(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
            if (replaySubscriptionArr == BuiltInFictitiousFunctionClassFactory || replaySubscriptionArr == MyBillsEntityDataFactory) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (replaySubscriptionArr[i] == replaySubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = MyBillsEntityDataFactory;
            } else {
                ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, replaySubscriptionArr, replaySubscriptionArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.downstream = subscriber;
            this.state = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                this.state.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.BuiltInFictitiousFunctionClassFactory(this);
        }
    }

    /* loaded from: classes9.dex */
    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> BuiltInFictitiousFunctionClassFactory;
        volatile int KClassImpl$Data$declaredNonStaticMembers$2;
        volatile boolean MyBillsEntityDataFactory;
        Throwable PlaceComponentResult;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext(T t) {
            this.BuiltInFictitiousFunctionClassFactory.add(t);
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
            this.PlaceComponentResult = th;
            this.MyBillsEntityDataFactory = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext() {
            this.MyBillsEntityDataFactory = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.BuiltInFictitiousFunctionClassFactory;
            Subscriber<? super T> subscriber = replaySubscription.downstream;
            Integer num = (Integer) replaySubscription.index;
            int i = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                replaySubscription.index = 0;
            }
            long j = replaySubscription.emitted;
            int i2 = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.MyBillsEntityDataFactory;
                    int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!z || i != i3) {
                        if (i == i3) {
                            break;
                        }
                        subscriber.onNext(list.get(i));
                        i++;
                        j++;
                    } else {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th = this.PlaceComponentResult;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z2 = this.MyBillsEntityDataFactory;
                    int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (z2 && i == i4) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.PlaceComponentResult;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = Integer.valueOf(i);
                replaySubscription.emitted = j;
                i2 = replaySubscription.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes9.dex */
    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        final int BuiltInFictitiousFunctionClassFactory;
        Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        volatile Node<T> MyBillsEntityDataFactory;
        int PlaceComponentResult;
        volatile boolean getAuthRequestContext;
        Node<T> getErrorConfigVersion;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.getErrorConfigVersion;
            this.getErrorConfigVersion = node;
            this.PlaceComponentResult++;
            node2.set(node);
            int i = this.PlaceComponentResult;
            if (i > this.BuiltInFictitiousFunctionClassFactory) {
                this.PlaceComponentResult = i - 1;
                this.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
            MyBillsEntityDataFactory();
            this.getAuthRequestContext = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext() {
            MyBillsEntityDataFactory();
            this.getAuthRequestContext = true;
        }

        private void MyBillsEntityDataFactory() {
            if (this.MyBillsEntityDataFactory.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.MyBillsEntityDataFactory.get());
                this.MyBillsEntityDataFactory = node;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.downstream;
            Node<T> node = (Node) replaySubscription.index;
            if (node == null) {
                node = this.MyBillsEntityDataFactory;
            }
            long j = replaySubscription.emitted;
            int i = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.getAuthRequestContext;
                    Node<T> node2 = node.get();
                    boolean z2 = node2 == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext((T) node2.value);
                        j++;
                        node = node2;
                    } else {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else if (this.getAuthRequestContext && node.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = node;
                replaySubscription.emitted = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }
    }

    /* loaded from: classes9.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean BuiltInFictitiousFunctionClassFactory;
        volatile TimedNode<T> KClassImpl$Data$declaredNonStaticMembers$2;
        Throwable MyBillsEntityDataFactory;
        final int PlaceComponentResult;
        final long getAuthRequestContext;
        final TimeUnit getErrorConfigVersion;
        int lookAheadTest;
        TimedNode<T> moveToNextValue;
        final Scheduler scheduleImpl;

        private void BuiltInFictitiousFunctionClassFactory() {
            long now = this.scheduleImpl.now(this.getErrorConfigVersion);
            long j = this.getAuthRequestContext;
            TimedNode<T> timedNode = this.KClassImpl$Data$declaredNonStaticMembers$2;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = new TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode;
                        return;
                    }
                } else if (timedNode2.time > now - j) {
                    if (timedNode.value != null) {
                        TimedNode<T> timedNode3 = new TimedNode<>(null, 0L);
                        timedNode3.lazySet(timedNode.get());
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode3;
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.scheduleImpl.now(this.getErrorConfigVersion));
            TimedNode<T> timedNode2 = this.moveToNextValue;
            this.moveToNextValue = timedNode;
            this.lookAheadTest++;
            timedNode2.set(timedNode);
            int i = this.lookAheadTest;
            if (i > this.PlaceComponentResult) {
                this.lookAheadTest = i - 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            }
            long now = this.scheduleImpl.now(this.getErrorConfigVersion);
            long j = this.getAuthRequestContext;
            TimedNode<T> timedNode3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            while (this.lookAheadTest > 1) {
                TimedNode<T> timedNode4 = timedNode3.get();
                if (timedNode4 == null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode3;
                    return;
                } else if (timedNode4.time > now - j) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode3;
                    return;
                } else {
                    this.lookAheadTest--;
                    timedNode3 = timedNode4;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timedNode3;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
            BuiltInFictitiousFunctionClassFactory();
            this.MyBillsEntityDataFactory = th;
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void getAuthRequestContext() {
            BuiltInFictitiousFunctionClassFactory();
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.downstream;
            TimedNode<T> timedNode = (TimedNode) replaySubscription.index;
            if (timedNode == null) {
                timedNode = this.KClassImpl$Data$declaredNonStaticMembers$2;
                long now = this.scheduleImpl.now(this.getErrorConfigVersion);
                long j = this.getAuthRequestContext;
                TimedNode<T> timedNode2 = timedNode.get();
                while (timedNode2 != null && timedNode2.time <= now - j) {
                    TimedNode<T> timedNode3 = timedNode2;
                    timedNode2 = timedNode2.get();
                    timedNode = timedNode3;
                }
            }
            long j2 = replaySubscription.emitted;
            int i = 1;
            do {
                long j3 = replaySubscription.requested.get();
                while (j2 != j3) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.BuiltInFictitiousFunctionClassFactory;
                    TimedNode<T> timedNode4 = timedNode.get();
                    boolean z2 = timedNode4 == null;
                    if (!z || !z2) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext((T) timedNode4.value);
                        j2++;
                        timedNode = timedNode4;
                    } else {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th = this.MyBillsEntityDataFactory;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                }
                if (j2 == j3) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    } else if (this.BuiltInFictitiousFunctionClassFactory && timedNode.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.MyBillsEntityDataFactory;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = timedNode;
                replaySubscription.emitted = j2;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }
    }
}
