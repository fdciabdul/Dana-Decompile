package net.sqlcipher;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private final String TAG = getClass().getSimpleName();

    @Override // net.sqlcipher.DatabaseErrorHandler
    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Corruption reported by sqlite on database, deleting: ");
        sb.append(sQLiteDatabase.getPath());
        InstrumentInjector.log_e(str, sb.toString());
        if (sQLiteDatabase.isOpen()) {
            InstrumentInjector.log_e(this.TAG, "Database object for corrupted database is already open, closing");
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                InstrumentInjector.log_e(this.TAG, "Exception closing Database object for corrupted database, ignored", e);
            }
        }
        deleteDatabaseFile(sQLiteDatabase.getPath());
    }

    private void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(SQLiteDatabase.MEMORY) || str.trim().length() == 0) {
            return;
        }
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("deleting the database file: ");
        sb.append(str);
        InstrumentInjector.log_e(str2, sb.toString());
        try {
            new File(str).delete();
        } catch (Exception e) {
            String str3 = this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete failed: ");
            sb2.append(e.getMessage());
            InstrumentInjector.log_w(str3, sb2.toString());
        }
    }
}
