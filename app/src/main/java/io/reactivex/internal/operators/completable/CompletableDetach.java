package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class CompletableDetach extends Completable {
    final CompletableSource BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DetachCompletableObserver(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable PlaceComponentResult;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.PlaceComponentResult.dispose();
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (completableObserver != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                completableObserver.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (completableObserver != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                completableObserver.onComplete();
            }
        }
    }
}
