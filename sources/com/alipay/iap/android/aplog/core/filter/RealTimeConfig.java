package com.alipay.iap.android.aplog.core.filter;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RealTimeConfig {
    public int interval = 5;
    public Map<String, Boolean> realtimeCategory = new ConcurrentHashMap();
    boolean enable = true;

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int i) {
        if (i <= 1) {
            i = 1;
        }
        this.interval = i;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public Map<String, Boolean> getRealtimeCategory() {
        return this.realtimeCategory;
    }

    public void setRealtimeCategory(Map<String, Boolean> map) {
        this.realtimeCategory = map;
    }
}
