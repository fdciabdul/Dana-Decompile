package io.split.android.client.service.synchronizer.attributes;

/* loaded from: classes6.dex */
public interface AttributesSynchronizerRegistry {
    void registerAttributesSynchronizer(String str, AttributesSynchronizer attributesSynchronizer);

    void unregisterAttributesSynchronizer(String str);
}
