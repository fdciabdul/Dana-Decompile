package io.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class DoubleExponentialHistogramAggregator implements Aggregator<ExponentialHistogramAccumulation, DoubleExemplarData> {
    private final ExponentialBucketStrategy bucketStrategy;
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExponentialHistogramAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExponentialHistogramAccumulation accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExponentialHistogramAccumulation diff(ExponentialHistogramAccumulation exponentialHistogramAccumulation, ExponentialHistogramAccumulation exponentialHistogramAccumulation2) {
        return Aggregator.CC.$default$diff(this, exponentialHistogramAccumulation, exponentialHistogramAccumulation2);
    }

    public DoubleExponentialHistogramAggregator(Supplier<ExemplarReservoir<DoubleExemplarData>> supplier, int i) {
        this(supplier, ExponentialBucketStrategy.newStrategy(i, ExponentialCounterFactory.CC.circularBufferCounter()));
    }

    DoubleExponentialHistogramAggregator(Supplier<ExemplarReservoir<DoubleExemplarData>> supplier, ExponentialBucketStrategy exponentialBucketStrategy) {
        this.reservoirSupplier = supplier;
        this.bucketStrategy = exponentialBucketStrategy;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<ExponentialHistogramAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get(), this.bucketStrategy);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final ExponentialHistogramAccumulation merge(ExponentialHistogramAccumulation exponentialHistogramAccumulation, ExponentialHistogramAccumulation exponentialHistogramAccumulation2) {
        double d;
        double d2;
        double min;
        double max;
        DoubleExponentialHistogramBuckets merge = DoubleExponentialHistogramBuckets.merge(exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation2.getPositiveBuckets());
        DoubleExponentialHistogramBuckets merge2 = DoubleExponentialHistogramBuckets.merge(exponentialHistogramAccumulation.getNegativeBuckets(), exponentialHistogramAccumulation2.getNegativeBuckets());
        int min2 = Math.min(merge.getScale(), merge2.getScale());
        merge.downscale(merge.getScale() - min2);
        merge2.downscale(merge2.getScale() - min2);
        if (exponentialHistogramAccumulation.hasMinMax() && exponentialHistogramAccumulation2.hasMinMax()) {
            min = Math.min(exponentialHistogramAccumulation.getMin(), exponentialHistogramAccumulation2.getMin());
            max = Math.max(exponentialHistogramAccumulation.getMax(), exponentialHistogramAccumulation2.getMax());
        } else if (exponentialHistogramAccumulation.hasMinMax()) {
            min = exponentialHistogramAccumulation.getMin();
            max = exponentialHistogramAccumulation.getMax();
        } else if (exponentialHistogramAccumulation2.hasMinMax()) {
            min = exponentialHistogramAccumulation2.getMin();
            max = exponentialHistogramAccumulation2.getMax();
        } else {
            d = -1.0d;
            d2 = -1.0d;
            return ExponentialHistogramAccumulation.create(merge.getScale(), exponentialHistogramAccumulation2.getSum() + exponentialHistogramAccumulation.getSum(), !exponentialHistogramAccumulation.hasMinMax() || exponentialHistogramAccumulation2.hasMinMax(), d, d2, merge, merge2, exponentialHistogramAccumulation.getZeroCount() + exponentialHistogramAccumulation2.getZeroCount(), exponentialHistogramAccumulation2.getExemplars());
        }
        d = min;
        d2 = max;
        return ExponentialHistogramAccumulation.create(merge.getScale(), exponentialHistogramAccumulation2.getSum() + exponentialHistogramAccumulation.getSum(), !exponentialHistogramAccumulation.hasMinMax() || exponentialHistogramAccumulation2.hasMinMax(), d, d2, merge, merge2, exponentialHistogramAccumulation.getZeroCount() + exponentialHistogramAccumulation2.getZeroCount(), exponentialHistogramAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, ExponentialHistogramAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createExponentialHistogram(resource, instrumentationScopeInfo, name, description, unit, ExponentialHistogramData.CC.create(aggregationTemporality, MetricDataUtils.toExponentialHistogramPointList(map, j, j3)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<ExponentialHistogramAccumulation, DoubleExemplarData> {
        private long count;
        private double max;
        private double min;
        private final DoubleExponentialHistogramBuckets negativeBuckets;
        private final DoubleExponentialHistogramBuckets positiveBuckets;
        private double sum;
        private long zeroCount;

        Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir, ExponentialBucketStrategy exponentialBucketStrategy) {
            super(exemplarReservoir);
            this.sum = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.zeroCount = 0L;
            this.min = Double.MAX_VALUE;
            this.max = -1.0d;
            this.count = 0L;
            this.positiveBuckets = exponentialBucketStrategy.newBuckets();
            this.negativeBuckets = exponentialBucketStrategy.newBuckets();
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final ExponentialHistogramAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            ExponentialHistogramAccumulation create;
            synchronized (this) {
                int scale = this.positiveBuckets.getScale();
                double d = this.sum;
                long j = this.count;
                create = ExponentialHistogramAccumulation.create(scale, d, j > 0, j > 0 ? this.min : -1.0d, j > 0 ? this.max : -1.0d, this.positiveBuckets.copy(), this.negativeBuckets.copy(), this.zeroCount, list);
                this.sum = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.zeroCount = 0L;
                this.min = Double.MAX_VALUE;
                this.max = -1.0d;
                this.count = 0L;
                this.positiveBuckets.clear();
                this.negativeBuckets.clear();
            }
            return create;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordDouble(double d) {
            synchronized (this) {
                if (DoubleExponentialHistogramAggregator$Handle$$ExternalSyntheticBackport0.m(d)) {
                    this.sum += d;
                    this.min = Math.min(this.min, d);
                    this.max = Math.max(this.max, d);
                    this.count++;
                    int compare = Double.compare(d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    if (compare == 0) {
                        this.zeroCount++;
                        return;
                    }
                    DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = compare > 0 ? this.positiveBuckets : this.negativeBuckets;
                    if (!doubleExponentialHistogramBuckets.record(d)) {
                        downScale(doubleExponentialHistogramBuckets.getScaleReduction(d));
                        doubleExponentialHistogramBuckets.record(d);
                    }
                }
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordLong(long j) {
            doRecordDouble(j);
        }

        final void downScale(int i) {
            this.positiveBuckets.downscale(i);
            this.negativeBuckets.downscale(i);
        }
    }
}
