package io.split.android.client.service.sseclient;

/* loaded from: classes6.dex */
public class FixedIntervalBackoffCounter implements BackoffCounter {
    private final long mRetryInterval;

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public void resetCounter() {
    }

    public FixedIntervalBackoffCounter(long j) {
        this.mRetryInterval = j;
    }

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public long getNextRetryTime() {
        return this.mRetryInterval;
    }
}
