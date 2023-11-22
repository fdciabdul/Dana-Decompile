package com.alipay.plus.android.config.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.profile.RpcProfile;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.plus.android.config.sdk.ConfigMerger;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigKeyDetails;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.ConfigFetchCallback;
import com.alipay.plus.android.config.sdk.fetcher.ConfigNotifyCallback;
import com.alipay.plus.android.config.sdk.listener.ConfigUpdateListener;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.alipay.plus.android.config.sdk.retry.DistributionNodesConfig;
import com.alipay.plus.android.config.sdk.retry.c;
import com.alipay.plus.android.config.sdk.retry.d;
import com.alipay.plus.android.config.sdk.rpc.AmcsRpcUtils;
import com.alipay.plus.android.config.sdk.storage.a;
import com.alipay.plus.android.config.sdk.trigger.ConfigUpdateTrigger;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ConfigCenter extends ConfigMerger implements ConfigFetchCallback {

    /* renamed from: a */
    private static final String f7350a = e.a(com.alipay.zoloz.config.ConfigCenter.TAG);
    private static final ConfigCenter b = new ConfigCenter();
    private a c;
    private ConfigCenterContext d;
    private Executor e;
    private ConfigUpdateListener f;
    private c g;
    protected long mCurrentNodeVersion = 0;
    protected long mLastRefreshTime = 0;
    private boolean h = true;

    protected ConfigCenter() {
    }

    private void a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int i = availableProcessors * 2;
        this.e = new ThreadPoolExecutor(i, i + 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alipay.plus.android.config.sdk.ConfigCenter.1

            /* renamed from: a */
            int f7351a = 0;

            {
                ConfigCenter.this = this;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                StringBuilder sb = new StringBuilder();
                sb.append("AMCS_BACKGROUND_THREAD");
                int i2 = this.f7351a;
                this.f7351a = i2 + 1;
                sb.append(i2);
                return new Thread(runnable, sb.toString());
            }
        }, new ThreadPoolExecutor.AbortPolicy());
    }

    private void a(long j, ConfigMerger.MergeChangeResult mergeChangeResult, Map<String, AmcsConfigKeyDetails> map) {
        String str;
        String str2;
        if (map == null || map.isEmpty()) {
            str = f7350a;
            str2 = "handleMergedResults: updateKeyDetails is empty.";
        } else if (mergeChangeResult != null && (!mergeChangeResult.changedList.isEmpty() || !mergeChangeResult.valueNotChangedList.isEmpty())) {
            HashMap hashMap = new HashMap();
            for (com.alipay.plus.android.config.sdk.a.a aVar : mergeChangeResult.changedList) {
                HashSet<String> hashSet = new HashSet();
                hashSet.addAll(aVar.c.addedKeys);
                hashSet.addAll(aVar.c.modifiedKeys);
                for (String str3 : hashSet) {
                    if (aVar.b) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(aVar.f7360a);
                        sb.append(".");
                        sb.append(str3);
                        str3 = sb.toString();
                    }
                    AmcsConfigKeyDetails amcsConfigKeyDetails = map.get(str3);
                    if (amcsConfigKeyDetails != null && amcsConfigKeyDetails.version > 0) {
                        hashMap.put(str3, String.valueOf(amcsConfigKeyDetails.version));
                    }
                }
            }
            for (String str4 : mergeChangeResult.valueNotChangedList) {
                AmcsConfigKeyDetails amcsConfigKeyDetails2 = map.get(str4);
                if (amcsConfigKeyDetails2 != null && amcsConfigKeyDetails2.version > 0 && amcsConfigKeyDetails2.version > j) {
                    hashMap.put(str4, String.valueOf(amcsConfigKeyDetails2.version));
                }
            }
            if (hashMap.isEmpty()) {
                LoggerWrapper.i(f7350a, "handleMergedResults: extras is empty.");
                return;
            } else {
                this.d.getConfigMonitor().behavior("config_merge_result", hashMap);
                return;
            }
        } else {
            str = f7350a;
            str2 = "handleMergedResults: changeResult has no changes.";
        }
        LoggerWrapper.i(str, str2);
    }

    private void a(List<DistributionNode> list) {
        if (list == null) {
            return;
        }
        RpcProfile rpcProfile = this.d.getRpcProfile();
        AmcsRpcUtils.updateRpcGateway(rpcProfile, AmcsRpcUtils.DEFAULT_NODE_MDS_SERVICE);
        for (DistributionNode distributionNode : list) {
            RpcProfile rpcProfile2 = (RpcProfile) e.a(rpcProfile, RpcProfile.class);
            if (rpcProfile2 != null && DistributionNode.a.isRpcNode(distributionNode.type) && ConfigUtils.isDeviceHitRate(distributionNode.rate, this.d) && !TextUtils.isEmpty(distributionNode.url)) {
                rpcProfile2.gatewayUrl = distributionNode.url;
                if (distributionNode.type == DistributionNode.a.GRAYSCALE && distributionNode.extras != null) {
                    rpcProfile2.appKey = null;
                    rpcProfile2.authCode = null;
                    rpcProfile2.headers = ConfigUtils.convertToStringMap(distributionNode.extras);
                }
                AmcsRpcUtils.updateRpcGateway(rpcProfile2, distributionNode.configName);
            }
        }
    }

    private void a(List<String> list, ConfigNotifyCallback configNotifyCallback) {
        a(list, configNotifyCallback, c.a.BY_KEYS);
    }

    private void a(List<String> list, ConfigNotifyCallback configNotifyCallback, c.a aVar) {
        DistributionNodesConfig g = g();
        List<DistributionNode> list2 = (g == null || g.distributionNodes == null) ? null : g.distributionNodes;
        String d = this.c.d();
        if (aVar != null && aVar != c.a.ALL) {
            if (aVar == c.a.BY_KEYS) {
                c.a(this.d, list2, list, this, configNotifyCallback).b();
                return;
            }
            return;
        }
        c a2 = c.a(this.d, getLastUpdateVersion(), list2, f(), d, this);
        this.g = a2;
        a2.b();
        c();
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRefreshTime;
        ConfigGetter sectionConfigGetter = getSectionConfigGetter("amcs");
        if (currentTimeMillis - j > (sectionConfigGetter != null ? sectionConfigGetter.getLongConfig("refreshGapKey", 1800000L) : 1800000L)) {
            refreshConfig();
        }
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mLastRefreshTime = currentTimeMillis;
        this.c.a(currentTimeMillis);
    }

    private void d() {
        a((List<String>) null, (ConfigNotifyCallback) null, c.a.ALL);
    }

    private void e() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.cancel();
            this.g = null;
        }
    }

    private List<DistributionNode> f() {
        if (this.c == null) {
            return null;
        }
        String str = f7350a;
        StringBuilder sb = new StringBuilder();
        sb.append("Current config version: ");
        sb.append(this.mCurrentConfigVersion);
        LoggerWrapper.i(str, sb.toString());
        DistributionNodesConfig b2 = this.c.b();
        if (b2 == null) {
            return null;
        }
        if (b2.configVersion <= this.mCurrentConfigVersion) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Backup version less. skip this backup node: ");
            sb2.append(b2);
            LoggerWrapper.w(str, sb2.toString());
            return null;
        }
        return b2.distributionNodes;
    }

    private DistributionNodesConfig g() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public static ConfigCenter getInstance() {
        return b;
    }

    public void fetchAppsByIds(String str, String str2, String str3, List<String> list, Map<String, Object> map, ConfigNotifyCallback configNotifyCallback) {
        String str4 = f7350a;
        LoggerWrapper.d(str4, "will fetchAppsByIds...");
        if (!isInitialized() || this.e == null) {
            LoggerWrapper.d(str4, "ConfigCenter have not initialized. will not fetch the config.");
            if (configNotifyCallback != null) {
                configNotifyCallback.onFetchFailed("IllegalStaus", "ConfigCenter have not initialized.!");
            }
        } else if (list == null || list.isEmpty()) {
            if (configNotifyCallback != null) {
                configNotifyCallback.onFetchFailed("IllegalParam", "keys can not be null or empty!");
            }
        } else {
            LoggerWrapper.d(str4, "start fetch apps from AMCS Lite.");
            try {
                this.d.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_FETCH_LITE_APPS_START, KVBuilder.newBuilder().put(UserMetadata.KEYDATA_FILENAME, e.a((Iterable<? extends CharSequence>) list, ',')).build());
                d.a(configNotifyCallback).executeOnExecutor(this.e, e.a(this.d, str, str2, str3, list, map));
            } catch (Exception e) {
                if (configNotifyCallback != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Fetching task failed: ");
                    sb.append(e.getMessage());
                    configNotifyCallback.onFetchFailed("SystemError", sb.toString());
                }
            }
        }
    }

    public ConfigCenterContext getConfigContext() {
        return this.d;
    }

    public ConfigUpdateListener getConfigUpdateListener() {
        return this.f;
    }

    public long getLastNodesVersion() {
        return this.mCurrentNodeVersion;
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
            Context context = configCenterContext.getContext();
            configCenterContext.getConfigMonitor().behavior("config_initialized", null);
            this.mStatus = ConfigMerger.Status.Initialized;
            this.d = configCenterContext;
            a aVar = new a(context, this.d.getEnvironment());
            this.c = aVar;
            this.mLastRefreshTime = aVar.e();
            a();
            initializeWithCache(this.c.a());
            ConfigGetter sectionConfigGetter = getSectionConfigGetter("amcs");
            if (sectionConfigGetter == null || sectionConfigGetter.getBoolConfig("enableMainProcessCheck", true)) {
                this.h = MiscUtils.isMainProcess(context);
            }
            String str = f7350a;
            StringBuilder sb = new StringBuilder();
            sb.append("** ConfigCenter initialize. mainProcess = ");
            sb.append(this.h);
            LoggerWrapper.i(str, sb.toString());
            if (this.h) {
                DistributionNodesConfig c = this.c.c();
                if (c != null) {
                    this.mCurrentNodeVersion = c.configVersion;
                    a(c.distributionNodes);
                }
                if (z) {
                    b();
                }
            }
        }
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.ConfigFetchCallback
    public void onFetchByKeysSuccess(AmcsConfigRpcResult amcsConfigRpcResult) {
        a(0L, parseFetchedConfigs(amcsConfigRpcResult.deleteKeys, amcsConfigRpcResult.updateKeys), amcsConfigRpcResult.updateKeyDetails);
        LoggerWrapper.i(f7350a, "onFetchByKeysSuccess: handle completed!");
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.ConfigFetchCallback
    public void onFetchFailed(String str, String str2) {
        String str3 = f7350a;
        LoggerWrapper.e(str3, String.format("Cannot fetch config! errorCode = %s, errorMessage = %s.", str, str2));
        e();
        if (isShutdown()) {
            LoggerWrapper.d(str3, "ConfigCenter already shutdown. will not handle this failure.");
            return;
        }
        ConfigUpdateListener configUpdateListener = this.f;
        if (configUpdateListener != null) {
            configUpdateListener.onConfigUpdateFailed(str, str2);
        }
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.ConfigFetchCallback
    public void onFetchSuccess(AmcsConfigRpcResult amcsConfigRpcResult, String str) {
        long parseLong = ConfigUtils.parseLong(amcsConfigRpcResult.responseTime, System.currentTimeMillis());
        c cVar = this.g;
        this.d.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_TOTAL_UPDATE_SUCCESS, KVBuilder.newBuilder().put("version", Long.valueOf(parseLong)).put("retryCount", Integer.valueOf(cVar != null ? cVar.a() : 0)).build());
        e();
        if (isShutdown()) {
            LoggerWrapper.d(f7350a, "ConfigCenter already shutdown. will not handle this success.");
            return;
        }
        String str2 = f7350a;
        LoggerWrapper.i(str2, String.format("onFetchSuccess: responseTime = %s, mCurrentConfigVersion = %s.", ConfigUtils.formatConfigVersionWithTime(parseLong), ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion)));
        if (!TextUtils.equals(this.c.d(), str)) {
            LoggerWrapper.i(str2, "onFetchSuccess: getLastRemergeFactor is true or is not last success node, will not check version.");
        } else if (parseLong <= this.mCurrentConfigVersion) {
            LoggerWrapper.i(str2, "onFetchSuccess: Response version less current local version, will skip.");
            return;
        }
        this.c.b(str);
        long j = this.mCurrentConfigVersion;
        setLastUpdateVersion(parseLong);
        a(j, parseFetchedConfigs(amcsConfigRpcResult.deleteKeys, amcsConfigRpcResult.updateKeys), amcsConfigRpcResult.updateKeyDetails);
        LoggerWrapper.i(str2, "onFetchSuccess: handle completed!");
        ConfigUpdateListener configUpdateListener = this.f;
        if (configUpdateListener != null) {
            configUpdateListener.onConfigUpdateSuccess(this.mCurrentConfigVersion);
        }
    }

    public void refreshByKeys(String str, List<String> list, ConfigNotifyCallback configNotifyCallback) {
        String str2 = f7350a;
        LoggerWrapper.d(str2, "will refreshByKeys...");
        if (!isInitialized()) {
            LoggerWrapper.d(str2, "ConfigCenter have not initialized. will not fetch the config.");
        } else if (!this.h) {
            LoggerWrapper.w(str2, "Cannot refresh config in sub-process!");
        } else if (list == null || list.isEmpty()) {
            if (configNotifyCallback != null) {
                configNotifyCallback.onFetchFailed("IllegalParam", "keys can not be null or empty!");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(".");
                    sb.append(str3);
                    str3 = sb.toString();
                }
                arrayList.add(str3);
            }
            LoggerWrapper.d(f7350a, "start fetch by keys.");
            a(arrayList, configNotifyCallback);
        }
    }

    public void refreshByKeys(List<String> list, ConfigNotifyCallback configNotifyCallback) {
        refreshByKeys("", list, configNotifyCallback);
    }

    public void refreshConfig() {
        String str = f7350a;
        LoggerWrapper.d(str, "will refreshConfig...");
        if (!isInitialized()) {
            LoggerWrapper.d(str, "ConfigCenter have not initialized. will not fetch the config.");
        } else if (!this.h) {
            LoggerWrapper.w(str, "Cannot refresh config in sub-process!");
        } else {
            e();
            this.d.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_TOTAL_UPDATE_START, null);
            LoggerWrapper.d(str, "start fetchConfigInternal.");
            d();
        }
    }

    public void saveCdnBackupConfig(DistributionNodesConfig distributionNodesConfig) {
        if (this.c == null) {
            LoggerWrapper.e(f7350a, "ConfigCenter not initialized. cannot save CDN backupConfig!");
        } else if (distributionNodesConfig.distributionNodes == null) {
            LoggerWrapper.e(f7350a, "distributionNodes is null, will not save!");
        } else {
            this.c.a(distributionNodesConfig);
        }
    }

    @Override // com.alipay.plus.android.config.sdk.ConfigMerger
    protected void saveConfigInternal(String str) {
        if (!isInitialized()) {
            LoggerWrapper.e(f7350a, "saveConfigInternal. You need invoke initialize(ctx) firstly!");
            return;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        this.f = configUpdateListener;
    }

    public void startConfigUpdateTrigger() {
        if (!isInitialized()) {
            LoggerWrapper.e(f7350a, "startConfigUpdateTrigger. You need invoke initialize(ctx) firstly!");
        } else if (!this.h) {
            LoggerWrapper.w(f7350a, "Cannot start sync trigger in sub-process!");
        } else {
            ConfigUpdateTrigger configUpdateTrigger = this.d.getConfigUpdateTrigger();
            if (configUpdateTrigger != null) {
                configUpdateTrigger.startTrigger(this.d);
            }
        }
    }

    public void switchEnvironment(String str) {
        if (!isInitialized()) {
            LoggerWrapper.e(f7350a, "switchEnvironment. You need invoke initialize(ctx) firstly!");
            return;
        }
        this.d.setEnvironment(str);
        a aVar = new a(this.d.getContext(), str);
        this.c = aVar;
        this.mLastRefreshTime = aVar.e();
        initializeWithCache(this.c.a());
    }

    public void updateAndSaveDistributionNodes(DistributionNodesConfig distributionNodesConfig) {
        if (this.c == null) {
            LoggerWrapper.e(f7350a, "ConfigCenter not initialized. cannot save distributionNodesConfig!");
        } else if (this.mCurrentNodeVersion > distributionNodesConfig.configVersion) {
            LoggerWrapper.e(f7350a, "Current node config is latest. abort saving distributionNodesConfig!");
        } else {
            this.mCurrentNodeVersion = distributionNodesConfig.configVersion;
            a(distributionNodesConfig.distributionNodes);
            this.c.b(distributionNodesConfig);
        }
    }
}
