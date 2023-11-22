package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class StatementBuilder<T, ID> {
    private static Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
    protected boolean addTableName;
    protected final Dao<T, ID> dao;
    protected final DatabaseType databaseType;
    protected final TableInfo<T, ID> tableInfo;
    protected final String tableName;
    protected StatementType type;
    protected Where<T, ID> where = null;

    protected abstract void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    protected abstract void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    protected FieldType[] getResultFieldTypes() {
        return null;
    }

    protected boolean shouldPrependTableNameToColumns() {
        return false;
    }

    public StatementBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao, StatementType statementType) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.tableName = tableInfo.getTableName();
        this.dao = dao;
        this.type = statementType;
        if (statementType.isOkForStatementBuilder()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Building a statement from a ");
        sb.append(statementType);
        sb.append(" statement is not allowed");
        throw new IllegalStateException(sb.toString());
    }

    public Where<T, ID> where() {
        Where<T, ID> where = new Where<>(this.tableInfo, this, this.databaseType);
        this.where = where;
        return where;
    }

    public void setWhere(Where<T, ID> where) {
        this.where = where;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MappedPreparedStmt<T, ID> prepareStatement(Long l, boolean z) throws SQLException {
        List<ArgumentHolder> arrayList = new ArrayList<>();
        String buildStatementString = buildStatementString(arrayList);
        ArgumentHolder[] argumentHolderArr = (ArgumentHolder[]) arrayList.toArray(new ArgumentHolder[arrayList.size()]);
        FieldType[] resultFieldTypes = getResultFieldTypes();
        FieldType[] fieldTypeArr = new FieldType[arrayList.size()];
        for (int i = 0; i < argumentHolderArr.length; i++) {
            fieldTypeArr[i] = argumentHolderArr[i].getFieldType();
        }
        if (!this.type.isOkForStatementBuilder()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Building a statement from a ");
            sb.append(this.type);
            sb.append(" statement is not allowed");
            throw new IllegalStateException(sb.toString());
        }
        TableInfo<T, ID> tableInfo = this.tableInfo;
        if (this.databaseType.isLimitSqlSupported()) {
            l = null;
        }
        return new MappedPreparedStmt<>(tableInfo, buildStatementString, fieldTypeArr, resultFieldTypes, argumentHolderArr, l, this.type, z);
    }

    public String prepareStatementString() throws SQLException {
        return buildStatementString(new ArrayList());
    }

    public StatementInfo prepareStatementInfo() throws SQLException {
        ArrayList arrayList = new ArrayList();
        return new StatementInfo(buildStatementString(arrayList), arrayList);
    }

    public void reset() {
        this.where = null;
    }

    protected String buildStatementString(List<ArgumentHolder> list) throws SQLException {
        StringBuilder sb = new StringBuilder(128);
        appendStatementString(sb, list);
        String obj = sb.toString();
        logger.debug("built statement {}", obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendStatementStart(sb, list);
        appendWhereStatement(sb, list, WhereOperation.FIRST);
        appendStatementEnd(sb, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, WhereOperation whereOperation) throws SQLException {
        if (this.where == null) {
            return whereOperation == WhereOperation.FIRST;
        }
        whereOperation.appendBefore(sb);
        this.where.appendSql(this.addTableName ? getTableName() : null, sb, list);
        whereOperation.appendAfter(sb);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldType verifyColumnName(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    protected String getTableName() {
        return this.tableName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StatementType getType() {
        return this.type;
    }

    /* loaded from: classes8.dex */
    public enum StatementType {
        SELECT(true, true, false, false),
        SELECT_LONG(true, true, false, false),
        SELECT_RAW(true, true, false, false),
        UPDATE(true, false, true, false),
        DELETE(true, false, true, false),
        EXECUTE(false, false, false, true);

        private final boolean okForExecute;
        private final boolean okForQuery;
        private final boolean okForStatementBuilder;
        private final boolean okForUpdate;

        StatementType(boolean z, boolean z2, boolean z3, boolean z4) {
            this.okForStatementBuilder = z;
            this.okForQuery = z2;
            this.okForUpdate = z3;
            this.okForExecute = z4;
        }

        public final boolean isOkForStatementBuilder() {
            return this.okForStatementBuilder;
        }

        public final boolean isOkForQuery() {
            return this.okForQuery;
        }

        public final boolean isOkForUpdate() {
            return this.okForUpdate;
        }

        public final boolean isOkForExecute() {
            return this.okForExecute;
        }
    }

    /* loaded from: classes8.dex */
    public static class StatementInfo {
        private final List<ArgumentHolder> argList;
        private final String statement;

        private StatementInfo(String str, List<ArgumentHolder> list) {
            this.argList = list;
            this.statement = str;
        }

        public String getStatement() {
            return this.statement;
        }

        public List<ArgumentHolder> getArgList() {
            return this.argList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public enum WhereOperation {
        FIRST("WHERE ", null),
        AND("AND (", ") "),
        OR("OR (", ") ");

        private final String after;
        private final String before;

        WhereOperation(String str, String str2) {
            this.before = str;
            this.after = str2;
        }

        public final void appendBefore(StringBuilder sb) {
            String str = this.before;
            if (str != null) {
                sb.append(str);
            }
        }

        public final void appendAfter(StringBuilder sb) {
            String str = this.after;
            if (str != null) {
                sb.append(str);
            }
        }
    }
}
