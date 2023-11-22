package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
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
public final class CompletableUsing<R> extends Completable {
    final Callable<R> BuiltInFictitiousFunctionClassFactory;
    final Function<? super R, ? extends CompletableSource> KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean PlaceComponentResult;
    final Consumer<? super R> getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        try {
            R call = this.BuiltInFictitiousFunctionClassFactory.call();
            try {
                ((CompletableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(call), "The completableFunction returned a null CompletableSource")).getAuthRequestContext(new UsingObserver(completableObserver, call, this.getAuthRequestContext, this.PlaceComponentResult));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                if (this.PlaceComponentResult) {
                    try {
                        this.getAuthRequestContext.accept(call);
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        EmptyDisposable.error(new CompositeException(th, th2), completableObserver);
                        return;
                    }
                }
                EmptyDisposable.error(th, completableObserver);
                if (this.PlaceComponentResult) {
                    return;
                }
                try {
                    this.getAuthRequestContext.accept(call);
                } catch (Throwable th3) {
                    Exceptions.MyBillsEntityDataFactory(th3);
                    RxJavaPlugins.PlaceComponentResult(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.MyBillsEntityDataFactory(th4);
            EmptyDisposable.error(th4, completableObserver);
        }
    }

    /* loaded from: classes9.dex */
    static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        final Consumer<? super R> disposer;
        final CompletableObserver downstream;
        final boolean eager;
        Disposable upstream;

        UsingObserver(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            this.downstream = completableObserver;
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

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
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

        @Override // io.reactivex.CompletableObserver
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
