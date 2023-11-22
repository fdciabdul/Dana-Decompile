package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.cz;
import com.xiaomi.push.dc;
import com.xiaomi.push.df;
import com.xiaomi.push.dn;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.o;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.au;

/* loaded from: classes8.dex */
public class w extends o.a {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;

    public w(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // com.xiaomi.push.o.a
    public final String PlaceComponentResult() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        at MyBillsEntityDataFactory = at.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        dn dnVar = new dn();
        dnVar.a(au.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, dc.MISC_CONFIG));
        dnVar.b(au.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, dc.PLUGIN_CONFIG));
        dt dtVar = new dt("-1", false);
        dtVar.c(df.DailyCheckClientConfig.f104a);
        dtVar.a(ee.PlaceComponentResult(dnVar));
        ag.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext((ag) dtVar, cz.Notification);
    }
}
