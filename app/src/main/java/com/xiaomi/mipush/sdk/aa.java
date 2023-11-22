package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.cz;
import com.xiaomi.push.dk;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public class aa {
    public static <T extends ef<T, ?>> dq MyBillsEntityDataFactory(Context context, T t, cz czVar, boolean z, String str, String str2) {
        return BuiltInFictitiousFunctionClassFactory(context, t, czVar, z, str, str2, false);
    }

    public static <T extends ef<T, ?>> dq getAuthRequestContext(Context context, T t, cz czVar, boolean z, String str, String str2) {
        return BuiltInFictitiousFunctionClassFactory(context, t, czVar, z, str, str2, true);
    }

    public static <T extends ef<T, ?>> dq BuiltInFictitiousFunctionClassFactory(Context context, T t, cz czVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] PlaceComponentResult = ee.PlaceComponentResult(t);
        if (PlaceComponentResult != null) {
            dq dqVar = new dq();
            if (z) {
                String str4 = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
                if (TextUtils.isEmpty(str4)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        PlaceComponentResult = com.xiaomi.channel.commonutils.android.b.MyBillsEntityDataFactory(com.xiaomi.push.aa.BuiltInFictitiousFunctionClassFactory(str4), PlaceComponentResult);
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("encryption error. ");
                    }
                }
            }
            dk dkVar = new dk();
            dkVar.f152a = 5L;
            dkVar.f153a = "fakeid";
            dqVar.a(dkVar);
            dqVar.a(ByteBuffer.wrap(PlaceComponentResult));
            dqVar.a(czVar);
            dqVar.b(z2);
            dqVar.b(str);
            dqVar.a(z);
            dqVar.a(str2);
            return dqVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(str3);
        return null;
    }

    public static ef KClassImpl$Data$declaredNonStaticMembers$2(Context context, dq dqVar) {
        byte[] m314a;
        dm dmVar;
        if (dqVar.m316b()) {
            byte[] BuiltInFictitiousFunctionClassFactory = g.BuiltInFictitiousFunctionClassFactory(context, dqVar, c.ASSEMBLE_PUSH_FCM);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.aa.BuiltInFictitiousFunctionClassFactory(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion);
            }
            try {
                m314a = com.xiaomi.channel.commonutils.android.b.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, dqVar.m314a());
            } catch (Exception e) {
                throw new o("the aes decrypt failed.", e);
            }
        } else {
            m314a = dqVar.m314a();
        }
        cz a2 = dqVar.a();
        boolean z = dqVar.f230b;
        switch (ab.getAuthRequestContext[a2.ordinal()]) {
            case 1:
                dmVar = new dv();
                break;
            case 2:
                dmVar = new eb();
                break;
            case 3:
                dmVar = new dz();
                break;
            case 4:
                dmVar = new ed();
                break;
            case 5:
                dmVar = new dx();
                break;
            case 6:
                dmVar = new dl();
                break;
            case 7:
                dmVar = new dp();
                break;
            case 8:
                dmVar = new dw();
                break;
            case 9:
                if (!z) {
                    dm dmVar2 = new dm();
                    dmVar2.a(true);
                    dmVar = dmVar2;
                    break;
                } else {
                    dmVar = new dt();
                    break;
                }
            case 10:
                dmVar = new dp();
                break;
            default:
                dmVar = null;
                break;
        }
        if (dmVar != null) {
            ee.BuiltInFictitiousFunctionClassFactory(dmVar, m314a);
        }
        return dmVar;
    }
}
