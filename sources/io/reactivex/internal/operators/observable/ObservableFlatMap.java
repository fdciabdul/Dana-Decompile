package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final Function<? super T, ? extends ObservableSource<? extends U>> PlaceComponentResult;

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.PlaceComponentResult = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.MyBillsEntityDataFactory(this.getAuthRequestContext, observer, this.PlaceComponentResult)) {
            return;
        }
        this.getAuthRequestContext.subscribe(new MergeObserver(observer, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                ObservableSource<? extends U> observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.wip;
                        if (i == this.maxConcurrency) {
                            this.sources.offer(observableSource);
                            return;
                        }
                        this.wip = i + 1;
                    }
                }
                subscribeInner(observableSource);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        final void subscribeInner(ObservableSource<? extends U> observableSource) {
            ObservableSource<? extends U> poll;
            while (observableSource instanceof Callable) {
                if (!tryEmitScalar((Callable) observableSource) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    poll = this.sources.poll();
                    if (poll == null) {
                        this.wip--;
                        z = true;
                    }
                }
                if (z) {
                    drain();
                    return;
                }
                observableSource = poll;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (addInner(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        final boolean addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        final void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerObserverArr[i] == innerObserver) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.observers, innerObserverArr, innerObserverArr2));
        }

        final boolean tryEmitScalar(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue<U> simplePlainQueue = this.queue;
                    if (simplePlainQueue == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
                        }
                        this.queue = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.errors.addThrowable(th);
                drain();
                return true;
            }
        }

        final void tryEmit(U u, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = innerObserver.queue;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.bufferSize);
                    innerObserver.queue = simpleQueue;
                }
                simpleQueue.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Throwable terminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            RxJavaPlugins.PlaceComponentResult(terminate);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a1, code lost:
        
            if (r11 != null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00a3, code lost:
        
            r12 = (U) r11.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
        
            if (r12 == null) goto L131;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
        
            r0.onNext(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00b0, code lost:
        
            if (checkTerminate() == false) goto L132;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00b2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00b3, code lost:
        
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00b4, code lost:
        
            io.reactivex.exceptions.Exceptions.MyBillsEntityDataFactory(r11);
            r10.dispose();
            r14.errors.addThrowable(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00c3, code lost:
        
            if (checkTerminate() != false) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00c5, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
        
            removeInner(r10);
            r4 = r4 + 1;
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00cd, code lost:
        
            if (r7 != r6) goto L129;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00d0, code lost:
        
            r11 = r10.done;
            r12 = r10.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00d4, code lost:
        
            if (r11 == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00d6, code lost:
        
            if (r12 == null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
        
            if (r12.isEmpty() == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00de, code lost:
        
            removeInner(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00e5, code lost:
        
            if (checkTerminate() == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x00e7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00e8, code lost:
        
            r4 = r4 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x00ea, code lost:
        
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x00ec, code lost:
        
            if (r7 != r6) goto L130;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x00ee, code lost:
        
            r7 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x00ef, code lost:
        
            r3 = r3 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void drainLoop() {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.drainLoop():void");
        }

        final boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            Throwable terminate = this.errors.terminate();
            if (terminate != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        final boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id  reason: collision with root package name */
        final long f8250id;
        final MergeObserver<T, U> parent;
        volatile SimpleQueue<U> queue;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.f8250id = j;
            this.parent = mergeObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.parent.errors.addThrowable(th)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
