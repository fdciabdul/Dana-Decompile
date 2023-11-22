package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final boolean BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends K> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super T, ? extends V> MyBillsEntityDataFactory;
    final int PlaceComponentResult;

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        this.MyBillsEntityDataFactory = function2;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.getAuthRequestContext.subscribe(new GroupByObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        final Observer<? super GroupedObservable<K, V>> downstream;
        final Function<? super T, ? extends K> keySelector;
        Disposable upstream;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, GroupedUnicast<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
            this.downstream = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            lazySet(1);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            try {
                K apply = this.keySelector.apply(t);
                Object obj = apply != null ? apply : NULL_KEY;
                GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    groupedUnicast = GroupedUnicast.MyBillsEntityDataFactory(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, groupedUnicast);
                    getAndIncrement();
                    this.downstream.onNext(groupedUnicast);
                }
                try {
                    groupedUnicast.getAuthRequestContext.onNext(ObjectHelper.PlaceComponentResult(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).getAuthRequestContext.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).getAuthRequestContext.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        public final void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> getAuthRequestContext;

        public static <T, K> GroupedUnicast<K, T> MyBillsEntityDataFactory(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupByObserver, k, z));
        }

        private GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.getAuthRequestContext = state;
        }

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super T> observer) {
            this.getAuthRequestContext.subscribe(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.actual.lazySet(observer);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z = this.delayError;
            Observer<? super T> observer = this.actual.get();
            int i = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z2 = this.done;
                        Object obj = (T) spscLinkedArrayQueue.poll();
                        boolean z3 = obj == null;
                        if (!checkTerminated(z2, z3, observer, z)) {
                            if (z3) {
                                break;
                            }
                            observer.onNext(obj);
                        } else {
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (observer == null) {
                    observer = this.actual.get();
                }
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        this.actual.lazySet(null);
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    this.actual.lazySet(null);
                    observer.onError(th2);
                    return true;
                } else if (z2) {
                    this.actual.lazySet(null);
                    observer.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
