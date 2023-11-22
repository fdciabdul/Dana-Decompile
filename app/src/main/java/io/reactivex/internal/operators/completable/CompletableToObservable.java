package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* loaded from: classes9.dex */
public final class CompletableToObservable<T> extends Observable<T> {
    final CompletableSource BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ObserverCompletableObserver(observer));
    }

    /* loaded from: classes9.dex */
    static final class ObserverCompletableObserver extends BasicQueueDisposable<Void> implements CompletableObserver {
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<?> MyBillsEntityDataFactory;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final /* bridge */ /* synthetic */ Object poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 2;
        }

        ObserverCompletableObserver(Observer<?> observer) {
            this.MyBillsEntityDataFactory = observer;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }
    }
}
