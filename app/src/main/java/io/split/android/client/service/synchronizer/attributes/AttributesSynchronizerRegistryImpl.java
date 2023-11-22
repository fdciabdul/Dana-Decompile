package io.split.android.client.service.synchronizer.attributes;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class AttributesSynchronizerRegistryImpl implements AttributesSynchronizerRegistry, AttributesSynchronizer {
    private final AtomicBoolean mLoadedAttributesFromCache = new AtomicBoolean(false);
    private final ConcurrentMap<String, AttributesSynchronizer> mAttributesSynchronizers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void registerAttributesSynchronizer(String str, AttributesSynchronizer attributesSynchronizer) {
        synchronized (this) {
            this.mAttributesSynchronizers.put(str, attributesSynchronizer);
            if (this.mLoadedAttributesFromCache.get()) {
                attributesSynchronizer.loadAttributesFromCache();
            }
        }
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void unregisterAttributesSynchronizer(String str) {
        this.mAttributesSynchronizers.remove(str);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizer
    public void loadAttributesFromCache() {
        synchronized (this) {
            Iterator<AttributesSynchronizer> it = this.mAttributesSynchronizers.values().iterator();
            while (it.hasNext()) {
                it.next().loadAttributesFromCache();
            }
            this.mLoadedAttributesFromCache.set(true);
        }
    }
}
