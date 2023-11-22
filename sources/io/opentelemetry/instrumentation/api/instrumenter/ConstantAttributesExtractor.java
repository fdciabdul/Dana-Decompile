package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class ConstantAttributesExtractor<REQUEST, RESPONSE, T> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final AttributeKey<T> attributeKey;
    private final T attributeValue;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstantAttributesExtractor(AttributeKey<T> attributeKey, T t) {
        this.attributeKey = attributeKey;
        this.attributeValue = t;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        attributesBuilder.put((AttributeKey<AttributeKey<T>>) this.attributeKey, (AttributeKey<T>) this.attributeValue);
    }
}
