package io.split.android.client.localhost;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.lifecycle.SplitLifecycleAware;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.storage.splits.SplitsStorage;
import javax.security.auth.Destroyable;

/* loaded from: classes6.dex */
public class LocalhostSynchronizer implements SplitLifecycleAware, Destroyable {
    private final int mRefreshRate;
    private final SplitsStorage mSplitsStorage;
    private final SplitTaskExecutor mTaskExecutor;

    public LocalhostSynchronizer(SplitTaskExecutor splitTaskExecutor, SplitClientConfig splitClientConfig, SplitsStorage splitsStorage) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mRefreshRate = ((SplitClientConfig) Preconditions.checkNotNull(splitClientConfig)).offlineRefreshRate();
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
    }

    public void start() {
        LoadSplitsTask loadSplitsTask = new LoadSplitsTask(this.mSplitsStorage);
        int i = this.mRefreshRate;
        if (i > 0) {
            this.mTaskExecutor.schedule(loadSplitsTask, 0L, i, null);
        } else {
            this.mTaskExecutor.submit(loadSplitsTask, null);
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void pause() {
        this.mTaskExecutor.pause();
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void resume() {
        this.mTaskExecutor.resume();
    }

    public void stop() {
        this.mTaskExecutor.stop();
    }
}
