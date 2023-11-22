package kotlin.reflect.full;

import id.dana.kyb.constant.KybDataSource;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader;", "", "()V", SemanticAttributes.DbSystemValues.CACHE, "Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "getCache", "()Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "setCache", "(Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;)V", "buildCache", "loadRepeatableContainer", "Ljava/lang/Class;", "", "klass", KybDataSource.CACHE, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
final class Java8RepeatableContainerLoader {
    public static final Java8RepeatableContainerLoader INSTANCE = new Java8RepeatableContainerLoader();
    private static Cache cache;

    private Java8RepeatableContainerLoader() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "", "Ljava/lang/Class;", "", "repeatableClass", "Ljava/lang/Class;", "getRepeatableClass", "()Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "valueMethod", "Ljava/lang/reflect/Method;", "getValueMethod", "()Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Cache {
        private final Class<? extends Annotation> repeatableClass;
        private final Method valueMethod;

        public Cache(Class<? extends Annotation> cls, Method method) {
            this.repeatableClass = cls;
            this.valueMethod = method;
        }

        @JvmName(name = "getRepeatableClass")
        public final Class<? extends Annotation> getRepeatableClass() {
            return this.repeatableClass;
        }

        @JvmName(name = "getValueMethod")
        public final Method getValueMethod() {
            return this.valueMethod;
        }
    }

    private final Cache buildCache() {
        try {
            Class<?> cls = Class.forName("java.lang.annotation.Repeatable");
            Intrinsics.checkNotNull(cls);
            return new Cache(cls, cls.getMethod("value", new Class[0]));
        } catch (ClassNotFoundException unused) {
            return new Cache(null, null);
        }
    }

    public final Class<? extends Annotation> loadRepeatableContainer(Class<? extends Annotation> klass) {
        Annotation annotation;
        Method valueMethod;
        Intrinsics.checkNotNullParameter(klass, "");
        Cache cache2 = cache;
        if (cache2 == null) {
            synchronized (this) {
                Java8RepeatableContainerLoader java8RepeatableContainerLoader = INSTANCE;
                Cache cache3 = cache;
                if (cache3 == null) {
                    cache2 = java8RepeatableContainerLoader.buildCache();
                    cache = cache2;
                } else {
                    cache2 = cache3;
                }
            }
        }
        Class repeatableClass = cache2.getRepeatableClass();
        if (repeatableClass == null || (annotation = klass.getAnnotation(repeatableClass)) == null || (valueMethod = cache2.getValueMethod()) == null) {
            return null;
        }
        Object invoke = valueMethod.invoke(annotation, new Object[0]);
        Intrinsics.checkNotNull(invoke);
        return (Class) invoke;
    }
}
