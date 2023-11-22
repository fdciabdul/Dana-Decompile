package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class ObservableNever extends Observable<Object> {
    public static final Observable<Object> MyBillsEntityDataFactory = new ObservableNever();

    private ObservableNever() {
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
