package io.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface TextMapGetter<C> {
    @Nullable
    String get(@Nullable C c, String str);

    Iterable<String> keys(C c);
}
