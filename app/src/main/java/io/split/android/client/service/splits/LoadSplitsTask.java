package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;

/* loaded from: classes6.dex */
public class LoadSplitsTask implements SplitTask {
    private final SplitsStorage mSplitsStorage;

    public LoadSplitsTask(SplitsStorage splitsStorage) {
        this.mSplitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mSplitsStorage.loadLocal();
        if (this.mSplitsStorage.getTill() > -1) {
            return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_SPLITS);
        }
        return SplitTaskExecutionInfo.error(SplitTaskType.LOAD_LOCAL_SPLITS);
    }
}
