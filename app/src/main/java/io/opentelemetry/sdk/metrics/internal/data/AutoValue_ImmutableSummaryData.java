package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.SummaryPointData;
import java.util.Collection;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableSummaryData extends ImmutableSummaryData {
    private final Collection<SummaryPointData> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSummaryData(Collection<SummaryPointData> collection) {
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.data.Data
    public final Collection<SummaryPointData> getPoints() {
        return this.points;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableSummaryData{points=");
        sb.append(this.points);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSummaryData) {
            return this.points.equals(((ImmutableSummaryData) obj).getPoints());
        }
        return false;
    }

    public final int hashCode() {
        return this.points.hashCode() ^ 1000003;
    }
}
