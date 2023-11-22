package com.alibaba.griver.core.prefetch;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.core.ui.GriverPage;
import com.alibaba.griver.core.utils.H5CookieUtil;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.acs.plugin.utils.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PrefetchUtils {
    private static Map<String, String> b;

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, JSONObject> f6439a = new ConcurrentHashMap();
    private static volatile App c = null;
    private static volatile String d = null;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b = concurrentHashMap;
        concurrentHashMap.put(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_SYSTEMINFO, JSApiCachePoint.GET_SYSTEM_INFO);
        b.put("storage", JSApiCachePoint.GET_LOCAL_STORAGE);
        b.put("siteInfo", Constants.JS_API_GET_SITE_INFO);
        b.put("location", "getCurrentLocation");
        b.put("authCode", Constants.JS_API_GET_AUTH_CODE);
        b.put("query", "query");
        b.put("metaData", "metaData");
        b.put("dependencies", "dependencies");
        b.put("pathParams", "pathParams");
    }

    public static void setDependencies(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Map<String, JSONObject> map = f6439a;
        if (map.get("dependencies") != null) {
            jSONObject2 = map.get("dependencies");
        }
        jSONObject2.put(str, (Object) jSONObject);
        map.put("dependencies", jSONObject2);
    }

    public static void clearJSAPICache() {
        f6439a.clear();
    }

    public static boolean isPrefetchAllowed(String str) {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.APP_PREFETCH_CONFIG);
        if (configJSONObject != null && configJSONObject.getBoolean("enable").booleanValue()) {
            JSONArray jSONArray = JSONUtils.getJSONArray(configJSONObject, "blackList", new JSONArray());
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    if (str.equals(jSONArray.getString(i))) {
                        return false;
                    }
                }
            }
            try {
                JSONArray jSONArray2 = configJSONObject.getJSONArray("whiteList");
                if (jSONArray2 == null || jSONArray2.size() == 0) {
                    return true;
                }
                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                    if (str.equals(jSONArray2.getString(i2))) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                GriverLogger.e("PrefetchUtils", "whitelist parse exception");
                return false;
            }
        }
        return false;
    }

    public static String generateRequestData(JSONArray jSONArray) {
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) next;
                for (String str : jSONObject.keySet()) {
                    Object obj = jSONObject.get(str);
                    if (obj instanceof JSONArray) {
                        a((JSONArray) obj);
                    }
                    if (obj instanceof JSONObject) {
                        a((JSONObject) obj);
                    }
                    if (obj instanceof String) {
                        jSONObject.put(str, (Object) a((String) obj));
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    public static JSONObject generateRequestData(JSONObject jSONObject) {
        for (String str : jSONObject.keySet()) {
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                a((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                a((JSONObject) obj);
            }
            if (obj instanceof String) {
                jSONObject.put(str, a((String) obj));
            }
        }
        return jSONObject;
    }

    private static void a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                a((JSONObject) obj);
            }
        }
    }

    private static void a(JSONObject jSONObject) {
        for (String str : jSONObject.keySet()) {
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                a((JSONObject) obj);
            } else if (obj instanceof String) {
                jSONObject.put(str, a((String) obj));
            }
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2 || !str.startsWith("$") || !str.endsWith("$")) {
            return str;
        }
        String a2 = a(str.substring(1, str.length() - 1).split("\\."));
        return !TextUtils.isEmpty(a2) ? a2 : "";
    }

    private static String a(String[] strArr) {
        JSONObject infoFromJSApi;
        if (strArr != null && strArr.length >= 2) {
            String str = strArr[0];
            JSONObject jSONObject = null;
            if (str.contains("?")) {
                String str2 = str.split("\\?")[0];
                jSONObject = JSON.parseObject(str.split("\\?")[1]);
                str = str2;
            }
            if (!b.containsKey(str) || (infoFromJSApi = getInfoFromJSApi(jSONObject, b.get(str))) == null) {
                return "";
            }
            for (int i = 1; i < strArr.length; i++) {
                Object obj = infoFromJSApi.get(strArr[i]);
                if (obj instanceof JSONObject) {
                    infoFromJSApi = (JSONObject) obj;
                } else {
                    String string = infoFromJSApi.getString(strArr[i]);
                    return string == null ? "" : string;
                }
            }
        }
        return "";
    }

    private static JSONObject b(String str) {
        if (str.equals("query")) {
            String str2 = (String) c.getStartParams().get("query");
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str3 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str3.split("=");
                if (split != null && split.length == 2) {
                    jSONObject.put(split[0], (Object) split[1]);
                }
            }
            return jSONObject;
        } else if (str.equals("pathParams")) {
            if (TextUtils.isEmpty(d)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            for (String str4 : d.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split2 = str4.split("=");
                if (split2 != null && split2.length == 2) {
                    jSONObject2.put(split2[0], (Object) split2[1]);
                }
            }
            return jSONObject2;
        } else if (str.equals("metaData")) {
            return (JSONObject) JSON.toJSON((AppModel) c.getData(AppModel.class));
        } else {
            if (str.equals("dependencies")) {
                return f6439a.get("dependencies");
            }
            return null;
        }
    }

    public static JSONObject getInfoFromJSApi(final JSONObject jSONObject, final String str) {
        if (str.equals("query") || str.equals("metaData") || str.equals("dependencies") || str.equals("pathParams")) {
            return b(str);
        }
        Map<String, JSONObject> map = f6439a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        App app = c;
        StringBuilder sb = new StringBuilder();
        sb.append((String) c.getStartParams().get("page"));
        GriverPage griverPage = new GriverPage(app, sb.toString(), c.getStartParams(), c.getSceneParams());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(new SendToNativeCallback() { // from class: com.alibaba.griver.core.prefetch.PrefetchUtils.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
            public final void onCallback(JSONObject jSONObject2, boolean z) {
                try {
                    if (str.equals(JSApiCachePoint.GET_LOCAL_STORAGE)) {
                        PrefetchUtils.f6439a.put(str, jSONObject2.getJSONObject("data").getJSONObject("APDataStorage").getJSONObject(jSONObject.getString("key")));
                        GriverLogger.e("TNGD_PREFETCH", jSONObject2.getJSONObject("data").getJSONObject("APDataStorage").getJSONObject(jSONObject.getString("key")).toJSONString());
                    } else {
                        PrefetchUtils.f6439a.put(str, jSONObject2);
                    }
                } catch (Exception unused) {
                    GriverLogger.d("PrefetchUtils", "no data in local storage");
                }
                countDownLatch.countDown();
            }
        });
        NativeCallContext.Builder params = new NativeCallContext.Builder().node(griverPage).name(str).params(jSONObject);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(NativeCallContext.generateUniqueId());
        BridgeDispatcher.getInstance().dispatch(params.id(sb2.toString()).build(), bridgeResponseHelper, false);
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            GriverLogger.d("PrefetchUtils", "call jsapi timeout");
        }
        return f6439a.get(str);
    }

    public static JSONObject sendHttp(String str, Object obj, String str2, String str3, int i, String str4, String str5) {
        JSONObject jSONObject;
        Map<String, String> map;
        StringBuilder sb = new StringBuilder();
        sb.append(" url = [");
        sb.append(str);
        sb.append("], headers = [");
        sb.append(obj);
        sb.append("], method = [");
        String str6 = str2;
        sb.append(str6);
        sb.append("], data = [");
        sb.append(str3);
        sb.append("], timeout = [");
        sb.append(i);
        sb.append("], dataType = [");
        sb.append(str4);
        sb.append("]");
        String obj2 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http request: ");
        sb2.append(obj2);
        GriverLogger.d("PrefetchUtils", sb2.toString());
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else if (obj instanceof JSONArray) {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 0;
            while (true) {
                JSONArray jSONArray = (JSONArray) obj;
                if (i2 >= jSONArray.size()) {
                    break;
                }
                for (Map.Entry<String, Object> entry : jSONArray.getJSONObject(i2).entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                i2++;
            }
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setUrl(str);
        try {
            map = (Map) JSON.parseObject(JSON.toJSONString(jSONObject), new TypeReference<Map<String, String>>() { // from class: com.alibaba.griver.core.prefetch.PrefetchUtils.2
            }, new Feature[0]);
        } catch (Exception e) {
            GriverLogger.e("PrefetchUtils", "transfer request header failed", e);
            map = null;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        String cookie = H5CookieUtil.getCookie(str);
        if (!TextUtils.isEmpty(cookie)) {
            map.put("Cookie", cookie);
        }
        httpRequest.setHeaders(map);
        if (TextUtils.isEmpty(str2)) {
            str6 = "GET";
        }
        httpRequest.setMethod(str6);
        httpRequest.setTimeout(i);
        if (!TextUtils.isEmpty(str3)) {
            httpRequest.setRequestData(str3.getBytes());
        }
        httpRequest.setTimeout(i);
        UUID.randomUUID();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        new LinkedHashMap();
        try {
            HttpResponse request = GriverTransport.request(httpRequest);
            if (request != null && request.getStatusCode() > 0) {
                String read = IOUtils.read(request.getInputStream());
                if (TextUtils.isEmpty(read)) {
                    jSONObject3.put("fail", (Object) "");
                } else if ("base64".equalsIgnoreCase(str4)) {
                    try {
                        jSONObject3.put("success", (Object) Base64.encodeToString(read.getBytes(), 2));
                    } catch (Exception e2) {
                        jSONObject4.put("error", (Object) 14);
                        jSONObject4.put("errorMessage", (Object) e2.getMessage());
                        jSONObject3.put("fail", (Object) jSONObject4);
                    }
                }
                if (request.getStatusCode() == 200) {
                    jSONObject3.put("success", (Object) read);
                    return jSONObject3;
                } else if (request.getStatusCode() == 502) {
                    jSONObject4.put("error", (Object) 13);
                    jSONObject4.put("errorMessage", (Object) "timeout error");
                } else if (request.getStatusCode() == 403) {
                    jSONObject4.put("error", (Object) 11);
                    jSONObject4.put("errorMessage", (Object) "access forbidden");
                } else if (request.getStatusCode() >= 400) {
                    jSONObject4.put("error", (Object) 19);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("HTTP error with statusCode: ");
                    sb3.append(request.getStatusCode());
                    jSONObject4.put("errorMessage", (Object) sb3.toString());
                }
            } else {
                jSONObject4.put("error", (Object) 12);
                jSONObject4.put("errorMessage", (Object) GriverMonitorConstants.MESSAGE_HTTP_REQUEST_NETWORK_ERROR);
            }
        } catch (Exception unused) {
            jSONObject4.put("error", (Object) 12);
            jSONObject4.put("errorMessage", (Object) GriverMonitorConstants.MESSAGE_HTTP_REQUEST_NETWORK_ERROR);
        }
        jSONObject3.put("fail", (Object) jSONObject4.toString());
        return jSONObject3;
    }

    public static void setApp(App app) {
        c = app;
    }

    public static void setPathParams(String str) {
        d = str;
    }
}
