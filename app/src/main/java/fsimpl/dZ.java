package fsimpl;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
class dZ {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method a(Class cls, String str, Class cls2, Class... clsArr) {
        return a(!eV.b() ? eV.b(cls, str, clsArr) : eV.a(-1, cls, str, clsArr), cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method a(Class cls, String str, Class... clsArr) {
        return eV.b(cls, str, clsArr);
    }

    private static Method a(Method method, Class cls) {
        if (method == null || cls == null) {
            return method;
        }
        Class<?> returnType = method.getReturnType();
        if (returnType == null || returnType != cls) {
            return null;
        }
        return method;
    }
}
