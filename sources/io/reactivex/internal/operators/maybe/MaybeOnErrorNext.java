package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
    final boolean MyBillsEntityDataFactory;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new OnErrorNextMaybeObserver(maybeObserver, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final MaybeObserver<? super T> downstream;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

        OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z) {
            this.downstream = maybeObserver;
            this.resumeFunction = function;
            this.allowFatal = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.PlaceComponentResult(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                DisposableHelper.replace(this, null);
                maybeSource.PlaceComponentResult(new NextMaybeObserver(this.downstream, this));
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        /* loaded from: classes9.dex */
        static final class NextMaybeObserver<T> implements MaybeObserver<T> {
            final MaybeObserver<? super T> MyBillsEntityDataFactory;
            final AtomicReference<Disposable> PlaceComponentResult;

            NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.MyBillsEntityDataFactory = maybeObserver;
                this.PlaceComponentResult = atomicReference;
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.PlaceComponentResult, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(T t) {
                this.MyBillsEntityDataFactory.onSuccess(t);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onError(Throwable th) {
                this.MyBillsEntityDataFactory.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onComplete() {
                this.MyBillsEntityDataFactory.onComplete();
            }
        }
    }
}
