package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes7.dex */
public class ReflectionUtils {
    private static Object PlaceComponentResult(Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(null, objArr);
        } catch (RuntimeException e) {
            Logger.e("ReflectionUtils", "RuntimeException in invoke:", e);
            return null;
        } catch (Exception e2) {
            Logger.e("ReflectionUtils", "Exception in invoke:", e2);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null) {
            Logger.w("ReflectionUtils", "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            Logger.e("ReflectionUtils", "NoSuchMethodException:", e);
            return null;
        } catch (SecurityException e2) {
            Logger.e("ReflectionUtils", "SecurityException:", e2);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Integer) {
                    clsArr[i] = Integer.TYPE;
                } else if (obj instanceof Long) {
                    clsArr[i] = Long.TYPE;
                } else if (obj instanceof Double) {
                    clsArr[i] = Double.TYPE;
                } else if (obj instanceof Float) {
                    clsArr[i] = Float.TYPE;
                } else if (obj instanceof Boolean) {
                    clsArr[i] = Boolean.TYPE;
                } else if (obj instanceof Character) {
                    clsArr[i] = Character.TYPE;
                } else if (obj instanceof Byte) {
                    clsArr[i] = Byte.TYPE;
                } else if (obj instanceof Void) {
                    clsArr[i] = Void.TYPE;
                } else if (obj instanceof Short) {
                    clsArr[i] = Short.TYPE;
                } else {
                    clsArr[i] = obj.getClass();
                }
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(BuiltInFictitiousFunctionClassFactory(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return PlaceComponentResult(method, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(BuiltInFictitiousFunctionClassFactory(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return PlaceComponentResult(method, objArr);
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException:", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException:", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException:", e3);
            return null;
        } catch (SecurityException e4) {
            Logger.e("ReflectionUtils", "not security int method getFieldObj,SecurityException:", e4);
            return null;
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField;
        } catch (IllegalArgumentException e) {
            Logger.e("ReflectionUtils", "Exception in getField :: IllegalArgumentException:", e);
            return null;
        } catch (NoSuchFieldException e2) {
            Logger.e("ReflectionUtils", "Exception in getField :: NoSuchFieldException:", e2);
            return null;
        } catch (SecurityException e3) {
            Logger.e("ReflectionUtils", "not security int method getField,SecurityException:", e3);
            return null;
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> BuiltInFictitiousFunctionClassFactory;
        if (str == null || (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str)) == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            final Field declaredField = BuiltInFictitiousFunctionClassFactory.getDeclaredField(str2);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(BuiltInFictitiousFunctionClassFactory);
        } catch (IllegalAccessException e) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException:", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException:", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Logger.e("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException:", e3);
            return null;
        } catch (SecurityException e4) {
            Logger.e("ReflectionUtils", "not security int method getStaticFieldObj,SecurityException:", e4);
            return null;
        }
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        try {
            if (str == null || str2 == null) {
                Logger.w("ReflectionUtils", "targetClass is  null or name is null:");
                return false;
            }
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            StringBuilder sb = new StringBuilder();
            sb.append("has method : ");
            sb.append(str2);
            Logger.v("ReflectionUtils", sb.toString());
            return true;
        } catch (RuntimeException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" RuntimeException");
            Logger.w("ReflectionUtils", sb2.toString());
            return false;
        } catch (Exception unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(" NoSuchMethodException");
            Logger.w("ReflectionUtils", sb3.toString());
            return false;
        }
    }

    private static Class<?> BuiltInFictitiousFunctionClassFactory(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean checkCompatible(String str) {
        try {
            ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
            if (classLoader == null) {
                throw new ClassNotFoundException("not found classloader");
            }
            classLoader.loadClass(str);
            return true;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("ClassNotFoundException");
            Logger.w("ReflectionUtils", sb.toString());
            return false;
        }
    }
}
