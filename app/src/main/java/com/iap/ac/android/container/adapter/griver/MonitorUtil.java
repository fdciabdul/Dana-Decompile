package com.iap.ac.android.container.adapter.griver;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.MonitorUtils;
import id.dana.data.here.HereOauthManager;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MonitorUtil {
    public static void monitorTradePay(BridgeInterceptor.InterceptContext interceptContext, JSONObject jSONObject) {
        MonitorMap.Builder a2 = a(interceptContext);
        if (a2 == null) {
            return;
        }
        if (jSONObject.isNull("error")) {
            a2.append("status", "success");
        } else {
            a2.append("status", "error");
        }
        try {
            a2.append("result", URLEncoder.encode(JSON.toJSONString(jSONObject), HereOauthManager.ENC));
        } catch (Exception e) {
            GriverLogger.e("MonitorUtil", "encode result failed", e);
        }
        GriverMonitor.event("mini_trade_pay", "GriverAppContainer", a2.build());
    }

    public static void monitorTradePayStart(BridgeInterceptor.InterceptContext interceptContext) {
        MonitorMap.Builder a2 = a(interceptContext);
        if (a2 == null) {
            return;
        }
        GriverMonitor.event("mini_trade_pay_start", "GriverAppContainer", a2.build());
    }

    private static MonitorMap.Builder a(BridgeInterceptor.InterceptContext interceptContext) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        Page page = interceptContext.page;
        App app = page.getApp();
        builder.appId(app.getAppId()).version(app).url(page.getOriginalURI());
        builder.append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app.getStartParams()));
        com.alibaba.fastjson.JSONObject jSONObject = interceptContext.jsParameters;
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_NO);
        String string2 = jSONObject.getString("paymentUrl");
        String string3 = jSONObject.getString(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_ORDER_STR);
        if (!TextUtils.isEmpty(string2)) {
            builder.append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_TYPE, "paymentUrl").append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_INFO, string2);
        } else if (!TextUtils.isEmpty(string3)) {
            builder.append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_TYPE, com.iap.ac.android.mpm.utils.MonitorUtil.KEY_ORDER_STR).append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_INFO, string3);
        } else if (TextUtils.isEmpty(string)) {
            return null;
        } else {
            builder.append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_TYPE, com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_NO).append(com.iap.ac.android.mpm.utils.MonitorUtil.KEY_TRADE_INFO, string);
        }
        return builder;
    }
}
