package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.bp;
import java.util.HashMap;

/* loaded from: classes8.dex */
public final class ae extends bp.a {
    final /* synthetic */ XMPushService KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ q MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(String str, XMPushService xMPushService, q qVar) {
        super(str);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = xMPushService;
        this.MyBillsEntityDataFactory = qVar;
    }

    @Override // com.xiaomi.push.service.bp.a
    final void MyBillsEntityDataFactory(bp bpVar) {
        String str;
        SharedPreferences sharedPreferences = bpVar.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("GAID");
        sb.append(":");
        sb.append("gaid");
        String string = sharedPreferences.getString(sb.toString(), "");
        String MyBillsEntityDataFactory = com.xiaomi.channel.commonutils.android.c.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (!com.xiaomi.channel.commonutils.android.c.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2) && !TextUtils.isEmpty(string)) {
            bp.BuiltInFictitiousFunctionClassFactory("GAID", "gaid", "");
            dt dtVar = new dt();
            dtVar.b(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            dtVar.c(df.ClientInfoUpdate.f104a);
            dtVar.a(aw.MyBillsEntityDataFactory());
            dtVar.a(new HashMap());
            dtVar.m324a().put("rm_gpid", "1");
            byte[] PlaceComponentResult = ee.PlaceComponentResult(ad.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), this.MyBillsEntityDataFactory.MyBillsEntityDataFactory, dtVar, cz.Notification));
            XMPushService xMPushService = this.KClassImpl$Data$declaredNonStaticMembers$2;
            xMPushService.a(xMPushService.getPackageName(), PlaceComponentResult, true);
            str = "not low upload gpid";
        } else if (TextUtils.isEmpty(MyBillsEntityDataFactory) || TextUtils.equals(string, MyBillsEntityDataFactory)) {
            return;
        } else {
            bp.BuiltInFictitiousFunctionClassFactory("GAID", "gaid", MyBillsEntityDataFactory);
            dt dtVar2 = new dt();
            dtVar2.b(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            dtVar2.c(df.ClientInfoUpdate.f104a);
            dtVar2.a(aw.MyBillsEntityDataFactory());
            dtVar2.a(new HashMap());
            dtVar2.m324a().put("gaid", MyBillsEntityDataFactory);
            byte[] PlaceComponentResult2 = ee.PlaceComponentResult(ad.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), this.MyBillsEntityDataFactory.MyBillsEntityDataFactory, dtVar2, cz.Notification));
            XMPushService xMPushService2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            xMPushService2.a(xMPushService2.getPackageName(), PlaceComponentResult2, true);
            str = "upload gaid. ";
        }
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(str);
    }
}
