package io.split.android.client.attributes;

import java.util.Map;

/* loaded from: classes6.dex */
public interface AttributesManager {
    boolean clearAttributes();

    Map<String, Object> getAllAttributes();

    Object getAttribute(String str);

    boolean removeAttribute(String str);

    boolean setAttribute(String str, Object obj);

    boolean setAttributes(Map<String, Object> map);
}
