package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class SingleToObservable<T> extends Observable<T> {
    final SingleSource<? extends T> KClassImpl$Data$declaredNonStaticMembers$2;

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = singleSource;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new SingleToObservableObserver(observer));
    }

    public static <T> SingleObserver<T> MyBillsEntityDataFactory(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    /* loaded from: classes6.dex */
    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        Disposable upstream;

        SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            complete(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }
    }
}
