package com.alibaba.ariver.kernel.common.utils;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes3.dex */
public class ReflectUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Method> f6166a = new ConcurrentHashMap();

    public static Object getDefaultValue(Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Boolean.FALSE;
        }
        if (cls == Void.TYPE) {
            return null;
        }
        return (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) ? 0 : null;
    }

    public static Object invokeMethod(Object obj, String str) throws Exception {
        return invokeMethod(obj.getClass(), obj, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(String str, String str2) throws Exception {
        return invokeMethod(Class.forName(str), (Object) null, str2, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Class cls, String str) throws Exception {
        return invokeMethod(cls, (Object) null, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(Class.forName(str), (Object) null, str2, clsArr, objArr);
    }

    public static Object invokeMethod(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method method = getMethod(cls, str, clsArr);
        if (objArr == null) {
            return method.invoke(obj, new Object[0]);
        }
        return method.invoke(obj, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method getMethod(Class<?> cls, String str, Class... clsArr) throws NoSuchMethodException {
        String concat = cls.getName().concat(".").concat(str);
        if (clsArr != null && clsArr.length > 0) {
            String concat2 = concat.concat("(");
            for (Class cls2 : clsArr) {
                concat2 = concat2.concat(cls2.getName()).concat(",");
            }
            concat = concat2.substring(0, concat2.length() - 1).concat(")");
        }
        Method method = null;
        try {
            Map<String, Method> map = f6166a;
            if (map.containsKey(concat)) {
                method = map.get(concat);
            }
        } catch (Throwable unused) {
        }
        if (method == null) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            f6166a.put(concat, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public static Object getField(Object obj, String str, Object obj2) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = Class.forName(String.valueOf(obj));
        }
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj2);
    }

    public static Method findMethod(Class cls, String str, String[] strArr) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                if (method.getParameterTypes().length == (strArr != null ? strArr.length : 0) && a(method.getParameterTypes(), strArr)) {
                    return method;
                }
            }
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, String[] strArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!TextUtils.equals(clsArr[i].getName(), strArr != null ? strArr[i] : null)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r6 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set<java.lang.Class<? extends com.alibaba.ariver.kernel.api.extension.Extension>> collectExtensionPoint(java.lang.Class<? extends com.alibaba.ariver.kernel.api.extension.Extension> r5, java.util.Set<java.lang.Class<? extends com.alibaba.ariver.kernel.api.extension.Extension>> r6) {
        /*
        L0:
            if (r6 != 0) goto L7
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r6.<init>()
        L7:
            java.lang.Class[] r0 = r5.getInterfaces()
            int r1 = r0.length
            r2 = 0
        Ld:
            if (r2 >= r1) goto L1f
            r3 = r0[r2]
            java.lang.Class<com.alibaba.ariver.kernel.api.extension.Extension> r4 = com.alibaba.ariver.kernel.api.extension.Extension.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 == 0) goto L1c
            r6.add(r3)
        L1c:
            int r2 = r2 + 1
            goto Ld
        L1f:
            java.lang.Class<com.alibaba.ariver.kernel.api.extension.Extension> r0 = com.alibaba.ariver.kernel.api.extension.Extension.class
            java.lang.Class r1 = r5.getSuperclass()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L30
            java.lang.Class r5 = r5.getSuperclass()
            goto L0
        L30:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.ReflectUtils.collectExtensionPoint(java.lang.Class, java.util.Set):java.util.Set");
    }
}
