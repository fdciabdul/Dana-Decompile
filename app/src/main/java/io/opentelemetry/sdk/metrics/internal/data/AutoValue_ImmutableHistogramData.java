package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableHistogramData extends ImmutableHistogramData {
    private final AggregationTemporality aggregationTemporality;
    private final Collection<HistogramPointData> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableHistogramData(AggregationTemporality aggregationTemporality, Collection<HistogramPointData> collection) {
        if (aggregationTemporality == null) {
            throw new NullPointerException("Null aggregationTemporality");
        }
        this.aggregationTemporality = aggregationTemporality;
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramData
    public final AggregationTemporality getAggregationTemporality() {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.data.HistogramData, io.opentelemetry.sdk.metrics.data.Data
    public final Collection<HistogramPointData> getPoints() {
        return this.points;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableHistogramData{aggregationTemporality=");
        sb.append(this.aggregationTemporality);
        sb.append(", points=");
        sb.append(this.points);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableHistogramData) {
            ImmutableHistogramData immutableHistogramData = (ImmutableHistogramData) obj;
            return this.aggregationTemporality.equals(immutableHistogramData.getAggregationTemporality()) && this.points.equals(immutableHistogramData.getPoints());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.aggregationTemporality.hashCode() ^ 1000003) * 1000003) ^ this.points.hashCode();
    }
}
