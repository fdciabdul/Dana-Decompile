package com.alipay.b.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class k implements i {
    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        Type type2;
        if (obj.getClass().equals(a.a.a.a.class)) {
            a.a.a.a aVar = (a.a.a.a) obj;
            HashSet hashSet = new HashSet();
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            for (int i = 0; i < aVar.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                hashSet.add(e.a(aVar.BuiltInFictitiousFunctionClassFactory(i), type2));
            }
            return hashSet;
        }
        return null;
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
