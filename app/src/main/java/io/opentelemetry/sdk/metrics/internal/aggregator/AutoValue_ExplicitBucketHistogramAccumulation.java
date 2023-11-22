package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
final class AutoValue_ExplicitBucketHistogramAccumulation extends ExplicitBucketHistogramAccumulation {
    private final long[] getCounts;
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final double getSum;
    private final boolean hasMinMax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ExplicitBucketHistogramAccumulation(double d, boolean z, double d2, double d3, long[] jArr, List<DoubleExemplarData> list) {
        this.getSum = d;
        this.hasMinMax = z;
        this.getMin = d2;
        this.getMax = d3;
        if (jArr == null) {
            throw new NullPointerException("Null getCounts");
        }
        this.getCounts = jArr;
        if (list == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final boolean hasMinMax() {
        return this.hasMinMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final long[] getCounts() {
        return this.getCounts;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    final List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExplicitBucketHistogramAccumulation{getSum=");
        sb.append(this.getSum);
        sb.append(", hasMinMax=");
        sb.append(this.hasMinMax);
        sb.append(", getMin=");
        sb.append(this.getMin);
        sb.append(", getMax=");
        sb.append(this.getMax);
        sb.append(", getCounts=");
        sb.append(Arrays.toString(this.getCounts));
        sb.append(", getExemplars=");
        sb.append(this.getExemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExplicitBucketHistogramAccumulation) {
            ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation = (ExplicitBucketHistogramAccumulation) obj;
            if (Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getSum()) && this.hasMinMax == explicitBucketHistogramAccumulation.hasMinMax() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getMin()) && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getMax())) {
                if (Arrays.equals(this.getCounts, explicitBucketHistogramAccumulation instanceof AutoValue_ExplicitBucketHistogramAccumulation ? ((AutoValue_ExplicitBucketHistogramAccumulation) explicitBucketHistogramAccumulation).getCounts : explicitBucketHistogramAccumulation.getCounts()) && this.getExemplars.equals(explicitBucketHistogramAccumulation.getExemplars())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int doubleToLongBits = (int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum));
        int i = this.hasMinMax ? 1231 : 1237;
        int doubleToLongBits2 = (int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin));
        return ((((((((i ^ ((doubleToLongBits ^ 1000003) * 1000003)) * 1000003) ^ doubleToLongBits2) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax)))) * 1000003) ^ Arrays.hashCode(this.getCounts)) * 1000003) ^ this.getExemplars.hashCode();
    }
}
