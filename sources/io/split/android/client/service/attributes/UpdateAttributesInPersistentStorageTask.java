package io.split.android.client.service.attributes;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import java.util.Map;

/* loaded from: classes9.dex */
public class UpdateAttributesInPersistentStorageTask implements SplitTask {
    private final Map<String, Object> mAttributes;
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public UpdateAttributesInPersistentStorageTask(String str, PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> map) {
        this.mMatchingKey = (String) Preconditions.checkNotNull(str);
        this.mPersistentAttributesStorage = (PersistentAttributesStorage) Preconditions.checkNotNull(persistentAttributesStorage);
        this.mAttributes = (Map) Preconditions.checkNotNull(map);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mPersistentAttributesStorage.set(this.mMatchingKey, this.mAttributes);
        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
    }
}
