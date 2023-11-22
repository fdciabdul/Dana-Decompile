package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* loaded from: classes2.dex */
public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DetachObserver(observer));
    }

    /* loaded from: classes9.dex */
    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Observer<? super T> MyBillsEntityDataFactory;
        Disposable getAuthRequestContext;

        DetachObserver(Observer<? super T> observer) {
            this.MyBillsEntityDataFactory = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable disposable = this.getAuthRequestContext;
            this.getAuthRequestContext = EmptyComponent.INSTANCE;
            this.MyBillsEntityDataFactory = EmptyComponent.asObserver();
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            Observer<? super T> observer = this.MyBillsEntityDataFactory;
            this.getAuthRequestContext = EmptyComponent.INSTANCE;
            this.MyBillsEntityDataFactory = EmptyComponent.asObserver();
            observer.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            Observer<? super T> observer = this.MyBillsEntityDataFactory;
            this.getAuthRequestContext = EmptyComponent.INSTANCE;
            this.MyBillsEntityDataFactory = EmptyComponent.asObserver();
            observer.onComplete();
        }
    }
}
