package com.alibaba.griver.core.common.monitor;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.MonitorUtils;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.data.here.HereOauthManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class KeyJSAPIMonitor {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f6396a;

    static {
        ArrayList arrayList = new ArrayList();
        f6396a = arrayList;
        arrayList.add(Constants.JS_API_TRADE_PAY);
        arrayList.add(Constants.JS_API_GET_AUTH_CODE);
        arrayList.add("appxrpc");
    }

    public static boolean isKeyAPI(String str) {
        return f6396a.contains(str);
    }

    public static void monitorKeyAPIResult(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        if (nativeCallContext == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("monitorKeyAPIResult is invoked ,jsapi name is = ");
        sb.append(nativeCallContext.getName());
        GriverLogger.d("KeyJSAPIMonitor", sb.toString());
        String name = nativeCallContext.getName();
        name.hashCode();
        char c = 65535;
        int hashCode = name.hashCode();
        if (hashCode != -792868850) {
            if (hashCode != -785307349) {
                if (hashCode == 1271209124 && name.equals(Constants.JS_API_TRADE_PAY)) {
                    c = 2;
                }
            } else if (name.equals(Constants.JS_API_GET_AUTH_CODE)) {
                c = 1;
            }
        } else if (name.equals("appxrpc")) {
            c = 0;
        }
        if (c != 0) {
            if (c == 1) {
                c(nativeCallContext, jSONObject);
                a(nativeCallContext, jSONObject);
                return;
            } else if (c != 2) {
                return;
            } else {
                b(nativeCallContext, jSONObject);
                return;
            }
        }
        JSONObject jSONObject2 = nativeCallContext.getParams().getJSONArray("requestData").getJSONObject(0);
        if (!jSONObject2.containsKey("method")) {
            GriverLogger.d("KeyJSAPIMonitor", "appxrpc jsapi request method is null");
            return;
        }
        String string = jSONObject2.getString("method");
        string.hashCode();
        if (string.equals(Constants.JS_API_GET_OPEN_USER_INFO)) {
            d(nativeCallContext, jSONObject);
        }
    }

    private static void a(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        App app;
        boolean z;
        GriverStageMonitor stageMonitor;
        if (nativeCallContext == null || nativeCallContext.getNode() == null || (app = ((Page) nativeCallContext.getNode()).getApp()) == null || !jSONObject.containsKey(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED) || !(z = JSONUtils.getBoolean(jSONObject, GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, false)) || (stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app))) == null) {
            return;
        }
        stageMonitor.addParamUnique(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, Boolean.valueOf(z));
    }

    public static void monitorKeyAPIInvoke(NativeCallContext nativeCallContext) {
        if (nativeCallContext != null && TextUtils.equals(Constants.JS_API_TRADE_PAY, nativeCallContext.getName())) {
            a(nativeCallContext);
        }
    }

    private static void a(NativeCallContext nativeCallContext) {
        MonitorMap.Builder b = b(nativeCallContext);
        if (b == null) {
            return;
        }
        GriverMonitor.event("mini_trade_pay_start", "GriverAppContainer", b.build());
    }

    private static void b(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        MonitorMap.Builder b = b(nativeCallContext);
        if (b == null) {
            return;
        }
        if (jSONObject.containsKey("error")) {
            b.append("status", "error");
        } else {
            b.append("status", "success");
        }
        try {
            b.append("result", URLEncoder.encode(JSON.toJSONString(jSONObject), HereOauthManager.ENC));
        } catch (Exception e) {
            GriverLogger.e("KeyJSAPIMonitor", "encode result failed", e);
        }
        GriverMonitor.event("mini_trade_pay", "GriverAppContainer", b.build());
    }

    private static MonitorMap.Builder b(NativeCallContext nativeCallContext) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        Node node = nativeCallContext.getNode();
        if (node instanceof Page) {
            Page page = (Page) node;
            App app = page.getApp();
            builder.appId(app.getAppId()).version(app).url(page.getOriginalURI());
            builder.append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app.getStartParams()));
        } else if (!(node instanceof App)) {
            return null;
        } else {
            App app2 = (App) node;
            Page activePage = app2.getActivePage();
            builder.appId(app2.getAppId()).version(app2);
            if (activePage != null) {
                builder.url(activePage.getOriginalURI());
            }
            builder.append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app2.getStartParams()));
        }
        if (nativeCallContext.getParams() == null) {
            return null;
        }
        return builder;
    }

    private static void c(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("monitorGetAuthCodeResult is invoked result = ");
        sb.append(JSON.toJSONString(jSONObject));
        GriverLogger.d("KeyJSAPIMonitor", sb.toString());
        MonitorMap.Builder c = c(nativeCallContext);
        if (c == null) {
            return;
        }
        if (jSONObject.containsKey("error")) {
            c.append("status", "error");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(jSONObject.getIntValue("error"));
            c.append("errorCode", sb2.toString());
            c.append("errorMessage", jSONObject.getString("errorMessage"));
        } else {
            c.append("status", "success");
        }
        GriverMonitor.event("mini_get_auth_code", "GriverAppContainer", c.build());
    }

    private static void d(NativeCallContext nativeCallContext, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("monitorGetOpenUserInfoResult is invoked result = ");
        sb.append(JSON.toJSONString(jSONObject));
        GriverLogger.d("KeyJSAPIMonitor", sb.toString());
        MonitorMap.Builder c = c(nativeCallContext);
        if (c == null) {
            return;
        }
        if (jSONObject.containsKey("error")) {
            c.append("status", "error");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(jSONObject.getIntValue("error"));
            c.append("errorCode", sb2.toString());
            c.append("errorMessage", jSONObject.getString("errorMessage"));
            return;
        }
        c.append("status", "success");
    }

    private static MonitorMap.Builder c(NativeCallContext nativeCallContext) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        Node node = nativeCallContext.getNode();
        if (node instanceof Page) {
            Page page = (Page) node;
            App app = page.getApp();
            builder.appId(app.getAppId()).version(app).url(page.getOriginalURI());
            builder.append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app.getStartParams()));
        } else if (!(node instanceof App)) {
            return null;
        } else {
            App app2 = (App) node;
            Page activePage = app2.getActivePage();
            builder.appId(app2.getAppId()).version(app2);
            if (activePage != null) {
                builder.url(activePage.getOriginalURI());
            }
            builder.append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(app2.getStartParams()));
        }
        return builder;
    }
}
