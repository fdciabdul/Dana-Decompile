package com.alipay.iap.android.common.syncintegration.api;

/* loaded from: classes3.dex */
public interface IAPSyncCallback {
    void onReceiveCommand(IAPSyncCommand iAPSyncCommand);

    void onReceiveMessage(IAPSyncMessage iAPSyncMessage);
}
