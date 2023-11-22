package io.split.android.client.service.executor;

import com.google.common.base.Preconditions;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* loaded from: classes6.dex */
class SplitTaskBatchWrapper implements Runnable {
    private final List<SplitTaskBatchItem> mTaskQueue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplitTaskBatchWrapper(List<SplitTaskBatchItem> list) {
        this.mTaskQueue = (List) Preconditions.checkNotNull(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (SplitTaskBatchItem splitTaskBatchItem : this.mTaskQueue) {
                SplitTaskExecutionInfo execute = splitTaskBatchItem.getTask().execute();
                SplitTaskExecutionListener listener = splitTaskBatchItem.getListener();
                if (listener != null) {
                    listener.taskExecuted(execute);
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("An error has occurred while running task on executor: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        }
    }
}
