package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.SpanLimits;

/* loaded from: classes6.dex */
final class AutoValue_ImmutableExceptionEventData extends C$AutoValue_ImmutableExceptionEventData {
    private volatile transient Attributes getAttributes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableExceptionEventData(final long j, final Throwable th, final Attributes attributes, final SpanLimits spanLimits) {
        new ImmutableExceptionEventData(j, th, attributes, spanLimits) { // from class: io.opentelemetry.sdk.trace.internal.data.$AutoValue_ImmutableExceptionEventData
            private final Attributes additionalAttributes;
            private final long epochNanos;
            private final Throwable exception;
            private final SpanLimits spanLimits;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.epochNanos = j;
                if (th == null) {
                    throw new NullPointerException("Null exception");
                }
                this.exception = th;
                if (attributes == null) {
                    throw new NullPointerException("Null additionalAttributes");
                }
                this.additionalAttributes = attributes;
                if (spanLimits == null) {
                    throw new NullPointerException("Null spanLimits");
                }
                this.spanLimits = spanLimits;
            }

            @Override // io.opentelemetry.sdk.trace.data.EventData
            public long getEpochNanos() {
                return this.epochNanos;
            }

            @Override // io.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Throwable getException() {
                return this.exception;
            }

            @Override // io.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Attributes getAdditionalAttributes() {
                return this.additionalAttributes;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.opentelemetry.sdk.trace.internal.data.ImmutableExceptionEventData
            public SpanLimits getSpanLimits() {
                return this.spanLimits;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("ImmutableExceptionEventData{epochNanos=");
                sb.append(this.epochNanos);
                sb.append(", exception=");
                sb.append(this.exception);
                sb.append(", additionalAttributes=");
                sb.append(this.additionalAttributes);
                sb.append(", spanLimits=");
                sb.append(this.spanLimits);
                sb.append("}");
                return sb.toString();
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof ImmutableExceptionEventData) {
                    ImmutableExceptionEventData immutableExceptionEventData = (ImmutableExceptionEventData) obj;
                    return this.epochNanos == immutableExceptionEventData.getEpochNanos() && this.exception.equals(immutableExceptionEventData.getException()) && this.additionalAttributes.equals(immutableExceptionEventData.getAdditionalAttributes()) && this.spanLimits.equals(immutableExceptionEventData.getSpanLimits());
                }
                return false;
            }

            public int hashCode() {
                long j2 = this.epochNanos;
                int i = (int) (j2 ^ (j2 >>> 32));
                int hashCode = this.exception.hashCode();
                return ((((hashCode ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ this.additionalAttributes.hashCode()) * 1000003) ^ this.spanLimits.hashCode();
            }
        };
    }

    @Override // io.opentelemetry.sdk.trace.internal.data.ImmutableExceptionEventData, io.opentelemetry.sdk.trace.data.EventData
    public final Attributes getAttributes() {
        if (this.getAttributes == null) {
            synchronized (this) {
                if (this.getAttributes == null) {
                    this.getAttributes = super.getAttributes();
                    if (this.getAttributes == null) {
                        throw new NullPointerException("getAttributes() cannot return null");
                    }
                }
            }
        }
        return this.getAttributes;
    }
}
