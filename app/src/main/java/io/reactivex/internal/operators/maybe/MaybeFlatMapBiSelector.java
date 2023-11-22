package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> MyBillsEntityDataFactory;
    final Function<? super T, ? extends MaybeSource<? extends U>> PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new FlatMapBiMainObserver(maybeObserver, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
        final Function<? super T, ? extends MaybeSource<? extends U>> PlaceComponentResult;
        final InnerObserver<T, U, R> getAuthRequestContext;

        FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.getAuthRequestContext = new InnerObserver<>(maybeObserver, biFunction);
            this.PlaceComponentResult = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.getAuthRequestContext);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.getAuthRequestContext.get());
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t), "The mapper returned a null MaybeSource");
                if (DisposableHelper.replace(this.getAuthRequestContext, null)) {
                    this.getAuthRequestContext.value = t;
                    maybeSource.PlaceComponentResult(this.getAuthRequestContext);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.downstream.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.getAuthRequestContext.downstream.onComplete();
        }

        /* loaded from: classes9.dex */
        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final MaybeObserver<? super R> downstream;
            final BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.downstream = maybeObserver;
                this.resultSelector = biFunction;
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.downstream.onSuccess(ObjectHelper.PlaceComponentResult(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.downstream.onError(th);
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
    }
}
