package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.AppUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.api.storage.TabBarDataStorage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class ResourceLoadExtension implements AppCreatePoint, AppDestroyPoint, AppLoadPoint, AppStartPoint, EngineInitSuccessPoint, TabBarInfoQueryPoint, ResourceLoadPoint, NodeAware<Node> {
    public static final String APPX_WORKER_JS_URL = "https://appx/af-appx.worker.min.js";
    private static final String TAG = "AriverRes:ResourceLoadExtension";
    private ResourceInterceptPoint mInterceptPoint;
    private App mApp = null;
    private List<ResourcePackage> mLockingPackages = new CopyOnWriteArrayList();
    private ConditionVariable mContentProviderSyncLock = new ConditionVariable();
    private Page mPage = null;
    private Page mOuterPage = null;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        ResourceContext onAppLoad = ResourceContextManager.getInstance().onAppLoad(app.getAppId(), app.getStartToken());
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
        if (this.mInterceptPoint == null) {
            this.mInterceptPoint = (ResourceInterceptPoint) ExtensionPoint.as(ResourceInterceptPoint.class).node(onAppLoad.getApp()).create();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppCreatePoint
    public void onAppCreate(App app) {
        if (this.mInterceptPoint == null) {
            this.mInterceptPoint = (ResourceInterceptPoint) ExtensionPoint.as(ResourceInterceptPoint.class).node(app).create();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x04ae, code lost:
    
        if (r4 != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x04ca, code lost:
    
        if (com.alibaba.ariver.resource.content.ResourceUtils.enableTabBarByAppId(r19.mApp.getAppId()) == false) goto L127;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05fc  */
    /* JADX WARN: Type inference failed for: r18v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.alibaba.fastjson.JSONObject, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.alibaba.fastjson.JSONObject, java.lang.Object] */
    @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadApp(java.lang.String r20, android.os.Bundle r21, android.os.Bundle r22, com.alibaba.ariver.app.api.point.app.AppLoadPoint.LoadResultCallback r23) {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.loadApp(java.lang.String, android.os.Bundle, android.os.Bundle, com.alibaba.ariver.app.api.point.app.AppLoadPoint$LoadResultCallback):void");
    }

    private void getTabBarFromFile(ResourcePackage resourcePackage, ResourceContext resourceContext) {
        Resource resource = resourcePackage.get(ResourceQuery.asUrl(RVConstants.FILE_TABBAR).setNeedAutoCompleteHost().setLanguageAware(true));
        if (resource == null && !this.mApp.isTinyApp() && "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableH5TabBarFallback", "yes"))) {
            ResourceQuery resourceQuery = new ResourceQuery(FileUtils.combinePath(resourceContext.getMainPackageInfo().getAppInfoModel().getVhost(), RVConstants.FILE_TABBAR));
            resourceQuery.setCanUseFallback(true);
            resourceQuery.setNeedAutoCompleteHost();
            resourceQuery.setMainDoc(false);
            resourceQuery.setForceNet(true);
            resource = resourceContext.getContentProvider().getContent(resourceQuery);
        }
        if (resource != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("put tabBar.json for ");
            sb.append(this.mApp.getAppId());
            RVLogger.d(TAG, sb.toString());
            JSONObject parseObject = JSONUtils.parseObject(resource.getBytes());
            if (parseObject != null && !parseObject.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("put tabBar.json");
                sb2.append(parseObject);
                RVLogger.d(TAG, sb2.toString());
                this.mApp.putJsonValue(RVConstants.JSON_TABBAR, parseObject);
            }
            resourceContext.tabBarDataStorage.onGetData(TabBarModel.inflateFromResource(resource, (ColorSchemeDecider) this.mApp.getData(ColorSchemeDecider.class)));
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("cannot find tabBar.json for ");
        sb3.append(this.mApp.getAppId());
        RVLogger.w(TAG, sb3.toString());
    }

    private void removeInvalidParams(AppConfigModel appConfigModel) {
        if (appConfigModel != null) {
            if (appConfigModel.getAppLaunchParams() != null && appConfigModel.getAppLaunchParams().containsKey("usePresetPopmenu")) {
                appConfigModel.getAppLaunchParams().remove("usePresetPopmenu");
            }
            if (appConfigModel.getPageLaunchParams() == null || !appConfigModel.getPageLaunchParams().containsKey("usePresetPopmenu")) {
                return;
            }
            appConfigModel.getPageLaunchParams().remove("usePresetPopmenu");
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
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.2
            @Override // java.lang.Runnable
            public void run() {
                for (final String str : hashSet) {
                    if (!"66666692".equalsIgnoreCase(str) && !"68687209".equalsIgnoreCase(str)) {
                        ResourcePackagePool.getInstance().attach(str, resourceContext);
                        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ResourceUtils.prepare(str, "*", null, UpdateMode.ASYNC);
                            }
                        };
                        if (AppUtils.enableUpdatePkgRes()) {
                            ExecutorUtils.getScheduledExecutor().schedule(runnable, 5L, TimeUnit.SECONDS);
                        }
                    }
                }
            }
        });
    }

    private byte[] getSnapshotIndex(App app, AppModel appModel, String str, String str2, boolean z) {
        byte[] loadSnapshotFile;
        if (str.endsWith("index.html")) {
            try {
                if (RVSnapshotUtils.isSnapshotEnabled(this.mApp) && (loadSnapshotFile = RVSnapshotUtils.loadSnapshotFile(this.mApp, appModel, str2, z)) != null) {
                    ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class, true);
                    if (iSnapshotProxy != null) {
                        iSnapshotProxy.snapshotHit(this.mApp);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("snapshot first page using local snapshotFile success! ");
                    sb.append(app);
                    RVLogger.d(TAG, sb.toString());
                    return loadSnapshotFile;
                }
            } catch (Throwable th) {
                RVLogger.e(TAG, "getSnapshotIndex error!", th);
            }
            return null;
        }
        return null;
    }

    private String getSnapshotTitleBar(App app, AppModel appModel, String str, String str2) {
        if (str.endsWith("index.html")) {
            try {
                String loadTitleBarSnapshot = RVSnapshotUtils.loadTitleBarSnapshot(app, appModel, str2);
                if (!TextUtils.isEmpty(loadTitleBarSnapshot)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SnapshotProvider read titleBar snapshotFile success! ");
                    sb.append(app);
                    RVLogger.d(TAG, sb.toString());
                    return loadTitleBarSnapshot;
                }
            } catch (Throwable th) {
                RVLogger.e(TAG, "getSnapshotTitle error!", th);
            }
            return null;
        }
        return null;
    }

    private String acquireMainJsUrl(Bundle bundle) {
        return FileUtils.combinePath(BundleUtils.getString(bundle, "onlineHost"), BundleUtils.contains(bundle, RVStartParams.KEY_BUNDLE_PATH) ? BundleUtils.getString(bundle, RVStartParams.KEY_BUNDLE_PATH) : "index.bundle.js");
    }

    @Override // com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint
    public void onInitSuccess() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<ResourcePackage> it = this.mLockingPackages.iterator();
        while (it.hasNext()) {
            it.next().waitForSetup();
        }
        this.mLockingPackages.clear();
        StringBuilder sb = new StringBuilder();
        sb.append("waitForSetup cost ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        RVLogger.d(TAG, sb.toString());
    }

    private void fillConfigWithIncludeFile(ResourceContext resourceContext, AppConfigModel appConfigModel) {
        Resource resource;
        ResourcePackage mainPackage = resourceContext.getMainPackage();
        if (mainPackage == null) {
            return;
        }
        String configVariable = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getConfigVariable();
        StringBuilder sb = new StringBuilder();
        sb.append("fillConfigWithIncludeFile, configVar: ");
        sb.append(configVariable);
        sb.append(" includeFiles: ");
        sb.append(appConfigModel.getIncludeFiles());
        RVLogger.d(TAG, sb.toString());
        if (appConfigModel.getIncludeFiles() == null || TextUtils.isEmpty(configVariable)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("config/");
        sb2.append(configVariable);
        sb2.append(".json");
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("try fillConfigWithIncludeFile with resource: ");
        sb3.append(obj);
        RVLogger.d(TAG, sb3.toString());
        if (appConfigModel.getIncludeFiles().contains(obj) && (resource = mainPackage.get(ResourceQuery.asUrl(obj).setNeedAutoCompleteHost())) != null) {
            RVLogger.d(TAG, "try fillConfigWithIncludeFile hit");
            JSONObject parseObject = JSONUtils.parseObject(resource.getBytes());
            JSONObject jSONObject = JSONUtils.getJSONObject(parseObject, "window", null);
            if (jSONObject != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit window");
                appConfigModel.setAppLaunchParams(jSONObject);
            }
            JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, SecurityConstants.KEY_PAGES, null);
            if (jSONArray != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit pages");
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                appConfigModel.setPages(arrayList);
            }
            JSONObject jSONObject2 = JSONUtils.getJSONObject(parseObject, "extPages", null);
            if (jSONObject2 != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit launchParams");
                if (appConfigModel.getPageLaunchParams() == null) {
                    appConfigModel.setPageLaunchParams(jSONObject2);
                } else {
                    appConfigModel.getPageLaunchParams().putAll(jSONObject2);
                }
                appConfigModel.setPageLaunchParams(jSONObject2);
            }
            String string = JSONUtils.getString(parseObject, "tabBar", null);
            Resource resource2 = resourceContext.getMainPackage().get(ResourceQuery.asUrl(RVConstants.FILE_TABBAR).setNeedAutoCompleteHost());
            if (resource2 != null) {
                if (string != null) {
                    RVLogger.d(TAG, "try fillConfigWithIncludeFile hit tabBar");
                    resource2.setBytes(string.getBytes());
                    return;
                }
                resourceContext.getMainPackage().remove(resource2.getUrl());
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
                appConfigModel.setAppLaunchParams(extModel.getWindow());
            } else {
                appConfigModel.getAppLaunchParams().putAll(extModel.getWindow());
            }
            if (appConfigModel.getPageLaunchParams() != null) {
                for (String str : appConfigModel.getPageLaunchParams().keySet()) {
                    JSONObject jSONObject = appConfigModel.getPageLaunchParams().getJSONObject(str);
                    if (jSONObject != null) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("window");
                        StringBuilder sb = new StringBuilder();
                        sb.append("fillConfigWithTemplate page ");
                        sb.append(str);
                        sb.append(" put ext.window ");
                        sb.append(extModel.getWindow());
                        RVLogger.d(TAG, sb.toString());
                        jSONObject.putAll(extModel.getWindow());
                        if (jSONObject2 != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("fillConfigWithTemplate page ");
                            sb2.append(str);
                            sb2.append(" put page.window ");
                            sb2.append(jSONObject2);
                            RVLogger.d(TAG, sb2.toString());
                            jSONObject.putAll(jSONObject2);
                        }
                    }
                }
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
        Resource resource;
        Resource intercept;
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.mApp.getAppId(), this.mApp.getStartToken());
        ResourceQuery canUseFallback = ResourceQuery.asUrl(resourceLoadContext.originUrl).setCanUseFallback(resourceLoadContext.canUseFallback);
        boolean equalsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(this.mApp.getStartParams(), "appxRouteFramework"));
        boolean z = false;
        canUseFallback.setAppxNgRoute(equalsIgnoreCase || resourceLoadContext.isPreRenderMainDoc);
        canUseFallback.setMainDoc(resourceLoadContext.isMainDoc);
        canUseFallback.setPreRenderMainDoc(resourceLoadContext.isPreRenderMainDoc);
        if (this.mPage != null) {
            if (this.mOuterPage != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("load resource url: ");
                sb.append(resourceLoadContext.originUrl);
                sb.append(" in outer pageurl :");
                sb.append(this.mOuterPage.getOriginalURI());
                RVLogger.d(TAG, sb.toString());
                canUseFallback.setPageUrl(this.mOuterPage.getOriginalURI());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load resource url: ");
                sb2.append(resourceLoadContext.originUrl);
                sb2.append(" in pageurl :");
                sb2.append(this.mPage.getOriginalURI());
                RVLogger.d(TAG, sb2.toString());
                canUseFallback.setPageUrl(this.mPage.getOriginalURI());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("load resource begin: ");
        sb3.append(resourceLoadContext.originUrl);
        sb3.append(" appx-ng: ");
        sb3.append(equalsIgnoreCase);
        sb3.append(" contentProvider：");
        sb3.append(resourceContext.getContentProvider() == null);
        RVLogger.d(TAG, sb3.toString());
        boolean z2 = equalsIgnoreCase && resourceLoadContext.originUrl.startsWith(ContentProviderImpl.TINY_RES_HOST);
        if (resourceContext.getContentProvider() != null) {
            resource = resourceContext.getContentProvider().getContent(canUseFallback);
        } else {
            if (canUseFallback.isPreRenderMainDoc()) {
                App app = this.mApp;
                OfflineResource offlineResource = null;
                if (app != null && RVSnapshotUtils.isPreRenderSnapshotOpen(app.getAppId())) {
                    AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
                    if (appModel == null) {
                        appModel = (AppModel) BundleUtils.getParcelable(this.mApp.getSceneParams(), "appInfo");
                    }
                    if (appModel != null) {
                        byte[] loadSnapshotFile = RVSnapshotUtils.loadSnapshotFile(this.mApp, appModel, resourceLoadContext.originUrl, true);
                        if (loadSnapshotFile != null && loadSnapshotFile.length > 100) {
                            z = true;
                        }
                        if (z) {
                            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_Use_Snapshot);
                            offlineResource = new OfflineResource(resourceLoadContext.originUrl, loadSnapshotFile);
                            offlineResource.setSourceType(ResourceSourceType.SNAPSHOT);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("appx-ng preRendering  resourceLoadExtension use snapshot!  ");
                            sb4.append(resourceLoadContext.originUrl);
                            RVLogger.d(TAG, sb4.toString());
                        }
                    }
                }
                if (offlineResource == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("appx-ng preRendering  resourceLoadExtension use from globalpackage! ");
                    sb5.append(resourceLoadContext.originUrl);
                    RVLogger.d(TAG, sb5.toString());
                    canUseFallback.pureUrl = "https://appx-ng/index.prerender.html";
                } else {
                    resource = offlineResource;
                }
            } else if (z2) {
                RVLogger.w(TAG, "appx-ng load resource error content provider null!!! Just find for global package! ");
                if (resourceLoadContext.originUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                    this.mApp.putBooleanValue("appxRouteWorker", canUseFallback.isAppxNgRoute());
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mApp, "appxRoute", "yes");
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_JS_WorkerFrameworkStart);
                }
                canUseFallback.pureUrl = canUseFallback.pureUrl.replace(ContentProviderImpl.TINY_RES_HOST, ContentProviderImpl.APPX_NG_TINY_RES_HOST);
            } else {
                RVLogger.w(TAG, "load resource error content provider null!!! Just find for global package! ");
                if (resourceLoadContext.originUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mApp, "appxRoute", "no");
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_JS_WorkerFrameworkStart);
                }
            }
            resource = GlobalPackagePool.getInstance().get(canUseFallback);
        }
        if (resource == null || (intercept = this.mInterceptPoint.intercept(resource)) == null) {
            return resource;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("load response ");
        sb6.append(canUseFallback.pureUrl);
        sb6.append(" intercepted to ");
        sb6.append(intercept);
        RVLogger.w(TAG, sb6.toString());
        return intercept;
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
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Node> weakReference) {
        App app;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (weakReference.get() instanceof App) {
            RVLogger.d(TAG, "resource load extension set node app");
            this.mApp = (App) weakReference.get();
        }
        if (weakReference.get() instanceof Page) {
            RVLogger.d(TAG, "resource load extension set node page");
            Page page = (Page) weakReference.get();
            this.mPage = page;
            long j = page.getStartParams().getLong("shell_id", Long.MIN_VALUE);
            if (j == Long.MIN_VALUE || (app = this.mApp) == null) {
                return;
            }
            this.mOuterPage = app.getPageByNodeId(j);
            StringBuilder sb = new StringBuilder();
            sb.append("resource load extension set embed parent page : ");
            sb.append(this.mOuterPage);
            RVLogger.d(TAG, sb.toString());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Node> getNodeType() {
        return Node.class;
    }

    @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint
    public void queryTabBarInfo(final TabBarInfoQueryPoint.OnTabBarInfoQueryListener onTabBarInfoQueryListener) {
        ResourceContextManager.getInstance().get(this.mApp.getAppId(), this.mApp.getStartToken()).tabBarDataStorage.retrieveData(new TabBarDataStorage.Listener() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.3
            @Override // com.alibaba.ariver.resource.api.storage.TabBarDataStorage.Listener
            public void onGetData(TabBarModel tabBarModel) {
                onTabBarInfoQueryListener.onTabInfoGot(tabBarModel);
            }
        });
    }
}
