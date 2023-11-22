package io.opentelemetry.exporter.internal.retry;

import j$.time.Duration;

/* loaded from: classes9.dex */
public abstract class RetryPolicy {
    private static final RetryPolicy DEFAULT = new RetryPolicyBuilder().build();

    public abstract double getBackoffMultiplier();

    public abstract Duration getInitialBackoff();

    public abstract int getMaxAttempts();

    public abstract Duration getMaxBackoff();

    public static RetryPolicy getDefault() {
        return DEFAULT;
    }

    public static RetryPolicyBuilder builder() {
        return new RetryPolicyBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RetryPolicy create(int i, Duration duration, Duration duration2, double d) {
        return new AutoValue_RetryPolicy(i, duration, duration2, d);
    }
}
