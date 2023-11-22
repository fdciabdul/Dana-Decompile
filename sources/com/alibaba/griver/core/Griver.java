package com.alibaba.griver.core;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.jsapi.logging.RVPerfLogLifeCycleExtension;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.api.cache.H5WebViewCacheExtension;
import com.alibaba.griver.api.common.GriverExtensionManifest;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.api.common.env.GriverVerifyPublicKeyProxy;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverErrors;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.api.resource.appinfo.AppInfoConstants;
import com.alibaba.griver.api.resource.preset.GriverResourcePresetProxy;
import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.AbstractPriorityRunnable;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.DebugMonitor;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.base.common.utils.StartupParamsUtils;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.resource.GriverResourceManager;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAppInfoStorage;
import com.alibaba.griver.base.resource.offline.GriverOfflinePkgManager;
import com.alibaba.griver.base.resource.predownload.AppPreDownloadManager;
import com.alibaba.griver.base.resource.preset.GriverResourcePreset;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import com.alibaba.griver.core.bridge.GriverBridgeManifest;
import com.alibaba.griver.core.kernel.ipc.client.BizIpcMessageHandler;
import com.alibaba.griver.core.liteprocess.LiteProcessHandler;
import com.alibaba.griver.core.liteprocess.LiteProcessManager;
import com.alibaba.griver.core.model.applist.AppInfosResult;
import com.alibaba.griver.core.model.applist.FetchAppsByIdsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsRequest;
import com.alibaba.griver.core.point.GriverEventManifest;
import com.alibaba.griver.core.preload.PreloadInitializer;
import com.alibaba.griver.core.rpc.MiniProgramProcessor;
import com.alibaba.griver.core.update.GriverIpcMessageConstants;
import com.alibaba.griver.core.utils.ExtensionRegistryUtils;
import com.alibaba.griver.core.vo.FetchAppRequestVO;
import com.alibaba.griver.core.worker.WorkerPool;
import com.alibaba.griver.h5.GriverH5;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import id.dana.danah5.DanaH5Key;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Griver {

    /* renamed from: a */
    private static boolean f6390a;
    private static GriverInitializeCallback b;

    private static void a() {
        List<ExtensionMetaInfo> extensions;
        RVManifest projectManifest = RVInitializer.getProjectManifest();
        if (projectManifest == null || (extensions = projectManifest.getExtensions()) == null) {
            return;
        }
        for (ExtensionMetaInfo extensionMetaInfo : extensions) {
            if (extensionMetaInfo.extensionClass.equals(RVPerfLogLifeCycleExtension.class.getName()) && extensionMetaInfo.filter != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = extensionMetaInfo.filter.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                if (!arrayList.contains("com.alibaba.ariver.app.api.point.page.ShouldLoadUrlResultPoint")) {
                    arrayList.add("com.alibaba.ariver.app.api.point.page.ShouldLoadUrlResultPoint");
                }
                extensionMetaInfo.filter = arrayList;
                return;
            }
        }
    }

    public static void initialize(final Application application, final GriverConfiguration griverConfiguration, GriverInitializeCallback griverInitializeCallback) {
        synchronized (Griver.class) {
            if (f6390a) {
                a((int) GriverErrors.INITIALIZE_EXCEPTION, "Repeated initialization");
                return;
            }
            b = griverInitializeCallback;
            GriverEnv.setApplication(application);
            if (griverConfiguration == null) {
                a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "GriverConfiguration is null");
                return;
            }
            if (!TextUtils.isEmpty(griverConfiguration.getAppId()) && !TextUtils.isEmpty(griverConfiguration.getWorkSpaceId())) {
                if (!TextUtils.isEmpty(griverConfiguration.getWebSocketURLPrefixForDebug())) {
                    GriverConfigConstants.insideStringConfig.put(GriverConfigConstants.KEY_WEBSOCKET_HOST_URL, griverConfiguration.getWebSocketURLPrefixForDebug());
                }
                GriverEnv.setAppId(griverConfiguration.getAppId());
                GriverEnv.setWorkSpaceId(griverConfiguration.getWorkSpaceId());
                GriverEnv.setGateway(griverConfiguration.getGateway());
                try {
                    RVInitializer.init(application);
                    a();
                    ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new LiteProcessHandler());
                    if (ProcessUtils.isTinyProcess()) {
                        ClientMsgReceiver.getInstance().registerBizHandler(GriverIpcMessageConstants.BIZ_CODE, new BizIpcMessageHandler());
                    }
                    if (!TextUtils.isEmpty(griverConfiguration.getAppendUserAgent())) {
                        GriverWebviewSetting.setUserAgent(griverConfiguration.getAppendUserAgent());
                    }
                    if (!TextUtils.isEmpty(griverConfiguration.getPresetPackagePath())) {
                        GriverResourcePreset.setGriverResourcePresetProxy(new GriverResourcePresetProxy() { // from class: com.alibaba.griver.core.Griver.1
                            @Override // com.alibaba.griver.api.resource.preset.GriverResourcePresetProxy
                            public final String getPresetResourcePath() {
                                return griverConfiguration.getPresetPackagePath();
                            }
                        });
                    }
                    GriverResourcePreset.savePresetConfiguration();
                    d();
                    GriverH5.preInstallH5Auto();
                    if (!TextUtils.isEmpty(griverConfiguration.getVerifyPackagePublicKey())) {
                        GriverEnv.setVerifyPublicKeyProxy(new GriverVerifyPublicKeyProxy() { // from class: com.alibaba.griver.core.Griver.2
                            @Override // com.alibaba.griver.api.common.env.GriverVerifyPublicKeyProxy
                            public final String getPublicKey() {
                                return griverConfiguration.getVerifyPackagePublicKey();
                            }
                        });
                    }
                    GriverPageConfiguration pageConfiguration = griverConfiguration.getPageConfiguration();
                    if (pageConfiguration != null) {
                        if (!TextUtils.isEmpty(pageConfiguration.statusPageURL)) {
                            ErrorPageUtils.setStatusErrorPage(pageConfiguration.statusPageURL);
                        }
                        if (!TextUtils.isEmpty(pageConfiguration.errorPageURL)) {
                            ErrorPageUtils.setH5ErrorPage(pageConfiguration.errorPageURL);
                        }
                    }
                    b();
                    c();
                    AppPreDownloadManager.start(application);
                    PreloadInitializer.init();
                    GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.core.Griver.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            GriverOfflinePkgManager.getInstance(application).cleanPkg();
                        }
                    });
                    GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.core.Griver.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            WorkerPool.getInstance().asyncCreateWorkerInPool();
                        }
                    }, 5L, TimeUnit.SECONDS);
                    ((H5WebViewCacheExtension) RVProxy.get(H5WebViewCacheExtension.class)).presetEntry();
                    RVProxy.setPrinter(new RVProxy.Printer() { // from class: com.alibaba.griver.core.Griver.5
                        @Override // com.alibaba.ariver.kernel.common.RVProxy.Printer
                        public final void print(String str) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("RVProxy: ");
                            sb.append(str);
                            GriverLogger.d("Griver", sb.toString());
                        }
                    });
                    return;
                } catch (Exception unused) {
                    a((int) GriverErrors.INITIALIZE_EXCEPTION, "Initialization exception");
                    return;
                }
            }
            a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "Missing necessary param");
        }
    }

    private static void b() {
        if (ProcessUtils.isMainProcess() || Build.VERSION.SDK_INT < 28) {
            return;
        }
        String processName = ProcessUtils.getProcessName();
        if (ProcessUtils.isTinyProcess()) {
            WebView.setDataDirectorySuffix(processName);
        }
    }

    public static boolean alreadyInitialized() {
        boolean z;
        synchronized (Griver.class) {
            z = f6390a;
        }
        return z;
    }

    @Deprecated
    public static void openUrl(Context context, String str, Bundle bundle) {
        synchronized (Griver.class) {
            openUrl(context, str, bundle, null);
        }
    }

    public static void openUrl(Context context, String str, Bundle bundle, GriverContainerAPICallBack griverContainerAPICallBack) {
        String[] split;
        synchronized (Griver.class) {
            if (a(griverContainerAPICallBack, context)) {
                try {
                    Uri parse = Uri.parse(str);
                    if (!parse.getQueryParameterNames().contains("_ariver_appid")) {
                        if (TextUtils.isEmpty(parse.getScheme())) {
                            a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                            GriverLogger.w("Griver", "invalid url scheme");
                            return;
                        }
                        GriverH5.openUrl(context, parse.toString(), bundle);
                        return;
                    }
                    String queryParameter = parse.getQueryParameter("_ariver_appid");
                    if (TextUtils.isEmpty(queryParameter)) {
                        a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                        RVLogger.e("Griver", "appId is empty");
                        return;
                    }
                    Bundle filterBundle = StartupParamsUtils.filterBundle(queryParameter, str, bundle);
                    String queryParameter2 = parse.getQueryParameter("_ariver_path");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        filterBundle.putString("page", Uri.decode(queryParameter2));
                        filterBundle.putString("url", "/index.html#");
                    }
                    filterBundle.putString(AppInfoConstants.ARIVER_TOKEN, parse.getQueryParameter("_ariver_token"));
                    String queryParameter3 = parse.getQueryParameter("_ariver_version");
                    String queryParameter4 = parse.getQueryParameter("_ariver_source");
                    String queryParameter5 = parse.getQueryParameter("titleAlignment");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        filterBundle.putString("titleAlignment", queryParameter5);
                    }
                    if (!filterBundle.containsKey("query")) {
                        String queryParameter6 = parse.getQueryParameter("query");
                        if (!TextUtils.isEmpty(queryParameter6)) {
                            filterBundle.putString("query", Uri.decode(queryParameter6));
                        }
                    }
                    if (TextUtils.equals(queryParameter4, com.alibaba.exthub.BuildConfig.BUILD_TYPE)) {
                        filterBundle.putString(AppInfoScene.PARAM_SOURCE, queryParameter4);
                        String queryParameter7 = parse.getQueryParameter("_ariver_scene");
                        if (!TextUtils.isEmpty(queryParameter3)) {
                            filterBundle.putString(AppInfoScene.PARAM_SCENE_VERSION, queryParameter3);
                        }
                        filterBundle.putString(AppInfoScene.PARAM_SCENE, queryParameter7);
                        if (TextUtils.equals(queryParameter7, AppInfoScene.DEBUG.name())) {
                            String queryParameter8 = parse.getQueryParameter("_ariver_channelid");
                            String queryParameter9 = parse.getQueryParameter("channelId");
                            if (TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                                RVLogger.e("Griver", "channelId and _ariver_channelid are both empty");
                                a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                                return;
                            }
                            filterBundle.putString("_ariver_channelid", TextUtils.isEmpty(queryParameter8) ? queryParameter9 : queryParameter8);
                            if (!TextUtils.isEmpty(queryParameter9)) {
                                queryParameter8 = queryParameter9;
                            }
                            filterBundle.putString("channelId", queryParameter8);
                            filterBundle.putString("isRemoteDebug", parse.getQueryParameter("isRemoteDebug"));
                            filterBundle.putString("isRemoteX", parse.getQueryParameter("isRemoteX"));
                            filterBundle.putString(GriverParam.TYRO_ID, parse.getQueryParameter(GriverParam.TYRO_ID));
                            filterBundle.putString(GriverParam.REMOTE_CH, parse.getQueryParameter(GriverParam.REMOTE_CH));
                        }
                    } else if (!TextUtils.isEmpty(queryParameter3)) {
                        filterBundle.putString(RVStartParams.LONG_NB_VERSION, queryParameter3);
                    }
                    String queryParameter10 = parse.getQueryParameter("channel");
                    String queryParameter11 = parse.getQueryParameter(GriverParam.SUB_CHANNEL);
                    String queryParameter12 = parse.getQueryParameter("sourceInfo");
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(queryParameter12) && (split = URLDecoder.decode(queryParameter12).split(ContainerUtils.FIELD_DELIMITER)) != null && split.length > 0) {
                        for (String str2 : split) {
                            String[] split2 = str2.split("=");
                            try {
                                hashMap.put(split2[0], split2[1]);
                            } catch (Exception e) {
                                GriverLogger.e("Griver", e.getMessage());
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(queryParameter10)) {
                        hashMap.put("channel", queryParameter10);
                    }
                    if (!TextUtils.isEmpty(queryParameter11)) {
                        hashMap.put(GriverParam.SUB_CHANNEL, queryParameter11);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (String str3 : hashMap.keySet()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str3);
                        sb2.append("=");
                        sb2.append((String) hashMap.get(str3));
                        sb2.append(ContainerUtils.FIELD_DELIMITER);
                        sb.append(sb2.toString());
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        String substring = sb.substring(0, sb.length() - 1);
                        filterBundle.putString("sourceInfo", URLDecoder.decode(substring));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("sourceInfo encode result = ");
                        sb3.append(URLDecoder.decode(substring));
                        GriverLogger.d("Griver", sb3.toString());
                    } else {
                        GriverLogger.d("Griver", "sourceInfo is null");
                    }
                    String queryParameter13 = parse.getQueryParameter("_ariver_event");
                    if (!TextUtils.isEmpty(queryParameter13)) {
                        filterBundle.putString("_ariver_event", queryParameter13);
                    }
                    a(context, queryParameter, filterBundle, false, griverContainerAPICallBack);
                } catch (Exception e2) {
                    ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APP_LIFE_INVALID_URL).append("url", str).build());
                    RVLogger.e("Griver", "parse url failed", e2);
                    a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_NOT_UNKNOWN);
                }
            }
        }
    }

    @Deprecated
    public static void openApp(Context context, String str, Bundle bundle) {
        synchronized (Griver.class) {
            a(context, str, bundle, true, null);
        }
    }

    public static void openApp(Context context, String str, Bundle bundle, GriverContainerAPICallBack griverContainerAPICallBack) {
        synchronized (Griver.class) {
            a(context, str, bundle, true, griverContainerAPICallBack);
        }
    }

    private static void a(Context context, final String str, Bundle bundle, boolean z, GriverContainerAPICallBack griverContainerAPICallBack) {
        Bundle bundle2;
        synchronized (Griver.class) {
            if (a(griverContainerAPICallBack, context)) {
                if (!Pattern.matches("^\\d{16}", str)) {
                    ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APP_LIFE_INVALID_APP_ID).append("appId", str).build());
                }
                if (z) {
                    bundle2 = StartupParamsUtils.filterBundle(str, "", bundle);
                } else {
                    bundle2 = new Bundle(bundle);
                }
                if (TextUtils.isEmpty(BundleUtils.getString(bundle2, "sourceInfo", ""))) {
                    String string = bundle2.getString("referrerInfo");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            String string2 = JSON.parseObject(string).getJSONObject("extraData").getString("sourceInfo");
                            if (!TextUtils.isEmpty(string2)) {
                                bundle2.putString("sourceInfo", URLDecoder.decode(string2));
                            }
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("phrase source info error ");
                            sb.append(e.getMessage());
                            GriverLogger.e("Griver", sb.toString());
                        }
                    }
                }
                bundle2.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
                DebugMonitor.reset();
                GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.core.Griver.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        GriverAppInfoStorage.queryAllAppInfo(str);
                    }
                });
                RVMain.startApp(context, str, bundle2, null);
            }
        }
    }

    public static void createFragment4Url(Context context, String str, Bundle bundle, GriverCreateFragmentCallBack griverCreateFragmentCallBack) {
        synchronized (Griver.class) {
            if (a(griverCreateFragmentCallBack, context, str)) {
                if (bundle == null) {
                    try {
                        bundle = new Bundle();
                    } catch (Throwable unused) {
                        a(griverCreateFragmentCallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                    }
                }
                bundle.putBoolean(GriverLaunchParams.CREATE_FRAGMENT, true);
                bundle.putBoolean("showTitleBar", false);
                Uri parse = Uri.parse(str);
                if (!parse.getQueryParameterNames().contains("_ariver_appid")) {
                    if (TextUtils.isEmpty(parse.getScheme())) {
                        a(griverCreateFragmentCallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                        GriverLogger.w("Griver", "invalid url scheme");
                        return;
                    }
                    GriverH5.createFragment(context, parse.toString(), bundle, griverCreateFragmentCallBack);
                } else {
                    a(griverCreateFragmentCallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                }
            }
        }
    }

    public static void closeApp(String str) {
        synchronized (Griver.class) {
            if (!TextUtils.isEmpty(str)) {
                LiteProcessManager.getInstance().closeApp(str);
            } else {
                LiteProcessManager.getInstance().closeAllApp();
            }
        }
    }

    public static void fetchApps(FetchAppRequestVO fetchAppRequestVO, OnRpcResultListener onRpcResultListener) {
        synchronized (Griver.class) {
            fetchApps(new FetchAppsRequest(fetchAppRequestVO), onRpcResultListener);
        }
    }

    @Deprecated
    public static void fetchApps(FetchAppsRequest fetchAppsRequest, OnRpcResultListener onRpcResultListener) {
        synchronized (Griver.class) {
            if (!f6390a) {
                ACLog.e("Griver", "Please initialize Griver first!");
                if (onRpcResultListener != null) {
                    onRpcResultListener.onResultFailed(3, "Please initialize Griver first!");
                }
                return;
            }
            new MiniProgramProcessor().fetchApps(fetchAppsRequest, onRpcResultListener);
        }
    }

    public static void fetchAppInfoListByIds(FetchAppsByIdsRequest fetchAppsByIdsRequest, OnRpcResultListener<AppInfosResult> onRpcResultListener) {
        synchronized (Griver.class) {
            if (!f6390a) {
                ACLog.e("Griver", "Please initialize Griver first!");
                if (onRpcResultListener != null) {
                    onRpcResultListener.onResultFailed(3, "Please initialize Griver first!");
                }
                return;
            }
            new MiniProgramProcessor().fetchAppInfosByIds(fetchAppsByIdsRequest.getAppIdList(), fetchAppsByIdsRequest.getCategory(), onRpcResultListener);
        }
    }

    @Deprecated
    public static void registerEventHandler(GriverEventManifest griverEventManifest) {
        registerEventHandler(griverEventManifest, null);
    }

    public static void registerEventHandler(GriverEventManifest griverEventManifest, GriverContainerAPICallBack griverContainerAPICallBack) {
        if (a(griverContainerAPICallBack, griverEventManifest)) {
            ExtensionMetaInfo convert = ExtensionRegistryUtils.convert(griverEventManifest);
            if (convert != null) {
                RVInitializer.getExtensionManager().getExtensionRegistry().register(convert);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(JSON.toJSONString(griverEventManifest.getEventClassNames()));
            sb.append("===");
            sb.append(griverEventManifest.getHandlerClassName());
            sb.append("===");
            sb.append(griverEventManifest.getScope().getSimpleName());
            GriverLogger.d("Griver", sb.toString());
        }
    }

    @Deprecated
    public static void registerBridge(GriverBridgeManifest griverBridgeManifest) {
        registerBridge(griverBridgeManifest, null);
    }

    public static void registerBridge(GriverBridgeManifest griverBridgeManifest, GriverContainerAPICallBack griverContainerAPICallBack) {
        if (a(griverContainerAPICallBack, griverBridgeManifest)) {
            if (TextUtils.isEmpty(griverBridgeManifest.getClassName()) || griverBridgeManifest.getActionList() == null || griverBridgeManifest.getActionList().size() == 0) {
                a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                GriverLogger.w("Griver", "register jsapi failed because of illegal param of bridge manifest");
            } else if (!ReflectUtils.classExist(griverBridgeManifest.getClassName())) {
                a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                StringBuilder sb = new StringBuilder();
                sb.append("register jsapi failed because class: ");
                sb.append(griverBridgeManifest.getClassName());
                sb.append(" can not be loaded");
                GriverLogger.w("Griver", sb.toString());
            } else {
                String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_SYSTEM_BRIDGE_LIST, "");
                List arrayList = new ArrayList();
                if (!TextUtils.isEmpty(config)) {
                    arrayList = (List) JSONObject.parseObject(config, new TypeReference<List<String>>() { // from class: com.alibaba.griver.core.Griver.7
                    }, new Feature[0]);
                }
                if (arrayList != null && arrayList.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    for (String str : griverBridgeManifest.getActionList()) {
                        if (!arrayList.contains(str)) {
                            linkedList.add(str);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to register reserved JSAPI: ");
                            sb2.append(str);
                            GriverLogger.w("Griver", sb2.toString());
                            GriverMonitor.error(GriverMonitorConstants.ERROR_REPEATED_JSAPI_REGISTER, "GriverAppContainer", new MonitorMap.Builder().apiName(str).build());
                        }
                    }
                    griverBridgeManifest.setActionList(linkedList);
                }
                if (griverBridgeManifest.getActionList() == null || griverBridgeManifest.getActionList().size() == 0) {
                    a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                } else {
                    RVInitializer.getExtensionManager().getExtensionRegistry().register(new ExtensionMetaInfo(griverBridgeManifest.getPackageName(), griverBridgeManifest.getClassName(), griverBridgeManifest.getActionList(), (Class<? extends Scope>) null, ExtensionType.BRIDGE, true));
                }
            }
        }
    }

    @Deprecated
    public static void registerExtension(GriverExtensionManifest griverExtensionManifest) {
        registerExtension(griverExtensionManifest, null);
    }

    public static void registerExtension(GriverExtensionManifest griverExtensionManifest, GriverContainerAPICallBack griverContainerAPICallBack) {
        if (a(griverContainerAPICallBack, griverExtensionManifest)) {
            if (griverExtensionManifest.getExtensionClass() == null || griverExtensionManifest.getExtensionImpl() == null) {
                a(griverContainerAPICallBack, GriverErrors.GRV_CONTAINER_API_ERROR_PARAM);
                GriverLogger.e("Griver", "registerExtension failed because of param is null");
                return;
            }
            RVProxy.set(griverExtensionManifest.getExtensionClass(), griverExtensionManifest.getExtensionImpl());
            StringBuilder sb = new StringBuilder();
            sb.append(griverExtensionManifest.getExtensionClass().getSimpleName());
            sb.append(">>>");
            sb.append(griverExtensionManifest.getExtensionImpl().getClass().getName());
            GriverLogger.d("Griver", sb.toString());
        }
    }

    private static void c() {
        f6390a = true;
        GriverInitializeCallback griverInitializeCallback = b;
        if (griverInitializeCallback != null) {
            griverInitializeCallback.onInitializedSuccess();
        }
    }

    private static void a(int i, String str) {
        GriverInitializeCallback griverInitializeCallback = b;
        if (griverInitializeCallback != null) {
            griverInitializeCallback.onInitializeFailed(i, str);
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.code(String.valueOf(i)).message(str);
        GriverMonitor.error(GriverMonitorConstants.ERROR_INIT_CONTAINER, "GriverAppContainer", builder.build());
    }

    private static void d() {
        if (!ProcessUtils.isMainProcess()) {
            GriverLogger.d("Griver", "do not pre install mini in non-main process");
        } else {
            a(GriverConfig.getSectionConfigWithListener("mini", new GriverConfigProxy.OnSectionConfigChangeListener() { // from class: com.alibaba.griver.core.Griver.8
                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnSectionConfigChangeListener
                public final void onChange(JSONObject jSONObject) {
                    Griver.a(jSONObject);
                }
            }));
        }
    }

    public static void a(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            GriverLogger.d("Griver", "config is null, return directly");
        } else {
            GriverExecutors.getSingleOrderThreadExecutorByName("saveConfiguration").execute(new AbstractPriorityRunnable(10) { // from class: com.alibaba.griver.core.Griver.9
                @Override // com.alibaba.griver.base.common.executor.AbstractPriorityRunnable
                public final void runTask() {
                    GriverLogger.d("Griver", "start to install configuration");
                    GriverResourceManager.saveConfiguration(GriverResourceManager.parseAppInfoFromJSONString(JSON.toJSONString(jSONObject)), false);
                }
            });
        }
    }

    public static String getAppLanguage() {
        return ((GriverAppLanguageExtension) RVProxy.get(GriverAppLanguageExtension.class)).getAppLanguage();
    }

    @Deprecated
    public static String getUtdid(Context context) {
        return getUtdid(context, null);
    }

    public static String getUtdid(Context context, GriverContainerAPICallBack griverContainerAPICallBack) {
        return a(griverContainerAPICallBack, context) ? GriverEnv.getUtdid(context) : "";
    }

    private static boolean a(GriverContainerAPICallBack griverContainerAPICallBack, Object... objArr) {
        Pair<Integer, String> pair;
        if (f6390a) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        pair = GriverErrors.GRV_CONTAINER_API_ERROR_PARAM;
                        break;
                    }
                }
            }
            pair = null;
        } else {
            pair = GriverErrors.GRV_CONTAINER_NOT_INITIALIZED;
        }
        a(griverContainerAPICallBack, pair);
        return pair == null;
    }

    private static void a(GriverContainerAPICallBack griverContainerAPICallBack, Pair<Integer, String> pair) {
        if (pair != null && !TextUtils.isEmpty((CharSequence) pair.second)) {
            StringBuilder sb = new StringBuilder();
            sb.append(pair.first);
            sb.append((String) pair.second);
            GriverLogger.e("Griver", sb.toString());
        }
        if (griverContainerAPICallBack == null || pair == null) {
            return;
        }
        griverContainerAPICallBack.error(((Integer) pair.first).intValue(), (String) pair.second);
    }
}
