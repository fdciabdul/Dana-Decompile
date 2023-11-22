package io.split.android.client.service.impressions.unique;

/* loaded from: classes6.dex */
public class UniqueKeysRecorderTaskConfig {
    private final int mElementsPerPush;
    private final long mEstimatedSizeInBytes;

    public UniqueKeysRecorderTaskConfig(int i, long j) {
        this.mElementsPerPush = i;
        this.mEstimatedSizeInBytes = j;
    }

    public int getElementsPerPush() {
        return this.mElementsPerPush;
    }

    public long getEstimatedSizeInBytes() {
        return this.mEstimatedSizeInBytes;
    }
}
