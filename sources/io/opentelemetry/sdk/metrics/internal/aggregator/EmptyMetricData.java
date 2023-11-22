package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.GaugeData;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.metrics.data.SumData;
import io.opentelemetry.sdk.metrics.data.SummaryData;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes9.dex */
public final class EmptyMetricData implements MetricData {
    private static final EmptyMetricData INSTANCE = new EmptyMetricData();

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ GaugeData getDoubleGaugeData() {
        return MetricData.CC.$default$getDoubleGaugeData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ SumData getDoubleSumData() {
        return MetricData.CC.$default$getDoubleSumData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ HistogramData getHistogramData() {
        return MetricData.CC.$default$getHistogramData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ GaugeData getLongGaugeData() {
        return MetricData.CC.$default$getLongGaugeData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ SumData getLongSumData() {
        return MetricData.CC.$default$getLongSumData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final /* synthetic */ SummaryData getSummaryData() {
        return MetricData.CC.$default$getSummaryData(this);
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final boolean isEmpty() {
        return true;
    }

    private EmptyMetricData() {
    }

    public static MetricData getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final Resource getResource() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getResource().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getInstrumentationScopeInfo().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getName() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getName().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getDescription() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getDescription().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getUnit() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getUnit().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final MetricDataType getType() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getType().");
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final Data<?> getData() {
        throw new UnsupportedOperationException("EmptyMetricData does not support getData().");
    }
}
