package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class Java16RecordComponentsLoader {
    public static final Java16RecordComponentsLoader INSTANCE = new Java16RecordComponentsLoader();
    private static Cache _cache;

    /* loaded from: classes.dex */
    public static final class Cache {
        private final Method getAccessor;
        private final Method getType;

        public Cache(Method method, Method method2) {
            this.getType = method;
            this.getAccessor = method2;
        }

        public final Method getGetType() {
            return this.getType;
        }

        public final Method getGetAccessor() {
            return this.getAccessor;
        }
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new Cache(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new Cache(null, null);
        }
    }

    private final Cache initCache(Object obj) {
        Cache cache = _cache;
        if (cache == null) {
            Cache buildCache = buildCache(obj);
            _cache = buildCache;
            return buildCache;
        }
        return cache;
    }

    public final Class<?> loadGetType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        Method getType = initCache(obj).getGetType();
        if (getType == null) {
            return null;
        }
        Object invoke = getType.invoke(obj, new Object[0]);
        Intrinsics.checkNotNull(invoke);
        return (Class) invoke;
    }

    public final Method loadGetAccessor(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        Method getAccessor = initCache(obj).getGetAccessor();
        if (getAccessor == null) {
            return null;
        }
        Object invoke = getAccessor.invoke(obj, new Object[0]);
        Intrinsics.checkNotNull(invoke);
        return (Method) invoke;
    }
}
