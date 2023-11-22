package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.sdk.metrics.data.PointData;

/* loaded from: classes9.dex */
public interface SumData<T extends PointData> extends Data<T> {
    AggregationTemporality getAggregationTemporality();

    boolean isMonotonic();
}
