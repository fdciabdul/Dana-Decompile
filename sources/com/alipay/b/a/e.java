package com.alipay.b.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static List<i> f6919a;

    static {
        ArrayList arrayList = new ArrayList();
        f6919a = arrayList;
        arrayList.add(new l());
        f6919a.add(new d());
        f6919a.add(new c());
        f6919a.add(new h());
        f6919a.add(new k());
        f6919a.add(new b());
        f6919a.add(new a());
        f6919a.add(new g());
    }

    public static final Object a(String str, Type type) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            return a(new a.a.a.a(trim), type);
        }
        if (trim.startsWith("{") && trim.endsWith("}")) {
            return a(new a.a.a.c(trim), type);
        }
        return a((Object) trim, type);
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : f6919a) {
            if (iVar.a(com.alipay.b.b.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }
}
