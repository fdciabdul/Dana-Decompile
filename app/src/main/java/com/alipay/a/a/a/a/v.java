package com.alipay.a.a.a.a;

import android.os.Looper;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Object> f6843a = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<>();
    private byte c = 0;
    private AtomicInteger d = new AtomicInteger();
    private t e;

    public v(t tVar) {
        this.e = tVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        com.alipay.c.a.a.a.a aVar = (com.alipay.c.a.a.a.a) method.getAnnotation(com.alipay.c.a.a.a.a.class);
        boolean z = method.getAnnotation(com.alipay.c.a.a.a.b.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        ThreadLocal<Object> threadLocal = f6843a;
        threadLocal.set(null);
        ThreadLocal<Map<String, Object>> threadLocal2 = b;
        threadLocal2.set(null);
        if (aVar == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String a2 = aVar.a();
        int incrementAndGet = this.d.incrementAndGet();
        try {
            if (this.c == 0) {
                com.alipay.a.a.a.a.a.e eVar = new com.alipay.a.a.a.a.a.e(incrementAndGet, a2, objArr);
                if (threadLocal2.get() != null) {
                    eVar.a(threadLocal2.get());
                }
                byte[] bArr = (byte[]) new e(this.e.f6841a, method, incrementAndGet, a2, eVar.a(), z).a();
                threadLocal2.set(null);
                Object a3 = new com.alipay.a.a.a.a.a.d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    threadLocal.set(a3);
                }
            }
            return threadLocal.get();
        } catch (s e) {
            e.f6840a = a2;
            throw e;
        }
    }
}
