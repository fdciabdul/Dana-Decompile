package io.split.android.client.storage.attributes;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class AttributesStorageContainerImpl implements AttributesStorageContainer {
    private final ConcurrentMap<String, AttributesStorage> mStorageMap = new ConcurrentHashMap();
    private final Object mLock = new Object();

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public AttributesStorage getStorageForKey(String str) {
        AttributesStorage attributesStorage;
        synchronized (this.mLock) {
            if (this.mStorageMap.get(str) == null) {
                this.mStorageMap.put(str, new AttributesStorageImpl());
            }
            attributesStorage = this.mStorageMap.get(str);
        }
        return attributesStorage;
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public Map<String, AttributesStorage> getCurrentStorages() {
        return new HashMap(this.mStorageMap);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public void destroy() {
        this.mStorageMap.clear();
    }
}
