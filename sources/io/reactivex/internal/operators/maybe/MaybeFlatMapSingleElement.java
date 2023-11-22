package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeFlatMapSingleElement<T, R> extends Maybe<R> {
    final MaybeSource<T> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends SingleSource<? extends R>> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(new FlatMapMaybeObserver(maybeObserver, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;
        final MaybeObserver<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.downstream = maybeObserver;
            this.mapper = function;
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
            try {
                ((SingleSource) ObjectHelper.PlaceComponentResult(this.mapper.apply(t), "The mapper returned a null SingleSource")).MyBillsEntityDataFactory(new FlatMapSingleObserver(this, this.downstream));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final AtomicReference<Disposable> BuiltInFictitiousFunctionClassFactory;
        final MaybeObserver<? super R> PlaceComponentResult;

        FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.BuiltInFictitiousFunctionClassFactory = atomicReference;
            this.PlaceComponentResult = maybeObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.BuiltInFictitiousFunctionClassFactory, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(R r) {
            this.PlaceComponentResult.onSuccess(r);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }
    }
}
