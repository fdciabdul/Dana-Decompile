package io.opentelemetry.instrumentation.api.instrumenter;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface SpanNameExtractor<REQUEST> {
    String extract(REQUEST request);
}
