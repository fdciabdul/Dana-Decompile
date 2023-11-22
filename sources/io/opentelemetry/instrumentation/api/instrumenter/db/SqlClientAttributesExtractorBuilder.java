package io.opentelemetry.instrumentation.api.instrumenter.db;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Objects;

/* loaded from: classes9.dex */
public final class SqlClientAttributesExtractorBuilder<REQUEST, RESPONSE> {
    final SqlClientAttributesGetter<REQUEST> getter;
    AttributeKey<String> dbTableAttribute = SemanticAttributes.DB_SQL_TABLE;
    boolean statementSanitizationEnabled = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SqlClientAttributesExtractorBuilder(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
        this.getter = sqlClientAttributesGetter;
    }

    public final SqlClientAttributesExtractorBuilder<REQUEST, RESPONSE> setTableAttribute(AttributeKey<String> attributeKey) {
        this.dbTableAttribute = (AttributeKey) Objects.requireNonNull(attributeKey);
        return this;
    }

    public final SqlClientAttributesExtractorBuilder<REQUEST, RESPONSE> setStatementSanitizationEnabled(boolean z) {
        this.statementSanitizationEnabled = z;
        return this;
    }

    public final SqlClientAttributesExtractor<REQUEST, RESPONSE> build() {
        return new SqlClientAttributesExtractor<>(this.getter, this.dbTableAttribute, SqlStatementSanitizer.create(this.statementSanitizationEnabled));
    }
}
