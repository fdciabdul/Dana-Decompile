package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* loaded from: classes9.dex */
public interface BoundDoubleHistogram {
    void record(double d);

    void record(double d, Context context);

    void unbind();
}
