package com.alibaba.griver.base.performance;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public interface PerformanceMonitor {
    void clear();

    JSONObject getData();

    void upload(App app);
}
