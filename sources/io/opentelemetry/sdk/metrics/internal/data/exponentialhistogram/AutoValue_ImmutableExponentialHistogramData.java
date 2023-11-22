package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Collection;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableExponentialHistogramData extends ImmutableExponentialHistogramData {
    private final AggregationTemporality aggregationTemporality;
    private final Collection<ExponentialHistogramPointData> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableExponentialHistogramData(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        if (aggregationTemporality == null) {
            throw new NullPointerException("Null aggregationTemporality");
        }
        this.aggregationTemporality = aggregationTemporality;
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramData, io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData
    public final AggregationTemporality getAggregationTemporality() {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramData, io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData, io.opentelemetry.sdk.metrics.data.Data
    public final Collection<ExponentialHistogramPointData> getPoints() {
        return this.points;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableExponentialHistogramData{aggregationTemporality=");
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
        if (obj instanceof ImmutableExponentialHistogramData) {
            ImmutableExponentialHistogramData immutableExponentialHistogramData = (ImmutableExponentialHistogramData) obj;
            return this.aggregationTemporality.equals(immutableExponentialHistogramData.getAggregationTemporality()) && this.points.equals(immutableExponentialHistogramData.getPoints());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.aggregationTemporality.hashCode() ^ 1000003) * 1000003) ^ this.points.hashCode();
    }
}
