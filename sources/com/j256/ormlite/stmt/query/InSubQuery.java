package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public class InSubQuery extends BaseComparison {

    /* renamed from: in  reason: collision with root package name */
    private final boolean f7666in;
    private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Clause
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public InSubQuery(String str, FieldType fieldType, QueryBuilder.InternalQueryBuilderWrapper internalQueryBuilderWrapper, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.subQueryBuilder = internalQueryBuilderWrapper;
        this.f7666in = z;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        if (this.f7666in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        sb.append('(');
        this.subQueryBuilder.appendStatementString(sb, list);
        FieldType[] resultFieldTypes = this.subQueryBuilder.getResultFieldTypes();
        if (resultFieldTypes != null) {
            if (resultFieldTypes.length != 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("There must be only 1 result column in sub-query but we found ");
                sb2.append(resultFieldTypes.length);
                throw new SQLException(sb2.toString());
            } else if (this.fieldType.getSqlType() != resultFieldTypes[0].getSqlType()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Outer column ");
                sb3.append(this.fieldType);
                sb3.append(" is not the same type as inner column ");
                sb3.append(resultFieldTypes[0]);
                throw new SQLException(sb3.toString());
            }
        }
        sb.append(") ");
    }
}
