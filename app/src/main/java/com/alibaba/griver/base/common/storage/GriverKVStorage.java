package com.alibaba.griver.base.common.storage;

import com.alibaba.griver.api.common.storage.GriverKVStorageProxy;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverKVStorage {

    /* renamed from: a  reason: collision with root package name */
    private static GriverKVStorageProxy f6304a = new GriverKVSpStorage(GriverEnv.getApplicationContext());

    public static void putString(String str, String str2, String str3) {
        f6304a.putString(GriverAccount.getUserId(), str, str2, str3);
    }

    public static String getString(String str, String str2) {
        return f6304a.getString(GriverAccount.getUserId(), str, str2);
    }

    public static void remove(String str, String str2) {
        f6304a.remove(GriverAccount.getUserId(), str, str2);
    }

    public static void clear(String str) {
        f6304a.clear(GriverAccount.getUserId(), str);
    }

    public static void setStorageProxy(GriverKVStorageProxy griverKVStorageProxy) {
        if (griverKVStorageProxy != null) {
            f6304a = griverKVStorageProxy;
        } else {
            GriverLogger.e("GriverKVStorage", "should not set null proxy to GriverKVStorage");
        }
    }
}
