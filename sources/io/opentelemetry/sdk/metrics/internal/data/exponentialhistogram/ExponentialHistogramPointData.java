package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface ExponentialHistogramPointData extends PointData {
    long getCount();

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    List<DoubleExemplarData> getExemplars();

    double getMax();

    double getMin();

    ExponentialHistogramBuckets getNegativeBuckets();

    ExponentialHistogramBuckets getPositiveBuckets();

    int getScale();

    double getSum();

    long getZeroCount();

    boolean hasMax();

    boolean hasMin();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static ExponentialHistogramPointData create(int i, double d, long j, @Nullable Double d2, @Nullable Double d3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j2, long j3, Attributes attributes, List<DoubleExemplarData> list) {
            return ImmutableExponentialHistogramPointData.create(i, d, j, d2, d3, exponentialHistogramBuckets, exponentialHistogramBuckets2, j2, j3, attributes, list);
        }
    }
}
