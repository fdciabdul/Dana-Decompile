package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> BuiltInFictitiousFunctionClassFactory;
    final AtomicReference<Disposable> MyBillsEntityDataFactory;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.MyBillsEntityDataFactory = atomicReference;
        this.BuiltInFictitiousFunctionClassFactory = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.MyBillsEntityDataFactory, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.BuiltInFictitiousFunctionClassFactory.onError(th);
    }
}
