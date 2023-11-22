package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.query.ColumnNameOrRawSql;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    private String alias;
    private String countOfQuery;
    private boolean distinct;
    private List<ColumnNameOrRawSql> groupByList;
    private String having;
    private final FieldType idField;
    private boolean isInnerQuery;
    private List<QueryBuilder<T, ID>.JoinInfo> joinList;
    private Long limit;
    private Long offset;
    private List<OrderBy> orderByList;
    private FieldType[] resultFieldTypes;
    private boolean selectIdColumn;
    private List<ColumnNameOrRawSql> selectList;

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.SELECT);
        FieldType idField = tableInfo.getIdField();
        this.idField = idField;
        this.selectIdColumn = idField != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableInnerQuery() {
        this.isInnerQuery = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSelectColumnCount() {
        if (this.countOfQuery != null) {
            return 1;
        }
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSelectColumnsAsString() {
        if (this.countOfQuery != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("COUNT(");
            sb.append(this.countOfQuery);
            sb.append(")");
            return sb.toString();
        }
        List<ColumnNameOrRawSql> list = this.selectList;
        return list == null ? "" : list.toString();
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return super.prepareStatement(this.limit, this.selectList == null);
    }

    public QueryBuilder<T, ID> selectColumns(String... strArr) {
        for (String str : strArr) {
            addSelectColumnToList(str);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectColumns(Iterable<String> iterable) {
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            addSelectColumnToList(it.next());
        }
        return this;
    }

    public QueryBuilder<T, ID> selectRaw(String... strArr) {
        for (String str : strArr) {
            addSelectToList(ColumnNameOrRawSql.withRawSql(str));
        }
        return this;
    }

    public QueryBuilder<T, ID> groupBy(String str) {
        if (verifyColumnName(str).isForeignCollection()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't groupBy foreign colletion field: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        addGroupBy(ColumnNameOrRawSql.withColumnName(str));
        return this;
    }

    public QueryBuilder<T, ID> groupByRaw(String str) {
        addGroupBy(ColumnNameOrRawSql.withRawSql(str));
        return this;
    }

    public QueryBuilder<T, ID> orderBy(String str, boolean z) {
        if (verifyColumnName(str).isForeignCollection()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't orderBy foreign colletion field: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        addOrderBy(new OrderBy(str, z));
        return this;
    }

    public QueryBuilder<T, ID> orderByRaw(String str) {
        addOrderBy(new OrderBy(str, (ArgumentHolder[]) null));
        return this;
    }

    public QueryBuilder<T, ID> orderByRaw(String str, ArgumentHolder... argumentHolderArr) {
        addOrderBy(new OrderBy(str, argumentHolderArr));
        return this;
    }

    public QueryBuilder<T, ID> distinct() {
        this.distinct = true;
        this.selectIdColumn = false;
        return this;
    }

    public QueryBuilder<T, ID> limit(Long l) {
        this.limit = l;
        return this;
    }

    public QueryBuilder<T, ID> offset(Long l) throws SQLException {
        if (this.databaseType.isOffsetSqlSupported()) {
            this.offset = l;
            return this;
        }
        throw new SQLException("Offset is not supported by this database");
    }

    public QueryBuilder<T, ID> setCountOf(boolean z) {
        return setCountOf("*");
    }

    public QueryBuilder<T, ID> setCountOf(String str) {
        this.countOfQuery = str;
        return this;
    }

    public QueryBuilder<T, ID> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, null, null, queryBuilder, joinWhereOperation);
        return this;
    }

    public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, str, str2, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, str, str2, queryBuilder, joinWhereOperation);
        return this;
    }

    public List<T> query() throws SQLException {
        return this.dao.query(prepare());
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]);
    }

    public T queryForFirst() throws SQLException {
        return this.dao.queryForFirst(prepare());
    }

    public String[] queryRawFirst() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return this.dao.iterator(prepare());
    }

    public long countOf() throws SQLException {
        String str = this.countOfQuery;
        try {
            setCountOf(true);
            return this.dao.countOf(prepare());
        } finally {
            setCountOf(str);
        }
    }

    public long countOf(String str) throws SQLException {
        String str2 = this.countOfQuery;
        try {
            setCountOf(str);
            return this.dao.countOf(prepare());
        } finally {
            setCountOf(str2);
        }
    }

    public QueryBuilder<T, ID> setAlias(String str) {
        this.alias = str;
        return this;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public void reset() {
        super.reset();
        this.distinct = false;
        this.selectIdColumn = this.idField != null;
        List<ColumnNameOrRawSql> list = this.selectList;
        if (list != null) {
            list.clear();
            this.selectList = null;
        }
        List<OrderBy> list2 = this.orderByList;
        if (list2 != null) {
            list2.clear();
            this.orderByList = null;
        }
        List<ColumnNameOrRawSql> list3 = this.groupByList;
        if (list3 != null) {
            list3.clear();
            this.groupByList = null;
        }
        this.isInnerQuery = false;
        this.countOfQuery = null;
        this.having = null;
        this.limit = null;
        this.offset = null;
        List<QueryBuilder<T, ID>.JoinInfo> list4 = this.joinList;
        if (list4 != null) {
            list4.clear();
            this.joinList = null;
        }
        this.addTableName = false;
        this.alias = null;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        if (this.joinList == null) {
            setAddTableName(false);
        } else {
            setAddTableName(true);
        }
        sb.append("SELECT ");
        if (this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        if (this.countOfQuery == null) {
            appendSelects(sb);
        } else {
            this.type = StatementBuilder.StatementType.SELECT_LONG;
            sb.append("COUNT(");
            sb.append(this.countOfQuery);
            sb.append(") ");
        }
        sb.append("FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableName);
        if (this.alias != null) {
            appendAlias(sb);
        }
        sb.append(InputCardNumberView.DIVIDER);
        if (this.joinList != null) {
            appendJoinSql(sb);
        }
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.j256.ormlite.stmt.StatementBuilder
    public boolean appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, StatementBuilder.WhereOperation whereOperation) throws SQLException {
        StatementBuilder.WhereOperation whereOperation2;
        boolean z = whereOperation == StatementBuilder.WhereOperation.FIRST;
        if (this.where != null) {
            z = super.appendWhereStatement(sb, list, whereOperation);
        }
        List<QueryBuilder<T, ID>.JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (QueryBuilder<T, ID>.JoinInfo joinInfo : list2) {
                if (z) {
                    whereOperation2 = StatementBuilder.WhereOperation.FIRST;
                } else {
                    whereOperation2 = joinInfo.operation.whereOperation;
                }
                z = joinInfo.queryBuilder.appendWhereStatement(sb, list, whereOperation2);
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendGroupBys(sb);
        appendHaving(sb);
        appendOrderBys(sb, list);
        if (!this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        appendOffset(sb);
        setAddTableName(false);
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected boolean shouldPrependTableNameToColumns() {
        return this.joinList != null;
    }

    protected void appendTableQualifier(StringBuilder sb) {
        this.databaseType.appendEscapedEntityName(sb, getTableName());
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    protected String getTableName() {
        String str = this.alias;
        return str == null ? this.tableName : str;
    }

    private void addOrderBy(OrderBy orderBy) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList();
        }
        this.orderByList.add(orderBy);
    }

    private void addGroupBy(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.groupByList == null) {
            this.groupByList = new ArrayList();
        }
        this.groupByList.add(columnNameOrRawSql);
        this.selectIdColumn = false;
    }

    private void setAddTableName(boolean z) {
        this.addTableName = z;
        List<QueryBuilder<T, ID>.JoinInfo> list = this.joinList;
        if (list != null) {
            Iterator<QueryBuilder<T, ID>.JoinInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().queryBuilder.setAddTableName(z);
            }
        }
    }

    private void addJoinInfo(JoinType joinType, String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinWhereOperation joinWhereOperation) throws SQLException {
        QueryBuilder<T, ID>.JoinInfo joinInfo = new JoinInfo(joinType, queryBuilder, joinWhereOperation);
        if (str == null) {
            matchJoinedFields(joinInfo, queryBuilder);
        } else {
            matchJoinedFieldsByName(joinInfo, str, str2, queryBuilder);
        }
        if (this.joinList == null) {
            this.joinList = new ArrayList();
        }
        this.joinList.add(joinInfo);
    }

    private void matchJoinedFieldsByName(QueryBuilder<T, ID>.JoinInfo joinInfo, String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        joinInfo.localField = this.tableInfo.getFieldTypeByColumnName(str);
        if (joinInfo.localField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find field in ");
            sb.append(this.tableInfo.getDataClass());
            sb.append(" that has column-name '");
            sb.append(str);
            sb.append("'");
            throw new SQLException(sb.toString());
        }
        joinInfo.remoteField = queryBuilder.tableInfo.getFieldTypeByColumnName(str2);
        if (joinInfo.remoteField != null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not find field in ");
        sb2.append(queryBuilder.tableInfo.getDataClass());
        sb2.append(" that has column-name '");
        sb2.append(str2);
        sb2.append("'");
        throw new SQLException(sb2.toString());
    }

    private void matchJoinedFields(QueryBuilder<T, ID>.JoinInfo joinInfo, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            FieldType foreignRefField = fieldType.getForeignRefField();
            if (fieldType.isForeign() && foreignRefField.equals(queryBuilder.tableInfo.getIdField())) {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignRefField;
                return;
            }
        }
        for (FieldType fieldType2 : queryBuilder.tableInfo.getFieldTypes()) {
            if (fieldType2.isForeign() && fieldType2.getForeignIdField().equals(this.idField)) {
                joinInfo.localField = this.idField;
                joinInfo.remoteField = fieldType2;
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find a foreign ");
        sb.append(this.tableInfo.getDataClass());
        sb.append(" field in ");
        sb.append(queryBuilder.tableInfo.getDataClass());
        sb.append(" or vice versa");
        throw new SQLException(sb.toString());
    }

    private void addSelectColumnToList(String str) {
        verifyColumnName(str);
        addSelectToList(ColumnNameOrRawSql.withColumnName(str));
    }

    private void addSelectToList(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.selectList == null) {
            this.selectList = new ArrayList();
        }
        this.selectList.add(columnNameOrRawSql);
    }

    private void appendJoinSql(StringBuilder sb) {
        for (QueryBuilder<T, ID>.JoinInfo joinInfo : this.joinList) {
            sb.append(joinInfo.type.sql);
            sb.append(" JOIN ");
            this.databaseType.appendEscapedEntityName(sb, joinInfo.queryBuilder.tableName);
            if (joinInfo.queryBuilder.alias != null) {
                joinInfo.queryBuilder.appendAlias(sb);
            }
            sb.append(" ON ");
            appendTableQualifier(sb);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, joinInfo.localField.getColumnName());
            sb.append(" = ");
            joinInfo.queryBuilder.appendTableQualifier(sb);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, joinInfo.remoteField.getColumnName());
            sb.append(InputCardNumberView.DIVIDER);
            if (joinInfo.queryBuilder.joinList != null) {
                joinInfo.queryBuilder.appendJoinSql(sb);
            }
        }
    }

    private void appendSelects(StringBuilder sb) {
        this.type = StatementBuilder.StatementType.SELECT;
        if (this.selectList == null) {
            if (this.addTableName) {
                appendTableQualifier(sb);
                sb.append('.');
            }
            sb.append("* ");
            this.resultFieldTypes = this.tableInfo.getFieldTypes();
            return;
        }
        boolean z = this.isInnerQuery;
        List<FieldType> arrayList = new ArrayList<>(this.selectList.size() + 1);
        boolean z2 = true;
        for (ColumnNameOrRawSql columnNameOrRawSql : this.selectList) {
            if (columnNameOrRawSql.getRawSql() != null) {
                this.type = StatementBuilder.StatementType.SELECT_RAW;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(columnNameOrRawSql.getRawSql());
            } else {
                FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(columnNameOrRawSql.getColumnName());
                if (fieldTypeByColumnName.isForeignCollection()) {
                    arrayList.add(fieldTypeByColumnName);
                } else {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(", ");
                    }
                    appendFieldColumnName(sb, fieldTypeByColumnName, arrayList);
                    if (fieldTypeByColumnName == this.idField) {
                        z = true;
                    }
                }
            }
        }
        if (this.type != StatementBuilder.StatementType.SELECT_RAW) {
            if (!z && this.selectIdColumn) {
                if (!z2) {
                    sb.append(',');
                }
                appendFieldColumnName(sb, this.idField, arrayList);
            }
            this.resultFieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        sb.append(InputCardNumberView.DIVIDER);
    }

    private void appendFieldColumnName(StringBuilder sb, FieldType fieldType, List<FieldType> list) {
        appendColumnName(sb, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
    }

    private void appendLimit(StringBuilder sb) {
        if (this.limit == null || !this.databaseType.isLimitSqlSupported()) {
            return;
        }
        this.databaseType.appendLimitValue(sb, this.limit.longValue(), this.offset);
    }

    private void appendOffset(StringBuilder sb) throws SQLException {
        if (this.offset == null) {
            return;
        }
        if (this.databaseType.isOffsetLimitArgument()) {
            if (this.limit == null) {
                throw new SQLException("If the offset is specified, limit must also be specified with this database");
            }
            return;
        }
        this.databaseType.appendOffsetValue(sb, this.offset.longValue());
    }

    private void appendGroupBys(StringBuilder sb) {
        boolean z = true;
        if (hasGroupStuff()) {
            appendGroupBys(sb, true);
            z = false;
        }
        List<QueryBuilder<T, ID>.JoinInfo> list = this.joinList;
        if (list != null) {
            for (QueryBuilder<T, ID>.JoinInfo joinInfo : list) {
                if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasGroupStuff()) {
                    joinInfo.queryBuilder.appendGroupBys(sb, z);
                    z = false;
                }
            }
        }
    }

    private boolean hasGroupStuff() {
        List<ColumnNameOrRawSql> list = this.groupByList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    private void appendGroupBys(StringBuilder sb, boolean z) {
        if (z) {
            sb.append("GROUP BY ");
        }
        for (ColumnNameOrRawSql columnNameOrRawSql : this.groupByList) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            if (columnNameOrRawSql.getRawSql() == null) {
                appendColumnName(sb, columnNameOrRawSql.getColumnName());
            } else {
                sb.append(columnNameOrRawSql.getRawSql());
            }
        }
        sb.append(InputCardNumberView.DIVIDER);
    }

    private void appendOrderBys(StringBuilder sb, List<ArgumentHolder> list) {
        boolean z = true;
        if (hasOrderStuff()) {
            appendOrderBys(sb, true, list);
            z = false;
        }
        List<QueryBuilder<T, ID>.JoinInfo> list2 = this.joinList;
        if (list2 != null) {
            for (QueryBuilder<T, ID>.JoinInfo joinInfo : list2) {
                if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasOrderStuff()) {
                    joinInfo.queryBuilder.appendOrderBys(sb, z, list);
                    z = false;
                }
            }
        }
    }

    private boolean hasOrderStuff() {
        List<OrderBy> list = this.orderByList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    private void appendOrderBys(StringBuilder sb, boolean z, List<ArgumentHolder> list) {
        if (z) {
            sb.append("ORDER BY ");
        }
        for (OrderBy orderBy : this.orderByList) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            if (orderBy.getRawSql() == null) {
                appendColumnName(sb, orderBy.getColumnName());
                if (!orderBy.isAscending()) {
                    sb.append(" DESC");
                }
            } else {
                sb.append(orderBy.getRawSql());
                if (orderBy.getOrderByArgs() != null) {
                    for (ArgumentHolder argumentHolder : orderBy.getOrderByArgs()) {
                        list.add(argumentHolder);
                    }
                }
            }
        }
        sb.append(InputCardNumberView.DIVIDER);
    }

    private void appendColumnName(StringBuilder sb, String str) {
        if (this.addTableName) {
            appendTableQualifier(sb);
            sb.append('.');
        }
        this.databaseType.appendEscapedEntityName(sb, str);
    }

    private void appendHaving(StringBuilder sb) {
        if (this.having != null) {
            sb.append("HAVING ");
            sb.append(this.having);
            sb.append(InputCardNumberView.DIVIDER);
        }
    }

    private void appendAlias(StringBuilder sb) {
        sb.append(" AS ");
        this.databaseType.appendEscapedEntityName(sb, this.alias);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class JoinInfo {
        FieldType localField;
        JoinWhereOperation operation;
        final QueryBuilder<?, ?> queryBuilder;
        FieldType remoteField;
        final JoinType type;

        public JoinInfo(JoinType joinType, QueryBuilder<?, ?> queryBuilder, JoinWhereOperation joinWhereOperation) {
            this.type = joinType;
            this.queryBuilder = queryBuilder;
            this.operation = joinWhereOperation;
        }
    }

    /* loaded from: classes8.dex */
    public static class InternalQueryBuilderWrapper {
        private final QueryBuilder<?, ?> queryBuilder;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InternalQueryBuilderWrapper(QueryBuilder<?, ?> queryBuilder) {
            this.queryBuilder = queryBuilder;
        }

        public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
            this.queryBuilder.appendStatementString(sb, list);
        }

        public FieldType[] getResultFieldTypes() {
            return this.queryBuilder.getResultFieldTypes();
        }
    }

    /* loaded from: classes8.dex */
    public enum JoinType {
        INNER("INNER"),
        LEFT("LEFT");

        private String sql;

        JoinType(String str) {
            this.sql = str;
        }
    }

    /* loaded from: classes8.dex */
    public enum JoinWhereOperation {
        AND(StatementBuilder.WhereOperation.AND),
        OR(StatementBuilder.WhereOperation.OR);

        private StatementBuilder.WhereOperation whereOperation;

        JoinWhereOperation(StatementBuilder.WhereOperation whereOperation) {
            this.whereOperation = whereOperation;
        }
    }
}
