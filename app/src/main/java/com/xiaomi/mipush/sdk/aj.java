package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;
import com.xiaomi.push.service.bf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aj extends ContentObserver {
    final /* synthetic */ ag PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ag agVar, Handler handler) {
        super(handler);
        this.PlaceComponentResult = agVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ag agVar = this.PlaceComponentResult;
        context = agVar.KClassImpl$Data$declaredNonStaticMembers$2;
        agVar.NetworkUserEntityData$$ExternalSyntheticLambda1 = Integer.valueOf(bf.PlaceComponentResult(context).MyBillsEntityDataFactory());
        num = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (num.intValue() != 0) {
            context2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (com.xiaomi.push.y.MyBillsEntityDataFactory(context3)) {
                ag agVar2 = this.PlaceComponentResult;
                if (agVar2.MyBillsEntityDataFactory != null) {
                    agVar2.PlaceComponentResult = SystemClock.elapsedRealtime();
                    agVar2.getAuthRequestContext(agVar2.MyBillsEntityDataFactory);
                    agVar2.MyBillsEntityDataFactory = null;
                }
            }
        }
    }
}
