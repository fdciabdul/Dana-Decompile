package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.GaugeData;
import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes9.dex */
public abstract class ImmutableGaugeData<T extends PointData> implements GaugeData<T> {
    private static final ImmutableGaugeData<DoublePointData> EMPTY = create(Collections.emptyList());

    @Override // io.opentelemetry.sdk.metrics.data.Data
    public abstract Collection<T> getPoints();

    public static <T extends PointData> ImmutableGaugeData<T> empty() {
        return EMPTY;
    }

    public static <T extends PointData> ImmutableGaugeData<T> create(Collection<T> collection) {
        return new AutoValue_ImmutableGaugeData(collection);
    }
}
