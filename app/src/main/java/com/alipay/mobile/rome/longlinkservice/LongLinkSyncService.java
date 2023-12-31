package com.alipay.mobile.rome.longlinkservice;

import android.content.Context;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;

/* loaded from: classes3.dex */
public abstract class LongLinkSyncService {

    /* renamed from: a  reason: collision with root package name */
    private static LongLinkSyncService f7209a;

    public abstract void addConnectionListener(ConnectionListener connectionListener);

    public abstract void appToBackground();

    public abstract void appToForeground();

    public abstract void initialize(Context context);

    public abstract void initialize(Context context, LongLinkAppConfig longLinkAppConfig);

    public abstract boolean isConnected();

    public abstract void registerBiz(String str, ISyncCallback iSyncCallback);

    public abstract void removeConnectionListener(ConnectionListener connectionListener);

    public abstract void reportMsgReceived(SyncMessage syncMessage);

    public abstract void unregisterBiz(String str);

    public abstract void updateUserInfo(String str, String str2);

    public static LongLinkSyncService getInstance() {
        if (f7209a == null) {
            synchronized (LongLinkSyncService.class) {
                try {
                    f7209a = (LongLinkSyncService) Class.forName("com.alipay.mobile.rome.syncservice.service.LongLinkSyncServiceImpl").newInstance();
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return f7209a;
    }
}
