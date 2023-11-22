package io.split.android.client.service.attributes;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;

/* loaded from: classes6.dex */
public class LoadAttributesTask implements SplitTask {
    private final AttributesStorage mAttributesStorage;
    private final String mMatchingKey;
    private final PersistentAttributesStorage mPersistentAttributesStorage;

    public LoadAttributesTask(String str, AttributesStorage attributesStorage, PersistentAttributesStorage persistentAttributesStorage) {
        this.mMatchingKey = (String) Preconditions.checkNotNull(str);
        this.mAttributesStorage = attributesStorage;
        this.mPersistentAttributesStorage = persistentAttributesStorage;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        AttributesStorage attributesStorage;
        PersistentAttributesStorage persistentAttributesStorage = this.mPersistentAttributesStorage;
        if (persistentAttributesStorage != null && (attributesStorage = this.mAttributesStorage) != null) {
            attributesStorage.set(persistentAttributesStorage.getAll(this.mMatchingKey));
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.LOAD_LOCAL_ATTRIBUTES);
    }
}
