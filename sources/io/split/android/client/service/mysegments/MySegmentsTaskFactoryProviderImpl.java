package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;

/* loaded from: classes6.dex */
public class MySegmentsTaskFactoryProviderImpl implements MySegmentsTaskFactoryProvider {
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsTaskFactoryProviderImpl(TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactoryProvider
    public MySegmentsTaskFactory getFactory(MySegmentsTaskFactoryConfiguration mySegmentsTaskFactoryConfiguration) {
        return new MySegmentsTaskFactoryImpl(mySegmentsTaskFactoryConfiguration, this.mTelemetryRuntimeProducer);
    }
}
