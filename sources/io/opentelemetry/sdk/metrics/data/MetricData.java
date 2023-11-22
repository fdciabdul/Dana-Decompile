package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSummaryData;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes9.dex */
public interface MetricData {
    Data<?> getData();

    String getDescription();

    GaugeData<DoublePointData> getDoubleGaugeData();

    SumData<DoublePointData> getDoubleSumData();

    HistogramData getHistogramData();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    GaugeData<LongPointData> getLongGaugeData();

    SumData<LongPointData> getLongSumData();

    String getName();

    Resource getResource();

    SummaryData getSummaryData();

    MetricDataType getType();

    String getUnit();

    boolean isEmpty();

    /* renamed from: io.opentelemetry.sdk.metrics.data.MetricData$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static GaugeData $default$getDoubleGaugeData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.DOUBLE_GAUGE) {
                return (GaugeData) metricData.getData();
            }
            return ImmutableGaugeData.empty();
        }

        public static GaugeData $default$getLongGaugeData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.LONG_GAUGE) {
                return (GaugeData) metricData.getData();
            }
            return ImmutableGaugeData.empty();
        }

        public static SumData $default$getDoubleSumData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.DOUBLE_SUM) {
                return (ImmutableSumData) metricData.getData();
            }
            return ImmutableSumData.empty();
        }

        public static SumData $default$getLongSumData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.LONG_SUM) {
                return (SumData) metricData.getData();
            }
            return ImmutableSumData.empty();
        }

        public static SummaryData $default$getSummaryData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.SUMMARY) {
                return (SummaryData) metricData.getData();
            }
            return ImmutableSummaryData.empty();
        }

        public static HistogramData $default$getHistogramData(MetricData metricData) {
            if (metricData.getType() == MetricDataType.HISTOGRAM) {
                return (HistogramData) metricData.getData();
            }
            return ImmutableHistogramData.empty();
        }
    }
}
