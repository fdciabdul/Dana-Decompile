package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Callable<U> PlaceComponentResult;
    final TimeUnit moveToNextValue;
    final long scheduleImpl;

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
        this.scheduleImpl = j2;
        this.moveToNextValue = timeUnit;
        this.BuiltInFictitiousFunctionClassFactory = scheduler;
        this.PlaceComponentResult = callable;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == this.scheduleImpl && this.MyBillsEntityDataFactory == Integer.MAX_VALUE) {
            this.getAuthRequestContext.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory));
            return;
        }
        Scheduler.Worker createWorker = this.BuiltInFictitiousFunctionClassFactory.createWorker();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == this.scheduleImpl) {
            this.getAuthRequestContext.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, createWorker));
        } else {
            this.getAuthRequestContext.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.moveToNextValue, createWorker));
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        Disposable GetContactSyncConfig;
        final AtomicReference<Disposable> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final long NetworkUserEntityData$$ExternalSyntheticLambda1;
        final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda2;
        final Scheduler getErrorConfigVersion;
        U lookAheadTest;
        final Callable<U> scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final /* synthetic */ void MyBillsEntityDataFactory(Observer observer, Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext((Collection) obj);
        }

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicReference<>();
            this.scheduleImpl = callable;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = j;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = timeUnit;
            this.getErrorConfigVersion = scheduler;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.GetContactSyncConfig, disposable)) {
                this.GetContactSyncConfig = disposable;
                try {
                    this.lookAheadTest = (U) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The buffer supplied is null");
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                    if (this.PlaceComponentResult) {
                        return;
                    }
                    Scheduler scheduler = this.getErrorConfigVersion;
                    long j = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    dispose();
                    EmptyDisposable.error(th, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.lookAheadTest;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            synchronized (this) {
                this.lookAheadTest = null;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U u;
            synchronized (this) {
                u = this.lookAheadTest;
                this.lookAheadTest = null;
            }
            if (u != null) {
                this.getAuthRequestContext.offer(u);
                this.MyBillsEntityDataFactory = true;
                if (MyBillsEntityDataFactory()) {
                    QueueDrainHelper.getAuthRequestContext(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, false, null, this);
                }
            }
            DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.GetContactSyncConfig.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public final void run() {
            U u;
            try {
                U u2 = (U) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.lookAheadTest;
                    if (u != null) {
                        this.lookAheadTest = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                } else {
                    getAuthRequestContext(u, this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                dispose();
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        Disposable GetContactSyncConfig;
        final List<U> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Scheduler.Worker NetworkUserEntityData$$ExternalSyntheticLambda1;
        final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda2;
        final long getErrorConfigVersion;
        final long lookAheadTest;
        final Callable<U> scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final /* synthetic */ void MyBillsEntityDataFactory(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.scheduleImpl = callable;
            this.getErrorConfigVersion = j;
            this.lookAheadTest = j2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = timeUnit;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = worker;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.GetContactSyncConfig, disposable)) {
                this.GetContactSyncConfig = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The buffer supplied is null");
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(collection);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                    Scheduler.Worker worker = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    long j = this.lookAheadTest;
                    worker.schedulePeriodically(this, j, j, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.schedule(new RemoveFromBufferEmit(collection), this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = true;
            synchronized (this) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.getAuthRequestContext.offer((Collection) it.next());
            }
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                QueueDrainHelper.getAuthRequestContext(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, false, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            synchronized (this) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            }
            this.GetContactSyncConfig.dispose();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            if (this.PlaceComponentResult) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.PlaceComponentResult) {
                        return;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(collection);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.schedule(new RemoveFromBuffer(collection), this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                dispose();
            }
        }

        /* loaded from: classes9.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U getAuthRequestContext;

            RemoveFromBuffer(U u) {
                this.getAuthRequestContext = u;
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(this.getAuthRequestContext);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, bufferSkipBoundedObserver.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        }

        /* loaded from: classes9.dex */
        final class RemoveFromBufferEmit implements Runnable {
            private final U KClassImpl$Data$declaredNonStaticMembers$2;

            RemoveFromBufferEmit(U u) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, bufferSkipBoundedObserver.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final boolean DatabaseTableConfigUtil;
        long GetContactSyncConfig;
        long NetworkUserEntityData$$ExternalSyntheticLambda0;
        final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda1;
        final long NetworkUserEntityData$$ExternalSyntheticLambda2;
        final int getErrorConfigVersion;
        Disposable initRecordTimeStamp;
        final Scheduler.Worker isLayoutRequested;
        final Callable<U> lookAheadTest;
        Disposable newProxyInstance;
        U scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final /* synthetic */ void MyBillsEntityDataFactory(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.lookAheadTest = callable;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = j;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = timeUnit;
            this.getErrorConfigVersion = i;
            this.DatabaseTableConfigUtil = z;
            this.isLayoutRequested = worker;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.newProxyInstance, disposable)) {
                this.newProxyInstance = disposable;
                try {
                    this.scheduleImpl = (U) ObjectHelper.PlaceComponentResult(this.lookAheadTest.call(), "The buffer supplied is null");
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                    Scheduler.Worker worker = this.isLayoutRequested;
                    long j = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    this.initRecordTimeStamp = worker.schedulePeriodically(this, j, j, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.isLayoutRequested.dispose();
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
                if (u.size() < this.getErrorConfigVersion) {
                    return;
                }
                this.scheduleImpl = null;
                this.GetContactSyncConfig++;
                if (this.DatabaseTableConfigUtil) {
                    this.initRecordTimeStamp.dispose();
                }
                KClassImpl$Data$declaredNonStaticMembers$2(u, this);
                try {
                    U u2 = (U) ObjectHelper.PlaceComponentResult(this.lookAheadTest.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.scheduleImpl = u2;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
                    }
                    if (this.DatabaseTableConfigUtil) {
                        Scheduler.Worker worker = this.isLayoutRequested;
                        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        this.initRecordTimeStamp = worker.schedulePeriodically(this, j, j, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    }
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            synchronized (this) {
                this.scheduleImpl = null;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            this.isLayoutRequested.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U u;
            this.isLayoutRequested.dispose();
            synchronized (this) {
                u = this.scheduleImpl;
                this.scheduleImpl = null;
            }
            if (u != null) {
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
            this.newProxyInstance.dispose();
            this.isLayoutRequested.dispose();
            synchronized (this) {
                this.scheduleImpl = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.lookAheadTest.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.scheduleImpl;
                    if (u2 != null && this.GetContactSyncConfig == this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                        this.scheduleImpl = u;
                        KClassImpl$Data$declaredNonStaticMembers$2(u2, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }
}
