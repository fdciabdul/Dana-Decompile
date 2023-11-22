package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.internal.C$Gson$Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SseDisconnectionTimer implements SplitTaskExecutionListener {
    private final int mInitialDelayInSeconds;
    private final SplitTaskExecutor mTaskExecutor;
    private String mTaskId;

    public SseDisconnectionTimer(SplitTaskExecutor splitTaskExecutor, int i) {
        this.mTaskExecutor = (SplitTaskExecutor) C$Gson$Preconditions.checkNotNull(splitTaskExecutor);
        this.mInitialDelayInSeconds = i;
    }

    public void cancel() {
        String str = this.mTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
    }

    public void schedule(SplitTask splitTask) {
        StringBuilder sb = new StringBuilder();
        sb.append("Scheduling disconnection in ");
        sb.append(this.mInitialDelayInSeconds);
        sb.append(" seconds");
        Logger.v(sb.toString());
        cancel();
        this.mTaskId = this.mTaskExecutor.schedule(splitTask, this.mInitialDelayInSeconds, this);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        this.mTaskId = null;
    }
}
