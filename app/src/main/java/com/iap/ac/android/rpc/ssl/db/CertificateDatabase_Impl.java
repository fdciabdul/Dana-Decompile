package com.iap.ac.android.rpc.ssl.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes8.dex */
public class CertificateDatabase_Impl extends CertificateDatabase {
    private volatile CertificateDao _certificateDao;

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.iap.ac.android.rpc.ssl.db.CertificateDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `certificate` (`certificateData` BLOB, `certificateUrl` TEXT NOT NULL, PRIMARY KEY(`certificateUrl`))");
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
                hashMap.put("certificateData", new TableInfo.Column("certificateData", "BLOB", false, 0));
                hashMap.put("certificateUrl", new TableInfo.Column("certificateUrl", "TEXT", true, 1));
                TableInfo tableInfo = new TableInfo("certificate", hashMap, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "certificate");
                if (tableInfo.equals(BuiltInFictitiousFunctionClassFactory)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Migration didn't properly handle certificate(com.iap.ac.android.rpc.ssl.db.CertificateEntity).\n Expected:\n");
                sb.append(tableInfo);
                sb.append("\n Found:\n");
                sb.append(BuiltInFictitiousFunctionClassFactory);
                throw new IllegalStateException(sb.toString());
            }
        }, "67d1572c5ffabc669d4b58d68e13a0c6", "028bbde6114c5ccfde3033904115bc7e");
        SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(databaseConfiguration.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = roomOpenHelper;
        return databaseConfiguration.PrepareContext.create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "certificate");
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

    @Override // com.iap.ac.android.rpc.ssl.db.CertificateDatabase
    public CertificateDao certificateDao() {
        CertificateDao certificateDao;
        if (this._certificateDao != null) {
            return this._certificateDao;
        }
        synchronized (this) {
            if (this._certificateDao == null) {
                this._certificateDao = new CertificateDao_Impl(this);
            }
            certificateDao = this._certificateDao;
        }
        return certificateDao;
    }
}
