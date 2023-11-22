package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class SingleUsing<T, U> extends Single<T> {
    final Function<? super U, ? extends SingleSource<? extends T>> BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final Consumer<? super U> MyBillsEntityDataFactory;
    final Callable<U> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        try {
            U call = this.PlaceComponentResult.call();
            try {
                ((SingleSource) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(call), "The singleFunction returned a null SingleSource")).MyBillsEntityDataFactory(new UsingSingleObserver(singleObserver, call, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory));
            } catch (Throwable th) {
                th = th;
                Exceptions.MyBillsEntityDataFactory(th);
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    try {
                        this.MyBillsEntityDataFactory.accept(call);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.error(th, singleObserver);
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                try {
                    this.MyBillsEntityDataFactory.accept(call);
                } catch (Throwable th3) {
                    Exceptions.MyBillsEntityDataFactory(th3);
                    RxJavaPlugins.PlaceComponentResult(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.MyBillsEntityDataFactory(th4);
            EmptyDisposable.error(th4, singleObserver);
        }
    }

    /* loaded from: classes9.dex */
    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;
        final Consumer<? super U> disposer;
        final SingleObserver<? super T> downstream;
        final boolean eager;
        Disposable upstream;

        UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
            super(u);
            this.downstream = singleObserver;
            this.eager = z;
            this.disposer = consumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeAfter();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.downstream.onSuccess(t);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.downstream.onError(th);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }

        final void disposeAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            }
        }
    }
}
