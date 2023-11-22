package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.el;
import com.xiaomi.push.ev;

/* loaded from: classes8.dex */
public class ee {
    public static <T extends ef<T, ?>> byte[] PlaceComponentResult(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ek(new el.a()).KClassImpl$Data$declaredNonStaticMembers$2(t);
        } catch (ej e) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }

    public static short getAuthRequestContext(Context context, dq dqVar) {
        return getAuthRequestContext(context, dqVar.f229b);
    }

    private static short getAuthRequestContext(Context context, String str) {
        int a2 = com.xiaomi.channel.commonutils.android.a.getAuthRequestContext(context, str, false).a();
        int i = n.BuiltInFictitiousFunctionClassFactory(context) ? 4 : 0;
        return (short) (a2 + 0 + i + (n.getAuthRequestContext(context) ? 8 : 0) + (com.xiaomi.push.service.aq.getAuthRequestContext(context) ? 16 : 0));
    }

    public static <T extends ef<T, ?>> void BuiltInFictitiousFunctionClassFactory(T t, byte[] bArr) {
        if (bArr == null) {
            throw new ej("the message byte is empty.");
        }
        ei eiVar = new ei(new ev.a(true, true, bArr.length));
        try {
            ex exVar = eiVar.KClassImpl$Data$declaredNonStaticMembers$2;
            int length = bArr.length;
            exVar.MyBillsEntityDataFactory = bArr;
            exVar.BuiltInFictitiousFunctionClassFactory = 0;
            exVar.getAuthRequestContext = length + 0;
            t.a(eiVar.PlaceComponentResult);
        } finally {
            ep epVar = eiVar.PlaceComponentResult;
        }
    }
}
