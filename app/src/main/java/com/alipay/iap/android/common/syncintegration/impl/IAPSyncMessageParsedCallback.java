package com.alipay.iap.android.common.syncintegration.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class IAPSyncMessageParsedCallback implements IAPSyncCallback {
    private static final String TAG = "sync_MessageParsedCallback";

    protected boolean logSyncMessageContent() {
        return true;
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback
    public void onReceiveCommand(IAPSyncCommand iAPSyncCommand) {
    }

    protected abstract void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list);

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback
    public void onReceiveMessage(IAPSyncMessage iAPSyncMessage) {
        LoggerWrapper.d(TAG, String.format("[%s] Receive-SYNC: %s", iAPSyncMessage.biz, iAPSyncMessage.msgData));
        List<String> syncMessages = getSyncMessages(iAPSyncMessage.msgData, logSyncMessageContent());
        if (syncMessages == null || syncMessages.isEmpty()) {
            return;
        }
        onReceiveParsedSyncMessage(iAPSyncMessage, iAPSyncMessage.biz, syncMessages);
    }

    public static List<String> getSyncMessages(String str, boolean z) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.has(RVParams.PREFETCH_LOCATION)) {
                    String optString = optJSONObject.optString(RVParams.PREFETCH_LOCATION);
                    if (!TextUtils.isEmpty(optString)) {
                        if ("1".equals(optJSONObject.optString("isB"))) {
                            optString = new String(Base64.decode(optString, 0));
                        }
                        if (z) {
                            LoggerWrapper.d(TAG, String.format("sync[%s]: %s", String.valueOf(i), optString));
                        }
                        arrayList.add(optString);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSyncMessages");
            sb.append(e.getMessage());
            LoggerWrapper.w(TAG, sb.toString());
            return null;
        }
    }
}
