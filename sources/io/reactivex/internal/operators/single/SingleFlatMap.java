package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class SingleFlatMap<T, R> extends Single<R> {
    final SingleSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends SingleSource<? extends R>> PlaceComponentResult;

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.PlaceComponentResult = function;
        this.BuiltInFictitiousFunctionClassFactory = singleSource;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new SingleFlatMapCallback(singleObserver, this.PlaceComponentResult));
    }

    /* loaded from: classes6.dex */
    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 3258103020495908596L;
        final SingleObserver<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.downstream = singleObserver;
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

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.PlaceComponentResult(this.mapper.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                singleSource.MyBillsEntityDataFactory(new FlatMapSingleObserver(this, this.downstream));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        /* loaded from: classes6.dex */
        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
            final AtomicReference<Disposable> MyBillsEntityDataFactory;
            final SingleObserver<? super R> getAuthRequestContext;

            FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.MyBillsEntityDataFactory = atomicReference;
                this.getAuthRequestContext = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this.MyBillsEntityDataFactory, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(R r) {
                this.getAuthRequestContext.onSuccess(r);
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                this.getAuthRequestContext.onError(th);
            }
        }
    }
}
