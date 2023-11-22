package io.split.android.client.service.impressions.unique;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class SaveUniqueImpressionsTask implements SplitTask {
    private final PersistentImpressionsUniqueStorage mStorage;
    private final Map<String, Set<String>> mUniqueKeys;

    public SaveUniqueImpressionsTask(PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, Map<String, Set<String>> map) {
        this.mStorage = (PersistentImpressionsUniqueStorage) Preconditions.checkNotNull(persistentImpressionsUniqueStorage);
        this.mUniqueKeys = map == null ? Collections.emptyMap() : map;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (!this.mUniqueKeys.isEmpty()) {
            this.mStorage.pushMany(mapToModel(this.mUniqueKeys));
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.SAVE_UNIQUE_KEYS_TASK);
    }

    private static List<UniqueKey> mapToModel(Map<String, Set<String>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            arrayList.add(new UniqueKey(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
