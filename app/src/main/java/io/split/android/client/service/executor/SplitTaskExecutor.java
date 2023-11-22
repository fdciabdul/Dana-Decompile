package io.split.android.client.service.executor;

import java.util.List;

/* loaded from: classes6.dex */
public interface SplitTaskExecutor {
    void executeSerially(List<SplitTaskBatchItem> list);

    void pause();

    void resume();

    String schedule(SplitTask splitTask, long j, long j2, SplitTaskExecutionListener splitTaskExecutionListener);

    String schedule(SplitTask splitTask, long j, SplitTaskExecutionListener splitTaskExecutionListener);

    void stop();

    void stopTask(String str);

    void submit(SplitTask splitTask, SplitTaskExecutionListener splitTaskExecutionListener);

    void submitOnMainThread(SplitTask splitTask);
}
