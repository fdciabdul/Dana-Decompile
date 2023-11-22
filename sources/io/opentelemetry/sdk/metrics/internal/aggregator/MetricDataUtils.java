package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.internal.PrimitiveLongList;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableDoublePointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import j$.util.Map;
import j$.util.function.BiConsumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
final class MetricDataUtils {
    private MetricDataUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMonotonicInstrument(InstrumentDescriptor instrumentDescriptor) {
        InstrumentType type = instrumentDescriptor.getType();
        return type == InstrumentType.HISTOGRAM || type == InstrumentType.COUNTER || type == InstrumentType.OBSERVABLE_COUNTER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<LongPointData> toLongPointList(Map<Attributes, LongAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda3
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                arrayList.add(ImmutableLongPointData.create(j, j2, (Attributes) obj, r6.getValue(), ((LongAccumulation) obj2).getExemplars()));
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<DoublePointData> toDoublePointList(java.util.Map<Attributes, DoubleAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda2
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                arrayList.add(ImmutableDoublePointData.create(j, j2, (Attributes) obj, r6.getValue(), ((DoubleAccumulation) obj2).getExemplars()));
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<HistogramPointData> toExplicitBucketHistogramPointList(java.util.Map<Attributes, ExplicitBucketHistogramAccumulation> map, final long j, final long j2, final List<Double> list) {
        final ArrayList arrayList = new ArrayList(map.size());
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toExplicitBucketHistogramPointList$2(arrayList, j, j2, list, (Attributes) obj, (ExplicitBucketHistogramAccumulation) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$toExplicitBucketHistogramPointList$2(List list, long j, long j2, List list2, Attributes attributes, ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation) {
        List<Long> wrap = PrimitiveLongList.wrap((long[]) explicitBucketHistogramAccumulation.getCounts().clone());
        double sum = explicitBucketHistogramAccumulation.getSum();
        double min = explicitBucketHistogramAccumulation.getMin();
        double max = explicitBucketHistogramAccumulation.getMax();
        list.add(ImmutableHistogramPointData.create(j, j2, attributes, sum, Double.valueOf(min), Double.valueOf(max), list2, wrap, explicitBucketHistogramAccumulation.getExemplars()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ExponentialHistogramPointData> toExponentialHistogramPointList(java.util.Map<Attributes, ExponentialHistogramAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda1
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricDataUtils.lambda$toExponentialHistogramPointList$3(arrayList, j, j2, (Attributes) obj, (ExponentialHistogramAccumulation) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$toExponentialHistogramPointList$3(List list, long j, long j2, Attributes attributes, ExponentialHistogramAccumulation exponentialHistogramAccumulation) {
        int scale = exponentialHistogramAccumulation.getScale();
        double sum = exponentialHistogramAccumulation.getSum();
        long zeroCount = exponentialHistogramAccumulation.getZeroCount();
        double min = exponentialHistogramAccumulation.getMin();
        double max = exponentialHistogramAccumulation.getMax();
        list.add(ExponentialHistogramPointData.CC.create(scale, sum, zeroCount, Double.valueOf(min), Double.valueOf(max), exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation.getNegativeBuckets(), j, j2, attributes, exponentialHistogramAccumulation.getExemplars()));
    }
}
