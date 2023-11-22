package com.alibaba.griver.base.resource.extensions;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.resource.extensions.GriverCommonResourceProxy;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.resource.utils.H5CommonResourceUtils;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class GriverPackageQueryExtension implements PackageQueryPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public ResourcePackage getMainPackage(ResourceContext resourceContext) {
        App app = resourceContext.getApp();
        if (app != null && PWAUtils.isPwaApp(app)) {
            GriverLogger.d("GriverPackageQueryExtension", "pwa with not verify");
            return new MainResourcePackageWithoutVerify(resourceContext);
        } else if ("yes".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_SHOULD_VERIFY_APP, "YES"))) {
            if (a(resourceContext)) {
                return new MainResourcePackageWithoutVerify(resourceContext);
            }
            return new GriverMainResourcePackage(resourceContext);
        } else {
            return new MainResourcePackageWithoutVerify(resourceContext);
        }
    }

    private boolean a(ResourceContext resourceContext) {
        AppModel mainPackageInfo;
        JSONObject extendInfos;
        JSONObject jSONObject;
        if (resourceContext == null || (mainPackageInfo = resourceContext.getMainPackageInfo()) == null || (extendInfos = mainPackageInfo.getExtendInfos()) == null || (jSONObject = extendInfos.getJSONObject("extData")) == null) {
            return false;
        }
        return "yes".equalsIgnoreCase(jSONObject.getString("skipVerifyApp"));
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext) {
        List<String> filterCommonResources;
        HashSet hashSet = new HashSet();
        if (!BundleUtils.getBoolean(resourceContext.getStartParams(), RVParams.isH5App, false)) {
            App app = resourceContext.getApp();
            GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
            if (GriverAppxNgRuntimeChecker.isUseAppxNg(app.getStartParams())) {
                if (GlobalPackagePool.getInstance().contains("68687209") && !RemoteDebugCompatUtils.isInDebugMode(app)) {
                    GriverLogger.d(PreloadScheduler.TAG, "GriverPackageQueryExtension#getResourcePackages, use preload appx ng package.");
                    if (stageMonitor != null) {
                        stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_APPX_STATUS, 1);
                    }
                } else {
                    GriverLogger.d(PreloadScheduler.TAG, "GriverPackageQueryExtension#getResourcePackages,  use default appx package.");
                    if (stageMonitor != null) {
                        stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_APPX_STATUS, 0);
                    }
                    hashSet.add(new AppXNgResourcePackageWithoutVerify(resourceContext));
                }
            } else if (GlobalPackagePool.getInstance().contains("66666692") && !RemoteDebugCompatUtils.isInDebugMode(app)) {
                GriverLogger.d(PreloadScheduler.TAG, "GriverPackageQueryExtension#getResourcePackages, use preload appx package.");
                if (stageMonitor != null) {
                    stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_APPX_STATUS, 1);
                }
            } else {
                GriverLogger.d(PreloadScheduler.TAG, "GriverPackageQueryExtension#getResourcePackages,  use default appx package.");
                if (stageMonitor != null) {
                    stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_APPX_STATUS, 0);
                }
                hashSet.add(new AppXResourcePackageWithoutVerify(resourceContext));
            }
        } else {
            GriverCommonResourceProxy griverCommonResourceProxy = (GriverCommonResourceProxy) RVProxy.get(GriverCommonResourceProxy.class);
            if (griverCommonResourceProxy != null && (filterCommonResources = H5CommonResourceUtils.filterCommonResources(griverCommonResourceProxy.getCommonResources())) != null && filterCommonResources.size() > 0) {
                for (String str : filterCommonResources) {
                    if (!TextUtils.equals(str, "66666692")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("shared package for h5: ");
                        sb.append(str);
                        GriverLogger.d("GriverPackageQueryExtension", sb.toString());
                        if ("yes".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_SHOULD_VERIFY_APP, "YES"))) {
                            hashSet.add(new GriverNormalResourcePackage(str, resourceContext));
                        } else {
                            hashSet.add(new NormalResourcePackageWithoutVerify(str, resourceContext));
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
    public ResourcePackage createPluginPackage(AppModel appModel, PluginModel pluginModel, ResourceContext resourceContext) {
        return new GriverPluginResourcePackage(appModel, pluginModel, resourceContext);
    }
}
