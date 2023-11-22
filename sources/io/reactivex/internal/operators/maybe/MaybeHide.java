package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {
    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new HideMaybeObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final MaybeObserver<? super T> PlaceComponentResult;

        HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.PlaceComponentResult = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.PlaceComponentResult.onSuccess(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.PlaceComponentResult.onComplete();
        }
    }
}
