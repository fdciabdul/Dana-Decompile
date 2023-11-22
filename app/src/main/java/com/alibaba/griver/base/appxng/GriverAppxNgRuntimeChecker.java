package com.alibaba.griver.base.appxng;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class GriverAppxNgRuntimeChecker {
    private static final String TAG = "AppxNgUtils";
    public static final String VALUE_ENABLED = "yes";
    private static Appx2Config sConfig;

    public static boolean isUseAppxNg(AppModel appModel) {
        return isUseAppxNg(appModel, null);
    }

    public static boolean isUseAppxNg(PluginModel pluginModel) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            JSONObject extendInfo = pluginModel.getExtendInfo();
            if (extendInfo == null) {
                return false;
            }
            if (extendInfo.containsKey("appxVersion")) {
                return "2".equals(extendInfo.getString("appxVersion"));
            }
            if (TextUtils.isEmpty(pluginModel.getNewPackageUrl()) || (jSONObject = extendInfo.getJSONObject("extData")) == null || (jSONObject2 = jSONObject.getJSONObject("packageInfo")) == null || (jSONObject3 = jSONObject2.getJSONObject("extendInfo")) == null || (jSONObject4 = jSONObject3.getJSONObject(RVConstants.EXTRA_RES_LAUNCH_PARAMS)) == null || !"yes".equalsIgnoreCase(jSONObject4.getString("appxRouteFramework"))) {
                return false;
            }
            if (sConfig == null) {
                sConfig = new Appx2Config(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_APPX_2_0_CTL));
            }
            return sConfig.canUseAppx2_0(pluginModel.getAppId());
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppxNgUtils#canUserAppxNg, e");
            sb.append(th);
            GriverLogger.d(TAG, sb.toString());
            return false;
        }
    }

    public static boolean isUseAppxNg(AppModel appModel, Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            JSONObject extendInfos = appModel.getExtendInfos();
            if (extendInfos == null) {
                return false;
            }
            if (extendInfos.containsKey("appxVersion")) {
                return "2".equals(extendInfos.getString("appxVersion"));
            }
            if (TextUtils.isEmpty(appModel.getAppInfoModel().getNewPackageUrl()) || (jSONObject = extendInfos.getJSONObject("extData")) == null || (jSONObject2 = jSONObject.getJSONObject("packageInfo")) == null || (jSONObject3 = jSONObject2.getJSONObject("extendInfo")) == null || (jSONObject4 = jSONObject3.getJSONObject(RVConstants.EXTRA_RES_LAUNCH_PARAMS)) == null || !"yes".equalsIgnoreCase(jSONObject4.getString("appxRouteFramework"))) {
                return false;
            }
            if (bundle == null || !AppInfoScene.isDevSource(bundle)) {
                if (sConfig == null) {
                    sConfig = new Appx2Config(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_APPX_2_0_CTL));
                }
                return sConfig.canUseAppx2_0(appModel.getAppId());
            }
            return true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppxNgUtils#canUserAppxNg, e");
            sb.append(th);
            GriverLogger.d(TAG, sb.toString());
            return false;
        }
    }

    public static boolean isUseAppxNg(Bundle bundle) {
        return "2".equals(bundle.getString("appxVersion"));
    }

    public static String getPackageUrl(AppModel appModel) {
        try {
            if (isUseAppxNg(appModel)) {
                return appModel.getExtendInfos() == null ? "" : appModel.getAppInfoModel().getNewPackageUrl();
            }
            return appModel.getAppInfoModel().getPackageUrl();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppxNgUtils#getPackageUrl, e");
            sb.append(e);
            GriverLogger.w(TAG, sb.toString());
            return "";
        }
    }

    public static String getPackageUrl(PluginModel pluginModel) {
        try {
            if (isUseAppxNg(pluginModel)) {
                return pluginModel.getExtendInfo() == null ? "" : pluginModel.getNewPackageUrl();
            }
            return pluginModel.getPackageUrl();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppxNgUtils#getPackageUrl, e");
            sb.append(e);
            GriverLogger.w(TAG, sb.toString());
            return "";
        }
    }
}
