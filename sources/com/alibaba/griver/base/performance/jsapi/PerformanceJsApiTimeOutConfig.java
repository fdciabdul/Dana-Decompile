package com.alibaba.griver.base.performance.jsapi;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceJsApiTimeOutConfig {
    public long timeThreshold = 500;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Long> f6331a = new ConcurrentHashMap();
    public List<String> blackJsApiList = new ArrayList();

    /* loaded from: classes6.dex */
    public class ApiThreshold {
        public String apiName;
        public long timeThreshold;

        public ApiThreshold() {
        }
    }

    public Map<String, Long> getApiThresholdMap() {
        return this.f6331a;
    }
}
