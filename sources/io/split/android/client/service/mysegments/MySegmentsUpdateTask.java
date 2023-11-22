package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes6.dex */
public class MySegmentsUpdateTask implements SplitTask {
    private final SplitEventsManager mEventsManager;
    private final boolean mIsAddOperation;
    private final MySegmentsStorage mMySegmentsStorage;
    private final String mSegmentName;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsUpdateTask(MySegmentsStorage mySegmentsStorage, boolean z, String str, SplitEventsManager splitEventsManager, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mMySegmentsStorage = (MySegmentsStorage) Preconditions.checkNotNull(mySegmentsStorage);
        this.mSegmentName = (String) Preconditions.checkNotNull(str);
        this.mIsAddOperation = z;
        this.mEventsManager = (SplitEventsManager) Preconditions.checkNotNull(splitEventsManager);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (this.mIsAddOperation) {
            return add();
        }
        return remove();
    }

    private SplitTaskExecutionInfo add() {
        try {
            Set<String> all = this.mMySegmentsStorage.getAll();
            if (!all.contains(this.mSegmentName)) {
                all.add(this.mSegmentName);
                updateAndNotify(all);
            }
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(UpdatesFromSSEEnum.MY_SEGMENTS);
            StringBuilder sb = new StringBuilder();
            sb.append("My Segments have been updated. Added ");
            sb.append(this.mSegmentName);
            Logger.d(sb.toString());
            return SplitTaskExecutionInfo.success(SplitTaskType.MY_SEGMENTS_UPDATE);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown error while adding segment ");
            sb2.append(this.mSegmentName);
            sb2.append(": ");
            sb2.append(e.getLocalizedMessage());
            logError(sb2.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_UPDATE);
        }
    }

    public SplitTaskExecutionInfo remove() {
        try {
            Set<String> all = this.mMySegmentsStorage.getAll();
            if (all.remove(this.mSegmentName)) {
                updateAndNotify(all);
            }
            this.mTelemetryRuntimeProducer.recordUpdatesFromSSE(UpdatesFromSSEEnum.MY_SEGMENTS);
            StringBuilder sb = new StringBuilder();
            sb.append("My Segments have been updated. Removed ");
            sb.append(this.mSegmentName);
            Logger.d(sb.toString());
            return SplitTaskExecutionInfo.success(SplitTaskType.MY_SEGMENTS_UPDATE);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown error while removing segment ");
            sb2.append(this.mSegmentName);
            sb2.append(": ");
            sb2.append(e.getLocalizedMessage());
            logError(sb2.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.MY_SEGMENTS_UPDATE);
        }
    }

    private void updateAndNotify(Set<String> set) {
        this.mMySegmentsStorage.set(new ArrayList(set));
        this.mEventsManager.notifyInternalEvent(SplitInternalEvent.MY_SEGMENTS_UPDATED);
    }

    private void logError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while executing my segments removal task: ");
        sb.append(str);
        Logger.e(sb.toString());
    }
}
