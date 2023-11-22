package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int BuiltInFictitiousFunctionClassFactory;
    final ObservableSource<B> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super B, ? extends ObservableSource<V>> MyBillsEntityDataFactory;

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource2;
        this.MyBillsEntityDataFactory = function;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        this.getAuthRequestContext.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        Disposable DatabaseTableConfigUtil;
        final CompositeDisposable GetContactSyncConfig;
        final Function<? super B, ? extends ObservableSource<V>> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final AtomicLong NetworkUserEntityData$$ExternalSyntheticLambda1;
        final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        final ObservableSource<B> getErrorConfigVersion;
        final List<UnicastSubject<T>> initRecordTimeStamp;
        final int lookAheadTest;
        final AtomicReference<Disposable> scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final void MyBillsEntityDataFactory(Observer<? super Observable<T>> observer, Object obj) {
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i) {
            super(observer, new MpscLinkedQueue());
            this.scheduleImpl = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = atomicLong;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new AtomicBoolean();
            this.getErrorConfigVersion = observableSource;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = function;
            this.lookAheadTest = i;
            this.GetContactSyncConfig = new CompositeDisposable();
            this.initRecordTimeStamp = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.DatabaseTableConfigUtil, disposable)) {
                this.DatabaseTableConfigUtil = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.get()) {
                    return;
                }
                OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, null, operatorWindowBoundaryOpenObserver)) {
                    this.getErrorConfigVersion.subscribe(operatorWindowBoundaryOpenObserver);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (BuiltInFictitiousFunctionClassFactory()) {
                Iterator<UnicastSubject<T>> it = this.initRecordTimeStamp.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (this.moveToNextValue.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.getAuthRequestContext.offer(NotificationLite.next(t));
                if (!MyBillsEntityDataFactory()) {
                    return;
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = th;
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.decrementAndGet() == 0) {
                this.GetContactSyncConfig.dispose();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.decrementAndGet() == 0) {
                this.GetContactSyncConfig.dispose();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.scheduleImpl);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.decrementAndGet() == 0) {
                    this.DatabaseTableConfigUtil.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
        }

        final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.getAuthRequestContext;
            Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<UnicastSubject<T>> list = this.initRecordTimeStamp;
            int i = 1;
            while (true) {
                boolean z = this.MyBillsEntityDataFactory;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    this.GetContactSyncConfig.dispose();
                    DisposableHelper.dispose(this.scheduleImpl);
                    Throwable th = this.BuiltInFictitiousFunctionClassFactory;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (!z2) {
                    if (poll instanceof WindowOperation) {
                        WindowOperation windowOperation = (WindowOperation) poll;
                        if (windowOperation.PlaceComponentResult != null) {
                            if (list.remove(windowOperation.PlaceComponentResult)) {
                                windowOperation.PlaceComponentResult.onComplete();
                                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.decrementAndGet() == 0) {
                                    this.GetContactSyncConfig.dispose();
                                    DisposableHelper.dispose(this.scheduleImpl);
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2.get()) {
                            UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2 = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
                            list.add(KClassImpl$Data$declaredNonStaticMembers$2);
                            observer.onNext(KClassImpl$Data$declaredNonStaticMembers$2);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0.apply((B) windowOperation.getAuthRequestContext), "The ObservableSource supplied is null");
                                OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, KClassImpl$Data$declaredNonStaticMembers$2);
                                if (this.GetContactSyncConfig.getAuthRequestContext(operatorWindowBoundaryCloseObserver)) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAndIncrement();
                                    observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                                }
                            } catch (Throwable th2) {
                                Exceptions.MyBillsEntityDataFactory(th2);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2.set(true);
                                observer.onError(th2);
                            }
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onNext((T) NotificationLite.getValue(poll));
                        }
                    }
                } else {
                    i = this.moveToNextValue.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WindowOperation<T, B> {
        final UnicastSubject<T> PlaceComponentResult;
        final B getAuthRequestContext;

        WindowOperation(UnicastSubject<T> unicastSubject, B b) {
            this.PlaceComponentResult = unicastSubject;
            this.getAuthRequestContext = b;
        }
    }

    /* loaded from: classes9.dex */
    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B, ?> PlaceComponentResult;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.PlaceComponentResult = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public final void onNext(B b) {
            WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver = this.PlaceComponentResult;
            windowBoundaryMainObserver.getAuthRequestContext.offer(new WindowOperation(null, b));
            if (windowBoundaryMainObserver.MyBillsEntityDataFactory()) {
                windowBoundaryMainObserver.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver = this.PlaceComponentResult;
            windowBoundaryMainObserver.DatabaseTableConfigUtil.dispose();
            windowBoundaryMainObserver.GetContactSyncConfig.dispose();
            windowBoundaryMainObserver.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {
        boolean MyBillsEntityDataFactory;
        final WindowBoundaryMainObserver<T, ?, V> PlaceComponentResult;
        final UnicastSubject<T> getAuthRequestContext;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.PlaceComponentResult = windowBoundaryMainObserver;
            this.getAuthRequestContext = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public final void onNext(V v) {
            dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver = this.PlaceComponentResult;
            windowBoundaryMainObserver.DatabaseTableConfigUtil.dispose();
            windowBoundaryMainObserver.GetContactSyncConfig.dispose();
            windowBoundaryMainObserver.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver = this.PlaceComponentResult;
            windowBoundaryMainObserver.GetContactSyncConfig.MyBillsEntityDataFactory(this);
            windowBoundaryMainObserver.getAuthRequestContext.offer(new WindowOperation(this.getAuthRequestContext, null));
            if (windowBoundaryMainObserver.MyBillsEntityDataFactory()) {
                windowBoundaryMainObserver.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        }
    }
}
