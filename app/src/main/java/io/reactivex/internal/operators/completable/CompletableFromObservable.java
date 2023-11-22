package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: classes9.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = completableObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }
}
