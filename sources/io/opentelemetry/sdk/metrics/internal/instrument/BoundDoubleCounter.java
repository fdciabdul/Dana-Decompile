package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* loaded from: classes9.dex */
public interface BoundDoubleCounter {
    void add(double d);

    void add(double d, Context context);

    void unbind();
}
