package net.sqlcipher.database;

import com.fullstory.instrumentation.InstrumentInjector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    SQLiteDatabase mDatabase;
    private String mSqlStmt;
    long nHandle;
    long nStatement = 0;
    private boolean mInUse = false;

    private final native void native_compile(String str);

    private final native void native_finalize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.mSqlStmt = null;
        if (!sQLiteDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(sQLiteDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
        this.mDatabase = sQLiteDatabase;
        this.mSqlStmt = str;
        this.nHandle = sQLiteDatabase.mNativeHandle;
        compile(str, true);
    }

    private void compile(String str, boolean z) {
        if (!this.mDatabase.isOpen()) {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        } else if (z) {
            this.mDatabase.lock();
            try {
                native_compile(str);
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseSqlStatement() {
        if (this.nStatement != 0) {
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb = new StringBuilder();
                sb.append("closed and deallocated DbObj (id#");
                sb.append(this.nStatement);
                sb.append(")");
                InstrumentInjector.log_v(TAG, sb.toString());
            }
            try {
                this.mDatabase.lock();
                native_finalize();
                this.nStatement = 0L;
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean acquire() {
        synchronized (this) {
            if (this.mInUse) {
                return false;
            }
            this.mInUse = true;
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb = new StringBuilder();
                sb.append("Acquired DbObj (id#");
                sb.append(this.nStatement);
                sb.append(") from DB cache");
                InstrumentInjector.log_v(TAG, sb.toString());
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        synchronized (this) {
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb = new StringBuilder();
                sb.append("Released DbObj (id#");
                sb.append(this.nStatement);
                sb.append(") back to DB cache");
                InstrumentInjector.log_v(TAG, sb.toString());
            }
            this.mInUse = false;
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.nStatement == 0) {
                return;
            }
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                StringBuilder sb = new StringBuilder();
                sb.append("** warning ** Finalized DbObj (id#");
                sb.append(this.nStatement);
                sb.append(")");
                InstrumentInjector.log_v(TAG, sb.toString());
            }
            releaseSqlStatement();
        } finally {
            super.finalize();
        }
    }
}
