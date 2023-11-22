package io.split.android.client.service.telemetry;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.telemetry.storage.TelemetryConfigProvider;
import io.split.android.client.telemetry.storage.TelemetryConfigProviderImpl;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStatsProvider;
import io.split.android.client.telemetry.storage.TelemetryStatsProviderImpl;
import io.split.android.client.telemetry.storage.TelemetryStorage;

/* loaded from: classes6.dex */
public class TelemetryTaskFactoryImpl implements TelemetryTaskFactory {
    private final TelemetryConfigProvider mTelemetryConfigProvider;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final TelemetryStatsProvider mTelemetryStatsProvider;
    private final HttpRecorder<Stats> mTelemetryStatsRecorder;

    public TelemetryTaskFactoryImpl(HttpRecorder<Config> httpRecorder, HttpRecorder<Stats> httpRecorder2, TelemetryStorage telemetryStorage, SplitClientConfig splitClientConfig, SplitsStorage splitsStorage, MySegmentsStorageContainer mySegmentsStorageContainer) {
        this.mTelemetryConfigRecorder = httpRecorder;
        this.mTelemetryConfigProvider = new TelemetryConfigProviderImpl(telemetryStorage, splitClientConfig);
        this.mTelemetryStatsRecorder = httpRecorder2;
        this.mTelemetryStatsProvider = new TelemetryStatsProviderImpl(telemetryStorage, splitsStorage, mySegmentsStorageContainer);
        this.mTelemetryRuntimeProducer = telemetryStorage;
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryConfigRecorderTask getTelemetryConfigRecorderTask() {
        return new TelemetryConfigRecorderTask(this.mTelemetryConfigRecorder, this.mTelemetryConfigProvider, this.mTelemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryStatsRecorderTask getTelemetryStatsRecorderTask() {
        return new TelemetryStatsRecorderTask(this.mTelemetryStatsRecorder, this.mTelemetryStatsProvider, this.mTelemetryRuntimeProducer);
    }
}
