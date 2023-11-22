package io.split.android.client.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.service.synchronizer.SyncManager;

/* loaded from: classes6.dex */
public class SyncImpressionListener implements ImpressionListener {
    private final SyncManager mSyncManager;

    @Override // io.split.android.client.impressions.ImpressionListener
    public void close() {
    }

    public SyncImpressionListener(SyncManager syncManager) {
        this.mSyncManager = (SyncManager) Preconditions.checkNotNull(syncManager);
    }

    @Override // io.split.android.client.impressions.ImpressionListener
    public void log(Impression impression) {
        this.mSyncManager.pushImpression(impression);
    }
}
