package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class DoubleSumAggregator extends AbstractSumAggregator<DoubleAccumulation, DoubleExemplarData> {
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    public DoubleSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir<DoubleExemplarData>> supplier) {
        super(instrumentDescriptor);
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<DoubleAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AbstractSumAggregator, io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final DoubleAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return DoubleAccumulation.create(d);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return DoubleAccumulation.create(doubleAccumulation.getValue() + doubleAccumulation2.getValue(), doubleAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AbstractSumAggregator, io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return DoubleAccumulation.create(doubleAccumulation2.getValue() - doubleAccumulation.getValue(), doubleAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean isMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createDoubleSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(isMonotonic, aggregationTemporality, MetricDataUtils.toDoublePointList(map, j, j3)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<DoubleAccumulation, DoubleExemplarData> {
        private final DoubleAdder current;

        Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = AdderUtil.createDoubleAdder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final DoubleAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            return DoubleAccumulation.create(this.current.sumThenReset(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordDouble(double d) {
            this.current.add(d);
        }
    }
}
