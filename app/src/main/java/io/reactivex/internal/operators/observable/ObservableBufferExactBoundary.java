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
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<B> PlaceComponentResult;

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.PlaceComponentResult = observableSource2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        this.getAuthRequestContext.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final ObservableSource<B> NetworkUserEntityData$$ExternalSyntheticLambda0;
        Disposable NetworkUserEntityData$$ExternalSyntheticLambda1;
        U getErrorConfigVersion;
        Disposable lookAheadTest;
        final Callable<U> scheduleImpl;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public final /* synthetic */ void MyBillsEntityDataFactory(Observer observer, Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext((Collection) obj);
        }

        BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.scheduleImpl = callable;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = observableSource;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda1, disposable)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = disposable;
                try {
                    this.getErrorConfigVersion = (U) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.lookAheadTest = bufferBoundaryObserver;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                    if (this.PlaceComponentResult) {
                        return;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.subscribe(bufferBoundaryObserver);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.PlaceComponentResult = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.getErrorConfigVersion;
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
                U u = this.getErrorConfigVersion;
                if (u == null) {
                    return;
                }
                this.getErrorConfigVersion = null;
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
            this.lookAheadTest.dispose();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
            if (MyBillsEntityDataFactory()) {
                this.getAuthRequestContext.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        final void scheduleImpl() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.scheduleImpl.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.getErrorConfigVersion;
                    if (u2 == null) {
                        return;
                    }
                    this.getErrorConfigVersion = u;
                    getAuthRequestContext(u2, this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferExactBoundaryObserver<T, U, B> KClassImpl$Data$declaredNonStaticMembers$2;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bufferExactBoundaryObserver;
        }

        @Override // io.reactivex.Observer
        public final void onNext(B b) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
