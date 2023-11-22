package com.xiaomi.push.service;

import com.xiaomi.push.o;

/* loaded from: classes8.dex */
final class ah extends o.a {
    final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ aq MyBillsEntityDataFactory;
    final /* synthetic */ int getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(String str, aq aqVar, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = aqVar;
        this.getAuthRequestContext = i;
    }

    @Override // com.xiaomi.push.o.a
    public final String PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext);
    }
}
