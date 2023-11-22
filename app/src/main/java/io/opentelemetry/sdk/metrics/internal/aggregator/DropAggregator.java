package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class DropAggregator implements Aggregator<Object, DoubleExemplarData> {
    private static final Object ACCUMULATION = new Object();
    public static final Aggregator<Object, DoubleExemplarData> INSTANCE = new DropAggregator();
    private static final AggregatorHandle<Object, DoubleExemplarData> HANDLE = new AggregatorHandle<Object, DoubleExemplarData>(ExemplarReservoir.CC.doubleNoSamples()) { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.DropAggregator.1
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordDouble(double d) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordLong(long j) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected Object doAccumulateThenReset(List<DoubleExemplarData> list) {
            return DropAggregator.ACCUMULATION;
        }
    };

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ Object accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ Object accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ Object diff(Object obj, Object obj2) {
        return Aggregator.CC.$default$diff(this, obj, obj2);
    }

    private DropAggregator() {
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<Object, DoubleExemplarData> createHandle() {
        return HANDLE;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final Object merge(Object obj, Object obj2) {
        return ACCUMULATION;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, Object> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        return EmptyMetricData.getInstance();
    }
}
