package com.alipay.mobile.rome.syncservice.sync.register;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncservice.sync.register.Biz;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f7306a = com.alipay.mobile.rome.syncservice.d.a.f7279a.getSharedPreferences("sync_biz_config", 0);

    private b() {
    }

    public static b a() {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        synchronized (b.class) {
            b bVar2 = b;
            if (bVar2 != null) {
                return bVar2;
            }
            b bVar3 = new b();
            b = bVar3;
            return bVar3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Integer num, String str, Boolean bool, Integer num2, boolean z, Boolean bool2) {
        if (num == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", "saveSyncConfig: bizIndex is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (num2 == null || (num2.intValue() != 1 && num2.intValue() != 2)) {
                StringBuilder sb = new StringBuilder("saveSyncConfig: illegal principalIdType rule: ");
                sb.append(num2);
                com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", sb.toString());
                return;
            }
            try {
                Biz biz = new Biz();
                biz.b = num;
                biz.f7304a = str;
                boolean z2 = false;
                biz.d = bool == null ? false : bool.booleanValue();
                biz.f = Biz.BizDimeEnum.getDime(num2.intValue());
                biz.c = z;
                if (bool2 != null) {
                    z2 = bool2.booleanValue();
                }
                biz.e = z2;
                Biz biz2 = a.a().b.get(str);
                if (biz2 == null) {
                    StringBuilder sb2 = new StringBuilder("saveSyncConfig...new biz=");
                    sb2.append(biz);
                    com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", sb2.toString());
                    a a2 = a.a();
                    String str2 = a.f7305a;
                    StringBuilder sb3 = new StringBuilder("addBizConfig: ");
                    sb3.append(biz.toString());
                    com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb3.toString());
                    a2.c.put(biz.b, biz);
                    a2.b.put(biz.f7304a, biz);
                    a2.a(biz);
                } else if (biz2.equals(biz)) {
                    return;
                } else {
                    biz.f = biz2.f;
                    biz.b = biz2.b;
                    StringBuilder sb4 = new StringBuilder("saveSyncConfig...modify biz=");
                    sb4.append(biz);
                    com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", sb4.toString());
                    a a3 = a.a();
                    String str3 = a.f7305a;
                    StringBuilder sb5 = new StringBuilder("modifyBizConfig: ");
                    sb5.append(biz.toString());
                    com.alipay.mobile.rome.syncsdk.util.c.a(str3, sb5.toString());
                    a3.c.put(biz.b, biz);
                    a3.b.put(biz.f7304a, biz);
                    Integer num3 = biz.b;
                    if (num3 != null) {
                        a3.i.remove(num3);
                        a3.d.remove(num3);
                        a3.h.remove(num3);
                        a3.g.remove(num3);
                        a3.f.remove(num3);
                    }
                    a3.a(biz);
                }
                this.f7306a.edit().putString(str, biz.toString()).commit();
            } catch (Exception e) {
                StringBuilder sb6 = new StringBuilder("saveSyncConfig...error=");
                sb6.append(e);
                com.alipay.mobile.rome.syncsdk.util.c.d("DynamicBizConfigStorage", sb6.toString());
                String str4 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
                if (TextUtils.isEmpty(str4)) {
                    str4 = com.alipay.mobile.rome.syncsdk.a.a.a().e();
                }
                com.alipay.mobile.rome.syncservice.sync.b.a().a(String.valueOf(e), str, str4, "3018");
            }
        }
    }

    public final Map<String, Biz> b() {
        HashMap hashMap;
        Map<String, ?> all;
        try {
            all = this.f7306a.getAll();
        } catch (Exception e) {
            e = e;
            hashMap = null;
        }
        if (all != null && !all.isEmpty()) {
            hashMap = new HashMap();
            try {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    try {
                        hashMap.put(entry.getKey(), Biz.a((String) entry.getValue()));
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder("readAllBizConfig item e:");
                        sb.append(e2);
                        com.alipay.mobile.rome.syncsdk.util.c.d("DynamicBizConfigStorage", sb.toString());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                StringBuilder sb2 = new StringBuilder("readAllBizConfig e:");
                sb2.append(e);
                com.alipay.mobile.rome.syncsdk.util.c.d("DynamicBizConfigStorage", sb2.toString());
                String str = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
                if (TextUtils.isEmpty(str)) {
                    str = com.alipay.mobile.rome.syncsdk.a.a.a().e();
                }
                com.alipay.mobile.rome.syncservice.sync.b.a().a(String.valueOf(e), null, str, "3014");
                StringBuilder sb3 = new StringBuilder("readAllBizConfig...bizConfigMap=");
                sb3.append(hashMap);
                com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", sb3.toString());
                return hashMap;
            }
            StringBuilder sb32 = new StringBuilder("readAllBizConfig...bizConfigMap=");
            sb32.append(hashMap);
            com.alipay.mobile.rome.syncsdk.util.c.a("DynamicBizConfigStorage", sb32.toString());
            return hashMap;
        }
        return null;
    }
}
