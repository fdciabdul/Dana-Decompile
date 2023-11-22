package com.alipay.iap.android.common.syncintegration.impl;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.mobile.rome.longlinkservice.ISyncCallback;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;

/* loaded from: classes3.dex */
public class SyncCallbackAdapter implements ISyncCallback {
    private String biz;
    private IAPSyncCallback callback;
    private IAPSyncProvider syncProvider;

    public SyncCallbackAdapter(String str, IAPSyncProvider iAPSyncProvider, IAPSyncCallback iAPSyncCallback) {
        this.biz = str;
        this.syncProvider = iAPSyncProvider;
        this.callback = iAPSyncCallback;
    }

    @Override // com.alipay.mobile.rome.longlinkservice.ISyncCallback
    public void onReceiveMessage(SyncMessage syncMessage) {
        IAPSyncProvider iAPSyncProvider = this.syncProvider;
        if (iAPSyncProvider != null) {
            iAPSyncProvider.reportMsgReceived(syncMessage);
        }
        if (this.callback != null) {
            this.callback.onReceiveMessage(convertSyncMessage(syncMessage));
        }
    }

    public IAPSyncMessage convertSyncMessage(SyncMessage syncMessage) {
        IAPSyncMessage iAPSyncMessage = new IAPSyncMessage();
        iAPSyncMessage.biz = syncMessage.biz;
        iAPSyncMessage.hasMore = syncMessage.hasMore;
        iAPSyncMessage.messageId = syncMessage.f7210id;
        iAPSyncMessage.msgData = syncMessage.msgData;
        iAPSyncMessage.userId = syncMessage.userId;
        return iAPSyncMessage;
    }
}
