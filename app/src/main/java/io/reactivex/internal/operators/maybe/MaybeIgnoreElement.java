package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {
    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new IgnoreMaybeObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable MyBillsEntityDataFactory;
        final MaybeObserver<? super T> getAuthRequestContext;

        IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.getAuthRequestContext = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.getAuthRequestContext.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
        }
    }
}
