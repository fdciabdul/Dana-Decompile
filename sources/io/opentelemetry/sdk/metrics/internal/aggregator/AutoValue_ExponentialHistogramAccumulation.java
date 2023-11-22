package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* loaded from: classes6.dex */
final class AutoValue_ExponentialHistogramAccumulation extends ExponentialHistogramAccumulation {
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final DoubleExponentialHistogramBuckets getNegativeBuckets;
    private final DoubleExponentialHistogramBuckets getPositiveBuckets;
    private final int getScale;
    private final double getSum;
    private final long getZeroCount;
    private final boolean hasMinMax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ExponentialHistogramAccumulation(int i, double d, boolean z, double d2, double d3, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2, long j, List<DoubleExemplarData> list) {
        this.getScale = i;
        this.getSum = d;
        this.hasMinMax = z;
        this.getMin = d2;
        this.getMax = d3;
        if (doubleExponentialHistogramBuckets == null) {
            throw new NullPointerException("Null getPositiveBuckets");
        }
        this.getPositiveBuckets = doubleExponentialHistogramBuckets;
        if (doubleExponentialHistogramBuckets2 == null) {
            throw new NullPointerException("Null getNegativeBuckets");
        }
        this.getNegativeBuckets = doubleExponentialHistogramBuckets2;
        this.getZeroCount = j;
        if (list == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final int getScale() {
        return this.getScale;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final boolean hasMinMax() {
        return this.hasMinMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final DoubleExponentialHistogramBuckets getPositiveBuckets() {
        return this.getPositiveBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final DoubleExponentialHistogramBuckets getNegativeBuckets() {
        return this.getNegativeBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final long getZeroCount() {
        return this.getZeroCount;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    final List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExponentialHistogramAccumulation{getScale=");
        sb.append(this.getScale);
        sb.append(", getSum=");
        sb.append(this.getSum);
        sb.append(", hasMinMax=");
        sb.append(this.hasMinMax);
        sb.append(", getMin=");
        sb.append(this.getMin);
        sb.append(", getMax=");
        sb.append(this.getMax);
        sb.append(", getPositiveBuckets=");
        sb.append(this.getPositiveBuckets);
        sb.append(", getNegativeBuckets=");
        sb.append(this.getNegativeBuckets);
        sb.append(", getZeroCount=");
        sb.append(this.getZeroCount);
        sb.append(", getExemplars=");
        sb.append(this.getExemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExponentialHistogramAccumulation) {
            ExponentialHistogramAccumulation exponentialHistogramAccumulation = (ExponentialHistogramAccumulation) obj;
            return this.getScale == exponentialHistogramAccumulation.getScale() && Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(exponentialHistogramAccumulation.getSum()) && this.hasMinMax == exponentialHistogramAccumulation.hasMinMax() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(exponentialHistogramAccumulation.getMin()) && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(exponentialHistogramAccumulation.getMax()) && this.getPositiveBuckets.equals(exponentialHistogramAccumulation.getPositiveBuckets()) && this.getNegativeBuckets.equals(exponentialHistogramAccumulation.getNegativeBuckets()) && this.getZeroCount == exponentialHistogramAccumulation.getZeroCount() && this.getExemplars.equals(exponentialHistogramAccumulation.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        int i = this.getScale;
        int doubleToLongBits = (int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum));
        int i2 = this.hasMinMax ? 1231 : 1237;
        int doubleToLongBits2 = (int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin));
        int doubleToLongBits3 = (int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax));
        int hashCode = this.getPositiveBuckets.hashCode();
        int hashCode2 = this.getNegativeBuckets.hashCode();
        long j = this.getZeroCount;
        return ((((((((((((((((i ^ 1000003) * 1000003) ^ doubleToLongBits) * 1000003) ^ i2) * 1000003) ^ doubleToLongBits2) * 1000003) ^ doubleToLongBits3) * 1000003) ^ hashCode) * 1000003) ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.getExemplars.hashCode();
    }
}
