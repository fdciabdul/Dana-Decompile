package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.table.TableInfo;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public class DeleteBuilder<T, ID> extends StatementBuilder<T, ID> {
    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) {
    }

    public DeleteBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.DELETE);
    }

    public PreparedDelete<T> prepare() throws SQLException {
        return super.prepareStatement(null, false);
    }

    public int delete() throws SQLException {
        return this.dao.delete((PreparedDelete) prepare());
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public void reset() {
        super.reset();
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        sb.append("DELETE FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
        sb.append(InputCardNumberView.DIVIDER);
    }
}
