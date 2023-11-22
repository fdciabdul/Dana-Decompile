package com.alibaba.ariver.kernel.common.storage;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes2.dex */
public interface KVStorageProxy extends Proxiable {
    public static final String COMMON_APPID = "empty_appId";

    void clear(String str);

    String getString(String str, String str2);

    void putString(String str, String str2, String str3);

    void remove(String str, String str2);
}
