package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(new DetachSingleObserver(singleObserver));
    }

    /* loaded from: classes9.dex */
    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        SingleObserver<? super T> MyBillsEntityDataFactory;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.MyBillsEntityDataFactory = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.MyBillsEntityDataFactory;
            if (singleObserver != null) {
                this.MyBillsEntityDataFactory = null;
                singleObserver.onSuccess(t);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.MyBillsEntityDataFactory;
            if (singleObserver != null) {
                this.MyBillsEntityDataFactory = null;
                singleObserver.onError(th);
            }
        }
    }
}
