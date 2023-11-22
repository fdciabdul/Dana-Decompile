package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import java.util.List;

/* loaded from: classes6.dex */
final class AutoValue_LongAccumulation extends LongAccumulation {
    private final List<LongExemplarData> exemplars;
    private final long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LongAccumulation(long j, List<LongExemplarData> list) {
        this.value = j;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    final long getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    final List<LongExemplarData> getExemplars() {
        return this.exemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LongAccumulation{value=");
        sb.append(this.value);
        sb.append(", exemplars=");
        sb.append(this.exemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LongAccumulation) {
            LongAccumulation longAccumulation = (LongAccumulation) obj;
            return this.value == longAccumulation.getValue() && this.exemplars.equals(longAccumulation.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.value;
        return this.exemplars.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }
}
