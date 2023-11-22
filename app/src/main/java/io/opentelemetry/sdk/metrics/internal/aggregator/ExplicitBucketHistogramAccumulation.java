package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ExplicitBucketHistogramAccumulation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long[] getCounts();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<DoubleExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMin();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getSum();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasMinMax();

    static ExplicitBucketHistogramAccumulation create(double d, boolean z, double d2, double d3, long[] jArr) {
        return create(d, z, d2, d3, jArr, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExplicitBucketHistogramAccumulation create(double d, boolean z, double d2, double d3, long[] jArr, List<DoubleExemplarData> list) {
        return new AutoValue_ExplicitBucketHistogramAccumulation(d, z, d2, d3, jArr, list);
    }
}
