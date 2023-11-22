package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {
    final Consumer<? super Disposable> BuiltInFictitiousFunctionClassFactory;
    final AtomicInteger KClassImpl$Data$declaredNonStaticMembers$2;
    final ConnectableObservable<? extends T> MyBillsEntityDataFactory;
    final int PlaceComponentResult;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.MyBillsEntityDataFactory.subscribe((Observer<? super Object>) observer);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.incrementAndGet() == this.PlaceComponentResult) {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
    }
}
