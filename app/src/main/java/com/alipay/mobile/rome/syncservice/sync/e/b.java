package com.alipay.mobile.rome.syncservice.sync.e;

import com.alipay.mobile.rome.syncservice.c.g;

/* loaded from: classes3.dex */
public class b {
    private static volatile b b;

    /* renamed from: a  reason: collision with root package name */
    public g f7303a = g.a();

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }
}
