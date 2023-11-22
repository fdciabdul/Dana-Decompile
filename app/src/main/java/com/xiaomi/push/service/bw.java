package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.cz;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;

/* loaded from: classes8.dex */
final class bw implements Runnable {
    final /* synthetic */ dt PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(dt dtVar) {
        this.PlaceComponentResult = dtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        byte[] PlaceComponentResult = ee.PlaceComponentResult(ad.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.c(), this.PlaceComponentResult.b(), this.PlaceComponentResult, cz.Notification));
        context = bv.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("UNDatas UploadNotificationDatas failed because not xmsf");
            return;
        }
        context2 = bv.KClassImpl$Data$declaredNonStaticMembers$2;
        ((XMPushService) context2).a(this.PlaceComponentResult.c(), PlaceComponentResult, true);
    }
}
