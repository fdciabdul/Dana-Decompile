package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class DoubleLastValueAggregator implements Aggregator<DoubleAccumulation, DoubleExemplarData> {
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    /* JADX WARN: Type inference failed for: r1v1, types: [io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation, java.lang.Object] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ DoubleAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation, java.lang.Object] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ DoubleAccumulation accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return doubleAccumulation2;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return doubleAccumulation2;
    }

    public DoubleLastValueAggregator(Supplier<ExemplarReservoir<DoubleExemplarData>> supplier) {
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<DoubleAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createDoubleGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toDoublePointList(map, j, j3)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<DoubleAccumulation, DoubleExemplarData> {
        @Nullable
        private static final Double DEFAULT_VALUE = null;
        private final AtomicReference<Double> current;

        private Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = new AtomicReference<>(DEFAULT_VALUE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final DoubleAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            return DoubleAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).doubleValue(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordDouble(double d) {
            this.current.set(Double.valueOf(d));
        }
    }
}
