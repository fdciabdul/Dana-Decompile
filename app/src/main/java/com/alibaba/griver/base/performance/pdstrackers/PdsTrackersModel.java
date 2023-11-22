package com.alibaba.griver.base.performance.pdstrackers;

import com.alibaba.fastjson.JSONArray;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PdsTrackersModel {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f6339a = new ConcurrentHashMap<>();

    public void addTracker(String str) {
        if (this.f6339a.containsKey(str)) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.f6339a;
            concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
        }
    }

    public void setPdsTrackers(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            this.f6339a.put(jSONArray.getString(i), 0);
        }
    }

    public void clear() {
        this.f6339a.clear();
    }

    public Map<String, Integer> getUploadMap() {
        if (this.f6339a.size() == 0) {
            return null;
        }
        return new HashMap(this.f6339a);
    }
}
