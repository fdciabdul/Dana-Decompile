package androidx.work.impl;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes6.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile PreferenceDao KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile DependencyDao MyBillsEntityDataFactory;
    private volatile WorkNameDao NetworkUserEntityData$$ExternalSyntheticLambda0;
    private volatile RawWorkInfoDao getAuthRequestContext;
    private volatile WorkTagDao getErrorConfigVersion;
    private volatile WorkProgressDao lookAheadTest;
    private volatile WorkSpecDao moveToNextValue;
    private volatile SystemIdInfoDao scheduleImpl;

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate() { // from class: androidx.work.impl.WorkDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        RoomDatabase.Callback callback = (RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        RoomDatabase.Callback callback = (RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                WorkDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", Arrays.asList("work_spec_id")));
                hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", Arrays.asList("prerequisite_id")));
                TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
                TableInfo BuiltInFictitiousFunctionClassFactory = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "Dependency");
                if (!tableInfo.equals(BuiltInFictitiousFunctionClassFactory)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n");
                    sb.append(tableInfo);
                    sb.append("\n Found:\n");
                    sb.append(BuiltInFictitiousFunctionClassFactory);
                    return new RoomOpenHelper.ValidationResult(false, sb.toString());
                }
                HashMap hashMap2 = new HashMap(25);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                hashMap2.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                hashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
                hashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", false, 0, null, 1));
                hashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
                hashMap2.put(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, new TableInfo.Column(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, "BLOB", true, 0, null, 1));
                hashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
                hashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
                hashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("period_start_time", new TableInfo.Column("period_start_time", "INTEGER", true, 0, null, 1));
                hashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                hashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
                hashMap2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
                hashMap2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                hashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", false, 0, null, 1));
                hashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                hashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                hashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                hashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", false, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", Arrays.asList("schedule_requested_at")));
                hashSet4.add(new TableInfo.Index("index_WorkSpec_period_start_time", Arrays.asList("period_start_time")));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", hashMap2, hashSet3, hashSet4);
                TableInfo BuiltInFictitiousFunctionClassFactory2 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "WorkSpec");
                if (!tableInfo2.equals(BuiltInFictitiousFunctionClassFactory2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n");
                    sb2.append(tableInfo2);
                    sb2.append("\n Found:\n");
                    sb2.append(BuiltInFictitiousFunctionClassFactory2);
                    return new RoomOpenHelper.ValidationResult(false, sb2.toString());
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                hashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", Arrays.asList("work_spec_id")));
                TableInfo tableInfo3 = new TableInfo("WorkTag", hashMap3, hashSet5, hashSet6);
                TableInfo BuiltInFictitiousFunctionClassFactory3 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "WorkTag");
                if (!tableInfo3.equals(BuiltInFictitiousFunctionClassFactory3)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n");
                    sb3.append(tableInfo3);
                    sb3.append("\n Found:\n");
                    sb3.append(BuiltInFictitiousFunctionClassFactory3);
                    return new RoomOpenHelper.ValidationResult(false, sb3.toString());
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                TableInfo tableInfo4 = new TableInfo("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory4 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "SystemIdInfo");
                if (!tableInfo4.equals(BuiltInFictitiousFunctionClassFactory4)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n");
                    sb4.append(tableInfo4);
                    sb4.append("\n Found:\n");
                    sb4.append(BuiltInFictitiousFunctionClassFactory4);
                    return new RoomOpenHelper.ValidationResult(false, sb4.toString());
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", Arrays.asList("work_spec_id")));
                TableInfo tableInfo5 = new TableInfo("WorkName", hashMap5, hashSet8, hashSet9);
                TableInfo BuiltInFictitiousFunctionClassFactory5 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "WorkName");
                if (!tableInfo5.equals(BuiltInFictitiousFunctionClassFactory5)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n");
                    sb5.append(tableInfo5);
                    sb5.append("\n Found:\n");
                    sb5.append(BuiltInFictitiousFunctionClassFactory5);
                    return new RoomOpenHelper.ValidationResult(false, sb5.toString());
                }
                HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                hashMap6.put("progress", new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                TableInfo tableInfo6 = new TableInfo("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory6 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "WorkProgress");
                if (!tableInfo6.equals(BuiltInFictitiousFunctionClassFactory6)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n");
                    sb6.append(tableInfo6);
                    sb6.append("\n Found:\n");
                    sb6.append(BuiltInFictitiousFunctionClassFactory6);
                    return new RoomOpenHelper.ValidationResult(false, sb6.toString());
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                hashMap7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("Preference", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory7 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "Preference");
                if (!tableInfo7.equals(BuiltInFictitiousFunctionClassFactory7)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Preference(androidx.work.impl.model.Preference).\n Expected:\n");
                    sb7.append(tableInfo7);
                    sb7.append("\n Found:\n");
                    sb7.append(BuiltInFictitiousFunctionClassFactory7);
                    return new RoomOpenHelper.ValidationResult(false, sb7.toString());
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6");
        SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(databaseConfiguration.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = roomOpenHelper;
        return databaseConfiguration.PrepareContext.create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } finally {
                super.endTransaction();
                if (!z) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
            }
        }
        super.beginTransaction();
        if (z) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `Dependency`");
        writableDatabase.execSQL("DELETE FROM `WorkSpec`");
        writableDatabase.execSQL("DELETE FROM `WorkTag`");
        writableDatabase.execSQL("DELETE FROM `SystemIdInfo`");
        writableDatabase.execSQL("DELETE FROM `WorkName`");
        writableDatabase.execSQL("DELETE FROM `WorkProgress`");
        writableDatabase.execSQL("DELETE FROM `Preference`");
        super.setTransactionSuccessful();
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkSpecDao getErrorConfigVersion() {
        WorkSpecDao workSpecDao;
        if (this.moveToNextValue != null) {
            return this.moveToNextValue;
        }
        synchronized (this) {
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new WorkSpecDao_Impl(this);
            }
            workSpecDao = this.moveToNextValue;
        }
        return workSpecDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final DependencyDao KClassImpl$Data$declaredNonStaticMembers$2() {
        DependencyDao dependencyDao;
        if (this.MyBillsEntityDataFactory != null) {
            return this.MyBillsEntityDataFactory;
        }
        synchronized (this) {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new DependencyDao_Impl(this);
            }
            dependencyDao = this.MyBillsEntityDataFactory;
        }
        return dependencyDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkTagDao scheduleImpl() {
        WorkTagDao workTagDao;
        if (this.getErrorConfigVersion != null) {
            return this.getErrorConfigVersion;
        }
        synchronized (this) {
            if (this.getErrorConfigVersion == null) {
                this.getErrorConfigVersion = new WorkTagDao_Impl(this);
            }
            workTagDao = this.getErrorConfigVersion;
        }
        return workTagDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final SystemIdInfoDao getAuthRequestContext() {
        SystemIdInfoDao systemIdInfoDao;
        if (this.scheduleImpl != null) {
            return this.scheduleImpl;
        }
        synchronized (this) {
            if (this.scheduleImpl == null) {
                this.scheduleImpl = new SystemIdInfoDao_Impl(this);
            }
            systemIdInfoDao = this.scheduleImpl;
        }
        return systemIdInfoDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkNameDao NetworkUserEntityData$$ExternalSyntheticLambda0() {
        WorkNameDao workNameDao;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        synchronized (this) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new WorkNameDao_Impl(this);
            }
            workNameDao = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return workNameDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkProgressDao lookAheadTest() {
        WorkProgressDao workProgressDao;
        if (this.lookAheadTest != null) {
            return this.lookAheadTest;
        }
        synchronized (this) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new WorkProgressDao_Impl(this);
            }
            workProgressDao = this.lookAheadTest;
        }
        return workProgressDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final PreferenceDao MyBillsEntityDataFactory() {
        PreferenceDao preferenceDao;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new PreferenceDao_Impl(this);
            }
            preferenceDao = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return preferenceDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RawWorkInfoDao PlaceComponentResult() {
        RawWorkInfoDao rawWorkInfoDao;
        if (this.getAuthRequestContext != null) {
            return this.getAuthRequestContext;
        }
        synchronized (this) {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new RawWorkInfoDao_Impl(this);
            }
            rawWorkInfoDao = this.getAuthRequestContext;
        }
        return rawWorkInfoDao;
    }
}
