package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;
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
public final class LongSumAggregator extends AbstractSumAggregator<LongAccumulation, LongExemplarData> {
    private final Supplier<ExemplarReservoir<LongExemplarData>> reservoirSupplier;

    public LongSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir<LongExemplarData>> supplier) {
        super(instrumentDescriptor);
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<LongAccumulation, LongExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return LongAccumulation.create(longAccumulation.getValue() + longAccumulation2.getValue(), longAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AbstractSumAggregator, io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return LongAccumulation.create(longAccumulation2.getValue() - longAccumulation.getValue(), longAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, LongAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean isMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createLongSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(isMonotonic, aggregationTemporality, MetricDataUtils.toLongPointList(map, j, j3)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<LongAccumulation, LongExemplarData> {
        private final LongAdder current;

        Handle(ExemplarReservoir<LongExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = AdderUtil.createLongAdder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final LongAccumulation doAccumulateThenReset(List<LongExemplarData> list) {
            return LongAccumulation.create(this.current.sumThenReset(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final void doRecordLong(long j) {
            this.current.add(j);
        }
    }
}
