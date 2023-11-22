package io.opentelemetry.instrumentation.api.instrumenter.util;

import io.opentelemetry.instrumentation.api.internal.ClassNames;
import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes9.dex */
public final class SpanNames {
    private static final Cache<Class<?>, Map<String, String>> spanNameCaches = Cache.CC.weak();

    public static String fromMethod(Method method) {
        return fromMethod(method.getDeclaringClass(), method.getName());
    }

    public static String fromMethod(Class<?> cls, String str) {
        Map<String, String> computeIfAbsent = spanNameCaches.computeIfAbsent(cls, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.util.SpanNames$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SpanNames.lambda$fromMethod$0((Class) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
        String str2 = computeIfAbsent.get(str);
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ClassNames.simpleName(cls));
        sb.append(".");
        sb.append(str);
        String obj = sb.toString();
        computeIfAbsent.put(str, obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$fromMethod$0(Class cls) {
        return new ConcurrentHashMap();
    }

    private SpanNames() {
    }
}
