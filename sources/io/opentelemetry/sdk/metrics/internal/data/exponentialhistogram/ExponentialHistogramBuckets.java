package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import java.util.List;

/* loaded from: classes3.dex */
public interface ExponentialHistogramBuckets {
    List<Long> getBucketCounts();

    int getOffset();

    long getTotalCount();
}
