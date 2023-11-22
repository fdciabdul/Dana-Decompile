package com.alipay.b.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public final class b implements i, j {
    @Override // com.alipay.b.a.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(f.b(it.next()));
        }
        return arrayList;
    }

    @Override // com.alipay.b.a.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(a.a.a.a.class)) {
            a.a.a.a aVar = (a.a.a.a) obj;
            Collection<Object> a2 = a(com.alipay.b.b.a.a(type), type);
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                for (int i = 0; i < aVar.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                    a2.add(e.a(aVar.BuiltInFictitiousFunctionClassFactory(i), type2));
                }
                return a2;
            }
            throw new IllegalArgumentException("Does not support the implement for generics.");
        }
        return null;
    }

    private static Collection<Object> a(Class<?> cls, Type type) {
        Type type2;
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf(type2);
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder("create instane error, class ");
            sb.append(cls.getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.alipay.b.a.i, com.alipay.b.a.j
    public final boolean a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
