package com.xiaomi.push;

import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class z {
    private static final Map<Class<?>, Class<?>> MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    public static class a<T> {
        public final Class<? extends T> MyBillsEntityDataFactory;
        public final T PlaceComponentResult;
    }

    static {
        HashMap hashMap = new HashMap();
        MyBillsEntityDataFactory = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Float.class, Float.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        Class cls = Boolean.TYPE;
        hashMap.put(cls, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(cls2, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(cls3, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(cls4, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(cls7, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                Class<?> cls = clsArr2[i];
                if (cls != null && !clsArr[i].isAssignableFrom(cls)) {
                    Map<Class<?>, Class<?>> map = MyBillsEntityDataFactory;
                    if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static Object[] BuiltInFictitiousFunctionClassFactory(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((a) obj).PlaceComponentResult;
            }
        }
        return objArr2;
    }

    private static Method KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method authRequestContext = getAuthRequestContext(cls.getDeclaredMethods(), str, clsArr);
            if (authRequestContext != null) {
                authRequestContext.setAccessible(true);
                return authRequestContext;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class<? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v4 */
    private static <T> T MyBillsEntityDataFactory(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == 0) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T MyBillsEntityDataFactory(Object obj, String str, Object... objArr) {
        return (T) KClassImpl$Data$declaredNonStaticMembers$2(obj.getClass(), str, PlaceComponentResult(objArr)).invoke(obj, BuiltInFictitiousFunctionClassFactory(objArr));
    }

    public static <T> T MyBillsEntityDataFactory(String str, String str2) {
        try {
            return (T) MyBillsEntityDataFactory((Class<? extends Object>) com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(null, str), (Object) null, str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getStaticField '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
            return null;
        }
    }

    public static <T> T PlaceComponentResult(Object obj, String str) {
        try {
            return (T) MyBillsEntityDataFactory((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
            return null;
        }
    }

    private static Class<?>[] PlaceComponentResult(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                clsArr[i] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i] = ((a) obj).MyBillsEntityDataFactory;
            }
        }
        return clsArr;
    }

    public static <T> T getAuthRequestContext(Class<? extends Object> cls, String str) {
        try {
            return (T) MyBillsEntityDataFactory(cls, (Object) null, str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls.getSimpleName());
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
            return null;
        }
    }

    private static Method getAuthRequestContext(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && BuiltInFictitiousFunctionClassFactory(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static <T> T getAuthRequestContext(Object obj, String str, Object... objArr) {
        try {
            return (T) KClassImpl$Data$declaredNonStaticMembers$2(obj.getClass(), str, PlaceComponentResult(objArr)).invoke(obj, BuiltInFictitiousFunctionClassFactory(objArr));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call Method '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
            return null;
        }
    }

    public static <T> T PlaceComponentResult(String str, String str2, Object... objArr) {
        try {
            return (T) KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(null, str), str2, PlaceComponentResult(objArr)).invoke(null, BuiltInFictitiousFunctionClassFactory(objArr));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call Method '");
            sb.append(str2);
            sb.append("' in ");
            sb.append(str);
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
            return null;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Object obj2) {
        try {
            Class<?> cls = obj.getClass();
            Field field = null;
            while (field == null) {
                try {
                    field = cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                }
                if (cls == null) {
                    throw new NoSuchFieldException();
                }
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call setField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(obj);
            sb.append(", ");
            sb.append(e);
            InstrumentInjector.log_w("JavaCalls", sb.toString());
        }
    }
}
