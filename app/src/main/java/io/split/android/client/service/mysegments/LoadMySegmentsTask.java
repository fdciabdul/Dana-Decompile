package io.split.android.client.service.mysegments;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.mysegments.MySegmentsStorage;

/* loaded from: classes6.dex */
public class LoadMySegmentsTask implements SplitTask {
    private final MySegmentsStorage mMySegmentsStorage;

    public LoadMySegmentsTask(MySegmentsStorage mySegmentsStorage) {
        this.mMySegmentsStorage = (MySegmentsStorage) Preconditions.checkNotNull(mySegmentsStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mMySegmentsStorage.loadLocal();
        return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_MY_SYGMENTS);
    }
}
