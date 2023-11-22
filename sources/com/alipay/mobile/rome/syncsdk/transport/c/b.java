package com.alipay.mobile.rome.syncsdk.transport.c;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7243a = "b";
    private static ExecutorService d;
    private final com.alipay.mobile.rome.syncsdk.service.a b;
    private final Map<Object, a> c;

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null;
    }

    public b(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.c = concurrentHashMap;
        this.b = aVar;
        e eVar = new e(aVar);
        f fVar = new f(aVar);
        g gVar = new g(aVar);
        h hVar = new h(aVar);
        i iVar = new i(aVar);
        j jVar = new j(aVar);
        concurrentHashMap.put(eVar, eVar);
        concurrentHashMap.put(fVar, fVar);
        concurrentHashMap.put(gVar, gVar);
        concurrentHashMap.put(hVar, hVar);
        concurrentHashMap.put(iVar, iVar);
        concurrentHashMap.put(jVar, jVar);
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        for (a aVar2 : this.c.values()) {
            if (aVar2.b(aVar)) {
                a(new d(this, aVar2, aVar));
            }
        }
    }

    private void a(Runnable runnable) {
        synchronized (this) {
            String str = f7243a;
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "submit ");
            ExecutorService executorService = d;
            if (executorService == null || executorService.isTerminated() || d.isShutdown()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(str, "submit:[ newSingleThreadExecutor restart]");
                d = Executors.newSingleThreadExecutor(new c(this));
            }
            d.submit(runnable);
        }
    }
}
