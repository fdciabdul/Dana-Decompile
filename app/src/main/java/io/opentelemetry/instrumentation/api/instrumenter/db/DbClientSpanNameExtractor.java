package io.opentelemetry.instrumentation.api.instrumenter.db;

import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.instrumentation.api.db.SqlStatementInfo;
import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* loaded from: classes9.dex */
public abstract class DbClientSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private static final String DEFAULT_SPAN_NAME = "DB Query";

    public static <REQUEST> SpanNameExtractor<REQUEST> create(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
        return new GenericDbClientSpanNameExtractor(dbClientAttributesGetter);
    }

    public static <REQUEST> SpanNameExtractor<REQUEST> create(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
        return new SqlClientSpanNameExtractor(sqlClientAttributesGetter);
    }

    private DbClientSpanNameExtractor() {
    }

    protected String computeSpanName(String str, String str2, String str3) {
        if (str2 == null) {
            return str == null ? DEFAULT_SPAN_NAME : str;
        }
        StringBuilder sb = new StringBuilder(str2);
        if (str != null || str3 != null) {
            sb.append(InputCardNumberView.DIVIDER);
        }
        if (str != null && (str3 == null || str3.indexOf(46) == -1)) {
            sb.append(str);
            if (str3 != null) {
                sb.append('.');
            }
        }
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    /* loaded from: classes9.dex */
    static final class GenericDbClientSpanNameExtractor<REQUEST> extends DbClientSpanNameExtractor<REQUEST> {
        private final DbClientAttributesGetter<REQUEST> getter;

        private GenericDbClientSpanNameExtractor(DbClientAttributesGetter<REQUEST> dbClientAttributesGetter) {
            super();
            this.getter = dbClientAttributesGetter;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
        public final String extract(REQUEST request) {
            return computeSpanName(this.getter.name(request), this.getter.operation(request), null);
        }
    }

    /* loaded from: classes9.dex */
    static final class SqlClientSpanNameExtractor<REQUEST> extends DbClientSpanNameExtractor<REQUEST> {
        private static final SqlStatementSanitizer sanitizer = SqlStatementSanitizer.create(true);
        private final SqlClientAttributesGetter<REQUEST> getter;

        private SqlClientSpanNameExtractor(SqlClientAttributesGetter<REQUEST> sqlClientAttributesGetter) {
            super();
            this.getter = sqlClientAttributesGetter;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
        public final String extract(REQUEST request) {
            String name = this.getter.name(request);
            SqlStatementInfo sanitize = sanitizer.sanitize(this.getter.rawStatement(request));
            return computeSpanName(name, sanitize.getOperation(), sanitize.getTable());
        }
    }
}
