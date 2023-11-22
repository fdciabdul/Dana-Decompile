package io.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.sdk.internal.PrimitiveLongList;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter;
import io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DoubleExponentialHistogramBuckets implements ExponentialHistogramBuckets {
    private final ExponentialCounterFactory counterFactory;
    private ExponentialCounter counts;
    private ExponentialHistogramIndexer exponentialHistogramIndexer;
    private int scale;
    private long totalCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleExponentialHistogramBuckets(int i, int i2, ExponentialCounterFactory exponentialCounterFactory) {
        this.counterFactory = exponentialCounterFactory;
        this.counts = exponentialCounterFactory.newCounter(i2);
        this.scale = i;
        this.exponentialHistogramIndexer = ExponentialHistogramIndexer.get(i);
        this.totalCount = 0L;
    }

    DoubleExponentialHistogramBuckets(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        ExponentialCounterFactory exponentialCounterFactory = doubleExponentialHistogramBuckets.counterFactory;
        this.counterFactory = exponentialCounterFactory;
        this.counts = exponentialCounterFactory.copy(doubleExponentialHistogramBuckets.counts);
        this.scale = doubleExponentialHistogramBuckets.scale;
        this.exponentialHistogramIndexer = doubleExponentialHistogramBuckets.exponentialHistogramIndexer;
        this.totalCount = doubleExponentialHistogramBuckets.totalCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DoubleExponentialHistogramBuckets copy() {
        return new DoubleExponentialHistogramBuckets(this);
    }

    public final void clear() {
        this.totalCount = 0L;
        this.counts.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean record(double d) {
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalStateException("Illegal attempted recording of zero at bucket level.");
        }
        boolean increment = this.counts.increment(this.exponentialHistogramIndexer.computeIndex(d), 1L);
        if (increment) {
            this.totalCount++;
        }
        return increment;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public final int getOffset() {
        if (this.counts.isEmpty()) {
            return 0;
        }
        return this.counts.getIndexStart();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    @Nonnull
    public final List<Long> getBucketCounts() {
        if (this.counts.isEmpty()) {
            return Collections.emptyList();
        }
        int indexEnd = (this.counts.getIndexEnd() - this.counts.getIndexStart()) + 1;
        long[] jArr = new long[indexEnd];
        for (int i = 0; i < indexEnd; i++) {
            ExponentialCounter exponentialCounter = this.counts;
            jArr[i] = exponentialCounter.get(exponentialCounter.getIndexStart() + i);
        }
        return PrimitiveLongList.wrap(jArr);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public final long getTotalCount() {
        return this.totalCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void downscale(int i) {
        if (i == 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot downscale by negative amount. Was given ");
            sb.append(i);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
        if (!this.counts.isEmpty()) {
            ExponentialCounter copy = this.counterFactory.copy(this.counts);
            copy.clear();
            for (int indexStart = this.counts.getIndexStart(); indexStart <= this.counts.getIndexEnd(); indexStart++) {
                long j = this.counts.get(indexStart);
                if (j > 0 && !copy.increment(indexStart >> i, j)) {
                    throw new IllegalStateException("Failed to create new downscaled buckets.");
                }
            }
            this.counts = copy;
        }
        int i2 = this.scale - i;
        this.scale = i2;
        this.exponentialHistogramIndexer = ExponentialHistogramIndexer.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleExponentialHistogramBuckets merge(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2) {
        if (doubleExponentialHistogramBuckets2.counts.isEmpty()) {
            return doubleExponentialHistogramBuckets;
        }
        if (doubleExponentialHistogramBuckets.counts.isEmpty()) {
            return doubleExponentialHistogramBuckets2;
        }
        DoubleExponentialHistogramBuckets copy = doubleExponentialHistogramBuckets.copy();
        copy.mergeWith(doubleExponentialHistogramBuckets2);
        return copy;
    }

    private void mergeWith(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        long min;
        int max;
        if (doubleExponentialHistogramBuckets.counts.isEmpty()) {
            return;
        }
        int min2 = Math.min(this.scale, doubleExponentialHistogramBuckets.scale);
        int i = this.scale - min2;
        int i2 = doubleExponentialHistogramBuckets.scale - min2;
        if (this.counts.isEmpty()) {
            min = doubleExponentialHistogramBuckets.getOffset() >> i2;
            max = doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i2;
        } else {
            min = Math.min(getOffset() >> i, doubleExponentialHistogramBuckets.getOffset() >> i2);
            max = Math.max(this.counts.getIndexEnd() >> i, doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i2);
        }
        downscale(i + getScaleReduction(min, max));
        int i3 = doubleExponentialHistogramBuckets.scale;
        int i4 = this.scale;
        for (int offset = doubleExponentialHistogramBuckets.getOffset(); offset <= doubleExponentialHistogramBuckets.counts.getIndexEnd(); offset++) {
            if (!this.counts.increment(offset >> (i3 - i4), doubleExponentialHistogramBuckets.counts.get(offset))) {
                throw new IllegalStateException("Failed to merge exponential histogram buckets.");
            }
        }
        this.totalCount += doubleExponentialHistogramBuckets.totalCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getScale() {
        return this.scale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getScaleReduction(double d) {
        long computeIndex = this.exponentialHistogramIndexer.computeIndex(d);
        return getScaleReduction(Math.min(computeIndex, this.counts.getIndexStart()), Math.max(computeIndex, this.counts.getIndexEnd()));
    }

    final int getScaleReduction(long j, long j2) {
        int i = 0;
        while ((j2 - j) + 1 > this.counts.getMaxSize()) {
            j >>= 1;
            j2 >>= 1;
            i++;
        }
        return i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof DoubleExponentialHistogramBuckets) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = (DoubleExponentialHistogramBuckets) obj;
            return this.scale == doubleExponentialHistogramBuckets.scale && sameBucketCounts(doubleExponentialHistogramBuckets);
        }
        return false;
    }

    private boolean sameBucketCounts(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        if (this.totalCount != doubleExponentialHistogramBuckets.totalCount) {
            return false;
        }
        int min = Math.min(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        if (min == Integer.MIN_VALUE) {
            min = Math.max(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        }
        int max = Math.max(this.counts.getIndexEnd(), doubleExponentialHistogramBuckets.counts.getIndexEnd());
        while (min <= max) {
            if (this.counts.get(min) != doubleExponentialHistogramBuckets.counts.get(min)) {
                return false;
            }
            min++;
        }
        return true;
    }

    public final int hashCode() {
        int i = 1000003;
        for (int indexStart = this.counts.getIndexStart(); indexStart <= this.counts.getIndexEnd(); indexStart++) {
            long j = this.counts.get(indexStart);
            if (j != 0) {
                i = ((int) (j ^ ((i ^ indexStart) * 1000003))) * 1000003;
            }
        }
        return this.scale ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleExponentialHistogramBuckets{scale: ");
        sb.append(this.scale);
        sb.append(", offset: ");
        sb.append(getOffset());
        sb.append(", counts: ");
        sb.append(this.counts);
        sb.append(" }");
        return sb.toString();
    }
}
