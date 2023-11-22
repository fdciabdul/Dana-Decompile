package io.opentelemetry.instrumentation.api.instrumenter.db;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.db.SqlStatementInfo;
import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes9.dex */
public final class SqlClientAttributesExtractor<REQUEST, RESPONSE> extends DbClientCommonAttributesExtractor<REQUEST, RESPONSE, SqlClientAttributesGetter<REQUEST>> {
    private final AttributeKey<String> dbTableAttribute;
    private final SqlStatementSanitizer sanitizer;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.db.DbClientCommonAttributesExtractor, io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final /* bridge */ /* synthetic */ SpanKey internalGetSpanKey() {
        return super.internalGetSpanKey();
    }

    public static <REQUEST, RESPONSE> SqlClientAttributesExtractor<REQUEST, RESPONSE> create(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
        return builder(sqlClientAttributesGetter).build();
    }

    public static <REQUEST, RESPONSE> SqlClientAttributesExtractorBuilder<REQUEST, RESPONSE> builder(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
        return new SqlClientAttributesExtractorBuilder<>(sqlClientAttributesGetter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SqlClientAttributesExtractor(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter, AttributeKey<String> attributeKey, SqlStatementSanitizer sqlStatementSanitizer) {
        super(sqlClientAttributesGetter);
        this.dbTableAttribute = attributeKey;
        this.sanitizer = sqlStatementSanitizer;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.db.DbClientCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        SqlStatementInfo sanitize = this.sanitizer.sanitize(((SqlClientAttributesGetter) this.getter).rawStatement(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_STATEMENT, sanitize.getFullStatement());
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.DB_OPERATION, sanitize.getOperation());
        AttributesExtractorUtil.internalSet(attributesBuilder, this.dbTableAttribute, sanitize.getTable());
    }
}
