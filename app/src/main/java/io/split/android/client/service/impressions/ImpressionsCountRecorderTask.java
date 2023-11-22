package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ImpressionsCountRecorderTask implements SplitTask {
    private static int POP_COUNT = 200;
    private final HttpRecorder<ImpressionsCount> mHttpRecorder;
    private final PersistentImpressionsCountStorage mPersistentStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public ImpressionsCountRecorderTask(HttpRecorder<ImpressionsCount> httpRecorder, PersistentImpressionsCountStorage persistentImpressionsCountStorage, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mPersistentStorage = (PersistentImpressionsCountStorage) Preconditions.checkNotNull(persistentImpressionsCountStorage);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        List<ImpressionsCountPerFeature> pop;
        long j;
        SplitTaskExecutionStatus splitTaskExecutionStatus = SplitTaskExecutionStatus.SUCCESS;
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        do {
            pop = this.mPersistentStorage.pop(POP_COUNT);
            if (pop.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = 0;
                try {
                    try {
                        Logger.d("Posting %d Split impressions count", Integer.valueOf(pop.size()));
                        this.mHttpRecorder.execute(new ImpressionsCount(pop));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j = currentTimeMillis2 - currentTimeMillis;
                        try {
                            this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.IMPRESSIONS_COUNT, currentTimeMillis2);
                            this.mPersistentStorage.delete(pop);
                            Logger.d("%d split impressions count sent", Integer.valueOf(pop.size()));
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j);
                        } catch (HttpRecorderException e) {
                            e = e;
                            j2 = j;
                            SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.ERROR;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Impressions count recorder task: Some counts couldn't be sent.Saving to send them in a new iteration");
                            sb.append(e.getLocalizedMessage());
                            Logger.e(sb.toString());
                            arrayList.addAll(pop);
                            this.mTelemetryRuntimeProducer.recordSyncError(OperationType.IMPRESSIONS_COUNT, e.getHttpStatus());
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j2);
                            splitTaskExecutionStatus = splitTaskExecutionStatus2;
                        } catch (Throwable th) {
                            th = th;
                            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS_COUNT, j);
                            throw th;
                        }
                    } catch (HttpRecorderException e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j = 0;
                }
            }
        } while (pop.size() == POP_COUNT);
        if (arrayList.size() > 0) {
            this.mPersistentStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_COUNT_RECORDER);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_COUNT_RECORDER);
    }
}
