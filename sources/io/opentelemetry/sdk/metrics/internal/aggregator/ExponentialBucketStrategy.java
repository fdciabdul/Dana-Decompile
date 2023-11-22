package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;

/* loaded from: classes6.dex */
final class ExponentialBucketStrategy {
    private static final int STARTING_SCALE = 20;
    private final ExponentialCounterFactory counterFactory;
    private final int maxBuckets;

    private ExponentialBucketStrategy(int i, ExponentialCounterFactory exponentialCounterFactory) {
        this.maxBuckets = i;
        this.counterFactory = exponentialCounterFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DoubleExponentialHistogramBuckets newBuckets() {
        return new DoubleExponentialHistogramBuckets(20, this.maxBuckets, this.counterFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExponentialBucketStrategy newStrategy(int i, ExponentialCounterFactory exponentialCounterFactory) {
        return new ExponentialBucketStrategy(i, exponentialCounterFactory);
    }
}
