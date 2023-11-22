package io.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface TextMapSetter<C> {
    void set(@Nullable C c, String str, String str2);
}
