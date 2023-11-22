package io.opentelemetry.instrumentation.api.instrumenter.code;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class CodeAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final CodeAttributesGetter<REQUEST> getter;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    public static <REQUEST, RESPONSE> CodeAttributesExtractor<REQUEST, RESPONSE> create(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        return new CodeAttributesExtractor<>(codeAttributesGetter);
    }

    private CodeAttributesExtractor(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        this.getter = codeAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        Class<?> codeClass = this.getter.codeClass(request);
        if (codeClass != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.CODE_NAMESPACE, codeClass.getName());
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.CODE_FUNCTION, this.getter.methodName(request));
    }
}
