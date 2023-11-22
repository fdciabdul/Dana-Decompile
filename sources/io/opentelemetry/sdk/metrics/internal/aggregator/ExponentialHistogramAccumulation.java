package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ExponentialHistogramAccumulation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<DoubleExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMin();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract DoubleExponentialHistogramBuckets getNegativeBuckets();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract DoubleExponentialHistogramBuckets getPositiveBuckets();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getScale();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getSum();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getZeroCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasMinMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExponentialHistogramAccumulation create(int i, double d, boolean z, double d2, double d3, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2, long j, List<DoubleExemplarData> list) {
        return new AutoValue_ExponentialHistogramAccumulation(i, d, z, d2, d3, doubleExponentialHistogramBuckets, doubleExponentialHistogramBuckets2, j, list);
    }
}
