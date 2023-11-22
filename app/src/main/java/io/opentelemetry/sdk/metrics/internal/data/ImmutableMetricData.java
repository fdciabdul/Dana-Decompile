package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.GaugeData;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.metrics.data.SumData;
import io.opentelemetry.sdk.metrics.data.SummaryData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes9.dex */
public abstract class ImmutableMetricData implements MetricData {
    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getDoubleGaugeData() {
        return MetricData.CC.$default$getDoubleGaugeData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getDoubleSumData() {
        return MetricData.CC.$default$getDoubleSumData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ HistogramData getHistogramData() {
        return MetricData.CC.$default$getHistogramData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getLongGaugeData() {
        return MetricData.CC.$default$getLongGaugeData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getLongSumData() {
        return MetricData.CC.$default$getLongSumData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SummaryData getSummaryData() {
        return MetricData.CC.$default$getSummaryData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ boolean isEmpty() {
        boolean isEmpty;
        isEmpty = getData().getPoints().isEmpty();
        return isEmpty;
    }

    public static MetricData createDoubleGauge(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, GaugeData<DoublePointData> gaugeData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.DOUBLE_GAUGE, gaugeData);
    }

    public static MetricData createLongGauge(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, GaugeData<LongPointData> gaugeData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.LONG_GAUGE, gaugeData);
    }

    public static MetricData createDoubleSum(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SumData<DoublePointData> sumData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.DOUBLE_SUM, sumData);
    }

    public static MetricData createLongSum(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SumData<LongPointData> sumData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.LONG_SUM, sumData);
    }

    public static MetricData createDoubleSummary(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, SummaryData summaryData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.SUMMARY, summaryData);
    }

    public static MetricData createDoubleHistogram(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, HistogramData histogramData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.HISTOGRAM, histogramData);
    }

    public static MetricData createExponentialHistogram(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, ExponentialHistogramData exponentialHistogramData) {
        return create(resource, instrumentationScopeInfo, str, str2, str3, MetricDataType.EXPONENTIAL_HISTOGRAM, exponentialHistogramData);
    }

    static ImmutableMetricData create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, MetricDataType metricDataType, Data<?> data) {
        return new AutoValue_ImmutableMetricData(resource, instrumentationScopeInfo, str, str2, str3, metricDataType, data);
    }
}
