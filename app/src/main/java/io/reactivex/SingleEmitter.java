package io.reactivex;

import io.reactivex.functions.Cancellable;

/* loaded from: classes6.dex */
public interface SingleEmitter<T> {
    void onError(Throwable th);

    void onSuccess(T t);

    void setCancellable(Cancellable cancellable);

    boolean tryOnError(Throwable th);
}
