package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import java.util.Collection;

/* loaded from: classes9.dex */
public interface ExponentialHistogramData extends Data<ExponentialHistogramPointData> {
    AggregationTemporality getAggregationTemporality();

    @Override // io.opentelemetry.sdk.metrics.data.Data
    Collection<ExponentialHistogramPointData> getPoints();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static ExponentialHistogramData create(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
            return ImmutableExponentialHistogramData.create(aggregationTemporality, collection);
        }

        public static ExponentialHistogramData fromMetricData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.EXPONENTIAL_HISTOGRAM) {
                return (ExponentialHistogramData) metricData.getData();
            }
            return ImmutableExponentialHistogramData.empty();
        }
    }
}
