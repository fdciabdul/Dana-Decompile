package com.alibaba.griver.core.jsapi.logging;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVPerformanceModel {

    /* renamed from: a  reason: collision with root package name */
    private String f6413a;
    private Long b;
    private String c = "";
    private Map<String, Long> d = new ConcurrentHashMap();
    private Map<String, Object> e = new ConcurrentHashMap();
    private Map<String, Object> f = new ConcurrentHashMap();
    private Map<String, Object> g = new ConcurrentHashMap();

    public void track(String str, String str2, Map<String, Object> map, Map<String, Object> map2, long j) {
        if (this.d.containsKey(str)) {
            return;
        }
        if (this.e.isEmpty() && map != null) {
            this.e.putAll(map);
            RVPerformanceLogHelper.safelyFillForConcurrentMap(GriverMonitorConstants.KEY_PAGE_URL, str2, this.e);
        }
        if (map2 != null) {
            this.f.putAll(map2);
        }
        RVPerformanceLogHelper.safelyFillForConcurrentMap(str, Long.valueOf(j), this.d);
    }

    public void setCurrentAppId(String str) {
        this.f6413a = str;
        RVPerformanceLogHelper.safelyFillForConcurrentMap("appId", str, this.e);
    }

    public void setCurrentStartToken(Long l) {
        this.b = l;
        RVPerformanceLogHelper.safelyFillForConcurrentMap(RVConstants.EXTRA_START_TOKEN, l, this.e);
    }

    public void setInitScene(String str) {
        this.c = str;
    }

    public String getInitScene() {
        return this.c;
    }

    public void addData2Performance(String str, String str2) {
        this.f.put(str, str2);
    }

    public void addDatas2Performance(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, map);
    }

    public void addEvent2Performance(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, map);
    }

    public Map<String, Long> getPerformanceStages() {
        return this.d;
    }

    public Map<String, Object> getCommonDatas() {
        return this.e;
    }

    public Map<String, Object> getExtDatas() {
        return this.f;
    }

    public Map<String, Object> getEvents() {
        return this.g;
    }

    public void fillAppInfo(App app) {
        RVPerformanceLogHelper.fillAppCommonInfo(app, this.e);
    }

    public void clear() {
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
    }
}
