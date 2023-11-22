package com.alipay.b.a;

import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: classes3.dex */
public final class c implements i, j {
    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
