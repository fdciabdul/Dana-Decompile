package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    private Map<Dao.DaoObserver, Object> daoObserverMap;
    protected final Class<T> dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator<T> lastIterator;
    private ObjectCache objectCache;
    protected ObjectFactory<T> objectFactory;
    protected StatementExecutor<T, ID> statementExecutor;
    protected DatabaseTableConfig<T> tableConfig;
    protected TableInfo<T, ID> tableInfo;
    private static final ThreadLocal<List<BaseDaoImpl<?, ?>>> daoConfigLevelLocal = new ThreadLocal<List<BaseDaoImpl<?, ?>>>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.1
        @Override // java.lang.ThreadLocal
        public final List<BaseDaoImpl<?, ?>> initialValue() {
            return new ArrayList(10);
        }
    };
    private static final Object constantObject = new Object();

    protected BaseDaoImpl(Class<T> cls) throws SQLException {
        this(null, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        this(connectionSource, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this(connectionSource, databaseTableConfig.getDataClass(), databaseTableConfig);
    }

    private BaseDaoImpl(ConnectionSource connectionSource, Class<T> cls, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this.dataClass = cls;
        this.tableConfig = databaseTableConfig;
        if (connectionSource != null) {
            this.connectionSource = connectionSource;
            initialize();
        }
    }

    public void initialize() throws SQLException {
        if (this.initialized) {
            return;
        }
        ConnectionSource connectionSource = this.connectionSource;
        if (connectionSource == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("connectionSource was never set on ");
            sb.append(getClass().getSimpleName());
            throw new IllegalStateException(sb.toString());
        }
        DatabaseType databaseType = connectionSource.getDatabaseType();
        this.databaseType = databaseType;
        if (databaseType == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connectionSource is getting a null DatabaseType in ");
            sb2.append(getClass().getSimpleName());
            throw new IllegalStateException(sb2.toString());
        }
        DatabaseTableConfig<T> databaseTableConfig = this.tableConfig;
        if (databaseTableConfig == null) {
            this.tableInfo = new TableInfo<>(this.connectionSource, this, this.dataClass);
        } else {
            databaseTableConfig.extractFieldTypes(this.connectionSource);
            this.tableInfo = new TableInfo<>(this.databaseType, this, this.tableConfig);
        }
        this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
        List<BaseDaoImpl<?, ?>> list = daoConfigLevelLocal.get();
        list.add(this);
        if (list.size() > 1) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                BaseDaoImpl<?, ?> baseDaoImpl = list.get(i);
                DaoManager.registerDao(this.connectionSource, baseDaoImpl);
                try {
                    for (FieldType fieldType : baseDaoImpl.getTableInfo().getFieldTypes()) {
                        fieldType.configDaoInformation(this.connectionSource, baseDaoImpl.getDataClass());
                    }
                    baseDaoImpl.initialized = true;
                } catch (SQLException e) {
                    DaoManager.unregisterDao(this.connectionSource, baseDaoImpl);
                    throw e;
                }
            } finally {
                list.clear();
                daoConfigLevelLocal.remove();
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForId(ID id2) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForId(readOnlyConnection, id2, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForFirst(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForFirst(readOnlyConnection, preparedQuery, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForAll() throws SQLException {
        checkForInitialized();
        return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForEq(String str, Object obj) throws SQLException {
        return queryBuilder().where().eq(str, obj).query();
    }

    @Override // com.j256.ormlite.dao.Dao
    public QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatching(T t) throws SQLException {
        return queryForMatching(t, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatchingArgs(T t) throws SQLException {
        return queryForMatching(t, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValues(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValuesArgs(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForSameId(T t) throws SQLException {
        ID extractId;
        checkForInitialized();
        if (t == null || (extractId = extractId(t)) == null) {
            return null;
        }
        return queryForId(extractId);
    }

    @Override // com.j256.ormlite.dao.Dao
    public int create(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.create(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int create(final Collection<T> collection) throws SQLException {
        checkForInitialized();
        for (T t : collection) {
            if (t instanceof BaseDaoEnabled) {
                ((BaseDaoEnabled) t).setDao(this);
            }
        }
        final DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return ((Integer) callBatchTasks(new Callable<Integer>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.2
                {
                    BaseDaoImpl.this = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public Integer call() throws SQLException {
                    Iterator it = collection.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += BaseDaoImpl.this.statementExecutor.create(readWriteConnection, it.next(), BaseDaoImpl.this.objectCache);
                    }
                    return Integer.valueOf(i);
                }
            })).intValue();
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T createIfNotExists(T t) throws SQLException {
        if (t == null) {
            return null;
        }
        T queryForSameId = queryForSameId(t);
        if (queryForSameId == null) {
            create((BaseDaoImpl<T, ID>) t);
            return t;
        }
        return queryForSameId;
    }

    @Override // com.j256.ormlite.dao.Dao
    public Dao.CreateOrUpdateStatus createOrUpdate(T t) throws SQLException {
        if (t == null) {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        ID extractId = extractId(t);
        if (extractId == null || !idExists(extractId)) {
            return new Dao.CreateOrUpdateStatus(true, false, create((BaseDaoImpl<T, ID>) t));
        }
        return new Dao.CreateOrUpdateStatus(false, true, update((BaseDaoImpl<T, ID>) t));
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateId(T t, ID id2) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.updateId(readWriteConnection, t, id2, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, preparedUpdate);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int refresh(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.refresh(readOnlyConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteById(ID id2) throws SQLException {
        checkForInitialized();
        if (id2 == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteById(readWriteConnection, id2, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(Collection<T> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteObjects(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteIds(Collection<ID> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteIds(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(PreparedDelete<T> preparedDelete) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, preparedDelete);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return iterator(-1);
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return iterator(-1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(int i) {
        checkForInitialized();
        CloseableIterator<T> createIterator = createIterator(i);
        this.lastIterator = createIterator;
        return createIterator;
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable() {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.3
            {
                BaseDaoImpl.this = this;
            }

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(-1);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build iterator for ");
                    sb.append(BaseDaoImpl.this.dataClass);
                    throw new IllegalStateException(sb.toString(), e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.4
            {
                BaseDaoImpl.this = this;
            }

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(preparedQuery, -1);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build prepared-query iterator for ");
                    sb.append(BaseDaoImpl.this.dataClass);
                    throw new IllegalStateException(sb.toString(), e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public void closeLastIterator() throws IOException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) throws SQLException {
        return iterator(preparedQuery, -1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        checkForInitialized();
        CloseableIterator<T> createIterator = createIterator(preparedQuery, i);
        this.lastIterator = createIterator;
        return createIterator;
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<String[]> queryRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <GR> GenericRawResults<GR> queryRaw(String str, RawRowMapper<GR> rawRowMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return (GenericRawResults<GR>) this.statementExecutor.queryRaw(this.connectionSource, str, rawRowMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, rawRowObjectMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <UO> GenericRawResults<UO> queryRaw(String str, DatabaseResultsMapper<UO> databaseResultsMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, databaseResultsMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long queryRawValue(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.queryForLong(readOnlyConnection, str, strArr);
            } catch (SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not perform raw value query for ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.executeRaw(readWriteConnection, str, strArr);
            } catch (SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not run raw execute statement ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRawNoArgs(String str) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.executeRawNoArgs(readWriteConnection, str);
            } catch (SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not run raw execute statement ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.updateRaw(readWriteConnection, str, strArr);
            } catch (SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not run raw update statement ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <CT> CT callBatchTasks(Callable<CT> callable) throws SQLException {
        checkForInitialized();
        return (CT) this.statementExecutor.callBatchTasks(this.connectionSource, callable);
    }

    @Override // com.j256.ormlite.dao.Dao
    public String objectToString(T t) {
        checkForInitialized();
        return this.tableInfo.objectToString(t);
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean objectsEqual(T t, T t2) throws SQLException {
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (!fieldType.getDataPersister().dataIsEqual(fieldType.extractJavaFieldValue(t), fieldType.extractJavaFieldValue(t2))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.j256.ormlite.dao.Dao
    public ID extractId(T t) throws SQLException {
        checkForInitialized();
        FieldType idField = this.tableInfo.getIdField();
        if (idField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(this.dataClass);
            sb.append(" does not have an id field");
            throw new SQLException(sb.toString());
        }
        return (ID) idField.extractJavaFieldValue(t);
    }

    @Override // com.j256.ormlite.dao.Dao
    public Class<T> getDataClass() {
        return this.dataClass;
    }

    @Override // com.j256.ormlite.dao.Dao
    public FieldType findForeignFieldType(Class<?> cls) {
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getType() == cls) {
                return fieldType;
            }
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isUpdatable() {
        return this.tableInfo.isUpdatable();
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isTableExists() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return readOnlyConnection.isTableExists(this.tableInfo.getTableName());
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForCountStar(readOnlyConnection);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        if (preparedQuery.getType() != StatementBuilder.StatementType.SELECT_LONG) {
            StringBuilder sb = new StringBuilder();
            sb.append("Prepared query is not of type ");
            sb.append(StatementBuilder.StatementType.SELECT_LONG);
            sb.append(", you need to call QueryBuilder.setCountOf(true)");
            throw new IllegalArgumentException(sb.toString());
        }
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForLong(readOnlyConnection, preparedQuery);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void assignEmptyForeignCollection(T t, String str) throws SQLException {
        makeEmptyForeignCollection(t, str);
    }

    @Override // com.j256.ormlite.dao.Dao
    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) throws SQLException {
        return makeEmptyForeignCollection(null, str);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(boolean z) throws SQLException {
        ReferenceObjectCache referenceObjectCache;
        if (z) {
            if (this.objectCache == null) {
                if (this.tableInfo.getIdField() == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Class ");
                    sb.append(this.dataClass);
                    sb.append(" must have an id field to enable the object cache");
                    throw new SQLException(sb.toString());
                }
                synchronized (BaseDaoImpl.class) {
                    if (defaultObjectCache == null) {
                        defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                    }
                    referenceObjectCache = defaultObjectCache;
                    this.objectCache = referenceObjectCache;
                }
                referenceObjectCache.registerClass(this.dataClass);
                return;
            }
            return;
        }
        ObjectCache objectCache = this.objectCache;
        if (objectCache != null) {
            objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(ObjectCache objectCache) throws SQLException {
        if (objectCache == null) {
            ObjectCache objectCache2 = this.objectCache;
            if (objectCache2 != null) {
                objectCache2.clear(this.dataClass);
                this.objectCache = null;
                return;
            }
            return;
        }
        ObjectCache objectCache3 = this.objectCache;
        if (objectCache3 != null && objectCache3 != objectCache) {
            objectCache3.clear(this.dataClass);
        }
        if (this.tableInfo.getIdField() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(this.dataClass);
            sb.append(" must have an id field to enable the object cache");
            throw new SQLException(sb.toString());
        }
        this.objectCache = objectCache;
        objectCache.registerClass(this.dataClass);
    }

    @Override // com.j256.ormlite.dao.Dao
    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void clearObjectCache() {
        ObjectCache objectCache = this.objectCache;
        if (objectCache != null) {
            objectCache.clear(this.dataClass);
        }
    }

    public static void clearAllInternalObjectCaches() {
        synchronized (BaseDaoImpl.class) {
            ReferenceObjectCache referenceObjectCache = defaultObjectCache;
            if (referenceObjectCache != null) {
                referenceObjectCache.clearAll();
                defaultObjectCache = null;
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T mapSelectStarRow(DatabaseResults databaseResults) throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper().mapRow(databaseResults);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void notifyChanges() {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            Iterator<Dao.DaoObserver> it = map.keySet().iterator();
            while (it.hasNext()) {
                it.next().onChange();
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void registerObserver(Dao.DaoObserver daoObserver) {
        if (this.daoObserverMap == null) {
            synchronized (this) {
                if (this.daoObserverMap == null) {
                    this.daoObserverMap = new ConcurrentHashMap();
                }
            }
        }
        this.daoObserverMap.put(daoObserver, constantObject);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void unregisterObserver(Dao.DaoObserver daoObserver) {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            synchronized (map) {
                this.daoObserverMap.remove(daoObserver);
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper();
    }

    @Override // com.j256.ormlite.dao.Dao
    public RawRowMapper<T> getRawRowMapper() {
        return this.statementExecutor.getRawRowMapper();
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean idExists(ID id2) throws SQLException {
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.ifExists(readOnlyConnection, id2);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public DatabaseConnection startThreadConnection() throws SQLException {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        this.connectionSource.saveSpecialConnection(readWriteConnection);
        return readWriteConnection;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void endThreadConnection(DatabaseConnection databaseConnection) throws SQLException {
        this.connectionSource.clearSpecialConnection(databaseConnection);
        this.connectionSource.releaseConnection(databaseConnection);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setAutoCommit(DatabaseConnection databaseConnection, boolean z) throws SQLException {
        databaseConnection.setAutoCommit(z);
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isAutoCommit(DatabaseConnection databaseConnection) throws SQLException {
        return databaseConnection.isAutoCommit();
    }

    @Override // com.j256.ormlite.dao.Dao
    public void commit(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.commit(null);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void rollBack(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.rollback(null);
    }

    public ObjectFactory<T> getObjectFactory() {
        return this.objectFactory;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectFactory(ObjectFactory<T> objectFactory) {
        checkForInitialized();
        this.objectFactory = objectFactory;
    }

    public DatabaseTableConfig<T> getTableConfig() {
        return this.tableConfig;
    }

    public TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    @Override // com.j256.ormlite.dao.Dao
    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public void setTableConfig(DatabaseTableConfig<T> databaseTableConfig) {
        this.tableConfig = databaseTableConfig;
    }

    @Override // com.j256.ormlite.dao.Dao
    public String getTableName() {
        return this.tableConfig.getTableName();
    }

    public static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource, cls) { // from class: com.j256.ormlite.dao.BaseDaoImpl.5
            @Override // com.j256.ormlite.dao.BaseDaoImpl, java.lang.Iterable
            public final /* bridge */ /* synthetic */ Iterator iterator() {
                return super.iterator();
            }
        };
    }

    public static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource, databaseTableConfig) { // from class: com.j256.ormlite.dao.BaseDaoImpl.6
            @Override // com.j256.ormlite.dao.BaseDaoImpl, java.lang.Iterable
            public final /* bridge */ /* synthetic */ Iterator iterator() {
                return super.iterator();
            }
        };
    }

    protected void checkForInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T t, String str) throws SQLException {
        checkForInitialized();
        ID extractId = t == null ? null : extractId(t);
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getColumnName().equals(str)) {
                BaseForeignCollection buildForeignCollection = fieldType.buildForeignCollection(t, extractId);
                if (t != null) {
                    fieldType.assignField(t, buildForeignCollection, true, null);
                }
                return buildForeignCollection;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find a field named ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public CloseableIterator<T> createIterator(int i) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, i, this.objectCache);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build iterator for ");
            sb.append(this.dataClass);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    public CloseableIterator<T> createIterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery, this.objectCache, i);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build prepared-query iterator for ");
            sb.append(this.dataClass);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    private List<T> queryForMatching(T t, boolean z) throws SQLException {
        checkForInitialized();
        QueryBuilder<T, ID> queryBuilder = queryBuilder();
        Where<T, ID> where = queryBuilder.where();
        int i = 0;
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            Object fieldValueIfNotDefault = fieldType.getFieldValueIfNotDefault(t);
            if (fieldValueIfNotDefault != null) {
                if (z) {
                    fieldValueIfNotDefault = new SelectArg(fieldValueIfNotDefault);
                }
                where.eq(fieldType.getColumnName(), fieldValueIfNotDefault);
                i++;
            }
        }
        if (i == 0) {
            return Collections.emptyList();
        }
        where.and(i);
        return queryBuilder.query();
    }

    private List<T> queryForFieldValues(Map<String, Object> map, boolean z) throws SQLException {
        checkForInitialized();
        QueryBuilder<T, ID> queryBuilder = queryBuilder();
        Where<T, ID> where = queryBuilder.where();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (z) {
                value = new SelectArg(value);
            }
            where.eq(entry.getKey(), value);
        }
        if (map.size() == 0) {
            return Collections.emptyList();
        }
        where.and(map.size());
        return queryBuilder.query();
    }
}
