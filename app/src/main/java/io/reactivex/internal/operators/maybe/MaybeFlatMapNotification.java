package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> BuiltInFictitiousFunctionClassFactory;
    final Callable<? extends MaybeSource<? extends R>> PlaceComponentResult;
    final Function<? super T, ? extends MaybeSource<? extends R>> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new FlatMapMaybeObserver(maybeObserver, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final MaybeObserver<? super R> downstream;
        final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
            this.downstream = maybeObserver;
            this.onSuccessMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
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
            try {
                ((MaybeSource) ObjectHelper.PlaceComponentResult(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).PlaceComponentResult(new InnerObserver());
            } catch (Exception e) {
                Exceptions.MyBillsEntityDataFactory(e);
                this.downstream.onError(e);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            try {
                ((MaybeSource) ObjectHelper.PlaceComponentResult(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).PlaceComponentResult(new InnerObserver());
            } catch (Exception e) {
                Exceptions.MyBillsEntityDataFactory(e);
                this.downstream.onError(new CompositeException(th, e));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            try {
                ((MaybeSource) ObjectHelper.PlaceComponentResult(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).PlaceComponentResult(new InnerObserver());
            } catch (Exception e) {
                Exceptions.MyBillsEntityDataFactory(e);
                this.downstream.onError(e);
            }
        }

        /* loaded from: classes9.dex */
        final class InnerObserver implements MaybeObserver<R> {
            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(R r) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }
        }
    }
}
