package io.split.android.client.service.impressions;

/* loaded from: classes6.dex */
public class ImpressionsRecorderTaskConfig {
    private final long estimatedSizeInBytes;
    private final int impressionsPerPush;
    private final boolean shouldRecordTelemetry;

    public ImpressionsRecorderTaskConfig(int i, long j, boolean z) {
        this.impressionsPerPush = i;
        this.estimatedSizeInBytes = j;
        this.shouldRecordTelemetry = z;
    }

    public int getImpressionsPerPush() {
        return this.impressionsPerPush;
    }

    public long getEstimatedSizeInBytes() {
        return this.estimatedSizeInBytes;
    }

    public boolean shouldRecordTelemetry() {
        return this.shouldRecordTelemetry;
    }
}
