package com.iap.ac.config.lite;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.instance.IInstanceInfo;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.instance.IAPInstanceInfo;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.ConfigMerger;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.facade.result.AmcsConfigKeyDetails;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.ConfigFetchCallback;
import com.iap.ac.config.lite.fetcher.ConfigNotifyCallback;
import com.iap.ac.config.lite.h.a;
import com.iap.ac.config.lite.listener.ConfigInitializeListener;
import com.iap.ac.config.lite.listener.ConfigUpdateListener;
import com.iap.ac.config.lite.preset.PresetConfig;
import com.iap.ac.config.lite.preset.PresetParser;
import com.iap.ac.config.lite.rpc.AmcsRpcUtils;
import com.iap.ac.config.lite.utils.ConfigUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ConfigCenter extends ConfigMerger implements ConfigFetchCallback, a.InterfaceC0142a {
    private static final String p = e.b(com.alipay.zoloz.config.ConfigCenter.TAG);
    private static final ConcurrentHashMap<String, ConfigCenter> q = new ConcurrentHashMap<>();
    private com.iap.ac.config.lite.storage.a g;
    private ConfigCenterContext h;
    private ConfigUpdateListener i;
    private List<ConfigInitializeListener> j;
    private com.iap.ac.config.lite.f.c k;
    private com.iap.ac.config.lite.g.a l;
    private final String m;
    protected long mLastRefreshTime;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private Map<String, Object> f7610o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements IInstanceInfo {
        a(ConfigCenter configCenter) {
        }

        @Override // com.iap.ac.android.common.instance.IInstanceInfo
        public String getInstanceId(Context context) {
            return IAPInstanceInfo.instanceId(context);
        }

        @Override // com.iap.ac.android.common.instance.IInstanceInfo
        public String getTid(Context context) {
            return IAPInstanceInfo.tid(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConfigCenterContext f7611a;
        final /* synthetic */ boolean b;

        b(ConfigCenterContext configCenterContext, boolean z) {
            this.f7611a = configCenterContext;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConfigCenter.this.initialize(this.f7611a, this.b);
            Iterator it = ConfigCenter.this.j.iterator();
            while (it.hasNext()) {
                ((ConfigInitializeListener) it.next()).onResult(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final ConfigCenter f7612a = new ConfigCenter();
    }

    protected ConfigCenter() {
        this(null);
    }

    private void a(Context context, RpcAppInfo rpcAppInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
            rpcProxyImpl.initialize(context, rpcAppInfo);
            RPCProxyHost.setRpcProxy(rpcProxyImpl, AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
            RpcGatewayController.initGatewayController(context, AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
        }
    }

    private void b(Map<String, Object> map) {
        com.iap.ac.config.lite.f.a a2 = com.iap.ac.config.lite.f.a.a(this.h, getLastUpdateVersion(), this.g.g(), map, this);
        this.k = a2;
        a2.i();
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mLastRefreshTime = currentTimeMillis;
        this.g.a(currentTimeMillis);
    }

    public static ConfigCenter getInstance() {
        return getInstance(null);
    }

    public void addConfigInitializeListener(ConfigInitializeListener configInitializeListener) {
        if (configInitializeListener == null) {
            return;
        }
        this.j.add(configInitializeListener);
        if (isInitialized()) {
            configInitializeListener.onResult(true);
        }
    }

    public ConfigCenterContext getConfigContext() {
        return this.h;
    }

    public ConfigUpdateListener getConfigUpdateListener() {
        return this.i;
    }

    public void handleSafemodeRecover(Application application) {
        com.iap.ac.config.lite.storage.a aVar = new com.iap.ac.config.lite.storage.a(application.getApplicationContext());
        aVar.c();
        if (aVar.f() > 0) {
            aVar.b();
        }
    }

    public void initialize(Context context, String str) {
        synchronized (this) {
            initialize(context, str, false);
        }
    }

    public void initializeAsync(ConfigCenterContext configCenterContext) {
        initializeAsync(configCenterContext, false);
    }

    public boolean newerThanLocalVersion(long j) {
        return j > getLastUpdateVersion();
    }

    @Override // com.iap.ac.config.lite.fetcher.ConfigFetchCallback
    public void onFetchByKeysSuccess(AmcsConfigRpcResult amcsConfigRpcResult) {
        a(0L, parseFetchedConfigs(amcsConfigRpcResult.deleteKeys, amcsConfigRpcResult.updateKeys), amcsConfigRpcResult.updateKeyDetails);
        ACLog.i(p, "onFetchByKeysSuccess: handle completed!");
    }

    @Override // com.iap.ac.config.lite.fetcher.ConfigFetchCallback
    public void onFetchFailed(String str, String str2) {
        String str3 = p;
        ACLog.e(str3, String.format("Cannot fetch config! errorCode = %s, errorMessage = %s.", str, str2));
        this.h.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_TOTAL_UPDATE, KVBuilder.newBuilder().put("isCDN", Boolean.valueOf(e.a(this))).put("success", "0").build());
        b();
        if (isShutdown()) {
            ACLog.d(str3, "ConfigCenter already shutdown. will not handle this failure.");
            return;
        }
        ConfigUpdateListener configUpdateListener = this.i;
        if (configUpdateListener != null) {
            configUpdateListener.onConfigUpdateFailed(str, str2);
        }
    }

    @Override // com.iap.ac.config.lite.fetcher.ConfigFetchCallback
    public void onFetchSuccess(AmcsConfigRpcResult amcsConfigRpcResult, String str) {
        long parseLong = ConfigUtils.parseLong(amcsConfigRpcResult.responseTime, System.currentTimeMillis());
        com.iap.ac.config.lite.f.c cVar = this.k;
        this.h.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_TOTAL_UPDATE, KVBuilder.newBuilder().put("version", Long.valueOf(parseLong)).put("retryCount", Integer.valueOf(cVar != null ? cVar.b() : 0)).put("isCDN", Boolean.valueOf(e.a(this))).put("success", "1").build());
        b();
        if (isShutdown()) {
            ACLog.d(p, "ConfigCenter already shutdown. will not handle this success.");
            return;
        }
        String str2 = p;
        ACLog.i(str2, String.format("onFetchSuccess: responseTime = %s, mCurrentConfigVersion = %s.", ConfigUtils.formatConfigVersionWithTime(parseLong), ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion)));
        if (!TextUtils.equals(this.g.g(), str)) {
            ACLog.i(str2, "onFetchSuccess: getLastRemergeFactor is true or is not last success node, will not check version.");
        } else if (parseLong <= this.mCurrentConfigVersion) {
            ACLog.i(str2, "onFetchSuccess: Response version less current local version, will skip.");
            return;
        }
        this.g.e(str);
        long j = this.mCurrentConfigVersion;
        setLastUpdateVersion(parseLong);
        a(j, parseFetchedConfigs(amcsConfigRpcResult.deleteKeys, amcsConfigRpcResult.updateKeys), amcsConfigRpcResult.updateKeyDetails);
        ACLog.i(str2, "onFetchSuccess: handle completed!");
        ConfigUpdateListener configUpdateListener = this.i;
        if (configUpdateListener != null) {
            configUpdateListener.onConfigUpdateSuccess(this.mCurrentConfigVersion);
        }
    }

    public void refreshByKeys(List<String> list, ConfigNotifyCallback configNotifyCallback) {
        refreshByKeys("", list, configNotifyCallback);
    }

    public void refreshConfig() {
        refreshConfig(null);
    }

    public void refreshConfigWithFrequenceLimit(Map<String, Object> map) {
        if (c(map)) {
            c();
            refreshConfig(map);
            return;
        }
        a(false);
    }

    @Override // com.iap.ac.config.lite.ConfigMerger
    protected void saveConfigInternal(String str) {
        if (!isInitialized()) {
            ACLog.e(p, "saveConfigInternal. You need invoke initialize(ctx) firstly!");
            return;
        }
        com.iap.ac.config.lite.storage.a aVar = this.g;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    public void setConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        this.i = configUpdateListener;
    }

    @Override // com.iap.ac.config.lite.h.a.InterfaceC0142a
    public void startConfigPolling() {
        String str = p;
        ACLog.d(str, "startConfigPolling dns prepare");
        com.iap.ac.config.lite.g.a aVar = this.l;
        if (aVar == null || aVar.isCanceled()) {
            this.l = com.iap.ac.config.lite.g.a.a(getConfigContext());
        }
        com.iap.ac.config.lite.g.a aVar2 = this.l;
        if (aVar2 == null || aVar2.d()) {
            return;
        }
        ACLog.d(str, "startConfigPolling dns start");
        this.l.i();
    }

    @Override // com.iap.ac.config.lite.h.a.InterfaceC0142a
    public void stopConfigPolling() {
        com.iap.ac.config.lite.g.a aVar = this.l;
        if (aVar == null || aVar.isCanceled()) {
            return;
        }
        this.l.cancel();
    }

    public void switchEnvironment(String str) {
        if (!isInitialized()) {
            ACLog.e(p, "switchEnvironment. You need invoke initialize(ctx) firstly!");
            return;
        }
        this.h.setEnvironment(str);
        com.iap.ac.config.lite.storage.a aVar = new com.iap.ac.config.lite.storage.a(this.h.getContext(), str, this.h.getBizCode());
        this.g = aVar;
        this.mLastRefreshTime = aVar.f();
        initializeWithCache(this.g.i());
    }

    protected ConfigCenter(String str) {
        this.mLastRefreshTime = 0L;
        this.j = new ArrayList();
        this.n = false;
        this.f7610o = new HashMap();
        this.m = str;
    }

    public static ConfigCenter getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return c.f7612a;
        }
        ConcurrentHashMap<String, ConfigCenter> concurrentHashMap = q;
        if (concurrentHashMap.get(str) == null) {
            synchronized (ConfigCenter.class) {
                if (concurrentHashMap.get(str) == null) {
                    concurrentHashMap.put(str, new ConfigCenter(str));
                }
            }
        }
        return concurrentHashMap.get(str);
    }

    public void initialize(Context context, String str, boolean z) {
        synchronized (this) {
            if (this.mStatus.isInitializedOrShutdown()) {
                return;
            }
            PresetConfig.SiteConfig siteConfig = PresetParser.getSiteConfig(context, str, this.m);
            RpcAppInfo rpcAppInfo = new RpcAppInfo();
            rpcAppInfo.rpcGateWayUrl = siteConfig.amcsGatewayUrl;
            rpcAppInfo.appId = siteConfig.gatewayAppId;
            rpcAppInfo.addHeader("workspaceId", siteConfig.gatewayWorkspaceId);
            rpcAppInfo.authCode = siteConfig.authCode;
            a();
            a(context, rpcAppInfo, this.m);
            ConfigCenterContext configCenterContext = new ConfigCenterContext(context, rpcAppInfo, str, null, siteConfig.workspaceId, siteConfig.appId, this.m);
            a(configCenterContext, siteConfig.androidProductId, siteConfig.logGatewayUrl, this.m);
            if (TextUtils.isEmpty(this.m)) {
                if (RPCProxyHost.isRpcProxyExist(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE)) {
                    AmcsRpcUtils.initializeRpcGateway(RpcGatewayController.getGatewayController(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE), configCenterContext.getRpcProfile(), str);
                } else {
                    AmcsRpcUtils.initializeRpcGateway(RpcGatewayController.getGatewayController(), configCenterContext.getRpcProfile(), str);
                }
            } else {
                AmcsRpcUtils.initializeRpcGateway(RpcGatewayController.getGatewayController(this.m), configCenterContext.getRpcProfile(), str);
            }
            configCenterContext.setDnsServer("223.5.5.5");
            if (siteConfig.schemeVersion == 1) {
                configCenterContext.setVersion(ConfigCenterContext.SchemeVersion.V1);
            }
            initialize(configCenterContext, z);
            ConfigUtils.setConfigProxy(this.m);
        }
    }

    public void initializeAsync(ConfigCenterContext configCenterContext, boolean z) {
        ConfigUtils.doAsyncTask(new b(configCenterContext, z));
    }

    public void refreshByKeys(String str, List<String> list, ConfigNotifyCallback configNotifyCallback) {
        refreshByKeys(str, list, null, configNotifyCallback, true);
    }

    public void refreshConfig(Map<String, Object> map) {
        synchronized (this) {
            String str = p;
            ACLog.d(str, "will refreshConfig...");
            if (!isInitialized()) {
                ACLog.d(str, "ConfigCenter have not initialized. will not fetch the config.");
                return;
            }
            this.n = true;
            a(true);
            b();
            if (map != null) {
                this.f7610o.putAll(map);
                this.g.d(JsonUtils.toJson(this.f7610o));
            }
            ACLog.d(str, "start fetchConfigInternal.");
            b(this.f7610o);
        }
    }

    private boolean c(Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRefreshTime;
        ConfigGetter sectionConfigGetter = getSectionConfigGetter("amcs");
        return currentTimeMillis - j > (sectionConfigGetter != null ? sectionConfigGetter.getLongConfig("refreshGapKey", 300000L) : 300000L) || a(map);
    }

    public void refreshByKeys(List<String> list, Map<String, Object> map, ConfigNotifyCallback configNotifyCallback, boolean z) {
        refreshByKeys("", list, map, configNotifyCallback, z);
    }

    public void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigNotifyCallback configNotifyCallback, boolean z) {
        refreshByKeys(str, list, map, configNotifyCallback, z, false);
    }

    public void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigNotifyCallback configNotifyCallback, boolean z, boolean z2) {
        String str2 = p;
        ACLog.d(str2, "will refreshByKeys...");
        if (!isInitialized()) {
            if (configNotifyCallback != null) {
                configNotifyCallback.onFetchFailed("IllegalStatus", "SDK not initialized");
            }
            ACLog.d(str2, "ConfigCenter have not initialized. will not fetch the config.");
        } else if (list == null || list.isEmpty()) {
            if (configNotifyCallback != null) {
                configNotifyCallback.onFetchFailed("IllegalParam", "keys can not be null or empty!");
            }
        } else {
            if (!this.n) {
                refreshConfigWithFrequenceLimit(null);
            }
            ArrayList arrayList = new ArrayList();
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(".");
                    sb.append(str3);
                    arrayList.add(sb.toString());
                } else {
                    arrayList.add(str3);
                }
            }
            ACLog.d(p, "start fetch by keys.");
            com.iap.ac.config.lite.f.b a2 = com.iap.ac.config.lite.f.b.a(this.h, list, map, this, z, configNotifyCallback);
            if (z2) {
                a2.b(true);
            }
            a2.i();
        }
    }

    private void b() {
        com.iap.ac.config.lite.f.c cVar = this.k;
        if (cVar != null) {
            cVar.cancel();
            this.k = null;
        }
    }

    private void a(ConfigCenterContext configCenterContext, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            ACUserInfoManager.setUserInfoManager(new com.iap.ac.config.lite.i.a(configCenterContext), AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
            com.iap.ac.config.lite.i.b.b().a(configCenterContext.getContext(), str, str2);
        }
    }

    private void a() {
        if (e.a("com.iap.ac.android.instance.IAPInstanceInfo") && InstanceInfo.getInstanceInfoImpl() == null) {
            InstanceInfo.setInstanceInfoImpl(new a(this));
        }
    }

    private boolean a(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            new HashMap(this.f7610o).putAll(map);
            return !r1.equals(r2);
        } catch (Exception e) {
            String str = p;
            StringBuilder sb = new StringBuilder();
            sb.append("isAttributeChanged : ");
            sb.append(e);
            ACLog.e(str, sb.toString());
            return false;
        }
    }

    private void a(long j, ConfigMerger.MergeChangeResult mergeChangeResult, Map<String, AmcsConfigKeyDetails> map) {
        if (map != null && !map.isEmpty()) {
            if (mergeChangeResult != null && (!mergeChangeResult.changedList.isEmpty() || !mergeChangeResult.valueNotChangedList.isEmpty())) {
                HashMap hashMap = new HashMap();
                for (com.iap.ac.config.lite.d.a aVar : mergeChangeResult.changedList) {
                    HashSet<String> hashSet = new HashSet();
                    hashSet.addAll(aVar.f7629a.addedKeys);
                    hashSet.addAll(aVar.f7629a.modifiedKeys);
                    for (String str : hashSet) {
                        if (aVar.c) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(aVar.b);
                            sb.append(".");
                            sb.append(str);
                            str = sb.toString();
                        }
                        AmcsConfigKeyDetails amcsConfigKeyDetails = map.get(str);
                        if (amcsConfigKeyDetails != null && ConfigUtils.parseLong(amcsConfigKeyDetails.version, 0L) > 0) {
                            hashMap.put(str, amcsConfigKeyDetails.version);
                        }
                    }
                }
                for (String str2 : mergeChangeResult.valueNotChangedList) {
                    AmcsConfigKeyDetails amcsConfigKeyDetails2 = map.get(str2);
                    if (amcsConfigKeyDetails2 != null) {
                        long parseLong = ConfigUtils.parseLong(amcsConfigKeyDetails2.version, 0L);
                        if (parseLong > 0 && parseLong > j) {
                            hashMap.put(str2, amcsConfigKeyDetails2.version);
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    ACLog.i(p, "handleMergedResults: extras is empty.");
                    return;
                } else {
                    this.h.getConfigMonitor().behavior("config_merge_result", hashMap);
                    return;
                }
            }
            ACLog.i(p, "handleMergedResults: changeResult has no changes.");
            return;
        }
        ACLog.i(p, "handleMergedResults: updateKeyDetails is empty.");
    }

    public void initialize(ConfigCenterContext configCenterContext) {
        synchronized (this) {
            initialize(configCenterContext, false);
        }
    }

    public void initialize(ConfigCenterContext configCenterContext, boolean z) {
        synchronized (this) {
            if (this.mStatus.isInitializedOrShutdown()) {
                return;
            }
            configCenterContext.setBizCode(this.m);
            Context context = configCenterContext.getContext();
            configCenterContext.getConfigMonitor().behavior("config_initialized", null);
            this.h = configCenterContext;
            com.iap.ac.config.lite.storage.a aVar = new com.iap.ac.config.lite.storage.a(context, this.h.getEnvironment(), this.h.getBizCode());
            this.g = aVar;
            this.h.setConfigStorage(aVar);
            this.mLastRefreshTime = this.g.f();
            this.l = com.iap.ac.config.lite.g.a.a(this.h);
            initializeWithCache(this.g.i());
            try {
                Map<String, Object> map = (Map) JsonUtils.fromJson(this.g.h(), Map.class);
                if (map != null) {
                    this.f7610o = map;
                }
            } catch (Exception e) {
                String str = p;
                StringBuilder sb = new StringBuilder();
                sb.append("mixAttribute fromJson : ");
                sb.append(e);
                ACLog.e(str, sb.toString());
            }
            this.mStatus = ConfigMerger.Status.INITIALIZED;
            if (z) {
                refreshConfigWithFrequenceLimit(null);
            }
            addSectionConfigListener("amcs", new com.iap.ac.config.lite.h.a(this));
        }
    }

    private void a(boolean z) {
        String str = p;
        ACLog.d(str, "startDnsTask prepare");
        com.iap.ac.config.lite.g.a aVar = this.l;
        if (aVar == null || !aVar.k() || this.l.d()) {
            return;
        }
        ACLog.d(str, "startDnsTask start");
        if (z) {
            this.l.h();
        } else {
            this.l.i();
        }
    }
}
