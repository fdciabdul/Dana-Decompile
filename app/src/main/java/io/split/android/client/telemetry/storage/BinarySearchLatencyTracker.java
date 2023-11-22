package io.split.android.client.telemetry.storage;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class BinarySearchLatencyTracker implements ILatencyTracker {
    private long[] latencies = new long[BUCKETS.length];
    private static final long MAX_LATENCY = 7481828;
    private static final long[] BUCKETS = {1000, 1500, 2250, 3375, 5063, 7594, 11391, 17086, 25629, 38443, 57665, 86498, 129746, 194620, 291929, 437894, 656841, 985261, 1477892, 2216838, 3325257, 4987885, MAX_LATENCY};

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void addLatencyMillis(long j) {
        int findIndex = findIndex(j * 1000);
        long[] jArr = this.latencies;
        jArr[findIndex] = jArr[findIndex] + 1;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void addLatencyMicros(long j) {
        int findIndex = findIndex(j);
        long[] jArr = this.latencies;
        jArr[findIndex] = jArr[findIndex] + 1;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long[] getLatencies() {
        return this.latencies;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getLatency(int i) {
        return this.latencies[i];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void clear() {
        this.latencies = new long[BUCKETS.length];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getBucketForLatencyMillis(long j) {
        return this.latencies[findIndex(j * 1000)];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getBucketForLatencyMicros(long j) {
        return this.latencies[findIndex(j)];
    }

    private int findIndex(long j) {
        if (j > MAX_LATENCY) {
            return BUCKETS.length - 1;
        }
        int binarySearch = Arrays.binarySearch(BUCKETS, j);
        return binarySearch < 0 ? -(binarySearch + 1) : binarySearch;
    }
}
