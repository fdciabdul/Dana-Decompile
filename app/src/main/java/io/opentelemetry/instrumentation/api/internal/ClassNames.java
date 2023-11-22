package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import j$.util.function.Function;

/* loaded from: classes9.dex */
public final class ClassNames {
    private static final Cache<Class<?>, String> simpleNames = Cache.CC.weak();

    public static String simpleName(Class<?> cls) {
        return simpleNames.computeIfAbsent(cls, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.ClassNames$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                String computeSimpleName;
                computeSimpleName = ClassNames.computeSimpleName((Class) obj);
                return computeSimpleName;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String computeSimpleName(Class<?> cls) {
        if (!cls.isAnonymousClass()) {
            return cls.getSimpleName();
        }
        String name = cls.getName();
        if (cls.getPackage() != null) {
            String name2 = cls.getPackage().getName();
            return !name2.isEmpty() ? name.substring(name2.length() + 1) : name;
        }
        return name;
    }

    private ClassNames() {
    }
}
