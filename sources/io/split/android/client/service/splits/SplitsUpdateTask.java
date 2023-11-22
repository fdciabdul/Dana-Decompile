package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.synchronizer.SplitsChangeChecker;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SplitsUpdateTask implements SplitTask {
    private SplitsChangeChecker mChangeChecker = new SplitsChangeChecker();
    private final Long mChangeNumber;
    private final ISplitEventsManager mEventsManager;
    private final SplitsStorage mSplitsStorage;
    private final SplitsSyncHelper mSplitsSyncHelper;

    public SplitsUpdateTask(SplitsSyncHelper splitsSyncHelper, SplitsStorage splitsStorage, long j, ISplitEventsManager iSplitEventsManager) {
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mSplitsSyncHelper = (SplitsSyncHelper) Preconditions.checkNotNull(splitsSyncHelper);
        this.mChangeNumber = Long.valueOf(j);
        this.mEventsManager = (ISplitEventsManager) Preconditions.checkNotNull(iSplitEventsManager);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        Long l = this.mChangeNumber;
        if (l == null || l.longValue() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not update split. Invalid change number ");
            sb.append(this.mChangeNumber);
            Logger.e(sb.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
        }
        long till = this.mSplitsStorage.getTill();
        if (this.mChangeNumber.longValue() <= till) {
            Logger.d("Received change number is previous than stored one. Avoiding update.");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
        }
        SplitTaskExecutionInfo sync = this.mSplitsSyncHelper.sync(this.mChangeNumber.longValue());
        if (sync.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
            SplitInternalEvent splitInternalEvent = SplitInternalEvent.SPLITS_FETCHED;
            if (this.mChangeChecker.splitsHaveChanged(till, this.mSplitsStorage.getTill())) {
                splitInternalEvent = SplitInternalEvent.SPLITS_UPDATED;
            }
            this.mEventsManager.notifyInternalEvent(splitInternalEvent);
        }
        return sync;
    }

    public void setChangeChecker(SplitsChangeChecker splitsChangeChecker) {
        this.mChangeChecker = splitsChangeChecker;
    }
}
