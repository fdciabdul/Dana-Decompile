package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* loaded from: classes9.dex */
public interface BoundLongHistogram {
    void record(long j);

    void record(long j, Context context);

    void unbind();
}
