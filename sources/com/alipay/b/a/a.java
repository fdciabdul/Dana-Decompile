package com.alipay.b.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class a implements i, j {
    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(a.a.a.a.class)) {
            a.a.a.a aVar = (a.a.a.a) obj;
            if (type instanceof GenericArrayType) {
                throw new IllegalArgumentException("Does not support generic array!");
            }
            Class<?> componentType = ((Class) type).getComponentType();
            int size = aVar.KClassImpl$Data$declaredNonStaticMembers$2.size();
            Object newInstance = Array.newInstance(componentType, size);
            for (int i = 0; i < size; i++) {
                Array.set(newInstance, i, e.a(aVar.BuiltInFictitiousFunctionClassFactory(i), componentType));
            }
            return newInstance;
        }
        return null;
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
