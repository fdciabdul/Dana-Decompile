package com.alibaba.griver.base.common.innerapp;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverInnerAppUtil {
    public static final String KEY_CLIENT_PARAM = "clientParams";

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, ClientParams> f6293a = new ConcurrentHashMap();

    public static boolean isInnerApp(App app) {
        JSONObject extendInfos;
        JSONObject jSONObject;
        if (app == null) {
            GriverLogger.w("GriverInnerAppUtil", "check inner app, appId is null, return false");
            return false;
        }
        String appId = app.getAppId();
        if (TextUtils.isEmpty(appId)) {
            GriverLogger.w("GriverInnerAppUtil", "check inner app, appId is null, return false");
            return false;
        }
        Map<String, ClientParams> map = f6293a;
        if (map.containsKey(appId)) {
            return map.get(appId).isInnerApp();
        }
        AppModel appModel = (AppModel) BundleUtils.getParcelable(app.getSceneParams(), "appInfo");
        if (appModel == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appInfo is not in sceneParams, check inner app from database, appId:");
            sb.append(appId);
            GriverLogger.w("GriverInnerAppUtil", sb.toString());
            appModel = GriverAppCenter.queryHighestAppInfo(appId);
        }
        ClientParams clientParams = null;
        if (appModel != null && (extendInfos = appModel.getExtendInfos()) != null && extendInfos.containsKey(KEY_CLIENT_PARAM) && (jSONObject = extendInfos.getJSONObject(KEY_CLIENT_PARAM)) != null) {
            clientParams = (ClientParams) JSONObject.parseObject(jSONObject.toJSONString(), ClientParams.class);
        }
        if (clientParams != null) {
            boolean isInnerApp = clientParams.isInnerApp();
            map.put(appId, clientParams);
            return isInnerApp;
        }
        return false;
    }

    public static boolean hasPermission(App app, String str) {
        if (isInnerApp(app)) {
            Map<String, ClientParams> map = f6293a;
            if (map.containsKey(app.getAppId())) {
                ClientParams clientParams = map.get(app.getAppId());
                if (clientParams.innerPermissionEnable == null) {
                    return true;
                }
                str.hashCode();
                if (str.equals("JSAPI_SP_Config_httpRequest_allowedDomain")) {
                    return clientParams.innerPermissionEnable.isJsapiSpConfigHttpRequestAllowedDomain();
                }
                if (str.equals("Webview_Config_allowedDomain")) {
                    return clientParams.innerPermissionEnable.isWebViewConfigAllowedDomain();
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
