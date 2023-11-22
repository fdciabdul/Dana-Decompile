package com.alipay.mobile.rome.syncservice.service;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.ConnectionListener;
import com.alipay.mobile.rome.longlinkservice.ISyncCallback;
import com.alipay.mobile.rome.longlinkservice.LongLinkAppConfig;
import com.alipay.mobile.rome.longlinkservice.LongLinkSyncService;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage;
import com.alipay.mobile.rome.syncsdk.util.AppStatusUtils;
import com.alipay.mobile.rome.syncsdk.util.c;
import com.alipay.mobile.rome.syncservice.a.b;
import com.alipay.mobile.rome.syncservice.d.a;

/* loaded from: classes3.dex */
public class LongLinkSyncServiceImpl extends LongLinkSyncService {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7288a = false;

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void initialize(Context context) {
        initialize(context, null);
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void initialize(Context context, LongLinkAppConfig longLinkAppConfig) {
        if (this.f7288a) {
            return;
        }
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        c.b("LongLinkSyncServiceImpl", "initialize");
        this.f7288a = true;
        a.f7279a = context.getApplicationContext();
        if (longLinkAppConfig != null) {
            com.alipay.mobile.rome.syncsdk.a.a.a().a(longLinkAppConfig);
        }
        com.alipay.mobile.rome.syncservice.a.a.a().a(new com.alipay.mobile.rome.syncservice.b.a(context));
        b.a();
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void registerBiz(String str, ISyncCallback iSyncCallback) {
        if (TextUtils.isEmpty(str) || iSyncCallback == null) {
            c.d("LongLinkSyncServiceImpl", "registerBiz illegal method parameters.");
        } else {
            com.alipay.mobile.rome.syncservice.sync.register.c.a(str, iSyncCallback);
        }
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void unregisterBiz(String str) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder("unregisterBiz:  [ biz=");
            sb.append(str);
            sb.append(" ]");
            c.b("LongLinkSyncServiceImpl", sb.toString());
            if (!com.alipay.mobile.rome.syncservice.sync.register.c.a(str)) {
                c.d("LongLinkSyncServiceImpl", "unregisterBiz:  [ biz not registered ]");
                return;
            }
            com.alipay.mobile.rome.syncservice.sync.register.c.c(str);
            com.alipay.mobile.rome.syncservice.sync.b.a();
        }
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void reportMsgReceived(SyncMessage syncMessage) {
        if (syncMessage == null) {
            c.d("LongLinkSyncServiceImpl", "reportMsgReceived: [ syncMessag=null ]");
            return;
        }
        String str = syncMessage.userId;
        String str2 = syncMessage.biz;
        String str3 = syncMessage.f7210id;
        int i = syncMessage.sOpcode;
        com.alipay.mobile.rome.syncservice.sync.c.a.a(str, str2, str3);
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public boolean isConnected() {
        boolean c;
        synchronized (this) {
            c = com.alipay.mobile.rome.syncservice.a.a.a().c();
        }
        return c;
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void addConnectionListener(ConnectionListener connectionListener) {
        com.alipay.mobile.rome.syncsdk.b bVar = com.alipay.mobile.rome.syncservice.a.a.a().f7271a;
        com.alipay.mobile.rome.syncsdk.b.a(connectionListener);
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void removeConnectionListener(ConnectionListener connectionListener) {
        com.alipay.mobile.rome.syncsdk.b bVar = com.alipay.mobile.rome.syncservice.a.a.a().f7271a;
        com.alipay.mobile.rome.syncsdk.b.b(connectionListener);
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void appToBackground() {
        if (!this.f7288a) {
            throw new NullPointerException("You must call method: initialize(Context context); firstly");
        }
        c.b("LongLinkSyncServiceImpl", "appToBackground: ");
        AppStatusUtils.a(AppStatusUtils.AppStatus.BACKGROUND);
        com.alipay.mobile.rome.syncservice.a.a.a().b();
        com.alipay.mobile.rome.syncservice.a.a.a().e();
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void appToForeground() {
        if (!this.f7288a) {
            throw new NullPointerException("You must call method: initialize(Context context); firstly");
        }
        if (AppStatusUtils.a() == AppStatusUtils.AppStatus.FOREGROUND && com.alipay.mobile.rome.syncservice.a.a.a().c()) {
            c.b("LongLinkSyncServiceImpl", "App is foreground and sync connected.");
            return;
        }
        c.b("LongLinkSyncServiceImpl", "appToForeground, then to startLink.");
        AppStatusUtils.a(AppStatusUtils.AppStatus.FOREGROUND);
        com.alipay.mobile.rome.syncservice.a.a.a().b();
        com.alipay.mobile.rome.syncservice.a.a.a().d();
    }

    @Override // com.alipay.mobile.rome.longlinkservice.LongLinkSyncService
    public void updateUserInfo(String str, String str2) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                c.c("LongLinkSyncServiceImpl", "updateUserInfo[ uid or session is null, user logout.]");
            }
            com.alipay.mobile.rome.syncservice.a.a.a().a(str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.alipay.mobile.rome.syncservice.sync.c.a.a();
                return;
            }
            com.alipay.mobile.rome.syncservice.c.a.a a2 = com.alipay.mobile.rome.syncservice.sync.b.a().f7291a.a(3002);
            if (a2 != null) {
                a2.a();
            }
        }
    }
}
