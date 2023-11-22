package io.split.android.client.service.synchronizer.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import java.util.Set;

/* loaded from: classes6.dex */
public class MySegmentsBackgroundSyncScheduleTask implements SplitTask {
    private final Set<String> mKeySet;
    private final MySegmentsWorkManagerWrapper mWorkManagerWrapper;

    public MySegmentsBackgroundSyncScheduleTask(MySegmentsWorkManagerWrapper mySegmentsWorkManagerWrapper, Set<String> set) {
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Preconditions.checkNotNull(mySegmentsWorkManagerWrapper);
        this.mKeySet = (Set) Preconditions.checkNotNull(set);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mWorkManagerWrapper.scheduleMySegmentsWork(this.mKeySet);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
