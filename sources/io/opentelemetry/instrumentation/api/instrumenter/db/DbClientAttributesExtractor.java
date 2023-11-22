package io.opentelemetry.instrumentation.api.instrumenter.db;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes9.dex */
public final class DbClientAttributesExtractor<REQUEST, RESPONSE> extends DbClientCommonAttributesExtractor<REQUEST, RESPONSE, DbClientAttributesGetter<REQUEST>> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.db.DbClientCommonAttributesExtractor, io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final /* bridge */ /* synthetic */ SpanKey internalGetSpanKey() {
        return super.internalGetSpanKey();
    }

    public static <REQUEST, RESPONSE> DbClientAttributesExtractor<REQUEST, RESPONSE> create(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
        return new DbClientAttributesExtractor<>(dbClientAttributesGetter);
    }

    DbClientAttributesExtractor(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
        super(dbClientAttributesGetter);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.db.DbClientCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_STATEMENT, ((DbClientAttributesGetter) this.getter).statement(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_OPERATION, ((DbClientAttributesGetter) this.getter).operation(request));
    }
}
