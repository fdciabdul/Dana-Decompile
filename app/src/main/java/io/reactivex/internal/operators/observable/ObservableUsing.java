package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableUsing<T, D> extends Observable<T> {
    final Consumer<? super D> BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<? extends D> MyBillsEntityDataFactory;
    final Function<? super D, ? extends ObservableSource<? extends T>> getAuthRequestContext;

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.MyBillsEntityDataFactory = callable;
        this.getAuthRequestContext = function;
        this.BuiltInFictitiousFunctionClassFactory = consumer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        try {
            D call = this.MyBillsEntityDataFactory.call();
            try {
                ((ObservableSource) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                try {
                    this.BuiltInFictitiousFunctionClassFactory.accept(call);
                    EmptyDisposable.error(th, observer);
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), observer);
                }
            }
        } catch (Throwable th3) {
            Exceptions.MyBillsEntityDataFactory(th3);
            EmptyDisposable.error(th3, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Observer<? super T> downstream;
        final boolean eager;
        final D resource;
        Disposable upstream;

        UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean z) {
            this.downstream = observer;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th);
                return;
            }
            this.downstream.onError(th);
            this.upstream.dispose();
            disposeAfter();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.downstream.onError(th);
                        return;
                    }
                }
                this.upstream.dispose();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeAfter();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get();
        }

        final void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            }
        }
    }
}
