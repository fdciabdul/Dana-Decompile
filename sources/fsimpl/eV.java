package fsimpl;

import com.fullstory.instrumentation.CurrentPlatform;
import com.fullstory.jni.FSNative;
import com.fullstory.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class eV {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7962a;
    private static final Method b;
    private static final Method c;

    static {
        Method method;
        Method method2;
        boolean z = CurrentPlatform.SDK_INT_FIXED >= 28;
        f7962a = z;
        Method method3 = null;
        if (z) {
            try {
                method2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            } catch (NoSuchMethodException unused) {
                method2 = null;
            }
            try {
                method3 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            } catch (NoSuchMethodException unused2) {
            }
            Method method4 = method3;
            method3 = method2;
            method = method4;
        } else {
            method = null;
        }
        b = method3;
        c = method;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
            return null;
        }
    }

    public static Object a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (Throwable th) {
            Log.printStackTrace(th);
            return null;
        }
    }

    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            Log.printStackTrace(th);
            return null;
        }
    }

    public static Field a(int i, int i2, Class cls, String str) {
        return !a(i, i2) ? b(cls, str) : a(i2, cls, str);
    }

    public static Field a(int i, Class cls, String str) {
        if (cls == null) {
            return null;
        }
        if (b(i)) {
            return c(cls, str);
        }
        try {
            Field field = (Field) c.invoke(cls, str);
            field.setAccessible(true);
            return field;
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
            return null;
        }
    }

    public static Field a(Class cls, String str) {
        return b(cls, str);
    }

    public static Method a(int i, int i2, Class cls, String str, Class... clsArr) {
        return !a(i, i2) ? b(cls, str, clsArr) : a(i2, cls, str, clsArr);
    }

    public static Method a(int i, Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        if (b(i)) {
            return c(cls, str, clsArr);
        }
        try {
            Method method = (Method) b.invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
            return null;
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return b(cls, str, clsArr);
    }

    public static boolean a() {
        if (f7962a) {
            return (b == null || c == null) ? false : true;
        }
        return true;
    }

    private static boolean a(int i) {
        return i != -1 && CurrentPlatform.SDK_INT_FIXED >= i;
    }

    private static boolean a(int i, int i2) {
        return a(i) || b(i2);
    }

    public static Field b(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
            return null;
        }
    }

    public static Method b(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
            return null;
        }
    }

    public static boolean b() {
        return f7962a;
    }

    private static boolean b(int i) {
        return i != -1 && CurrentPlatform.SDK_INT_FIXED >= i && CurrentPlatform.TARGET_SDK >= i;
    }

    public static Field c(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            Field a2 = FSNative.a(cls, str);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            }
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
        }
        return null;
    }

    public static Method c(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            Method a2 = FSNative.a(cls, str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            }
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
        }
        return null;
    }
}
