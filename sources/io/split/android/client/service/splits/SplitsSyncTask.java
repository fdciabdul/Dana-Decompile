package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.synchronizer.SplitsChangeChecker;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;

/* loaded from: classes6.dex */
public class SplitsSyncTask implements SplitTask {
    private final long mCacheExpirationInSeconds;
    private final SplitsChangeChecker mChangeChecker = new SplitsChangeChecker();
    private final boolean mCheckCacheExpiration;
    private final ISplitEventsManager mEventsManager;
    private final String mSplitsFilterQueryString;
    private final SplitsStorage mSplitsStorage;
    private final SplitsSyncHelper mSplitsSyncHelper;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    private String sanitizeString(String str) {
        return str == null ? "" : str;
    }

    public static SplitsSyncTask build(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, boolean z, long j, String str, ISplitEventsManager iSplitEventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        return new SplitsSyncTask(splitsSyncHelper, splitsStorage, z, j, str, telemetryRuntimeProducer, iSplitEventsManager);
    }

    public static SplitTask buildForBackground(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, boolean z, long j, String str, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        return new SplitsSyncTask(splitsSyncHelper, splitsStorage, z, j, str, telemetryRuntimeProducer, null);
    }

    private SplitsSyncTask(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, boolean z, long j, String str, TelemetryRuntimeProducer telemetryRuntimeProducer, ISplitEventsManager iSplitEventsManager) {
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mSplitsSyncHelper = (SplitsSyncHelper) Preconditions.checkNotNull(splitsSyncHelper);
        this.mCacheExpirationInSeconds = j;
        this.mCheckCacheExpiration = z;
        this.mSplitsFilterQueryString = str;
        this.mEventsManager = iSplitEventsManager;
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        long till = this.mSplitsStorage.getTill();
        boolean z = this.mCheckCacheExpiration && this.mSplitsSyncHelper.cacheHasExpired(till, this.mSplitsStorage.getUpdateTimestamp(), this.mCacheExpirationInSeconds);
        boolean splitsFilterHasChanged = splitsFilterHasChanged(this.mSplitsStorage.getSplitsFilterQueryString());
        if (splitsFilterHasChanged) {
            this.mSplitsStorage.updateSplitsFilterQueryString(this.mSplitsFilterQueryString);
            till = -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SplitTaskExecutionInfo sync = this.mSplitsSyncHelper.sync(till, splitsFilterHasChanged || z, splitsFilterHasChanged);
        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.SPLITS, System.currentTimeMillis() - currentTimeMillis);
        if (sync.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.SPLITS, System.currentTimeMillis());
            notifyInternalEvent(till);
        }
        return sync;
    }

    private void notifyInternalEvent(long j) {
        if (this.mEventsManager != null) {
            SplitInternalEvent splitInternalEvent = SplitInternalEvent.SPLITS_FETCHED;
            if (this.mChangeChecker.splitsHaveChanged(j, this.mSplitsStorage.getTill())) {
                splitInternalEvent = SplitInternalEvent.SPLITS_UPDATED;
            }
            this.mEventsManager.notifyInternalEvent(splitInternalEvent);
        }
    }

    private boolean splitsFilterHasChanged(String str) {
        return !sanitizeString(this.mSplitsFilterQueryString).equals(sanitizeString(str));
    }
}
