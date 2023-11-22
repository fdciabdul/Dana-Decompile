package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {
    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super Boolean> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new IsEmptyMaybeObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super Boolean> BuiltInFictitiousFunctionClassFactory;
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;

        IsEmptyMaybeObserver(MaybeObserver<? super Boolean> maybeObserver) {
            this.BuiltInFictitiousFunctionClassFactory = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.TRUE);
        }
    }
}
