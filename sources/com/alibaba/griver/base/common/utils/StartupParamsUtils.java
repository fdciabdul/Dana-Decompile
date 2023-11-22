package com.alibaba.griver.base.common.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class StartupParamsUtils {
    public static Bundle filterBundle(String str, String str2, Bundle bundle) {
        return filterBundle(str, str2, bundle, true);
    }

    public static Bundle filterBundle(String str, String str2, Bundle bundle, boolean z) {
        Bundle bundle2;
        if (bundle == null || bundle.size() == 0) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        List parseArray = JSON.parseArray(GriverConfigConstants.DEFAULT_RESERVED_PARAMS_LIST, String.class);
        try {
            parseArray = JSON.parseArray(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_RESERVED_STARTUP_PARAMS, GriverConfigConstants.DEFAULT_RESERVED_PARAMS_LIST), String.class);
        } catch (Exception e) {
            GriverLogger.w("StartupParamsUtils", "parse config failed", e);
        }
        if (!bundle2.containsKey("titleColor")) {
            bundle2.putInt("titleColor", 0);
        }
        Iterator<String> it = bundle2.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String next = it.next();
            if (parseArray.contains(next)) {
                sb.append(next);
                sb.append(",");
                it.remove();
            }
        }
        if (z && !TextUtils.isEmpty(sb.toString())) {
            sb.delete(sb.length() - 1, sb.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found reserved startup parameter with key: ");
            sb2.append((Object) sb);
            GriverLogger.d("StartupParamsUtils", sb2.toString());
            GriverMonitor.error(GriverMonitorConstants.ERROR_RESERVED_PARAMS_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(str).url(str2).append("paramName", sb.toString()).build());
        }
        return bundle2;
    }
}
