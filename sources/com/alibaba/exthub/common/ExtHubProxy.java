package com.alibaba.exthub.common;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtHubProxy {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Object> f6264a = new ConcurrentHashMap();

    public static <T> void set(Class<? super T> cls, T t) {
        a(cls, t);
    }

    public static <T> T get(Class<T> cls) {
        Map<Class<?>, Object> map = f6264a;
        T t = (T) map.get(cls);
        if (t != null) {
            return t;
        }
        synchronized (map) {
            T t2 = (T) map.get(cls);
            if (t2 != null) {
                return t2;
            }
            DefaultImpl defaultImpl = (DefaultImpl) cls.getAnnotation(DefaultImpl.class);
            if (defaultImpl != null) {
                try {
                    Class<?> cls2 = Class.forName(defaultImpl.value());
                    if (cls.isAssignableFrom(cls2)) {
                        T t3 = (T) cls2.newInstance();
                        set(cls, t3);
                        return t3;
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DefaultImpl instantiate exception!");
                    sb.append(th.getMessage());
                    InstrumentInjector.log_d("ExtHubProxy", sb.toString());
                }
            }
            return null;
        }
    }

    private static <T> void a(Class cls, Object obj) {
        if (cls == null) {
            return;
        }
        if (obj == null) {
            f6264a.remove(cls);
        } else if (!cls.isInterface()) {
            StringBuilder sb = new StringBuilder();
            sb.append("set proxy class must a Interface: ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        } else {
            Map<Class<?>, Object> map = f6264a;
            synchronized (map) {
                map.put(cls, obj);
            }
        }
    }
}
