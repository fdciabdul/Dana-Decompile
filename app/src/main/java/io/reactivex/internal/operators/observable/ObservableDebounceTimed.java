package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final TimeUnit BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final Scheduler MyBillsEntityDataFactory;

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.BuiltInFictitiousFunctionClassFactory = timeUnit;
        this.MyBillsEntityDataFactory = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.createWorker()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        volatile long BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        final long getAuthRequestContext;
        Disposable getErrorConfigVersion;
        final TimeUnit lookAheadTest;
        final Scheduler.Worker moveToNextValue;

        DebounceTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.getAuthRequestContext = j;
            this.lookAheadTest = timeUnit;
            this.moveToNextValue = worker;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getErrorConfigVersion, disposable)) {
                this.getErrorConfigVersion = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            long j = this.BuiltInFictitiousFunctionClassFactory + 1;
            this.BuiltInFictitiousFunctionClassFactory = j;
            Disposable disposable = this.PlaceComponentResult;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
            this.PlaceComponentResult = debounceEmitter;
            debounceEmitter.setResource(this.moveToNextValue.schedule(debounceEmitter, this.getAuthRequestContext, this.lookAheadTest));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            Disposable disposable = this.PlaceComponentResult;
            if (disposable != null) {
                disposable.dispose();
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            this.moveToNextValue.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            Disposable disposable = this.PlaceComponentResult;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
            this.moveToNextValue.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getErrorConfigVersion.dispose();
            this.moveToNextValue.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.moveToNextValue.isDisposed();
        }
    }

    /* loaded from: classes6.dex */
    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedObserver<T> parent;
        final T value;

        DebounceEmitter(T t, long j, DebounceTimedObserver<T> debounceTimedObserver) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedObserver;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.once.compareAndSet(false, true)) {
                DebounceTimedObserver<T> debounceTimedObserver = this.parent;
                long j = this.idx;
                T t = this.value;
                if (j == debounceTimedObserver.BuiltInFictitiousFunctionClassFactory) {
                    debounceTimedObserver.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public final void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
