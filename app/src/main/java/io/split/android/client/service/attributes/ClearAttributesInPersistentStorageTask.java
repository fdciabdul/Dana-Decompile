package io.split.android.client.service.attributes;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;

/* loaded from: classes9.dex */
public class ClearAttributesInPersistentStorageTask implements SplitTask {
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public ClearAttributesInPersistentStorageTask(String str, PersistentAttributesStorage persistentAttributesStorage) {
        this.mMatchingKey = (String) Preconditions.checkNotNull(str);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Preconditions.checkNotNull(persistentAttributesStorage);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mPersistentAttributesStorage.clear(this.mMatchingKey);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
