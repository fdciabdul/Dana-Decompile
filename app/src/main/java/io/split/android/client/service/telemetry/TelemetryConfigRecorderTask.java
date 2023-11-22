package io.split.android.client.service.telemetry;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryConfigProvider;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class TelemetryConfigRecorderTask implements SplitTask {
    private final TelemetryConfigProvider mTelemetryConfigProvider;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public TelemetryConfigRecorderTask(HttpRecorder<Config> httpRecorder, TelemetryConfigProvider telemetryConfigProvider, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mTelemetryConfigRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mTelemetryConfigProvider = (TelemetryConfigProvider) Preconditions.checkNotNull(telemetryConfigProvider);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        SplitTaskExecutionInfo error;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                this.mTelemetryConfigRecorder.execute(this.mTelemetryConfigProvider.getConfigTelemetry());
                this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.TELEMETRY, System.currentTimeMillis());
                error = SplitTaskExecutionInfo.success(SplitTaskType.TELEMETRY_CONFIG_TASK);
            } catch (HttpRecorderException e) {
                Logger.e(e);
                this.mTelemetryRuntimeProducer.recordSyncError(OperationType.TELEMETRY, e.getHttpStatus());
                error = SplitTaskExecutionInfo.error(SplitTaskType.TELEMETRY_CONFIG_TASK);
            }
            return error;
        } finally {
            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.TELEMETRY, System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
