package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamCompletableSource;

/* loaded from: classes9.dex */
public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {
    final CompletableSource MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new FromCompletableObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {
        final MaybeObserver<? super T> BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;

        FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
            this.BuiltInFictitiousFunctionClassFactory = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }
    }
}
