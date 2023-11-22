package com.alipay.mobile.rome.syncservice.a;

import android.text.TextUtils;
import com.alibaba.griver.api.jsapi.diagnostic.RecordReportConstants;
import com.alipay.mobile.rome.syncsdk.util.SyncThreadManager;
import com.alipay.mobile.rome.syncsdk.util.j;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7272a = "com.alipay.mobile.rome.syncservice.a.b";

    public static void a() {
        j.f7269a.a(SyncThreadManager.ThreadType.SYNC_RECEIVE, new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b() {
        com.alipay.mobile.rome.syncsdk.a.a a2 = com.alipay.mobile.rome.syncsdk.a.a.a();
        String a3 = com.alipay.mobile.rome.syncsdk.b.a.a().a("app_id");
        String a4 = com.alipay.mobile.rome.syncsdk.b.a.a().a(RecordReportConstants.WORKSPACE_ID);
        if (TextUtils.isEmpty(a3) || TextUtils.isEmpty(a4)) {
            com.alipay.mobile.rome.syncsdk.b.a.a().a("app_id", a2.d());
            com.alipay.mobile.rome.syncsdk.b.a.a().a(RecordReportConstants.WORKSPACE_ID, a2.c.workspaceId);
        } else if (TextUtils.equals(a3, a2.d()) && TextUtils.equals(a4, a2.c.workspaceId)) {
        } else {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7272a, "workspaceId or appId changed");
            com.alipay.mobile.rome.syncservice.sync.register.b.a().f7306a.edit().clear().commit();
            com.alipay.mobile.rome.syncservice.sync.a a5 = com.alipay.mobile.rome.syncservice.sync.a.a();
            com.alipay.mobile.rome.syncservice.sync.a.c.clear();
            try {
                if (a5.d == null) {
                    a5.d = a5.b.getSharedPreferences("com.alipay.android.phone.rome.syncservice.syncinfo", 0);
                }
                a5.d.edit().clear().apply();
                com.alipay.mobile.rome.syncsdk.util.c.b(com.alipay.mobile.rome.syncservice.sync.a.f7289a, "clearAllKeys successfully!");
            } catch (Exception e) {
                String str = com.alipay.mobile.rome.syncservice.sync.a.f7289a;
                StringBuilder sb = new StringBuilder("clearAllKeys: [ Exception ");
                sb.append(e);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            }
            com.alipay.mobile.rome.syncservice.sync.b.a.a a6 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a);
            a6.c.a("delete from sync_dispatch");
            a6.b.a("delete from syncUplink");
            com.alipay.mobile.rome.syncsdk.b.a.a().a("app_id", a2.d());
            com.alipay.mobile.rome.syncsdk.b.a.a().a(RecordReportConstants.WORKSPACE_ID, a2.c.workspaceId);
        }
    }
}
