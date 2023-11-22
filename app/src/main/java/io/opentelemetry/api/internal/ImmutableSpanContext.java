package io.opentelemetry.api.internal;

import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.api.trace.TraceState;

/* loaded from: classes6.dex */
public abstract class ImmutableSpanContext implements SpanContext {
    public static final SpanContext INVALID = createInternal(TraceId.getInvalid(), SpanId.getInvalid(), TraceFlags.CC.getDefault(), TraceState.CC.getDefault(), false, false);

    @Override // io.opentelemetry.api.trace.SpanContext
    public /* synthetic */ byte[] getSpanIdBytes() {
        byte[] bytesFromBase16;
        bytesFromBase16 = OtelEncodingUtils.bytesFromBase16(getSpanId(), SpanId.getLength());
        return bytesFromBase16;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public /* synthetic */ byte[] getTraceIdBytes() {
        byte[] bytesFromBase16;
        bytesFromBase16 = OtelEncodingUtils.bytesFromBase16(getTraceId(), TraceId.getLength());
        return bytesFromBase16;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public /* synthetic */ boolean isSampled() {
        boolean isSampled;
        isSampled = getTraceFlags().isSampled();
        return isSampled;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public abstract boolean isValid();

    private static AutoValue_ImmutableSpanContext createInternal(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z, boolean z2) {
        return new AutoValue_ImmutableSpanContext(str, str2, traceFlags, traceState, z, z2);
    }

    public static SpanContext create(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z, boolean z2) {
        if (z2 || (SpanId.isValid(str2) && TraceId.isValid(str))) {
            return createInternal(str, str2, traceFlags, traceState, z, true);
        }
        return createInternal(TraceId.getInvalid(), SpanId.getInvalid(), traceFlags, traceState, z, false);
    }
}
