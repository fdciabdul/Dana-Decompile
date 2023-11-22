package io.opentelemetry.instrumentation.api.db;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class AutoValue_SqlStatementInfo extends SqlStatementInfo {
    private final String fullStatement;
    private final String operation;
    private final String table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SqlStatementInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.fullStatement = str;
        this.operation = str2;
        this.table = str3;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public final String getFullStatement() {
        return this.fullStatement;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public final String getOperation() {
        return this.operation;
    }

    @Override // io.opentelemetry.instrumentation.api.db.SqlStatementInfo
    @Nullable
    public final String getTable() {
        return this.table;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SqlStatementInfo{fullStatement=");
        sb.append(this.fullStatement);
        sb.append(", operation=");
        sb.append(this.operation);
        sb.append(", table=");
        sb.append(this.table);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SqlStatementInfo) {
            SqlStatementInfo sqlStatementInfo = (SqlStatementInfo) obj;
            String str = this.fullStatement;
            if (str != null ? str.equals(sqlStatementInfo.getFullStatement()) : sqlStatementInfo.getFullStatement() == null) {
                String str2 = this.operation;
                if (str2 != null ? str2.equals(sqlStatementInfo.getOperation()) : sqlStatementInfo.getOperation() == null) {
                    String str3 = this.table;
                    if (str3 == null) {
                        if (sqlStatementInfo.getTable() == null) {
                            return true;
                        }
                    } else if (str3.equals(sqlStatementInfo.getTable())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.fullStatement;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.operation;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.table;
        return ((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ (str3 != null ? str3.hashCode() : 0);
    }
}
