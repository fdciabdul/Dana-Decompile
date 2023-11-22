package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* loaded from: classes2.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {
    final ObservableSource<T> MyBillsEntityDataFactory;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.MyBillsEntityDataFactory = observableSource;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.MyBillsEntityDataFactory.subscribe(observer);
    }
}
