package io.reactivex.internal.observers;

/* loaded from: classes2.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = t;
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            countDown();
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.getAuthRequestContext = th;
        }
        countDown();
    }
}
