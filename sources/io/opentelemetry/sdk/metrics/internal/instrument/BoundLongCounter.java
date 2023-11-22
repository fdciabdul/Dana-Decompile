package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* loaded from: classes9.dex */
public interface BoundLongCounter {
    void add(long j);

    void add(long j, Context context);

    void unbind();
}
