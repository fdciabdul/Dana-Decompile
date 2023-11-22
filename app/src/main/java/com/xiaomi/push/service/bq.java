package com.xiaomi.push.service;

import com.xiaomi.push.service.bp;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

/* loaded from: classes8.dex */
class bq implements Runnable {
    final /* synthetic */ bp BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.BuiltInFictitiousFunctionClassFactory = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            Iterator it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                ((bp.a) it.next()).run();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Sync job exception :");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        bp.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
    }
}
