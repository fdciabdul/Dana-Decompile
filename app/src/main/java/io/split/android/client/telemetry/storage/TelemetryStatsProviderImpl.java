package io.split.android.client.telemetry.storage;

import com.google.common.base.Preconditions;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.Stats;

/* loaded from: classes6.dex */
public class TelemetryStatsProviderImpl implements TelemetryStatsProvider {
    private final MySegmentsStorageContainer mMySegmentsStorageContainer;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryStorageConsumer mTelemetryStorageConsumer;
    private volatile Stats pendingStats = null;
    private final Object mLock = new Object();

    public TelemetryStatsProviderImpl(TelemetryStorageConsumer telemetryStorageConsumer, SplitsStorage splitsStorage, MySegmentsStorageContainer mySegmentsStorageContainer) {
        this.mTelemetryStorageConsumer = (TelemetryStorageConsumer) Preconditions.checkNotNull(telemetryStorageConsumer);
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mMySegmentsStorageContainer = (MySegmentsStorageContainer) Preconditions.checkNotNull(mySegmentsStorageContainer);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryStatsProvider
    public Stats getTelemetryStats() {
        if (this.pendingStats == null) {
            synchronized (this.mLock) {
                if (this.pendingStats == null) {
                    this.pendingStats = buildStats();
                }
            }
        }
        return this.pendingStats;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryStatsProvider
    public void clearStats() {
        this.pendingStats = null;
    }

    private Stats buildStats() {
        Stats stats = new Stats();
        stats.setStreamingEvents(this.mTelemetryStorageConsumer.popStreamingEvents());
        stats.setSplitCount(this.mSplitsStorage.getAll().size());
        stats.setTags(this.mTelemetryStorageConsumer.popTags());
        stats.setMethodLatencies(this.mTelemetryStorageConsumer.popLatencies());
        stats.setSegmentCount(this.mMySegmentsStorageContainer.getUniqueAmount());
        stats.setSessionLengthMs(this.mTelemetryStorageConsumer.getSessionLength());
        stats.setLastSynchronizations(this.mTelemetryStorageConsumer.getLastSynchronization());
        stats.setImpressionsDropped(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_DROPPED));
        stats.setImpressionsQueued(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_QUEUED));
        stats.setImpressionsDeduped(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_DEDUPED));
        stats.setMethodExceptions(this.mTelemetryStorageConsumer.popExceptions());
        stats.setHttpLatencies(this.mTelemetryStorageConsumer.popHttpLatencies());
        stats.setHttpErrors(this.mTelemetryStorageConsumer.popHttpErrors());
        stats.setTokenRefreshes(this.mTelemetryStorageConsumer.popTokenRefreshes());
        stats.setAuthRejections(this.mTelemetryStorageConsumer.popAuthRejections());
        stats.setEventsQueued(this.mTelemetryStorageConsumer.getEventsStats(EventsDataRecordsEnum.EVENTS_QUEUED));
        stats.setEventsDropped(this.mTelemetryStorageConsumer.getEventsStats(EventsDataRecordsEnum.EVENTS_DROPPED));
        stats.setUpdatesFromSSE(this.mTelemetryStorageConsumer.popUpdatesFromSSE());
        return stats;
    }
}
