package io.split.android.client.service.executor;

import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class SplitTaskBatchItem {
    private final WeakReference<SplitTaskExecutionListener> listener;
    private final SplitTask task;

    public SplitTaskBatchItem(SplitTask splitTask, SplitTaskExecutionListener splitTaskExecutionListener) {
        this.task = (SplitTask) Preconditions.checkNotNull(splitTask);
        this.listener = new WeakReference<>(splitTaskExecutionListener);
    }

    public SplitTask getTask() {
        return this.task;
    }

    public SplitTaskExecutionListener getListener() {
        return this.listener.get();
    }
}
