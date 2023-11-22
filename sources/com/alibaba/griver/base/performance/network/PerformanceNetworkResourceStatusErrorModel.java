package com.alibaba.griver.base.performance.network;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetworkResourceStatusErrorModel {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f6335a = new ConcurrentHashMap<>();

    public void add(String str, String str2) {
        int i;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f6335a.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        Integer num = concurrentHashMap.get(str2);
        if (num != null) {
            i = Integer.valueOf(num.intValue() + 1);
        } else {
            i = 1;
        }
        concurrentHashMap.put(str2, i);
        this.f6335a.put(str, concurrentHashMap);
    }

    public Map<String, Map<String, Integer>> getUploadMap() {
        if (this.f6335a.size() == 0) {
            return null;
        }
        return new HashMap(this.f6335a);
    }

    public void clear() {
        this.f6335a.clear();
    }
}
