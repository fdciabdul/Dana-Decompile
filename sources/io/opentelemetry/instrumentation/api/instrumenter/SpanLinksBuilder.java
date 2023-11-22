package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* loaded from: classes6.dex */
public interface SpanLinksBuilder {
    SpanLinksBuilder addLink(SpanContext spanContext);

    SpanLinksBuilder addLink(SpanContext spanContext, Attributes attributes);
}
