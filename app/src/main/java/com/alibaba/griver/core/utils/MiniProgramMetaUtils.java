package com.alibaba.griver.core.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.innerapp.GriverInnerAppUtil;
import com.alibaba.griver.base.utils.MiniProgramExtendUtils;

/* loaded from: classes6.dex */
public class MiniProgramMetaUtils {
    public static void extractAcParams(Page page, BridgeInterceptor.InterceptContext interceptContext, String str) {
        Bundle sceneParams;
        Bundle sceneParams2;
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        App app = page.getApp();
        if (appModel != null) {
            JSONObject jSONObject = new JSONObject();
            AppInfoModel appInfoModel = appModel.getAppInfoModel();
            if (appInfoModel != null) {
                jSONObject.put("appId", (Object) appInfoModel.getAppId());
                jSONObject.put("appType", (Object) 2);
                jSONObject.put("name", (Object) appInfoModel.getName());
                jSONObject.put("logo", (Object) appInfoModel.getLogo());
                jSONObject.put("desc", (Object) appInfoModel.getDesc());
                jSONObject.put("deployVersion", (Object) appInfoModel.getVersion());
                jSONObject.put("developerVersion", (Object) appInfoModel.getDeveloperVersion());
            }
            JSONObject extendInfos = appModel.getExtendInfos();
            if (extendInfos != null) {
                jSONObject.put("acquirerId", (Object) extendInfos.getString("acquirerId"));
                jSONObject.put("authClientId", (Object) extendInfos.getString("authClientId"));
                jSONObject.put("publishingStatus", (Object) extendInfos.getString("publishingStatus"));
                if (extendInfos.getJSONObject(GriverInnerAppUtil.KEY_CLIENT_PARAM) != null) {
                    jSONObject.put(GriverInnerAppUtil.KEY_CLIENT_PARAM, (Object) JSON.toJSONString(extendInfos.getJSONObject(GriverInnerAppUtil.KEY_CLIENT_PARAM)));
                }
                if (extendInfos.getJSONObject("languages") != null) {
                    jSONObject.put("languages", (Object) JSON.toJSONString(extendInfos.getJSONObject("languages")));
                }
                interceptContext.sourceSite = extendInfos.getString("acquirerId");
                if (app != null && (sceneParams2 = app.getSceneParams()) != null) {
                    interceptContext.newSourceSite = sceneParams2.getString("newSourceSite");
                    interceptContext.acquireSite = sceneParams2.getString("acquireSite");
                }
                boolean containsKey = extendInfos.containsKey("merchantId");
                JSONObject jSONObject2 = extendInfos.getJSONObject("acParams");
                if (containsKey) {
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (!jSONObject2.containsKey("merchantId")) {
                        jSONObject.put("merchantId", extendInfos.get("merchantId"));
                        jSONObject2.put("merchantId", extendInfos.get("merchantId"));
                    }
                }
                JSONObject jsApiExecuteConfig = MiniProgramExtendUtils.getJsApiExecuteConfig(appModel, extendInfos, str);
                if (jsApiExecuteConfig != null) {
                    if (jsApiExecuteConfig.containsKey("authClientId")) {
                        String string = jsApiExecuteConfig.getString("authClientId");
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.put("authClientId", (Object) string);
                        }
                        if (jSONObject2 != 0 && jSONObject2.containsKey("authClientId")) {
                            jSONObject2.put("authClientId", (Object) string);
                        }
                    }
                    if (jsApiExecuteConfig.containsKey("merchantId")) {
                        String string2 = jsApiExecuteConfig.getString("merchantId");
                        if (!TextUtils.isEmpty(string2)) {
                            jSONObject.put("merchantId", (Object) string2);
                            if (jSONObject2 != null) {
                                jSONObject2.put("merchantId", (Object) string2);
                            }
                        }
                    }
                    jSONObject.put("theJSAPIExeConfig", (Object) JSON.toJSONString(jsApiExecuteConfig));
                }
                jSONObject.put("acParams", (Object) JSON.toJSONString(jSONObject2));
                interceptContext.acParams = jSONObject;
            }
            if (app != null && (sceneParams = app.getSceneParams()) != null) {
                jSONObject.put("newSourceSite", (Object) sceneParams.getString("newSourceSite"));
                jSONObject.put("acquireSite", (Object) sceneParams.getString("acquireSite"));
            }
            if (appModel.getAppInfoModel() != null) {
                interceptContext.miniProgramName = appModel.getAppInfoModel().getName();
            }
        }
    }

    public static void adaptAppId(NativeCallContext nativeCallContext, BridgeInterceptor.InterceptContext interceptContext) {
        Render render;
        if (nativeCallContext == null || interceptContext == null || (render = nativeCallContext.getRender()) == null) {
            return;
        }
        String appId = render.getAppId();
        if (BundleUtils.getBoolean(render.getStartParams(), RVParams.isH5App, false) && !TextUtils.isEmpty(appId)) {
            if (TextUtils.equals("null_online", appId)) {
                appId = "";
            } else if (appId.endsWith(GriverBaseConstants.H5_ONLINE_SUFFIX)) {
                appId = appId.replace(GriverBaseConstants.H5_ONLINE_SUFFIX, "");
            }
        }
        interceptContext.miniProgramAppID = appId;
    }
}
