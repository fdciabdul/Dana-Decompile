package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> MyBillsEntityDataFactory;

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.MyBillsEntityDataFactory = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DebounceObserver(new SerializedObserver(observer), this.MyBillsEntityDataFactory));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        volatile long KClassImpl$Data$declaredNonStaticMembers$2;
        final Function<? super T, ? extends ObservableSource<U>> MyBillsEntityDataFactory;
        final AtomicReference<Disposable> PlaceComponentResult = new AtomicReference<>();
        boolean getAuthRequestContext;
        Disposable scheduleImpl;

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.MyBillsEntityDataFactory = function;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.scheduleImpl, disposable)) {
                this.scheduleImpl = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            Disposable disposable = this.PlaceComponentResult.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(t), "The ObservableSource supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j, t);
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                dispose();
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.PlaceComponentResult);
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            Disposable disposable = this.PlaceComponentResult.get();
            if (disposable != DisposableHelper.DISPOSED) {
                DebounceInnerObserver debounceInnerObserver = (DebounceInnerObserver) disposable;
                if (debounceInnerObserver != null && debounceInnerObserver.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                    DebounceObserver<T, U> debounceObserver = debounceInnerObserver.PlaceComponentResult;
                    long j = debounceInnerObserver.getAuthRequestContext;
                    T t = debounceInnerObserver.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (j == debounceObserver.KClassImpl$Data$declaredNonStaticMembers$2) {
                        debounceObserver.BuiltInFictitiousFunctionClassFactory.onNext(t);
                    }
                }
                DisposableHelper.dispose(this.PlaceComponentResult);
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.scheduleImpl.dispose();
            DisposableHelper.dispose(this.PlaceComponentResult);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.scheduleImpl.isDisposed();
        }

        /* loaded from: classes9.dex */
        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            boolean BuiltInFictitiousFunctionClassFactory;
            final T KClassImpl$Data$declaredNonStaticMembers$2;
            final AtomicBoolean MyBillsEntityDataFactory = new AtomicBoolean();
            final DebounceObserver<T, U> PlaceComponentResult;
            final long getAuthRequestContext;

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.PlaceComponentResult = debounceObserver;
                this.getAuthRequestContext = j;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
            }

            @Override // io.reactivex.Observer
            public final void onNext(U u) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory = true;
                dispose();
                MyBillsEntityDataFactory();
            }

            private void MyBillsEntityDataFactory() {
                if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                    DebounceObserver<T, U> debounceObserver = this.PlaceComponentResult;
                    long j = this.getAuthRequestContext;
                    T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (j == debounceObserver.KClassImpl$Data$declaredNonStaticMembers$2) {
                        debounceObserver.BuiltInFictitiousFunctionClassFactory.onNext(t);
                    }
                }
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory = true;
                this.PlaceComponentResult.onError(th);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory = true;
                MyBillsEntityDataFactory();
            }
        }
    }
}
