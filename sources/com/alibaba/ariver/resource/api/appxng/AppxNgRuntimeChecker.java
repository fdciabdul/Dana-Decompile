package com.alibaba.ariver.resource.api.appxng;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ParcelUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appxng.AppPreRenderModel;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.runtime.RuntimeCheckResult;
import com.alibaba.ariver.resource.runtime.RuntimeVersionChecker;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class AppxNgRuntimeChecker extends RuntimeVersionChecker {
    private static final String FORCE_APPX_MODEL_4DEBUG = "forceAppxMode4Debug";
    private static final String TAG = "AriverRes:AppxNgRuntimeChecker";

    /* loaded from: classes6.dex */
    public enum SoloPackageType {
        forceSolo,
        trySolo,
        forceTotal
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeRequired() {
        return "appxRuntimeRequired";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeSupportMax() {
        return "webRuntimeSupportMax";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeSupportMin() {
        return "webRuntimeSupportMin";
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getTag() {
        return TAG;
    }

    public AppxNgRuntimeChecker(String str) {
        super(str);
    }

    public static void setAppxNgPackageSolo(AppModel appModel, boolean z) {
        appModel.getExtendInfos().put(RVConstants.APPXNG_SOLO_PACKAGE_TYPE, (Object) Integer.valueOf(z ? 1 : 0));
    }

    public static boolean isAppxNgSoloPackage(AppModel appModel) {
        return JSONUtils.getInt(appModel.getExtendInfos(), RVConstants.APPXNG_SOLO_PACKAGE_TYPE) == 1;
    }

    public static boolean isPreRenderingWebView(App app, View view) {
        AppPreRenderModel appPreRenderModel;
        return (app == null || (appPreRenderModel = (AppPreRenderModel) app.getData(AppPreRenderModel.class, false)) == null || !appPreRenderModel.isPreLoad || appPreRenderModel.preRenderWebView == null || appPreRenderModel.preRenderWebView.get() != view) ? false : true;
    }

    public static boolean isPreRenderingApp(App app) {
        AppPreRenderModel appPreRenderModel;
        if (app == null || (appPreRenderModel = (AppPreRenderModel) app.getData(AppPreRenderModel.class, false)) == null) {
            return false;
        }
        return appPreRenderModel.isPreLoad;
    }

    public static AppPreRenderModel getPrerenderModel(App app) {
        if (app == null) {
            return null;
        }
        return (AppPreRenderModel) app.getData(AppPreRenderModel.class, false);
    }

    public static AppPreRenderModel setAppPreRendering(App app, View view) {
        if (app == null) {
            return null;
        }
        AppPreRenderModel appPreRenderModel = (AppPreRenderModel) app.getData(AppPreRenderModel.class, true);
        appPreRenderModel.isPreLoad = true;
        appPreRenderModel.status = AppPreRenderModel.Status.prepare;
        appPreRenderModel.preRenderWebView = new WeakReference<>(view);
        StringBuilder sb = new StringBuilder();
        sb.append("setAppPreRendering view is:  ");
        sb.append(view);
        RVLogger.d(TAG, sb.toString());
        return appPreRenderModel;
    }

    public static void downGradingPreRender(App app) {
        AppPreRenderModel appPreRenderModel;
        if (app == null || (appPreRenderModel = (AppPreRenderModel) app.getData(AppPreRenderModel.class, false)) == null) {
            return;
        }
        appPreRenderModel.isPreLoad = false;
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public String getRuntimeVersion() {
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(getRuntimeAppId());
        String version = resourcePackage != null ? resourcePackage.version() : null;
        if (TextUtils.isEmpty(version)) {
            AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(getRuntimeAppId()));
            if (appModel != null) {
                version = appModel.getAppVersion();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("globalPackagePool is empty,getVersion from AppInfoManager\t ");
            sb.append(getRuntimeAppId());
            sb.append("\t version is\t ");
            sb.append(TextUtils.isEmpty(version) ? "null" : version);
            RVLogger.d(TAG, sb.toString());
        }
        return version;
    }

    public boolean isAvailable(AppModel appModel) {
        return ((RVResourceManager) RVProxy.get(RVResourceManager.class)).isAvailable(appModel);
    }

    private boolean checkAppNgSupport() {
        String runtimeVersion = getRuntimeVersion();
        JSONObject jSONObject = JSONUtils.getJSONObject(((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(getRuntimeAppId()).version(runtimeVersion)).getExtendInfos(), "paramsMap", null);
        boolean z = jSONObject != null ? JSONUtils.getBoolean(jSONObject, "isAppxSupportPrerenderStartup", false) : false;
        StringBuilder sb = new StringBuilder();
        sb.append("preRender checkAppxNgPackage support : ");
        sb.append(z);
        sb.append(" version: ");
        sb.append(runtimeVersion);
        RVLogger.d(TAG, sb.toString());
        return z;
    }

    public boolean checkAppxSupportCrossVersionSnapshot(App app, AppModel appModel) {
        if ("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework"))) {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_appx_snapshot_crossversion");
            if (!CollectionUtils.isEmpty(configJSONArray) && ((configJSONArray.contains(app.getAppId()) || configJSONArray.contains("all")) && JSONUtils.getBoolean(JSONUtils.parseObject(JSONUtils.getString(JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_PARAM_MAP, null), RVStartParams.KEY_ENABLE_HTML_SNAPSHOT)), "crossVersion", false))) {
                String runtimeVersion = getRuntimeVersion();
                AppModel appModel2 = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(getRuntimeAppId()).version(runtimeVersion));
                if (appModel2 == null) {
                    return false;
                }
                JSONObject jSONObject = JSONUtils.getJSONObject(appModel2.getExtendInfos(), "paramsMap", null);
                r1 = jSONObject != null ? JSONUtils.getBoolean(jSONObject, "isAppxSupportCrossVersionSnapshot", false) : false;
                StringBuilder sb = new StringBuilder();
                sb.append("checkAppxSupportCrossVersionSnapshot: ");
                sb.append(runtimeVersion);
                sb.append(" appId:");
                sb.append(app.getAppId());
                sb.append(" ");
                sb.append(r1);
                sb.append(" ");
                sb.append(configJSONArray);
                RVLogger.d(TAG, sb.toString());
            }
        }
        return r1;
    }

    public boolean needCheckSnapshotMd5(App app) {
        JSONObject jSONObject;
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshot_md5_check");
        if (CollectionUtils.isEmpty(configJSONArray)) {
            return false;
        }
        if (configJSONArray.contains(app.getAppId()) || configJSONArray.contains("all")) {
            AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(getRuntimeAppId()).version(getRuntimeVersion()));
            if (appModel == null || (jSONObject = JSONUtils.getJSONObject(appModel.getExtendInfos(), "paramsMap", null)) == null) {
                return false;
            }
            return JSONUtils.getBoolean(jSONObject, "isAppxSupportCrossVersionSnapshot", false);
        }
        return false;
    }

    public boolean checkUsePreRender(App app) {
        if (app.isTinyApp()) {
            String appId = app.getAppId();
            if (RVKernelUtils.isDebug() && "yes".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxNgPreRender"))) {
                return checkAppNgSupport();
            }
            if ("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework"))) {
                RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                JSONArray configJSONArray = rVConfigService.getConfigJSONArray("ta_prerender_blacklist");
                if (!CollectionUtils.isEmpty(configJSONArray) && configJSONArray.contains(appId)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(appId);
                    sb.append("  in preRender blacklist");
                    RVLogger.d(TAG, sb.toString());
                    return false;
                }
                JSONArray configJSONArray2 = rVConfigService.getConfigJSONArray("ta_prerender_whitelist");
                if (!CollectionUtils.isEmpty(configJSONArray2) && (configJSONArray2.contains(appId) || configJSONArray2.contains("all"))) {
                    return checkAppNgSupport();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(appId);
                sb2.append(" not in preRender whitelist");
                RVLogger.d(TAG, sb2.toString());
            }
            return false;
        }
        return false;
    }

    public boolean checkUseNewPackageUrl(AppModel appModel, Bundle bundle) {
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        if (appInfoModel != null) {
            if (!TextUtils.isEmpty(appInfoModel.getNewPackageUrl()) && !TextUtils.isEmpty(appInfoModel.getNewPackageSize())) {
                if (!AppInfoScene.isDevSource(bundle) && TextUtils.isEmpty(appInfoModel.getNewFallbackBaseUrl())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("appx-ng check use solo package disable by new fallbackBaseUrl  is empty ");
                    sb.append(appInfoModel.getAppId());
                    RVLogger.d(TAG, sb.toString());
                    return false;
                } else if (!CollectionUtils.isEmpty(appInfoModel.getSubPackages()) && CollectionUtils.isEmpty(appInfoModel.getNewSubPackages())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("appx-ng check use solo package disable by newSubpackages is empty ");
                    sb2.append(appInfoModel.getAppId());
                    RVLogger.d(TAG, sb2.toString());
                    return false;
                } else {
                    SoloPackageType isConfigSupport = isConfigSupport(appInfoModel.getAppId());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" soloPackageType is ");
                    sb3.append(isConfigSupport);
                    RVLogger.d(TAG, sb3.toString());
                    if (isConfigSupport == SoloPackageType.trySolo) {
                        try {
                            AppModel appModel2 = (AppModel) ParcelUtils.parcelAndUnParcel(appModel);
                            setAppxNgPackageSolo(appModel2, true);
                            if (isAvailable(appModel2)) {
                                return true;
                            }
                            setAppxNgPackageSolo(appModel2, false);
                            if (isAvailable(appModel2)) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("appx-ng check use solo package disable by tryconfig，while newpackage is not available ,package url is availabe ");
                                sb4.append(appInfoModel.getAppId());
                                RVLogger.d(TAG, sb4.toString());
                                return false;
                            }
                            return true;
                        } catch (Exception e) {
                            RVLogger.w(TAG, "appx-ng check use solo package try failed", e);
                            return true;
                        }
                    } else if (isConfigSupport == SoloPackageType.forceSolo) {
                        return true;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("appx-ng check use solo package disable by config ");
                        sb5.append(appInfoModel.getAppId());
                        RVLogger.d(TAG, sb5.toString());
                    }
                }
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("appx-ng check use solo package disable by newpackageurl or newpackagesize  is empty ");
                sb6.append(appInfoModel.getAppId());
                RVLogger.d(TAG, sb6.toString());
            }
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("appx-ng check use solo package disable by appinfo model is null ");
            sb7.append(appInfoModel.getAppId());
            RVLogger.d(TAG, sb7.toString());
        }
        return false;
    }

    public boolean checkUseNewPackageUrlWithDevSource(AppModel appModel, Bundle bundle) {
        if (appModel != null && appModel.getAppInfoModel() != null) {
            if (AppInfoScene.isDevSource(bundle) && BundleUtils.contains(bundle, FORCE_APPX_MODEL_4DEBUG)) {
                int i = BundleUtils.getInt(bundle, FORCE_APPX_MODEL_4DEBUG, 0);
                StringBuilder sb = new StringBuilder();
                sb.append("appx-ng check use solo package forceAppxMode4Debug is: ");
                sb.append(i);
                sb.append(appModel.getAppId());
                RVLogger.d(TAG, sb.toString());
                if (i == 0 || i == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("appx-ng check use solo package disable by devSource forceAppxModelDebug == ");
                    sb2.append(i);
                    sb2.append(appModel.getAppId());
                    RVLogger.d(TAG, sb2.toString());
                    return false;
                } else if (i == 2) {
                    return true;
                }
            }
            AppInfoModel appInfoModel = appModel.getAppInfoModel();
            if (bundle != null && appInfoModel != null) {
                if ("YES".equalsIgnoreCase(BundleUtils.getString(bundle, "appxRouteFramework"))) {
                    return checkUseNewPackageUrl(appModel, bundle);
                }
                RVLogger.d(TAG, "appx-ng check use solo package disable by appx1.0 ");
                return false;
            }
            RVLogger.d(TAG, "appx-ng check use solo package disable by appinfo model is null ");
        }
        return false;
    }

    private SoloPackageType isConfigSupport(String str) {
        JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("ta_appx2_solo_config");
        if (configJSONObject != null) {
            JSONArray jSONArray = JSONUtils.getJSONArray(configJSONObject, "deny_list", null);
            if (jSONArray != null && (jSONArray.contains(str) || jSONArray.contains("all"))) {
                return SoloPackageType.forceTotal;
            }
            JSONArray jSONArray2 = JSONUtils.getJSONArray(configJSONObject, "allow_list", null);
            if (jSONArray2 != null && (jSONArray2.contains(str) || jSONArray2.contains("all"))) {
                return SoloPackageType.forceSolo;
            }
            JSONArray jSONArray3 = JSONUtils.getJSONArray(configJSONObject, "try_allow_list", null);
            if (jSONArray3 != null && (jSONArray3.contains(str) || jSONArray3.contains("all"))) {
                return SoloPackageType.trySolo;
            }
        }
        return SoloPackageType.forceTotal;
    }

    @Override // com.alibaba.ariver.resource.runtime.RuntimeVersionChecker
    public RuntimeCheckResult checkRuntimeVersion(AppModel appModel, Bundle bundle) {
        String runtimeAppId = getRuntimeAppId();
        String string = BundleUtils.contains(bundle, getRuntimeRequired()) ? BundleUtils.getString(bundle, getRuntimeRequired()) : null;
        if (TextUtils.isEmpty(string) && appModel.getContainerInfo() != null) {
            string = JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), getRuntimeRequired());
        }
        String runtimeVersion = getRuntimeVersion();
        if (TextUtils.isEmpty(runtimeVersion)) {
            StringBuilder sb = new StringBuilder();
            sb.append(runtimeAppId);
            sb.append("version is empty,appx-ng");
            RVLogger.d(TAG, sb.toString());
            return new RuntimeCheckResult(false, true, "1");
        }
        RuntimeCheckResult checkRuntimeMatched = checkRuntimeMatched(runtimeAppId, runtimeVersion, string);
        if (!checkRuntimeMatched.isEnabled()) {
            RVLogger.d(getTag(), String.format("%s not match,update", runtimeAppId));
        }
        return checkRuntimeMatched;
    }
}
