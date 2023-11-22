package com.iap.ac.android.container.adapter.griver;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.api.bridge.GriverBridgeCallEvent;
import com.alibaba.griver.api.bridge.GriverBridgeCallNotFoundEvent;
import com.alibaba.griver.api.bridge.GriverBridgeCallPreInterceptEvent;
import com.alibaba.griver.api.common.GriverExtensionManifest;
import com.alibaba.griver.api.common.menu.GriverACMenuExtension;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.page.GriverAppEvent;
import com.alibaba.griver.api.common.page.GriverInterceptUrlEvent;
import com.alibaba.griver.api.common.page.GriverPageHelperEvent;
import com.alibaba.griver.api.common.webview.GriverUserAgentExtension;
import com.alibaba.griver.api.h5.permission.GriverH5JSAPIPermissionExtension;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.base.resource.cache.GriverCacheManager;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.bridge.BridgeInterceptorManager;
import com.alibaba.griver.core.model.applist.AppInfosResult;
import com.alibaba.griver.core.model.applist.FetchAppsByIdsRequest;
import com.alibaba.griver.core.point.GriverEventManifest;
import com.alibaba.griver.init.IAPGriverConfig;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.container.IContainer;
import com.iap.ac.android.common.container.auth.IContainerAuth;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.container.constant.ContainerEventAction;
import com.iap.ac.android.common.container.event.ContainerEventFilter;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor;
import com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor;
import com.iap.ac.android.common.container.js.model.JSBridgeMessageToNative;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.container.model.AppInfoListData;
import com.iap.ac.android.common.container.model.CloseAppParams;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.constant.GriverAdapterKeys;
import com.iap.ac.android.container.adapter.griver.event.AppEventHandler;
import com.iap.ac.android.container.adapter.griver.event.BridgeCallNotFoundEventHandler;
import com.iap.ac.android.container.adapter.griver.event.BridgeCallPreInterceptorHandler;
import com.iap.ac.android.container.adapter.griver.event.GriverJSAPICallEventHandler;
import com.iap.ac.android.container.adapter.griver.event.InterceptUrlEventHandler;
import com.iap.ac.android.container.adapter.griver.event.PageHelperEventHandler;
import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;
import com.iap.ac.android.container.adapter.griver.extension.JSPermissionExtensionImpl;
import com.iap.ac.android.container.adapter.griver.extension.UserAgentExtensionImpl;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GriverContainerImpl implements IContainer {
    public static final String KEY_APPID = "appId";
    public static final String KEY_WORKSPACEID = "workSpaceId";

    /* renamed from: a  reason: collision with root package name */
    private static String f7553a = "env";
    private static String b = "environment";
    private static String c = "authCode";
    private static String d = "useAmcsLite";
    private static String e = "useSecurityGuard";
    private static String f = "gpSignature";
    private static String g = "gatewayUrl";
    private static String h = "language";
    private static String i = "flowType";
    private static String j = "local";
    private static String k = "a+";
    private Map<String, BridgeInterceptor> l = new HashMap();

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, String str) {
        startContainer(context, str, (IContainerListener) null);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, String str, IContainerListener iContainerListener) {
        startContainer(context, new ContainerParams(str), iContainerListener);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, ContainerParams containerParams) {
        startContainer(context, containerParams, (IContainerListener) null);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, ContainerParams containerParams, IContainerListener iContainerListener) {
        if (!Utils.isGriverContainerInit()) {
            ACLog.e("GriverContainerImpl", "startContainer error! AppContainer not initialized.");
        } else if (containerParams == null) {
            ACLog.e("GriverContainerImpl", "startContainer error! containerParams is null!");
        } else {
            Bundle bundle = new Bundle();
            if (containerParams.containerBundle != null) {
                bundle.putAll(containerParams.containerBundle);
            }
            String str = containerParams.appId;
            if (!TextUtils.isEmpty(str)) {
                String a2 = a(str);
                bundle.putString(GriverAdapterKeys.PARAM_PAGE_ID, a2);
                AppEventHandler.addContainerListener(a2, iContainerListener);
                Griver.openApp(context, str, bundle);
                return;
            }
            String str2 = containerParams.url;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String a3 = a(str2);
            bundle.putString(GriverAdapterKeys.PARAM_PAGE_ID, a3);
            AppEventHandler.addContainerListener(a3, iContainerListener);
            Griver.openUrl(context, str2, bundle);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerContainerListener(IContainerListener iContainerListener) {
        AppEventHandler.addContainerListener(iContainerListener);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterContainerListener(IContainerListener iContainerListener) {
        AppEventHandler.removeContainerListener(iContainerListener);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean registerPlugin(BaseContainerPlugin baseContainerPlugin) {
        synchronized (this) {
            if (baseContainerPlugin == null) {
                return false;
            }
            Iterator<String> actionIterator = baseContainerPlugin.onPrepare(new ContainerEventFilter()).actionIterator();
            while (actionIterator.hasNext()) {
                String next = actionIterator.next();
                ACLog.d("GriverContainerImpl", "registerPlugin! event == ".concat(String.valueOf(next)));
                if (!TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_STARTED) && !TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_FINISHED)) {
                    if (TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_SHOULD_OVERRIDE_URL)) {
                        InterceptUrlEventHandler.setPlugin(baseContainerPlugin);
                        Griver.registerEventHandler(new GriverEventManifest(InterceptUrlEventHandler.class.getName(), Arrays.asList(GriverInterceptUrlEvent.class.getName()), Page.class));
                    } else {
                        StringBuilder sb = new StringBuilder("unregisterPlugin error!");
                        sb.append(next);
                        sb.append(" not support.");
                        ACLog.e("GriverContainerImpl", sb.toString());
                    }
                }
                InterceptUrlEventHandler.setPlugin(baseContainerPlugin);
                Griver.registerEventHandler(new GriverEventManifest(PageHelperEventHandler.class.getName(), Arrays.asList(GriverPageHelperEvent.class.getName()), Page.class));
            }
            return true;
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterPlugin(BaseContainerPlugin baseContainerPlugin) {
        synchronized (this) {
            if (baseContainerPlugin == null) {
                return;
            }
            Iterator<String> actionIterator = baseContainerPlugin.onPrepare(new ContainerEventFilter()).actionIterator();
            while (actionIterator.hasNext()) {
                String next = actionIterator.next();
                ACLog.d("GriverContainerImpl", "unregisterPlugin! event == ".concat(String.valueOf(next)));
                if (!TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_STARTED) && !TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_FINISHED)) {
                    if (TextUtils.equals(next, ContainerEventAction.ACTION_WEB_PAGE_SHOULD_OVERRIDE_URL)) {
                        InterceptUrlEventHandler.setPlugin(null);
                    } else {
                        StringBuilder sb = new StringBuilder("unregisterPlugin error!");
                        sb.append(next);
                        sb.append(" not support.");
                        ACLog.e("GriverContainerImpl", sb.toString());
                    }
                }
                InterceptUrlEventHandler.setPlugin(null);
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void setProvider(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        ACLog.d("GriverContainerImpl", "setProvider! name == ".concat(String.valueOf(str)));
        if (str.equals(ContainerUaProvider.class.getName())) {
            Griver.registerExtension(new GriverExtensionManifest(GriverUserAgentExtension.class, new UserAgentExtensionImpl((ContainerUaProvider) obj)));
        } else if (str.equals(JsApiPermissionProvider.class.getName())) {
            Griver.registerExtension(new GriverExtensionManifest(GriverH5JSAPIPermissionExtension.class, new JSPermissionExtensionImpl((JsApiPermissionProvider) obj)));
        } else if (str.equals(ContainerUIProvider.class.getName())) {
            Griver.registerExtension(new GriverExtensionManifest(GriverACMenuExtension.class, new CustomMenuExtensionImpl((ContainerUIProvider) obj)));
        } else {
            StringBuilder sb = new StringBuilder("setProvider error!");
            sb.append(str);
            sb.append(" not support.");
            ACLog.e("GriverContainerImpl", sb.toString());
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIPlugin(final BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            if (baseJSPlugin == null) {
                return;
            }
            if (baseJSPlugin.getJsApiList() != null && baseJSPlugin.getJsApiList().size() != 0) {
                for (String str : baseJSPlugin.getJsApiList()) {
                    ACLog.d("GriverContainerImpl", "registerJSAPIPlugin! jsapi == ".concat(String.valueOf(str)));
                    BridgeInterceptorManager.getInstance().register(str, new com.alibaba.griver.api.bridge.BridgeInterceptor() { // from class: com.iap.ac.android.container.adapter.griver.GriverContainerImpl.1
                        @Override // com.alibaba.griver.api.bridge.BridgeInterceptor
                        public boolean willHandleJSAPI(String str2, BridgeInterceptor.InterceptContext interceptContext, BridgeCallback bridgeCallback) {
                            if (TextUtils.equals(str2, Constants.JS_API_TRADE_PAY) || TextUtils.equals(str2, "crossPay")) {
                                if (GriverContainerImpl.this.isMiniProgram(interceptContext.miniProgramAppID)) {
                                    if (!GriverContainerImpl.access$000(GriverContainerImpl.this, str2, interceptContext)) {
                                        return false;
                                    }
                                } else if (!TextUtils.equals(BundleUtils.getString(interceptContext.page.getStartParams(), "bizScenario"), Constants.H5Param.PARAM_SDK_FLAG)) {
                                    return false;
                                }
                            }
                            JSBridgeMessageToNative jSBridgeMessageToNative = new JSBridgeMessageToNative();
                            jSBridgeMessageToNative.func = str2;
                            jSBridgeMessageToNative.param = Utils.fastJsonToJson(interceptContext.jsParameters);
                            if (jSBridgeMessageToNative.param != null) {
                                try {
                                    jSBridgeMessageToNative.param.put("appId", interceptContext.miniProgramAppID);
                                    jSBridgeMessageToNative.param.put(GriverMonitorConstants.KEY_MONITOR_SOURCE_SITE, interceptContext.sourceSite);
                                    if (interceptContext.acParams != null) {
                                        jSBridgeMessageToNative.param.put("acMerchantId", interceptContext.acParams.get("merchantId"));
                                    }
                                } catch (JSONException e2) {
                                    ACLog.e("GriverContainerImpl", "json parse error: ", e2);
                                }
                                ACLog.i("GriverContainerImpl", jSBridgeMessageToNative.param.toString());
                            }
                            try {
                                if (TextUtils.equals(str2, com.iap.ac.android.acs.plugin.utils.Constants.JS_API_TRADE_PAY) || TextUtils.equals(str2, "crossPay")) {
                                    MonitorUtil.monitorTradePayStart(interceptContext);
                                }
                                JSONObject onJSEvent = baseJSPlugin.onJSEvent(jSBridgeMessageToNative, new GriverContainerPresenter(interceptContext.page), new GriverContainerBridgeContext(interceptContext.page, bridgeCallback));
                                if (onJSEvent != null) {
                                    if (TextUtils.equals(str2, com.iap.ac.android.acs.plugin.utils.Constants.JS_API_TRADE_PAY) || TextUtils.equals(str2, "crossPay")) {
                                        MonitorUtil.monitorTradePay(interceptContext, onJSEvent);
                                    }
                                    bridgeCallback.sendJSONResponse(Utils.jsonObjectToFastJson(onJSEvent));
                                    return true;
                                }
                                return true;
                            } catch (Exception e3) {
                                ACLog.e("GriverContainerImpl", "onJSEvent error: ", e3);
                                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                return true;
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r3, com.alibaba.griver.api.bridge.BridgeInterceptor.InterceptContext r4) {
        /*
            com.alibaba.fastjson.JSONObject r0 = r4.acParams     // Catch: org.json.JSONException -> L14
            if (r0 == 0) goto L1c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L14
            com.alibaba.fastjson.JSONObject r1 = r4.acParams     // Catch: org.json.JSONException -> L14
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch: org.json.JSONException -> L14
            r0.<init>(r1)     // Catch: org.json.JSONException -> L14
            java.lang.String r3 = com.iap.ac.android.biz.common.utils.AcBizUtils.getChannel(r0, r3)     // Catch: org.json.JSONException -> L14
            goto L1e
        L14:
            r3 = move-exception
            java.lang.String r0 = "GriverContainerImpl"
            java.lang.String r1 = "getChannel"
            com.alibaba.griver.base.common.logger.GriverLogger.e(r0, r1, r3)
        L1c:
            java.lang.String r3 = ""
        L1e:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L32
            java.lang.String r3 = r4.miniProgramAppID
            java.lang.String r0 = r4.sourceSite
            java.lang.String r2 = r4.acquireSite
            boolean r3 = com.iap.ac.android.biz.common.utils.AcBizUtils.isAcBizPay(r3, r0, r2)
            if (r3 != 0) goto L3b
            return r1
        L32:
            java.lang.String r0 = "B15"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L3b
            return r1
        L3b:
            com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager r3 = com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager.getInstance()
            java.lang.String r0 = r4.miniProgramAppID
            java.lang.String r2 = "tradePay"
            boolean r3 = r3.isDisabled(r0, r2)
            if (r3 != 0) goto L5a
            com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager r3 = com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager.getInstance()
            java.lang.String r4 = r4.miniProgramAppID
            java.lang.String r0 = "crossPay"
            boolean r3 = r3.isDisabled(r4, r0)
            if (r3 != 0) goto L5a
            r3 = 1
            return r3
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.container.adapter.griver.GriverContainerImpl.a(java.lang.String, com.alibaba.griver.api.bridge.BridgeInterceptor$InterceptContext):boolean");
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            if (baseJSPlugin == null) {
                return;
            }
            if (baseJSPlugin.getJsApiList() != null && baseJSPlugin.getJsApiList().size() != 0) {
                for (String str : baseJSPlugin.getJsApiList()) {
                    ACLog.d("GriverContainerImpl", "unregisterJSAPIPlugin! jsapi == ".concat(String.valueOf(str)));
                    BridgeInterceptorManager.getInstance().unregister(str);
                }
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean isMiniProgram(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("\\d{16}").matcher(str).matches();
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIInterceptor(String str, final com.iap.ac.android.common.container.interceptor.BridgeInterceptor bridgeInterceptor) {
        ACLog.d("GriverContainerImpl", "registerJSAPIPlugin! jsapi == ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            ACLog.e("GriverContainerImpl", "registerJSAPIInterceptor error! jsapi name is empty.");
        } else if (bridgeInterceptor == null) {
            ACLog.e("GriverContainerImpl", "registerJSAPIInterceptor error! bridgeInterceptor is null.");
        } else {
            BridgeInterceptorManager.getInstance().register(str, new com.alibaba.griver.api.bridge.BridgeInterceptor() { // from class: com.iap.ac.android.container.adapter.griver.GriverContainerImpl.2
                @Override // com.alibaba.griver.api.bridge.BridgeInterceptor
                public boolean willHandleJSAPI(String str2, BridgeInterceptor.InterceptContext interceptContext, BridgeCallback bridgeCallback) {
                    BridgeInterceptor.InterceptContext interceptContext2 = new BridgeInterceptor.InterceptContext();
                    interceptContext2.pluginId = interceptContext.pluginId;
                    interceptContext2.context = interceptContext.context;
                    interceptContext2.jsParameters = Utils.fastJsonToJson(interceptContext.jsParameters);
                    interceptContext2.miniProgramAppID = interceptContext.miniProgramAppID;
                    interceptContext2.miniProgramPageURL = interceptContext.miniProgramPageURL;
                    interceptContext2.sourceSite = interceptContext.sourceSite;
                    interceptContext2.newSourceSite = interceptContext.newSourceSite;
                    interceptContext2.acquireSite = interceptContext.acquireSite;
                    interceptContext2.acParams = Utils.fastJsonToJson(interceptContext.acParams);
                    interceptContext2.miniProgramName = interceptContext.miniProgramName;
                    interceptContext2.startParams = interceptContext.startParams;
                    ACLog.d("GriverContainerImpl", "interceptor proxy called == ".concat(String.valueOf(str2)));
                    if (TextUtils.equals(BundleUtils.getString(interceptContext.page.getStartParams(), "bizScenario"), Constants.H5Param.PARAM_SDK_FLAG) && !GriverContainerImpl.this.isMiniProgram(interceptContext.miniProgramAppID) && GriverContainerImpl.this.l != null && GriverContainerImpl.this.l.get(str2) != null) {
                        return ((com.iap.ac.android.common.container.interceptor.BridgeInterceptor) GriverContainerImpl.this.l.get(str2)).willHandleJSAPI(str2, interceptContext2, IAPBridgeCallbackAdapter.from(bridgeCallback));
                    }
                    return bridgeInterceptor.willHandleJSAPI(str2, interceptContext2, IAPBridgeCallbackAdapter.from(bridgeCallback));
                }
            });
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterJSAPIInterceptor(String str) {
        ACLog.d("GriverContainerImpl", "unregisterJSAPIInterceptor! jsapi == ".concat(String.valueOf(str)));
        BridgeInterceptorManager.getInstance().unregister(str);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerACH5JSAPIInterceptor(String str, com.iap.ac.android.common.container.interceptor.BridgeInterceptor bridgeInterceptor) {
        if (TextUtils.isEmpty(str) || bridgeInterceptor == null) {
            return;
        }
        if (this.l == null) {
            this.l = new HashMap();
        }
        this.l.put(str, bridgeInterceptor);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterACH5JSAPIInterceptor(String str) {
        Map<String, com.iap.ac.android.common.container.interceptor.BridgeInterceptor> map;
        if (TextUtils.isEmpty(str) || (map = this.l) == null) {
            return;
        }
        map.remove(str);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean isJSAPIRegistered(String str) {
        return (RVInitializer.getExtensionManager() == null || RVInitializer.getExtensionManager().findActionMeta(null, str) == null) ? false : true;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public IContainerAuth getContainerAuth() {
        return new GriverContainerAuthImpl();
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void closeApp(CloseAppParams closeAppParams) {
        if (closeAppParams == null) {
            ACLog.e("GriverContainerImpl", "closeApp error! closeAppParams is null!");
        } else {
            Griver.closeApp(closeAppParams.appId);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIPreInterceptor(BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor) {
        BridgeCallPreInterceptorHandler.registerJSAPIPreInterceptor(bridgeJSAPIPreInterceptor);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerNotFoundJSAPIInterceptor(NotFoundJSAPIInterceptor notFoundJSAPIInterceptor) {
        BridgeCallNotFoundEventHandler.registerNotFoundJSAPIInterceptor(notFoundJSAPIInterceptor);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void logEvent(String str, Map<String, String> map) {
        GriverMonitor.event(str, "GriverAppContainer", map);
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.hashCode());
        sb.append("_");
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void fetchAppInfoListByIds(List<String> list, final Callback<AppInfoListData> callback) {
        Griver.fetchAppInfoListByIds(new FetchAppsByIdsRequest(list), new OnRpcResultListener<AppInfosResult>() { // from class: com.iap.ac.android.container.adapter.griver.GriverContainerImpl.3
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(AppInfosResult appInfosResult) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onResultSuccess(DataProcessor.convertAppListResult(appInfosResult));
                }
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i2, String str) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onResultFailed(i2, str);
                }
            }
        });
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public HashMap<String, String> getGriverConfig() {
        HashMap<String, String> hashMap = new HashMap<>();
        IAPGriverConfig iAPGriverConfig = IAPGriverConfig.getInstance();
        if (iAPGriverConfig != null) {
            hashMap.put("appId", iAPGriverConfig.getAppId());
            hashMap.put(c, iAPGriverConfig.getAuthCode());
            hashMap.put(f7553a, iAPGriverConfig.getEnv());
            hashMap.put(b, iAPGriverConfig.getEnvironment());
            hashMap.put(g, iAPGriverConfig.getGatewayUrl());
            hashMap.put(f, iAPGriverConfig.getGpSignature());
            hashMap.put(d, iAPGriverConfig.getUseAmcsLite());
            hashMap.put(e, iAPGriverConfig.getUseSecurityGuard());
            hashMap.put(KEY_WORKSPACEID, iAPGriverConfig.getWorkSpaceId());
            hashMap.put(h, Griver.getAppLanguage());
        }
        return hashMap;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerAppEventHandler() {
        Griver.registerEventHandler(new GriverEventManifest(AppEventHandler.class.getName(), Collections.singletonList(GriverAppEvent.class.getName()), App.class));
        Griver.registerEventHandler(new GriverEventManifest(BridgeCallNotFoundEventHandler.class.getName(), Collections.singletonList(GriverBridgeCallNotFoundEvent.class.getName()), App.class));
        Griver.registerEventHandler(new GriverEventManifest(BridgeCallPreInterceptorHandler.class.getName(), Collections.singletonList(GriverBridgeCallPreInterceptEvent.class.getName()), App.class));
        Griver.registerEventHandler(new GriverEventManifest(GriverJSAPICallEventHandler.class.getName(), Collections.singletonList(GriverBridgeCallEvent.class.getName()), App.class));
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public String objectForKey(String str, String str2) {
        return GriverCacheManager.getInstance().getCache(str).objectForKey(str2);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void setObject(String str, String str2, String str3, long j2) {
        GriverCacheManager.getInstance().getCache(str).setObject(str2, str3, j2);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void removeObjectForKey(String str, String str2) {
        GriverCacheManager.getInstance().getCache(str).removeObjectForKey(str2);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void removeAllObjects(String str) {
        GriverCacheManager.getInstance().getCache(str).removeAllObjects();
    }

    static /* synthetic */ boolean access$000(GriverContainerImpl griverContainerImpl, String str, BridgeInterceptor.InterceptContext interceptContext) {
        if (interceptContext != null && interceptContext.jsParameters != null && interceptContext.jsParameters.containsKey(i) && (interceptContext.jsParameters.get(i) instanceof String) && interceptContext.jsParameters.getString(i).equals(k)) {
            return true;
        }
        if (interceptContext != null && interceptContext.jsParameters != null && interceptContext.jsParameters.containsKey(i) && (interceptContext.jsParameters.get(i) instanceof String) && interceptContext.jsParameters.getString(i).equals(j)) {
            return false;
        }
        return a(str, interceptContext);
    }
}
