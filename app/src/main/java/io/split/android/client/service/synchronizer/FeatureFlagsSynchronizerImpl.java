package io.split.android.client.service.synchronizer;

import com.google.common.base.Preconditions;
import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskBatchItem;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class FeatureFlagsSynchronizerImpl implements FeatureFlagsSynchronizer {
    private final LoadLocalDataListener mLoadLocalSplitsListener;
    private final SplitClientConfig mSplitClientConfig;
    private final SplitTaskFactory mSplitTaskFactory;
    private String mSplitsFetcherTaskId;
    private final SplitTaskExecutionListener mSplitsSyncListener;
    private final RetryBackoffCounterTimer mSplitsSyncRetryTimer;
    private final SplitTaskExecutor mSplitsTaskExecutor;
    private final RetryBackoffCounterTimer mSplitsUpdateRetryTimer;
    private final SplitTaskExecutor mTaskExecutor;

    public FeatureFlagsSynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, SplitTaskExecutor splitTaskExecutor2, SplitTaskFactory splitTaskFactory, ISplitEventsManager iSplitEventsManager, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, final PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mSplitsTaskExecutor = splitTaskExecutor2;
        this.mSplitClientConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        SplitTaskFactory splitTaskFactory2 = (SplitTaskFactory) Preconditions.checkNotNull(splitTaskFactory);
        this.mSplitTaskFactory = splitTaskFactory2;
        RetryBackoffCounterTimer create = retryBackoffCounterTimerFactory.create(splitTaskExecutor2, 1);
        this.mSplitsSyncRetryTimer = create;
        this.mSplitsUpdateRetryTimer = retryBackoffCounterTimerFactory.create(splitTaskExecutor2, 1);
        if (pushManagerEventBroadcaster != null) {
            this.mSplitsSyncListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.synchronizer.FeatureFlagsSynchronizerImpl.1
                @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
                public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
                    if (splitTaskExecutionInfo.getStatus() == SplitTaskExecutionStatus.SUCCESS) {
                        pushManagerEventBroadcaster.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.SUCCESSFUL_SYNC));
                    }
                }
            };
        } else {
            this.mSplitsSyncListener = null;
        }
        create.setTask(splitTaskFactory2.createSplitsSyncTask(true), this.mSplitsSyncListener);
        this.mLoadLocalSplitsListener = new LoadLocalDataListener(iSplitEventsManager, SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void loadFromCache() {
        submitLoadingTask(this.mLoadLocalSplitsListener);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void loadAndSynchronize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SplitTaskBatchItem(this.mSplitTaskFactory.createFilterSplitsInCacheTask(), null));
        arrayList.add(new SplitTaskBatchItem(this.mSplitTaskFactory.createLoadSplitsTask(), this.mLoadLocalSplitsListener));
        arrayList.add(new SplitTaskBatchItem(new SplitTask() { // from class: io.split.android.client.service.synchronizer.FeatureFlagsSynchronizerImpl$$ExternalSyntheticLambda0
            @Override // io.split.android.client.service.executor.SplitTask
            public final SplitTaskExecutionInfo execute() {
                return FeatureFlagsSynchronizerImpl.this.m3167x94483de0();
            }
        }, null));
        this.mTaskExecutor.executeSerially(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadAndSynchronize$0$io-split-android-client-service-synchronizer-FeatureFlagsSynchronizerImpl  reason: not valid java name */
    public /* synthetic */ SplitTaskExecutionInfo m3167x94483de0() {
        synchronize();
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void synchronize(long j) {
        this.mSplitsUpdateRetryTimer.setTask(this.mSplitTaskFactory.createSplitsUpdateTask(j), this.mSplitsSyncListener);
        this.mSplitsUpdateRetryTimer.start();
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void synchronize() {
        this.mSplitsSyncRetryTimer.start();
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void startPeriodicFetching() {
        scheduleSplitsFetcherTask();
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void stopPeriodicFetching() {
        this.mSplitsTaskExecutor.stopTask(this.mSplitsFetcherTaskId);
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void stopSynchronization() {
        this.mSplitsSyncRetryTimer.stop();
        this.mSplitsUpdateRetryTimer.stop();
    }

    @Override // io.split.android.client.service.synchronizer.FeatureFlagsSynchronizer
    public void submitLoadingTask(SplitTaskExecutionListener splitTaskExecutionListener) {
        this.mTaskExecutor.submit(this.mSplitTaskFactory.createLoadSplitsTask(), splitTaskExecutionListener);
    }

    private void scheduleSplitsFetcherTask() {
        this.mSplitsFetcherTaskId = this.mSplitsTaskExecutor.schedule(this.mSplitTaskFactory.createSplitsSyncTask(false), this.mSplitClientConfig.featuresRefreshRate(), this.mSplitClientConfig.featuresRefreshRate(), this.mSplitsSyncListener);
    }
}
