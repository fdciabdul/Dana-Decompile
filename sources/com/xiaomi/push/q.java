package com.xiaomi.push;

import com.xiaomi.push.o;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class q extends o.b {
    final /* synthetic */ o getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, o.a aVar) {
        super(aVar);
        this.getAuthRequestContext = oVar;
    }

    @Override // com.xiaomi.push.o.b
    final void PlaceComponentResult() {
        Object obj;
        Map map;
        obj = this.getAuthRequestContext.getAuthRequestContext;
        synchronized (obj) {
            map = this.getAuthRequestContext.MyBillsEntityDataFactory;
            map.remove(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
        }
    }
}
