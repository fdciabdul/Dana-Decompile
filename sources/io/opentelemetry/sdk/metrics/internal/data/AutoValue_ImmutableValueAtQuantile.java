package io.opentelemetry.sdk.metrics.internal.data;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableValueAtQuantile extends ImmutableValueAtQuantile {
    private final double quantile;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableValueAtQuantile(double d, double d2) {
        this.quantile = d;
        this.value = d2;
    }

    @Override // io.opentelemetry.sdk.metrics.data.ValueAtQuantile
    public final double getQuantile() {
        return this.quantile;
    }

    @Override // io.opentelemetry.sdk.metrics.data.ValueAtQuantile
    public final double getValue() {
        return this.value;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableValueAtQuantile{quantile=");
        sb.append(this.quantile);
        sb.append(", value=");
        sb.append(this.value);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableValueAtQuantile) {
            ImmutableValueAtQuantile immutableValueAtQuantile = (ImmutableValueAtQuantile) obj;
            return Double.doubleToLongBits(this.quantile) == Double.doubleToLongBits(immutableValueAtQuantile.getQuantile()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(immutableValueAtQuantile.getValue());
        }
        return false;
    }

    public final int hashCode() {
        return ((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value))) ^ ((((int) ((Double.doubleToLongBits(this.quantile) >>> 32) ^ Double.doubleToLongBits(this.quantile))) ^ 1000003) * 1000003);
    }
}
