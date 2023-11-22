package com.alipay.mobile.map.log;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReportController;
import id.dana.oauth.OauthConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapBusinessLogger {
    public static final MapBusinessLogger INSTANCE = new MapBusinessLogger();

    private MapBusinessLogger() {
    }

    public void logJsApiCall(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(ReportController.PARAM_MAP_JS_API, str2);
        MapLoggerFactory.expose(context, "a565.b11414.c27269.d51586", hashMap);
    }

    public void logJsApiError(Context context, String str, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("mapErr", "JSAPI");
        hashMap.put("JSAPI", str2);
        if (i > 0) {
            hashMap.put(ReportController.PARAM_MAP_CODE, String.valueOf(i));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(ReportController.PARAM_ERROR_MESSAGE, str3);
        }
        MapLoggerFactory.expose(context, "a565.b11414.c27269.d51586", hashMap);
    }

    public void logParamError(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("mapErr", "param");
        if (i > 0) {
            hashMap.put(ReportController.PARAM_MAP_CODE, String.valueOf(i));
        }
        MapLoggerFactory.expose(context, "a565.b11414.c27269.d51586", hashMap);
    }

    public void logSDKError(Context context, String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("mapErr", OauthConstant.OauthType.SDK_TYPE);
        if (i > 0) {
            hashMap.put(ReportController.PARAM_MAP_CODE, String.valueOf(i));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(ReportController.PARAM_ERROR_MESSAGE, str2);
        }
        MapLoggerFactory.expose(context, "a565.b11414.c27269.d51586", hashMap);
    }

    public void logEvent(Context context, String str, String str2) {
        logEvent(context, str, str2, 0);
    }

    public void logEvent(Context context, String str, String str2, int i) {
        logEvent(context, str, str2, i, null);
    }

    public void logEvent(Context context, String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("mapEvent", str2);
        if (i > 0) {
            hashMap.put(ReportController.PARAM_MAP_CODE, String.valueOf(i));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("mapMsg", str3);
        }
        MapLoggerFactory.expose(context, str, hashMap);
    }

    public void logEvent(Context context, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("appId", str);
        hashMap.put("mapEvent", str2);
        MapLoggerFactory.expose(context, str, hashMap);
    }
}
