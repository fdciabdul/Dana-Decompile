package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class n {
    private static volatile n KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;

    private n(Context context) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, dq dqVar, boolean z) {
        MyBillsEntityDataFactory(context).getAuthRequestContext(dqVar, 3, z);
    }

    private static n MyBillsEntityDataFactory(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (n.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new n(context);
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static void PlaceComponentResult(Context context, dq dqVar, boolean z) {
        MyBillsEntityDataFactory(context).getAuthRequestContext(dqVar, 1, z);
    }

    public static void getAuthRequestContext(Context context, dq dqVar, boolean z) {
        MyBillsEntityDataFactory(context).getAuthRequestContext(dqVar, 4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(dq dqVar, int i, boolean z) {
        if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(this.MyBillsEntityDataFactory) || !com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || dqVar == null || dqVar.f222a != cz.SendMessage || dqVar.m308a() == null || !z) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("click to start activity result:");
        sb.append(String.valueOf(i));
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        dt dtVar = new dt(dqVar.m308a().m277a(), false);
        dtVar.c(df.SDK_START_ACTIVITY.f104a);
        dtVar.b(dqVar.m309a());
        dtVar.d(dqVar.f229b);
        dtVar.f241a = new HashMap();
        dtVar.f241a.put("result", String.valueOf(i));
        ag.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2(dtVar, cz.Notification, false, false, null, true, dqVar.f229b, dqVar.f225a, true, false);
    }

    public static void MyBillsEntityDataFactory(Context context, dq dqVar, boolean z) {
        n MyBillsEntityDataFactory;
        int i;
        a PlaceComponentResult = a.PlaceComponentResult(context);
        if (TextUtils.isEmpty(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.lookAheadTest) || TextUtils.isEmpty(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion)) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(context);
            i = 6;
        } else {
            boolean scheduleImpl = PlaceComponentResult.scheduleImpl();
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(context);
            i = scheduleImpl ? 7 : 5;
        }
        MyBillsEntityDataFactory.getAuthRequestContext(dqVar, i, z);
    }
}
