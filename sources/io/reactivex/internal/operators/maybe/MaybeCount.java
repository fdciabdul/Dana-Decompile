package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* loaded from: classes9.dex */
public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Long> singleObserver) {
        this.PlaceComponentResult.PlaceComponentResult(new CountMaybeObserver(singleObserver));
    }

    /* loaded from: classes9.dex */
    static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final SingleObserver<? super Long> getAuthRequestContext;

        CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.getAuthRequestContext = singleObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onSuccess(1L);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onSuccess(0L);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
        }
    }
}
