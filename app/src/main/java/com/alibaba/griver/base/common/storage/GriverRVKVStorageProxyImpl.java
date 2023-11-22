package com.alibaba.griver.base.common.storage;

import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;

/* loaded from: classes6.dex */
public class GriverRVKVStorageProxyImpl implements KVStorageProxy {
    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void putString(String str, String str2, String str3) {
        GriverKVStorage.putString(str, str2, str3);
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public String getString(String str, String str2) {
        return GriverKVStorage.getString(str, str2);
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void remove(String str, String str2) {
        GriverKVStorage.remove(str, str2);
    }

    @Override // com.alibaba.ariver.kernel.common.storage.KVStorageProxy
    public void clear(String str) {
        GriverKVStorage.clear(str);
    }
}
