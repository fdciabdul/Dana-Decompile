package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class DisposableObserver<T> implements Observer<T>, Disposable {
    final AtomicReference<Disposable> upstream = new AtomicReference<>();

    protected void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.getAuthRequestContext(this.upstream, disposable, getClass())) {
            onStart();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }
}
