package com.alibaba.ariver.resource.api;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.util.Map;

/* loaded from: classes3.dex */
public class RVResourceUtils {
    public static String getPresetVersion(String str) {
        AppModel appModel;
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        Map<String, AppModel> presetAppInfos = rVResourcePresetProxy.getPresetAppInfos();
        if (presetAppInfos == null || (appModel = presetAppInfos.get(str)) == null || (presetPackage = rVResourcePresetProxy.getPresetPackage()) == null || presetPackage.get(str) == null || !TextUtils.equals(presetPackage.get(str).getVersion(), appModel.getAppVersion())) {
            return null;
        }
        return appModel.getAppVersion();
    }

    public static boolean needSkipPermissionCheck(Node node) {
        AppModel appModel;
        JSONObject extendInfos;
        JSONObject jSONObject;
        App app = (App) node.bubbleFindNode(App.class);
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (extendInfos = appModel.getExtendInfos()) == null || (jSONObject = JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_LAUNCH_PARAMS, null)) == null) {
            return false;
        }
        String string = JSONUtils.getString(jSONObject, "checkPermission", "YES");
        if (PermissionUtil.forceInnerPermissionCheck(JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_PARAM_MAP, null))) {
            RVLogger.d("RVResourceUtils", "force check permission paramMap");
            return false;
        }
        return "NO".equalsIgnoreCase(string);
    }

    public static File getExtDirectory(AppModel appModel, boolean z) {
        String installPath = ((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel);
        StringBuilder sb = new StringBuilder();
        sb.append("ariver_ext_");
        sb.append(appModel.getAppVersion());
        String combinePath = FileUtils.combinePath(installPath, sb.toString());
        if (TextUtils.isEmpty(combinePath)) {
            return null;
        }
        File file = new File(combinePath);
        if (!z || file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static int compareVersion(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str2 != null && str2.length() != 0) {
                        if (!str.contains("*") && !str2.contains("*")) {
                            String[] split = str.split("\\.");
                            String[] split2 = str2.split("\\.");
                            int length = split.length;
                            int length2 = split2.length;
                            int min = Math.min(length, length2);
                            for (int i = 0; i < min; i++) {
                                long parseLong = TypeUtils.parseLong(split[i]);
                                long parseLong2 = TypeUtils.parseLong(split2[i]);
                                if (parseLong > parseLong2) {
                                    return 1;
                                }
                                if (parseLong < parseLong2) {
                                    return -1;
                                }
                            }
                            if (length > length2) {
                                while (min < length) {
                                    if (TypeUtils.parseLong(split[min]) > 0) {
                                        return 1;
                                    }
                                    min++;
                                }
                            } else if (length < length2) {
                                while (min < length2) {
                                    if (TypeUtils.parseLong(split2[min]) > 0) {
                                        return -1;
                                    }
                                    min++;
                                }
                            }
                        }
                        return 0;
                    }
                    return 1;
                }
            } catch (Exception e) {
                RVLogger.e(RVConstants.RESOURCE_TAG, "compareVersion exception!", e);
            }
        }
        return (str2 == null || str2.length() == 0) ? 0 : -1;
    }

    public static String getPkgSize(PrepareContext prepareContext) {
        AppModel appModel = prepareContext.getAppModel();
        String packageSize = (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getPackageSize();
        return (StringUtils.isEmpty(packageSize) || "null".equals(packageSize)) ? "0" : packageSize;
    }

    public static String getNewPkgSize(PrepareContext prepareContext) {
        AppModel appModel = prepareContext.getAppModel();
        String newPackageSize = (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getNewPackageSize();
        return (StringUtils.isEmpty(newPackageSize) || "null".equals(newPackageSize)) ? "0" : newPackageSize;
    }

    public static boolean parseDynamicPlugin() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_checkDynamicPlugin", "yes"));
    }
}
