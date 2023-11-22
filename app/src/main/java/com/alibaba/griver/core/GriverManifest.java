package com.alibaba.griver.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestManager;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.integration.BaseManifest;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.permission.extension.AppPermissionInitExtension;
import com.alibaba.ariver.permission.extension.EventSendInterceptorExtension;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.ariver.websocket.core.DefaultWebSocketProxyImpl;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.api.activity.GriverActivityRestoreExtension;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.env.GriverTopAppInfoExtension;
import com.alibaba.griver.api.common.menu.GriverMenuExtension;
import com.alibaba.griver.api.common.monitor.GriverMonitorAnalyticsConfigExtension;
import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import com.alibaba.griver.api.common.page.GriverStartPageFailedExtension;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtensionImpl;
import com.alibaba.griver.api.open.GriverAboutUrlExtension;
import com.alibaba.griver.api.resource.extensions.GriverParseFailedPoint;
import com.alibaba.griver.api.ui.GVViewFactory;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.api.ui.dialog.GriverPromptExtension;
import com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension;
import com.alibaba.griver.api.ui.optionmenu.GriverOptionMenuPanelExtension;
import com.alibaba.griver.api.ui.share.GriverShareExtension;
import com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension;
import com.alibaba.griver.api.ui.share.GriverShareMenuExtension;
import com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension;
import com.alibaba.griver.api.ui.titlebar.GriverButtonStyleExtension;
import com.alibaba.griver.api.ui.titlebar.GriverDefaultBackHomeButtonStyleExtension;
import com.alibaba.griver.api.webview.GriverGeoLocationExtension;
import com.alibaba.griver.api.webview.GriverWebViewReceivedErrorExtension;
import com.alibaba.griver.api.webview.PageAbnormalPoint;
import com.alibaba.griver.api.webview.PageErrorPoint;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.GriverBaseManifest;
import com.alibaba.griver.base.api.GriverAsyncUpdateManager;
import com.alibaba.griver.base.api.PageProcessPoint;
import com.alibaba.griver.base.api.ReceivedTitlePoint;
import com.alibaba.griver.base.api.ShouldLoadUrlPoint;
import com.alibaba.griver.base.common.CommonAbilityManifest;
import com.alibaba.griver.base.common.account.GriverRVAccountServiceImpl;
import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension;
import com.alibaba.griver.base.common.bridge.GriverNetworkPermissionExtension;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.config.GriverRVConfigServiceImpl;
import com.alibaba.griver.base.common.env.GriverRVEnvironmentServiceImpl;
import com.alibaba.griver.base.common.env.GriverRVResourceEnvProxyImpl;
import com.alibaba.griver.base.common.executor.GriverRVExecutorServiceImpl;
import com.alibaba.griver.base.common.innerapp.GriverRVInnerAppProxyImpl;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.logger.GriverRVLoggerProxyImpl;
import com.alibaba.griver.base.common.monitor.GriverRVMonitorImpl;
import com.alibaba.griver.base.common.network.GriverRVTransortServiceImpl;
import com.alibaba.griver.base.common.permission.GriverAuthentication;
import com.alibaba.griver.base.common.permission.GriverTinyAppInnerAuthenticationProxyImpl;
import com.alibaba.griver.base.common.permission.TinyAppInnerAuthenticationProxy;
import com.alibaba.griver.base.common.storage.GriverRVKVStorageProxyImpl;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.base.common.webview.WebViewSettingExtension;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alibaba.griver.base.preload.point.OnPreloadPoint;
import com.alibaba.griver.base.resource.GriverRVPluginResourceManagerImpl;
import com.alibaba.griver.base.resource.GriverRVResourceManagerImpl;
import com.alibaba.griver.base.resource.appinfo.GriverRVAppInfoManagerImpl;
import com.alibaba.griver.base.resource.appinfo.GriverRVAppUpdaterImpl;
import com.alibaba.griver.base.resource.extensions.GriverPackageQueryExtension;
import com.alibaba.griver.base.resource.point.ResourceProviderExtension;
import com.alibaba.griver.base.resource.preset.GriverRVResourcePresetImpl;
import com.alibaba.griver.biz.GriverBizManifest;
import com.alibaba.griver.bluetooth.BluetoothManifest;
import com.alibaba.griver.core.bridge.GriverBridgeManifest;
import com.alibaba.griver.core.common.monitor.GriverLifeCycleMonitorExtension;
import com.alibaba.griver.core.common.monitor.GriverMonitorAnalyticsConfigExtensionImpl;
import com.alibaba.griver.core.common.monitor.GriverMonitorAnalyticsTriggerExtension;
import com.alibaba.griver.core.common.monitor.GriverMonitorProxyManager;
import com.alibaba.griver.core.embedview.NXEmbedAppExtension;
import com.alibaba.griver.core.embedview.NXEmbedPageExtension;
import com.alibaba.griver.core.embedview.NXEmbedViewFactory;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.core.extensions.BridgeAccessExtension;
import com.alibaba.griver.core.extensions.DefaultAppExtension;
import com.alibaba.griver.core.extensions.DefaultHttpRequestAPIExtension;
import com.alibaba.griver.core.extensions.DefaultWebViewSettingExtensionImpl;
import com.alibaba.griver.core.extensions.GriverActivityRestoreExtensionImpl;
import com.alibaba.griver.core.extensions.GriverAppExtensionImpl;
import com.alibaba.griver.core.extensions.GriverAppLanguageExtensionImpl;
import com.alibaba.griver.core.extensions.GriverBridgeNotFoundExtension;
import com.alibaba.griver.core.extensions.GriverGeoLocationExtensionImpl;
import com.alibaba.griver.core.extensions.GriverNetworkPermissionExtensionImpl;
import com.alibaba.griver.core.extensions.GriverShouldLoadUrlExtension;
import com.alibaba.griver.core.extensions.GriverTopAppInfoExtensionImpl;
import com.alibaba.griver.core.extensions.JSAPIMonitorExtension;
import com.alibaba.griver.core.extensions.NebulaAuthDialogProxy;
import com.alibaba.griver.core.extensions.TrackerExtension;
import com.alibaba.griver.core.extensions.WorkerManagerExtension;
import com.alibaba.griver.core.h5.GriverSessionDataExtension;
import com.alibaba.griver.core.jsapi.app.ClientAppBridgeExtension;
import com.alibaba.griver.core.jsapi.app.GetAppInfoBridgeExtension;
import com.alibaba.griver.core.jsapi.dialog.DefaultDialogImplExtension;
import com.alibaba.griver.core.jsapi.dialog.GriverUniformDialogExtension;
import com.alibaba.griver.core.jsapi.dialog.GriverUniformPromptExtension;
import com.alibaba.griver.core.jsapi.logging.AppPerformanceBridgeExtension;
import com.alibaba.griver.core.jsapi.logging.HandleLoggingActionBridgeExtension;
import com.alibaba.griver.core.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.griver.core.jsapi.logging.TrackerConfigBridgeExtension;
import com.alibaba.griver.core.jsapi.monitor.GriverLogReportBridgeExtension;
import com.alibaba.griver.core.jsapi.monitor.MonitorBridgeExtension;
import com.alibaba.griver.core.jsapi.share.GriverDefaultShareMenu4PageExtensionImpl;
import com.alibaba.griver.core.jsapi.share.GriverDefaultShareMenuExtensionImpl;
import com.alibaba.griver.core.jsapi.share.GriverShareExtensionImpl;
import com.alibaba.griver.core.jsapi.share.ShareBridgeExtension;
import com.alibaba.griver.core.jsapi.toast.DefaultToastImplExtension;
import com.alibaba.griver.core.point.GriverEventManifest;
import com.alibaba.griver.core.point.PageHelperPoint;
import com.alibaba.griver.core.proxy.GriverEmbedWebViewJsApiPermissionProxyImpl;
import com.alibaba.griver.core.proxy.GriverEngineFactoryImpl;
import com.alibaba.griver.core.proxy.GriverPageFactory;
import com.alibaba.griver.core.proxy.GriverRemoteDebugProxy;
import com.alibaba.griver.core.proxy.GriverScreenOrientationProxyImpl;
import com.alibaba.griver.core.proxy.GriverStartClientProxy;
import com.alibaba.griver.core.proxy.GriverStartPageFailedExtensionImpl;
import com.alibaba.griver.core.proxy.GriverViewFactoryImpl;
import com.alibaba.griver.core.render.extensions.GriverBridgeInjectExtension;
import com.alibaba.griver.core.render.extensions.GriverDefaultWebViewReceivedErrorExtension;
import com.alibaba.griver.core.render.extensions.GriverPageAbnormalExtension;
import com.alibaba.griver.core.resource.GriverParseFailedExtension;
import com.alibaba.griver.core.ui.auth.UniformLocalAuthDialogExtensionImpl;
import com.alibaba.griver.core.ui.loading.GriverPageLoadingExtension;
import com.alibaba.griver.core.ui.menu.GriverAboutUrlExtensionImpl;
import com.alibaba.griver.core.ui.menu.GriverMenuExtensionImpl;
import com.alibaba.griver.core.ui.menu.UniformOptionMenuPanelExtensionImpl;
import com.alibaba.griver.core.update.GriverAsyncUpdateManagerImpl;
import com.alibaba.griver.core.utils.ExtensionRegistryUtils;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.alibaba.griver.device.DeviceManifest;
import com.alibaba.griver.file.FileManifest;
import com.alibaba.griver.h5.GriverH5Manifest;
import com.alibaba.griver.h5.api.GriverSessionDataPoint;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.ImageManifest;
import com.alibaba.griver.image.ImageServiceImpl;
import com.alibaba.griver.map.MapManifest;
import com.alibaba.griver.socket.SocketManifest;
import com.alibaba.griver.ui.extension.TitleBarExtension;
import com.alibaba.griver.ui.extension.WebContentExtension;
import com.alibaba.griver.ui.loading.GriverDefaultLoadingView;
import com.alibaba.griver.ui.popmenu.H5TinyPopMenu;
import com.alibaba.griver.ui.splash.SplashFragment;
import com.alibaba.griver.v8.V8Manifest;
import com.alipay.griver.ccdn.CCDNMainifest;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverManifest extends BaseManifest {
    private static final String BUNDLE_NAME = "com-alibaba-griver";
    private static final String TAG = "GriverManifest";

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(GriverBaseManifest.getInstance().getProxies());
        arrayList.add(new RVManifest.LazyProxyManifest(RVPerformanceTracker.class, new RVProxy.LazyGetter<RVPerformanceTracker>() { // from class: com.alibaba.griver.core.GriverManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPerformanceTracker get() {
                return new RVPerformanceTrackerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVNativePermissionRequestProxy.class, new RVProxy.LazyGetter<RVNativePermissionRequestProxy>() { // from class: com.alibaba.griver.core.GriverManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVNativePermissionRequestProxy get() {
                return new RVNativePermissionRequestManager();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVWebSocketProxy.class, new RVProxy.LazyGetter<RVWebSocketProxy>() { // from class: com.alibaba.griver.core.GriverManifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVWebSocketProxy get() {
                return new DefaultWebSocketProxyImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVNativePermissionRequestProxy.class, new RVNativePermissionRequestManager()));
        arrayList.add(new RVManifest.LazyProxyManifest(RVLogger.Proxy.class, new RVProxy.LazyGetter<RVLogger.Proxy>() { // from class: com.alibaba.griver.core.GriverManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVLogger.Proxy get() {
                return new GriverRVLoggerProxyImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVMonitor.class, new GriverRVMonitorImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(RVEnvironmentService.class, new RVProxy.LazyGetter<RVEnvironmentService>() { // from class: com.alibaba.griver.core.GriverManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVEnvironmentService get() {
                return new GriverRVEnvironmentServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVAccountService.class, new GriverRVAccountServiceImpl()));
        AppUpdaterFactory.registerRule(new AppUpdaterFactory.Rule() { // from class: com.alibaba.griver.core.GriverManifest.6
            @Override // com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory.Rule
            public IAppUpdater findUpdater(String str, Bundle bundle) {
                return new GriverRVAppUpdaterImpl();
            }
        });
        arrayList.add(new RVManifest.LazyProxyManifest(RVResourcePresetProxy.class, new RVProxy.LazyGetter<RVResourcePresetProxy>() { // from class: com.alibaba.griver.core.GriverManifest.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourcePresetProxy get() {
                return new GriverRVResourcePresetImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVExecutorService.class, new RVProxy.LazyGetter<RVExecutorService>() { // from class: com.alibaba.griver.core.GriverManifest.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVExecutorService get() {
                return new GriverRVExecutorServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(EngineFactory.class, new GriverEngineFactoryImpl()));
        arrayList.add(new RVManifest.ProxyManifest(EmbedWebViewJsApiPermissionProxy.class, new GriverEmbedWebViewJsApiPermissionProxyImpl()));
        arrayList.add(new RVManifest.ProxyManifest(RVClientStarter.class, new GriverStartClientProxy()));
        arrayList.add(new RVManifest.ProxyManifest(RVViewFactory.class, new GriverViewFactoryImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(RVConfigService.class, new RVProxy.LazyGetter<RVConfigService>() { // from class: com.alibaba.griver.core.GriverManifest.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVConfigService get() {
                return new GriverRVConfigServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(AuthenticationProxy.class, new GriverAuthentication()));
        arrayList.add(new RVManifest.LazyProxyManifest(RVAppInfoManager.class, new RVProxy.LazyGetter<RVAppInfoManager>() { // from class: com.alibaba.griver.core.GriverManifest.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVAppInfoManager get() {
                return new GriverRVAppInfoManagerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVResourceManager.class, new RVProxy.LazyGetter<RVResourceManager>() { // from class: com.alibaba.griver.core.GriverManifest.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourceManager get() {
                return new GriverRVResourceManagerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVPluginResourceManager.class, new RVProxy.LazyGetter<RVPluginResourceManager>() { // from class: com.alibaba.griver.core.GriverManifest.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPluginResourceManager get() {
                return new GriverRVPluginResourceManagerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVTransportService.class, new RVProxy.LazyGetter<RVTransportService>() { // from class: com.alibaba.griver.core.GriverManifest.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVTransportService get() {
                return new GriverRVTransortServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(GriverLoadingViewExtension.class, new GriverDefaultLoadingView()));
        if (ReflectUtils.classExist("com.alibaba.griver.v8.V8Manifest")) {
            try {
                arrayList.addAll(V8Manifest.getInstance().getProxies());
            } catch (Exception e) {
                GriverLogger.e(TAG, "Load socket manifest failed", e);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.image.ImageManifest")) {
            try {
                arrayList.addAll(ImageManifest.getInstance().getProxies());
            } catch (Exception e2) {
                GriverLogger.e(TAG, "Load imageManifet manifest failed", e2);
            }
        }
        arrayList.add(new RVManifest.ProxyManifest(RVPageFactory.class, new GriverPageFactory()));
        arrayList.add(new RVManifest.LazyProxyManifest(EmbedViewProvider.class, new RVProxy.LazyGetter<EmbedViewProvider>() { // from class: com.alibaba.griver.core.GriverManifest.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EmbedViewProvider get() {
                return new NXEmbedViewFactory();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVRemoteDebugProxy.class, new GriverRemoteDebugProxy()));
        arrayList.add(new RVManifest.ProxyManifest(TinyAppInnerProxy.class, new GriverRVInnerAppProxyImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(AuthDialogProxy.class, new RVProxy.LazyGetter<AuthDialogProxy>() { // from class: com.alibaba.griver.core.GriverManifest.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public AuthDialogProxy get() {
                return new NebulaAuthDialogProxy();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(KVStorageProxy.class, new RVProxy.LazyGetter<KVStorageProxy>() { // from class: com.alibaba.griver.core.GriverManifest.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public KVStorageProxy get() {
                return new GriverRVKVStorageProxyImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVPerformanceTracker.class, new RVPerformanceTrackerImpl()));
        arrayList.add(new RVManifest.ProxyManifest(RVResourceEnviromentProxy.class, new GriverRVResourceEnvProxyImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(RVNativePermissionRequestProxy.class, new RVProxy.LazyGetter<RVNativePermissionRequestProxy>() { // from class: com.alibaba.griver.core.GriverManifest.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVNativePermissionRequestProxy get() {
                return new RVNativePermissionRequestManager();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverDialogExtension.class, new RVProxy.LazyGetter<GriverDialogExtension>() { // from class: com.alibaba.griver.core.GriverManifest.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverDialogExtension get() {
                return new GriverUniformDialogExtension();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverPromptExtension.class, new RVProxy.LazyGetter<GriverPromptExtension>() { // from class: com.alibaba.griver.core.GriverManifest.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverPromptExtension get() {
                return new GriverUniformPromptExtension();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverWebViewReceivedErrorExtension.class, new RVProxy.LazyGetter<GriverWebViewReceivedErrorExtension>() { // from class: com.alibaba.griver.core.GriverManifest.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverWebViewReceivedErrorExtension get() {
                return new GriverDefaultWebViewReceivedErrorExtension();
            }
        }));
        if (ReflectUtils.classExist("com.alibaba.griver.ui.GriverViewFactoryImpl")) {
            arrayList.add(new RVManifest.ProxyManifest(GVViewFactory.class, new com.alibaba.griver.ui.GriverViewFactoryImpl()));
        }
        if (ReflectUtils.classExist("com.alibaba.griver.image.ImageServiceImpl")) {
            arrayList.add(new RVManifest.LazyProxyManifest(GriverImageService.class, new RVProxy.LazyGetter<GriverImageService>() { // from class: com.alibaba.griver.core.GriverManifest.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public GriverImageService get() {
                    return new ImageServiceImpl();
                }
            }));
        }
        arrayList.add(new RVManifest.LazyProxyManifest(GriverMonitorProxy.class, new RVProxy.LazyGetter<GriverMonitorProxy>() { // from class: com.alibaba.griver.core.GriverManifest.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverMonitorProxy get() {
                return GriverMonitorProxyManager.getDefaultProxy();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(OnPreloadPoint.class, new RVProxy.LazyGetter<OnPreloadPoint>() { // from class: com.alibaba.griver.core.GriverManifest.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public OnPreloadPoint get() {
                return new GriverOnPreloadExtension();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(GriverAppExtension.class, new GriverAppExtensionImpl()));
        arrayList.add(new RVManifest.ProxyManifest(GriverSplashFragmentExtension.class, new GriverSplashFragmentExtension() { // from class: com.alibaba.griver.core.GriverManifest.24
            @Override // com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension
            public GriverSplashFragmentExtension.AbstractSplashFragment createSplashFragment() {
                return new SplashFragment();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverHttpRequestAPIExtension.class, new RVProxy.LazyGetter<GriverHttpRequestAPIExtension>() { // from class: com.alibaba.griver.core.GriverManifest.25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverHttpRequestAPIExtension get() {
                return new DefaultHttpRequestAPIExtension();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverAppLanguageExtension.class, new RVProxy.LazyGetter<GriverAppLanguageExtension>() { // from class: com.alibaba.griver.core.GriverManifest.26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverAppLanguageExtension get() {
                return new GriverAppLanguageExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(WebViewSettingExtension.class, new RVProxy.LazyGetter<WebViewSettingExtension>() { // from class: com.alibaba.griver.core.GriverManifest.27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public WebViewSettingExtension get() {
                return new DefaultWebViewSettingExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverGeoLocationExtension.class, new RVProxy.LazyGetter<GriverGeoLocationExtension>() { // from class: com.alibaba.griver.core.GriverManifest.28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverGeoLocationExtension get() {
                return new GriverGeoLocationExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverTopAppInfoExtension.class, new RVProxy.LazyGetter<GriverTopAppInfoExtension>() { // from class: com.alibaba.griver.core.GriverManifest.29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverTopAppInfoExtension get() {
                return new GriverTopAppInfoExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVScreenOrientationProxy.class, new GriverScreenOrientationProxyImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverStartPageFailedExtension.class, new RVProxy.LazyGetter<GriverStartPageFailedExtension>() { // from class: com.alibaba.griver.core.GriverManifest.30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverStartPageFailedExtension get() {
                return new GriverStartPageFailedExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverActivityRestoreExtension.class, new RVProxy.LazyGetter<GriverActivityRestoreExtension>() { // from class: com.alibaba.griver.core.GriverManifest.31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverActivityRestoreExtension get() {
                return new GriverActivityRestoreExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverMenuExtension.class, new RVProxy.LazyGetter<GriverMenuExtension>() { // from class: com.alibaba.griver.core.GriverManifest.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverMenuExtension get() {
                return new GriverMenuExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(GriverAboutUrlExtension.class, new GriverAboutUrlExtensionImpl()));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverShareExtension.class, new RVProxy.LazyGetter<GriverShareExtension>() { // from class: com.alibaba.griver.core.GriverManifest.33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverShareExtension get() {
                return new GriverShareExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverShareMenuExtension.class, new RVProxy.LazyGetter<GriverShareMenuExtension>() { // from class: com.alibaba.griver.core.GriverManifest.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverShareMenuExtension get() {
                return new GriverDefaultShareMenuExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverShareMenu4PageExtension.class, new RVProxy.LazyGetter<GriverShareMenu4PageExtension>() { // from class: com.alibaba.griver.core.GriverManifest.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverShareMenu4PageExtension get() {
                return new GriverDefaultShareMenu4PageExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverAsyncUpdateManager.class, new RVProxy.LazyGetter<GriverAsyncUpdateManager>() { // from class: com.alibaba.griver.core.GriverManifest.36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverAsyncUpdateManager get() {
                return new GriverAsyncUpdateManagerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverNetworkPermissionExtension.class, new RVProxy.LazyGetter<GriverNetworkPermissionExtension>() { // from class: com.alibaba.griver.core.GriverManifest.37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverNetworkPermissionExtension get() {
                return new GriverNetworkPermissionExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverLocalAuthDialogExtension.class, new RVProxy.LazyGetter<GriverLocalAuthDialogExtension>() { // from class: com.alibaba.griver.core.GriverManifest.38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverLocalAuthDialogExtension get() {
                return new UniformLocalAuthDialogExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverOptionMenuPanelExtension.class, new RVProxy.LazyGetter<GriverOptionMenuPanelExtension>() { // from class: com.alibaba.griver.core.GriverManifest.39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverOptionMenuPanelExtension get() {
                return new UniformOptionMenuPanelExtensionImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(GriverMonitorAnalyticsConfigExtension.class, new GriverMonitorAnalyticsConfigExtensionImpl()));
        arrayList.add(new RVManifest.ProxyManifest(TinyAppInnerAuthenticationProxy.class, new GriverTinyAppInnerAuthenticationProxyImpl()));
        arrayList.add(new RVManifest.ProxyManifest(GriverButtonStyleExtension.class, new GriverDefaultBackHomeButtonStyleExtension()));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverAllRecordsExtension.class, new RVProxy.LazyGetter<GriverAllRecordsExtension>() { // from class: com.alibaba.griver.core.GriverManifest.40
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverAllRecordsExtension get() {
                return new GriverAllRecordsExtensionImpl();
            }
        }));
        Map<Class<? extends GriverExtension>, GriverExtension> extensionMap = GriverExtensionDelegate.getInstance().getExtensionMap();
        if (extensionMap != null && extensionMap.size() > 0) {
            for (Map.Entry<Class<? extends GriverExtension>, GriverExtension> entry : extensionMap.entrySet()) {
                arrayList.add(new RVManifest.ProxyManifest(entry.getKey(), entry.getValue()));
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.device.DeviceManifest")) {
            try {
                arrayList.addAll(DeviceManifest.getInstance().getProxies());
            } catch (Exception e3) {
                GriverLogger.e(TAG, "Load device manifest failed", e3);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.bluetooth.BluetoothManifest")) {
            try {
                arrayList.addAll(BluetoothManifest.getInstance().getProxies());
            } catch (Exception e4) {
                GriverLogger.e(TAG, "Load bluetooth manifest failed", e4);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.file.FileManifest")) {
            try {
                arrayList.addAll(FileManifest.getInstance().getProxies());
            } catch (Exception e5) {
                GriverLogger.e(TAG, "Load file manifest failed", e5);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.socket.SocketManifest")) {
            try {
                arrayList.addAll(SocketManifest.getInstance().getProxies());
            } catch (Exception e6) {
                GriverLogger.e(TAG, "Load socket manifest failed", e6);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.base.common.CommonAbilityManifest")) {
            try {
                arrayList.addAll(CommonAbilityManifest.getInstance().getProxies());
            } catch (Exception e7) {
                GriverLogger.e(TAG, "Load common ability manifest failed", e7);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.h5.GriverH5Manifest")) {
            try {
                arrayList.addAll(GriverH5Manifest.getInstance().getProxies());
            } catch (Exception e8) {
                GriverLogger.e(TAG, "Load h5 manifest failed", e8);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.map.MapManifest")) {
            try {
                arrayList.addAll(MapManifest.getInstance().getProxies());
            } catch (Exception e9) {
                GriverLogger.e(TAG, "Load map manifest failed", e9);
            }
        }
        if (ReflectUtils.classExist("com.alipay.griver.ccdn.CCDNMainifest")) {
            try {
                arrayList.addAll(CCDNMainifest.getInstance().getProxies());
            } catch (Exception e10) {
                GriverLogger.e(TAG, "Load map manifest failed", e10);
            }
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.remotedebug.jsapi.RemoteDebugBridgeExtension", (List<String>) Arrays.asList(TinyAppLogUtil.TINY_APP_STANDARD_LOG, "tyroRequest"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension", (List<String>) Arrays.asList("showRemoteDebugMask", "showRemoteDebugPanel"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.griver.core.jsapi.snapshot.SnapshotBridgeExtension", (List<String>) Arrays.asList("saveSnapshot", "getSnapshotConfig", "deleteSnapshot")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.ui.popmenu.CustomPopMenuExtension", (List<String>) Arrays.asList(H5TinyPopMenu.DEVELOPER_CUSTOM_MENU)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.toast.ToastBridgeExtension", (List<String>) Arrays.asList(ApiDowngradeConstant.ActionType.TOAST, "hideToast")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension", (List<String>) Arrays.asList("datePicker")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.dialog.DialogBridgeExtension", (List<String>) Arrays.asList(ApiDowngradeConstant.ActionType.ALERT, "confirm", "prompt")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.loading.LoadingBridgeExtension", (List<String>) Arrays.asList("showLoading", "hideLoading"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.app.WindowBridgeExtension", (List<String>) Arrays.asList("popTo", RVStartParams.FROM_TYPE_PUSH_WINDOW, "popWindow")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.app.TitleBarBridgeExtension", (List<String>) Arrays.asList(GriverEvents.EVENT_SET_TITLE, "getTitleAndStatusbarHeight", "getTitleAndStatusBarHeight", "setTitleColor", "setBarBottomLineColor", "setTransparentTitle", "getTitleColor", "showTitleLoading", "hideTitleLoading", "showOptionMenu", "hideOptionMenu", "setOptionMenu", GriverEvents.EVENT_SHOW_BACK_BUTTON, "hideBackButton"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.app.TabBarBridgeExtension", (List<String>) Arrays.asList("setTabBar", "switchTab"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.actionsheet.ActionSheetBridgeExtension", (List<String>) Arrays.asList("actionSheet"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.app.MiniProgramBridgeExtension", (List<String>) Arrays.asList("navigateToMiniProgram", "navigateBackMiniProgram", "getRunScene", "getExtConfig", "registerUpdateManager", "applyUpdate")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.prefetch.PreFetchBridgeExtension", (List<String>) Arrays.asList("getBackgroundFetchData")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension", (List<String>) Arrays.asList("beehiveOptionsPicker", "beehiveMultilevelSelect")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.ui.extension.TinyAppBackHomeExtension", (List<String>) Arrays.asList("showBackHome")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.pullrefresh.PullRefreshBridgeExtension", (List<String>) Arrays.asList("startPullDownRefresh", "restorePullToRefresh", "setCanPullDown")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.ui.AppearanceBridgeExtension", (List<String>) Arrays.asList("setBackgroundColor", "setBackgroundTextStyle", "hideShareMenu", "hideOptionMenuItem")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.aboutinfo.AboutInfoBridgeExtension", (List<String>) Arrays.asList("getAboutInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.network.NetworkBridgeExtension", (List<String>) Arrays.asList("getNetworkType")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.system.SystemInfoBridgeExtension", (List<String>) Arrays.asList(JSApiCachePoint.GET_SYSTEM_INFO)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.engine.InputBridgeExtension", (List<String>) Arrays.asList("toggleSoftInput", "showSoftInput", "inputFocus4Android")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.keyboard.KeyboardBridgeExtension", (List<String>) Arrays.asList("hideKeyboard")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.clipboard.ClipboardBridgeExtension", (List<String>) Arrays.asList("getClipboard", "setClipboard")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.storage.StorageBridgeExtension", (List<String>) Arrays.asList("setTinyLocalStorage", JSApiCachePoint.GET_LOCAL_STORAGE, "removeTinyLocalStorage", "clearTinyLocalStorage", "getTinyLocalStorageInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtensionWrapper", (List<String>) Arrays.asList("getCurrentLocation")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.device.network.RequestBridgeExtension", (List<String>) Arrays.asList("request", PermissionConstant.HTTPREQUET)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.diagnostic.DiagnosticBridgeExtension", (List<String>) Arrays.asList("griverInternalDiagnoticTool", "pdsReportTracks", "griverCheckWalletApi")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.engine.OrientationBridgeExtension", (List<String>) Arrays.asList("getScreenOrientation", "setScreenOrientation")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.worker.WorkerBridgeExtension", (List<String>) Arrays.asList("registerWorker", NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, "loadPlugin")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.extensions.GriverEmbedViewBridgeExtension", (List<String>) Arrays.asList("NBComponent.render", "NBComponent.sendMessage")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.embedview.EmbedWebViewBridgeExtension", (List<String>) Arrays.asList("postWebViewMessage")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.engine.EngineBridgeExtension", (List<String>) Arrays.asList("measureText", "checkJSAPI", "h5PageReload")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.internalapi.InternalApiBridgeExtension", (List<String>) Arrays.asList("internalAPI"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, HandleLoggingActionBridgeExtension.class.getName(), (List<String>) Arrays.asList("handleLoggingAction")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, AppPerformanceBridgeExtension.class.getName(), (List<String>) Arrays.asList("onAppPerfEvent", "onCubeAppPerfEvent", "monitorH5Performance")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, TrackerConfigBridgeExtension.class.getName(), (List<String>) Arrays.asList("trackerConfig")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.core.jsapi.subpackage.SubPackageBridgeExtension", (List<String>) Arrays.asList("loadSubPackage"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, ClientAppBridgeExtension.class.getName(), (List<String>) Arrays.asList("updateClientApp"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, GetAppInfoBridgeExtension.class.getName(), (List<String>) Arrays.asList("fetchAppInfoListByIds", "fetchAppInfoListByKeyword"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, ShareBridgeExtension.class.getName(), (List<String>) Arrays.asList("shareTinyAppMsg")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, MonitorBridgeExtension.class.getName(), MonitorBridgeExtension.getJSAPI()));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, GriverLogReportBridgeExtension.class.getName(), GriverLogReportBridgeExtension.getJSAPI()));
        if (ReflectUtils.classExist("com.alibaba.griver.device.DeviceManifest")) {
            try {
                arrayList.addAll(DeviceManifest.getInstance().getBridgeExtensions());
            } catch (Exception e) {
                GriverLogger.e(TAG, "Load device extension failed", e);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.bluetooth.BluetoothManifest")) {
            try {
                arrayList.addAll(BluetoothManifest.getInstance().getBridgeExtensions());
            } catch (Exception e2) {
                GriverLogger.e(TAG, "Load bluetooth extension failed", e2);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.image.ImageManifest")) {
            try {
                arrayList.addAll(ImageManifest.getInstance().getBridgeExtensions());
            } catch (Exception e3) {
                GriverLogger.e(TAG, "Load bluetooth extension failed", e3);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.file.FileManifest")) {
            try {
                arrayList.addAll(FileManifest.getInstance().getBridgeExtensions());
            } catch (Exception e4) {
                GriverLogger.e(TAG, "Load file extension failed", e4);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.map.MapManifest")) {
            try {
                arrayList.addAll(MapManifest.getInstance().getBridgeExtensions());
            } catch (Exception e5) {
                GriverLogger.e(TAG, "Load file extension failed", e5);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.socket.SocketManifest")) {
            try {
                arrayList.addAll(SocketManifest.getInstance().getBridgeExtensions());
            } catch (Exception e6) {
                GriverLogger.e(TAG, "Load socket extension failed", e6);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.base.common.CommonAbilityManifest")) {
            try {
                arrayList.addAll(CommonAbilityManifest.getInstance().getBridgeExtensions());
            } catch (Exception e7) {
                GriverLogger.e(TAG, "Load common ability bridge extension failed", e7);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.h5.GriverH5Manifest")) {
            try {
                arrayList.addAll(GriverH5Manifest.getInstance().getBridgeExtensions());
            } catch (Exception e8) {
                GriverLogger.e(TAG, "Load h5 bridge extension failed", e8);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.biz.GriverBizManifest")) {
            try {
                arrayList.addAll(GriverBizManifest.getInstance().getBridgeExtensions());
            } catch (Exception e9) {
                GriverLogger.e(TAG, "Load biz bridge extension failed", e9);
            }
        }
        registerBridge(arrayList);
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.runtime.GriverResourceLoadExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppStartPoint", "com.alibaba.ariver.app.api.point.app.AppLoadPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint", "com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint", "com.alibaba.ariver.engine.api.resources.ResourceLoadPoint", "com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.api.snapshot.SnapshotSaveExtension", Arrays.asList("com.alibaba.ariver.app.api.point.page.PagePausePoint", "com.alibaba.ariver.app.api.point.app.PushWindowPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.app.extensions.AppRestartExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppRestartPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.logging.PerformancePubExtension", Arrays.asList("com.alibaba.ariver.app.api.monitor.RVPub")));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.permission.extension.AppPermissionInitExtension", Arrays.asList("com.alibaba.ariver.resource.api.extension.PackageParsedPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.permission.extension.EventSendInterceptorExtension", Arrays.asList("com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.integration.proxy.impl.CommonAppExitExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppExitPoint")));
        linkedList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.tools.extension.RVToolsActivityHelperOnCreateFinishedExtension", Arrays.asList("com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint"), App.class));
        linkedList.add(new ExtensionMetaInfo(RVEConstant.RVEHost.ARIVER_HOST, ResourceProviderExtension.class.getName(), Collections.singletonList(ResourceProviderPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(RVEConstant.RVEHost.ARIVER_HOST, BridgeAccessExtension.class.getName(), Collections.singletonList(BridgeAccessPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(RVEConstant.RVEHost.ARIVER_HOST, GriverPackageQueryExtension.class.getName(), Collections.singletonList(PackageQueryPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, DefaultAppExtension.class.getName(), Arrays.asList(AppStartPoint.class.getName(), AppDestroyPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(RVEConstant.RVEHost.ARIVER_HOST, AppPermissionInitExtension.class.getName(), Arrays.asList(PackageParsedPoint.class.getName(), AppDestroyPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(RVEConstant.RVEHost.ARIVER_HOST, WorkerManagerExtension.class.getName(), Arrays.asList(CreateWorkerPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverPageAbnormalExtension.class.getName(), Collections.singletonList(PageAbnormalPoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo("permission", EventSendInterceptorExtension.class.getName(), Collections.singletonList(EventSendInterceptorPoint.class.getName()), App.class));
        if (ReflectUtils.classExist("com.alibaba.griver.ui.extension.TitleBarExtension")) {
            linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, TitleBarExtension.class.getName(), Arrays.asList(TitleBarOptionClickPoint.class.getName(), TitleBarShowClosePoint.class.getName(), ReceivedTitlePoint.class.getName()), App.class));
        }
        if (ReflectUtils.classExist("com.alibaba.griver.ui.extension.WebContentExtension")) {
            linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, WebContentExtension.class.getName(), Arrays.asList(TitleBarCloseClickPoint.class.getName(), BackPressedPoint.class.getName(), TitleBarTitleClickPoint.class.getName()), Page.class));
        }
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, JSAPIMonitorExtension.class.getName(), Collections.singletonList(NativeCallResultPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, DefaultDialogImplExtension.class.getName(), Arrays.asList(DialogPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, DefaultToastImplExtension.class.getName(), Arrays.asList(ToastPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverParseFailedExtension.class.getName(), Arrays.asList(GriverParseFailedPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverSessionDataExtension.class.getName(), Arrays.asList(GriverSessionDataPoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverPageLoadingExtension.class.getName(), Arrays.asList(PageEnterPoint.class.getName(), PageFinishedPoint.class.getName(), PageErrorPoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverBridgeInjectExtension.class.getName(), Arrays.asList(PageStartedPoint.class.getName(), PageFinishedPoint.class.getName(), ReceivedTitlePoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverLifeCycleMonitorExtension.class.getName(), Arrays.asList(PagePausePoint.class.getName(), PageEnterPoint.class.getName(), PageResumePoint.class.getName(), PageExitPoint.class.getName(), PageDestroyPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, PageHelperPoint.class.getName(), Arrays.asList(PageStartedPoint.class.getName(), PageResumePoint.class.getName(), PageFinishedPoint.class.getName(), PageExitPoint.class.getName(), PageProcessPoint.class.getName(), PageBackPoint.class.getName(), PagePausePoint.class.getName(), PageDestroyPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, TrackerExtension.class.getName(), Arrays.asList(AppStartPoint.class.getName(), PageFinishedPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverShouldLoadUrlExtension.class.getName(), Arrays.asList(ShouldLoadUrlPoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, NXEmbedAppExtension.class.getName(), Arrays.asList(BackKeyDownPoint.class.getName()), App.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, NXEmbedPageExtension.class.getName(), Arrays.asList(BackPressedPoint.class.getName()), Page.class));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverBridgeNotFoundExtension.class.getName(), Arrays.asList(NativeCallNotFoundPoint.class.getName())));
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverMonitorAnalyticsTriggerExtension.class.getName(), Arrays.asList(AppOnLoadResultPoint.class.getName())));
        registerPoint(linkedList);
        if (ReflectUtils.classExist("com.alibaba.griver.v8.V8Manifest")) {
            try {
                linkedList.addAll(V8Manifest.getInstance().getExtensions());
            } catch (Exception e) {
                GriverLogger.e(TAG, "Load V8 extension failed", e);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.device.DeviceManifest")) {
            try {
                linkedList.addAll(DeviceManifest.getInstance().getExtensions());
            } catch (Exception e2) {
                GriverLogger.e(TAG, "Load device extension failed", e2);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.bluetooth.BluetoothManifest")) {
            try {
                linkedList.addAll(BluetoothManifest.getInstance().getExtensions());
            } catch (Exception e3) {
                GriverLogger.e(TAG, "Load bluetooth extension failed", e3);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.file.FileManifest")) {
            try {
                linkedList.addAll(FileManifest.getInstance().getExtensions());
            } catch (Exception e4) {
                GriverLogger.e(TAG, "Load file extension failed", e4);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.socket.SocketManifest")) {
            try {
                linkedList.addAll(SocketManifest.getInstance().getExtensions());
            } catch (Exception e5) {
                GriverLogger.e(TAG, "Load socket extension failed", e5);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.base.common.CommonAbilityManifest")) {
            try {
                linkedList.addAll(CommonAbilityManifest.getInstance().getExtensions());
            } catch (Exception e6) {
                GriverLogger.e(TAG, "Load common ability extension failed", e6);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.h5.GriverH5Manifest")) {
            try {
                linkedList.addAll(GriverH5Manifest.getInstance().getExtensions());
            } catch (Exception e7) {
                GriverLogger.e(TAG, "Load h5 extension failed", e7);
            }
        }
        linkedList.add(new ExtensionMetaInfo(BUNDLE_NAME, GriverUniformDialogExtension.class.getName(), Arrays.asList(AppOnConfigurationChangedPoint.class.getName())));
        return linkedList;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        List<RVManifest.ServiceBeanManifest> serviceBeans = super.getServiceBeans(extensionManager);
        if (serviceBeans == null) {
            serviceBeans = new ArrayList<>();
        }
        if (ReflectUtils.classExist("com.alibaba.griver.device.DeviceManifest")) {
            try {
                serviceBeans.addAll(DeviceManifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e) {
                GriverLogger.e(TAG, "Load device service bean failed", e);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.bluetooth.BluetoothManifest")) {
            try {
                serviceBeans.addAll(BluetoothManifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e2) {
                GriverLogger.e(TAG, "Load bluetooth service bean failed", e2);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.file.FileManifest")) {
            try {
                serviceBeans.addAll(FileManifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e3) {
                GriverLogger.e(TAG, "Load file service bean failed", e3);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.socket.SocketManifest")) {
            try {
                serviceBeans.addAll(SocketManifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e4) {
                GriverLogger.e(TAG, "Load socket service bean failed", e4);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.base.common.CommonAbilityManifest")) {
            try {
                serviceBeans.addAll(CommonAbilityManifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e5) {
                GriverLogger.e(TAG, "Load common ability service bean failed", e5);
            }
        }
        if (ReflectUtils.classExist("com.alibaba.griver.h5.GriverH5Manifest")) {
            try {
                serviceBeans.addAll(GriverH5Manifest.getInstance().getServiceBeans(extensionManager));
            } catch (Exception e6) {
                GriverLogger.e(TAG, "Load h5 service bean failed", e6);
            }
        }
        return serviceBeans;
    }

    private void registerPoint(List<ExtensionMetaInfo> list) {
        List<GriverEventManifest> eventManifests = GriverExtensionDelegate.getInstance().getEventManifests();
        if (eventManifests == null || eventManifests.size() <= 0) {
            return;
        }
        Iterator<GriverEventManifest> it = eventManifests.iterator();
        while (it.hasNext()) {
            ExtensionMetaInfo convert = ExtensionRegistryUtils.convert(it.next());
            if (convert != null) {
                list.add(convert);
            }
        }
    }

    public void registerBridge(List<RVManifest.BridgeExtensionManifest> list) {
        List<GriverBridgeManifest> bridgeManifests = GriverExtensionDelegate.getInstance().getBridgeManifests();
        if (bridgeManifests == null || bridgeManifests.size() <= 0) {
            return;
        }
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_SYSTEM_BRIDGE_LIST, "");
        List list2 = TextUtils.isEmpty(config) ? null : (List) JSONObject.parseObject(config, new TypeReference<List<String>>() { // from class: com.alibaba.griver.core.GriverManifest.41
        }, new Feature[0]);
        for (GriverBridgeManifest griverBridgeManifest : bridgeManifests) {
            if (!TextUtils.isEmpty(griverBridgeManifest.getClassName()) && griverBridgeManifest.getActionList() != null && griverBridgeManifest.getActionList().size() != 0 && ReflectUtils.classExist(griverBridgeManifest.getClassName())) {
                if (list2 != null && list2.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    for (String str : griverBridgeManifest.getActionList()) {
                        if (!list2.contains(str)) {
                            linkedList.add(str);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(" is not register");
                            RVLogger.w(TAG, sb.toString());
                        }
                    }
                    griverBridgeManifest.setActionList(linkedList);
                }
                if (griverBridgeManifest.getActionList() != null && griverBridgeManifest.getActionList().size() != 0) {
                    list.add(RVManifest.BridgeExtensionManifest.makeRaw(griverBridgeManifest.getClassName(), griverBridgeManifest.getClassName(), griverBridgeManifest.getActionList()));
                }
            }
        }
    }
}
