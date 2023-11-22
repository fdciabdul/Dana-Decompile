package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
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
public final class LongLastValueAggregator implements Aggregator<LongAccumulation, LongExemplarData> {
    private final Supplier<ExemplarReservoir<LongExemplarData>> reservoirSupplier;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ LongAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ LongAccumulation accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return longAccumulation2;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return longAccumulation2;
    }

    public LongLastValueAggregator(Supplier<ExemplarReservoir<LongExemplarData>> supplier) {
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<LongAccumulation, LongExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, LongAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createLongGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toLongPointList(map, j, j3)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<LongAccumulation, LongExemplarData> {
        @Nullable
        private static final Long DEFAULT_VALUE = null;
        private final AtomicReference<Long> current;

        Handle(ExemplarReservoir<LongExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = new AtomicReference<>(DEFAULT_VALUE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final LongAccumulation doAccumulateThenReset(List<LongExemplarData> list) {
            return LongAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).longValue(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordLong(long j) {
            this.current.set(Long.valueOf(j));
        }
    }
}
