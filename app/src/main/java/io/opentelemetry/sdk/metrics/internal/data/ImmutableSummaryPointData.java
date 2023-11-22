package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.SummaryPointData;
import io.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class ImmutableSummaryPointData implements SummaryPointData {
    public static ImmutableSummaryPointData create(long j, long j2, Attributes attributes, long j3, double d, List<ValueAtQuantile> list) {
        return new AutoValue_ImmutableSummaryPointData(j, j2, attributes, Collections.emptyList(), j3, d, list);
    }
}
