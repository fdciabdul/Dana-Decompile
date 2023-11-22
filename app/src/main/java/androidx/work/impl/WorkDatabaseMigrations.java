package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PreferenceUtils;

/* loaded from: classes3.dex */
public class WorkDatabaseMigrations {
    public static Migration BuiltInFictitiousFunctionClassFactory = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.1
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS alarmInfo");
            supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };
    public static Migration getAuthRequestContext = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.2
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 23) {
                supportSQLiteDatabase.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };
    public static Migration PlaceComponentResult = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.3
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };
    public static Migration KClassImpl$Data$declaredNonStaticMembers$2 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.4
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };
    public static Migration NetworkUserEntityData$$ExternalSyntheticLambda0 = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.5
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };
    public static Migration getErrorConfigVersion = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.6
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };
    public static Migration MyBillsEntityDataFactory = new Migration() { // from class: androidx.work.impl.WorkDatabaseMigrations.7
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    };

    private WorkDatabaseMigrations() {
    }

    /* loaded from: classes3.dex */
    public static class RescheduleMigration extends Migration {
        final Context PlaceComponentResult;

        public RescheduleMigration(Context context, int i, int i2) {
            super(i, i2);
            this.PlaceComponentResult = context;
        }

        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (this.MyBillsEntityDataFactory >= 10) {
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.PlaceComponentResult.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class WorkMigration9To10 extends Migration {
        final Context KClassImpl$Data$declaredNonStaticMembers$2;

        public WorkMigration9To10(Context context) {
            super(9, 10);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        }

        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            PreferenceUtils.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, supportSQLiteDatabase);
            IdGenerator.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, supportSQLiteDatabase);
        }
    }
}
