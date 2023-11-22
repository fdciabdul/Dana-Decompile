package com.alibaba.wireless.security.framework.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6802a;
    private final boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        private a() {
        }
    }

    private d(Object obj) {
        this.f6802a = obj;
    }

    public static d a(Object obj) {
        return new d(obj);
    }

    private static d a(Method method, Object obj, Object... objArr) throws e {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new e(e);
        }
    }

    public static Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> b = b();
        try {
            return b.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return b.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    b = b.getSuperclass();
                }
            } while (b != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        return clsArr;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> b = b();
        for (Method method : b.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : b.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            b = b.getSuperclass();
        } while (b != null);
        StringBuilder sb = new StringBuilder();
        sb.append("No similar method ");
        sb.append(str);
        sb.append(" with params ");
        sb.append(Arrays.toString(clsArr));
        sb.append(" could be found on type ");
        sb.append(b());
        sb.append(".");
        throw new NoSuchMethodException(sb.toString());
    }

    public d a(String str, Object... objArr) throws e {
        Class<?>[] a2 = a(objArr);
        try {
            try {
                return a(a(str, a2), this.f6802a, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, a2), this.f6802a, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new e(e);
        }
    }

    public <T> T a() {
        return (T) this.f6802a;
    }

    public Class<?> b() {
        return this.b ? (Class) this.f6802a : this.f6802a.getClass();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f6802a.equals(((d) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f6802a.hashCode();
    }

    public String toString() {
        return this.f6802a.toString();
    }
}
