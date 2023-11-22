package com.alibaba.griver.api.common.storage;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface GriverKVStorageProxy extends Proxiable {
    void clear(String str, String str2);

    String getString(String str, String str2, String str3);

    void putString(String str, String str2, String str3, String str4);

    void remove(String str, String str2, String str3);
}
