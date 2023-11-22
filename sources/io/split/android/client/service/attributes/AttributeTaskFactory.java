package io.split.android.client.service.attributes;

import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import java.util.Map;

/* loaded from: classes6.dex */
public interface AttributeTaskFactory {
    ClearAttributesInPersistentStorageTask createAttributeClearTask(PersistentAttributesStorage persistentAttributesStorage);

    UpdateAttributesInPersistentStorageTask createAttributeUpdateTask(PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> map);

    LoadAttributesTask createLoadAttributesTask(PersistentAttributesStorage persistentAttributesStorage);
}
