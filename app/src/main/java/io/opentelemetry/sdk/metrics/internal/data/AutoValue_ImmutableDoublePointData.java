package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableDoublePointData extends ImmutableDoublePointData {
    private final Attributes attributes;
    private final long epochNanos;
    private final List<DoubleExemplarData> exemplars;
    private final long startEpochNanos;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableDoublePointData(long j, long j2, Attributes attributes, double d, List<DoubleExemplarData> list) {
        this.startEpochNanos = j;
        this.epochNanos = j2;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.value = d;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.metrics.data.DoublePointData
    public final double getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.data.DoublePointData, io.opentelemetry.sdk.metrics.data.PointData
    public final List<DoubleExemplarData> getExemplars() {
        return this.exemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableDoublePointData{startEpochNanos=");
        sb.append(this.startEpochNanos);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", exemplars=");
        sb.append(this.exemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableDoublePointData) {
            ImmutableDoublePointData immutableDoublePointData = (ImmutableDoublePointData) obj;
            return this.startEpochNanos == immutableDoublePointData.getStartEpochNanos() && this.epochNanos == immutableDoublePointData.getEpochNanos() && this.attributes.equals(immutableDoublePointData.getAttributes()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableDoublePointData.getValue()) && this.exemplars.equals(immutableDoublePointData.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.startEpochNanos;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.epochNanos;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode = this.attributes.hashCode();
        return ((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)))) * 1000003) ^ this.exemplars.hashCode();
    }
}
