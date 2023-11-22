package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableExponentialHistogramPointData extends ImmutableExponentialHistogramPointData {
    private final Attributes getAttributes;
    private final long getCount;
    private final long getEpochNanos;
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final ExponentialHistogramBuckets getNegativeBuckets;
    private final ExponentialHistogramBuckets getPositiveBuckets;
    private final int getScale;
    private final long getStartEpochNanos;
    private final double getSum;
    private final long getZeroCount;
    private final boolean hasMax;
    private final boolean hasMin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableExponentialHistogramPointData(long j, long j2, Attributes attributes, int i, double d, long j3, long j4, boolean z, double d2, boolean z2, double d3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, List<DoubleExemplarData> list) {
        this.getStartEpochNanos = j;
        this.getEpochNanos = j2;
        if (attributes == null) {
            throw new NullPointerException("Null getAttributes");
        }
        this.getAttributes = attributes;
        this.getScale = i;
        this.getSum = d;
        this.getCount = j3;
        this.getZeroCount = j4;
        this.hasMin = z;
        this.getMin = d2;
        this.hasMax = z2;
        this.getMax = d3;
        if (exponentialHistogramBuckets == null) {
            throw new NullPointerException("Null getPositiveBuckets");
        }
        this.getPositiveBuckets = exponentialHistogramBuckets;
        if (exponentialHistogramBuckets2 == null) {
            throw new NullPointerException("Null getNegativeBuckets");
        }
        this.getNegativeBuckets = exponentialHistogramBuckets2;
        if (list == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list;
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

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final int getScale() {
        return this.getScale;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final long getCount() {
        return this.getCount;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final long getZeroCount() {
        return this.getZeroCount;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final boolean hasMin() {
        return this.hasMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final boolean hasMax() {
        return this.hasMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final ExponentialHistogramBuckets getPositiveBuckets() {
        return this.getPositiveBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData
    public final ExponentialHistogramBuckets getNegativeBuckets() {
        return this.getNegativeBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData, io.opentelemetry.sdk.metrics.data.PointData
    public final List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableExponentialHistogramPointData{getStartEpochNanos=");
        sb.append(this.getStartEpochNanos);
        sb.append(", getEpochNanos=");
        sb.append(this.getEpochNanos);
        sb.append(", getAttributes=");
        sb.append(this.getAttributes);
        sb.append(", getScale=");
        sb.append(this.getScale);
        sb.append(", getSum=");
        sb.append(this.getSum);
        sb.append(", getCount=");
        sb.append(this.getCount);
        sb.append(", getZeroCount=");
        sb.append(this.getZeroCount);
        sb.append(", hasMin=");
        sb.append(this.hasMin);
        sb.append(", getMin=");
        sb.append(this.getMin);
        sb.append(", hasMax=");
        sb.append(this.hasMax);
        sb.append(", getMax=");
        sb.append(this.getMax);
        sb.append(", getPositiveBuckets=");
        sb.append(this.getPositiveBuckets);
        sb.append(", getNegativeBuckets=");
        sb.append(this.getNegativeBuckets);
        sb.append(", getExemplars=");
        sb.append(this.getExemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableExponentialHistogramPointData) {
            ImmutableExponentialHistogramPointData immutableExponentialHistogramPointData = (ImmutableExponentialHistogramPointData) obj;
            return this.getStartEpochNanos == immutableExponentialHistogramPointData.getStartEpochNanos() && this.getEpochNanos == immutableExponentialHistogramPointData.getEpochNanos() && this.getAttributes.equals(immutableExponentialHistogramPointData.getAttributes()) && this.getScale == immutableExponentialHistogramPointData.getScale() && Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(immutableExponentialHistogramPointData.getSum()) && this.getCount == immutableExponentialHistogramPointData.getCount() && this.getZeroCount == immutableExponentialHistogramPointData.getZeroCount() && this.hasMin == immutableExponentialHistogramPointData.hasMin() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(immutableExponentialHistogramPointData.getMin()) && this.hasMax == immutableExponentialHistogramPointData.hasMax() && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(immutableExponentialHistogramPointData.getMax()) && this.getPositiveBuckets.equals(immutableExponentialHistogramPointData.getPositiveBuckets()) && this.getNegativeBuckets.equals(immutableExponentialHistogramPointData.getNegativeBuckets()) && this.getExemplars.equals(immutableExponentialHistogramPointData.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.getStartEpochNanos;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.getEpochNanos;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode = this.getAttributes.hashCode();
        int i3 = this.getScale;
        int doubleToLongBits = (int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum));
        long j3 = this.getCount;
        int i4 = (int) (j3 ^ (j3 >>> 32));
        long j4 = this.getZeroCount;
        int i5 = (int) (j4 ^ (j4 >>> 32));
        int i6 = this.hasMin ? 1231 : 1237;
        int doubleToLongBits2 = (int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin));
        int i7 = this.hasMax ? 1231 : 1237;
        int doubleToLongBits3 = (int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax));
        return ((((((((((((((((((((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ i3) * 1000003) ^ doubleToLongBits) * 1000003) ^ i4) * 1000003) ^ i5) * 1000003) ^ i6) * 1000003) ^ doubleToLongBits2) * 1000003) ^ i7) * 1000003) ^ doubleToLongBits3) * 1000003) ^ this.getPositiveBuckets.hashCode()) * 1000003) ^ this.getNegativeBuckets.hashCode()) * 1000003) ^ this.getExemplars.hashCode();
    }
}
