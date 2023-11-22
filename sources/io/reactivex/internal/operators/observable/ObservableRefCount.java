package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableRefCount<T> extends Observable<T> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final ConnectableObservable<T> MyBillsEntityDataFactory;
    final long PlaceComponentResult;
    RefConnection getAuthRequestContext;
    final TimeUnit getErrorConfigVersion;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, TimeUnit.NANOSECONDS);
    }

    private ObservableRefCount(ConnectableObservable<T> connectableObservable, TimeUnit timeUnit) {
        this.MyBillsEntityDataFactory = connectableObservable;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        this.PlaceComponentResult = 0L;
        this.getErrorConfigVersion = timeUnit;
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.getAuthRequestContext;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.getAuthRequestContext = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.KClassImpl$Data$declaredNonStaticMembers$2) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.MyBillsEntityDataFactory.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(refConnection);
        }
    }

    final void MyBillsEntityDataFactory(RefConnection refConnection) {
        synchronized (this) {
            if (this.MyBillsEntityDataFactory instanceof ObservablePublishClassic) {
                RefConnection refConnection2 = this.getAuthRequestContext;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.getAuthRequestContext = null;
                    if (refConnection.timer != null) {
                        refConnection.timer.dispose();
                        refConnection.timer = null;
                    }
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    BuiltInFictitiousFunctionClassFactory(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.getAuthRequestContext;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    if (refConnection.timer != null) {
                        refConnection.timer.dispose();
                        refConnection.timer = null;
                    }
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.getAuthRequestContext = null;
                        BuiltInFictitiousFunctionClassFactory(refConnection);
                    }
                }
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(RefConnection refConnection) {
        ConnectableObservable<T> connectableObservable = this.MyBillsEntityDataFactory;
        if (connectableObservable instanceof Disposable) {
            ((Disposable) connectableObservable).dispose();
        } else if (connectableObservable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableObservable).MyBillsEntityDataFactory(refConnection.get());
        }
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.getAuthRequestContext) {
                this.getAuthRequestContext = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableObservable<T> connectableObservable = this.MyBillsEntityDataFactory;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).MyBillsEntityDataFactory(disposable);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.parent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.MyBillsEntityDataFactory).MyBillsEntityDataFactory(disposable);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.MyBillsEntityDataFactory(this.connection);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.MyBillsEntityDataFactory(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                ObservableRefCount<T> observableRefCount = this.parent;
                RefConnection refConnection = this.connection;
                synchronized (observableRefCount) {
                    RefConnection refConnection2 = observableRefCount.getAuthRequestContext;
                    if (refConnection2 == null || refConnection2 != refConnection) {
                        return;
                    }
                    long j = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j;
                    if (j == 0 && refConnection.connected) {
                        if (observableRefCount.PlaceComponentResult == 0) {
                            observableRefCount.KClassImpl$Data$declaredNonStaticMembers$2(refConnection);
                            return;
                        }
                        SequentialDisposable sequentialDisposable = new SequentialDisposable();
                        refConnection.timer = sequentialDisposable;
                        sequentialDisposable.replace(observableRefCount.BuiltInFictitiousFunctionClassFactory.scheduleDirect(refConnection, observableRefCount.PlaceComponentResult, observableRefCount.getErrorConfigVersion));
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
