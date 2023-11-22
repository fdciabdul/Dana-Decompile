package io.opentelemetry.instrumentation.api.db;

import io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer;
import io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics;
import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import j$.util.function.Function;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class SqlStatementSanitizer {
    private final boolean statementSanitizationEnabled;
    private static final SupportabilityMetrics supportability = SupportabilityMetrics.instance();
    private static final Cache<CacheKey, SqlStatementInfo> sqlToStatementInfoCache = Cache.CC.bounded(1000);

    public static SqlStatementSanitizer create(boolean z) {
        return new SqlStatementSanitizer(z);
    }

    private SqlStatementSanitizer(boolean z) {
        this.statementSanitizationEnabled = z;
    }

    public final SqlStatementInfo sanitize(@Nullable String str) {
        return sanitize(str, SqlDialect.DEFAULT);
    }

    public final SqlStatementInfo sanitize(@Nullable final String str, final SqlDialect sqlDialect) {
        if (!this.statementSanitizationEnabled || str == null) {
            return SqlStatementInfo.create(str, null, null);
        }
        return sqlToStatementInfoCache.computeIfAbsent(CacheKey.create(str, sqlDialect), new Function() { // from class: io.opentelemetry.instrumentation.api.db.SqlStatementSanitizer$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SqlStatementSanitizer.lambda$sanitize$0(str, sqlDialect, (SqlStatementSanitizer.CacheKey) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SqlStatementInfo lambda$sanitize$0(String str, SqlDialect sqlDialect, CacheKey cacheKey) {
        supportability.incrementCounter(SupportabilityMetrics.CounterNames.SQL_STATEMENT_SANITIZER_CACHE_MISS);
        return AutoSqlSanitizer.sanitize(str, sqlDialect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class CacheKey {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract SqlDialect getDialect();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String getStatement();

        static CacheKey create(String str, SqlDialect sqlDialect) {
            return new AutoValue_SqlStatementSanitizer_CacheKey(str, sqlDialect);
        }
    }
}
