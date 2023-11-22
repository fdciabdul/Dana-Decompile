package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.instrumentation.api.instrumenter.SpanLinksBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.SpanLinksExtractor;

/* loaded from: classes9.dex */
public final class PropagatorBasedSpanLinksExtractor<REQUEST> implements SpanLinksExtractor<REQUEST> {
    private final TextMapGetter<REQUEST> getter;
    private final TextMapPropagator propagator;

    public PropagatorBasedSpanLinksExtractor(TextMapPropagator textMapPropagator, TextMapGetter<REQUEST> textMapGetter) {
        this.propagator = textMapPropagator;
        this.getter = textMapGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanLinksExtractor
    public final void extract(SpanLinksBuilder spanLinksBuilder, Context context, REQUEST request) {
        spanLinksBuilder.addLink(Span.CC.fromContext(this.propagator.extract(context, request, this.getter)).getSpanContext());
    }
}
