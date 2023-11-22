package io.split.android.client.service.synchronizer;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class SyncGuardianImpl implements SyncGuardian {
    private final AtomicLong mDefaultMaxSyncPeriod;
    private boolean mIsInitialized;
    private final AtomicLong mLastSyncTimestamp;
    private final AtomicLong mMaxSyncPeriod;
    private final TimestampProvider mNewTimestamp;
    private final boolean mStreamingEnabled;
    private final boolean mSyncEnabled;

    /* loaded from: classes6.dex */
    interface TimestampProvider {
        long get();
    }

    public SyncGuardianImpl(SplitClientConfig splitClientConfig) {
        this(splitClientConfig, null);
    }

    SyncGuardianImpl(SplitClientConfig splitClientConfig, TimestampProvider timestampProvider) {
        this.mIsInitialized = false;
        long defaultSSEConnectionDelay = splitClientConfig.defaultSSEConnectionDelay();
        this.mDefaultMaxSyncPeriod = new AtomicLong(defaultSSEConnectionDelay);
        this.mMaxSyncPeriod = new AtomicLong(defaultSSEConnectionDelay);
        this.mLastSyncTimestamp = new AtomicLong(0L);
        this.mSyncEnabled = splitClientConfig.syncEnabled();
        this.mStreamingEnabled = splitClientConfig.streamingEnabled();
        this.mNewTimestamp = timestampProvider == null ? new TimestampProvider() { // from class: io.split.android.client.service.synchronizer.SyncGuardianImpl$$ExternalSyntheticLambda0
            @Override // io.split.android.client.service.synchronizer.SyncGuardianImpl.TimestampProvider
            public final long get() {
                long seconds;
                seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                return seconds;
            }
        } : timestampProvider;
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void updateLastSyncTimestamp() {
        this.mLastSyncTimestamp.set(this.mNewTimestamp.get());
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public boolean mustSync() {
        return this.mIsInitialized && this.mSyncEnabled && this.mStreamingEnabled && this.mNewTimestamp.get() - this.mLastSyncTimestamp.get() >= this.mMaxSyncPeriod.get();
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void setMaxSyncPeriod(long j) {
        this.mMaxSyncPeriod.set(Math.max(j, this.mDefaultMaxSyncPeriod.get()));
        StringBuilder sb = new StringBuilder();
        sb.append("Setting new max sync period: ");
        sb.append(this.mMaxSyncPeriod.get());
        sb.append(" seconds");
        Logger.v(sb.toString());
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void initialize() {
        if (this.mIsInitialized) {
            return;
        }
        this.mIsInitialized = true;
    }
}
