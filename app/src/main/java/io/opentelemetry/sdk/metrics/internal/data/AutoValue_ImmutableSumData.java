package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableSumData<T extends PointData> extends ImmutableSumData<T> {
    private final AggregationTemporality aggregationTemporality;
    private final boolean monotonic;
    private final Collection<T> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSumData(Collection<T> collection, boolean z, AggregationTemporality aggregationTemporality) {
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
        this.monotonic = z;
        if (aggregationTemporality == null) {
            throw new NullPointerException("Null aggregationTemporality");
        }
        this.aggregationTemporality = aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.data.Data
    public final Collection<T> getPoints() {
        return this.points;
    }

    @Override // io.opentelemetry.sdk.metrics.data.SumData
    public final boolean isMonotonic() {
        return this.monotonic;
    }

    @Override // io.opentelemetry.sdk.metrics.data.SumData
    public final AggregationTemporality getAggregationTemporality() {
        return this.aggregationTemporality;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableSumData{points=");
        sb.append(this.points);
        sb.append(", monotonic=");
        sb.append(this.monotonic);
        sb.append(", aggregationTemporality=");
        sb.append(this.aggregationTemporality);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSumData) {
            ImmutableSumData immutableSumData = (ImmutableSumData) obj;
            return this.points.equals(immutableSumData.getPoints()) && this.monotonic == immutableSumData.isMonotonic() && this.aggregationTemporality.equals(immutableSumData.getAggregationTemporality());
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.points.hashCode() ^ 1000003) * 1000003) ^ (this.monotonic ? 1231 : 1237)) * 1000003) ^ this.aggregationTemporality.hashCode();
    }
}
