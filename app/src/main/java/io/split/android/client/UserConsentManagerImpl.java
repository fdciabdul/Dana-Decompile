package io.split.android.client;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManager;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.impressions.ImpressionsStorage;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class UserConsentManagerImpl implements UserConsentManager {
    private UserConsent mCurrentStatus;
    private final EventsStorage mEventsStorage;
    private final EventsTracker mEventsTracker;
    private final ImpressionManager mImpressionManager;
    private final ImpressionsStorage mImpressionsStorage;
    private final Object mLock = new Object();
    private final SplitClientConfig mSplitConfig;
    private final SyncManager mSyncManager;
    private final SplitTaskExecutor mTaskExecutor;

    public UserConsentManagerImpl(SplitClientConfig splitClientConfig, ImpressionsStorage impressionsStorage, EventsStorage eventsStorage, SyncManager syncManager, EventsTracker eventsTracker, ImpressionManager impressionManager, SplitTaskExecutor splitTaskExecutor) {
        this.mSplitConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mImpressionsStorage = (ImpressionsStorage) Preconditions.checkNotNull(impressionsStorage);
        this.mEventsStorage = (EventsStorage) Preconditions.checkNotNull(eventsStorage);
        this.mSyncManager = (SyncManager) Preconditions.checkNotNull(syncManager);
        this.mEventsTracker = (EventsTracker) Preconditions.checkNotNull(eventsTracker);
        this.mImpressionManager = (ImpressionManager) Preconditions.checkNotNull(impressionManager);
        this.mTaskExecutor = splitTaskExecutor;
        setStatus(splitClientConfig.userConsent());
    }

    @Override // io.split.android.client.UserConsentManager
    public void setStatus(UserConsent userConsent) {
        synchronized (this.mLock) {
            if (this.mCurrentStatus == userConsent) {
                return;
            }
            this.mSplitConfig.setUserConsent(userConsent);
            enableTracking(userConsent);
            enablePersistence(userConsent);
            this.mSyncManager.setupUserConsent(userConsent);
            this.mCurrentStatus = userConsent;
            StringBuilder sb = new StringBuilder();
            sb.append("User consent set to ");
            sb.append(userConsent.toString());
            Logger.d(sb.toString());
        }
    }

    @Override // io.split.android.client.UserConsentManager
    public UserConsent getStatus() {
        UserConsent userConsent;
        synchronized (this.mLock) {
            userConsent = this.mCurrentStatus;
        }
        return userConsent;
    }

    private void enableTracking(UserConsent userConsent) {
        boolean z = userConsent != UserConsent.DECLINED;
        this.mEventsTracker.enableTracking(z);
        this.mImpressionManager.enableTracking(z);
        StringBuilder sb = new StringBuilder();
        sb.append("Tracking has been set to ");
        sb.append(z);
        Logger.d(sb.toString());
    }

    private void enablePersistence(UserConsent userConsent) {
        final boolean z = userConsent == UserConsent.GRANTED;
        this.mTaskExecutor.submit(new SplitTask() { // from class: io.split.android.client.UserConsentManagerImpl.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                UserConsentManagerImpl.this.mImpressionsStorage.enablePersistence(z);
                UserConsentManagerImpl.this.mEventsStorage.enablePersistence(z);
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Persistence has been set to ");
        sb.append(z);
        Logger.d(sb.toString());
    }
}
