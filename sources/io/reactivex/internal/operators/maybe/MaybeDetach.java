package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {
    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new DetachMaybeObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable MyBillsEntityDataFactory;
        MaybeObserver<? super T> getAuthRequestContext;

        DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.getAuthRequestContext = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext = null;
            this.MyBillsEntityDataFactory.dispose();
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
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
            MaybeObserver<? super T> maybeObserver = this.getAuthRequestContext;
            if (maybeObserver != null) {
                this.getAuthRequestContext = null;
                maybeObserver.onSuccess(t);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.getAuthRequestContext;
            if (maybeObserver != null) {
                this.getAuthRequestContext = null;
                maybeObserver.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.getAuthRequestContext;
            if (maybeObserver != null) {
                this.getAuthRequestContext = null;
                maybeObserver.onComplete();
            }
        }
    }
}
