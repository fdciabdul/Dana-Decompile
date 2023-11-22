package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class AttributesExtractorUtil {
    public static <T> void internalSet(AttributesBuilder attributesBuilder, AttributeKey<T> attributeKey, @Nullable T t) {
        if (t != null) {
            attributesBuilder.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
        }
    }

    private AttributesExtractorUtil() {
    }
}
