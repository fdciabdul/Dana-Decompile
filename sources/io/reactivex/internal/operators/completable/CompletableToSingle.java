package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class CompletableToSingle<T> extends Single<T> {
    final T MyBillsEntityDataFactory;
    final Callable<? extends T> PlaceComponentResult;
    final CompletableSource getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.getAuthRequestContext.getAuthRequestContext(new ToSingle(singleObserver));
    }

    /* loaded from: classes9.dex */
    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> getAuthRequestContext;

        ToSingle(SingleObserver<? super T> singleObserver) {
            this.getAuthRequestContext = singleObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            T call;
            if (CompletableToSingle.this.PlaceComponentResult != null) {
                try {
                    call = CompletableToSingle.this.PlaceComponentResult.call();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.getAuthRequestContext.onError(th);
                    return;
                }
            } else {
                call = CompletableToSingle.this.MyBillsEntityDataFactory;
            }
            if (call == null) {
                this.getAuthRequestContext.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.getAuthRequestContext.onSuccess(call);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.onSubscribe(disposable);
        }
    }
}
