package com.alipay.iap.android.common.syncintegration.api;

import android.content.Context;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;

/* loaded from: classes3.dex */
public interface IAPSyncProvider {
    void initialize(Context context);

    boolean isConnected();

    boolean registerReceiveCallback(String str, IAPSyncCallback iAPSyncCallback);

    void reportMsgReceived(SyncMessage syncMessage);

    boolean unregisterReceiveCallback(String str);

    void updateUserInfo(String str, String str2);
}
