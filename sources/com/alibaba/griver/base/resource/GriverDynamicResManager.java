package com.alibaba.griver.base.resource;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.AbstractPriorityRunnable;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverDynamicResManager {

    /* renamed from: a  reason: collision with root package name */
    private static GriverDynamicResManager f6343a;
    private long b;
    private String c;
    private Map<String, AppModel> d;

    public static GriverDynamicResManager getInstance() {
        if (f6343a == null) {
            synchronized (GriverDynamicResManager.class) {
                if (f6343a == null) {
                    f6343a = new GriverDynamicResManager();
                }
            }
        }
        return f6343a;
    }

    private GriverDynamicResManager() {
    }

    public void start(String str) {
        synchronized (this) {
            if (getInstance().isUseDynamicResource()) {
                this.c = str;
                this.b = SystemClock.elapsedRealtime();
                GriverExecutors.getSingleOrderThreadExecutorByName("saveConfiguration").execute(new AbstractPriorityRunnable(10) { // from class: com.alibaba.griver.base.resource.GriverDynamicResManager.1
                    @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
                    public void runTask() {
                        GriverLogger.d("GriverDynamicResManager", "start to install appx.json configuration");
                        GriverResourceManager.saveConfiguration(GriverDynamicResManager.getInstance().a(), false, true);
                    }
                });
            }
        }
    }

    public void notifyFinish() {
        long j;
        synchronized (this) {
            if (getInstance().isUseDynamicResource()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = this.b;
                if (j2 > 0) {
                    j = elapsedRealtime - j2;
                    if (j > 0) {
                        GriverMonitor.error(GriverMonitorConstants.EVENT_LOAD_REMOTE_RUNTIME_RESOURCES, "GriverAppContainer", new MonitorMap.Builder().append("success", String.valueOf(isAllAppxJsonResInstalled())).appId(this.c).cost(String.valueOf(j)).build());
                        this.b = 0L;
                    }
                }
                j = 0;
                GriverMonitor.error(GriverMonitorConstants.EVENT_LOAD_REMOTE_RUNTIME_RESOURCES, "GriverAppContainer", new MonitorMap.Builder().append("success", String.valueOf(isAllAppxJsonResInstalled())).appId(this.c).cost(String.valueOf(j)).build());
                this.b = 0L;
            }
        }
    }

    public boolean isAllAppxJsonResInstalled() {
        boolean z;
        try {
            Iterator<AppModel> it = a().values().iterator();
            while (true) {
                while (it.hasNext()) {
                    z = z && AppInfoUtils.isInstalled(it.next());
                }
                return z;
            }
        } catch (Throwable th) {
            GriverLogger.w("GriverDynamicResManager", "isAllAppxJsonResInstalled failed", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, AppModel> a() {
        if (!CollectionUtils.isEmpty(this.d)) {
            return this.d;
        }
        try {
            this.d = GriverResourceManager.parseAppInfoFromJSONString(JSON.parseObject(IOUtils.readAsset(GriverEnv.getResources(), "Griver/appx.json")).getString("mini"));
        } catch (Throwable th) {
            GriverLogger.e("GriverDynamicResManager", "parse JSONObject failed", th);
        }
        return this.d;
    }

    public boolean isUseDynamicResource() {
        return !ReflectUtils.classExist("com.alibaba.griver.resource.BuildConfig") || GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_REMOTE_RESOURCE_ENABLED, false);
    }

    public boolean shouldDynamicDownload(AppModel appModel) {
        try {
            if (!isUseDynamicResource()) {
                c(appModel);
                return false;
            }
            Map<String, AppModel> a2 = a();
            if (a2 == null || !a2.containsKey(appModel.getAppId()) || a(appModel)) {
                return false;
            }
            b(appModel);
            return true;
        } catch (Throwable th) {
            GriverLogger.e("GriverDynamicResManager", "shouldDynamicDownload process failed", th);
            return false;
        }
    }

    private boolean a(AppModel appModel) {
        JSONObject extendInfos;
        AppModel queryAppInfo = GriverAppCenter.queryAppInfo(appModel.getAppId(), appModel.getAppVersion());
        if (queryAppInfo == null || (extendInfos = queryAppInfo.getExtendInfos()) == null) {
            return false;
        }
        return extendInfos.getBooleanValue("isFromDynamicDownload");
    }

    private void b(AppModel appModel) {
        JSONObject extendInfos = appModel.getExtendInfos();
        if (extendInfos == null) {
            extendInfos = new JSONObject();
        }
        extendInfos.put("isFromDynamicDownload", (Object) Boolean.TRUE);
    }

    private void c(AppModel appModel) {
        JSONObject extendInfos;
        if (a(appModel)) {
            RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
            if (rVResourceManager != null) {
                rVResourceManager.deleteDownloadPackage(appModel);
                rVResourceManager.deleteInstallStatus(appModel.getAppId());
            }
            AppModel queryAppInfo = GriverAppCenter.queryAppInfo(appModel.getAppId(), appModel.getAppVersion());
            if (queryAppInfo == null || (extendInfos = queryAppInfo.getExtendInfos()) == null || !extendInfos.containsKey("isFromDynamicDownload")) {
                return;
            }
            extendInfos.remove("isFromDynamicDownload");
            GriverAppCenter.updateAppInfo(queryAppInfo);
        }
    }

    public void saveDynamicDownloadStatus(AppModel appModel) {
        JSONObject extendInfos = appModel.getExtendInfos();
        if (extendInfos == null || !extendInfos.containsKey("isFromDynamicDownload")) {
            return;
        }
        GriverAppCenter.updateAppInfo(appModel);
    }
}
