package io.split.android.client.attributes;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AttributesMergerImpl implements AttributesMerger {
    @Override // io.split.android.client.attributes.AttributesMerger
    public Map<String, Object> merge(Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        return hashMap;
    }
}
