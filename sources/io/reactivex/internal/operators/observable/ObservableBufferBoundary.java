package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final ObservableSource<? extends Open> BuiltInFictitiousFunctionClassFactory;
    final Callable<U> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> PlaceComponentResult;

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
        this.PlaceComponentResult = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        observer.onSubscribe(bufferBoundaryObserver);
        this.getAuthRequestContext.subscribe(bufferBoundaryObserver);
    }

    /* loaded from: classes9.dex */
    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
        final ObservableSource<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super C> downstream;
        long index;
        final SpscLinkedArrayQueue<C> queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final CompositeDisposable observers = new CompositeDisposable();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.downstream = observer;
            this.bufferSupplier = callable;
            this.bufferOpen = observableSource;
            this.bufferClose = function;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.upstream, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.getAuthRequestContext(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void open(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
                    this.observers.getAuthRequestContext(bufferCloseObserver);
                    observableSource.subscribe(bufferCloseObserver);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                DisposableHelper.dispose(this.upstream);
                onError(th);
            }
        }

        final void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.MyBillsEntityDataFactory(bufferOpenObserver);
            if (this.observers.getAuthRequestContext() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }

        final void close(BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            boolean z;
            this.observers.MyBillsEntityDataFactory(bufferCloseObserver);
            if (this.observers.getAuthRequestContext() == 0) {
                DisposableHelper.dispose(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        final void boundaryError(Disposable disposable, Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.observers.MyBillsEntityDataFactory(disposable);
            onError(th);
        }

        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super C> observer = this.downstream;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.errors.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.errors.terminate());
                    return;
                }
                C poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    observer.onComplete();
                    return;
                } else if (!z2) {
                    observer.onNext(poll);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        /* loaded from: classes9.dex */
        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> parent;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.Observer
            public final void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundaryObserver<T, C, ?, ?> parent;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.parent = bufferBoundaryObserver;
            this.index = j;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            Disposable disposable = get();
            if (disposable != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                disposable.dispose();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (get() != DisposableHelper.DISPOSED) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }
    }
}
