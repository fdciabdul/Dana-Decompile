package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.internal.C$Gson$Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SseRefreshTokenTimer implements SplitTaskExecutionListener {
    private static final int RECONNECT_TIME_BEFORE_TOKEN_EXP_IN_SECONDS = 600;
    PushManagerEventBroadcaster mBroadcasterChannel;
    SplitTaskExecutor mTaskExecutor;
    String mTaskId;

    public SseRefreshTokenTimer(SplitTaskExecutor splitTaskExecutor, PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this.mTaskExecutor = (SplitTaskExecutor) C$Gson$Preconditions.checkNotNull(splitTaskExecutor);
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) C$Gson$Preconditions.checkNotNull(pushManagerEventBroadcaster);
    }

    public void cancel() {
        this.mTaskExecutor.stopTask(this.mTaskId);
    }

    public void schedule(long j, long j2) {
        cancel();
        this.mTaskId = this.mTaskExecutor.schedule(new SplitTask() { // from class: io.split.android.client.service.sseclient.sseclient.SseRefreshTokenTimer.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                Logger.d("Informing sse token expired throught pushing retryable error.");
                SseRefreshTokenTimer.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR));
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, reconnectTime(j, j2), null);
    }

    private long reconnectTime(long j, long j2) {
        return Math.max((j2 - j) - 600, 0L);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        this.mTaskId = null;
    }
}
