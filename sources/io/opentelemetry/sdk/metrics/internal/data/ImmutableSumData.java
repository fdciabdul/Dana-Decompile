package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.metrics.data.SumData;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes9.dex */
public abstract class ImmutableSumData<T extends PointData> implements SumData<T> {
    static final ImmutableSumData<DoublePointData> EMPTY = create(false, AggregationTemporality.CUMULATIVE, Collections.emptyList());

    public static <T extends PointData> ImmutableSumData<T> empty() {
        return EMPTY;
    }

    public static <T extends PointData> ImmutableSumData<T> create(boolean z, AggregationTemporality aggregationTemporality, Collection<T> collection) {
        return new AutoValue_ImmutableSumData(collection, z, aggregationTemporality);
    }
}
