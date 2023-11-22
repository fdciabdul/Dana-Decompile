package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {
    final AtomicReference<Disposable> PlaceComponentResult = new AtomicReference<>();

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.getAuthRequestContext(this.PlaceComponentResult, disposable, getClass());
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.PlaceComponentResult);
    }
}
