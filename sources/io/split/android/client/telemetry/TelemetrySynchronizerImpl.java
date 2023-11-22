package io.split.android.client.telemetry;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.FixedIntervalBackoffCounter;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;

/* loaded from: classes6.dex */
public class TelemetrySynchronizerImpl implements TelemetrySynchronizer {
    private final RetryBackoffCounterTimer mConfigTimer;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryTaskFactory mTaskFactory;
    private final long mTelemetrySyncPeriod;
    private String statsTaskId;

    public TelemetrySynchronizerImpl(SplitTaskExecutor splitTaskExecutor, TelemetryTaskFactory telemetryTaskFactory, long j) {
        this(splitTaskExecutor, telemetryTaskFactory, new RetryBackoffCounterTimer(splitTaskExecutor, new FixedIntervalBackoffCounter(1L), 3), j);
    }

    public TelemetrySynchronizerImpl(SplitTaskExecutor splitTaskExecutor, TelemetryTaskFactory telemetryTaskFactory, RetryBackoffCounterTimer retryBackoffCounterTimer, long j) {
        this.statsTaskId = null;
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mTaskFactory = (TelemetryTaskFactory) Preconditions.checkNotNull(telemetryTaskFactory);
        this.mConfigTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer);
        this.mTelemetrySyncPeriod = j;
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void synchronizeConfig() {
        this.mConfigTimer.setTask(this.mTaskFactory.getTelemetryConfigRecorderTask(), null);
        this.mConfigTimer.start();
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void synchronizeStats() {
        this.statsTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.getTelemetryStatsRecorderTask(), 5L, this.mTelemetrySyncPeriod, null);
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void destroy() {
        this.mConfigTimer.stop();
        stopStatsSynchronization();
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void flush() {
        this.mTaskExecutor.submit(this.mTaskFactory.getTelemetryStatsRecorderTask(), null);
    }

    private void stopStatsSynchronization() {
        String str = this.statsTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
            this.statsTaskId = null;
        }
    }
}
