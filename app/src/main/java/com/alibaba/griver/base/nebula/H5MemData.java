package com.alibaba.griver.base.nebula;

import com.alibaba.griver.base.api.H5Data;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5MemData implements H5Data {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f6322a = new HashMap();

    @Override // com.alibaba.griver.base.api.H5Data
    public void set(String str, String str2) {
        this.f6322a.put(str, str2);
    }

    @Override // com.alibaba.griver.base.api.H5Data
    public String get(String str) {
        return this.f6322a.get(str);
    }

    @Override // com.alibaba.griver.base.api.H5Data
    public String remove(String str) {
        return this.f6322a.remove(str);
    }

    @Override // com.alibaba.griver.base.api.H5Data
    public boolean has(String str) {
        return this.f6322a.containsKey(str);
    }
}
