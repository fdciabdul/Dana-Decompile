package com.alipay.mobile.rome.syncservice.sync.e;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.util.c;
import com.alipay.mobile.rome.syncservice.model.ResultCodeEnum;
import com.alipay.mobile.rome.syncservice.model.d;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7302a = "a";

    public static d a(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        if (aVar == null) {
            return new d(ResultCodeEnum.ERROR);
        }
        aVar.g = 0;
        String str = f7302a;
        StringBuilder sb = new StringBuilder("insertToDB biz:");
        sb.append(aVar.c);
        sb.append(" sKey:");
        sb.append(aVar.d);
        c.b(str, sb.toString());
        try {
            if (TextUtils.isEmpty(aVar.f)) {
                c.b(str, "syncPacket.md  is null or syncPacket.pf <= 0, msg will not insert to db.");
                return new d(ResultCodeEnum.SUCCESS);
            }
            d a2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).c.a(aVar);
            if (a2.f7287a == ResultCodeEnum.ERROR) {
                StringBuilder sb2 = new StringBuilder("insertToDB: ");
                sb2.append(ResultCodeEnum.ERROR);
                c.d(str, sb2.toString());
            }
            return a2;
        } catch (Exception e) {
            String str2 = f7302a;
            StringBuilder sb3 = new StringBuilder("insertToDB: [ Exception=");
            sb3.append(e);
            sb3.append(" ]");
            c.d(str2, sb3.toString());
            return new d(ResultCodeEnum.ERROR, String.valueOf(e));
        }
    }

    public static void b(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        if (Long.parseLong(aVar.d) > com.alipay.mobile.rome.syncservice.sync.a.a().a(aVar.c, aVar.b)) {
            com.alipay.mobile.rome.syncservice.sync.a.a().a(aVar.c, Long.parseLong(aVar.d), aVar.b);
        }
    }

    public static void c(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        if ((!TextUtils.isEmpty(aVar.f)) == true) {
            com.alipay.mobile.rome.syncservice.sync.c.a.c(aVar.c);
        }
    }
}
