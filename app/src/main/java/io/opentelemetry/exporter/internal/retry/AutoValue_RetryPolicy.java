package io.opentelemetry.exporter.internal.retry;

import j$.time.Duration;

/* loaded from: classes9.dex */
final class AutoValue_RetryPolicy extends RetryPolicy {
    private final double backoffMultiplier;
    private final Duration initialBackoff;
    private final int maxAttempts;
    private final Duration maxBackoff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_RetryPolicy(int i, Duration duration, Duration duration2, double d) {
        this.maxAttempts = i;
        if (duration == null) {
            throw new NullPointerException("Null initialBackoff");
        }
        this.initialBackoff = duration;
        if (duration2 == null) {
            throw new NullPointerException("Null maxBackoff");
        }
        this.maxBackoff = duration2;
        this.backoffMultiplier = d;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public final int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public final Duration getInitialBackoff() {
        return this.initialBackoff;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public final Duration getMaxBackoff() {
        return this.maxBackoff;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public final double getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RetryPolicy{maxAttempts=");
        sb.append(this.maxAttempts);
        sb.append(", initialBackoff=");
        sb.append(this.initialBackoff);
        sb.append(", maxBackoff=");
        sb.append(this.maxBackoff);
        sb.append(", backoffMultiplier=");
        sb.append(this.backoffMultiplier);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RetryPolicy) {
            RetryPolicy retryPolicy = (RetryPolicy) obj;
            return this.maxAttempts == retryPolicy.getMaxAttempts() && this.initialBackoff.equals(retryPolicy.getInitialBackoff()) && this.maxBackoff.equals(retryPolicy.getMaxBackoff()) && Double.doubleToLongBits(this.backoffMultiplier) == Double.doubleToLongBits(retryPolicy.getBackoffMultiplier());
        }
        return false;
    }

    public final int hashCode() {
        int i = this.maxAttempts;
        return ((((((i ^ 1000003) * 1000003) ^ this.initialBackoff.hashCode()) * 1000003) ^ this.maxBackoff.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.backoffMultiplier) >>> 32) ^ Double.doubleToLongBits(this.backoffMultiplier)));
    }
}
