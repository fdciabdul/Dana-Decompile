package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    static final Callable BuiltInFictitiousFunctionClassFactory = new DefaultUnboundedFactory();
    final Callable<? extends ReplayBuffer<T>> KClassImpl$Data$declaredNonStaticMembers$2;
    final Publisher<T> MyBillsEntityDataFactory;
    final AtomicReference<ReplaySubscriber<T>> getAuthRequestContext;
    final Flowable<T> scheduleImpl;

    /* loaded from: classes9.dex */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    public static <T> ConnectableFlowable<T> PlaceComponentResult(Flowable<? extends T> flowable) {
        return BuiltInFictitiousFunctionClassFactory(flowable, BuiltInFictitiousFunctionClassFactory);
    }

    public static <T> ConnectableFlowable<T> MyBillsEntityDataFactory(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return BuiltInFictitiousFunctionClassFactory(flowable, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    private static <T> ConnectableFlowable<T> BuiltInFictitiousFunctionClassFactory(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.MyBillsEntityDataFactory(new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.MyBillsEntityDataFactory = publisher;
        this.scheduleImpl = flowable;
        this.getAuthRequestContext = atomicReference;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.MyBillsEntityDataFactory.subscribe(subscriber);
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public final void MyBillsEntityDataFactory(Disposable disposable) {
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, (ReplaySubscriber) disposable, null);
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.getAuthRequestContext.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.KClassImpl$Data$declaredNonStaticMembers$2.call());
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.MyBillsEntityDataFactory(th);
                RuntimeException MyBillsEntityDataFactory = ExceptionHelper.MyBillsEntityDataFactory(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z) {
                this.scheduleImpl.getAuthRequestContext(replaySubscriber);
            }
        } catch (Throwable th) {
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
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
                    } else if (innerSubscriptionArr[i].equals(innerSubscription)) {
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        final void manageRequests() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (!isDisposed()) {
                InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j = this.maxChildRequested;
                long j2 = j;
                for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    j2 = Math.max(j2, innerSubscription.totalRequested.get());
                }
                long j3 = this.maxUpstreamRequested;
                Subscription subscription = get();
                long j4 = j2 - j;
                if (j4 != 0) {
                    this.maxChildRequested = j2;
                    if (subscription == null) {
                        long j5 = j3 + j4;
                        if (j5 < 0) {
                            j5 = LongCompanionObject.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j5;
                    } else if (j3 != 0) {
                        this.maxUpstreamRequested = 0L;
                        subscription.request(j3 + j4);
                    } else {
                        subscription.request(j4);
                    }
                } else if (j3 != 0 && subscription != null) {
                    this.maxUpstreamRequested = 0L;
                    subscription.request(j3);
                }
                i = this.management.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (!SubscriptionHelper.validate(j) || BackpressureHelper.MyBillsEntityDataFactory(this, j) == Long.MIN_VALUE) {
                return;
            }
            BackpressureHelper.getAuthRequestContext(this.totalRequested, j);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }

        public final long produced(long j) {
            return BackpressureHelper.KClassImpl$Data$declaredNonStaticMembers$2(this, j);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        final <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: classes9.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                Subscriber<? super T> subscriber = innerSubscription.child;
                while (!innerSubscription.isDisposed()) {
                    int i = this.size;
                    Integer num = (Integer) innerSubscription.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = innerSubscription.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            innerSubscription.dispose();
                            if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                                return;
                            }
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        innerSubscription.index = Integer.valueOf(intValue);
                        if (j != LongCompanionObject.MAX_VALUE) {
                            innerSubscription.produced(j3);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* loaded from: classes9.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        void truncate() {
        }

        BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
            Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        final void setFirst(Node node) {
            set(node);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                while (!innerSubscription.isDisposed()) {
                    long j = innerSubscription.get();
                    boolean z = j == LongCompanionObject.MAX_VALUE;
                    Node node2 = (Node) innerSubscription.index();
                    if (node2 == null) {
                        node2 = getHead();
                        innerSubscription.index = node2;
                        BackpressureHelper.getAuthRequestContext(innerSubscription.totalRequested, node2.index);
                    }
                    long j2 = 0;
                    while (j != 0 && (node = node2.get()) != null) {
                        Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (NotificationLite.accept(leaveTransform, innerSubscription.child)) {
                                innerSubscription.index = null;
                                return;
                            }
                            j2++;
                            j--;
                            if (innerSubscription.isDisposed()) {
                                innerSubscription.index = null;
                                return;
                            }
                            node2 = node;
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            innerSubscription.index = null;
                            innerSubscription.dispose();
                            if (NotificationLite.isError(leaveTransform) || NotificationLite.isComplete(leaveTransform)) {
                                return;
                            }
                            innerSubscription.child.onError(th);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.index = node2;
                        if (!z) {
                            innerSubscription.produced(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
                innerSubscription.index = null;
            }
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(head.value);
                if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                    return;
                }
                collection.add((Object) NotificationLite.getValue(leaveTransform));
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return get();
        }
    }

    /* loaded from: classes9.dex */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        final void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        final Object enterTransform(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        final Object leaveTransform(Object obj) {
            return ((Timed) obj).MyBillsEntityDataFactory;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        final void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit);
            long j = this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                } else if (this.size > this.limit && this.size > 1) {
                    i++;
                    this.size--;
                    node3 = node2.get();
                } else if (((Timed) node2.value).getAuthRequestContext > now - j) {
                    break;
                } else {
                    i++;
                    this.size--;
                    node3 = node2.get();
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        
            setFirst(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void truncateFinal() {
            /*
                r14 = this;
                io.reactivex.Scheduler r0 = r14.scheduler
                java.util.concurrent.TimeUnit r1 = r14.unit
                long r0 = r0.now(r1)
                long r2 = r14.maxAge
                java.lang.Object r4 = r14.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r4 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r4
                java.lang.Object r5 = r4.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
            L17:
                r13 = r5
                r5 = r4
                r4 = r13
                if (r4 == 0) goto L3b
                int r7 = r14.size
                r8 = 1
                if (r7 <= r8) goto L3b
                java.lang.Object r7 = r4.value
                io.reactivex.schedulers.Timed r7 = (io.reactivex.schedulers.Timed) r7
                long r9 = r7.getAuthRequestContext
                long r11 = r0 - r2
                int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r7 > 0) goto L3b
                int r6 = r6 + 1
                int r5 = r14.size
                int r5 = r5 - r8
                r14.size = r5
                java.lang.Object r5 = r4.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r5
                goto L17
            L3b:
                if (r6 == 0) goto L40
                r14.setFirst(r5)
            L40:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        final Node getHead() {
            Node node;
            long now = this.scheduler.now(this.unit);
            long j = this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                Timed timed = (Timed) node2.value;
                if (NotificationLite.isComplete(timed.MyBillsEntityDataFactory) || NotificationLite.isError(timed.MyBillsEntityDataFactory) || timed.getAuthRequestContext > now - j) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }
    }

    public static <T> ConnectableFlowable<T> PlaceComponentResult(Flowable<T> flowable, int i) {
        if (i != Integer.MAX_VALUE) {
            return BuiltInFictitiousFunctionClassFactory(flowable, new ReplayBufferTask(i));
        }
        return BuiltInFictitiousFunctionClassFactory(flowable, BuiltInFictitiousFunctionClassFactory);
    }

    /* loaded from: classes9.dex */
    static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Callable<? extends ConnectableFlowable<U>> BuiltInFictitiousFunctionClassFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> MyBillsEntityDataFactory;

        @Override // io.reactivex.Flowable
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(connectableFlowable), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.MyBillsEntityDataFactory(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }

        /* loaded from: classes9.dex */
        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> MyBillsEntityDataFactory;

            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Disposable disposable) throws Exception {
                this.MyBillsEntityDataFactory.setResource(disposable);
            }

            DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.MyBillsEntityDataFactory = subscriberResourceWrapper;
            }
        }
    }

    public static <T> ConnectableFlowable<T> MyBillsEntityDataFactory(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return BuiltInFictitiousFunctionClassFactory(flowable, new ScheduledReplayBufferTask(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    /* loaded from: classes9.dex */
    static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ConnectableFlowable<T> getAuthRequestContext;

        @Override // io.reactivex.flowables.ConnectableFlowable
        public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
            this.getAuthRequestContext.MyBillsEntityDataFactory(consumer);
        }

        @Override // io.reactivex.Flowable
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(subscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int PlaceComponentResult;

        ReplayBufferTask(int i) {
            this.PlaceComponentResult = i;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return new SizeBoundReplayBuffer(this.PlaceComponentResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final TimeUnit BuiltInFictitiousFunctionClassFactory;
        private final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private final long getAuthRequestContext;

        ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = j;
            this.BuiltInFictitiousFunctionClassFactory = timeUnit;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return new SizeAndTimeBoundReplayBuffer(this.PlaceComponentResult, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> KClassImpl$Data$declaredNonStaticMembers$2;
        private final AtomicReference<ReplaySubscriber<T>> MyBillsEntityDataFactory;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.MyBillsEntityDataFactory = atomicReference;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
        }

        @Override // org.reactivestreams.Publisher
        public final void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.MyBillsEntityDataFactory.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.KClassImpl$Data$declaredNonStaticMembers$2.call());
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
            subscriber.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.remove(innerSubscription);
                return;
            }
            replaySubscriber.manageRequests();
            replaySubscriber.buffer.replay(innerSubscription);
        }
    }

    /* loaded from: classes9.dex */
    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
