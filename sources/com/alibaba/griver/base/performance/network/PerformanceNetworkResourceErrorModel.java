package com.alibaba.griver.base.performance.network;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetworkResourceErrorModel {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f6333a = new ConcurrentHashMap<>();

    public void add(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.f6333a.get(str);
        if (num != null) {
            i = Integer.valueOf(num.intValue() + 1);
        } else {
            i = 1;
        }
        this.f6333a.put(str, i);
    }

    public Map<String, String> getUploadMap() {
        HashMap hashMap = new HashMap();
        if (this.f6333a.size() == 0) {
            return hashMap;
        }
        for (Map.Entry<String, Integer> entry : this.f6333a.entrySet()) {
            hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    public void clear() {
        this.f6333a.clear();
    }
}
