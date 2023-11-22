package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* loaded from: classes9.dex */
public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {
    final MaybeSource<T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.getAuthRequestContext.PlaceComponentResult(new IsEmptyMaybeObserver(singleObserver));
    }

    /* loaded from: classes9.dex */
    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super Boolean> BuiltInFictitiousFunctionClassFactory;
        Disposable getAuthRequestContext;

        IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.getAuthRequestContext = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.TRUE);
        }
    }
}
