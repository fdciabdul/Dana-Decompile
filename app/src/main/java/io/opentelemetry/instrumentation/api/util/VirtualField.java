package io.opentelemetry.instrumentation.api.util;

import io.opentelemetry.instrumentation.api.internal.RuntimeVirtualFieldSupplier;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class VirtualField<T, F> {
    @Nullable
    public abstract F get(T t);

    public abstract void set(T t, @Nullable F f);

    public static <U extends T, V extends F, T, F> VirtualField<U, V> find(Class<T> cls, Class<F> cls2) {
        return RuntimeVirtualFieldSupplier.get().find(cls, cls2);
    }
}
