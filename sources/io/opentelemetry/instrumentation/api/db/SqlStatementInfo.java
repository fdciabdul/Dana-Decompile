package io.opentelemetry.instrumentation.api.db;

import j$.util.function.Function;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public abstract class SqlStatementInfo {
    @Nullable
    public abstract String getFullStatement();

    @Nullable
    public abstract String getOperation();

    @Nullable
    public abstract String getTable();

    public static SqlStatementInfo create(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new AutoValue_SqlStatementInfo(str, str2, str3);
    }

    public SqlStatementInfo mapTable(Function<String, String> function) {
        return create(getFullStatement(), getOperation(), function.apply(getTable()));
    }
}
