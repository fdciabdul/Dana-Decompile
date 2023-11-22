package io.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public final class DoubleExplicitBucketHistogramAggregator implements Aggregator<ExplicitBucketHistogramAccumulation, DoubleExemplarData> {
    private final double[] boundaries;
    private final List<Double> boundaryList;
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    /* JADX WARN: Type inference failed for: r1v1, types: [io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation, java.lang.Object] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExplicitBucketHistogramAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation, java.lang.Object] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExplicitBucketHistogramAccumulation accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation, java.lang.Object] */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final /* synthetic */ ExplicitBucketHistogramAccumulation diff(ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation, ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation2) {
        return Aggregator.CC.$default$diff(this, explicitBucketHistogramAccumulation, explicitBucketHistogramAccumulation2);
    }

    public DoubleExplicitBucketHistogramAggregator(double[] dArr, Supplier<ExemplarReservoir<DoubleExemplarData>> supplier) {
        this.boundaries = dArr;
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        this.boundaryList = Collections.unmodifiableList(arrayList);
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final AggregatorHandle<ExplicitBucketHistogramAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.boundaries, this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final ExplicitBucketHistogramAccumulation merge(ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation, ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation2) {
        double d;
        double d2;
        double min;
        double max;
        long[] counts = explicitBucketHistogramAccumulation.getCounts();
        long[] jArr = new long[counts.length];
        for (int i = 0; i < counts.length; i++) {
            jArr[i] = counts[i] + explicitBucketHistogramAccumulation2.getCounts()[i];
        }
        if (explicitBucketHistogramAccumulation.hasMinMax() && explicitBucketHistogramAccumulation2.hasMinMax()) {
            min = Math.min(explicitBucketHistogramAccumulation.getMin(), explicitBucketHistogramAccumulation2.getMin());
            max = Math.max(explicitBucketHistogramAccumulation.getMax(), explicitBucketHistogramAccumulation2.getMax());
        } else if (explicitBucketHistogramAccumulation.hasMinMax()) {
            min = explicitBucketHistogramAccumulation.getMin();
            max = explicitBucketHistogramAccumulation.getMax();
        } else if (explicitBucketHistogramAccumulation2.hasMinMax()) {
            min = explicitBucketHistogramAccumulation2.getMin();
            max = explicitBucketHistogramAccumulation2.getMax();
        } else {
            d = -1.0d;
            d2 = -1.0d;
            return ExplicitBucketHistogramAccumulation.create(explicitBucketHistogramAccumulation.getSum() + explicitBucketHistogramAccumulation2.getSum(), !explicitBucketHistogramAccumulation.hasMinMax() || explicitBucketHistogramAccumulation2.hasMinMax(), d, d2, jArr, explicitBucketHistogramAccumulation2.getExemplars());
        }
        d2 = max;
        d = min;
        return ExplicitBucketHistogramAccumulation.create(explicitBucketHistogramAccumulation.getSum() + explicitBucketHistogramAccumulation2.getSum(), !explicitBucketHistogramAccumulation.hasMinMax() || explicitBucketHistogramAccumulation2.hasMinMax(), d, d2, jArr, explicitBucketHistogramAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public final MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, ExplicitBucketHistogramAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        DoubleExplicitBucketHistogramAggregator doubleExplicitBucketHistogramAggregator;
        long j4;
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            doubleExplicitBucketHistogramAggregator = this;
            j4 = j2;
        } else {
            doubleExplicitBucketHistogramAggregator = this;
            j4 = j;
        }
        return ImmutableMetricData.createDoubleHistogram(resource, instrumentationScopeInfo, name, description, unit, ImmutableHistogramData.create(aggregationTemporality, MetricDataUtils.toExplicitBucketHistogramPointList(map, j4, j3, doubleExplicitBucketHistogramAggregator.boundaryList)));
    }

    /* loaded from: classes6.dex */
    static final class Handle extends AggregatorHandle<ExplicitBucketHistogramAccumulation, DoubleExemplarData> {
        private final double[] boundaries;
        private long count;
        private final long[] counts;
        private final ReentrantLock lock;
        private double max;
        private double min;
        private double sum;

        Handle(double[] dArr, ExemplarReservoir<DoubleExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.lock = new ReentrantLock();
            this.boundaries = dArr;
            this.counts = new long[dArr.length + 1];
            this.sum = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.min = Double.MAX_VALUE;
            this.max = -1.0d;
            this.count = 0L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public final ExplicitBucketHistogramAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            this.lock.lock();
            try {
                double d = this.sum;
                long j = this.count;
                boolean z = j > 0;
                double d2 = j > 0 ? this.min : -1.0d;
                double d3 = j > 0 ? this.max : -1.0d;
                long[] jArr = this.counts;
                ExplicitBucketHistogramAccumulation create = ExplicitBucketHistogramAccumulation.create(d, z, d2, d3, Arrays.copyOf(jArr, jArr.length), list);
                this.sum = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.min = Double.MAX_VALUE;
                this.max = -1.0d;
                this.count = 0L;
                Arrays.fill(this.counts, 0L);
                return create;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordDouble(double d) {
            int findBucketIndex = ExplicitBucketHistogramUtils.findBucketIndex(this.boundaries, d);
            this.lock.lock();
            try {
                this.sum += d;
                this.min = Math.min(this.min, d);
                this.max = Math.max(this.max, d);
                this.count++;
                long[] jArr = this.counts;
                jArr[findBucketIndex] = jArr[findBucketIndex] + 1;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected final void doRecordLong(long j) {
            doRecordDouble(j);
        }
    }
}
