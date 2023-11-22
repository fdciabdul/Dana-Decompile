package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* loaded from: classes2.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    private final T KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableJust(T t) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.KClassImpl$Data$declaredNonStaticMembers$2);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public final T call() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
