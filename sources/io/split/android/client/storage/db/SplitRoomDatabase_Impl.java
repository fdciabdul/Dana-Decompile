package io.split.android.client.storage.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesDao_Impl;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class SplitRoomDatabase_Impl extends SplitRoomDatabase {
    private volatile AttributesDao _attributesDao;
    private volatile EventDao _eventDao;
    private volatile GeneralInfoDao _generalInfoDao;
    private volatile ImpressionDao _impressionDao;
    private volatile ImpressionsCountDao _impressionsCountDao;
    private volatile MySegmentDao _mySegmentDao;
    private volatile SplitDao _splitDao;
    private volatile UniqueKeysDao _uniqueKeysDao;

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(4) { // from class: io.split.android.client.storage.db.SplitRoomDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `my_segments` (`user_key` TEXT NOT NULL, `segment_list` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`user_key`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `splits` (`name` TEXT NOT NULL, `body` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `impressions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `test_name` TEXT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `general_info` (`name` TEXT NOT NULL, `stringValue` TEXT, `longValue` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `impressions_count` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `attributes` (`user_key` TEXT NOT NULL, `attributes` TEXT, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`user_key`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `unique_keys` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_key` TEXT NOT NULL, `feature_list` TEXT, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a996d1e0f5e8da089a69b3bfe5fa8a1f')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `my_segments`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `splits`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `events`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `impressions`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `general_info`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `impressions_count`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `attributes`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `unique_keys`");
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        RoomDatabase.Callback callback = (RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        RoomDatabase.Callback callback = (RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SplitRoomDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                SplitRoomDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i)).KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 1, null, 1));
                hashMap.put("segment_list", new TableInfo.Column("segment_list", "TEXT", true, 0, null, 1));
                hashMap.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("my_segments", hashMap, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "my_segments");
                if (!tableInfo.equals(BuiltInFictitiousFunctionClassFactory)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("my_segments(io.split.android.client.storage.db.MySegmentEntity).\n Expected:\n");
                    sb.append(tableInfo);
                    sb.append("\n Found:\n");
                    sb.append(BuiltInFictitiousFunctionClassFactory);
                    return new RoomOpenHelper.ValidationResult(false, sb.toString());
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap2.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                hashMap2.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo(ServiceConstants.DEFAULT_SPLITS_FILENAME, hashMap2, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory2 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, ServiceConstants.DEFAULT_SPLITS_FILENAME);
                if (!tableInfo2.equals(BuiltInFictitiousFunctionClassFactory2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("splits(io.split.android.client.storage.db.SplitEntity).\n Expected:\n");
                    sb2.append(tableInfo2);
                    sb2.append("\n Found:\n");
                    sb2.append(BuiltInFictitiousFunctionClassFactory2);
                    return new RoomOpenHelper.ValidationResult(false, sb2.toString());
                }
                HashMap hashMap3 = new HashMap(4);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap3.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                hashMap3.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                hashMap3.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("events", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory3 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "events");
                if (!tableInfo3.equals(BuiltInFictitiousFunctionClassFactory3)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("events(io.split.android.client.storage.db.EventEntity).\n Expected:\n");
                    sb3.append(tableInfo3);
                    sb3.append("\n Found:\n");
                    sb3.append(BuiltInFictitiousFunctionClassFactory3);
                    return new RoomOpenHelper.ValidationResult(false, sb3.toString());
                }
                HashMap hashMap4 = new HashMap(5);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap4.put("test_name", new TableInfo.Column("test_name", "TEXT", true, 0, null, 1));
                hashMap4.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                hashMap4.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                hashMap4.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo("impressions", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory4 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "impressions");
                if (!tableInfo4.equals(BuiltInFictitiousFunctionClassFactory4)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("impressions(io.split.android.client.storage.db.ImpressionEntity).\n Expected:\n");
                    sb4.append(tableInfo4);
                    sb4.append("\n Found:\n");
                    sb4.append(BuiltInFictitiousFunctionClassFactory4);
                    return new RoomOpenHelper.ValidationResult(false, sb4.toString());
                }
                HashMap hashMap5 = new HashMap(4);
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap5.put("stringValue", new TableInfo.Column("stringValue", "TEXT", false, 0, null, 1));
                hashMap5.put("longValue", new TableInfo.Column("longValue", "INTEGER", true, 0, null, 1));
                hashMap5.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("general_info", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory5 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "general_info");
                if (!tableInfo5.equals(BuiltInFictitiousFunctionClassFactory5)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("general_info(io.split.android.client.storage.db.GeneralInfoEntity).\n Expected:\n");
                    sb5.append(tableInfo5);
                    sb5.append("\n Found:\n");
                    sb5.append(BuiltInFictitiousFunctionClassFactory5);
                    return new RoomOpenHelper.ValidationResult(false, sb5.toString());
                }
                HashMap hashMap6 = new HashMap(4);
                hashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap6.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                hashMap6.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                hashMap6.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo6 = new TableInfo("impressions_count", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory6 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "impressions_count");
                if (!tableInfo6.equals(BuiltInFictitiousFunctionClassFactory6)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("impressions_count(io.split.android.client.storage.db.ImpressionsCountEntity).\n Expected:\n");
                    sb6.append(tableInfo6);
                    sb6.append("\n Found:\n");
                    sb6.append(BuiltInFictitiousFunctionClassFactory6);
                    return new RoomOpenHelper.ValidationResult(false, sb6.toString());
                }
                HashMap hashMap7 = new HashMap(3);
                hashMap7.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 1, null, 1));
                hashMap7.put("attributes", new TableInfo.Column("attributes", "TEXT", false, 0, null, 1));
                hashMap7.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("attributes", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory7 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "attributes");
                if (!tableInfo7.equals(BuiltInFictitiousFunctionClassFactory7)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("attributes(io.split.android.client.storage.db.attributes.AttributesEntity).\n Expected:\n");
                    sb7.append(tableInfo7);
                    sb7.append("\n Found:\n");
                    sb7.append(BuiltInFictitiousFunctionClassFactory7);
                    return new RoomOpenHelper.ValidationResult(false, sb7.toString());
                }
                HashMap hashMap8 = new HashMap(5);
                hashMap8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap8.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 0, null, 1));
                hashMap8.put("feature_list", new TableInfo.Column("feature_list", "TEXT", false, 0, null, 1));
                hashMap8.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                hashMap8.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo8 = new TableInfo("unique_keys", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory8 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "unique_keys");
                if (!tableInfo8.equals(BuiltInFictitiousFunctionClassFactory8)) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("unique_keys(io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity).\n Expected:\n");
                    sb8.append(tableInfo8);
                    sb8.append("\n Found:\n");
                    sb8.append(BuiltInFictitiousFunctionClassFactory8);
                    return new RoomOpenHelper.ValidationResult(false, sb8.toString());
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "a996d1e0f5e8da089a69b3bfe5fa8a1f", "7a65afa85f1fe8870e51ec2df5f9487b");
        SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(databaseConfiguration.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = roomOpenHelper;
        return databaseConfiguration.PrepareContext.create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "my_segments", ServiceConstants.DEFAULT_SPLITS_FILENAME, "events", "impressions", "general_info", "impressions_count", "attributes", "unique_keys");
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `my_segments`");
            writableDatabase.execSQL("DELETE FROM `splits`");
            writableDatabase.execSQL("DELETE FROM `events`");
            writableDatabase.execSQL("DELETE FROM `impressions`");
            writableDatabase.execSQL("DELETE FROM `general_info`");
            writableDatabase.execSQL("DELETE FROM `impressions_count`");
            writableDatabase.execSQL("DELETE FROM `attributes`");
            writableDatabase.execSQL("DELETE FROM `unique_keys`");
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
    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(MySegmentDao.class, MySegmentDao_Impl.getRequiredConverters());
        hashMap.put(SplitDao.class, SplitDao_Impl.getRequiredConverters());
        hashMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
        hashMap.put(ImpressionDao.class, ImpressionDao_Impl.getRequiredConverters());
        hashMap.put(GeneralInfoDao.class, GeneralInfoDao_Impl.getRequiredConverters());
        hashMap.put(ImpressionsCountDao.class, ImpressionsCountDao_Impl.getRequiredConverters());
        hashMap.put(AttributesDao.class, AttributesDao_Impl.getRequiredConverters());
        hashMap.put(UniqueKeysDao.class, UniqueKeysDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final MySegmentDao mySegmentDao() {
        MySegmentDao mySegmentDao;
        if (this._mySegmentDao != null) {
            return this._mySegmentDao;
        }
        synchronized (this) {
            if (this._mySegmentDao == null) {
                this._mySegmentDao = new MySegmentDao_Impl(this);
            }
            mySegmentDao = this._mySegmentDao;
        }
        return mySegmentDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final SplitDao splitDao() {
        SplitDao splitDao;
        if (this._splitDao != null) {
            return this._splitDao;
        }
        synchronized (this) {
            if (this._splitDao == null) {
                this._splitDao = new SplitDao_Impl(this);
            }
            splitDao = this._splitDao;
        }
        return splitDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final EventDao eventDao() {
        EventDao eventDao;
        if (this._eventDao != null) {
            return this._eventDao;
        }
        synchronized (this) {
            if (this._eventDao == null) {
                this._eventDao = new EventDao_Impl(this);
            }
            eventDao = this._eventDao;
        }
        return eventDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final ImpressionDao impressionDao() {
        ImpressionDao impressionDao;
        if (this._impressionDao != null) {
            return this._impressionDao;
        }
        synchronized (this) {
            if (this._impressionDao == null) {
                this._impressionDao = new ImpressionDao_Impl(this);
            }
            impressionDao = this._impressionDao;
        }
        return impressionDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final GeneralInfoDao generalInfoDao() {
        GeneralInfoDao generalInfoDao;
        if (this._generalInfoDao != null) {
            return this._generalInfoDao;
        }
        synchronized (this) {
            if (this._generalInfoDao == null) {
                this._generalInfoDao = new GeneralInfoDao_Impl(this);
            }
            generalInfoDao = this._generalInfoDao;
        }
        return generalInfoDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final ImpressionsCountDao impressionsCountDao() {
        ImpressionsCountDao impressionsCountDao;
        if (this._impressionsCountDao != null) {
            return this._impressionsCountDao;
        }
        synchronized (this) {
            if (this._impressionsCountDao == null) {
                this._impressionsCountDao = new ImpressionsCountDao_Impl(this);
            }
            impressionsCountDao = this._impressionsCountDao;
        }
        return impressionsCountDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final AttributesDao attributesDao() {
        AttributesDao attributesDao;
        if (this._attributesDao != null) {
            return this._attributesDao;
        }
        synchronized (this) {
            if (this._attributesDao == null) {
                this._attributesDao = new AttributesDao_Impl(this);
            }
            attributesDao = this._attributesDao;
        }
        return attributesDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public final UniqueKeysDao uniqueKeysDao() {
        UniqueKeysDao uniqueKeysDao;
        if (this._uniqueKeysDao != null) {
            return this._uniqueKeysDao;
        }
        synchronized (this) {
            if (this._uniqueKeysDao == null) {
                this._uniqueKeysDao = new UniqueKeysDao_Impl(this);
            }
            uniqueKeysDao = this._uniqueKeysDao;
        }
        return uniqueKeysDao;
    }
}
