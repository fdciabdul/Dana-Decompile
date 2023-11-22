package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
public final class MaybeUsing<T, D> extends Maybe<T> {
    final boolean BuiltInFictitiousFunctionClassFactory;
    final Consumer<? super D> MyBillsEntityDataFactory;
    final Callable<? extends D> PlaceComponentResult;
    final Function<? super D, ? extends MaybeSource<? extends T>> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        try {
            D call = this.PlaceComponentResult.call();
            try {
                ((MaybeSource) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(call), "The sourceSupplier returned a null MaybeSource")).PlaceComponentResult(new UsingObserver(maybeObserver, call, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    try {
                        this.MyBillsEntityDataFactory.accept(call);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), maybeObserver);
                        return;
                    }
                }
                EmptyDisposable.error(th, maybeObserver);
                if (this.BuiltInFictitiousFunctionClassFactory) {
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
            EmptyDisposable.error(th4, maybeObserver);
        }
    }

    /* loaded from: classes9.dex */
    static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        final Consumer<? super D> disposer;
        final MaybeObserver<? super T> downstream;
        final boolean eager;
        Disposable upstream;

        UsingObserver(MaybeObserver<? super T> maybeObserver, D d, Consumer<? super D> consumer, boolean z) {
            super(d);
            this.downstream = maybeObserver;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        final void disposeResourceAfter() {
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

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
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
            disposeResourceAfter();
        }

        @Override // io.reactivex.MaybeObserver
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
            disposeResourceAfter();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
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
            this.downstream.onComplete();
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }
    }
}
