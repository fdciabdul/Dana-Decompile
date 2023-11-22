package com.alipay.plus.android.ab.sdk.trigger;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.plus.android.ab.sdk.AbTestingContext;
import com.alipay.plus.android.ab.sdk.monitor.AbTestingMonitor;
import com.alipay.plus.android.config.sdk.a.e;
import java.util.List;

/* loaded from: classes7.dex */
public class AbTestingSyncTrigger extends AbTestingTrigger {
    protected static final String AB_VARIATION_SYNC_BIZ_ID = "ABTESTING";

    /* renamed from: a */
    private static final String f7346a = e.a("AbTestingSyncTrigger");
    protected IAPSyncProvider mSyncProvider;

    public AbTestingSyncTrigger() {
        this.mSyncProvider = new SyncProvider();
    }

    public AbTestingSyncTrigger(IAPSyncProvider iAPSyncProvider) {
        this.mSyncProvider = iAPSyncProvider;
    }

    public void a(List<String> list) {
        for (String str : list) {
            JSONObject jSONObject = null;
            try {
                jSONObject = JSONObject.parseObject(str);
            } catch (JSONException e) {
                String str2 = f7346a;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse config sync message to JSONObject! ");
                sb.append(e.getMessage());
                LoggerWrapper.w(str2, sb.toString());
            }
            if (jSONObject != null) {
                LoggerWrapper.d(f7346a, String.format("Receive sync message: %s! will update AB Variation now!", str));
                String string = jSONObject.getString("source");
                String string2 = jSONObject.getString("content");
                if (!TextUtils.isEmpty(string)) {
                    updateABVariation(string, string2);
                }
            }
        }
    }

    protected void registerSyncReceiver(final AbTestingContext abTestingContext) {
        this.mSyncProvider.registerReceiveCallback(AB_VARIATION_SYNC_BIZ_ID, new IAPSyncMessageParsedCallback() { // from class: com.alipay.plus.android.ab.sdk.trigger.AbTestingSyncTrigger.1
            {
                AbTestingSyncTrigger.this = this;
            }

            @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
            public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list) {
                if (TextUtils.equals(str, AbTestingSyncTrigger.AB_VARIATION_SYNC_BIZ_ID)) {
                    AbTestingSyncTrigger.this.a(list);
                    abTestingContext.getAbTestingMonitor().behavior(AbTestingMonitor.Events.AB_SYNC_GETDATA, null);
                }
            }
        });
    }

    @Override // com.alipay.plus.android.ab.sdk.trigger.AbTestingTrigger
    public void startTrigger(AbTestingContext abTestingContext) {
        LoggerWrapper.d(f7346a, "startTrigger.");
        registerSyncReceiver(abTestingContext);
    }
}
