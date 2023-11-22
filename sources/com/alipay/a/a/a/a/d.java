package com.alipay.a.a.a.a;

import android.content.Context;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public final class d extends r {

    /* renamed from: a  reason: collision with root package name */
    Context f6826a;

    public d(Context context) {
        this.f6826a = context;
    }

    @Override // com.alipay.a.a.a.a.r
    public final <T> T a(Class<T> cls, final w wVar) {
        t tVar = new t(new c() { // from class: com.alipay.a.a.a.a.d.1
            @Override // com.alipay.a.a.a.a.c
            public final String a() {
                return wVar.f6844a;
            }

            @Override // com.alipay.a.a.a.a.c
            public final w c() {
                return wVar;
            }

            @Override // com.alipay.a.a.a.a.c
            public final boolean d() {
                return wVar.c;
            }

            @Override // com.alipay.a.a.a.a.c
            public final x b() {
                return h.a(d.this.f6826a.getApplicationContext());
            }
        });
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new u(tVar.f6841a, cls, tVar.b));
    }
}
