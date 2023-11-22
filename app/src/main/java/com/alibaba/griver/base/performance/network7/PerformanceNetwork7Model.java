package com.alibaba.griver.base.performance.network7;

import com.alibaba.griver.base.common.utils.MapBuilder;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetwork7Model {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f6337a = new ConcurrentHashMap<>();

    public void setNetWorkHttp(String str) {
        if (this.f6337a.containsKey(str)) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.f6337a;
            concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
            return;
        }
        this.f6337a.put(str, 1);
    }

    public void clear() {
        this.f6337a.clear();
    }

    public Map<String, String> getUploadMap() {
        if (this.f6337a.size() == 0) {
            return null;
        }
        MapBuilder.Builder builder = new MapBuilder.Builder();
        for (Map.Entry<String, Integer> entry : this.f6337a.entrySet()) {
            builder.map(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return builder.build();
    }
}
