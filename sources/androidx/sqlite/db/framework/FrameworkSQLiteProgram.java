package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* loaded from: classes6.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.getAuthRequestContext = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.getAuthRequestContext.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.getAuthRequestContext.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.getAuthRequestContext.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        this.getAuthRequestContext.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        this.getAuthRequestContext.bindBlob(i, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.getAuthRequestContext.close();
    }
}
