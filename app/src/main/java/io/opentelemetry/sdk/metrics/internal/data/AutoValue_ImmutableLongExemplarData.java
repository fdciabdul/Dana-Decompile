package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ImmutableLongExemplarData extends ImmutableLongExemplarData {
    private final long epochNanos;
    private final Attributes filteredAttributes;
    private final SpanContext spanContext;
    private final long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableLongExemplarData(Attributes attributes, long j, SpanContext spanContext, long j2) {
        if (attributes == null) {
            throw new NullPointerException("Null filteredAttributes");
        }
        this.filteredAttributes = attributes;
        this.epochNanos = j;
        if (spanContext == null) {
            throw new NullPointerException("Null spanContext");
        }
        this.spanContext = spanContext;
        this.value = j2;
    }

    @Override // io.opentelemetry.sdk.metrics.data.ExemplarData
    public final Attributes getFilteredAttributes() {
        return this.filteredAttributes;
    }

    @Override // io.opentelemetry.sdk.metrics.data.ExemplarData
    public final long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.ExemplarData
    public final SpanContext getSpanContext() {
        return this.spanContext;
    }

    @Override // io.opentelemetry.sdk.metrics.data.LongExemplarData
    public final long getValue() {
        return this.value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableLongExemplarData{filteredAttributes=");
        sb.append(this.filteredAttributes);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", spanContext=");
        sb.append(this.spanContext);
        sb.append(", value=");
        sb.append(this.value);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableLongExemplarData) {
            ImmutableLongExemplarData immutableLongExemplarData = (ImmutableLongExemplarData) obj;
            return this.filteredAttributes.equals(immutableLongExemplarData.getFilteredAttributes()) && this.epochNanos == immutableLongExemplarData.getEpochNanos() && this.spanContext.equals(immutableLongExemplarData.getSpanContext()) && this.value == immutableLongExemplarData.getValue();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.filteredAttributes.hashCode();
        long j = this.epochNanos;
        int i = (int) (j ^ (j >>> 32));
        int hashCode2 = this.spanContext.hashCode();
        long j2 = this.value;
        return ((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ hashCode2) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }
}
