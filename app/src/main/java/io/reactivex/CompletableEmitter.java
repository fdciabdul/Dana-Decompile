package io.reactivex;

import io.reactivex.functions.Cancellable;

/* loaded from: classes3.dex */
public interface CompletableEmitter {
    void onComplete();

    void setCancellable(Cancellable cancellable);

    boolean tryOnError(Throwable th);
}
