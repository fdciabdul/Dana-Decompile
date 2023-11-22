package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final Callable<? extends ObservableSource<B>> MyBillsEntityDataFactory;
    final int PlaceComponentResult;

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i) {
        super(observableSource);
        this.MyBillsEntityDataFactory = callable;
        this.PlaceComponentResult = i;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        this.getAuthRequestContext.subscribe(new WindowBoundaryMainObserver(observer, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        static final WindowBoundaryInnerObserver<Object, Object> BOUNDARY_DISPOSED = new WindowBoundaryInnerObserver<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        final Callable<? extends ObservableSource<B>> other;
        Disposable upstream;
        UnicastSubject<T> window;
        final AtomicReference<WindowBoundaryInnerObserver<T, B>> boundaryObserver = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i, Callable<? extends ObservableSource<B>> callable) {
            this.downstream = observer;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            disposeBoundary();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void disposeBoundary() {
            AtomicReference<WindowBoundaryInnerObserver<T, B>> atomicReference = this.boundaryObserver;
            WindowBoundaryInnerObserver<Object, Object> windowBoundaryInnerObserver = BOUNDARY_DISPOSED;
            Disposable disposable = (Disposable) atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (disposable == null || disposable == windowBoundaryInnerObserver) {
                return;
            }
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        final void innerNext(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.boundaryObserver, windowBoundaryInnerObserver, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        final void innerError(Throwable th) {
            this.upstream.dispose();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        final void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z = this.done;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                } else if (!z2) {
                    if (poll != NEXT_WINDOW) {
                        unicastSubject.onNext(poll);
                    } else {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            UnicastSubject<T> PlaceComponentResult = UnicastSubject.PlaceComponentResult(this.capacityHint, this);
                            this.window = PlaceComponentResult;
                            this.windows.getAndIncrement();
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.other.call(), "The other Callable returned a null ObservableSource");
                                WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.boundaryObserver, null, windowBoundaryInnerObserver)) {
                                    observableSource.subscribe(windowBoundaryInnerObserver);
                                    observer.onNext(PlaceComponentResult);
                                }
                            } catch (Throwable th) {
                                Exceptions.MyBillsEntityDataFactory(th);
                                atomicThrowable.addThrowable(th);
                                this.done = true;
                            }
                        }
                    }
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        boolean BuiltInFictitiousFunctionClassFactory;
        final WindowBoundaryMainObserver<T, B> KClassImpl$Data$declaredNonStaticMembers$2;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public final void onNext(B b) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.innerNext(this);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.innerError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.innerComplete();
        }
    }
}
