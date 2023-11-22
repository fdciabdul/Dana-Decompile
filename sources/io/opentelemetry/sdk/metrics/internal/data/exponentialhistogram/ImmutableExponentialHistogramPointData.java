package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class ImmutableExponentialHistogramPointData implements ExponentialHistogramPointData {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableExponentialHistogramPointData create(int i, double d, long j, @Nullable Double d2, @Nullable Double d3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j2, long j3, Attributes attributes, List<DoubleExemplarData> list) {
        long totalCount = exponentialHistogramBuckets.getTotalCount();
        return new AutoValue_ImmutableExponentialHistogramPointData(j2, j3, attributes, i, d, j + totalCount + exponentialHistogramBuckets2.getTotalCount(), j, d2 != null, d2 != null ? d2.doubleValue() : -1.0d, d3 != null, d3 != null ? d3.doubleValue() : -1.0d, exponentialHistogramBuckets, exponentialHistogramBuckets2, list);
    }
}
