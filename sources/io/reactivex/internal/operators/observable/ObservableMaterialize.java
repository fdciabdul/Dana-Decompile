package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {
    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Notification<T>> observer) {
        this.getAuthRequestContext.subscribe(new MaterializeObserver(observer));
    }

    /* loaded from: classes9.dex */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> PlaceComponentResult;
        Disposable getAuthRequestContext;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.PlaceComponentResult = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.PlaceComponentResult.onNext(Notification.BuiltInFictitiousFunctionClassFactory(t));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onNext(Notification.MyBillsEntityDataFactory(th));
            this.PlaceComponentResult.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult.onNext(Notification.MyBillsEntityDataFactory());
            this.PlaceComponentResult.onComplete();
        }
    }
}
