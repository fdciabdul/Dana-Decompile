package io.split.android.client.storage.attributes;

import java.util.Map;

/* loaded from: classes6.dex */
public interface AttributesStorageContainer {
    void destroy();

    Map<String, AttributesStorage> getCurrentStorages();

    AttributesStorage getStorageForKey(String str);
}
