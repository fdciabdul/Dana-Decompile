package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new HideDisposable(observer));
    }

    /* loaded from: classes9.dex */
    static final class HideDisposable<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;

        HideDisposable(Observer<? super T> observer) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}
