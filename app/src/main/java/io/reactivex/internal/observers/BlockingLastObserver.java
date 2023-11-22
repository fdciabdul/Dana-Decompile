package io.reactivex.internal.observers;

/* loaded from: classes2.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        this.BuiltInFictitiousFunctionClassFactory = t;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = th;
        countDown();
    }
}
