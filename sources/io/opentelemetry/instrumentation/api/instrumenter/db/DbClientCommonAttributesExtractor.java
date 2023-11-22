package io.opentelemetry.instrumentation.api.instrumenter.db;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.db.DbClientCommonAttributesGetter;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
abstract class DbClientCommonAttributesExtractor<REQUEST, RESPONSE, GETTER extends DbClientCommonAttributesGetter<REQUEST>> implements AttributesExtractor<REQUEST, RESPONSE>, SpanKeyProvider {
    final GETTER getter;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DbClientCommonAttributesExtractor(GETTER getter) {
        this.getter = getter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_SYSTEM, this.getter.system(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_USER, this.getter.user(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_NAME, this.getter.name(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_CONNECTION_STRING, this.getter.connectionString(request));
    }

    public SpanKey internalGetSpanKey() {
        return SpanKey.DB_CLIENT;
    }
}
