package io.opentelemetry.instrumentation.api.instrumenter.util;

import io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter;

/* loaded from: classes9.dex */
public abstract class ClassAndMethod {
    public abstract Class<?> declaringClass();

    public abstract String methodName();

    public static CodeAttributesGetter<ClassAndMethod> codeAttributesGetter() {
        return ClassAndMethodAttributesGetter.INSTANCE;
    }

    public static ClassAndMethod create(Class<?> cls, String str) {
        return new AutoValue_ClassAndMethod(cls, str);
    }
}
