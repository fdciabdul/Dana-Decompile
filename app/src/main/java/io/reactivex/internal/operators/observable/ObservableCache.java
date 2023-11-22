package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] BuiltInFictitiousFunctionClassFactory = new CacheDisposable[0];
    static final CacheDisposable[] PlaceComponentResult = new CacheDisposable[0];
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    volatile boolean MyBillsEntityDataFactory;
    Throwable NetworkUserEntityData$$ExternalSyntheticLambda0;
    Node<T> NetworkUserEntityData$$ExternalSyntheticLambda1;
    final Node<T> getErrorConfigVersion;
    int initRecordTimeStamp;
    final AtomicBoolean lookAheadTest;
    volatile long moveToNextValue;
    final AtomicReference<CacheDisposable<T>[]> scheduleImpl;

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
    }

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.lookAheadTest = new AtomicBoolean();
        Node<T> node = new Node<>(i);
        this.getErrorConfigVersion = node;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = node;
        this.scheduleImpl = new AtomicReference<>(BuiltInFictitiousFunctionClassFactory);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(observer, this);
        observer.onSubscribe(cacheDisposable);
        do {
            cacheDisposableArr = this.scheduleImpl.get();
            if (cacheDisposableArr == PlaceComponentResult) {
                break;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, cacheDisposableArr, cacheDisposableArr2));
        if (!this.lookAheadTest.get() && this.lookAheadTest.compareAndSet(false, true)) {
            this.getAuthRequestContext.subscribe(this);
        } else {
            PlaceComponentResult(cacheDisposable);
        }
    }

    private void PlaceComponentResult(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j = cacheDisposable.index;
        int i = cacheDisposable.offset;
        Node<T> node = cacheDisposable.node;
        Observer<? super T> observer = cacheDisposable.downstream;
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 1;
        while (!cacheDisposable.disposed) {
            boolean z = this.MyBillsEntityDataFactory;
            boolean z2 = this.moveToNextValue == j;
            if (z && z2) {
                cacheDisposable.node = null;
                Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            } else if (!z2) {
                if (i == i2) {
                    node = node.getAuthRequestContext;
                    i = 0;
                }
                observer.onNext((Object) node.PlaceComponentResult[i]);
                i++;
                j++;
            } else {
                cacheDisposable.index = j;
                cacheDisposable.offset = i;
                cacheDisposable.node = node;
                i3 = cacheDisposable.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        cacheDisposable.node = null;
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        int i = this.initRecordTimeStamp;
        if (i == this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Node<T> node = new Node<>(i);
            node.PlaceComponentResult[0] = t;
            this.initRecordTimeStamp = 1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext = node;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = node;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult[i] = t;
            this.initRecordTimeStamp = i + 1;
        }
        this.moveToNextValue++;
        for (CacheDisposable<T> cacheDisposable : this.scheduleImpl.get()) {
            PlaceComponentResult(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = th;
        this.MyBillsEntityDataFactory = true;
        for (CacheDisposable<T> cacheDisposable : this.scheduleImpl.getAndSet(PlaceComponentResult)) {
            PlaceComponentResult(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.MyBillsEntityDataFactory = true;
        for (CacheDisposable<T> cacheDisposable : this.scheduleImpl.getAndSet(PlaceComponentResult)) {
            PlaceComponentResult(cacheDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.getErrorConfigVersion;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            CacheDisposable<T>[] cacheDisposableArr;
            CacheDisposable[] cacheDisposableArr2;
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            ObservableCache<T> observableCache = this.parent;
            do {
                cacheDisposableArr = observableCache.scheduleImpl.get();
                int length = cacheDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cacheDisposableArr[i] == this) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    cacheDisposableArr2 = ObservableCache.BuiltInFictitiousFunctionClassFactory;
                } else {
                    CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                    System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                    System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                    cacheDisposableArr2 = cacheDisposableArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(observableCache.scheduleImpl, cacheDisposableArr, cacheDisposableArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Node<T> {
        final T[] PlaceComponentResult;
        volatile Node<T> getAuthRequestContext;

        Node(int i) {
            this.PlaceComponentResult = (T[]) new Object[i];
        }
    }
}
