package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;

/* loaded from: classes6.dex */
public abstract class ImmutableDoubleExemplarData implements DoubleExemplarData {
    public static DoubleExemplarData create(Attributes attributes, long j, SpanContext spanContext, double d) {
        return new AutoValue_ImmutableDoubleExemplarData(attributes, j, spanContext, d);
    }
}
