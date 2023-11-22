package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamSingleSource;

/* loaded from: classes9.dex */
public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new FromSingleObserver(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
        Disposable MyBillsEntityDataFactory;
        final MaybeObserver<? super T> PlaceComponentResult;

        FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.PlaceComponentResult = maybeObserver;
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

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onError(th);
        }
    }
}
