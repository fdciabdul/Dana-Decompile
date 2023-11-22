package zipkin2;

import zipkin2.internal.Nullable;

/* loaded from: classes6.dex */
public interface Callback<V> {
    void onError(Throwable th);

    void onSuccess(@Nullable V v);
}
