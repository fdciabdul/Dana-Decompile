package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SplitKillTask implements SplitTask {
    private final ISplitEventsManager mEventsManager;
    private final Split mKilledSplit;
    private final SplitsStorage mSplitsStorage;

    public SplitKillTask(SplitsStorage splitsStorage, Split split, ISplitEventsManager iSplitEventsManager) {
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mKilledSplit = split;
        this.mEventsManager = iSplitEventsManager;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mKilledSplit == null) {
                logError("Split name to kill could not be null.");
                return SplitTaskExecutionInfo.error(SplitTaskType.SPLIT_KILL);
            }
            if (this.mKilledSplit.changeNumber <= this.mSplitsStorage.getTill()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Skipping killed split notification for old change number: ");
                sb.append(this.mKilledSplit.changeNumber);
                Logger.d(sb.toString());
                return SplitTaskExecutionInfo.success(SplitTaskType.SPLIT_KILL);
            }
            Split split = this.mSplitsStorage.get(this.mKilledSplit.name);
            split.killed = true;
            split.defaultTreatment = this.mKilledSplit.defaultTreatment;
            split.changeNumber = this.mKilledSplit.changeNumber;
            this.mSplitsStorage.updateWithoutChecks(split);
            this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLIT_KILLED_NOTIFICATION);
            Logger.d("Killed split has been updated");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLIT_KILL);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown error while updating killed split: ");
            sb2.append(e.getLocalizedMessage());
            logError(sb2.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLIT_KILL);
        }
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while executing Split kill task: ");
        sb.append(str);
        Logger.e(sb.toString());
    }
}
