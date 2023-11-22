package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.ValueAtQuantile;

/* loaded from: classes9.dex */
public abstract class ImmutableValueAtQuantile implements ValueAtQuantile {
    public static ValueAtQuantile create(double d, double d2) {
        return new AutoValue_ImmutableValueAtQuantile(d, d2);
    }
}
