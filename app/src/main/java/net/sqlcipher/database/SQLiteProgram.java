package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String TAG = "SQLiteProgram";
    boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected long nHandle;
    @Deprecated
    protected long nStatement;

    private final native void native_clear_bindings();

    @Deprecated
    protected void compile(String str, boolean z) {
    }

    protected final native void native_bind_blob(int i, byte[] bArr);

    protected final native void native_bind_double(int i, double d);

    protected final native void native_bind_long(int i, long j);

    protected final native void native_bind_null(int i);

    protected final native void native_bind_string(int i, String str);

    @Deprecated
    protected final native void native_compile(String str);

    @Deprecated
    protected final native void native_finalize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mDatabase = sQLiteDatabase;
        String trim = str.trim();
        this.mSql = trim;
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        trim = trim.length() >= 6 ? trim.substring(0, 6) : trim;
        if (!trim.equalsIgnoreCase("INSERT") && !trim.equalsIgnoreCase("UPDATE") && !trim.equalsIgnoreCase("REPLAC") && !trim.equalsIgnoreCase("DELETE") && !trim.equalsIgnoreCase("SELECT")) {
            SQLiteCompiledSql sQLiteCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql;
            this.nStatement = sQLiteCompiledSql.nStatement;
            return;
        }
        SQLiteCompiledSql compiledStatementForSql = sQLiteDatabase.getCompiledStatementForSql(str);
        this.mCompiledSql = compiledStatementForSql;
        if (compiledStatementForSql == null) {
            SQLiteCompiledSql sQLiteCompiledSql2 = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql2;
            sQLiteCompiledSql2.acquire();
            sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb = new StringBuilder();
                sb.append("Created DbObj (id#");
                sb.append(this.mCompiledSql.nStatement);
                sb.append(") for sql: ");
                sb.append(str);
                InstrumentInjector.log_v(TAG, sb.toString());
            }
        } else if (!compiledStatementForSql.acquire()) {
            long j = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("** possible bug ** Created NEW DbObj (id#");
                sb2.append(this.mCompiledSql.nStatement);
                sb2.append(") because the previously created DbObj (id#");
                sb2.append(j);
                sb2.append(") was not released for sql:");
                sb2.append(str);
                InstrumentInjector.log_v(TAG, sb2.toString());
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        synchronized (this.mDatabase.mCompiledQueries) {
            if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                this.mCompiledSql.releaseSqlStatement();
                this.mCompiledSql = null;
                this.nStatement = 0L;
            } else {
                this.mCompiledSql.release();
            }
        }
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    String getSqlString() {
        return this.mSql;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
        acquireReference();
        try {
            native_bind_null(i);
        } finally {
            releaseReference();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
        acquireReference();
        try {
            native_bind_long(i, j);
        } finally {
            releaseReference();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
        acquireReference();
        try {
            native_bind_double(i, d);
        } finally {
            releaseReference();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("the bind value at index ");
            sb.append(i);
            sb.append(" is null");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else {
            if (!this.mDatabase.isOpen()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("database ");
                sb2.append(this.mDatabase.getPath());
                sb2.append(" already closed");
                throw new IllegalStateException(sb2.toString());
            }
            acquireReference();
            try {
                native_bind_string(i, str);
            } finally {
                releaseReference();
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("the bind value at index ");
            sb.append(i);
            sb.append(" is null");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else {
            if (!this.mDatabase.isOpen()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("database ");
                sb2.append(this.mDatabase.getPath());
                sb2.append(" already closed");
                throw new IllegalStateException(sb2.toString());
            }
            acquireReference();
            try {
                native_bind_blob(i, bArr);
            } finally {
                releaseReference();
            }
        }
    }

    public void clearBindings() {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (!this.mDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
        acquireReference();
        try {
            native_clear_bindings();
        } finally {
            releaseReference();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.mClosed && this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
                this.mDatabase.unlock();
                this.mClosed = true;
            } catch (Throwable th) {
                this.mDatabase.unlock();
                throw th;
            }
        }
    }
}
