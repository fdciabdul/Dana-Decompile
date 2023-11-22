package com.alibaba.griver.base.stagemonitor;

import android.os.SystemClock;
import com.alibaba.ariver.app.api.App;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class GriverStageMonitor {
    protected ConcurrentHashMap<String, Long> stageMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<>();

    public abstract void transitToError(String str);

    public abstract void upload(App app);

    public void transitToNext(String str) {
        if (str == null) {
            return;
        }
        transitToNext(str, SystemClock.elapsedRealtime());
    }

    public void transitToNext(String str, long j) {
        if (str == null) {
            return;
        }
        this.stageMap.put(str, Long.valueOf(j));
    }

    public void addParam(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.paramMap.put(str, obj);
    }

    public void removeParam(String str) {
        if (str == null) {
            return;
        }
        this.paramMap.remove(str);
    }

    public void addParamUnique(String str, Object obj) {
        if (str == null || obj == null || this.paramMap.containsKey(str)) {
            return;
        }
        this.paramMap.put(str, obj);
    }

    public Map<String, Object> getParamsMap() {
        return this.paramMap;
    }
}
