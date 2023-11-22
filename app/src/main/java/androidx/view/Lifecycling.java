package androidx.view;

import androidx.view.Lifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Lifecycling {
    private static Map<Class<?>, Integer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> PlaceComponentResult = new HashMap();

    /* renamed from: androidx.lifecycle.Lifecycling$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements GenericLifecycleObserver {
        final /* synthetic */ LifecycleEventObserver BuiltInFictitiousFunctionClassFactory;

        @Override // androidx.view.LifecycleEventObserver
        public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LifecycleEventObserver getAuthRequestContext(Object obj) {
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof FullLifecycleObserver;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (MyBillsEntityDataFactory(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = PlaceComponentResult.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(getAuthRequestContext(list.get(0), obj));
            }
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
            for (int i = 0; i < list.size(); i++) {
                generatedAdapterArr[i] = getAuthRequestContext(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static GeneratedAdapter getAuthRequestContext(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends GeneratedAdapter> BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(canonicalName.replace(".", "_"));
            sb.append("_LifecycleAdapter");
            String obj = sb.toString();
            if (!name.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(name);
                sb2.append(".");
                sb2.append(obj);
                obj = sb2.toString();
            }
            Constructor declaredConstructor = Class.forName(obj).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static int MyBillsEntityDataFactory(Class<?> cls) {
        ArrayList arrayList;
        Integer num = KClassImpl$Data$declaredNonStaticMembers$2.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 2;
        if (cls.getCanonicalName() != null) {
            Constructor<? extends GeneratedAdapter> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cls);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                PlaceComponentResult.put(cls, Collections.singletonList(BuiltInFictitiousFunctionClassFactory));
            } else if (!ClassesInfoCache.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(cls)) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (KClassImpl$Data$declaredNonStaticMembers$2(superclass)) {
                    arrayList = MyBillsEntityDataFactory(superclass) != 1 ? new ArrayList(PlaceComponentResult.get(superclass)) : null;
                }
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Class<?> cls2 = interfaces[i2];
                        if (KClassImpl$Data$declaredNonStaticMembers$2(cls2)) {
                            if (MyBillsEntityDataFactory(cls2) == 1) {
                                break;
                            }
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.addAll(PlaceComponentResult.get(cls2));
                        }
                        i2++;
                    } else if (arrayList != null) {
                        PlaceComponentResult.put(cls, arrayList);
                    }
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2.put(cls, Integer.valueOf(i));
            return i;
        }
        i = 1;
        KClassImpl$Data$declaredNonStaticMembers$2.put(cls, Integer.valueOf(i));
        return i;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    private Lifecycling() {
    }
}
