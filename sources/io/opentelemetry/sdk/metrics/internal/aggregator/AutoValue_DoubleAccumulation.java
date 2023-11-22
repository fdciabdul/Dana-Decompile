package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* loaded from: classes6.dex */
final class AutoValue_DoubleAccumulation extends DoubleAccumulation {
    private final List<DoubleExemplarData> exemplars;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_DoubleAccumulation(double d, List<DoubleExemplarData> list) {
        this.value = d;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    public final double getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    final List<DoubleExemplarData> getExemplars() {
        return this.exemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleAccumulation{value=");
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
        if (obj instanceof DoubleAccumulation) {
            DoubleAccumulation doubleAccumulation = (DoubleAccumulation) obj;
            return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(doubleAccumulation.getValue()) && this.exemplars.equals(doubleAccumulation.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        return this.exemplars.hashCode() ^ ((((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value))) ^ 1000003) * 1000003);
    }
}
