package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ImmutableDoubleExemplarData extends ImmutableDoubleExemplarData {
    private final long epochNanos;
    private final Attributes filteredAttributes;
    private final SpanContext spanContext;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableDoubleExemplarData(Attributes attributes, long j, SpanContext spanContext, double d) {
        if (attributes == null) {
            throw new NullPointerException("Null filteredAttributes");
        }
        this.filteredAttributes = attributes;
        this.epochNanos = j;
        if (spanContext == null) {
            throw new NullPointerException("Null spanContext");
        }
        this.spanContext = spanContext;
        this.value = d;
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

    @Override // io.opentelemetry.sdk.metrics.data.DoubleExemplarData
    public final double getValue() {
        return this.value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableDoubleExemplarData{filteredAttributes=");
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
        if (obj instanceof ImmutableDoubleExemplarData) {
            ImmutableDoubleExemplarData immutableDoubleExemplarData = (ImmutableDoubleExemplarData) obj;
            return this.filteredAttributes.equals(immutableDoubleExemplarData.getFilteredAttributes()) && this.epochNanos == immutableDoubleExemplarData.getEpochNanos() && this.spanContext.equals(immutableDoubleExemplarData.getSpanContext()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableDoubleExemplarData.getValue());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.filteredAttributes.hashCode();
        long j = this.epochNanos;
        return ((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.spanContext.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
