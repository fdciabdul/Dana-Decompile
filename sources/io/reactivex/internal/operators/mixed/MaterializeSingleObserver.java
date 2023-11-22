package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    final SingleObserver<? super Notification<T>> MyBillsEntityDataFactory;
    Disposable PlaceComponentResult;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.MyBillsEntityDataFactory = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
            this.PlaceComponentResult = disposable;
            this.MyBillsEntityDataFactory.onSubscribe(this);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onComplete() {
        this.MyBillsEntityDataFactory.onSuccess(Notification.MyBillsEntityDataFactory());
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.MyBillsEntityDataFactory.onSuccess(Notification.BuiltInFictitiousFunctionClassFactory(t));
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.MyBillsEntityDataFactory.onSuccess(Notification.MyBillsEntityDataFactory(th));
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult.isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.PlaceComponentResult.dispose();
    }
}
