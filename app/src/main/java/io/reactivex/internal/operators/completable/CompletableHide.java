package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class CompletableHide extends Completable {
    final CompletableSource BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new HideCompletableObserver(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class HideCompletableObserver implements CompletableObserver, Disposable {
        Disposable PlaceComponentResult;
        final CompletableObserver getAuthRequestContext;

        HideCompletableObserver(CompletableObserver completableObserver) {
            this.getAuthRequestContext = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
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
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.getAuthRequestContext.onComplete();
        }
    }
}
