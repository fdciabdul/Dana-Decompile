package io.split.android.client.events.executors;

import io.split.android.client.SplitClient;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;

/* loaded from: classes6.dex */
class ClientEventSplitTask implements SplitTask {
    private final boolean mIsMainThread;
    private final SplitClient mSplitClient;
    private final SplitEventTask mTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientEventSplitTask(SplitEventTask splitEventTask, SplitClient splitClient, boolean z) {
        this.mTask = splitEventTask;
        this.mSplitClient = splitClient;
        this.mIsMainThread = z;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mIsMainThread) {
                this.mTask.onPostExecutionView(this.mSplitClient);
            } else {
                this.mTask.onPostExecution(this.mSplitClient);
            }
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }
}
