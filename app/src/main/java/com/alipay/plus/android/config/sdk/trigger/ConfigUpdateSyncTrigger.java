package com.alipay.plus.android.config.sdk.trigger;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.plus.android.config.sdk.ConfigCenter;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.alipay.plus.android.config.sdk.retry.DistributionNodesConfig;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ConfigUpdateSyncTrigger extends ConfigUpdateTrigger {
    protected static final String CONFIG_SYNC_BIZ_ID = "APLUS-CONFIG";
    protected static final String CONFIG_SYNC_BY_USER_BIZ_ID = "APLUS-CONFIG-USER";
    protected static final String CONFIG_SYNC_NODE_BIZ_ID = "APLUS-CONFIG-NODE";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7387a = e.a("BaseSyncTrigger");
    protected IAPSyncProvider mSyncProvider;

    public ConfigUpdateSyncTrigger(IAPSyncProvider iAPSyncProvider) {
        this.mSyncProvider = iAPSyncProvider;
    }

    private static List<DistributionNode> a(JSONArray jSONArray) {
        Integer num;
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                String string = jSONObject.getString("url");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        num = jSONObject.getInteger("rate");
                    } catch (Exception unused) {
                        LoggerWrapper.d(f7387a, String.format("Node rate cannot be parsed, rate is [%s]", String.valueOf(jSONObject.getString("rate"))));
                        num = null;
                    }
                    try {
                        DistributionNode distributionNode = new DistributionNode(DistributionNode.a.valueOf(jSONObject.getString("type")), string, jSONObject.getString("configName"), num);
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("extras");
                            if (jSONObject2 != null) {
                                distributionNode.extras = jSONObject2;
                            }
                        } catch (Exception unused2) {
                            LoggerWrapper.e(f7387a, "Can not parse extras ");
                        }
                        arrayList.add(distributionNode);
                        LoggerWrapper.d(f7387a, String.format("CdnBackup [%s] Receive CDN message! message: %s", String.valueOf(i), distributionNode.toString()));
                    } catch (Exception unused3) {
                        LoggerWrapper.e(f7387a, String.format("Can not parse Distribution type [%s]", jSONObject.getString("type")));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        JSONObject parseObject;
        long parseLong;
        long lastNodesVersion = ConfigCenter.getInstance().getLastNodesVersion();
        for (String str : list) {
            try {
                parseObject = JSON.parseObject(str);
                parseLong = ConfigUtils.parseLong(parseObject.getString("update"), 0L);
            } catch (Throwable th) {
                String str2 = f7387a;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse nodes sync message to JSONObject! ");
                sb.append(th.getMessage());
                LoggerWrapper.w(str2, sb.toString());
            }
            if (parseLong > lastNodesVersion) {
                ConfigCenter.getInstance().updateAndSaveDistributionNodes(new DistributionNodesConfig(parseLong, a(ConfigUtils.getJSONArraySafe(parseObject, "distributionNodes"))));
                LoggerWrapper.d(f7387a, String.format("Receive node sync message: %s! will refresh nodes now!", str));
                return;
            }
            String str3 = f7387a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive node sync message! But not refresh nodes!");
            sb2.append(String.format("lastUpdateTimestamp = %d, nodeUpdateTimestamp = %d", Long.valueOf(lastNodesVersion), Long.valueOf(parseLong)));
            LoggerWrapper.d(str3, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<String> list) {
        JSONObject parseObject;
        long parseLong;
        long lastUpdateVersion = ConfigCenter.getInstance().getLastUpdateVersion();
        for (String str : list) {
            try {
                parseObject = JSON.parseObject(str);
                parseLong = ConfigUtils.parseLong(parseObject.getString("update"), 0L);
            } catch (Throwable th) {
                String str2 = f7387a;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse config sync message to JSONObject! ");
                sb.append(th.getMessage());
                LoggerWrapper.w(str2, sb.toString());
            }
            if (parseLong > lastUpdateVersion) {
                ConfigCenter.getInstance().saveCdnBackupConfig(new DistributionNodesConfig(parseLong, a(ConfigUtils.getJSONArraySafe(parseObject, "cdnMessage"))));
                LoggerWrapper.d(f7387a, String.format("Receive sync message: %s! will refresh config now!", str));
                updateConfig();
                return;
            }
            String str3 = f7387a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive sync message! But not refresh config!");
            sb2.append(String.format("lastUpdateTimestamp = %d, configUpdateTimestamp = %d", Long.valueOf(lastUpdateVersion), Long.valueOf(parseLong)));
            LoggerWrapper.d(str3, sb2.toString());
        }
    }

    protected void registerSyncReceiver(final ConfigCenterContext configCenterContext) {
        IAPSyncMessageParsedCallback iAPSyncMessageParsedCallback = new IAPSyncMessageParsedCallback() { // from class: com.alipay.plus.android.config.sdk.trigger.ConfigUpdateSyncTrigger.1
            @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
            public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list) {
                if (TextUtils.equals(str, ConfigUpdateSyncTrigger.CONFIG_SYNC_BIZ_ID) || TextUtils.equals(str, ConfigUpdateSyncTrigger.CONFIG_SYNC_BY_USER_BIZ_ID)) {
                    ConfigUpdateSyncTrigger.this.b(list);
                    configCenterContext.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_SYNC_GETDATA, null);
                }
            }
        };
        IAPSyncMessageParsedCallback iAPSyncMessageParsedCallback2 = new IAPSyncMessageParsedCallback() { // from class: com.alipay.plus.android.config.sdk.trigger.ConfigUpdateSyncTrigger.2
            @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
            public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list) {
                if (TextUtils.equals(str, ConfigUpdateSyncTrigger.CONFIG_SYNC_NODE_BIZ_ID)) {
                    ConfigUpdateSyncTrigger.this.a(list);
                    configCenterContext.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_SYNC_GETDATA, null);
                }
            }
        };
        this.mSyncProvider.registerReceiveCallback(CONFIG_SYNC_BIZ_ID, iAPSyncMessageParsedCallback);
        this.mSyncProvider.registerReceiveCallback(CONFIG_SYNC_BY_USER_BIZ_ID, iAPSyncMessageParsedCallback);
        this.mSyncProvider.registerReceiveCallback(CONFIG_SYNC_NODE_BIZ_ID, iAPSyncMessageParsedCallback2);
    }

    @Override // com.alipay.plus.android.config.sdk.trigger.ConfigUpdateTrigger
    public void startTrigger(ConfigCenterContext configCenterContext) {
        LoggerWrapper.d(f7387a, "startTrigger.");
        registerSyncReceiver(configCenterContext);
    }
}
