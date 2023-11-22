package com.alipay.b.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static List<j> f6920a;

    static {
        ArrayList arrayList = new ArrayList();
        f6920a = arrayList;
        arrayList.add(new l());
        f6920a.add(new d());
        f6920a.add(new c());
        f6920a.add(new h());
        f6920a.add(new b());
        f6920a.add(new a());
        f6920a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (com.alipay.b.b.a.a(b.getClass())) {
            return a.a.a.c.PlaceComponentResult(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new a.a.a.a((Collection) ((List) b)).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new a.a.a.c((Map) b).toString();
        }
        StringBuilder sb = new StringBuilder("Unsupported Class : ");
        sb.append(b.getClass());
        throw new IllegalArgumentException(sb.toString());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (j jVar : f6920a) {
            if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Unsupported Class : ");
        sb.append(obj.getClass());
        throw new IllegalArgumentException(sb.toString());
    }
}
