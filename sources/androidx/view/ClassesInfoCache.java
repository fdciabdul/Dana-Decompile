package androidx.view;

import androidx.view.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
final class ClassesInfoCache {
    static ClassesInfoCache PlaceComponentResult = new ClassesInfoCache();
    final Map<Class<?>, CallbackInfo> getAuthRequestContext = new HashMap();
    private final Map<Class<?>, Boolean> MyBillsEntityDataFactory = new HashMap();

    ClassesInfoCache() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        Boolean bool = this.MyBillsEntityDataFactory.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] PlaceComponentResult2 = PlaceComponentResult(cls);
        for (Method method : PlaceComponentResult2) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                getAuthRequestContext(cls, PlaceComponentResult2);
                return true;
            }
        }
        this.MyBillsEntityDataFactory.put(cls, Boolean.FALSE);
        return false;
    }

    private static Method[] PlaceComponentResult(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private static void MyBillsEntityDataFactory(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        Method method = methodReference.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(method.getName());
        sb.append(" in ");
        sb.append(cls.getName());
        sb.append(" already declared with different @OnLifecycleEvent value: previous value ");
        sb.append(event2);
        sb.append(", new value ");
        sb.append(event);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CallbackInfo getAuthRequestContext(Class<?> cls, Method[] methodArr) {
        int i;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            CallbackInfo callbackInfo = this.getAuthRequestContext.get(superclass);
            if (callbackInfo == null) {
                callbackInfo = getAuthRequestContext(superclass, null);
            }
            if (callbackInfo != null) {
                hashMap.putAll(callbackInfo.BuiltInFictitiousFunctionClassFactory);
            }
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            CallbackInfo callbackInfo2 = this.getAuthRequestContext.get(cls2);
            if (callbackInfo2 == null) {
                callbackInfo2 = getAuthRequestContext(cls2, null);
            }
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : callbackInfo2.BuiltInFictitiousFunctionClassFactory.entrySet()) {
                MyBillsEntityDataFactory(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = PlaceComponentResult(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                MyBillsEntityDataFactory(hashMap, new MethodReference(i, method), value, cls);
                z = true;
            }
        }
        CallbackInfo callbackInfo3 = new CallbackInfo(hashMap);
        this.getAuthRequestContext.put(cls, callbackInfo3);
        this.MyBillsEntityDataFactory.put(cls, Boolean.valueOf(z));
        return callbackInfo3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static class CallbackInfo {
        final Map<MethodReference, Lifecycle.Event> BuiltInFictitiousFunctionClassFactory;
        final Map<Lifecycle.Event, List<MethodReference>> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.BuiltInFictitiousFunctionClassFactory = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.KClassImpl$Data$declaredNonStaticMembers$2.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.KClassImpl$Data$declaredNonStaticMembers$2.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void BuiltInFictitiousFunctionClassFactory(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    MethodReference methodReference = list.get(size);
                    try {
                        int i = methodReference.BuiltInFictitiousFunctionClassFactory;
                        if (i == 0) {
                            methodReference.KClassImpl$Data$declaredNonStaticMembers$2.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            methodReference.KClassImpl$Data$declaredNonStaticMembers$2.invoke(obj, lifecycleOwner);
                        } else if (i == 2) {
                            methodReference.KClassImpl$Data$declaredNonStaticMembers$2.invoke(obj, lifecycleOwner, event);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    /* loaded from: classes.dex */
    public static final class MethodReference {
        final int BuiltInFictitiousFunctionClassFactory;
        final Method KClassImpl$Data$declaredNonStaticMembers$2;

        MethodReference(int i, Method method) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MethodReference) {
                MethodReference methodReference = (MethodReference) obj;
                return this.BuiltInFictitiousFunctionClassFactory == methodReference.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2.getName().equals(methodReference.KClassImpl$Data$declaredNonStaticMembers$2.getName());
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.getName().hashCode();
        }
    }
}
