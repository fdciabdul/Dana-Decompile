package com.alibaba.ariver.kernel.common;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* loaded from: classes2.dex */
public class RVProxy {
    private static volatile Printer c;

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Object> f6114a = new ConcurrentHashMap();
    private static final Map<InstanceType, Map<Class<?>, Object>> b = new ConcurrentHashMap();
    public static boolean sHasSetupProxy = false;
    private static Initializer d = null;

    /* loaded from: classes3.dex */
    public static class EmptyPrinter implements Printer {
        @Override // com.alibaba.ariver.kernel.common.RVProxy.Printer
        public void print(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public interface Initializer {
        void doInitialize();
    }

    /* loaded from: classes3.dex */
    public interface LazyGetter<T> {
        T get();
    }

    /* loaded from: classes3.dex */
    public interface Printer {
        void print(String str);
    }

    public static void setLazyInitializer(Initializer initializer) {
        d = initializer;
    }

    public static void setPrinter(Printer printer) {
        c = printer;
    }

    public static Printer getPrinter() {
        Printer printer;
        synchronized (RVProxy.class) {
            if (c == null) {
                c = new EmptyPrinter();
            }
            printer = c;
        }
        return printer;
    }

    public static <T> void setLazy(Class<T> cls, LazyGetter<T> lazyGetter) {
        a(null, cls, lazyGetter);
    }

    public static <T> void setLazy(InstanceType instanceType, Class<T> cls, LazyGetter<T> lazyGetter) {
        a(instanceType, cls, lazyGetter);
    }

    public static <T> void set(Class<? super T> cls, T t) {
        a(null, cls, t);
    }

    public static <T> void set(InstanceType instanceType, Class<? super T> cls, T t) {
        a(instanceType, cls, t);
    }

    private static <T> void a(InstanceType instanceType, Class cls, Object obj) {
        Map<Class<?>, Object> map;
        if (cls == null) {
            return;
        }
        if (instanceType != null) {
            Map<InstanceType, Map<Class<?>, Object>> map2 = b;
            map = map2.get(instanceType);
            if (map == null) {
                synchronized (map2) {
                    map = map2.get(instanceType);
                    if (map == null) {
                        map = new ConcurrentHashMap<>();
                        map2.put(instanceType, map);
                    }
                }
            }
        } else {
            map = f6114a;
        }
        if (obj == null) {
            map.remove(cls);
        } else if (!cls.isInterface()) {
            StringBuilder sb = new StringBuilder();
            sb.append("set proxy class must a Interface: ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        } else if (!Proxiable.class.isAssignableFrom(cls)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("set proxy class must a Proxiable: ");
            sb2.append(cls);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!cls.isInstance(obj) && !(obj instanceof LazyGetter)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj.getClass().getSimpleName());
            sb3.append(" is not instance of ");
            sb3.append(cls.getSimpleName());
            sb3.append(" and not instance of LazyGetter");
            throw new IllegalArgumentException(sb3.toString());
        } else {
            Printer printer = getPrinter();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(cls.getSimpleName());
            sb4.append(" >>> ");
            sb4.append(obj.getClass());
            sb4.append(" instance: ");
            sb4.append(instanceType);
            printer.print(sb4.toString());
            synchronized (f6114a) {
                map.put(cls, obj);
            }
        }
    }

    public static <T> T get(Class<T> cls) {
        return (T) get((Class) cls, false);
    }

    public static <T> T get(Node node, Class<T> cls) {
        return (T) get(node, cls, false);
    }

    public static <T> T get(Class<T> cls, boolean z) {
        return (T) get(null, cls, z);
    }

    public static <T> T get(Node node, final Class<T> cls, boolean z) {
        Map<Class<?>, Object> map;
        T t;
        if (!cls.isInterface()) {
            Printer printer = getPrinter();
            StringBuilder sb = new StringBuilder();
            sb.append("got proxy clazz must a Interface:");
            sb.append(cls.getSimpleName());
            printer.print(sb.toString());
        }
        InstanceType instanceType = node != null ? node.getInstanceType() : null;
        if (instanceType == null || (map = b.get(instanceType)) == null) {
            map = null;
            t = null;
        } else {
            t = (T) map.get(cls);
        }
        if (t == null) {
            t = (T) f6114a.get(cls);
        }
        if (t == null || (t instanceof LazyGetter)) {
            T t2 = (T) a(map, cls);
            if (t2 != null) {
                return t2;
            }
            if (!sHasSetupProxy) {
                Printer printer2 = getPrinter();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get proxy but not initialized! sLazyInitializer: ");
                sb2.append(d);
                printer2.print(sb2.toString());
                Initializer initializer = d;
                if (initializer != null) {
                    initializer.doInitialize();
                    T t3 = (T) a(map, cls);
                    if (t3 != null) {
                        return t3;
                    }
                } else if (z) {
                    return null;
                }
            }
            if (z) {
                return null;
            }
            T t4 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.alibaba.ariver.kernel.common.RVProxy.1
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    Class<?> returnType = method.getReturnType();
                    Printer printer3 = RVProxy.getPrinter();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unimplemented proxy:");
                    sb3.append(cls.getSimpleName());
                    sb3.append(".");
                    sb3.append(method.getName());
                    printer3.print(sb3.toString());
                    if (returnType.isPrimitive()) {
                        if (returnType == Boolean.TYPE || returnType == Boolean.TYPE) {
                            return Boolean.FALSE;
                        }
                        return 0;
                    }
                    return null;
                }
            });
            set(cls, t4);
            return t4;
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002d A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #1 {all -> 0x0027, blocks: (B:16:0x001f, B:23:0x002d, B:27:0x0037, B:31:0x0064, B:32:0x0068, B:35:0x006d, B:45:0x00d4, B:37:0x0077, B:39:0x0085, B:42:0x00ae), top: B:51:0x001f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> T a(java.util.Map<java.lang.Class<?>, java.lang.Object> r8, java.lang.Class<T> r9) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.RVProxy.a(java.util.Map, java.lang.Class):java.lang.Object");
    }
}
