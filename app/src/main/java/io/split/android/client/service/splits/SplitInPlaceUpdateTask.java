package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SplitInPlaceUpdateTask implements SplitTask {
    private final long mChangeNumber;
    private final ISplitEventsManager mEventsManager;
    private final Split mSplit;
    private final SplitChangeProcessor mSplitChangeProcessor;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SplitInPlaceUpdateTask(SplitsStorage splitsStorage, SplitChangeProcessor splitChangeProcessor, ISplitEventsManager iSplitEventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer, Split split, long j) {
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this.mSplitChangeProcessor = (SplitChangeProcessor) Preconditions.checkNotNull(splitChangeProcessor);
        this.mEventsManager = (ISplitEventsManager) Preconditions.checkNotNull(iSplitEventsManager);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mSplit = (Split) Preconditions.checkNotNull(split);
        this.mChangeNumber = j;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mSplitsStorage.update(this.mSplitChangeProcessor.process(this.mSplit, this.mChangeNumber));
            this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_UPDATED);
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(UpdatesFromSSEEnum.SPLITS);
            StringBuilder sb = new StringBuilder();
            sb.append("Updated feature flag: ");
            sb.append(this.mSplit.name);
            Logger.d(sb.toString());
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLITS_SYNC);
        } catch (Exception unused) {
            Logger.e("Could not update feature flag");
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLITS_SYNC);
        }
    }
}
