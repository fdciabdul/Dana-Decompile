package com.mixpanel.android.viewcrawler;

import android.view.View;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Caller {
    final Object[] BuiltInFictitiousFunctionClassFactory;
    private final Method KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final Class<?> PlaceComponentResult;
    private final Class<?> getAuthRequestContext;

    public Caller(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        Method method;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = objArr;
        this.getAuthRequestContext = cls2;
        Class[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            Object[] objArr2 = this.BuiltInFictitiousFunctionClassFactory;
            if (i >= objArr2.length) {
                break;
            }
            clsArr[i] = objArr2[i].getClass();
            i++;
        }
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                method = null;
                break;
            }
            method = methods[i2];
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.MyBillsEntityDataFactory) && parameterTypes.length == this.BuiltInFictitiousFunctionClassFactory.length && BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext).isAssignableFrom(BuiltInFictitiousFunctionClassFactory(method.getReturnType()))) {
                boolean z = true;
                for (int i3 = 0; i3 < parameterTypes.length && z; i3++) {
                    z = BuiltInFictitiousFunctionClassFactory(parameterTypes[i3]).isAssignableFrom(BuiltInFictitiousFunctionClassFactory(clsArr[i3]));
                }
                if (z) {
                    break;
                }
            }
            i2++;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = method;
        if (method == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(cls.getName());
            sb.append(".");
            sb.append(str);
            sb.append(" doesn't exit");
            throw new NoSuchMethodException(sb.toString());
        }
        this.PlaceComponentResult = method.getDeclaringClass();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Caller ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("(");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(")]");
        return sb.toString();
    }

    public final Object MyBillsEntityDataFactory(View view, Object[] objArr) {
        if (this.PlaceComponentResult.isAssignableFrom(view.getClass())) {
            try {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(view, objArr);
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Method ");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getName());
                sb.append(" appears not to be public");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelABTest.Caller", sb.toString(), e);
                return null;
            } catch (IllegalArgumentException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Method ");
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getName());
                sb2.append(" called with arguments of the wrong type");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelABTest.Caller", sb2.toString(), e2);
                return null;
            } catch (InvocationTargetException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Method ");
                sb3.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getName());
                sb3.append(" threw an exception");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelABTest.Caller", sb3.toString(), e3);
                return null;
            }
        }
        return null;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Object[] objArr) {
        Class<?>[] parameterTypes = this.KClassImpl$Data$declaredNonStaticMembers$2.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            Class<?> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(parameterTypes[i]);
            Object obj = objArr[i];
            if (obj == null) {
                if (BuiltInFictitiousFunctionClassFactory == Byte.TYPE || BuiltInFictitiousFunctionClassFactory == Short.TYPE || BuiltInFictitiousFunctionClassFactory == Integer.TYPE || BuiltInFictitiousFunctionClassFactory == Long.TYPE || BuiltInFictitiousFunctionClassFactory == Float.TYPE || BuiltInFictitiousFunctionClassFactory == Double.TYPE || BuiltInFictitiousFunctionClassFactory == Boolean.TYPE || BuiltInFictitiousFunctionClassFactory == Character.TYPE) {
                    return false;
                }
            } else if (!BuiltInFictitiousFunctionClassFactory.isAssignableFrom(BuiltInFictitiousFunctionClassFactory(obj.getClass()))) {
                return false;
            }
        }
        return true;
    }

    private static Class<?> BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return cls == Character.class ? Character.TYPE : cls;
    }
}
