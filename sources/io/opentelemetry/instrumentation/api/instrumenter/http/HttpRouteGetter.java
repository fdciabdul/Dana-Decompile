package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.context.Context;
import javax.annotation.Nullable;

@FunctionalInterface
/* loaded from: classes9.dex */
public interface HttpRouteGetter<T> {
    @Nullable
    String get(Context context, T t);
}
