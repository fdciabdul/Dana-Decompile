package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import java.util.List;

/* loaded from: classes6.dex */
public class SaveImpressionsCountTask implements SplitTask {
    private final List<ImpressionsCountPerFeature> mCounts;
    private final PersistentImpressionsCountStorage mCountsStorage;

    public SaveImpressionsCountTask(PersistentImpressionsCountStorage persistentImpressionsCountStorage, List<ImpressionsCountPerFeature> list) {
        this.mCountsStorage = (PersistentImpressionsCountStorage) Preconditions.checkNotNull(persistentImpressionsCountStorage);
        this.mCounts = (List) Preconditions.checkNotNull(list);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mCountsStorage.pushMany(this.mCounts);
        return SplitTaskExecutionInfo.success(SplitTaskType.SAVE_IMPRESSIONS_COUNT);
    }
}
