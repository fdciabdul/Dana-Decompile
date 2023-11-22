package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public class SimpleComparison extends BaseComparison {
    public static final String EQUAL_TO_OPERATION = "=";
    public static final String GREATER_THAN_EQUAL_TO_OPERATION = ">=";
    public static final String GREATER_THAN_OPERATION = ">";
    public static final String LESS_THAN_EQUAL_TO_OPERATION = "<=";
    public static final String LESS_THAN_OPERATION = "<";
    public static final String LIKE_OPERATION = "LIKE";
    public static final String NOT_EQUAL_TO_OPERATION = "<>";
    private final String operation;

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Clause
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ void appendValue(DatabaseType databaseType, StringBuilder sb, List list) throws SQLException {
        super.appendValue(databaseType, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SimpleComparison(String str, FieldType fieldType, Object obj, String str2) throws SQLException {
        super(str, fieldType, obj, true);
        this.operation = str2;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        sb.append(this.operation);
        sb.append(InputCardNumberView.DIVIDER);
    }
}
