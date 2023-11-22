package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes8.dex */
public class h {
    public com.huawei.hms.framework.network.grs.e.a PlaceComponentResult;
    public final ExecutorService getAuthRequestContext = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    public final Map<String, com.huawei.hms.framework.network.grs.g.k.b> MyBillsEntityDataFactory = new ConcurrentHashMap(16);
    public final Object BuiltInFictitiousFunctionClassFactory = new Object();

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ String MyBillsEntityDataFactory;
        final /* synthetic */ com.huawei.hms.framework.network.grs.b PlaceComponentResult;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c getAuthRequestContext;

        public b(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            h.this = r1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cVar;
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = cVar2;
            this.PlaceComponentResult = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.KClassImpl$Data$declaredNonStaticMembers$2(h.this.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext), this.PlaceComponentResult);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Callable<d> {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c PlaceComponentResult;
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c getAuthRequestContext;

        a(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            h.this = r1;
            this.getAuthRequestContext = cVar;
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = cVar2;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ d call() {
            return new c(this.getAuthRequestContext, h.this.PlaceComponentResult).MyBillsEntityDataFactory(h.this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            Logger.v("RequestController", "GrsResponse is not null");
            bVar.PlaceComponentResult(dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0061, code lost:
    
        if (r2.PlaceComponentResult() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0065, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.hms.framework.network.grs.g.d KClassImpl$Data$declaredNonStaticMembers$2(com.huawei.hms.framework.network.grs.g.k.c r7, java.lang.String r8, com.huawei.hms.framework.network.grs.e.c r9) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "request to server with service name is: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RequestController"
            com.huawei.hms.framework.common.Logger.d(r1, r0)
            com.huawei.hms.framework.network.grs.GrsBaseInfo r0 = r7.PlaceComponentResult
            android.content.Context r1 = r7.MyBillsEntityDataFactory
            r2 = 1
            java.lang.String r0 = r0.getGrsParasKey(r2, r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "request spUrlKey: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RequestController"
            com.huawei.hms.framework.common.Logger.v(r2, r1)
            java.lang.Object r1 = r6.BuiltInFictitiousFunctionClassFactory
            monitor-enter(r1)
            android.content.Context r2 = r7.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L9b
            boolean r2 = com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(r2)     // Catch: java.lang.Throwable -> L9b
            r3 = 0
            if (r2 != 0) goto L43
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9b
            return r3
        L43:
            com.huawei.hms.framework.network.grs.h.d$a r2 = com.huawei.hms.framework.network.grs.h.d.BuiltInFictitiousFunctionClassFactory(r0)     // Catch: java.lang.Throwable -> L9b
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.k.b> r4 = r6.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> L9b
            com.huawei.hms.framework.network.grs.g.k.b r4 = (com.huawei.hms.framework.network.grs.g.k.b) r4     // Catch: java.lang.Throwable -> L9b
            if (r4 == 0) goto L5b
            boolean r5 = r4.MyBillsEntityDataFactory()     // Catch: java.lang.Throwable -> L9b
            if (r5 != 0) goto L58
            goto L5b
        L58:
            java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> r7 = r4.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L9b
            goto L82
        L5b:
            if (r2 == 0) goto L66
            boolean r2 = r2.PlaceComponentResult()     // Catch: java.lang.Throwable -> L9b
            if (r2 != 0) goto L64
            goto L66
        L64:
            monitor-exit(r1)
            return r3
        L66:
            java.lang.String r2 = "RequestController"
            java.lang.String r4 = "hitGrsRequestBean == null or request block is released."
            com.huawei.hms.framework.common.Logger.d(r2, r4)     // Catch: java.lang.Throwable -> L9b
            java.util.concurrent.ExecutorService r2 = r6.getAuthRequestContext     // Catch: java.lang.Throwable -> L9b
            com.huawei.hms.framework.network.grs.g.h$a r4 = new com.huawei.hms.framework.network.grs.g.h$a     // Catch: java.lang.Throwable -> L9b
            r4.<init>(r7, r8, r9)     // Catch: java.lang.Throwable -> L9b
            java.util.concurrent.Future r7 = r2.submit(r4)     // Catch: java.lang.Throwable -> L9b
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.k.b> r8 = r6.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L9b
            com.huawei.hms.framework.network.grs.g.k.b r9 = new com.huawei.hms.framework.network.grs.g.k.b     // Catch: java.lang.Throwable -> L9b
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L9b
            r8.put(r0, r9)     // Catch: java.lang.Throwable -> L9b
        L82:
            monitor-exit(r1)
            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L8a java.util.concurrent.ExecutionException -> L8e java.util.concurrent.CancellationException -> L92
            com.huawei.hms.framework.network.grs.g.d r7 = (com.huawei.hms.framework.network.grs.g.d) r7     // Catch: java.lang.InterruptedException -> L8a java.util.concurrent.ExecutionException -> L8e java.util.concurrent.CancellationException -> L92
            return r7
        L8a:
            r7 = move-exception
            java.lang.String r8 = "when check result, find InterruptedException, check others"
            goto L95
        L8e:
            r7 = move-exception
            java.lang.String r8 = "when check result, find ExecutionException, check others"
            goto L95
        L92:
            r7 = move-exception
            java.lang.String r8 = "when check result, find CancellationException, check others"
        L95:
            java.lang.String r9 = "RequestController"
            com.huawei.hms.framework.common.Logger.w(r9, r8, r7)
            return r3
        L9b:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.h.KClassImpl$Data$declaredNonStaticMembers$2(com.huawei.hms.framework.network.grs.g.k.c, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }
}
