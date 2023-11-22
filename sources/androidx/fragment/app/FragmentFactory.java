package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> MyBillsEntityDataFactory = new SimpleArrayMap<>();

    private static Class<?> MyBillsEntityDataFactory(ClassLoader classLoader, String str) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> simpleArrayMap = MyBillsEntityDataFactory;
        SimpleArrayMap<String, Class<?>> simpleArrayMap2 = simpleArrayMap.get(classLoader);
        if (simpleArrayMap2 == null) {
            simpleArrayMap2 = new SimpleArrayMap<>();
            simpleArrayMap.put(classLoader, simpleArrayMap2);
        }
        Class<?> cls = simpleArrayMap2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean BuiltInFictitiousFunctionClassFactory(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(MyBillsEntityDataFactory(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends Fragment> KClassImpl$Data$declaredNonStaticMembers$2(ClassLoader classLoader, String str) {
        try {
            return MyBillsEntityDataFactory(classLoader, str);
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to instantiate fragment ");
            sb.append(str);
            sb.append(": make sure class is a valid subclass of Fragment");
            throw new Fragment.InstantiationException(sb.toString(), e);
        } catch (ClassNotFoundException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to instantiate fragment ");
            sb2.append(str);
            sb2.append(": make sure class name exists");
            throw new Fragment.InstantiationException(sb2.toString(), e2);
        }
    }

    public Fragment getAuthRequestContext(ClassLoader classLoader, String str) {
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to instantiate fragment ");
            sb.append(str);
            sb.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new Fragment.InstantiationException(sb.toString(), e);
        } catch (InstantiationException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to instantiate fragment ");
            sb2.append(str);
            sb2.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new Fragment.InstantiationException(sb2.toString(), e2);
        } catch (NoSuchMethodException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to instantiate fragment ");
            sb3.append(str);
            sb3.append(": could not find Fragment constructor");
            throw new Fragment.InstantiationException(sb3.toString(), e3);
        } catch (InvocationTargetException e4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to instantiate fragment ");
            sb4.append(str);
            sb4.append(": calling Fragment constructor caused an exception");
            throw new Fragment.InstantiationException(sb4.toString(), e4);
        }
    }
}
