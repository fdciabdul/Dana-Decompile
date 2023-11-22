package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class SelectIterator<T, ID> implements CloseableIterator<T>, Iterator {
    private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
    private boolean alreadyMoved;
    private final Dao<T, ID> classDao;
    private boolean closed;
    private final CompiledStatement compiledStmt;
    private final DatabaseConnection connection;
    private final ConnectionSource connectionSource;
    private final Class<?> dataClass;
    private boolean first = true;
    private T last;
    private final DatabaseResults results;
    private int rowC;
    private final GenericRowMapper<T> rowMapper;
    private final String statement;

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    public SelectIterator(Class<?> cls, Dao<T, ID> dao, GenericRowMapper<T> genericRowMapper, ConnectionSource connectionSource, DatabaseConnection databaseConnection, CompiledStatement compiledStatement, String str, ObjectCache objectCache) throws SQLException {
        this.dataClass = cls;
        this.classDao = dao;
        this.rowMapper = genericRowMapper;
        this.connectionSource = connectionSource;
        this.connection = databaseConnection;
        this.compiledStmt = compiledStatement;
        this.results = compiledStatement.runQuery(objectCache);
        this.statement = str;
        if (str != null) {
            logger.debug("starting iterator @{} for '{}'", Integer.valueOf(hashCode()), str);
        }
    }

    public boolean hasNextThrow() throws SQLException {
        boolean next;
        if (this.closed) {
            return false;
        }
        if (this.alreadyMoved) {
            return true;
        }
        if (this.first) {
            this.first = false;
            next = this.results.first();
        } else {
            next = this.results.next();
        }
        if (!next) {
            IOUtils.closeThrowSqlException(this, "iterator");
        }
        this.alreadyMoved = true;
        return next;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            return hasNextThrow();
        } catch (SQLException e) {
            this.last = null;
            closeQuietly();
            StringBuilder sb = new StringBuilder();
            sb.append("Errors getting more results of ");
            sb.append(this.dataClass);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T first() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.first()) {
            return getCurrent();
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T previous() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.previous()) {
            return getCurrent();
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T current() throws SQLException {
        if (this.closed) {
            return null;
        }
        if (this.first) {
            return first();
        }
        return getCurrent();
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T nextThrow() throws SQLException {
        boolean next;
        if (this.closed) {
            return null;
        }
        if (!this.alreadyMoved) {
            if (this.first) {
                this.first = false;
                next = this.results.first();
            } else {
                next = this.results.next();
            }
            if (!next) {
                this.first = false;
                return null;
            }
        }
        this.first = false;
        return getCurrent();
    }

    @Override // java.util.Iterator
    public T next() {
        T nextThrow;
        try {
            nextThrow = nextThrow();
        } catch (SQLException e) {
            e = e;
        }
        if (nextThrow != null) {
            return nextThrow;
        }
        e = null;
        this.last = null;
        closeQuietly();
        StringBuilder sb = new StringBuilder();
        sb.append("Could not get next result for ");
        sb.append(this.dataClass);
        throw new IllegalStateException(sb.toString(), e);
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T moveRelative(int i) throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.moveRelative(i)) {
            return getCurrent();
        }
        return null;
    }

    public void removeThrow() throws SQLException {
        T t = this.last;
        if (t == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No last ");
            sb.append(this.dataClass);
            sb.append(" object to remove. Must be called after a call to next.");
            throw new IllegalStateException(sb.toString());
        }
        Dao<T, ID> dao = this.classDao;
        if (dao == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot remove ");
            sb2.append(this.dataClass);
            sb2.append(" object because classDao not initialized");
            throw new IllegalStateException(sb2.toString());
        }
        try {
            dao.delete((Dao<T, ID>) t);
        } finally {
            this.last = null;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        try {
            removeThrow();
        } catch (SQLException e) {
            closeQuietly();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not delete ");
            sb.append(this.dataClass);
            sb.append(" object ");
            sb.append(this.last);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.compiledStmt.close();
        this.closed = true;
        this.last = null;
        if (this.statement != null) {
            logger.debug("closed iterator @{} after {} rows", Integer.valueOf(hashCode()), Integer.valueOf(this.rowC));
        }
        try {
            this.connectionSource.releaseConnection(this.connection);
        } catch (SQLException e) {
            throw new IOException("could not release connection", e);
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public DatabaseResults getRawResults() {
        return this.results;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void moveToNext() {
        this.last = null;
        this.first = false;
        this.alreadyMoved = false;
    }

    private T getCurrent() throws SQLException {
        T mapRow = this.rowMapper.mapRow(this.results);
        this.last = mapRow;
        this.alreadyMoved = false;
        this.rowC++;
        return mapRow;
    }
}
