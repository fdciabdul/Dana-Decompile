package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

/* loaded from: classes6.dex */
final class SpanStatusBuilderImpl implements SpanStatusBuilder {
    private final Span span;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder
    public final /* synthetic */ SpanStatusBuilder setStatus(StatusCode statusCode) {
        SpanStatusBuilder status;
        status = setStatus(statusCode, "");
        return status;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanStatusBuilderImpl(Span span) {
        this.span = span;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder
    public final SpanStatusBuilder setStatus(StatusCode statusCode, String str) {
        this.span.setStatus(statusCode, str);
        return this;
    }
}
