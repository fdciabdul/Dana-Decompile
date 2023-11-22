package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> BuiltInFictitiousFunctionClassFactory;
    final Callable<? extends ObservableSource<B>> PlaceComponentResult;

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.PlaceComponentResult = callable;
        this.BuiltInFictitiousFunctionClassFactory = callable2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        this.getAuthRequestContext.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final AtomicReference<Disposable> NetworkUserEntityData$$ExternalSyntheticLambda0;
        Disposable NetworkUserEntityData$$ExternalSyntheticLambda1;
        final Callable<U> getErrorConfigVersion;
        final Callable<? extends ObservableSource<B>> lookAheadTest;
        U scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final /* synthetic */ void MyBillsEntityDataFactory(Observer observer, Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext((Collection) obj);
        }

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicReference<>();
            this.getErrorConfigVersion = callable;
            this.lookAheadTest = callable2;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda1, disposable)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = disposable;
                Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                try {
                    this.scheduleImpl = (U) ObjectHelper.PlaceComponentResult(this.getErrorConfigVersion.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.lookAheadTest.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (this.PlaceComponentResult) {
                            return;
                        }
                        observableSource.subscribe(bufferBoundaryObserver);
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.PlaceComponentResult = true;
                        disposable.dispose();
                        EmptyDisposable.error(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    this.PlaceComponentResult = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, observer);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.scheduleImpl;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            synchronized (this) {
                U u = this.scheduleImpl;
                if (u == null) {
                    return;
                }
                this.scheduleImpl = null;
                this.getAuthRequestContext.offer(u);
                this.MyBillsEntityDataFactory = true;
                if (MyBillsEntityDataFactory()) {
                    QueueDrainHelper.getAuthRequestContext(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, false, this, this);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
            DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (MyBillsEntityDataFactory()) {
                this.getAuthRequestContext.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        final void lookAheadTest() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.getErrorConfigVersion.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.lookAheadTest.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.replace(this.NetworkUserEntityData$$ExternalSyntheticLambda0, bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u2 = this.scheduleImpl;
                            if (u2 == null) {
                                return;
                            }
                            this.scheduleImpl = u;
                            observableSource.subscribe(bufferBoundaryObserver);
                            getAuthRequestContext(u2, this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.PlaceComponentResult = true;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        boolean BuiltInFictitiousFunctionClassFactory;
        final BufferBoundarySupplierObserver<T, U, B> KClassImpl$Data$declaredNonStaticMembers$2;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public final void onNext(B b) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest();
        }
    }
}
