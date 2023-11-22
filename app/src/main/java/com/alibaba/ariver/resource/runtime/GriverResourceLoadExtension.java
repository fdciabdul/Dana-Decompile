package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.storage.TabBarDataStorage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.preload.point.OnPreloadPoint;
import com.alibaba.griver.base.resource.extensions.GriverAppXResourcePackage;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import com.alibaba.griver.core.preload.PreloadInitializer;
import com.alibaba.griver.core.preload.impl.render.RenderPreloadNgResources;
import com.alibaba.griver.core.preload.impl.render.RenderPreloadResources;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class GriverResourceLoadExtension implements AppDestroyPoint, AppLoadPoint, AppOnLoadResultPoint, AppStartPoint, EngineInitSuccessPoint, TabBarInfoQueryPoint, ResourceLoadPoint, NodeAware<App> {
    private static final String FILE_APP_CONFIG = "appConfig.json";
    private static final String FILE_TABBAR = "tabBar.json";
    private static final String TAG = "AriverRes:GriverResourceLoadExtension";
    private App mApp = null;
    private List<ResourcePackage> mLockingPackages = new CopyOnWriteArrayList();
    private ConditionVariable mContentProviderSyncLock = new ConditionVariable();

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        ResourceContext onAppLoad = ResourceContextManager.getInstance().onAppLoad(app.getAppId(), this.mApp.getStartToken());
        StringBuilder sb = new StringBuilder();
        sb.append("onAppStart: ");
        sb.append(app.getAppId());
        sb.append(" on resourceContext: ");
        sb.append(onAppLoad);
        RVLogger.d(TAG, sb.toString());
        onAppLoad.setApp(app);
        onAppLoad.setAppId(app.getAppId());
        onAppLoad.setStartParams(app.getStartParams());
        onAppLoad.setSceneParams(app.getSceneParams());
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0418  */
    @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadApp(java.lang.String r18, android.os.Bundle r19, android.os.Bundle r20, com.alibaba.ariver.app.api.point.app.AppLoadPoint.LoadResultCallback r21) {
        /*
            Method dump skipped, instructions count: 1137
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.runtime.GriverResourceLoadExtension.loadApp(java.lang.String, android.os.Bundle, android.os.Bundle, com.alibaba.ariver.app.api.point.app.AppLoadPoint$LoadResultCallback):void");
    }

    private void preloadRenderResource(App app, String str, Bundle bundle) {
        RenderPreloadResources renderPreloadResources;
        RenderPreloadNgResources renderPreloadNgResources;
        if (GriverAppxNgRuntimeChecker.isUseAppxNg(bundle)) {
            if (!app.isTinyApp() || PWAUtils.isPwaAppAndLoadNewWay(app) || !PreloadInitializer.canPrerender(app) || (renderPreloadNgResources = (RenderPreloadNgResources) PreloadScheduler.getInstance().getReadyResource(RenderPreloadNgResources.class)) == null) {
                return;
            }
            renderPreloadNgResources.getIndexJs(app);
        } else if (!app.isTinyApp() || PWAUtils.isPwaAppAndLoadNewWay(app) || !PreloadInitializer.canPrerender(app) || (renderPreloadResources = (RenderPreloadResources) PreloadScheduler.getInstance().getReadyResource(RenderPreloadResources.class)) == null) {
        } else {
            renderPreloadResources.getIndexJs(app);
        }
    }

    private void addLauncherParamResourcePackage(final ResourceContext resourceContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("addLauncherParamResourcePackage for ");
        sb.append(resourceContext.getAppId());
        RVLogger.d(TAG, sb.toString());
        final HashSet hashSet = new HashSet();
        JSONArray parseArray = JSONUtils.parseArray(BundleUtils.getString(resourceContext.getStartParams(), RVStartParams.KEY_ACCPKG_RES));
        if (parseArray != null && parseArray.size() > 0) {
            int size = parseArray.size();
            for (int i = 0; i < size; i++) {
                String string = parseArray.getString(i);
                if (!string.equals(resourceContext.getAppId())) {
                    hashSet.add(string);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.runtime.GriverResourceLoadExtension.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ResourcePackagePool.getInstance().attach((String) it.next(), resourceContext);
                }
            }
        });
    }

    private String acquireMainJsUrl(Bundle bundle) {
        return FileUtils.combinePath(BundleUtils.getString(bundle, "onlineHost"), BundleUtils.getString(bundle, RVStartParams.KEY_BUNDLE_PATH));
    }

    @Override // com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint
    public void onInitSuccess() {
        Iterator<ResourcePackage> it = this.mLockingPackages.iterator();
        while (it.hasNext()) {
            it.next().waitForSetup();
        }
        this.mLockingPackages.clear();
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.mApp.getAppId(), this.mApp.getStartToken());
        if (resourceContext.getMainPackage() != null) {
            String appLanguage = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppLanguage();
            ResourcePackage mainPackage = resourceContext.getMainPackage();
            StringBuilder sb = new StringBuilder();
            sb.append(appLanguage);
            sb.append("/");
            sb.append("tabBar.json");
            Resource resource = mainPackage.get(ResourceQuery.asUrl(sb.toString()).setNeedAutoCompleteHost());
            if (resource == null) {
                resource = resourceContext.getMainPackage().get(ResourceQuery.asUrl("tabBar.json").setNeedAutoCompleteHost());
            }
            if (resource != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("put tabBar.json for ");
                sb2.append(this.mApp.getAppId());
                RVLogger.d(TAG, sb2.toString());
                resourceContext.tabBarDataStorage.onGetData((TabBarModel) JSONUtils.parseObject(resource.getBytes(), TabBarModel.class));
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("cannot find tabBar.json for ");
            sb3.append(this.mApp.getAppId());
            RVLogger.w(TAG, sb3.toString());
        }
    }

    private void fillConfigWithIncludeFile(ResourceContext resourceContext, AppConfigModel appConfigModel) {
        Resource resource;
        ResourcePackage mainPackage = resourceContext.getMainPackage();
        if (mainPackage == null) {
            return;
        }
        String configVariable = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getConfigVariable();
        if (appConfigModel.getIncludeFiles() == null || TextUtils.isEmpty(configVariable)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("config/");
        sb.append(configVariable);
        sb.append(".json");
        String obj = sb.toString();
        if (appConfigModel.getIncludeFiles().contains(obj) && (resource = mainPackage.get(ResourceQuery.asUrl(obj).setNeedAutoCompleteHost())) != null) {
            JSONObject parseObject = JSONUtils.parseObject(resource.getBytes());
            JSONObject jSONObject = JSONUtils.getJSONObject(parseObject, "window", null);
            if (jSONObject != null) {
                appConfigModel.setAppLaunchParams(jSONObject);
            }
            JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, SecurityConstants.KEY_PAGES, null);
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                appConfigModel.setPages(arrayList);
            }
            JSONObject jSONObject2 = JSONUtils.getJSONObject(parseObject, "extPages", null);
            if (jSONObject2 != null) {
                if (appConfigModel.getPageLaunchParams() == null) {
                    appConfigModel.setPageLaunchParams(jSONObject2);
                } else {
                    appConfigModel.getPageLaunchParams().putAll(jSONObject2);
                }
                appConfigModel.setPageLaunchParams(jSONObject2);
            }
            String string = JSONUtils.getString(parseObject, "tabBar", null);
            Resource resource2 = resourceContext.getMainPackage().get(ResourceQuery.asUrl("tabBar.json").setNeedAutoCompleteHost());
            if (resource2 != null) {
                if (string != null) {
                    resource2.setBytes(string.getBytes());
                } else {
                    resourceContext.getMainPackage().remove(resource2.getUrl());
                }
            }
        }
    }

    private void fillConfigWithTemplate(AppConfigModel appConfigModel) {
        AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) {
            return;
        }
        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
        if (!templateConfig.isTemplateValid() || templateConfig.getExtModel() == null) {
            return;
        }
        TemplateExtModel extModel = templateConfig.getExtModel();
        if (extModel.getWindow() != null) {
            if (appConfigModel.getAppLaunchParams() == null) {
                appConfigModel.setAppLaunchParams(templateConfig.getExtModel().getWindow());
            } else {
                appConfigModel.getAppLaunchParams().putAll(templateConfig.getExtModel().getWindow());
            }
        }
        if (extModel.getExtPages() != null) {
            if (appConfigModel.getPageLaunchParams() == null) {
                appConfigModel.setPageLaunchParams(extModel.getExtPages());
            } else {
                appConfigModel.getPageLaunchParams().putAll(extModel.getExtPages());
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
    public Resource load(ResourceLoadContext resourceLoadContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("load resource begin: ");
        sb.append(resourceLoadContext.originUrl);
        RVLogger.d(TAG, sb.toString());
        boolean isUseAppxNg = GriverAppxNgRuntimeChecker.isUseAppxNg(this.mApp.getStartParams());
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.mApp.getAppId(), this.mApp.getStartToken());
        ResourceQuery canUseFallback = ResourceQuery.asUrl(resourceLoadContext.originUrl).setCanUseFallback(resourceLoadContext.canUseFallback);
        canUseFallback.setMainDoc(resourceLoadContext.isMainDoc);
        if (isUseAppxNg) {
            canUseFallback.setAppxNgRoute(true);
            ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("68687209");
            App app = resourceContext.getApp();
            if ((resourcePackage instanceof GriverAppXResourcePackage) && !RemoteDebugCompatUtils.isInDebugMode(app) && resourceLoadContext.originUrl != null && resourceLoadContext.originUrl.startsWith("https://appx")) {
                canUseFallback.pureUrl = canUseFallback.pureUrl.replace(ContentProviderImpl.TINY_RES_HOST, ContentProviderImpl.APPX_NG_TINY_RES_HOST);
                return resourcePackage.get(canUseFallback);
            }
        } else {
            ResourcePackage resourcePackage2 = GlobalPackagePool.getInstance().getPackage("66666692");
            App app2 = resourceContext.getApp();
            if ((resourcePackage2 instanceof GriverAppXResourcePackage) && !RemoteDebugCompatUtils.isInDebugMode(app2) && resourceLoadContext.originUrl != null && resourceLoadContext.originUrl.startsWith("https://appx")) {
                return resourcePackage2.get(canUseFallback);
            }
        }
        if (resourceContext.getContentProvider() != null) {
            return resourceContext.getContentProvider().getContent(canUseFallback);
        }
        if (isUseAppxNg) {
            RVLogger.w(TAG, "appx-ng load resource error content provider null!!! Just find for global package! ");
            canUseFallback.pureUrl = canUseFallback.pureUrl.replace(ContentProviderImpl.TINY_RES_HOST, ContentProviderImpl.APPX_NG_TINY_RES_HOST);
            return GlobalPackagePool.getInstance().get(canUseFallback);
        }
        RVLogger.w(TAG, "load resource error content provider null!!! Just find for global package! ");
        return GlobalPackagePool.getInstance().get(canUseFallback);
    }

    @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
    public Resource loadGlobalResource(String str) {
        return GlobalPackagePool.getInstance().get(ResourceQuery.asUrl(str));
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        for (String str : ResourceContextManager.getInstance().get(app.getAppId(), app.getStartToken()).getResourcePackages()) {
            if (!TextUtils.equals("66666692", str)) {
                ResourcePackagePool.getInstance().detach(str);
            }
        }
        ResourceContextManager.getInstance().onAppDestroy(app.getAppId(), app.getStartToken());
        closeAppMonitor(app);
        if (app.isTinyApp()) {
            ((OnPreloadPoint) RVProxy.get(OnPreloadPoint.class)).closeAppPointPreload(app);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.mApp = weakReference.get();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint
    public void queryTabBarInfo(final TabBarInfoQueryPoint.OnTabBarInfoQueryListener onTabBarInfoQueryListener) {
        ResourceContextManager.getInstance().get(this.mApp.getAppId(), this.mApp.getStartToken()).tabBarDataStorage.retrieveData(new TabBarDataStorage.Listener() { // from class: com.alibaba.ariver.resource.runtime.GriverResourceLoadExtension.2
            @Override // com.alibaba.ariver.resource.api.storage.TabBarDataStorage.Listener
            public void onGetData(TabBarModel tabBarModel) {
                onTabBarInfoQueryListener.onTabInfoGot(tabBarModel);
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint
    public void onLoadResult(App app, AppLoadResult appLoadResult) {
        if (RemoteDebugCompatUtils.isInDebugMode(app) || !app.isTinyApp()) {
            return;
        }
        ((OnPreloadPoint) RVProxy.get(OnPreloadPoint.class)).createAppContext(app);
    }

    private void closeAppMonitor(App app) {
        if (app == null) {
            return;
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.appId(app.getAppId()).url(app.getStartUrl()).version(app).needAsynAppType(true);
        GriverMonitor.event(GriverMonitorConstants.EVENT_APP_EXIT, "GriverAppContainer", builder.build());
    }
}
