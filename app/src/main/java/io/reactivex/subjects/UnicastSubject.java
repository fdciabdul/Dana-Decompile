package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends Subject<T> {
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<Observer<? super T>> MyBillsEntityDataFactory;
    final BasicIntQueueDisposable<T> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final boolean PlaceComponentResult;
    volatile boolean getAuthRequestContext;
    final AtomicReference<Runnable> getErrorConfigVersion;
    final AtomicBoolean lookAheadTest;
    final SpscLinkedArrayQueue<T> moveToNextValue;
    Throwable scheduleImpl;

    @CheckReturnValue
    public static <T> UnicastSubject<T> PlaceComponentResult() {
        return new UnicastSubject<>(bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return new UnicastSubject<>(i);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> PlaceComponentResult(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable);
    }

    private UnicastSubject(int i) {
        this.moveToNextValue = new SpscLinkedArrayQueue<>(ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint"));
        this.getErrorConfigVersion = new AtomicReference<>();
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = new AtomicReference<>();
        this.lookAheadTest = new AtomicBoolean();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new UnicastQueueDisposable();
    }

    private UnicastSubject(int i, Runnable runnable) {
        this.moveToNextValue = new SpscLinkedArrayQueue<>(ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint"));
        this.getErrorConfigVersion = new AtomicReference<>(ObjectHelper.PlaceComponentResult(runnable, "onTerminate"));
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = new AtomicReference<>();
        this.lookAheadTest = new AtomicBoolean();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new UnicastQueueDisposable();
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        if (!this.lookAheadTest.get() && this.lookAheadTest.compareAndSet(false, true)) {
            observer.onSubscribe(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.MyBillsEntityDataFactory.lazySet(observer);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.MyBillsEntityDataFactory.lazySet(null);
                return;
            } else {
                BuiltInFictitiousFunctionClassFactory();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    final void getAuthRequestContext() {
        Runnable runnable = this.getErrorConfigVersion.get();
        if (runnable == null || !LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, runnable, null)) {
            return;
        }
        runnable.run();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.getAuthRequestContext || this.BuiltInFictitiousFunctionClassFactory) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext || this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.moveToNextValue.offer(t);
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext || this.BuiltInFictitiousFunctionClassFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.scheduleImpl = th;
        this.getAuthRequestContext = true;
        getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.getAuthRequestContext || this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.getAuthRequestContext = true;
        getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory();
    }

    private boolean MyBillsEntityDataFactory(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.scheduleImpl;
        if (th != null) {
            this.MyBillsEntityDataFactory.lazySet(null);
            simpleQueue.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.MyBillsEntityDataFactory.get();
        int i = 1;
        while (observer == null) {
            i = this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAndGet(-i);
            if (i == 0) {
                return;
            }
            observer = this.MyBillsEntityDataFactory.get();
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.moveToNextValue;
            boolean z = this.PlaceComponentResult;
            int i2 = 1;
            while (!this.BuiltInFictitiousFunctionClassFactory) {
                boolean z2 = this.getAuthRequestContext;
                if ((!z) == true && z2 && MyBillsEntityDataFactory(spscLinkedArrayQueue, observer)) {
                    return;
                }
                observer.onNext(null);
                if (!z2) {
                    i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    this.MyBillsEntityDataFactory.lazySet(null);
                    Throwable th = this.scheduleImpl;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
            }
            this.MyBillsEntityDataFactory.lazySet(null);
            return;
        }
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.moveToNextValue;
        boolean z3 = this.PlaceComponentResult;
        boolean z4 = true;
        int i3 = 1;
        while (!this.BuiltInFictitiousFunctionClassFactory) {
            boolean z5 = this.getAuthRequestContext;
            Object obj = (T) this.moveToNextValue.poll();
            boolean z6 = obj == null;
            if (z5) {
                if ((!z3) != false && z4) {
                    if (MyBillsEntityDataFactory(spscLinkedArrayQueue2, observer)) {
                        return;
                    }
                    z4 = false;
                }
                if (z6) {
                    this.MyBillsEntityDataFactory.lazySet(null);
                    Throwable th2 = this.scheduleImpl;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
            }
            if (!z6) {
                observer.onNext(obj);
            } else {
                i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        this.MyBillsEntityDataFactory.lazySet(null);
        spscLinkedArrayQueue2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
            UnicastSubject.this = r1;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            return UnicastSubject.this.moveToNextValue.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return UnicastSubject.this.moveToNextValue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            UnicastSubject.this.moveToNextValue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (UnicastSubject.this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            UnicastSubject.this.BuiltInFictitiousFunctionClassFactory = true;
            UnicastSubject.this.getAuthRequestContext();
            UnicastSubject.this.MyBillsEntityDataFactory.lazySet(null);
            if (UnicastSubject.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndIncrement() == 0) {
                UnicastSubject.this.MyBillsEntityDataFactory.lazySet(null);
                if (UnicastSubject.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                UnicastSubject.this.moveToNextValue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return UnicastSubject.this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
