package io.split.android.client.service.synchronizer.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsSyncTask;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.LoadLocalDataListener;

/* loaded from: classes6.dex */
public class MySegmentsSynchronizerImpl implements MySegmentsSynchronizer {
    private final LoadLocalDataListener mLoadLocalMySegmentsListener;
    private String mMySegmentsFetcherTaskId;
    private final RetryBackoffCounterTimer mMySegmentsSyncRetryTimer;
    private final int mSegmentsRefreshRate;
    private final MySegmentsTaskFactory mSplitTaskFactory;
    private final SplitTaskExecutor mTaskExecutor;

    public MySegmentsSynchronizerImpl(RetryBackoffCounterTimer retryBackoffCounterTimer, SplitTaskExecutor splitTaskExecutor, SplitEventsManager splitEventsManager, MySegmentsTaskFactory mySegmentsTaskFactory, int i) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mMySegmentsSyncRetryTimer = (RetryBackoffCounterTimer) Preconditions.checkNotNull(retryBackoffCounterTimer);
        this.mSplitTaskFactory = (MySegmentsTaskFactory) Preconditions.checkNotNull(mySegmentsTaskFactory);
        this.mSegmentsRefreshRate = i;
        this.mLoadLocalMySegmentsListener = new LoadLocalDataListener(splitEventsManager, SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void loadMySegmentsFromCache() {
        submitMySegmentsLoadingTask(this.mLoadLocalMySegmentsListener);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void synchronizeMySegments() {
        this.mMySegmentsSyncRetryTimer.setTask(this.mSplitTaskFactory.createMySegmentsSyncTask(false), null);
        this.mMySegmentsSyncRetryTimer.start();
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void forceMySegmentsSync() {
        this.mMySegmentsSyncRetryTimer.setTask(this.mSplitTaskFactory.createMySegmentsSyncTask(true), null);
        this.mMySegmentsSyncRetryTimer.start();
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void destroy() {
        this.mMySegmentsSyncRetryTimer.stop();
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void scheduleSegmentsSyncTask() {
        SplitTaskExecutor splitTaskExecutor = this.mTaskExecutor;
        MySegmentsSyncTask createMySegmentsSyncTask = this.mSplitTaskFactory.createMySegmentsSyncTask(false);
        long j = this.mSegmentsRefreshRate;
        this.mMySegmentsFetcherTaskId = splitTaskExecutor.schedule(createMySegmentsSyncTask, j, j, null);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void stopPeriodicFetching() {
        this.mTaskExecutor.stopTask(this.mMySegmentsFetcherTaskId);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void submitMySegmentsLoadingTask() {
        submitMySegmentsLoadingTask(null);
    }

    private void submitMySegmentsLoadingTask(SplitTaskExecutionListener splitTaskExecutionListener) {
        this.mTaskExecutor.submit(this.mSplitTaskFactory.createLoadMySegmentsTask(), splitTaskExecutionListener);
    }
}
