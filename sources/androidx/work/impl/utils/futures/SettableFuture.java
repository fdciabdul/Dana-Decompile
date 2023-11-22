package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes3.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public static <V> SettableFuture<V> PlaceComponentResult() {
        return new SettableFuture<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public final boolean getAuthRequestContext(V v) {
        return super.getAuthRequestContext((SettableFuture<V>) v);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public final boolean BuiltInFictitiousFunctionClassFactory(Throwable th) {
        return super.BuiltInFictitiousFunctionClassFactory(th);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public final boolean PlaceComponentResult(ListenableFuture<? extends V> listenableFuture) {
        return super.PlaceComponentResult(listenableFuture);
    }

    private SettableFuture() {
    }
}
