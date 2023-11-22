package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class AndroidCompiledStatement implements CompiledStatement {
    private List<Object> args;
    private final boolean cacheStore;
    private final boolean cancelQueriesEnabled;
    private ApiCompatibility.CancellationHook cancellationHook;
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;
    private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    private static final String[] NO_STRING_ARGS = new String[0];
    private static final ApiCompatibility apiCompatibility = ApiCompatibilityUtils.getCompatibility();

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setQueryTimeout(long j) {
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z, boolean z2) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
        this.cacheStore = z2;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public String getColumnName(int i) throws SQLException {
        return getCursor().getColumnName(i);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (!this.type.isOkForQuery()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call query on a ");
            sb.append(this.type);
            sb.append(" statement");
            throw new IllegalArgumentException(sb.toString());
        }
        return new AndroidDatabaseResults(getCursor(), objectCache, this.cacheStore);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runUpdate() throws SQLException {
        String obj;
        if (!this.type.isOkForUpdate()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call update on a ");
            sb.append(this.type);
            sb.append(" statement");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.max == null) {
            obj = this.sql;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.sql);
            sb2.append(" ");
            sb2.append(this.max);
            obj = sb2.toString();
        }
        return execSql(this.db, "runUpdate", obj, getArgArray());
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runExecute() throws SQLException {
        if (!this.type.isOkForExecute()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call execute on a ");
            sb.append(this.type);
            sb.append(" statement");
            throw new IllegalArgumentException(sb.toString());
        }
        return execSql(this.db, "runExecute", this.sql, getArgArray());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Cursor cursor = this.cursor;
        if (cursor != null && !cursor.isClosed()) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e) {
                throw new IOException("Problems closing Android cursor", e);
            }
        }
        this.cancellationHook = null;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void closeQuietly() {
        Cursor cursor = this.cursor;
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void cancel() {
        ApiCompatibility.CancellationHook cancellationHook = this.cancellationHook;
        if (cancellationHook != null) {
            cancellationHook.cancel();
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setObject(int i, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i, null);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                this.args.add(i, obj.toString());
                return;
            case 12:
            case 13:
                this.args.add(i, obj);
                return;
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

    /* renamed from: com.j256.ormlite.android.AndroidCompiledStatement$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
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
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
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

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setMaxRows(int i) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i);
    }

    public Cursor getCursor() throws SQLException {
        if (this.cursor == null) {
            String str = null;
            try {
                if (this.max == null) {
                    str = this.sql;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.sql);
                    sb.append(" LIMIT ");
                    sb.append(this.max);
                    str = sb.toString();
                }
                if (this.cancelQueriesEnabled) {
                    this.cancellationHook = apiCompatibility.createCancellationHook();
                }
                Cursor rawQuery = apiCompatibility.rawQuery(this.db, str, getStringArray(), this.cancellationHook);
                this.cursor = rawQuery;
                rawQuery.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", this, str);
            } catch (android.database.SQLException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Problems executing Android query: ");
                sb2.append(str);
                throw SqlExceptionUtil.create(sb2.toString(), e);
            }
        }
        return this.cursor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        com.j256.ormlite.android.AndroidCompiledStatement.logger.trace("executing statement {} changed {} rows: {}", r4, java.lang.Integer.valueOf(r6), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r0 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int execSql(android.database.sqlite.SQLiteDatabase r3, java.lang.String r4, java.lang.String r5, java.lang.Object[] r6) throws java.sql.SQLException {
        /*
            r3.execSQL(r5, r6)     // Catch: android.database.SQLException -> L2d
            r6 = 1
            r0 = 0
            java.lang.String r1 = "SELECT CHANGES()"
            android.database.sqlite.SQLiteStatement r0 = r3.compileStatement(r1)     // Catch: android.database.SQLException -> L13 java.lang.Throwable -> L15
            long r1 = r0.simpleQueryForLong()     // Catch: android.database.SQLException -> L13 java.lang.Throwable -> L15
            int r6 = (int) r1
            if (r0 == 0) goto L21
            goto L1e
        L13:
            goto L1c
        L15:
            r3 = move-exception
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            throw r3
        L1c:
            if (r0 == 0) goto L21
        L1e:
            r0.close()
        L21:
            com.j256.ormlite.logger.Logger r3 = com.j256.ormlite.android.AndroidCompiledStatement.logger
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "executing statement {} changed {} rows: {}"
            r3.trace(r1, r4, r0, r5)
            return r6
        L2d:
            r3 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Problems executing "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = " Android statement: "
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.sql.SQLException r3 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r3)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidCompiledStatement.execSql(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.Object[]):int");
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return list.toArray(new Object[list.size()]);
    }

    private String[] getStringArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
