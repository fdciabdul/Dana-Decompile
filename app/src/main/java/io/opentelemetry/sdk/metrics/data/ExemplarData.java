package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* loaded from: classes6.dex */
public interface ExemplarData {
    long getEpochNanos();

    Attributes getFilteredAttributes();

    SpanContext getSpanContext();
}
