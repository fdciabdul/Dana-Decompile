package com.alibaba.griver.base.common.storage;

import android.content.Context;
import com.alibaba.griver.api.common.storage.GriverKVStorageProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverKVSpStorage implements GriverKVStorageProxy {

    /* renamed from: a  reason: collision with root package name */
    private Context f6303a;

    public GriverKVSpStorage(Context context) {
        this.f6303a = context;
    }

    @Override // com.alibaba.griver.api.common.storage.GriverKVStorageProxy
    public void putString(String str, String str2, String str3, String str4) {
        Context context = this.f6303a;
        if (context == null) {
            GriverLogger.w("GriverKVSpStorage", "context is null, can not store data", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Griver-");
        sb.append(str2);
        context.getSharedPreferences(sb.toString(), 4).edit().putString(a(str, str3), str4).commit();
    }

    @Override // com.alibaba.griver.api.common.storage.GriverKVStorageProxy
    public String getString(String str, String str2, String str3) {
        Context context = this.f6303a;
        if (context == null) {
            GriverLogger.w("GriverKVSpStorage", "context is null, can not get data", null);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Griver-");
        sb.append(str2);
        return context.getSharedPreferences(sb.toString(), 4).getString(a(str, str3), "");
    }

    @Override // com.alibaba.griver.api.common.storage.GriverKVStorageProxy
    public void remove(String str, String str2, String str3) {
        Context context = this.f6303a;
        if (context == null) {
            GriverLogger.w("GriverKVSpStorage", "context is null, can not remove data", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Griver-");
        sb.append(str2);
        context.getSharedPreferences(sb.toString(), 4).edit().remove(a(str, str3)).commit();
    }

    @Override // com.alibaba.griver.api.common.storage.GriverKVStorageProxy
    public void clear(String str, String str2) {
        Context context = this.f6303a;
        if (context == null) {
            GriverLogger.w("GriverKVSpStorage", "context is null, can not clear data", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Griver-");
        sb.append(str2);
        context.getSharedPreferences(sb.toString(), 4).edit().clear().commit();
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-");
        sb.append(str2);
        return sb.toString();
    }
}
