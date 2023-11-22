package io.opentelemetry.instrumentation.api.instrumenter.util;

import io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
enum ClassAndMethodAttributesGetter implements CodeAttributesGetter<ClassAndMethod> {
    INSTANCE;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter
    @Nullable
    public final Class<?> codeClass(ClassAndMethod classAndMethod) {
        return classAndMethod.declaringClass();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter
    @Nullable
    public final String methodName(ClassAndMethod classAndMethod) {
        return classAndMethod.methodName();
    }
}
