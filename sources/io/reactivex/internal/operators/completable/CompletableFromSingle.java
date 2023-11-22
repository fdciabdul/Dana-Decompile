package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* loaded from: classes9.dex */
public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new CompletableFromSingleObserver(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver MyBillsEntityDataFactory;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.MyBillsEntityDataFactory = completableObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
