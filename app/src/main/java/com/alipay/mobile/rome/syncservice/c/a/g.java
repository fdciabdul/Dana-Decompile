package com.alipay.mobile.rome.syncservice.c.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, a> f7275a = new HashMap();

    public final a a(int i) {
        a aVar = this.f7275a.get(Integer.valueOf(i));
        if (aVar == null) {
            aVar = null;
            if (i == 1001) {
                aVar = new b();
            } else if (i == 4001) {
                aVar = new e();
            } else if (i == 5001) {
                aVar = new f();
            } else if (i == 3001) {
                aVar = new c();
            } else if (i == 3002) {
                aVar = new d();
            } else {
                StringBuilder sb = new StringBuilder("unknown opcode: ");
                sb.append(i);
                com.alipay.mobile.rome.syncsdk.util.c.a("SyncSendOperationFactory", sb.toString());
            }
            if (aVar != null) {
                this.f7275a.put(Integer.valueOf(i), aVar);
            }
        }
        return aVar;
    }
}
