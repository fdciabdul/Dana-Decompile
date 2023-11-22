package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

/* loaded from: classes8.dex */
public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__5.0__";
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;
    private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
    private static final String[] NO_STRING_ARGS = new String[0];

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.db.inTransaction()) {
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            }
        } else if (this.db.inTransaction()) {
        } else {
            this.db.beginTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("problems beginning transaction ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("problems commiting transaction ");
            sb.append(savepoint.getSavepointName());
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("problems rolling back transaction ");
            sb.append(savepoint.getSavepointName());
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i, boolean z) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled, z);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.db.compileStatement(str);
                bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                long executeInsert = sQLiteStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(executeInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                return 1;
            } catch (android.database.SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("inserting to database failed: ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            closeQuietly(sQLiteStatement);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.j256.ormlite.android.AndroidDatabaseConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // com.j256.ormlite.support.DatabaseConnection
    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException {
        android.database.SQLException e;
        T t;
        ?? r5 = (T) false;
        try {
            try {
                objArr = this.db.rawQuery(str, toStrings(objArr));
                try {
                    AndroidDatabaseResults androidDatabaseResults = new AndroidDatabaseResults(objArr, objectCache, true);
                    try {
                        logger.trace("{}: queried for one result: {}", (Object) this, str);
                        if (androidDatabaseResults.first()) {
                            t = genericRowMapper.mapRow(androidDatabaseResults);
                            if (androidDatabaseResults.next()) {
                                Object obj = MORE_THAN_ONE;
                                IOUtils.closeQuietly(androidDatabaseResults);
                                closeQuietly(objArr);
                                return obj;
                            }
                        } else {
                            t = r5;
                        }
                        IOUtils.closeQuietly(androidDatabaseResults);
                        closeQuietly(objArr);
                        return t;
                    } catch (android.database.SQLException e2) {
                        e = e2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("queryForOne from database failed: ");
                        sb.append(str);
                        throw SqlExceptionUtil.create(sb.toString(), e);
                    } catch (Throwable th) {
                        th = th;
                        r5 = (T) androidDatabaseResults;
                        IOUtils.closeQuietly(r5);
                        closeQuietly(objArr);
                        throw th;
                    }
                } catch (android.database.SQLException e3) {
                    e = e3;
                }
            } catch (android.database.SQLException e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                objArr = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.db.compileStatement(str);
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(simpleQueryForLong), str);
                return simpleQueryForLong;
            } catch (android.database.SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("queryForLong from database failed: ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } finally {
            closeQuietly(sQLiteStatement);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.j256.ormlite.android.AndroidDatabaseResults, java.io.Closeable] */
    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        Closeable closeable;
        android.database.SQLException e;
        Cursor cursor;
        ?? r0;
        Cursor cursor2 = null;
        try {
            cursor = this.db.rawQuery(str, toStrings(objArr));
        } catch (android.database.SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            closeable = null;
            closeQuietly(cursor2);
            IOUtils.closeQuietly(closeable);
            throw th;
        }
        try {
            r0 = new AndroidDatabaseResults(cursor, null, false);
        } catch (android.database.SQLException e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            r0 = cursor2;
            cursor2 = cursor;
            closeable = r0;
            closeQuietly(cursor2);
            IOUtils.closeQuietly(closeable);
            throw th;
        }
        try {
            long j = r0.first() ? r0.getLong(0) : 0L;
            logger.trace("{}: query for long raw query returned {}: {}", this, Long.valueOf(j), str);
            closeQuietly(cursor);
            IOUtils.closeQuietly(r0);
            return j;
        } catch (android.database.SQLException e4) {
            e = e4;
            cursor2 = r0;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("queryForLong from database failed: ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            } catch (Throwable th3) {
                th = th3;
                r0 = cursor2;
                cursor2 = cursor;
                closeable = r0;
                closeQuietly(cursor2);
                IOUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursor;
            closeable = r0;
            closeQuietly(cursor2);
            IOUtils.closeQuietly(closeable);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", this, this.db);
        } catch (android.database.SQLException e) {
            throw new IOException("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        SQLiteDatabase sQLiteDatabase = this.db;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '");
        sb.append(str);
        sb.append("'");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            boolean z = rawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
            return z;
        } finally {
            rawQuery.close();
        }
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws SQLException {
        SQLiteStatement sQLiteStatement;
        int i;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                sQLiteStatement = this.db.compileStatement(str);
                try {
                    bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                    sQLiteStatement.execute();
                    closeQuietly(sQLiteStatement);
                    try {
                        sQLiteStatement2 = this.db.compileStatement("SELECT CHANGES()");
                        i = (int) sQLiteStatement2.simpleQueryForLong();
                    } catch (android.database.SQLException unused) {
                        i = 1;
                    } catch (Throwable th) {
                        closeQuietly(sQLiteStatement2);
                        throw th;
                    }
                    closeQuietly(sQLiteStatement2);
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(i), str);
                    return i;
                } catch (android.database.SQLException e) {
                    e = e;
                    sQLiteStatement2 = sQLiteStatement;
                    StringBuilder sb = new StringBuilder();
                    sb.append("updating database failed: ");
                    sb.append(str);
                    throw SqlExceptionUtil.create(sb.toString(), e);
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = sQLiteStatement2;
            }
        } catch (android.database.SQLException e2) {
            e = e2;
        }
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i].getSqlType();
                switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i + 1, obj.toString());
                        continue;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                        continue;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                        continue;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                        continue;
                    case 13:
                    case 14:
                    case 15:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid Android type: ");
                        sb.append(sqlType);
                        throw new SQLException(sb.toString());
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unknown sql argument type: ");
                        sb2.append(sqlType);
                        throw new SQLException(sb2.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }

    private void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private void closeQuietly(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
    }

    /* loaded from: classes8.dex */
    static class OurSavePoint implements Savepoint {
        private String name;

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }
}
