package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.StatusCode;

/* loaded from: classes6.dex */
public interface SpanStatusBuilder {
    SpanStatusBuilder setStatus(StatusCode statusCode);

    SpanStatusBuilder setStatus(StatusCode statusCode, String str);

    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
    }
}
