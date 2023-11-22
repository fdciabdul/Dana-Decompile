package io.split.android.client.storage.attributes;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AttributesStorageImpl implements AttributesStorage {
    private final Map<String, Object> mInMemoryAttributes = new ConcurrentHashMap();

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public Object get(String str) {
        return this.mInMemoryAttributes.get(str);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public Map<String, Object> getAll() {
        return new HashMap(this.mInMemoryAttributes);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void set(String str, Object obj) {
        this.mInMemoryAttributes.put(str, obj);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void set(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.mInMemoryAttributes.putAll(map);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void clear() {
        this.mInMemoryAttributes.clear();
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void destroy() {
        this.mInMemoryAttributes.clear();
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void remove(String str) {
        this.mInMemoryAttributes.remove(str);
    }
}
