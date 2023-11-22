package com.alipay.a.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class u implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    protected c f6842a;
    protected Class<?> b;
    protected v c;

    public u(c cVar, Class<?> cls, v vVar) {
        this.f6842a = cVar;
        this.b = cls;
        this.c = vVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
