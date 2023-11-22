package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public final class ReplaySubject<T> extends Subject<T> {
    boolean BuiltInFictitiousFunctionClassFactory;
    final ReplayBuffer<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<ReplayDisposable<T>[]> PlaceComponentResult = new AtomicReference<>(MyBillsEntityDataFactory);
    static final ReplayDisposable[] MyBillsEntityDataFactory = new ReplayDisposable[0];
    static final ReplayDisposable[] getAuthRequestContext = new ReplayDisposable[0];
    private static final Object[] NetworkUserEntityData$$ExternalSyntheticLambda0 = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface ReplayBuffer<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        void replay(ReplayDisposable<T> replayDisposable);
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> BuiltInFictitiousFunctionClassFactory() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    private ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = replayBuffer;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (PlaceComponentResult(replayDisposable) && replayDisposable.cancelled) {
            BuiltInFictitiousFunctionClassFactory(replayDisposable);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.add(t);
        for (ReplayDisposable<T> replayDisposable : this.PlaceComponentResult.get()) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        ReplayDisposable<T>[] replayDisposableArr;
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.BuiltInFictitiousFunctionClassFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        Object error = NotificationLite.error(th);
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.addFinal(error);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(null, error)) {
            replayDisposableArr = this.PlaceComponentResult.getAndSet(getAuthRequestContext);
        } else {
            replayDisposableArr = getAuthRequestContext;
        }
        for (ReplayDisposable<T> replayDisposable : replayDisposableArr) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        ReplayDisposable<T>[] replayDisposableArr;
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        replayBuffer.addFinal(complete);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(null, complete)) {
            replayDisposableArr = this.PlaceComponentResult.getAndSet(getAuthRequestContext);
        } else {
            replayDisposableArr = getAuthRequestContext;
        }
        for (ReplayDisposable<T> replayDisposable : replayDisposableArr) {
            replayBuffer.replay(replayDisposable);
        }
    }

    private boolean PlaceComponentResult(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.PlaceComponentResult.get();
            if (replayDisposableArr == getAuthRequestContext) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    final void BuiltInFictitiousFunctionClassFactory(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.PlaceComponentResult.get();
            if (replayDisposableArr == getAuthRequestContext || replayDisposableArr == MyBillsEntityDataFactory) {
                return;
            }
            int length = replayDisposableArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (replayDisposableArr[i] == replayDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = MyBillsEntityDataFactory;
            } else {
                ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, replayDisposableArr, replayDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.downstream = observer;
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.BuiltInFictitiousFunctionClassFactory(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        public final void trimHead() {
        }

        UnboundedReplayBuffer(int i) {
            this.buffer = new ArrayList(ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void addFinal(Object obj) {
            this.buffer.add(obj);
            trimHead();
            this.size++;
            this.done = true;
        }

        public final T getValue() {
            int i = this.size;
            if (i != 0) {
                List<Object> list = this.buffer;
                T t = (T) list.get(i - 1);
                if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                    if (i == 1) {
                        return null;
                    }
                    return (T) list.get(i - 2);
                }
                return t;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            Observer<? super T> observer = replayDisposable.downstream;
            Integer num = (Integer) replayDisposable.index;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                replayDisposable.index = 0;
            }
            int i3 = 1;
            while (!replayDisposable.cancelled) {
                int i4 = this.size;
                while (i4 != i2) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    Object obj = list.get(i2);
                    if (this.done && (i = i2 + 1) == i4 && i == (i4 = this.size)) {
                        if (NotificationLite.isComplete(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    observer.onNext(obj);
                    i2++;
                }
                if (i2 == this.size) {
                    replayDisposable.index = Integer.valueOf(i2);
                    i3 = replayDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        public final int size() {
            int i = this.size;
            if (i != 0) {
                int i2 = i - 1;
                Object obj = this.buffer.get(i2);
                return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i2 : i;
            }
            return 0;
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
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int i) {
            this.maxSize = ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxSize");
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        final void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void add(T t) {
            Node<Object> node = new Node<>(t);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            trimHead();
            this.done = true;
        }

        public final void trimHead() {
            Node<Object> node = this.head;
            if (node.value != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
            }
        }

        public final T getValue() {
            Node<Object> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = (T) node.value;
            if (t == null) {
                return null;
            }
            return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) node2.value : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            int size = size();
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
            } else {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    node = node.get();
                    tArr[i] = node.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = replayDisposable.downstream;
            Node<T> node = (Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    Object obj = (T) node2.value;
                    if (this.done && node2.get() == null) {
                        if (NotificationLite.isComplete(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    observer.onNext(obj);
                    node = node2;
                } else if (node.get() == null) {
                    replayDisposable.index = node;
                    i = replayDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    continue;
                }
            }
            replayDisposable.index = null;
        }

        public final int size() {
            Node<Object> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    Object obj = node.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                node = node2;
            }
            return i;
        }
    }

    /* loaded from: classes9.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.maxSize = ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxSize");
            this.maxAge = ObjectHelper.BuiltInFictitiousFunctionClassFactory(j, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        final void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit);
            long j = this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now - j) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        final void trimFinal() {
            long now = this.scheduler.now(this.unit);
            long j = this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.value != null) {
                        TimedNode<Object> timedNode3 = new TimedNode<>(null, 0L);
                        timedNode3.lazySet(timedNode.get());
                        this.head = timedNode3;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now - j) {
                    if (timedNode.value != null) {
                        TimedNode<Object> timedNode4 = new TimedNode<>(null, 0L);
                        timedNode4.lazySet(timedNode.get());
                        this.head = timedNode4;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void add(T t) {
            TimedNode<Object> timedNode = new TimedNode<>(t, this.scheduler.now(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, LongCompanionObject.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        public final void trimHead() {
            TimedNode<Object> timedNode = this.head;
            if (timedNode.value != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0L);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }

        public final T getValue() {
            T t;
            TimedNode<Object> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.time >= this.scheduler.now(this.unit) - this.maxAge && (t = (T) timedNode.value) != null) {
                return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) timedNode2.value : t;
            }
            return null;
        }

        final TimedNode<Object> getHead() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit);
            long j = this.maxAge;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > now - j) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T[] getValues(T[] tArr) {
            TimedNode<T> head = getHead();
            int size = size(head);
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
            } else {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    head = head.get();
                    tArr[i] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public final void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = replayDisposable.downstream;
            TimedNode<T> timedNode = (TimedNode) replayDisposable.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            int i = 1;
            while (true) {
                timedNode = timedNode;
                if (replayDisposable.cancelled) {
                    replayDisposable.index = null;
                    return;
                }
                while (!replayDisposable.cancelled) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 != null) {
                        Object obj = (T) timedNode2.value;
                        if (this.done && timedNode2.get() == null) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(obj);
                        timedNode = timedNode2;
                    } else if (timedNode.get() == null) {
                        replayDisposable.index = timedNode;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
                return;
            }
        }

        public final int size() {
            return size(getHead());
        }

        final int size(TimedNode<Object> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    Object obj = timedNode.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                timedNode = timedNode2;
            }
            return i;
        }
    }
}
