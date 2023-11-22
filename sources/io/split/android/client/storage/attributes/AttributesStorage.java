package io.split.android.client.storage.attributes;

import java.util.Map;

/* loaded from: classes6.dex */
public interface AttributesStorage {
    void clear();

    void destroy();

    Object get(String str);

    Map<String, Object> getAll();

    void remove(String str);

    void set(String str, Object obj);

    void set(Map<String, Object> map);
}
