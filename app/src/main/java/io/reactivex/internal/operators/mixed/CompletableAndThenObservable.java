package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {
    final CompletableSource KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<? extends R> MyBillsEntityDataFactory;

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = completableSource;
        this.MyBillsEntityDataFactory = observableSource;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.MyBillsEntityDataFactory);
        observer.onSubscribe(andThenObservableObserver);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(andThenObservableObserver);
    }

    /* loaded from: classes6.dex */
    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        ObservableSource<? extends R> other;

        AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.other = observableSource;
            this.downstream = observer;
        }

        @Override // io.reactivex.Observer
        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            ObservableSource<? extends R> observableSource = this.other;
            if (observableSource == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            observableSource.subscribe(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
