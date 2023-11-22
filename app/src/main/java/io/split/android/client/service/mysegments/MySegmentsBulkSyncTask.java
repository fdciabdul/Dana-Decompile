package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes9.dex */
public class MySegmentsBulkSyncTask implements SplitTask {
    private final Set<MySegmentsSyncTask> mMySegmentsSyncTasks;

    public MySegmentsBulkSyncTask(Set<MySegmentsSyncTask> set) {
        this.mMySegmentsSyncTasks = (Set) Preconditions.checkNotNull(set);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        Iterator<MySegmentsSyncTask> it = this.mMySegmentsSyncTasks.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
