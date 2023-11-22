package io.opentelemetry.instrumentation.api.instrumenter.code;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface CodeAttributesGetter<REQUEST> {
    @Nullable
    Class<?> codeClass(REQUEST request);

    @Nullable
    String methodName(REQUEST request);
}
