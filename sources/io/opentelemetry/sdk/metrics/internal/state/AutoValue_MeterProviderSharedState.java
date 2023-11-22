package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes2.dex */
final class AutoValue_MeterProviderSharedState extends MeterProviderSharedState {
    private final Clock clock;
    private final ExemplarFilter exemplarFilter;
    private final Resource resource;
    private final long startEpochNanos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_MeterProviderSharedState(Clock clock, Resource resource, long j, ExemplarFilter exemplarFilter) {
        if (clock == null) {
            throw new NullPointerException("Null clock");
        }
        this.clock = clock;
        if (resource == null) {
            throw new NullPointerException("Null resource");
        }
        this.resource = resource;
        this.startEpochNanos = j;
        if (exemplarFilter == null) {
            throw new NullPointerException("Null exemplarFilter");
        }
        this.exemplarFilter = exemplarFilter;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public final Clock getClock() {
        return this.clock;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public final Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public final long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    final ExemplarFilter getExemplarFilter() {
        return this.exemplarFilter;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MeterProviderSharedState{clock=");
        sb.append(this.clock);
        sb.append(", resource=");
        sb.append(this.resource);
        sb.append(", startEpochNanos=");
        sb.append(this.startEpochNanos);
        sb.append(", exemplarFilter=");
        sb.append(this.exemplarFilter);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MeterProviderSharedState) {
            MeterProviderSharedState meterProviderSharedState = (MeterProviderSharedState) obj;
            return this.clock.equals(meterProviderSharedState.getClock()) && this.resource.equals(meterProviderSharedState.getResource()) && this.startEpochNanos == meterProviderSharedState.getStartEpochNanos() && this.exemplarFilter.equals(meterProviderSharedState.getExemplarFilter());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.clock.hashCode();
        int hashCode2 = this.resource.hashCode();
        long j = this.startEpochNanos;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.exemplarFilter.hashCode();
    }
}
