package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final SingleSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final MaybeSource<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.PlaceComponentResult.PlaceComponentResult(new SwitchIfEmptyMaybeObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4603919676453758899L;
        final SingleObserver<? super T> downstream;
        final SingleSource<? extends T> other;

        SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.other = singleSource;
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
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            Disposable disposable = get();
            if (disposable == DisposableHelper.DISPOSED || !compareAndSet(disposable, null)) {
                return;
            }
            this.other.MyBillsEntityDataFactory(new OtherSingleObserver(this.downstream, this));
        }

        /* loaded from: classes9.dex */
        static final class OtherSingleObserver<T> implements SingleObserver<T> {
            final SingleObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
            final AtomicReference<Disposable> PlaceComponentResult;

            OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
                this.PlaceComponentResult = atomicReference;
            }

            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.PlaceComponentResult, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(T t) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }
}
