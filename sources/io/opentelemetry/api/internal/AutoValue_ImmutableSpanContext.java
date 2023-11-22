package io.opentelemetry.api.internal;

import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ImmutableSpanContext extends ImmutableSpanContext {
    private final boolean remote;
    private final String spanId;
    private final TraceFlags traceFlags;
    private final String traceId;
    private final TraceState traceState;
    private final boolean valid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSpanContext(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z, boolean z2) {
        if (str == null) {
            throw new NullPointerException("Null traceId");
        }
        this.traceId = str;
        if (str2 == null) {
            throw new NullPointerException("Null spanId");
        }
        this.spanId = str2;
        if (traceFlags == null) {
            throw new NullPointerException("Null traceFlags");
        }
        this.traceFlags = traceFlags;
        if (traceState == null) {
            throw new NullPointerException("Null traceState");
        }
        this.traceState = traceState;
        this.remote = z;
        this.valid = z2;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public final String getTraceId() {
        return this.traceId;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public final String getSpanId() {
        return this.spanId;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public final TraceFlags getTraceFlags() {
        return this.traceFlags;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public final TraceState getTraceState() {
        return this.traceState;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public final boolean isRemote() {
        return this.remote;
    }

    @Override // io.opentelemetry.api.internal.ImmutableSpanContext, io.opentelemetry.api.trace.SpanContext
    public final boolean isValid() {
        return this.valid;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableSpanContext{traceId=");
        sb.append(this.traceId);
        sb.append(", spanId=");
        sb.append(this.spanId);
        sb.append(", traceFlags=");
        sb.append(this.traceFlags);
        sb.append(", traceState=");
        sb.append(this.traceState);
        sb.append(", remote=");
        sb.append(this.remote);
        sb.append(", valid=");
        sb.append(this.valid);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSpanContext) {
            ImmutableSpanContext immutableSpanContext = (ImmutableSpanContext) obj;
            return this.traceId.equals(immutableSpanContext.getTraceId()) && this.spanId.equals(immutableSpanContext.getSpanId()) && this.traceFlags.equals(immutableSpanContext.getTraceFlags()) && this.traceState.equals(immutableSpanContext.getTraceState()) && this.remote == immutableSpanContext.isRemote() && this.valid == immutableSpanContext.isValid();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.traceId.hashCode();
        int hashCode2 = this.spanId.hashCode();
        int hashCode3 = this.traceFlags.hashCode();
        int hashCode4 = this.traceState.hashCode();
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ (this.remote ? 1231 : 1237)) * 1000003) ^ (this.valid ? 1231 : 1237);
    }
}
