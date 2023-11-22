package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bs extends o.a {
    final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ String MyBillsEntityDataFactory;
    final /* synthetic */ Notification PlaceComponentResult = null;
    final /* synthetic */ Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(int i, String str, Context context, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = str2;
    }

    @Override // com.xiaomi.push.o.a
    public final String PlaceComponentResult() {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = br.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        br.getAuthRequestContext(this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }
}
