package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;

/* loaded from: classes6.dex */
final class SpanLinksBuilderImpl implements SpanLinksBuilder {
    private final SpanBuilder spanBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanLinksBuilderImpl(SpanBuilder spanBuilder) {
        this.spanBuilder = spanBuilder;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanLinksBuilder
    public final SpanLinksBuilder addLink(SpanContext spanContext) {
        this.spanBuilder.addLink(spanContext);
        return this;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanLinksBuilder
    public final SpanLinksBuilder addLink(SpanContext spanContext, Attributes attributes) {
        this.spanBuilder.addLink(spanContext, attributes);
        return this;
    }
}
