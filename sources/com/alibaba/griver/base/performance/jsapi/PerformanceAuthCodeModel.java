package com.alibaba.griver.base.performance.jsapi;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class PerformanceAuthCodeModel {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, AuthCodeTime> f6328a = new LinkedHashMap<>();

    public void begin(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        this.f6328a.put(str, new AuthCodeTime(j));
    }

    public void end(String str, long j) {
        AuthCodeTime authCodeTime;
        if (TextUtils.isEmpty(str) || j < 0 || !this.f6328a.containsKey(str) || (authCodeTime = this.f6328a.get(str)) == null) {
            return;
        }
        authCodeTime.endTime = j;
        authCodeTime.cost = j - authCodeTime.startTime;
    }

    public Map<String, Object> getUploadMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : new LinkedHashMap(this.f6328a).entrySet()) {
            linkedHashMap.put(String.valueOf(((AuthCodeTime) entry.getValue()).startTime), String.valueOf(((AuthCodeTime) entry.getValue()).cost));
        }
        return linkedHashMap;
    }

    public void clear() {
        this.f6328a.clear();
    }

    /* loaded from: classes3.dex */
    static class AuthCodeTime {
        long cost;
        long endTime;
        long startTime;

        public AuthCodeTime(long j) {
            this.startTime = j;
        }
    }
}
