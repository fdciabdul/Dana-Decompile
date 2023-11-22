package io.split.android.client.service.telemetry;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStatsProvider;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class TelemetryStatsRecorderTask implements SplitTask {
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final TelemetryStatsProvider mTelemetryStatsProvider;
    private final HttpRecorder<Stats> mTelemetryStatsRecorder;

    public TelemetryStatsRecorderTask(HttpRecorder<Stats> httpRecorder, TelemetryStatsProvider telemetryStatsProvider, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mTelemetryStatsRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mTelemetryStatsProvider = (TelemetryStatsProvider) Preconditions.checkNotNull(telemetryStatsProvider);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        SplitTaskExecutionInfo error;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                this.mTelemetryStatsRecorder.execute(this.mTelemetryStatsProvider.getTelemetryStats());
                this.mTelemetryStatsProvider.clearStats();
                this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.TELEMETRY, System.currentTimeMillis());
                error = SplitTaskExecutionInfo.success(SplitTaskType.TELEMETRY_STATS_TASK);
            } catch (HttpRecorderException e) {
                Logger.e(e);
                this.mTelemetryRuntimeProducer.recordSyncError(OperationType.TELEMETRY, e.getHttpStatus());
                error = SplitTaskExecutionInfo.error(SplitTaskType.TELEMETRY_STATS_TASK);
            }
            return error;
        } finally {
            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.TELEMETRY, System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
