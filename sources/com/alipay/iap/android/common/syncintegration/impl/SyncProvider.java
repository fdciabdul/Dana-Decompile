package com.alipay.iap.android.common.syncintegration.impl;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.syncintegration.SyncIntegration;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.mobile.rome.longlinkservice.LongLinkSyncService;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;

/* loaded from: classes3.dex */
public class SyncProvider implements IAPSyncProvider {
    private static final String TAG = "SyncProvider";
    private LongLinkSyncService syncService;

    public SyncProvider() {
        if (isIncludeSyncService()) {
            this.syncService = LongLinkSyncService.getInstance();
        }
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public void initialize(Context context) {
        LongLinkSyncService longLinkSyncService = this.syncService;
        if (longLinkSyncService != null) {
            longLinkSyncService.initialize(context);
        }
    }

    public void initialize(Context context, SyncProfile syncProfile) {
        LongLinkSyncService longLinkSyncService = this.syncService;
        if (longLinkSyncService != null) {
            longLinkSyncService.initialize(context, SyncIntegration.convertConfig(syncProfile));
        }
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public boolean registerReceiveCallback(String str, IAPSyncCallback iAPSyncCallback) {
        LongLinkSyncService longLinkSyncService = this.syncService;
        if (longLinkSyncService != null) {
            longLinkSyncService.registerBiz(str, new SyncCallbackAdapter(str, this, iAPSyncCallback));
            return true;
        }
        return false;
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public boolean unregisterReceiveCallback(String str) {
        LongLinkSyncService longLinkSyncService = this.syncService;
        if (longLinkSyncService != null) {
            longLinkSyncService.unregisterBiz(str);
            return true;
        }
        return false;
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public boolean isConnected() {
        LongLinkSyncService longLinkSyncService = this.syncService;
        return longLinkSyncService != null && longLinkSyncService.isConnected();
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public void updateUserInfo(String str, String str2) {
        LongLinkSyncService longLinkSyncService = this.syncService;
        if (longLinkSyncService != null) {
            longLinkSyncService.updateUserInfo(str, str2);
        }
    }

    @Override // com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider
    public void reportMsgReceived(SyncMessage syncMessage) {
        LongLinkSyncService longLinkSyncService;
        if (syncMessage == null || (longLinkSyncService = this.syncService) == null) {
            return;
        }
        longLinkSyncService.reportMsgReceived(syncMessage);
    }

    private static boolean isIncludeSyncService() {
        try {
            return Class.forName("com.alipay.mobile.rome.longlinkservice.LongLinkSyncService") != null;
        } catch (ClassNotFoundException e) {
            LoggerWrapper.e(TAG, e.getMessage(), e);
            return false;
        }
    }
}
