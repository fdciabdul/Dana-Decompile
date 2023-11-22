package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import java.util.List;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableSummaryPointData extends ImmutableSummaryPointData {
    private final Attributes attributes;
    private final long count;
    private final long epochNanos;
    private final List<? extends ExemplarData> exemplars;
    private final long startEpochNanos;
    private final double sum;
    private final List<ValueAtQuantile> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSummaryPointData(long j, long j2, Attributes attributes, List<? extends ExemplarData> list, long j3, double d, List<ValueAtQuantile> list2) {
        this.startEpochNanos = j;
        this.epochNanos = j2;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
        this.count = j3;
        this.sum = d;
        if (list2 == null) {
            throw new NullPointerException("Null values");
        }
        this.values = list2;
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

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final List<? extends ExemplarData> getExemplars() {
        return this.exemplars;
    }

    @Override // io.opentelemetry.sdk.metrics.data.SummaryPointData
    public final long getCount() {
        return this.count;
    }

    @Override // io.opentelemetry.sdk.metrics.data.SummaryPointData
    public final double getSum() {
        return this.sum;
    }

    @Override // io.opentelemetry.sdk.metrics.data.SummaryPointData
    public final List<ValueAtQuantile> getValues() {
        return this.values;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableSummaryPointData{startEpochNanos=");
        sb.append(this.startEpochNanos);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", exemplars=");
        sb.append(this.exemplars);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", sum=");
        sb.append(this.sum);
        sb.append(", values=");
        sb.append(this.values);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSummaryPointData) {
            ImmutableSummaryPointData immutableSummaryPointData = (ImmutableSummaryPointData) obj;
            return this.startEpochNanos == immutableSummaryPointData.getStartEpochNanos() && this.epochNanos == immutableSummaryPointData.getEpochNanos() && this.attributes.equals(immutableSummaryPointData.getAttributes()) && this.exemplars.equals(immutableSummaryPointData.getExemplars()) && this.count == immutableSummaryPointData.getCount() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(immutableSummaryPointData.getSum()) && this.values.equals(immutableSummaryPointData.getValues());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.startEpochNanos;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.epochNanos;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode = this.attributes.hashCode();
        int hashCode2 = this.exemplars.hashCode();
        long j3 = this.count;
        int doubleToLongBits = (int) ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum));
        return ((((((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ hashCode2) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ doubleToLongBits) * 1000003) ^ this.values.hashCode();
    }
}
