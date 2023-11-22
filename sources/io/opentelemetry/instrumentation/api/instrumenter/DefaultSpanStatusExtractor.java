package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.StatusCode;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class DefaultSpanStatusExtractor<REQUEST, RESPONSE> implements SpanStatusExtractor<REQUEST, RESPONSE> {
    static final SpanStatusExtractor<Object, Object> INSTANCE = new DefaultSpanStatusExtractor();

    DefaultSpanStatusExtractor() {
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor
    public final void extract(SpanStatusBuilder spanStatusBuilder, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        if (th != null) {
            spanStatusBuilder.setStatus(StatusCode.ERROR);
        }
    }
}
