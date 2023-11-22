package com.alipay.mobile.rome.syncservice.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class g {
    private static g b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a<?>> f7278a = new HashMap();

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    private g() {
    }

    public static a a(int i) {
        if (i != 2001) {
            if (i != 5002) {
                if (i == 8001) {
                    return new f();
                }
                StringBuilder sb = new StringBuilder("unknown opcode: ");
                sb.append(i);
                com.alipay.mobile.rome.syncsdk.util.c.a("SyncOperationFactory", sb.toString());
                return null;
            }
            return new e();
        }
        return new d();
    }
}
