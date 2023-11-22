package com.alibaba.griver.h5.extension;

import android.text.TextUtils;
import com.alibaba.griver.h5.api.GriverDataCacheExtension;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverDataCacheExtensionImpl implements GriverDataCacheExtension {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f6546a = new HashMap();

    @Override // com.alibaba.griver.h5.api.GriverDataCacheExtension
    public String get(String str) {
        return (!TextUtils.isEmpty(str) && this.f6546a.containsKey(str)) ? this.f6546a.get(str) : "";
    }

    @Override // com.alibaba.griver.h5.api.GriverDataCacheExtension
    public void set(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6546a.put(str, str2);
    }

    @Override // com.alibaba.griver.h5.api.GriverDataCacheExtension
    public void set(String str, String str2, boolean z) {
        set(str, str2);
    }

    @Override // com.alibaba.griver.h5.api.GriverDataCacheExtension
    public void remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6546a.remove(str);
    }

    @Override // com.alibaba.griver.h5.api.GriverDataCacheExtension
    public boolean has(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f6546a.containsKey(str);
    }
}
