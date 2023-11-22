package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    private static boolean getAuthRequestContext;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder MyBillsEntityDataFactory(Activity activity) {
        return BuiltInFictitiousFunctionClassFactory(activity, activity.getWindow().getDecorView());
    }

    public static Unbinder MyBillsEntityDataFactory(Dialog dialog) {
        return BuiltInFictitiousFunctionClassFactory(dialog, dialog.getWindow().getDecorView());
    }

    public static Unbinder BuiltInFictitiousFunctionClassFactory(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (getAuthRequestContext) {
            StringBuilder sb = new StringBuilder();
            sb.append("Looking up binding for ");
            sb.append(cls.getName());
            InstrumentInjector.log_d("ButterKnife", sb.toString());
        }
        Constructor<? extends Unbinder> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cls);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return Unbinder.PlaceComponentResult;
        }
        try {
            return BuiltInFictitiousFunctionClassFactory.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to invoke ");
            sb2.append(BuiltInFictitiousFunctionClassFactory);
            throw new RuntimeException(sb2.toString(), e);
        } catch (InstantiationException e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to invoke ");
            sb3.append(BuiltInFictitiousFunctionClassFactory);
            throw new RuntimeException(sb3.toString(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unable to create binding instance.", cause);
        }
    }

    private static Constructor<? extends Unbinder> BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        Constructor<? extends Unbinder> BuiltInFictitiousFunctionClassFactory;
        Map<Class<?>, Constructor<? extends Unbinder>> map = KClassImpl$Data$declaredNonStaticMembers$2;
        Constructor<? extends Unbinder> constructor = map.get(cls);
        if (constructor != null || map.containsKey(cls)) {
            if (getAuthRequestContext) {
                InstrumentInjector.log_d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            if (getAuthRequestContext) {
                InstrumentInjector.log_d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
                return null;
            }
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append("_ViewBinding");
            BuiltInFictitiousFunctionClassFactory = classLoader.loadClass(sb.toString()).getConstructor(cls, View.class);
            if (getAuthRequestContext) {
                InstrumentInjector.log_d("ButterKnife", "HIT: Loaded binding class and constructor.");
            }
        } catch (ClassNotFoundException unused) {
            if (getAuthRequestContext) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Not found. Trying superclass ");
                sb2.append(cls.getSuperclass().getName());
                InstrumentInjector.log_d("ButterKnife", sb2.toString());
            }
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to find binding constructor for ");
            sb3.append(name);
            throw new RuntimeException(sb3.toString(), e);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.put(cls, BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory;
    }
}
