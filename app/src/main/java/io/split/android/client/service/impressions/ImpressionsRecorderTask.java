package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes6.dex */
public class ImpressionsRecorderTask implements SplitTask {
    public static final int FAILING_CHUNK_SIZE = 20;
    private final ImpressionsRecorderTaskConfig mConfig;
    private final HttpRecorder<List<KeyImpression>> mHttpRecorder;
    private final PersistentImpressionsStorage mPersistenImpressionsStorage;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public ImpressionsRecorderTask(HttpRecorder<List<KeyImpression>> httpRecorder, PersistentImpressionsStorage persistentImpressionsStorage, ImpressionsRecorderTaskConfig impressionsRecorderTaskConfig, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mHttpRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mPersistenImpressionsStorage = (PersistentImpressionsStorage) Preconditions.checkNotNull(persistentImpressionsStorage);
        this.mConfig = (ImpressionsRecorderTaskConfig) Preconditions.checkNotNull(impressionsRecorderTaskConfig);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        List<KeyImpression> pop;
        long j;
        long j2;
        long currentTimeMillis;
        SplitTaskExecutionStatus splitTaskExecutionStatus = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        long j3 = 0;
        do {
            pop = this.mPersistenImpressionsStorage.pop(this.mConfig.getImpressionsPerPush());
            if (pop.size() > 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    Logger.d("Posting %d Split impressions", Integer.valueOf(pop.size()));
                    this.mHttpRecorder.execute(pop);
                    currentTimeMillis = System.currentTimeMillis();
                    j2 = currentTimeMillis - currentTimeMillis2;
                } catch (HttpRecorderException e) {
                    e = e;
                    j2 = 0;
                } catch (Throwable th) {
                    th = th;
                    j = 0;
                }
                try {
                    try {
                        this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.IMPRESSIONS, currentTimeMillis);
                        this.mPersistenImpressionsStorage.delete(pop);
                        Logger.d("%d split impressions sent", Integer.valueOf(pop.size()));
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j2);
                    } catch (Throwable th2) {
                        th = th2;
                        j = j2;
                        this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j);
                        throw th;
                    }
                } catch (HttpRecorderException e2) {
                    e = e2;
                    SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.ERROR;
                    i += this.mConfig.getImpressionsPerPush();
                    j3 += sumImpressionsBytes(pop);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Impressions recorder task: Some impressions couldn't be sent.Saving to send them in a new iteration");
                    sb.append(e.getLocalizedMessage());
                    Logger.e(sb.toString());
                    arrayList.addAll(pop);
                    this.mTelemetryRuntimeProducer.recordSyncError(OperationType.IMPRESSIONS, e.getHttpStatus());
                    this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.IMPRESSIONS, j2);
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                }
            }
        } while (pop.size() == this.mConfig.getImpressionsPerPush());
        if (arrayList.size() > 0) {
            this.mPersistenImpressionsStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            HashMap hashMap = new HashMap();
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(i));
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(j3));
            return SplitTaskExecutionInfo.error(SplitTaskType.IMPRESSIONS_RECORDER, hashMap);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.IMPRESSIONS_RECORDER);
    }

    private long sumImpressionsBytes(List<KeyImpression> list) {
        long j = 0;
        for (KeyImpression keyImpression : list) {
            j += this.mConfig.getEstimatedSizeInBytes();
        }
        return j;
    }
}
