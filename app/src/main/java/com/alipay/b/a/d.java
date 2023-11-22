package com.alipay.b.a;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public final class d implements i, j {
    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
