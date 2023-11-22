package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dataSource was not set on ");
        sb.append(getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public <T> T callInTransaction(String str, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(str, this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        return (T) callInTransaction((String) null, connectionSource, callable);
    }

    public static <T> T callInTransaction(String str, ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: all -> 0x0073, Exception -> 0x0075, SQLException -> 0x0088, TRY_LEAVE, TryCatch #5 {Exception -> 0x0075, blocks: (B:22:0x005f, B:24:0x0065), top: B:50:0x005f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r6, boolean r7, com.j256.ormlite.db.DatabaseType r8, java.util.concurrent.Callable<T> r9) throws java.sql.SQLException {
        /*
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            java.lang.String r1 = "restored auto-commit to true"
            r2 = 1
            r3 = 0
            if (r7 != 0) goto L12
            boolean r7 = r8.isNestedSavePointsSupported()     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto Lf
            goto L12
        Lf:
            r7 = 0
            r8 = 0
            goto L5f
        L12:
            boolean r7 = r6.isAutoCommitSupported()     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto L2d
            boolean r7 = r6.isAutoCommit()     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto L2d
            r6.setAutoCommit(r3)     // Catch: java.lang.Throwable -> L95
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L2a
            java.lang.String r8 = "had to set auto-commit to false"
            r7.debug(r8)     // Catch: java.lang.Throwable -> L2a
            r3 = 1
            goto L2d
        L2a:
            r7 = move-exception
            r8 = 1
            goto L97
        L2d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r7.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "ORMLITE"
            r7.append(r8)     // Catch: java.lang.Throwable -> L95
            java.util.concurrent.atomic.AtomicInteger r8 = com.j256.ormlite.misc.TransactionManager.savePointCounter     // Catch: java.lang.Throwable -> L95
            int r8 = r8.incrementAndGet()     // Catch: java.lang.Throwable -> L95
            r7.append(r8)     // Catch: java.lang.Throwable -> L95
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L95
            java.sql.Savepoint r7 = r6.setSavePoint(r7)     // Catch: java.lang.Throwable -> L95
            if (r7 != 0) goto L52
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L95
            java.lang.String r4 = "started savePoint transaction"
            r8.debug(r4)     // Catch: java.lang.Throwable -> L95
            goto L5d
        L52:
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L95
            java.lang.String r4 = "started savePoint transaction {}"
            java.lang.String r5 = r7.getSavepointName()     // Catch: java.lang.Throwable -> L95
            r8.debug(r4, r5)     // Catch: java.lang.Throwable -> L95
        L5d:
            r8 = r3
            r3 = 1
        L5f:
            java.lang.Object r9 = r9.call()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75 java.sql.SQLException -> L88
            if (r3 == 0) goto L68
            commit(r6, r7)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75 java.sql.SQLException -> L88
        L68:
            if (r8 == 0) goto L72
            r6.setAutoCommit(r2)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r1)
        L72:
            return r9
        L73:
            r7 = move-exception
            goto L97
        L75:
            r9 = move-exception
            if (r3 == 0) goto L81
            rollBack(r6, r7)     // Catch: java.lang.Throwable -> L73 java.sql.SQLException -> L7c
            goto L81
        L7c:
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L73
            r7.error(r9, r0)     // Catch: java.lang.Throwable -> L73
        L81:
            java.lang.String r7 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r7 = com.j256.ormlite.misc.SqlExceptionUtil.create(r7, r9)     // Catch: java.lang.Throwable -> L73
            throw r7     // Catch: java.lang.Throwable -> L73
        L88:
            r9 = move-exception
            if (r3 == 0) goto L94
            rollBack(r6, r7)     // Catch: java.lang.Throwable -> L73 java.sql.SQLException -> L8f
            goto L94
        L8f:
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L73
            r7.error(r9, r0)     // Catch: java.lang.Throwable -> L73
        L94:
            throw r9     // Catch: java.lang.Throwable -> L73
        L95:
            r7 = move-exception
            r8 = r3
        L97:
            if (r8 == 0) goto La1
            r6.setAutoCommit(r2)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r1)
        La1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }
}
