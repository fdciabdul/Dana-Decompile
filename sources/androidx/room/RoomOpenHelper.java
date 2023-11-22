package androidx.room;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes6.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    private DatabaseConfiguration BuiltInFictitiousFunctionClassFactory;
    private final String MyBillsEntityDataFactory;
    private final String PlaceComponentResult;
    private final Delegate getAuthRequestContext;

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.version);
        this.BuiltInFictitiousFunctionClassFactory = databaseConfiguration;
        this.getAuthRequestContext = delegate;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void BuiltInFictitiousFunctionClassFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(supportSQLiteDatabase);
        this.getAuthRequestContext.createAllTables(supportSQLiteDatabase);
        if (!MyBillsEntityDataFactory) {
            ValidationResult onValidateSchema = this.getAuthRequestContext.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("Pre-packaged database has an invalid schema: ");
                sb.append(onValidateSchema.getAuthRequestContext);
                throw new IllegalStateException(sb.toString());
            }
        }
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL(RoomMasterTable.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
        this.getAuthRequestContext.onCreate(supportSQLiteDatabase);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0077 A[EDGE_INSN: B:63:0x0077->B:40:0x0077 BREAK  A[LOOP:1: B:11:0x001c->B:68:?], SYNTHETIC] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(androidx.sqlite.db.SupportSQLiteDatabase r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.getAuthRequestContext(androidx.sqlite.db.SupportSQLiteDatabase, int, int):void");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        getAuthRequestContext(supportSQLiteDatabase, i, i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.getAuthRequestContext(supportSQLiteDatabase);
        if (PlaceComponentResult(supportSQLiteDatabase)) {
            Cursor query = supportSQLiteDatabase.query(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                String string = query.moveToFirst() ? query.getString(0) : null;
                query.close();
                if (!this.MyBillsEntityDataFactory.equals(string) && !this.PlaceComponentResult.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        } else {
            ValidationResult onValidateSchema = this.getAuthRequestContext.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("Pre-packaged database has an invalid schema: ");
                sb.append(onValidateSchema.getAuthRequestContext);
                throw new IllegalStateException(sb.toString());
            }
            this.getAuthRequestContext.onPostMigrate(supportSQLiteDatabase);
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
        }
        this.getAuthRequestContext.onOpen(supportSQLiteDatabase);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    private static boolean PlaceComponentResult(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            query.close();
        }
    }

    private static boolean MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            query.close();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Delegate {
        public final int version;

        protected abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        protected void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        protected void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public Delegate(int i) {
            this.version = i;
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        protected ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, null);
        }
    }

    /* loaded from: classes6.dex */
    public static class ValidationResult {
        public final boolean PlaceComponentResult;
        public final String getAuthRequestContext;

        public ValidationResult(boolean z, String str) {
            this.PlaceComponentResult = z;
            this.getAuthRequestContext = str;
        }
    }
}
