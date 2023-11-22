package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* loaded from: classes9.dex */
public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> BuiltInFictitiousFunctionClassFactory;
    final Object KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(new ContainsMaybeObserver(singleObserver, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
        final Object BuiltInFictitiousFunctionClassFactory;
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final SingleObserver<? super Boolean> getAuthRequestContext;

        ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.getAuthRequestContext = singleObserver;
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
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
            this.getAuthRequestContext.onSuccess(Boolean.valueOf(ObjectHelper.getAuthRequestContext(obj, this.BuiltInFictitiousFunctionClassFactory)));
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onSuccess(Boolean.FALSE);
        }
    }
}
