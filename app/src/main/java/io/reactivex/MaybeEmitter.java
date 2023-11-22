package io.reactivex;

import io.reactivex.functions.Cancellable;

/* loaded from: classes9.dex */
public interface MaybeEmitter<T> {
    void onComplete();

    void onSuccess(T t);

    void setCancellable(Cancellable cancellable);

    boolean tryOnError(Throwable th);
}
