package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.context.Context;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface SpanLinksExtractor<REQUEST> {
    void extract(SpanLinksBuilder spanLinksBuilder, Context context, REQUEST request);
}
