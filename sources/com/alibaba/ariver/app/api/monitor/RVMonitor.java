package com.alibaba.ariver.app.api.monitor;

import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* loaded from: classes2.dex */
public interface RVMonitor extends Proxiable {
    void behavior(Page page, String str, Map<String, Object> map, Map<String, Object> map2, BridgeCallback bridgeCallback);

    void error(Page page, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);

    void errorLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map);

    void event(String str, String str2, int i, Map<String, String> map);

    void flowLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map);

    void logNebulaTech(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, Map<String, Object> map4);

    void markSpmBehavor(Context context, String str, Map<String, String> map);

    void markSpmBehavor(String str, Map<String, String> map);

    void markSpmExpose(Context context, String str, Map<String, String> map);

    void performance(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Long> map3, Map<String, Object> map4);

    void performanceLog(String str, String str2, String str3, String str4, Map<String, Object> map);
}
