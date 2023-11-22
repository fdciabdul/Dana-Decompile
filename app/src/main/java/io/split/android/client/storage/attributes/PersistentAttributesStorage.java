package io.split.android.client.storage.attributes;

import java.util.Map;

/* loaded from: classes6.dex */
public interface PersistentAttributesStorage {
    void clear(String str);

    Map<String, Object> getAll(String str);

    void set(String str, Map<String, Object> map);
}
