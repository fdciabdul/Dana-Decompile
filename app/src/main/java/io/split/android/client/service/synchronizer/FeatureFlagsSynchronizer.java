package io.split.android.client.service.synchronizer;

import io.split.android.client.service.executor.SplitTaskExecutionListener;

/* loaded from: classes6.dex */
public interface FeatureFlagsSynchronizer {
    void loadAndSynchronize();

    void loadFromCache();

    void startPeriodicFetching();

    void stopPeriodicFetching();

    void stopSynchronization();

    void submitLoadingTask(SplitTaskExecutionListener splitTaskExecutionListener);

    void synchronize();

    void synchronize(long j);
}
