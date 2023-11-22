package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableGaugeData<T extends PointData> extends ImmutableGaugeData<T> {
    private final Collection<T> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableGaugeData(Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData, io.opentelemetry.sdk.metrics.data.Data
    public final Collection<T> getPoints() {
        return this.points;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableGaugeData{points=");
        sb.append(this.points);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableGaugeData) {
            return this.points.equals(((ImmutableGaugeData) obj).getPoints());
        }
        return false;
    }

    public final int hashCode() {
        return this.points.hashCode() ^ 1000003;
    }
}
