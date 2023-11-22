package io.opentelemetry.sdk.metrics.internal.aggregator;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.resources.Resource;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface Aggregator<T, U extends ExemplarData> {
    @Nullable
    T accumulateDoubleMeasurement(double d, Attributes attributes, Context context);

    @Nullable
    T accumulateLongMeasurement(long j, Attributes attributes, Context context);

    AggregatorHandle<T, U> createHandle();

    T diff(T t, T t2);

    T merge(T t, T t2);

    MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, T> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<T, U extends ExemplarData> {
        public static Aggregator<Object, DoubleExemplarData> drop() {
            return DropAggregator.INSTANCE;
        }

        @Nullable
        public static Object $default$accumulateLongMeasurement(Aggregator aggregator, long j, Attributes attributes, Context context) {
            AggregatorHandle<T, U> createHandle = aggregator.createHandle();
            createHandle.recordLong(j, attributes, context);
            return createHandle.accumulateThenReset(attributes);
        }

        @Nullable
        public static Object $default$accumulateDoubleMeasurement(Aggregator aggregator, double d, Attributes attributes, Context context) {
            AggregatorHandle<T, U> createHandle = aggregator.createHandle();
            createHandle.recordDouble(d, attributes, context);
            return createHandle.accumulateThenReset(attributes);
        }

        public static Object $default$diff(Aggregator aggregator, Object obj, Object obj2) {
            throw new UnsupportedOperationException("This aggregator does not support diff.");
        }
    }
}
