package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean BuiltInFictitiousFunctionClassFactory;
    final Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
    final long MyBillsEntityDataFactory;
    final TimeUnit PlaceComponentResult;

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.MyBillsEntityDataFactory = j;
        this.PlaceComponentResult = timeUnit;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scheduler;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DelayObserver(!this.BuiltInFictitiousFunctionClassFactory ? new SerializedObserver(observer) : observer, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2.createWorker(), this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final TimeUnit PlaceComponentResult;
        final boolean getAuthRequestContext;
        final Scheduler.Worker getErrorConfigVersion;

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.PlaceComponentResult = timeUnit;
            this.getErrorConfigVersion = worker;
            this.getAuthRequestContext = z;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.getErrorConfigVersion.schedule(new OnNext(t), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.getErrorConfigVersion.schedule(new OnError(th), this.getAuthRequestContext ? this.KClassImpl$Data$declaredNonStaticMembers$2 : 0L, this.PlaceComponentResult);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.getErrorConfigVersion.schedule(new OnComplete(), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
            this.getErrorConfigVersion.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getErrorConfigVersion.isDisposed();
        }

        /* loaded from: classes6.dex */
        final class OnNext implements Runnable {
            private final T PlaceComponentResult;

            OnNext(T t) {
                this.PlaceComponentResult = t;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DelayObserver.this.BuiltInFictitiousFunctionClassFactory.onNext((T) this.PlaceComponentResult);
            }
        }

        /* loaded from: classes6.dex */
        final class OnError implements Runnable {
            private final Throwable getAuthRequestContext;

            OnError(Throwable th) {
                this.getAuthRequestContext = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    DelayObserver.this.BuiltInFictitiousFunctionClassFactory.onError(this.getAuthRequestContext);
                } finally {
                    DelayObserver.this.getErrorConfigVersion.dispose();
                }
            }
        }

        /* loaded from: classes6.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    DelayObserver.this.BuiltInFictitiousFunctionClassFactory.onComplete();
                } finally {
                    DelayObserver.this.getErrorConfigVersion.dispose();
                }
            }
        }
    }
}
