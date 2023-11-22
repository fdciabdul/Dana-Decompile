package com.alipay.imobile.network.sslpinning.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes6.dex */
public class CertificateDatabase_Impl extends CertificateDatabase {

    /* renamed from: a  reason: collision with root package name */
    private volatile com.alipay.imobile.network.sslpinning.db.a f7088a;

    /* loaded from: classes6.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `certificate` (`certificateUrl` TEXT NOT NULL, `certificateData` BLOB, PRIMARY KEY(`certificateUrl`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"67d1572c5ffabc669d4b58d68e13a0c6\")");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `certificate`");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (CertificateDatabase_Impl.this.mCallbacks != null) {
                int size = CertificateDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    RoomDatabase.Callback callback = (RoomDatabase.Callback) CertificateDatabase_Impl.this.mCallbacks.get(i);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            CertificateDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            CertificateDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (CertificateDatabase_Impl.this.mCallbacks != null) {
                int size = CertificateDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) CertificateDatabase_Impl.this.mCallbacks.get(i)).KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("certificateUrl", new TableInfo.Column("certificateUrl", "TEXT", true, 1));
            hashMap.put("certificateData", new TableInfo.Column("certificateData", "BLOB", false, 0));
            TableInfo tableInfo = new TableInfo("certificate", hashMap, new HashSet(0), new HashSet(0));
            TableInfo BuiltInFictitiousFunctionClassFactory = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "certificate");
            if (tableInfo.equals(BuiltInFictitiousFunctionClassFactory)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Migration didn't properly handle certificate(com.alipay.imobile.network.sslpinning.db.CertificateEntity).\n Expected:\n");
            sb.append(tableInfo);
            sb.append("\n Found:\n");
            sb.append(BuiltInFictitiousFunctionClassFactory);
            throw new IllegalStateException(sb.toString());
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `certificate`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "certificate");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new a(1), "67d1572c5ffabc669d4b58d68e13a0c6", "5f02091a66b0e97e0ae08ba0eed5c426");
        SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(databaseConfiguration.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = roomOpenHelper;
        return databaseConfiguration.PrepareContext.create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }

    @Override // com.alipay.imobile.network.sslpinning.db.CertificateDatabase
    public com.alipay.imobile.network.sslpinning.db.a a() {
        com.alipay.imobile.network.sslpinning.db.a aVar;
        if (this.f7088a != null) {
            return this.f7088a;
        }
        synchronized (this) {
            if (this.f7088a == null) {
                this.f7088a = new b(this);
            }
            aVar = this.f7088a;
        }
        return aVar;
    }
}
