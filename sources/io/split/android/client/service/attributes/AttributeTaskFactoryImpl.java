package io.split.android.client.service.attributes;

import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import java.util.Map;

/* loaded from: classes6.dex */
public class AttributeTaskFactoryImpl implements AttributeTaskFactory {
    private final AttributesStorage mAttributesStorage;
    private final String mMatchingKey;

    public AttributeTaskFactoryImpl(String str, AttributesStorage attributesStorage) {
        this.mMatchingKey = str;
        this.mAttributesStorage = attributesStorage;
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public UpdateAttributesInPersistentStorageTask createAttributeUpdateTask(PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> map) {
        return new UpdateAttributesInPersistentStorageTask(this.mMatchingKey, persistentAttributesStorage, map);
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public ClearAttributesInPersistentStorageTask createAttributeClearTask(PersistentAttributesStorage persistentAttributesStorage) {
        return new ClearAttributesInPersistentStorageTask(this.mMatchingKey, persistentAttributesStorage);
    }

    @Override // io.split.android.client.service.attributes.AttributeTaskFactory
    public LoadAttributesTask createLoadAttributesTask(PersistentAttributesStorage persistentAttributesStorage) {
        return new LoadAttributesTask(this.mMatchingKey, this.mAttributesStorage, persistentAttributesStorage);
    }
}
