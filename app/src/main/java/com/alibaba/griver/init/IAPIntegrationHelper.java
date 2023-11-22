package com.alibaba.griver.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverExtensionManifest;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverErrors;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.base.common.config.GriverAmcsLiteConfig;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.constants.AMCSConstants;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.env.DefaultConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.rpc.GriverRpcExtension;
import com.alibaba.griver.base.common.utils.KitUtils;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.GriverInitializeCallback;
import com.alibaba.griver.init.config.AmcsLiteManager;
import com.alibaba.griver.init.monitor.LogLiteManager;
import com.alibaba.griver.init.rpc.GriverRpcExtensionImpl;
import com.alibaba.griver.init.rpc.GriverRpcUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alipay.iap.android.common.securityprofiles.extractor.ProfileExtractor;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.member.MemberInfoResult;
import com.alipay.iap.android.wallet.acl.member.MemberService;
import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.account.IUserInfoManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.resource.ConfigResourceUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class IAPIntegrationHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6642a;
    private static GriverInitializeCallback b;
    private static Application c;
    private static String d;

    public static void init(Application application, IAPIntegrationConfiguration iAPIntegrationConfiguration, GriverInitializeCallback griverInitializeCallback) {
        IAPConfig iAPGriverConfig;
        DefaultConfig defaultConfig;
        synchronized (IAPIntegrationHelper.class) {
            b = griverInitializeCallback;
            if (application == null) {
                a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "application is null");
            } else if (iAPIntegrationConfiguration == null) {
                a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "Missing all necessary param");
            } else {
                c = application;
                iAPIntegrationConfiguration.setEnv("PROD");
                iAPIntegrationConfiguration.setGatewayUrl("https://imgs-ac.alipay.com/imgw.htm");
                long currentTimeMillis = System.currentTimeMillis();
                String readFullConfig = ConfigResourceUtils.readFullConfig(application, iAPIntegrationConfiguration.getAppId(), "mp_config");
                if (!TextUtils.isEmpty(readFullConfig)) {
                    iAPGriverConfig = IAPGriverConfig.getInstance();
                    JSONObject parseObject = JSON.parseObject(readFullConfig);
                    if (parseObject != null) {
                        String string = JSONUtils.getString(parseObject, "appId", "");
                        if (!TextUtils.isEmpty(string)) {
                            iAPGriverConfig.setAppId(string);
                        }
                        String string2 = JSONUtils.getString(parseObject, "workspaceId", "");
                        if (!TextUtils.isEmpty(string2)) {
                            iAPGriverConfig.setWorkSpaceId(string2);
                        }
                        String string3 = JSONUtils.getString(parseObject, "verifyPackagePublicKey", "");
                        if (!TextUtils.isEmpty(string3)) {
                            iAPGriverConfig.setVerifyPackagePublicKey(string3);
                        }
                        String string4 = JSONUtils.getString(parseObject, "appName", "");
                        if (!TextUtils.isEmpty(string4)) {
                            GriverEnv.setAppName(string4);
                        }
                        String string5 = JSONUtils.getString(parseObject, "defaultConfig", "");
                        if (!TextUtils.isEmpty(string5) && (defaultConfig = (DefaultConfig) JSON.parseObject(string5, DefaultConfig.class)) != null) {
                            GriverEnv.setDefaultConfig(defaultConfig);
                        }
                    }
                } else {
                    iAPGriverConfig = !TextUtils.isEmpty(IAPGriverConfig.getInstance().getAppId()) ? IAPGriverConfig.getInstance() : a(application);
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getAppId())) {
                    GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.init.IAPIntegrationHelper.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class, true);
                            if (griverAllRecordsExtension != null) {
                                griverAllRecordsExtension.addRecord(new Record.Builder(RecordError.ERROR_INITIALIZE_NO_APP_ID).build());
                            }
                        }
                    }, 2L, TimeUnit.SECONDS);
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getWorkSpaceId())) {
                    GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.init.IAPIntegrationHelper.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
                            if (griverAllRecordsExtension != null) {
                                griverAllRecordsExtension.addRecord(new Record.Builder(RecordError.ERROR_INITIALIZE_NO_WORKSPACE_ID).build());
                            }
                        }
                    }, 2L, TimeUnit.SECONDS);
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getVerifyPackagePublicKey())) {
                    GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.init.IAPIntegrationHelper.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
                            if (griverAllRecordsExtension != null) {
                                griverAllRecordsExtension.addRecord(new Record.Builder("103").append(RecordError.KEY_CURRENT_KEY, " ").build());
                            }
                        }
                    }, 2L, TimeUnit.SECONDS);
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getAppId())) {
                    iAPGriverConfig.setAppId(iAPIntegrationConfiguration.getAppId());
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getWorkSpaceId())) {
                    iAPGriverConfig.setWorkSpaceId(iAPIntegrationConfiguration.getWorkSpaceId());
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getEnv())) {
                    iAPGriverConfig.setEnv(iAPIntegrationConfiguration.getEnv());
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getAppendUserAgent())) {
                    iAPGriverConfig.setAppendUserAgent(iAPIntegrationConfiguration.getAppendUserAgent());
                }
                if (!TextUtils.isEmpty(iAPGriverConfig.getGatewayUrl())) {
                    iAPIntegrationConfiguration.setGatewayUrl(iAPGriverConfig.getGatewayUrl());
                }
                if (!TextUtils.isEmpty(iAPGriverConfig.getEnvironment())) {
                    GriverEnv.setEnvironment(iAPGriverConfig.getEnvironment().toLowerCase());
                }
                GriverEnv.setAlwaysShowDiagnosticTool(iAPGriverConfig.getAlwaysShowDiagnosticTool());
                if (iAPGriverConfig.getExtra() == null) {
                    iAPGriverConfig.setExtra(iAPIntegrationConfiguration);
                }
                if (TextUtils.isEmpty(iAPGriverConfig.getAppId())) {
                    a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "Missing necessary param(appId)");
                } else if (TextUtils.isEmpty(iAPGriverConfig.getWorkSpaceId())) {
                    a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "Missing necessary param(workSpaceId)");
                } else if (TextUtils.isEmpty(iAPGriverConfig.getEnv())) {
                    a((int) GriverErrors.INITIALIZE_ERROR_PARAM, "Missing necessary param(env)");
                } else {
                    if (TextUtils.isEmpty(iAPGriverConfig.getExtra().getGatewayUrl())) {
                        iAPGriverConfig.getExtra().setGatewayUrl("https://imgs-ac.alipay.com/imgw.htm");
                    }
                    if (TextUtils.isEmpty(iAPGriverConfig.getExtra().getLogProductId())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(iAPGriverConfig.getAppId());
                        sb.append("_ANDROID-");
                        sb.append(iAPGriverConfig.getEnv().toUpperCase());
                        iAPGriverConfig.getExtra().setLogProductId(sb.toString());
                    }
                    if (TextUtils.isEmpty(iAPGriverConfig.getExtra().getLogUploadURL())) {
                        iAPGriverConfig.getExtra().setLogUploadURL(com.iap.ac.android.biz.common.BuildConfig.GATEWAY_LOG_PROD);
                    }
                    if (TextUtils.isEmpty(iAPGriverConfig.getVerifyPackagePublicKey())) {
                        ACLog.w("IAPIntegrationHelper", "Verify package public key is not in config");
                        try {
                            String extraData = getExtraData(iAPGriverConfig, "verifyPackagePublicKey");
                            if (TextUtils.isEmpty(extraData)) {
                                ACLog.w("IAPIntegrationHelper", "Verify package public key is not in security guard");
                            } else {
                                iAPGriverConfig.setVerifyPackagePublicKey(extraData);
                            }
                        } catch (Throwable th) {
                            ACLog.d("IAPIntegrationHelper", "read security guard failed", th);
                        }
                    }
                    a();
                    ACLog.d("IAPIntegrationHelper", JSON.toJSONString(iAPGriverConfig));
                    iAPGriverConfig.setGateway(iAPGriverConfig.getExtra().getGatewayUrl());
                    GriverRpcUtils.init(application, iAPGriverConfig);
                    if (a(iAPGriverConfig)) {
                        if (ReflectUtils.classExist("com.iap.ac.android.loglite.api.AnalyticsConfig")) {
                            try {
                                LogLiteManager.init(application, iAPGriverConfig);
                                if (isDebuggable()) {
                                    try {
                                        Class<?> cls = Class.forName("com.alipay.wallet.profiler.core.ProfilerMgr");
                                        cls.getDeclaredMethod(IAPSyncCommand.COMMAND_INIT, Application.class).invoke(cls.getDeclaredMethod("get", new Class[0]).invoke(cls, new Object[0]), c);
                                    } catch (Exception unused) {
                                        ACLog.e("IAPIntegrationHelper", "reflect to use FELIX FAILED");
                                    }
                                }
                                Griver.initialize(application, iAPGriverConfig, griverInitializeCallback);
                                a(application, iAPGriverConfig);
                                if (isDebuggable()) {
                                    try {
                                        Class<?> cls2 = Class.forName("com.alipay.wallet.profiler.core.ProfilerMgr");
                                        cls2.getDeclaredMethod("postInit", Application.class).invoke(cls2.getDeclaredMethod("get", new Class[0]).invoke(cls2, new Object[0]), c);
                                    } catch (Exception unused2) {
                                        ACLog.e("IAPIntegrationHelper", "reflect to use FELIX FAILED");
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("init Griver success, timeCost=");
                                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                                ACLog.d("IAPIntegrationHelper", sb2.toString());
                                return;
                            } catch (Exception unused3) {
                                a((int) GriverErrors.INITIALIZE_EXCEPTION, "Init log failed.");
                                return;
                            }
                        }
                        a((int) GriverErrors.INITIALIZE_EXCEPTION, "Log SDK is not exist.");
                    }
                }
            }
        }
    }

    private static void a() {
        try {
            b();
            IUserInfoManager iUserInfoManager = new IUserInfoManager() { // from class: com.alibaba.griver.init.IAPIntegrationHelper.4
                @Override // com.iap.ac.android.common.account.IUserInfoManager
                public final boolean setUserInfo(ACUserInfo aCUserInfo) {
                    return false;
                }

                @Override // com.iap.ac.android.common.account.IUserInfoManager
                public final ACUserInfo getUserInfo() {
                    IAPIntegrationHelper.b();
                    if (!TextUtils.isEmpty(IAPIntegrationHelper.d)) {
                        ACUserInfo aCUserInfo = new ACUserInfo();
                        aCUserInfo.openId = IAPIntegrationHelper.d;
                        return aCUserInfo;
                    }
                    return new ACUserInfo();
                }

                @Override // com.iap.ac.android.common.account.IUserInfoManager
                public final String getOpenId() {
                    IAPIntegrationHelper.b();
                    if (TextUtils.isEmpty(IAPIntegrationHelper.d)) {
                        return null;
                    }
                    return IAPIntegrationHelper.d;
                }
            };
            ACUserInfoManager.setUserInfoManager(iUserInfoManager);
            ACUserInfoManager.setUserInfoManager(iUserInfoManager, "GriverAppContainer");
        } catch (Exception e) {
            ACLog.e("IAPIntegrationHelper", "try to set userId to common failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        try {
            ((MemberService) WalletServiceManager.getInstance().getService(MemberService.class)).getMemberInfo(MemberService.MemberInfoFetchStrategy.LOCAL_USER_ID_ONLY, null, null, new Callback<MemberInfoResult>() { // from class: com.alibaba.griver.init.IAPIntegrationHelper.5
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public final void result(MemberInfoResult memberInfoResult) {
                    if (memberInfoResult != null && memberInfoResult.memberInfo != null) {
                        String unused = IAPIntegrationHelper.d = memberInfoResult.memberInfo.userId;
                    } else {
                        ACLog.e("IAPIntegrationHelper", "userId not implemented in wallet API");
                    }
                }
            });
        } catch (Exception e) {
            ACLog.e("IAPIntegrationHelper", "try to set userId to common failed", e);
        }
    }

    private static IAPConfig a(Application application) {
        IAPConfig iAPConfig = (IAPConfig) JSON.parseObject(KitUtils.getAssetContent(application, GriverBaseConstants.GRIVER_CONFIG_ASSET_PATH), IAPConfig.class);
        if (iAPConfig == null) {
            return new IAPConfig();
        }
        IAPGriverConfig.getInstance().refreshConfig(iAPConfig);
        return iAPConfig;
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

    private static void a(Application application, IAPConfig iAPConfig) {
        Griver.registerExtension(new GriverExtensionManifest(GriverRpcExtension.class, new GriverRpcExtensionImpl("GriverAppContainer")));
    }

    private static boolean a(IAPConfig iAPConfig) {
        if (ReflectUtils.classExist(AMCSConstants.AMCS_LITE_MAIN_CLASS)) {
            AmcsLiteManager.initAmcs(c, iAPConfig);
            GriverConfig.setConfigProxy(new GriverAmcsLiteConfig());
            return true;
        }
        a((int) GriverErrors.INITIALIZE_EXCEPTION, "AMCS Lite SDK is not exist");
        return false;
    }

    public static String getExtraData(IAPConfig iAPConfig, String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("authCode == ");
        sb.append(iAPConfig.getAuthCode());
        ACLog.d("IAPIntegrationHelper", sb.toString());
        JSONObject parseObject = JSON.parseObject(getSecurityExtraData(c, iAPConfig.getAuthCode(), ProfileExtractor.KEY_DEFAULT_RPC_PROFILES));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GriverConfig == ");
        sb2.append(JSON.toJSONString(parseObject));
        ACLog.d("IAPIntegrationHelper", sb2.toString());
        return (JSONUtils.contains(parseObject, "prod") && JSONUtils.contains(parseObject.getJSONObject("prod"), "extras")) ? parseObject.getJSONObject("prod").getJSONObject("extras").getString(str) : "";
    }

    public static String getSecurityExtraData(Context context, String str, String str2) throws Exception {
        IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(context).getStaticDataStoreComp();
        if (staticDataStoreComp != null) {
            return staticDataStoreComp.getExtraData(str2, str);
        }
        return null;
    }

    public static boolean isDebuggable() {
        Boolean bool = f6642a;
        if (bool == null) {
            try {
                return (c.getApplicationInfo().flags & 2) != 0;
            } catch (Throwable th) {
                ACLog.e("GriverEnv", "exception detail", th);
                return false;
            }
        }
        return bool.booleanValue();
    }
}
