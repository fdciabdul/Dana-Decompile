package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DatabaseResultsMapper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    private static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];
    private String countStarQuery;
    private final Dao<T, ID> dao;
    private final DatabaseType databaseType;
    private FieldType[] ifExistsFieldTypes;
    private String ifExistsQuery;
    private final ThreadLocal<Boolean> localIsInBatchMode = new ThreadLocal<Boolean>() { // from class: com.j256.ormlite.stmt.StatementExecutor.1
        {
            StatementExecutor.this = this;
        }

        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private MappedDelete<T, ID> mappedDelete;
    private MappedCreate<T, ID> mappedInsert;
    private MappedQueryForFieldEq<T, ID> mappedQueryForId;
    private MappedRefresh<T, ID> mappedRefresh;
    private MappedUpdate<T, ID> mappedUpdate;
    private MappedUpdateId<T, ID> mappedUpdateId;
    private PreparedQuery<T> preparedQueryForAll;
    private RawRowMapper<T> rawRowMapper;
    private final TableInfo<T, ID> tableInfo;

    public StatementExecutor(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.dao = dao;
    }

    public T queryForId(DatabaseConnection databaseConnection, ID id2, ObjectCache objectCache) throws SQLException {
        if (this.mappedQueryForId == null) {
            this.mappedQueryForId = MappedQueryForFieldEq.build(this.databaseType, this.tableInfo, null);
        }
        return this.mappedQueryForId.execute(databaseConnection, id2, objectCache);
    }

    public T queryForFirst(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws SQLException {
        DatabaseResults runQuery;
        CompiledStatement compile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT);
        DatabaseResults databaseResults = null;
        try {
            compile.setMaxRows(1);
            runQuery = compile.runQuery(objectCache);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (runQuery.first()) {
                logger.debug("query-for-first of '{}' returned at least 1 result", preparedStmt.getStatement());
                T mapRow = preparedStmt.mapRow(runQuery);
                IOUtils.closeThrowSqlException(runQuery, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                return mapRow;
            }
            logger.debug("query-for-first of '{}' returned at 0 results", preparedStmt.getStatement());
            IOUtils.closeThrowSqlException(runQuery, "results");
            IOUtils.closeThrowSqlException(compile, "compiled statement");
            return null;
        } catch (Throwable th2) {
            th = th2;
            databaseResults = runQuery;
            IOUtils.closeThrowSqlException(databaseResults, "results");
            IOUtils.closeThrowSqlException(compile, "compiled statement");
            throw th;
        }
    }

    public List<T> queryForAll(ConnectionSource connectionSource, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return query(connectionSource, this.preparedQueryForAll, objectCache);
    }

    public long queryForCountStar(DatabaseConnection databaseConnection) throws SQLException {
        if (this.countStarQuery == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("SELECT COUNT(*) FROM ");
            this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
            this.countStarQuery = sb.toString();
        }
        long queryForLong = databaseConnection.queryForLong(this.countStarQuery);
        logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(queryForLong));
        return queryForLong;
    }

    public long queryForLong(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt) throws SQLException {
        CompiledStatement compile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT_LONG);
        try {
            DatabaseResults runQuery = compile.runQuery(null);
            if (runQuery.first()) {
                long j = runQuery.getLong(0);
                IOUtils.closeThrowSqlException(runQuery, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                return j;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No result found in queryForLong: ");
            sb.append(preparedStmt.getStatement());
            throw new SQLException(sb.toString());
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(null, "results");
            IOUtils.closeThrowSqlException(compile, "compiled statement");
            throw th;
        }
    }

    public long queryForLong(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        Throwable th;
        CompiledStatement compiledStatement;
        DatabaseResults runQuery;
        logger.debug("executing raw query for long: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseResults databaseResults = null;
        try {
            compiledStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                runQuery = compiledStatement.runQuery(null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            compiledStatement = null;
        }
        try {
            if (runQuery.first()) {
                long j = runQuery.getLong(0);
                IOUtils.closeThrowSqlException(runQuery, "results");
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                return j;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No result found in queryForLong: ");
            sb.append(str);
            throw new SQLException(sb.toString());
        } catch (Throwable th4) {
            th = th4;
            databaseResults = runQuery;
            IOUtils.closeThrowSqlException(databaseResults, "results");
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            throw th;
        }
    }

    public List<T> query(ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache) throws SQLException {
        SelectIterator<T, ID> buildIterator = buildIterator(null, connectionSource, preparedStmt, objectCache, -1);
        try {
            ArrayList arrayList = new ArrayList();
            while (buildIterator.hasNextThrow()) {
                arrayList.add(buildIterator.nextThrow());
            }
            logger.debug("query of '{}' returned {} results", preparedStmt.getStatement(), Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            IOUtils.closeThrowSqlException(buildIterator, "iterator");
        }
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, int i, ObjectCache objectCache) throws SQLException {
        prepareQueryForAll();
        return buildIterator(baseDaoImpl, connectionSource, this.preparedQueryForAll, objectCache, i);
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        prepareQueryForAll();
        return this.preparedQueryForAll;
    }

    public RawRowMapper<T> getRawRowMapper() {
        if (this.rawRowMapper == null) {
            this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
        }
        return this.rawRowMapper;
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache, int i) throws SQLException {
        CompiledStatement compile;
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        CompiledStatement compiledStatement = null;
        try {
            compile = preparedStmt.compile(readOnlyConnection, StatementBuilder.StatementType.SELECT, i);
        } catch (Throwable th) {
            th = th;
        }
        try {
            SelectIterator<T, ID> selectIterator = new SelectIterator<>(this.tableInfo.getDataClass(), baseDaoImpl, preparedStmt, connectionSource, readOnlyConnection, compile, preparedStmt.getStatement(), objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return selectIterator;
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = compile;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public GenericRawResults<String[]> queryRaw(ConnectionSource connectionSource, String str, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compileStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        CompiledStatement compiledStatement = null;
        try {
            compileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            assignStatementArguments(compileStatement, strArr);
            RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compileStatement, this, objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return rawResultsImpl;
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = compileStatement;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, RawRowMapper<UO> rawRowMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compileStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        CompiledStatement compiledStatement = null;
        try {
            compileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            assignStatementArguments(compileStatement, strArr);
            RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compileStatement, new UserRawRowMapper(rawRowMapper, this), objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return rawResultsImpl;
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = compileStatement;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compileStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        CompiledStatement compiledStatement = null;
        try {
            compileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            assignStatementArguments(compileStatement, strArr);
            RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compileStatement, new UserRawRowObjectMapper(rawRowObjectMapper, dataTypeArr), objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return rawResultsImpl;
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = compileStatement;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public GenericRawResults<Object[]> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compileStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        CompiledStatement compiledStatement = null;
        try {
            compileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            assignStatementArguments(compileStatement, strArr);
            RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compileStatement, new ObjectArrayRowMapper(dataTypeArr), objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return rawResultsImpl;
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = compileStatement;
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.j256.ormlite.stmt.StatementExecutor$1] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v2 */
    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DatabaseResultsMapper<UO> databaseResultsMapper, String[] strArr, ObjectCache objectCache) throws SQLException {
        CompiledStatement compileStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        ?? r14 = 0;
        try {
            compileStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            assignStatementArguments(compileStatement, strArr);
            RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compileStatement, new UserDatabaseResultsMapper(databaseResultsMapper), objectCache);
            IOUtils.closeThrowSqlException(null, "compiled statement");
            return rawResultsImpl;
        } catch (Throwable th2) {
            th = th2;
            r14 = compileStatement;
            IOUtils.closeThrowSqlException(r14, "compiled statement");
            if (readOnlyConnection != null) {
                connectionSource.releaseConnection(readOnlyConnection);
            }
            throw th;
        }
    }

    public int updateRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw update statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("update arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runUpdate();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    public int executeRawNoArgs(DatabaseConnection databaseConnection, String str) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        return databaseConnection.executeStatement(str, -1);
    }

    public int executeRaw(DatabaseConnection databaseConnection, String str, String[] strArr) throws SQLException {
        logger.debug("running raw execute statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("execute arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runExecute();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    public int create(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedInsert == null) {
            this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
        }
        int insert = this.mappedInsert.insert(this.databaseType, databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return insert;
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdate == null) {
            this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
        }
        int update = this.mappedUpdate.update(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return update;
    }

    public int updateId(DatabaseConnection databaseConnection, T t, ID id2, ObjectCache objectCache) throws SQLException {
        if (this.mappedUpdateId == null) {
            this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
        }
        int execute = this.mappedUpdateId.execute(databaseConnection, t, id2, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return execute;
    }

    public int update(DatabaseConnection databaseConnection, PreparedUpdate<T> preparedUpdate) throws SQLException {
        CompiledStatement compile = preparedUpdate.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public int refresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedRefresh == null) {
            this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
        }
        return this.mappedRefresh.executeRefresh(databaseConnection, t, objectCache);
    }

    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int delete = this.mappedDelete.delete(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return delete;
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id2, ObjectCache objectCache) throws SQLException {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int deleteById = this.mappedDelete.deleteById(databaseConnection, id2, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteById;
    }

    public int deleteObjects(DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        int deleteObjects = MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteObjects;
    }

    public int deleteIds(DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        int deleteIds = MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteIds;
    }

    public int delete(DatabaseConnection databaseConnection, PreparedDelete<T> preparedDelete) throws SQLException {
        CompiledStatement compile = preparedDelete.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public <CT> CT callBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) throws SQLException {
        CT ct;
        if (connectionSource.isSingleConnection(this.tableInfo.getTableName())) {
            synchronized (this) {
                ct = (CT) doCallBatchTasks(connectionSource, callable);
            }
            return ct;
        }
        return (CT) doCallBatchTasks(connectionSource, callable);
    }

    private <CT> CT doCallBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) throws SQLException {
        boolean z;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            this.localIsInBatchMode.set(Boolean.TRUE);
            z = connectionSource.saveSpecialConnection(readWriteConnection);
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            CT ct = (CT) doCallBatchTasks(readWriteConnection, z, callable);
            if (z) {
                connectionSource.clearSpecialConnection(readWriteConnection);
            }
            connectionSource.releaseConnection(readWriteConnection);
            this.localIsInBatchMode.set(Boolean.FALSE);
            Dao<T, ID> dao = this.dao;
            if (dao != null) {
                dao.notifyChanges();
            }
            return ct;
        } catch (Throwable th2) {
            th = th2;
            if (z) {
                connectionSource.clearSpecialConnection(readWriteConnection);
            }
            connectionSource.releaseConnection(readWriteConnection);
            this.localIsInBatchMode.set(Boolean.FALSE);
            Dao<T, ID> dao2 = this.dao;
            if (dao2 != null) {
                dao2.notifyChanges();
            }
            throw th;
        }
    }

    private <CT> CT doCallBatchTasks(DatabaseConnection databaseConnection, boolean z, Callable<CT> callable) throws SQLException {
        if (this.databaseType.isBatchUseTransaction()) {
            return (CT) TransactionManager.callInTransaction(databaseConnection, z, this.databaseType, callable);
        }
        boolean z2 = false;
        try {
            if (databaseConnection.isAutoCommitSupported() && databaseConnection.isAutoCommit()) {
                databaseConnection.setAutoCommit(false);
                try {
                    logger.debug("disabled auto-commit on table {} before batch tasks", this.tableInfo.getTableName());
                    z2 = true;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                    }
                    throw th;
                }
            }
            try {
                CT call = callable.call();
                if (z2) {
                    databaseConnection.setAutoCommit(true);
                    logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                }
                return call;
            } catch (SQLException e) {
                throw e;
            } catch (Exception e2) {
                throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", e2);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public String[] mapRow(DatabaseResults databaseResults) throws SQLException {
        int columnCount = databaseResults.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            strArr[i] = databaseResults.getString(i);
        }
        return strArr;
    }

    public boolean ifExists(DatabaseConnection databaseConnection, ID id2) throws SQLException {
        if (this.ifExistsQuery == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
            queryBuilder.selectRaw("COUNT(*)");
            queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
            this.ifExistsQuery = queryBuilder.prepareStatementString();
            this.ifExistsFieldTypes = new FieldType[]{this.tableInfo.getIdField()};
        }
        long queryForLong = databaseConnection.queryForLong(this.ifExistsQuery, new Object[]{this.tableInfo.getIdField().convertJavaFieldToSqlArgValue(id2)}, this.ifExistsFieldTypes);
        logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(queryForLong));
        return queryForLong != 0;
    }

    private void assignStatementArguments(CompiledStatement compiledStatement, String[] strArr) throws SQLException {
        for (int i = 0; i < strArr.length; i++) {
            compiledStatement.setObject(i, strArr[i], SqlType.STRING);
        }
    }

    private void prepareQueryForAll() throws SQLException {
        if (this.preparedQueryForAll == null) {
            this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
        }
    }

    /* loaded from: classes8.dex */
    public static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final RawRowMapper<UO> mapper;
        private final GenericRowMapper<String[]> stringRowMapper;

        public UserRawRowMapper(RawRowMapper<UO> rawRowMapper, GenericRowMapper<String[]> genericRowMapper) {
            this.mapper = rawRowMapper;
            this.stringRowMapper = genericRowMapper;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(getColumnNames(databaseResults), this.stringRowMapper.mapRow(databaseResults));
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            String[] columnNames = databaseResults.getColumnNames();
            this.columnNames = columnNames;
            return columnNames;
        }
    }

    /* loaded from: classes8.dex */
    public static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
        private String[] columnNames;
        private final DataType[] columnTypes;
        private final RawRowObjectMapper<UO> mapper;

        public UserRawRowObjectMapper(RawRowObjectMapper<UO> rawRowObjectMapper, DataType[] dataTypeArr) {
            this.mapper = rawRowObjectMapper;
            this.columnTypes = dataTypeArr;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    objArr[i] = null;
                } else {
                    objArr[i] = dataTypeArr[i].getDataPersister().resultToJava(null, databaseResults, i);
                }
            }
            return this.mapper.mapRow(getColumnNames(databaseResults), this.columnTypes, objArr);
        }

        private String[] getColumnNames(DatabaseResults databaseResults) throws SQLException {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            String[] columnNames = databaseResults.getColumnNames();
            this.columnNames = columnNames;
            return columnNames;
        }
    }

    /* loaded from: classes8.dex */
    public static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
        private final DataType[] columnTypes;

        public ObjectArrayRowMapper(DataType[] dataTypeArr) {
            this.columnTypes = dataTypeArr;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public Object[] mapRow(DatabaseResults databaseResults) throws SQLException {
            DataType dataType;
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i >= dataTypeArr.length) {
                    dataType = DataType.STRING;
                } else {
                    dataType = dataTypeArr[i];
                }
                objArr[i] = dataType.getDataPersister().resultToJava(null, databaseResults, i);
            }
            return objArr;
        }
    }

    /* loaded from: classes8.dex */
    public static class UserDatabaseResultsMapper<UO> implements GenericRowMapper<UO> {
        public final DatabaseResultsMapper<UO> mapper;

        private UserDatabaseResultsMapper(DatabaseResultsMapper<UO> databaseResultsMapper) {
            this.mapper = databaseResultsMapper;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) throws SQLException {
            return this.mapper.mapRow(databaseResults);
        }
    }
}
