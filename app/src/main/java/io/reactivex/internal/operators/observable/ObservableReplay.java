package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {
    static final BufferSupplier getAuthRequestContext = new UnBoundedFactory();
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;
    final BufferSupplier<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<T> MyBillsEntityDataFactory;
    final AtomicReference<ReplayObserver<T>> PlaceComponentResult;

    /* loaded from: classes9.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes9.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    public static <U, R> Observable<R> PlaceComponentResult(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> KClassImpl$Data$declaredNonStaticMembers$2(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.getAuthRequestContext(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    public static <T> ConnectableObservable<T> getAuthRequestContext(ObservableSource<? extends T> observableSource) {
        return PlaceComponentResult(observableSource, getAuthRequestContext);
    }

    public static <T> ConnectableObservable<T> PlaceComponentResult(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return PlaceComponentResult(observableSource, new ScheduledReplaySupplier(i, j, timeUnit, scheduler));
    }

    private static <T> ConnectableObservable<T> PlaceComponentResult(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.getAuthRequestContext(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.MyBillsEntityDataFactory = observableSource2;
        this.PlaceComponentResult = atomicReference;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bufferSupplier;
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public final void MyBillsEntityDataFactory(Disposable disposable) {
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, (ReplayObserver) disposable, null);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(observer);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.PlaceComponentResult.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replayObserver);
            if (z) {
                this.MyBillsEntityDataFactory.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.MyBillsEntityDataFactory(th);
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        final boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.observers, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        final void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerDisposableArr[i].equals(innerDisposable)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = EMPTY;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.observers, innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                replay();
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                replayFinal();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        final void replay() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.replay(innerDisposable);
            }
        }

        final void replayFinal() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final Observer<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = innerDisposable.child;
            int i = 1;
            while (!innerDisposable.isDisposed()) {
                int i2 = this.size;
                Integer num = (Integer) innerDisposable.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i2) {
                    if (NotificationLite.accept(get(intValue), observer) || innerDisposable.isDisposed()) {
                        return;
                    }
                    intValue++;
                }
                innerDisposable.index = Integer.valueOf(intValue);
                i = innerDisposable.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        abstract void truncate();

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                Node node = (Node) innerDisposable.index();
                if (node == null) {
                    node = getHead();
                    innerDisposable.index = node;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node2 = node.get();
                    if (node2 != null) {
                        if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        node = node2;
                    } else {
                        innerDisposable.index = node;
                        i = innerDisposable.addAndGet(-i);
                    }
                }
                innerDisposable.index = null;
                return;
            } while (i != 0);
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        final Object enterTransform(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        final Object leaveTransform(Object obj) {
            return ((Timed) obj).MyBillsEntityDataFactory;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
        
            setFirst(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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
                io.reactivex.internal.operators.observable.ObservableReplay$Node r4 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r4
                java.lang.Object r5 = r4.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r5 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r5
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
                io.reactivex.internal.operators.observable.ObservableReplay$Node r5 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r5
                goto L17
            L3b:
                if (r6 == 0) goto L40
                r14.setFirst(r5)
            L40:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

    /* loaded from: classes9.dex */
    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public final ReplayBuffer<Object> BuiltInFictitiousFunctionClassFactory() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: classes9.dex */
    static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Disposable disposable) throws Exception {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setResource(disposable);
        }

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observerResourceWrapper;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        private final int PlaceComponentResult;

        ReplayBufferSupplier(int i) {
            this.PlaceComponentResult = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public final ReplayBuffer<T> BuiltInFictitiousFunctionClassFactory() {
            return new SizeBoundReplayBuffer(this.PlaceComponentResult);
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
        private final Scheduler MyBillsEntityDataFactory;
        private final long PlaceComponentResult;
        private final int getAuthRequestContext;

        ScheduledReplaySupplier(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
            this.MyBillsEntityDataFactory = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public final ReplayBuffer<T> BuiltInFictitiousFunctionClassFactory() {
            return new SizeAndTimeBoundReplayBuffer(this.getAuthRequestContext, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        }
    }

    /* loaded from: classes9.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> PlaceComponentResult;
        private final AtomicReference<ReplayObserver<T>> getAuthRequestContext;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.getAuthRequestContext = atomicReference;
            this.PlaceComponentResult = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.getAuthRequestContext.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            replayObserver.add(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class MulticastReplay<R, U> extends Observable<R> {
        private final Callable<? extends ConnectableObservable<U>> BuiltInFictitiousFunctionClassFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> KClassImpl$Data$declaredNonStaticMembers$2;

        MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.BuiltInFictitiousFunctionClassFactory = callable;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.MyBillsEntityDataFactory(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, observer);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class Replay<T> extends ConnectableObservable<T> {
        private final Observable<T> BuiltInFictitiousFunctionClassFactory;
        private final ConnectableObservable<T> KClassImpl$Data$declaredNonStaticMembers$2;

        Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = connectableObservable;
            this.BuiltInFictitiousFunctionClassFactory = observable;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(consumer);
        }

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super T> observer) {
            this.BuiltInFictitiousFunctionClassFactory.subscribe(observer);
        }
    }

    public static <T> ConnectableObservable<T> getAuthRequestContext(ObservableSource<T> observableSource, int i) {
        if (i != Integer.MAX_VALUE) {
            return PlaceComponentResult(observableSource, new ReplayBufferSupplier(i));
        }
        return PlaceComponentResult(observableSource, getAuthRequestContext);
    }

    public static <T> ConnectableObservable<T> PlaceComponentResult(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return PlaceComponentResult(observableSource, new ScheduledReplaySupplier(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }
}
