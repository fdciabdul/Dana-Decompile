package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;

/* loaded from: classes2.dex */
public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {
    private final Action MyBillsEntityDataFactory;
    private final Consumer<? super Disposable> PlaceComponentResult;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.PlaceComponentResult = consumer;
        this.MyBillsEntityDataFactory = action;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DisposableLambdaObserver(observer, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }
}
