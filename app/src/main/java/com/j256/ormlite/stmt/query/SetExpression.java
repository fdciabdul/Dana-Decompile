package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public class SetExpression extends BaseComparison {
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

    public SetExpression(String str, FieldType fieldType, String str2) throws SQLException {
        super(str, fieldType, str2, true);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        sb.append("= ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public void appendArgOrValue(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, List<ArgumentHolder> list, Object obj) {
        sb.append(obj);
        sb.append(InputCardNumberView.DIVIDER);
    }
}
