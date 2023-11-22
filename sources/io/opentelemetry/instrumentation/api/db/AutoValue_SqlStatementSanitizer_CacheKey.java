package io.opentelemetry.instrumentation.api.db;

import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;

/* loaded from: classes9.dex */
final class AutoValue_SqlStatementSanitizer_CacheKey extends SqlStatementSanitizer.CacheKey {
    private final SqlDialect dialect;
    private final String statement;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SqlStatementSanitizer_CacheKey(String str, SqlDialect sqlDialect) {
        if (str == null) {
            throw new NullPointerException("Null statement");
        }
        this.statement = str;
        if (sqlDialect == null) {
            throw new NullPointerException("Null dialect");
        }
        this.dialect = sqlDialect;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer.CacheKey
    final String getStatement() {
        return this.statement;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer.CacheKey
    final SqlDialect getDialect() {
        return this.dialect;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CacheKey{statement=");
        sb.append(this.statement);
        sb.append(", dialect=");
        sb.append(this.dialect);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SqlStatementSanitizer.CacheKey) {
            SqlStatementSanitizer.CacheKey cacheKey = (SqlStatementSanitizer.CacheKey) obj;
            return this.statement.equals(cacheKey.getStatement()) && this.dialect.equals(cacheKey.getDialect());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.statement.hashCode() ^ 1000003) * 1000003) ^ this.dialect.hashCode();
    }
}
