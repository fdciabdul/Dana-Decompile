package io.split.android.client.service.synchronizer.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;

/* loaded from: classes6.dex */
public class MySegmentsSynchronizerFactoryImpl implements MySegmentsSynchronizerFactory {
    private static final int BACKOFF_BASE = 1;
    private final RetryBackoffCounterTimerFactory mRetryBackoffCounterTimerFactory;
    private final int mSegmentsRefreshRate;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public MySegmentsSynchronizerFactoryImpl(RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, SplitTaskExecutor splitTaskExecutor, int i) {
        this.mRetryBackoffCounterTimerFactory = (RetryBackoffCounterTimerFactory) Preconditions.checkNotNull(retryBackoffCounterTimerFactory);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mSegmentsRefreshRate = i;
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactory
    public MySegmentsSynchronizer getSynchronizer(MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager) {
        return new MySegmentsSynchronizerImpl(this.mRetryBackoffCounterTimerFactory.create(this.mSplitTaskExecutor, 1), this.mSplitTaskExecutor, splitEventsManager, mySegmentsTaskFactory, this.mSegmentsRefreshRate);
    }
}
