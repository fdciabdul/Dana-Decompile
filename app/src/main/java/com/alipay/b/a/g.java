package com.alipay.b.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class g implements i, j {
    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return true;
    }

    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (!cls.equals(Object.class)) {
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Object obj2 = null;
                    if (field != null && obj != null && !"this$0".equals(field.getName())) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            field.setAccessible(isAccessible);
                            obj2 = f.b(obj3);
                        }
                    }
                    if (obj2 != null) {
                        treeMap.put(field.getName(), obj2);
                    }
                }
            }
            cls = cls.getSuperclass();
            declaredFields = cls.getDeclaredFields();
        }
        return treeMap;
    }

    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(a.a.a.c.class)) {
            a.a.a.c cVar = (a.a.a.c) obj;
            Class cls = (Class) type;
            Object newInstance = cls.newInstance();
            while (!cls.equals(Object.class)) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        String name = field.getName();
                        Type genericType = field.getGenericType();
                        if (cVar.getAuthRequestContext.containsKey(name)) {
                            field.setAccessible(true);
                            field.set(newInstance, e.a(cVar.BuiltInFictitiousFunctionClassFactory(name), genericType));
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return newInstance;
        }
        return null;
    }
}
