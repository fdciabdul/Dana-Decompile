package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import java.util.List;

/* loaded from: classes6.dex */
public class MySegmentsTaskFactoryImpl implements MySegmentsTaskFactory {
    private final MySegmentsTaskFactoryConfiguration mConfiguration;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsTaskFactoryImpl(MySegmentsTaskFactoryConfiguration mySegmentsTaskFactoryConfiguration, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mConfiguration = (MySegmentsTaskFactoryConfiguration) Preconditions.checkNotNull(mySegmentsTaskFactoryConfiguration);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsSyncTask createMySegmentsSyncTask(boolean z) {
        return new MySegmentsSyncTask(this.mConfiguration.getHttpFetcher(), this.mConfiguration.getStorage(), z, this.mConfiguration.getEventsManager(), this.mTelemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public LoadMySegmentsTask createLoadMySegmentsTask() {
        return new LoadMySegmentsTask(this.mConfiguration.getStorage());
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsOverwriteTask createMySegmentsOverwriteTask(List<String> list) {
        return new MySegmentsOverwriteTask(this.mConfiguration.getStorage(), list, this.mConfiguration.getEventsManager());
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsUpdateTask createMySegmentsUpdateTask(boolean z, String str) {
        return new MySegmentsUpdateTask(this.mConfiguration.getStorage(), z, str, this.mConfiguration.getEventsManager(), this.mTelemetryRuntimeProducer);
    }
}
