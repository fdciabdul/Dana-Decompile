package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.internal.C$Gson$Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.BackoffCounter;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class RetryBackoffCounterTimer implements SplitTaskExecutionListener {
    private static final int DEFAULT_MAX_ATTEMPTS = -1;
    private final BackoffCounter mBackoffCounter;
    private final AtomicInteger mCurrentAttempts;
    private SplitTaskExecutionListener mListener;
    private final int mRetryAttemptsLimit;
    private SplitTask mTask;
    private final SplitTaskExecutor mTaskExecutor;
    private String mTaskId;

    public RetryBackoffCounterTimer(SplitTaskExecutor splitTaskExecutor, BackoffCounter backoffCounter) {
        this.mCurrentAttempts = new AtomicInteger(0);
        this.mTaskExecutor = (SplitTaskExecutor) C$Gson$Preconditions.checkNotNull(splitTaskExecutor);
        this.mBackoffCounter = (BackoffCounter) C$Gson$Preconditions.checkNotNull(backoffCounter);
        this.mRetryAttemptsLimit = -1;
    }

    public RetryBackoffCounterTimer(SplitTaskExecutor splitTaskExecutor, BackoffCounter backoffCounter, int i) {
        this.mCurrentAttempts = new AtomicInteger(0);
        this.mTaskExecutor = (SplitTaskExecutor) C$Gson$Preconditions.checkNotNull(splitTaskExecutor);
        this.mBackoffCounter = (BackoffCounter) C$Gson$Preconditions.checkNotNull(backoffCounter);
        this.mRetryAttemptsLimit = i;
    }

    public void setTask(SplitTask splitTask, SplitTaskExecutionListener splitTaskExecutionListener) {
        synchronized (this) {
            this.mTask = (SplitTask) C$Gson$Preconditions.checkNotNull(splitTask);
            this.mListener = splitTaskExecutionListener;
        }
    }

    public void setTask(SplitTask splitTask) {
        synchronized (this) {
            setTask(splitTask, null);
        }
    }

    public void stop() {
        synchronized (this) {
            if (this.mTask == null) {
                return;
            }
            this.mTaskExecutor.stopTask(this.mTaskId);
            this.mTaskId = null;
        }
    }

    public void start() {
        synchronized (this) {
            if (this.mTask != null && this.mTaskId == null) {
                this.mBackoffCounter.resetCounter();
                this.mCurrentAttempts.incrementAndGet();
                this.mTaskId = this.mTaskExecutor.schedule(this.mTask, 0L, this);
            }
        }
    }

    private void schedule() {
        synchronized (this) {
            if (this.mTask == null) {
                return;
            }
            long nextRetryTime = this.mBackoffCounter.getNextRetryTime();
            Logger.d(String.format("Retrying %s task in %d seconds", this.mTask.getClass().getSimpleName(), Long.valueOf(nextRetryTime)));
            this.mCurrentAttempts.incrementAndGet();
            this.mTaskId = this.mTaskExecutor.schedule(this.mTask, nextRetryTime, this);
        }
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        this.mTaskId = null;
        if (splitTaskExecutionInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
            if (this.mRetryAttemptsLimit == -1 || this.mCurrentAttempts.get() < this.mRetryAttemptsLimit) {
                schedule();
                return;
            }
            return;
        }
        this.mBackoffCounter.resetCounter();
        SplitTaskExecutionListener splitTaskExecutionListener = this.mListener;
        if (splitTaskExecutionListener != null) {
            splitTaskExecutionListener.taskExecuted(SplitTaskExecutionInfo.success(splitTaskExecutionInfo.getTaskType()));
        }
    }
}
