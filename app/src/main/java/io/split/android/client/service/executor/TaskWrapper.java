package io.split.android.client.service.executor;

import com.google.common.base.Preconditions;
import io.split.android.client.utils.logger.Logger;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
class TaskWrapper implements Runnable {
    private final WeakReference<SplitTaskExecutionListener> mExecutionListener;
    private final SplitTask mTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskWrapper(SplitTask splitTask, SplitTaskExecutionListener splitTaskExecutionListener) {
        this.mTask = (SplitTask) Preconditions.checkNotNull(splitTask);
        this.mExecutionListener = new WeakReference<>(splitTaskExecutionListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SplitTaskExecutionInfo execute = this.mTask.execute();
            SplitTaskExecutionListener splitTaskExecutionListener = this.mExecutionListener.get();
            if (splitTaskExecutionListener != null) {
                splitTaskExecutionListener.taskExecuted(execute);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("An error has occurred while running task on executor: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        }
    }
}
