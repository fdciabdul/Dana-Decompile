package com.alibaba.griver.base.performance.network;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetworkTimeConfig {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, MineTypeConfig> f6336a = new ConcurrentHashMap<>();

    public PerformanceNetworkTimeConfig(String str) {
        try {
            JSONObject parseObject = JSONUtils.parseObject(str);
            if (parseObject != null) {
                for (Map.Entry<String, Object> entry : parseObject.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                        this.f6336a.put(entry.getKey().replace("_", "/"), new MineTypeConfig((JSONObject) entry.getValue()));
                    }
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            GriverLogger.w("PerformanceNetworkTimeC", sb.toString());
        }
    }

    public MineTypeConfig getConfig(String str) {
        return this.f6336a.get(str);
    }

    /* loaded from: classes6.dex */
    public static class MineTypeConfig {
        public long size;
        public long time;

        public MineTypeConfig(JSONObject jSONObject) {
            this.size = JSONUtils.getLong(jSONObject, GriverMonitorConstants.KEY_SIZE, ConvertUtils.MB);
            this.time = JSONUtils.getLong(jSONObject, "time", 500L);
        }
    }
}
