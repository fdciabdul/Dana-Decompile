package io.split.android.client.events.executors;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClient;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutor;

/* loaded from: classes6.dex */
public class SplitEventExecutorWithClient implements SplitEventExecutor {
    private final SplitTask mBackgroundSplitTask;
    private final SplitTask mMainThreadSplitTask;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public SplitEventExecutorWithClient(SplitTaskExecutor splitTaskExecutor, SplitEventTask splitEventTask, SplitClient splitClient) {
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mBackgroundSplitTask = new ClientEventSplitTask(splitEventTask, splitClient, false);
        this.mMainThreadSplitTask = new ClientEventSplitTask(splitEventTask, splitClient, true);
    }

    @Override // io.split.android.client.events.executors.SplitEventExecutor
    public void execute() {
        this.mSplitTaskExecutor.submit(this.mBackgroundSplitTask, null);
        this.mSplitTaskExecutor.submitOnMainThread(this.mMainThreadSplitTask);
    }
}
