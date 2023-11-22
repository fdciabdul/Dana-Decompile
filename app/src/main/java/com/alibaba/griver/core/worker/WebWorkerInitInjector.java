package com.alibaba.griver.core.worker;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class WebWorkerInitInjector {
    public static void getInitInjectAppXStartParams(JSONObject jSONObject) {
        String a2 = a((RVConfigService) RVProxy.get(RVConfigService.class));
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        jSONObject.put("__appxFrameworkConfig", (Object) a2);
    }

    private static String a(RVConfigService rVConfigService) {
        String configWithProcessCache = rVConfigService.getConfigWithProcessCache("ta_appxStartupConfigKeys", "");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return "";
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<Object> it = JSON.parseArray(configWithProcessCache).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    String obj = next.toString();
                    String configWithProcessCache2 = rVConfigService.getConfigWithProcessCache(obj, null);
                    if (configWithProcessCache2 == null) {
                        configWithProcessCache2 = "";
                    }
                    hashMap.put(obj, configWithProcessCache2);
                }
            }
            String jSONString = JSON.toJSONString(hashMap);
            StringBuilder sb = new StringBuilder();
            sb.append("getAppxFrameworkSwitch intercept start params: ");
            sb.append(jSONString);
            RVLogger.d("WorkerInitInjector", sb.toString());
            return jSONString;
        } catch (Exception e) {
            RVLogger.e("WorkerInitInjector", "getAppxFrameworkSwitch error:", e);
            return "";
        }
    }
}
