package com.alibaba.ariver.engine.api.common.log;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.store.JsAPICallStore;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.ApiLog;
import com.alibaba.ariver.kernel.common.log.AppLogConfigProxy;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class APILogUtils {

    /* renamed from: a  reason: collision with root package name */
    private static int f6028a = 1000;
    private static Set<String> b;
    private static boolean c;
    private static Set<String> d;
    private static Set<String> e;
    private static int f;
    private static Map<String, Map<String, String>> g;
    private static Map<String, LogCountInfo> h;

    private static void a() {
        if (c) {
            return;
        }
        AppLogConfigProxy appLogConfigProxy = (AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class);
        b = appLogConfigProxy.getIgnoreAPIList();
        d = appLogConfigProxy.getIgnoreInputAPIList();
        f6028a = appLogConfigProxy.getAPILengthLimit();
        c = true;
        f = appLogConfigProxy.getIgnoreApiLogCount();
        g = appLogConfigProxy.getNotIgnoreAPIForSpecificParam();
        h = new HashMap();
    }

    public static void logApiDispatch(NativeCallContext nativeCallContext) {
        if (nativeCallContext == null) {
            return;
        }
        try {
            a();
            String name = nativeCallContext.getName();
            JSONObject params = nativeCallContext.getParams();
            if ("XRiverNotFound".equalsIgnoreCase(JSONUtils.getString(params, "apiCallLink", ""))) {
                StringBuilder sb = new StringBuilder();
                sb.append("jsapi start log has logged in xriver api dispatch params: ");
                sb.append(params);
                RVLogger.d("AriverEngine:APILogUtils", sb.toString());
                return;
            }
            if ("internalAPI".equals(name)) {
                String string = JSONUtils.getString(params, "method");
                if (!TextUtils.isEmpty(string) && a(b, string)) {
                    a(AppLogUtils.getParentId(nativeCallContext.getNode()), name, "start", "logApiDispatch internalAPI");
                    return;
                }
            }
            if (a(b, name) && a(name, params)) {
                a(AppLogUtils.getParentId(nativeCallContext.getNode()), name, "start", "logApiDispatch");
                return;
            }
            if (!"internalAPI".equals(name) && (nativeCallContext.getNode() instanceof DataNode)) {
                ((JsAPICallStore) ((DataNode) nativeCallContext.getNode()).getData(JsAPICallStore.class, true)).append(name);
            }
            if (a(d, name) && a(name, params)) {
                a(AppLogUtils.getParentId(nativeCallContext.getNode()), name, "start", "logApiDispatchInput");
                return;
            }
            ApiLog.Builder callMode = new ApiLog.Builder().setParentId(AppLogUtils.getParentId(nativeCallContext.getNode())).setGroupId(nativeCallContext.getId()).setState("start").setApiName(nativeCallContext.getName()).setCallMode(nativeCallContext.getCallMode());
            String originalData = nativeCallContext.getOriginalData() != null ? nativeCallContext.getOriginalData() : JSONUtils.toString(params);
            int length = originalData.length();
            int i = f6028a;
            if (length > i) {
                originalData = a("all", originalData, i);
            }
            callMode.setData(originalData);
            AppLogger.log(callMode.build());
        } catch (Throwable th) {
            RVLogger.e("AriverEngine:APILogUtils", "onCallDispatch log error", th);
        }
    }

    public static void logApiSendBack(NativeCallContext nativeCallContext, JSONObject jSONObject, String str) {
        if (nativeCallContext == null) {
            return;
        }
        try {
            a();
            String name = nativeCallContext.getName();
            Integer num = null;
            String str2 = (jSONObject == null || (num = jSONObject.getInteger("error")) == null || num.intValue() == 0) ? "success" : "error";
            if (a(b, name)) {
                if (a(name, nativeCallContext.getParams())) {
                    a(AppLogUtils.getParentId(nativeCallContext.getNode()), name, str2, "logApiSendBack");
                }
            } else if (a(e, name) && a(name, nativeCallContext.getParams())) {
                a(AppLogUtils.getParentId(nativeCallContext.getNode()), name, str2, "logApiSendBackOutput");
            } else {
                ApiLog.Builder builder = new ApiLog.Builder();
                if (num != null && num.intValue() != 0) {
                    builder.setErrCode(num.intValue());
                }
                int length = str.length();
                int i = f6028a;
                if (length > i) {
                    str = a("all", str, i);
                }
                if ("rpc".equals(name)) {
                    String string = JSONUtils.getString(jSONObject, "ariverRpcTraceId");
                    String currentEnv = ((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)).getCurrentEnv();
                    if (!TextUtils.isEmpty(string)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(currentEnv);
                        sb.append("`");
                        sb.append(string);
                        sb.append(" ");
                        sb.append(str);
                        str = sb.toString();
                    }
                    builder.setData(str);
                } else {
                    builder.setData(str);
                }
                builder.setParentId(AppLogUtils.getParentId(nativeCallContext.getNode())).setApiName(nativeCallContext.getName()).setGroupId(nativeCallContext.getId()).setState(str2).setCallMode(nativeCallContext.getCallMode());
                AppLogger.log(builder.build());
            }
        } catch (Throwable th) {
            RVLogger.e("AriverEngine:APILogUtils", "onSendBack log error", th);
        }
    }

    private static boolean a(String str, JSONObject jSONObject) {
        Map<String, String> map;
        Map<String, Map<String, String>> map2 = g;
        if (map2 != null && map2.size() != 0 && g.containsKey(str) && (map = g.get(str)) != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String string = JSONUtils.getString(jSONObject, key);
                if (value != null && value.equals(string)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean a(Set<String> set, String str) {
        return set != null && set.contains(str);
    }

    private static String a(String str, String str2, int i) {
        if (str == null) {
            str = "";
        }
        if (str2 == null || str2.equals("")) {
            return "";
        }
        if (str2.length() > i) {
            String substring = str2.substring(0, i);
            StringBuilder sb = new StringBuilder();
            sb.append(str2.length());
            return String.format("value of %s length is %s, will be truncated:%s...", str, sb.toString(), substring);
        }
        return str2;
    }

    private static void a(String str, String str2, String str3, String str4) {
        IgnoreLogUtils.handleIgnoreLog(str, str2, str3, str4, f, h, IgnoreLogUtils.TYPE_API);
    }
}
