package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.SummaryData;
import io.opentelemetry.sdk.metrics.data.SummaryPointData;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes9.dex */
public abstract class ImmutableSummaryData implements SummaryData {
    private static final ImmutableSummaryData EMPTY = create(Collections.emptyList());

    public static ImmutableSummaryData empty() {
        return EMPTY;
    }

    public static ImmutableSummaryData create(Collection<SummaryPointData> collection) {
        return new AutoValue_ImmutableSummaryData(collection);
    }
}
