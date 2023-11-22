package com.alibaba.griver.core.jsapi.worker;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.api.track.EventAttr;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.PluginInfoUtil;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.base.resource.offline.GriverOfflinePkgManager;
import com.alibaba.griver.base.resource.plugin.cache.GriverPluginCacheManager;
import com.alibaba.griver.core.plugin.PluginUtils;
import com.alibaba.griver.core.render.VHostUrlInterceptor;
import com.alibaba.griver.core.worker.QJSUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.iap.ac.android.container.constant.ContainerKeys;
import id.dana.kyb.constant.KybDataSource;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class WorkerBridgeExtension implements BridgeExtension {
    private static final String LOAD_PLUGIN_KEY_URL = "url";
    private static final String LOAD_PLUGIN_VERSION = "version";
    private static final String MONITOR_REGISTER_WORK_SUCCESS = "register_work_success";
    private static final int NOT_FOUND_APP = 10;
    private static final String TAG = "AriverEngine:WorkerBridgeExtension";
    private Map<String, Future<BridgeResponse>> mLoadedPlugins = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void registerWorker(@BindingNode(Page.class) final Page page, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback, @BindingParam({"worker"}) String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("registerWorker");
        sb.append(System.currentTimeMillis());
        GriverLogger.d("PRELOAD", sb.toString());
        RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", "renderFrameworkFinish", Long.valueOf(SystemClock.elapsedRealtime())));
        final String mergeVHost = VHostUrlInterceptor.mergeVHost(str.substring(0, str.indexOf("?")), ((AppModel) page.getApp().getData(AppModel.class)).getAppInfoModel().getVhost());
        final RVEngine engineProxy = page.getApp().getEngineProxy();
        EngineRouter engineRouter = engineProxy.getEngineRouter();
        ((WorkerStore) page.getData(WorkerStore.class, true)).workerId = mergeVHost;
        ((WorkerStore) page.getApp().getData(WorkerStore.class, true)).workerId = mergeVHost;
        if (engineRouter.getWorkerById(mergeVHost) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "installed");
            bridgeCallback.sendJSONResponse(jSONObject);
            try {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("register_work_success", "Render registerWork success", KybDataSource.RENDER, page.getApp() != null ? page.getApp().getAppId() : "", page.getPageURI(), null);
            } catch (Throwable th) {
                RVLogger.e(TAG, "flowLog exception:", th);
            }
        } else if (TextUtils.isEmpty(mergeVHost)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("REGISTER_WORKER worker: ");
            sb2.append(mergeVHost);
            RVLogger.d(TAG, sb2.toString());
            final Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            final String userAgent = page.getRender().getUserAgent();
            ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.1
                @Override // java.lang.Runnable
                public void run() {
                    WorkerBridgeExtension.this.createWorkerInner(page, bridgeCallback, mergeVHost, engineProxy, applicationContext, userAgent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createWorkerInner(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"worker"}) String str, RVEngine rVEngine, Context context, String str2) {
        try {
            page.getApp().getEngineProxy().getEngineRouter().registerWorker(str, rVEngine.createWorker(context, page, str, str2));
            StringBuilder sb = new StringBuilder();
            sb.append("success setServiceWorkerID ");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "installed");
            bridgeCallback.sendJSONResponse(jSONObject);
            try {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("register_work_success", "Render registerWork success", KybDataSource.RENDER, page.getApp() != null ? page.getApp().getAppId() : "", page.getPageURI(), null);
            } catch (Throwable th) {
                RVLogger.e(TAG, "flowLog exception:", th);
            }
        } catch (Throwable th2) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state", "failed");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createWorker exception! ");
            sb2.append(th2.getMessage());
            jSONObject2.put("exception", (Object) sb2.toString());
            bridgeCallback.sendJSONResponse(jSONObject2);
            RVLogger.e(TAG, "createWorker exception!", th2);
            ((EventTracker) RVProxy.get(EventTracker.class)).error(page, "WebEngineError", th2.getMessage()).putAttr(EventAttr.Key_abnormalCode, "registerWorkerError").putAttr(EventAttr.Key_abnormalMsg, th2.getMessage());
            ((WorkerExceptionPoint) ExtensionPoint.as(WorkerExceptionPoint.class).node(page).create()).onCreateWorkerException(th2.getMessage());
        }
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse postMessage(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingParam(name = {"ariver_message"}) String str) {
        String str2 = ((WorkerStore) page.getData(WorkerStore.class, true)).workerId;
        EngineRouter engineRouter = page.getApp().getEngineProxy().getEngineRouter();
        final JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("handlerName", (Object) "message");
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(RVConstants.KEY_POST_MESSAGE, (Object) str);
            jSONObject2.put("data", (Object) jSONObject3);
        } else {
            jSONObject2.put("data", (Object) jSONObject);
        }
        jSONObject2.getJSONObject("data").put(ContainerKeys.PARAM_PAGE_ID, (Object) Long.valueOf(page.getNodeId()));
        jSONObject2.getJSONObject("data").put("viewId", (Object) page.getRender().getRenderId());
        final Worker workerById = engineRouter.getWorkerById(str2);
        if (workerById == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("postMessage but cannot find worker for workerId: ");
            sb.append(str2);
            RVLogger.e(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cannot find worker for id: ");
            sb2.append(str2);
            return BridgeResponse.newError(10, sb2.toString());
        }
        if (workerById.isWorkerReady()) {
            workerById.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.2
                @Override // java.lang.Runnable
                public void run() {
                    workerById.sendJsonToWorker(jSONObject2, null);
                }
            });
        } else {
            workerById.registerWorkerReadyListener(new Worker.WorkerReadyListener() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.3
                @Override // com.alibaba.ariver.engine.api.Worker.WorkerReadyListener
                public void onWorkerReady() {
                    workerById.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            workerById.sendJsonToWorker(jSONObject2, null);
                        }
                    });
                }
            });
        }
        return BridgeResponse.SUCCESS;
    }

    public boolean isLoadPluginAllowed(String str) {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.APP_PLUGIN_ENABLE);
        if (configJSONObject == null) {
            return false;
        }
        if (configJSONObject.getBoolean("enable") == null || configJSONObject.getBoolean("enable").booleanValue()) {
            JSONArray jSONArray = configJSONObject.getJSONArray("blackList");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    if (str.equals(jSONArray.getString(i))) {
                        return false;
                    }
                }
            }
            JSONArray jSONArray2 = configJSONObject.getJSONArray("whiteList");
            if (jSONArray2 == null || jSONArray2.size() == 0) {
                return true;
            }
            for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                if (str.equals(jSONArray2.getString(i2))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse loadPlugin(@BindingApiContext ApiContext apiContext, @BindingParam(required = true, value = {"plugin"}) String str, @BindingNode(App.class) App app) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String appId = app.getAppId();
        if (!(QJSUtils.isAllowedQJS(appId) && GriverAppxNgRuntimeChecker.isUseAppxNg((AppModel) app.getData(AppModel.class, false)) && ((GriverV8WorkerExtension) RVProxy.get(GriverV8WorkerExtension.class, true)) != null) || !isLoadPluginAllowed(appId)) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)) != null) {
            String[] split = str.split(AUScreenAdaptTool.PREFIX_ID);
            String str2 = split[0];
            ((WorkerStore) app.getData(WorkerStore.class, true)).dynamicLoadedPlugins.add(str2);
            String str3 = split.length > 1 ? split[1] : "*";
            String str4 = TextUtils.isEmpty(str3) ? "*" : str3;
            PluginFuture pluginFuture = new PluginFuture(app, str2, str4, apiContext, new Bundle());
            this.mLoadedPlugins.put(str2, pluginFuture);
            try {
                return pluginFuture.get();
            } catch (Throwable th) {
                uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "failure", "notFoundApp", str2, str4, appId);
                return BridgeResponse.newError(6, th.getMessage());
            }
        }
        uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "failure", "Disable", "", "", appId);
        return BridgeResponse.UNKNOWN_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPluginLoadEvent(String str, String str2, String str3, String str4, String str5, String str6) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().appId(str6).needAsynAppType(true);
        needAsynAppType.append("consuming", str);
        needAsynAppType.append("result", str2);
        needAsynAppType.append("errorMessage", str3);
        needAsynAppType.append("pluginId", str4);
        needAsynAppType.append("pluginVersion", str5);
        GriverMonitor.event("mini_app_plugin_load", "GriverAppContainer", needAsynAppType.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadMiniFetchAppFail(String str, String str2, String str3, String str4, String str5, String str6) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().appId(str4).needAsynAppType(true);
        needAsynAppType.append("code", str);
        needAsynAppType.append("message", str2);
        needAsynAppType.append(GriverMonitorConstants.KEY_COST, str3);
        needAsynAppType.append("appId", str4);
        needAsynAppType.append("version", str5);
        needAsynAppType.append("deployVersion", str6);
        needAsynAppType.append("appType", "MiniProgramPlugin");
        GriverMonitor.event(GriverMonitorConstants.ERROR_FETCH_APP_EXCEPTION, "GriverAppContainer", needAsynAppType.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPluginTimecost(String str, String str2) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().appId(str2).needAsynAppType(true);
        needAsynAppType.append(GriverMonitorConstants.KEY_COST, str);
        GriverMonitor.event(GriverMonitorConstants.EVENT_FETCH_APP_SUCCESS, "GriverAppContainer", needAsynAppType.build());
    }

    /* loaded from: classes2.dex */
    class PluginFuture implements Future<BridgeResponse> {

        /* renamed from: a  reason: collision with root package name */
        private App f6424a;
        private ApiContext b;
        private String c;
        private String d;
        private BridgeResponse e = null;
        private PluginModel f = null;
        private Bundle g;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        PluginFuture(App app, String str, String str2, ApiContext apiContext, Bundle bundle) {
            this.f6424a = app;
            this.c = str;
            this.d = str2;
            this.b = apiContext;
            this.g = bundle;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.e != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public BridgeResponse get() throws InterruptedException {
            synchronized (this) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                BridgeResponse bridgeResponse = this.e;
                if (bridgeResponse != null) {
                    return bridgeResponse;
                }
                final AppModel appModel = (AppModel) this.f6424a.getData(AppModel.class, false);
                final String appId = appModel.getAppId();
                final RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
                PluginModel selectPluginModel = GriverPluginCacheManager.getInstance().selectPluginModel(this.c, this.d);
                this.f = selectPluginModel;
                if (selectPluginModel == null) {
                    JSONObject downloadMeta = PluginUtils.downloadMeta(this.f6424a.getAppId(), this.f6424a.getAppVersion(), this.c, this.d);
                    if (downloadMeta != null && downloadMeta.getBoolean("success").booleanValue()) {
                        PluginModel pluginModel = (PluginModel) JSON.parseObject(downloadMeta.getJSONObject("pluginMeta").getJSONObject("appInfo").toJSONString(), PluginModel.class);
                        this.f = pluginModel;
                        if (pluginModel != null) {
                            if (!"*".equals(this.d)) {
                                this.f.setVersion(this.d);
                            }
                            GriverPluginCacheManager.getInstance().savePluginModel(this.c, this.f.getVersion(), this.f);
                        }
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(elapsedRealtime2), "failure", "notFoundApp", this.c, this.d, appId);
                    WorkerBridgeExtension.this.uploadMiniFetchAppFail("10", "not found app", String.valueOf(elapsedRealtime2), appId, this.d, "");
                    return new BridgeResponse.Error(10, "not found app");
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                if (!rVPluginResourceManager.isAvailable(appModel, Collections.singletonList(this.f))) {
                    RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin not installed, just enter download install process!");
                    rVPluginResourceManager.downloadPlugins(appModel, Collections.singletonList(this.f), new PluginDownloadCallback() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.PluginFuture.1
                        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                        public void onSingleFailed(PluginModel pluginModel2, int i, String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                        public void onSuccess() {
                            rVPluginResourceManager.installPlugins(appModel, Collections.singletonList(PluginFuture.this.f), new PluginInstallCallback() { // from class: com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension.PluginFuture.1.1
                                @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                                public void onSingleFailed(PluginModel pluginModel2, int i, String str) {
                                }

                                @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                                public void onSuccess(List<Pair<PluginModel, String>> list) {
                                    GriverOfflinePkgManager.getInstance().updatePkgTime(PluginInfoUtil.getInstallParentPath(PluginFuture.this.f), System.currentTimeMillis());
                                    PluginFuture.this.e = PluginFuture.this.a(elapsedRealtime, appModel, PluginFuture.this.f);
                                    countDownLatch.countDown();
                                }

                                @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                                public void onFailed(int i, String str) {
                                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "failure", "install plugin fail", PluginFuture.this.c, PluginFuture.this.d, appId);
                                    PluginFuture pluginFuture = PluginFuture.this;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("install error: ");
                                    sb.append(str);
                                    pluginFuture.e = BridgeResponse.newError(10, sb.toString());
                                    countDownLatch.countDown();
                                }
                            });
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                        public void onFailed(int i, String str) {
                            WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "failure", "download plugin fail", PluginFuture.this.c, PluginFuture.this.d, appId);
                            PluginFuture pluginFuture = PluginFuture.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("download error: ");
                            sb.append(str);
                            pluginFuture.e = BridgeResponse.newError(9, sb.toString());
                            countDownLatch.countDown();
                        }
                    });
                    countDownLatch.await();
                    return this.e;
                }
                RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin installed, just enter load plugin!");
                BridgeResponse a2 = a(elapsedRealtime, appModel, this.f);
                this.e = a2;
                return a2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BridgeResponse a(long j, AppModel appModel, PluginModel pluginModel) {
            BridgeResponse bridgeResponse;
            String appId = appModel.getAppId();
            ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.f6424a.getAppId(), this.f6424a.getStartToken());
            ResourcePackage resourcePackage = (resourceContext.getPackages() == null || !resourceContext.getPackages().containsKey(this.c)) ? null : resourceContext.getPackages().get(this.c);
            if (resourcePackage == null) {
                resourcePackage = ((PackageQueryPoint) ExtensionPoint.as(PackageQueryPoint.class).node(this.f6424a).create()).createPluginPackage(appModel, pluginModel, resourceContext);
            }
            if (resourcePackage == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f6424a.isExited()) {
                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(elapsedRealtime - j), "failure", "PluginPackage == null because of app isExited", this.c, this.d, appId);
                    bridgeResponse = BridgeResponse.newError(5, "1", "PluginPackage == null because of app isExited");
                } else {
                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(elapsedRealtime - j), "failure", "cannot create PluginPackage!", this.c, this.d, appId);
                    bridgeResponse = BridgeResponse.newError(5, "2", "cannot create PluginPackage!");
                }
            } else {
                resourcePackage.setup(true);
                resourceContext.addPackage(resourcePackage);
                resourcePackage.waitForSetup();
                String str = ((WorkerStore) this.f6424a.getData(WorkerStore.class, true)).workerId;
                if (this.f6424a.getEngineProxy() == null) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    WorkerBridgeExtension workerBridgeExtension = WorkerBridgeExtension.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cannot loadPlugin without getEngineProxy! app.isExited =");
                    sb.append(this.f6424a.isExited());
                    workerBridgeExtension.uploadPluginLoadEvent(String.valueOf(elapsedRealtime2 - j), "failure", sb.toString(), this.c, this.d, appId);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("cannot loadPlugin without getEngineProxy! app.isExited =");
                    sb2.append(this.f6424a.isExited());
                    return BridgeResponse.newError(5, "3", sb2.toString());
                }
                Worker workerById = this.f6424a.getEngineProxy().getEngineRouter().getWorkerById(str);
                if (workerById == null) {
                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - j), "failure", "cannot loadPlugin without worker!", this.c, this.d, appId);
                    return BridgeResponse.newError(5, "4", "cannot loadPlugin without worker!");
                }
                try {
                    workerById.loadPlugin(this.c);
                    JSONObject jSONObject = new JSONObject();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("__plugins__/");
                    sb3.append(this.c);
                    sb3.append("/index.js");
                    jSONObject.put("url", sb3.toString());
                    if (pluginModel != null && pluginModel.getVersion() != null) {
                        jSONObject.put("version", pluginModel.getVersion());
                        PermissionModel pluginPermissionModel = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getPluginPermissionModel(appModel.getAppId(), pluginModel.getAppId());
                        JSONArray jSONArray = new JSONArray();
                        if (pluginPermissionModel != null) {
                            for (String str2 : pluginPermissionModel.getJsapiList()) {
                                if (!TextUtils.isEmpty(str2) && str2.startsWith("_appxFwExtra_")) {
                                    jSONArray.add(str2);
                                }
                            }
                        }
                        jSONObject.put("componentContext", (Object) jSONArray);
                        jSONObject.put("package_nick", pluginModel.getDeveloperVersion());
                    }
                    bridgeResponse = new BridgeResponse(jSONObject);
                    a(pluginModel, this.f6424a);
                } catch (Throwable th) {
                    WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(SystemClock.elapsedRealtime() - j), "failure", th.getMessage(), this.c, this.d, appId);
                    return BridgeResponse.newError(5, th.getMessage());
                }
            }
            ((PluginStore) this.f6424a.getData(PluginStore.class, true)).putDynamicPluginModel(pluginModel);
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - j;
            WorkerBridgeExtension.this.uploadPluginLoadEvent(String.valueOf(elapsedRealtime3), "success", "", this.c, this.d, appId);
            WorkerBridgeExtension.this.uploadPluginTimecost(String.valueOf(elapsedRealtime3), appId);
            return bridgeResponse;
        }

        private void a(PluginModel pluginModel, App app) {
            DynamicPluginInfo dynamicPluginInfo;
            if (app == null || pluginModel == null) {
                return;
            }
            if (app.getData(DynamicPluginInfo.class) == null) {
                dynamicPluginInfo = new DynamicPluginInfo();
            } else {
                dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            }
            dynamicPluginInfo.addPlugin(pluginModel);
            app.setData(DynamicPluginInfo.class, dynamicPluginInfo);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public BridgeResponse get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return get();
        }
    }
}
