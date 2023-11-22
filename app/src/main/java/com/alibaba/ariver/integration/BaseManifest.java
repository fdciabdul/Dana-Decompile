package com.alibaba.ariver.integration;

import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestManager;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.track.JsApiStatTrackServiceImpl;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.integration.ipc.server.ServerSideRemoteExtensionCaller;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.TBAuthDialogProxy;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.support.supportui.extensions.AuthDialogExtentionV2;
import com.alibaba.ariver.websocket.core.DefaultWebSocketProxyImpl;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class BaseManifest implements RVManifest {
    private AccessController mAccessController = null;
    private RemoteController mRemoteController = null;

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        AccessController accessController;
        synchronized (this) {
            if (this.mAccessController == null) {
                this.mAccessController = new DefaultAccessController();
            }
            accessController = this.mAccessController;
        }
        return accessController;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        RemoteController remoteController;
        synchronized (this) {
            if (this.mRemoteController == null) {
                this.mRemoteController = new DefaultRemoteController();
            }
            remoteController = this.mRemoteController;
        }
        return remoteController;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.toast.ToastBridgeExtension", (List<String>) Arrays.asList(ApiDowngradeConstant.ActionType.TOAST, "hideToast")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.DatePickerBridgeExtension", (List<String>) Arrays.asList("datePicker")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension", (List<String>) Arrays.asList(ApiDowngradeConstant.ActionType.ALERT, "confirm", "prompt", "agreementConfirm")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.LoadingBridgeExtension", (List<String>) Arrays.asList("showLoading", "hideLoading"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.network.NetworkBridgeExtension", (List<String>) Arrays.asList("getNetworkType")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.android.playground.extensions.SystemInfoBridgeExtension", (List<String>) Arrays.asList(JSApiCachePoint.GET_SYSTEM_INFO)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.AppRunTimeInfoBridgeExtension", (List<String>) Arrays.asList("getLocaleInfo", "getLayoutDirection")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension", (List<String>) Arrays.asList("registerWorker", NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, "loadPlugin"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.EmbedViewBridgeExtension", (List<String>) Arrays.asList("NBComponent.render", "NBComponent.sendMessage", "NBComponent.remove")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.EmbedWebViewBridgeExtension", (List<String>) Arrays.asList("postWebViewMessage", "getEmbedWebViewEnv")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.OpenAuthExtension", (List<String>) Arrays.asList("getAuthorize", Constants.JS_API_GET_AUTH_CODE, "getAuthUserInfo", "getBusinessAuth", Constants.JS_API_GET_COMPONENT_AUTH, "showAuthGuide")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.ProgramSettingExtension", (List<String>) Arrays.asList(Constants.JS_API_GET_SETTING)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.TBAuthorizeBridge", (List<String>) Arrays.asList("getTBCode", "authorize", "setTBSessionInfo", "getTBSessionInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.TBAuthorizeOpenSettingExtension", (List<String>) Arrays.asList("openSetting")).instanceType(InstanceType.TAOBAO));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.template.TemplateBridgeExtension", (List<String>) Arrays.asList("getExtConfig")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension", (List<String>) Arrays.asList("addPkgRes", "checkApp", "installApp")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.resource.GetAppInfoBridgeExtension", (List<String>) Arrays.asList("getAppInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.resource.SnapshotBridgeExtension", (List<String>) Arrays.asList("saveSnapshot", "getSnapshotConfig", "deleteSnapshot")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.mtop.MtopBridgeExtention", (List<String>) Arrays.asList("sendMtop")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.GetClientInfoBridgeExtension", (List<String>) Arrays.asList("getClientInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.InputBridgeExtension", (List<String>) Arrays.asList("toggleSoftInput", "showSoftInput", "inputFocus4Android")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.OrientationBridgeExtension", (List<String>) Arrays.asList("getScreenOrientation", "setScreenOrientation")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.EngineBridgeExtension", (List<String>) Arrays.asList("checkJSAPI", "h5PageReload", "measureText")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.logging.AppPerformanceBridgeExtension", (List<String>) Arrays.asList("onAppPerfEvent", "onCubeAppPerfEvent", "monitorH5Performance")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.app.AppBridgeExtension", (List<String>) Arrays.asList("getSceneStackInfo"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.app.TitleBarBridgeExtension", (List<String>) Arrays.asList(GriverEvents.EVENT_SET_TITLE, "getTitleAndStatusbarHeight", "setTitleColor", "setBarBottomLineColor", "setTransparentTitle", "getTitleColor", "showTitleLoading", "hideTitleLoading", "showOptionMenu", "hideOptionMenu", GriverEvents.EVENT_SHOW_BACK_BUTTON, "hideBackButton"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.app.TabBarBridgeExtension", (List<String>) Arrays.asList("setTabBar", "switchTab", "removeTabBarItem", "addTabBarItem", "getTabBarStatus"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension", (List<String>) Arrays.asList("internalAPI"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension", (List<String>) Arrays.asList("loadSubPackage"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.StartParamsBridgeExtension", (List<String>) Arrays.asList("getStartupParams", "setStartParam"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension", (List<String>) Arrays.asList("actionSheet"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.NotificationBridgeExtension", (List<String>) Arrays.asList("addNotifyListener", "removeNotifyListener", "postNotification"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.rpc.RpcBridgeExtension", (List<String>) Arrays.asList("rpc"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.rpc.TinyAppxRpcBridgeExtension", (List<String>) Arrays.asList("appxrpc"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.rpc.TinyRpcBridgeExtension", (List<String>) Arrays.asList("tinyRpc"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.logging.HandleLoggingActionBridgeExtension", (List<String>) Arrays.asList("handleLoggingAction"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.app.WindowBridgeExtension", (List<String>) Arrays.asList(RVStartParams.FROM_TYPE_PUSH_WINDOW, "popWindow", "popTo", "getRunScene"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.websocket.WebSocketBridgeExtension", (List<String>) Arrays.asList("connectSocket", "sendSocketMessage", "closeSocket"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.remotedebug.RemoteDebugBridgeExtension", (List<String>) Arrays.asList(TinyAppLogUtil.TINY_APP_STANDARD_LOG, "tyroRequest"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.remotedebug.RemoteDebugViewBridgeExtension", (List<String>) Arrays.asList("showRemoteDebugMask", "showRemoteDebugPanel"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.PermissionConfigExtension", (List<String>) Arrays.asList("getPermissionConfig")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.tracedebug.jsapi.TraceDebugBridgeExtension", (List<String>) Arrays.asList("initialTraceDebug", "postMethodTrace"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.tools.extension.RVToolsResourceExtension", (List<String>) Arrays.asList("rvToolsFetchResource"), (Class<? extends Scope>) App.class));
        if (isInStandardCashierSDK()) {
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.pay.StdTradePayBridgeExtension", (List<String>) Arrays.asList(Constants.JS_API_TRADE_PAY), (Class<? extends Scope>) App.class));
        } else {
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.pay.ProTradePayBridgeExtension", (List<String>) Arrays.asList(Constants.JS_API_TRADE_PAY), (Class<? extends Scope>) App.class));
        }
        return arrayList;
    }

    private static boolean isInStandardCashierSDK() {
        try {
            Class.forName("com.alipay.sdk.app.PayTask");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.runtime.ResourceLoadExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppStartPoint", "com.alibaba.ariver.app.api.point.app.AppCreatePoint", "com.alibaba.ariver.app.api.point.app.AppLoadPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint", "com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint", "com.alibaba.ariver.engine.api.resources.ResourceLoadPoint", "com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint"), App.class).addExcludeNode("com.alibaba.xriver.android.node.CRVApp"));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.resource.api.snapshot.SnapshotSaveExtension", Arrays.asList("com.alibaba.ariver.app.api.point.page.PagePausePoint", "com.alibaba.ariver.app.api.point.app.PushWindowPoint"), App.class).addExcludeNode("com.alibaba.xriver.android.node.CRVApp"));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.app.extensions.AppRestartExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppRestartPoint"), App.class).addExcludeNode("com.alibaba.xriver.android.node.CRVApp"));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.logging.PerformancePubExtension", Arrays.asList("com.alibaba.ariver.app.api.monitor.RVPub")));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.permission.extension.AppPermissionInitExtension", Arrays.asList("com.alibaba.ariver.resource.api.extension.PackageParsedPoint", "com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint"), App.class).addExcludeNode("com.alibaba.xriver.android.node.CRVApp"));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.permission.extension.EventSendInterceptorExtension", Arrays.asList("com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.integration.proxy.impl.CommonAppExitExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppExitPoint")));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.integration.proxy.impl.RVEAppExitExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppExitPoint")));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.tools.extension.RVToolsActivityHelperOnCreateFinishedExtension", Arrays.asList("com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.tools.extension.RVToolsEngineInitSuccessExtension", Arrays.asList("com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.remotedebug.worker.CreateRemoteWorkerExtension", Arrays.asList("com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.tracedebug.extension.TraceDebugEngineExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppLoadPoint", "com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint", "com.alibaba.ariver.app.api.point.page.PageExitPoint", "com.alibaba.ariver.app.api.point.page.PageEnterPoint", "com.alibaba.ariver.app.api.point.app.AppExitPoint", "com.alibaba.ariver.app.api.point.view.TinyAppLifecyclePoint", "com.alibaba.ariver.engine.api.point.NativeCallResultPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.tools.extension.RVToolsResourceInterceptExtension", Arrays.asList("com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint", "com.alibaba.ariver.app.api.point.page.PageStartedPoint", "com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint", "com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint", "com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.font.FontSizeSettingExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppStartPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint"), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-ariver-ariver", "com.alibaba.ariver.console.DebugConsoleExtension", Arrays.asList("com.alibaba.ariver.console.DebugConsolePoint"), App.class));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(RVPerformanceTracker.class, new RVProxy.LazyGetter<RVPerformanceTracker>() { // from class: com.alibaba.ariver.integration.BaseManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPerformanceTracker get() {
                return new RVPerformanceTrackerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVNativePermissionRequestProxy.class, new RVProxy.LazyGetter<RVNativePermissionRequestProxy>() { // from class: com.alibaba.ariver.integration.BaseManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVNativePermissionRequestProxy get() {
                return new RVNativePermissionRequestManager();
            }
        }));
        try {
            arrayList.add(new RVManifest.LazyProxyManifest(RVWebSocketProxy.class, new RVProxy.LazyGetter<RVWebSocketProxy>() { // from class: com.alibaba.ariver.integration.BaseManifest.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public RVWebSocketProxy get() {
                    return new DefaultWebSocketProxyImpl();
                }
            }));
        } catch (Throwable th) {
            RVLogger.e(Log.getStackTraceString(th));
        }
        arrayList.add(new RVManifest.LazyProxyManifest(RVJsStatTrackService.class, new RVProxy.LazyGetter<RVJsStatTrackService>() { // from class: com.alibaba.ariver.integration.BaseManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVJsStatTrackService get() {
                return new JsApiStatTrackServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVNativePermissionRequestProxy.class, new RVNativePermissionRequestManager()));
        arrayList.add(new RVManifest.LazyProxyManifest(TBAuthDialogProxy.class, new RVProxy.LazyGetter<TBAuthDialogProxy>() { // from class: com.alibaba.ariver.integration.BaseManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public TBAuthDialogProxy get() {
                return new AuthDialogExtentionV2();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(final ExtensionManager extensionManager) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.ServiceBeanManifest(IRemoteCaller.class, new RVProxy.LazyGetter<IRemoteCaller>() { // from class: com.alibaba.ariver.integration.BaseManifest.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IRemoteCaller get() {
                return new ServerSideRemoteExtensionCaller(extensionManager);
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return new ArrayList();
    }
}
