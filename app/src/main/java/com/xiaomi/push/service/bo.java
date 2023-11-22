package com.xiaomi.push.service;

import android.content.Context;
import android.util.Base64;
import com.xiaomi.push.C0221r;
import com.xiaomi.push.at;
import com.xiaomi.push.service.bn;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bo extends C0221r.b {
    final /* synthetic */ bn BuiltInFictitiousFunctionClassFactory;
    boolean getAuthRequestContext = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.BuiltInFictitiousFunctionClassFactory = bnVar;
    }

    @Override // com.xiaomi.push.C0221r.b
    public final void MyBillsEntityDataFactory() {
        List list;
        List list2;
        bn.a[] aVarArr;
        at.a unused;
        bn.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        if (this.getAuthRequestContext) {
            synchronized (this.BuiltInFictitiousFunctionClassFactory) {
                list = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                list2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                aVarArr = (bn.a[]) list.toArray(new bn.a[list2.size()]);
            }
            for (bn.a aVar : aVarArr) {
                unused = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            }
        }
    }

    @Override // com.xiaomi.push.C0221r.b
    public final void PlaceComponentResult() {
        Context context;
        Context context2;
        try {
            context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
            a.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2();
            context2 = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
            at.a KClassImpl$Data$declaredNonStaticMembers$2 = at.a.KClassImpl$Data$declaredNonStaticMembers$2(Base64.decode(com.xiaomi.push.ao.MyBillsEntityDataFactory(context2, "https://resolver.msg.global.xiaomi.net/psc/?t=a"), 10));
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2;
                this.getAuthRequestContext = true;
                bn.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("fetch config failure: ");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }
}
