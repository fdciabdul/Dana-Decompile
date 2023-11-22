package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;

/* loaded from: classes9.dex */
public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {
    final MaybeSource<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(new IgnoreMaybeObserver(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final CompletableObserver KClassImpl$Data$declaredNonStaticMembers$2;

        IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = completableObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
        }
    }
}
