package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes.dex */
public abstract class MeterProviderSharedState {
    public abstract Clock getClock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ExemplarFilter getExemplarFilter();

    public abstract Resource getResource();

    public abstract long getStartEpochNanos();

    public static MeterProviderSharedState create(Clock clock, Resource resource, ExemplarFilter exemplarFilter, long j) {
        return new AutoValue_MeterProviderSharedState(clock, resource, j, exemplarFilter);
    }
}
