package com.alibaba.griver.base.resource;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.h5.appinfo.GriverH5AppInfo;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.executor.AbstractPriorityRunnable;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ZipUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.preset.GriverResourcePreset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverResourceManager {
    public static void saveConfiguration(Map<String, AppModel> map, boolean z) {
        saveConfiguration(map, z, false);
    }

    public static void saveConfiguration(Map<String, AppModel> map, boolean z, boolean z2) {
        String str;
        JSONObject parseObject;
        if (map == null || map.size() == 0) {
            GriverLogger.w("GriverResourceManager", "save configuration but app info map is null, return directly");
            return;
        }
        for (Map.Entry<String, AppModel> entry : map.entrySet()) {
            String key = entry.getKey();
            AppModel value = entry.getValue();
            if (!AppInfoUtils.isValid(value)) {
                StringBuilder sb = new StringBuilder();
                sb.append("configuration is invalid, no need to save, appId: ");
                sb.append(key);
                GriverLogger.w("GriverResourceManager", sb.toString());
            } else if (!TextUtils.equals(key, value.getAppId())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("configuration map key is not compatible with value id, do not save. key: ");
                sb2.append(key);
                sb2.append(", AppInfoId: ");
                sb2.append(value.getAppId());
                GriverLogger.w("GriverResourceManager", sb2.toString());
            } else {
                String appVersion = value.getAppVersion();
                AppModel queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(key);
                if (queryHighestAppInfo != null && RVResourceUtils.compareVersion(queryHighestAppInfo.getAppVersion(), appVersion) > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("version is not the newest, no need to save, appId: ");
                    sb3.append(key);
                    sb3.append(", version: ");
                    sb3.append(appVersion);
                    GriverLogger.w("GriverResourceManager", sb3.toString());
                } else {
                    if (z || queryHighestAppInfo == null || RVResourceUtils.compareVersion(queryHighestAppInfo.getAppVersion(), appVersion) < 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("save configuration, appId: ");
                        sb4.append(key);
                        sb4.append(", version: ");
                        sb4.append(appVersion);
                        GriverLogger.d("GriverResourceManager", sb4.toString());
                        GriverAppCenter.saveAppInfo(value);
                    }
                    if (!z2) {
                        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_H5_CONFIG_CONTROL);
                        if (!TextUtils.isEmpty(config)) {
                            try {
                                parseObject = JSON.parseObject(config);
                            } catch (Exception e) {
                                GriverLogger.e("GriverResourceManager", "parse h5_config_control failed", e);
                            }
                            if (parseObject.containsKey(GriverConfigConstants.PARAM_DISABLE_AUTO_DOWNLOAD) && parseObject.getBoolean(GriverConfigConstants.PARAM_DISABLE_AUTO_DOWNLOAD).booleanValue()) {
                                str = "YES";
                                installPackage(value, "YES".equalsIgnoreCase(str));
                            }
                        }
                    }
                    str = "NO";
                    installPackage(value, "YES".equalsIgnoreCase(str));
                }
            }
        }
    }

    public static Map<String, AppModel> parseAppInfoFromJSONString(String str) {
        HashMap hashMap = new HashMap();
        try {
        } catch (Exception e) {
            GriverLogger.e("GriverResourceManager", "parse config failed", e);
        }
        for (Map.Entry<String, Object> entry : JSON.parseObject(str).entrySet()) {
            JSONObject jSONObject = null;
            try {
                jSONObject = (JSONObject) entry.getValue();
            } catch (Exception e2) {
                GriverLogger.e("GriverResourceManager", "parse JSONObject failed", e2);
            }
            if (jSONObject != null) {
                if (jSONObject.containsKey("downloadURL")) {
                    try {
                        GriverH5AppInfo griverH5AppInfo = (GriverH5AppInfo) JSON.parseObject(JSON.toJSONString(jSONObject), GriverH5AppInfo.class);
                        griverH5AppInfo.appId = entry.getKey();
                        AppModel convertToAppInfo = AppInfoUtils.convertToAppInfo(griverH5AppInfo);
                        if (AppInfoUtils.isValid(convertToAppInfo)) {
                            hashMap.put(entry.getKey(), convertToAppInfo);
                        }
                    } catch (Exception unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("parse configuration for appId: ");
                        sb.append(entry);
                        sb.append(", value: ");
                        sb.append(jSONObject);
                        sb.append(" , failed");
                        GriverLogger.w("GriverResourceManager", sb.toString());
                    }
                } else {
                    try {
                        AppModel appModel = (AppModel) JSON.parseObject(JSON.toJSONString(jSONObject), AppModel.class);
                        if (AppInfoUtils.isValid(appModel)) {
                            hashMap.put(entry.getKey(), appModel);
                        }
                    } catch (Exception unused2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("parse configuration for appId: ");
                        sb2.append(entry);
                        sb2.append(", value: ");
                        sb2.append(jSONObject);
                        sb2.append(" , failed");
                        GriverLogger.w("GriverResourceManager", sb2.toString());
                    }
                }
                GriverLogger.e("GriverResourceManager", "parse config failed", e);
                return hashMap;
            }
        }
        return hashMap;
    }

    public static void installPackage(AppModel appModel, boolean z) {
        RVResourceManager rVResourceManager;
        if (!AppInfoUtils.isValid(appModel)) {
            GriverLogger.w("GriverResourceManager", "app info is invalid, do not install");
        } else if (!AppInfoUtils.shouldInstall(appModel)) {
            GriverLogger.w("GriverResourceManager", "app should not install, do not install");
        } else {
            Map<String, RVResourcePresetProxy.PresetPackage> presetPackage = GriverResourcePreset.getPresetPackage();
            boolean shouldDynamicDownload = GriverDynamicResManager.getInstance().shouldDynamicDownload(appModel);
            if (shouldDynamicDownload && (rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class)) != null) {
                rVResourceManager.deleteDownloadPackage(appModel);
                rVResourceManager.deleteInstallStatus(appModel.getAppId());
            }
            if (presetPackage != null && presetPackage.containsKey(appModel.getAppId()) && presetPackage.get(appModel.getAppId()) != null && TextUtils.equals(presetPackage.get(appModel.getAppId()).getVersion(), appModel.getAppVersion()) && !shouldDynamicDownload) {
                a(appModel, presetPackage.get(appModel.getAppId()));
            } else {
                a(appModel, z);
            }
        }
    }

    private static void a(final AppModel appModel, boolean z) {
        final RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager != null) {
            if (rVResourceManager.isAvailable(appModel)) {
                GriverLogger.d("GriverResourceManager", "has installed already, do not download");
            } else if (rVResourceManager.isDownloaded(appModel)) {
                GriverLogger.d("GriverResourceManager", "has downloaded, install directly");
                rVResourceManager.installApp(appModel, new PackageInstallCallback() { // from class: com.alibaba.griver.base.resource.GriverResourceManager.1
                    @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                    public final void onResult(boolean z2, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("install result: ");
                        sb.append(z2);
                        GriverLogger.d("GriverResourceManager", sb.toString());
                        if (z2) {
                            GriverDynamicResManager.getInstance().saveDynamicDownloadStatus(appModel);
                        }
                    }
                });
            } else if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("skip download for : ");
                sb.append(appModel.getAppId());
                GriverLogger.w("GriverResourceManager", sb.toString());
            } else {
                rVResourceManager.downloadApp(appModel, false, new PackageDownloadCallback() { // from class: com.alibaba.griver.base.resource.GriverResourceManager.2
                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                    public final void onCancel(String str) {
                    }

                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                    public final void onFailed(String str, int i, String str2) {
                    }

                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                    public final void onPrepare(String str) {
                    }

                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                    public final void onProgress(String str, int i) {
                    }

                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                    public final void onFinish(String str) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("download success, then install: ");
                        sb2.append(str);
                        GriverLogger.d("GriverResourceManager", sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("install App: ");
                        sb3.append(appModel.toString());
                        GriverLogger.d("GriverResourceManager", sb3.toString());
                        rVResourceManager.installApp(appModel, new PackageInstallCallback() { // from class: com.alibaba.griver.base.resource.GriverResourceManager.2.1
                            {
                                AnonymousClass2.this = this;
                            }

                            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                            public void onResult(boolean z2, String str2) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("install result: ");
                                sb4.append(z2);
                                GriverLogger.d("GriverResourceManager", sb4.toString());
                                if (z2) {
                                    GriverDynamicResManager.getInstance().saveDynamicDownloadStatus(appModel);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    private static void a(final AppModel appModel, final RVResourcePresetProxy.PresetPackage presetPackage) {
        GriverExecutors.getSingleOrderThreadExecutorByName(AppInfoUtils.getInstallThreadName(appModel.getAppId())).execute(new AbstractPriorityRunnable(5) { // from class: com.alibaba.griver.base.resource.GriverResourceManager.3
            @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
            public final void runTask() {
                RVResourcePresetProxy.PresetPackage presetPackage2 = presetPackage;
                if (presetPackage2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("preset package is null, do not install preset for appId: ");
                    sb.append(appModel.getAppId());
                    GriverLogger.w("GriverResourceManager", sb.toString());
                } else if (!TextUtils.equals(presetPackage2.getVersion(), appModel.getAppVersion())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("preset package version is not match, do not install preset for appId: ");
                    sb2.append(appModel.getAppId());
                    sb2.append(", version: ");
                    sb2.append(appModel.getAppVersion());
                    sb2.append(", preset version: ");
                    sb2.append(presetPackage.getVersion());
                    GriverLogger.w("GriverResourceManager", sb2.toString());
                } else if (AppInfoUtils.isInstalled(appModel)) {
                    GriverLogger.d("GriverResourceManager", "app is installed, do not install preset");
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        String installPath = AppInfoUtils.getInstallPath(appModel);
                        if (ZipUtils.unZip(presetPackage.getInputStream(), installPath) && AppInfoUtils.installPathValid(installPath)) {
                            for (String str : AppInfoUtils.getAllInstallFiles(appModel.getAppId())) {
                                if (!TextUtils.equals(str, installPath)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("delete old install path: ");
                                    sb3.append(str);
                                    GriverLogger.d("GriverResourceManager", sb3.toString());
                                    FileUtils.delete(str);
                                }
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("install preset success for appId: ");
                            sb4.append(appModel.getAppId());
                            sb4.append(", version: ");
                            sb4.append(appModel.getAppVersion());
                            GriverLogger.d("GriverResourceManager", sb4.toString());
                            GriverMonitor.event(GriverMonitorConstants.EVENT_UNZIP_SUCCESS, "GriverAppContainer", new MonitorMap.Builder().appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).needAsynAppType(true).build());
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("unzip preset failed for appId: ");
                        sb5.append(appModel.getAppId());
                        sb5.append(", version: ");
                        sb5.append(appModel.getAppVersion());
                        GriverLogger.d("GriverResourceManager", sb5.toString());
                        FileUtils.delete(installPath);
                        MonitorMap.Builder builder = new MonitorMap.Builder();
                        builder.appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).message("unzip result fail for preset").installPath(installPath);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_FAIL, "GriverAppContainer", builder.build());
                    } catch (Exception e) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("install app failed, appId: ");
                        sb6.append(appModel.getAppId());
                        sb6.append(", version: ");
                        sb6.append(appModel.getAppVersion());
                        GriverLogger.e("GriverResourceManager", sb6.toString(), e);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_UNZIP_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(appModel.getAppId()).version(appModel).cost(String.valueOf(System.currentTimeMillis() - currentTimeMillis)).exception(e).message(GriverMonitorConstants.MESSAGE_UNZIP_PRESET_ERROR).installPath(AppInfoUtils.getInstallPath(appModel)).needAsynAppType(true).build());
                        FileUtils.delete(AppInfoUtils.getInstallPath(appModel));
                    }
                }
            }
        });
    }
}
