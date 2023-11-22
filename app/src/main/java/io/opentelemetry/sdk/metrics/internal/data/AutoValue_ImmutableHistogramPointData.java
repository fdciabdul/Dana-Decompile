package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableHistogramPointData extends ImmutableHistogramPointData {
    private final Attributes getAttributes;
    private final List<Double> getBoundaries;
    private final long getCount;
    private final List<Long> getCounts;
    private final long getEpochNanos;
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final long getStartEpochNanos;
    private final double getSum;
    private final boolean hasMax;
    private final boolean hasMin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableHistogramPointData(long j, long j2, Attributes attributes, double d, long j3, boolean z, double d2, boolean z2, double d3, List<Double> list, List<Long> list2, List<DoubleExemplarData> list3) {
        this.getStartEpochNanos = j;
        this.getEpochNanos = j2;
        if (attributes == null) {
            throw new NullPointerException("Null getAttributes");
        }
        this.getAttributes = attributes;
        this.getSum = d;
        this.getCount = j3;
        this.hasMin = z;
        this.getMin = d2;
        this.hasMax = z2;
        this.getMax = d3;
        if (list == null) {
            throw new NullPointerException("Null getBoundaries");
        }
        this.getBoundaries = list;
        if (list2 == null) {
            throw new NullPointerException("Null getCounts");
        }
        this.getCounts = list2;
        if (list3 == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list3;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getStartEpochNanos() {
        return this.getStartEpochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getEpochNanos() {
        return this.getEpochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final Attributes getAttributes() {
        return this.getAttributes;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final long getCount() {
        return this.getCount;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final boolean hasMin() {
        return this.hasMin;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final boolean hasMax() {
        return this.hasMax;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final List<Double> getBoundaries() {
        return this.getBoundaries;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData
    public final List<Long> getCounts() {
        return this.getCounts;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramPointData, io.opentelemetry.sdk.metrics.data.PointData
    public final List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableHistogramPointData{getStartEpochNanos=");
        sb.append(this.getStartEpochNanos);
        sb.append(", getEpochNanos=");
        sb.append(this.getEpochNanos);
        sb.append(", getAttributes=");
        sb.append(this.getAttributes);
        sb.append(", getSum=");
        sb.append(this.getSum);
        sb.append(", getCount=");
        sb.append(this.getCount);
        sb.append(", hasMin=");
        sb.append(this.hasMin);
        sb.append(", getMin=");
        sb.append(this.getMin);
        sb.append(", hasMax=");
        sb.append(this.hasMax);
        sb.append(", getMax=");
        sb.append(this.getMax);
        sb.append(", getBoundaries=");
        sb.append(this.getBoundaries);
        sb.append(", getCounts=");
        sb.append(this.getCounts);
        sb.append(", getExemplars=");
        sb.append(this.getExemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableHistogramPointData) {
            ImmutableHistogramPointData immutableHistogramPointData = (ImmutableHistogramPointData) obj;
            return this.getStartEpochNanos == immutableHistogramPointData.getStartEpochNanos() && this.getEpochNanos == immutableHistogramPointData.getEpochNanos() && this.getAttributes.equals(immutableHistogramPointData.getAttributes()) && Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(immutableHistogramPointData.getSum()) && this.getCount == immutableHistogramPointData.getCount() && this.hasMin == immutableHistogramPointData.hasMin() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(immutableHistogramPointData.getMin()) && this.hasMax == immutableHistogramPointData.hasMax() && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(immutableHistogramPointData.getMax()) && this.getBoundaries.equals(immutableHistogramPointData.getBoundaries()) && this.getCounts.equals(immutableHistogramPointData.getCounts()) && this.getExemplars.equals(immutableHistogramPointData.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.getStartEpochNanos;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.getEpochNanos;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode = this.getAttributes.hashCode();
        int doubleToLongBits = (int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum));
        long j3 = this.getCount;
        int i3 = (int) (j3 ^ (j3 >>> 32));
        int i4 = this.hasMin ? 1231 : 1237;
        int doubleToLongBits2 = (int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin));
        int i5 = this.hasMax ? 1231 : 1237;
        int doubleToLongBits3 = (int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax));
        return ((((((((((((((((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ doubleToLongBits) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ doubleToLongBits2) * 1000003) ^ i5) * 1000003) ^ doubleToLongBits3) * 1000003) ^ this.getBoundaries.hashCode()) * 1000003) ^ this.getCounts.hashCode()) * 1000003) ^ this.getExemplars.hashCode();
    }
}
