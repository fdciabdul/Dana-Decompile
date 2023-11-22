package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.internal.C$Gson$Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class BackoffCounterTimer implements SplitTaskExecutionListener {
    private BackoffCounter mBackoffCounter;
    private SplitTask mTask;
    private SplitTaskExecutor mTaskExecutor;
    String mTaskId;

    public BackoffCounterTimer(SplitTaskExecutor splitTaskExecutor, BackoffCounter backoffCounter) {
        this.mTaskExecutor = (SplitTaskExecutor) C$Gson$Preconditions.checkNotNull(splitTaskExecutor);
        this.mBackoffCounter = (BackoffCounter) C$Gson$Preconditions.checkNotNull(backoffCounter);
    }

    public void setTask(SplitTask splitTask) {
        this.mTask = (SplitTask) C$Gson$Preconditions.checkNotNull(splitTask);
    }

    public void cancel() {
        if (this.mTask == null) {
            return;
        }
        this.mBackoffCounter.resetCounter();
        this.mTaskExecutor.stopTask(this.mTaskId);
        this.mTaskId = null;
    }

    public void schedule() {
        if (this.mTask == null || this.mTaskId != null) {
            return;
        }
        long nextRetryTime = this.mBackoffCounter.getNextRetryTime();
        Logger.d(String.format("Retrying reconnection in %d seconds", Long.valueOf(nextRetryTime)));
        this.mTaskId = this.mTaskExecutor.schedule(this.mTask, nextRetryTime, this);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        this.mTaskId = null;
    }
}
