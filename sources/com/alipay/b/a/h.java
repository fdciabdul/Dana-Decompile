package com.alipay.b.a;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class h implements i, j {
    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Map key must be String!");
            }
            treeMap.put((String) entry.getKey(), f.b(entry.getValue()));
        }
        return treeMap;
    }

    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(a.a.a.c.class)) {
            a.a.a.c cVar = (a.a.a.c) obj;
            Map<Object, Object> a2 = a(type);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class != type2) {
                    throw new IllegalArgumentException("Deserialize Map Key must be String.class");
                }
                for (String str : cVar.getAuthRequestContext.keySet()) {
                    if (com.alipay.b.b.a.a((Class<?>) type3)) {
                        a2.put(str, cVar.BuiltInFictitiousFunctionClassFactory(str));
                    } else {
                        a2.put(str, e.a(cVar.BuiltInFictitiousFunctionClassFactory(str), type3));
                    }
                }
                return a2;
            }
            throw new IllegalArgumentException("Deserialize Map must be Generics!");
        }
        return null;
    }

    private static Map<Object, Object> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                Class cls = (Class) type;
                if (cls.isInterface()) {
                    StringBuilder sb = new StringBuilder("unsupport type ");
                    sb.append(type);
                    throw new IllegalArgumentException(sb.toString());
                }
                try {
                    return (Map) cls.newInstance();
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("unsupport type ");
                    sb2.append(type);
                    throw new IllegalArgumentException(sb2.toString(), e);
                }
            }
        }
        return new Properties();
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}
