package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.ImmutableSpanContext;

/* loaded from: classes2.dex */
public interface SpanContext {
    String getSpanId();

    byte[] getSpanIdBytes();

    TraceFlags getTraceFlags();

    String getTraceId();

    byte[] getTraceIdBytes();

    TraceState getTraceState();

    boolean isRemote();

    boolean isSampled();

    boolean isValid();

    /* renamed from: io.opentelemetry.api.trace.SpanContext$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static SpanContext getInvalid() {
            return ImmutableSpanContext.INVALID;
        }

        public static SpanContext create(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
            return ImmutableSpanContext.create(str, str2, traceFlags, traceState, false, false);
        }

        public static SpanContext createFromRemoteParent(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
            return ImmutableSpanContext.create(str, str2, traceFlags, traceState, true, false);
        }

        public static boolean $default$isValid(SpanContext spanContext) {
            return TraceId.isValid(spanContext.getTraceId()) && SpanId.isValid(spanContext.getSpanId());
        }
    }
}
