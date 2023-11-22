package com.alipay.mobile.rome.syncservice.sync.register;

import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.ISyncCallback;
import com.alipay.mobile.rome.longlinkservice.ISyncUpCallback;
import com.alipay.mobile.rome.syncsdk.util.SyncThreadManager;
import com.alipay.mobile.rome.syncsdk.util.j;
import com.alipay.mobile.rome.syncservice.sync.c.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private static final String f7307a = "c";
    private static final ConcurrentHashMap<String, ISyncCallback> b = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ISyncUpCallback> c = new ConcurrentHashMap<>();

    public static boolean a(String str) {
        a a2 = a.a();
        if (a2.b == null) {
            return false;
        }
        if (a2.b.get(str) == null) {
            String str2 = a.f7305a;
            StringBuilder sb = new StringBuilder("isBizRegistered name[");
            sb.append(str);
            sb.append("] no registered.");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            return false;
        }
        return true;
    }

    public static ISyncCallback b(String str) {
        return b.get(str);
    }

    public static void a(String str, ISyncCallback iSyncCallback) {
        b.put(str, iSyncCallback);
        j.f7269a.a(SyncThreadManager.ThreadType.SYNC_DISPATCH, new d(str));
    }

    public static void c(String str) {
        b.remove(str);
        com.alipay.mobile.rome.syncservice.sync.c.a.d(str);
    }

    public static ISyncUpCallback d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.get(str);
    }

    public static boolean e(String str) {
        Set<String> keySet;
        if (TextUtils.isEmpty(str) || (keySet = c.keySet()) == null) {
            return false;
        }
        return keySet.contains(str);
    }
}
