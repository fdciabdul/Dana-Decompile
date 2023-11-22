package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RoomTrackingLiveData;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase BuiltInFictitiousFunctionClassFactory;
    private final SharedSQLiteStatement KClassImpl$Data$declaredNonStaticMembers$2;
    private final SharedSQLiteStatement MyBillsEntityDataFactory;
    private final SharedSQLiteStatement NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final EntityInsertionAdapter<WorkSpec> PlaceComponentResult;
    private final SharedSQLiteStatement getAuthRequestContext;
    private final SharedSQLiteStatement getErrorConfigVersion;
    private final SharedSQLiteStatement lookAheadTest;
    private final SharedSQLiteStatement moveToNextValue;
    private final SharedSQLiteStatement scheduleImpl;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.BuiltInFictitiousFunctionClassFactory = roomDatabase;
        this.PlaceComponentResult = new EntityInsertionAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                WorkSpec workSpec2 = workSpec;
                if (workSpec2.getErrorConfigVersion == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workSpec2.getErrorConfigVersion);
                }
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.getAuthRequestContext(workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda7));
                if (workSpec2.newProxyInstance == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, workSpec2.newProxyInstance);
                }
                if (workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
                byte[] authRequestContext = Data.getAuthRequestContext(workSpec2.moveToNextValue);
                if (authRequestContext == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, authRequestContext);
                }
                byte[] authRequestContext2 = Data.getAuthRequestContext(workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                if (authRequestContext2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, authRequestContext2);
                }
                supportSQLiteStatement.bindLong(7, workSpec2.lookAheadTest);
                supportSQLiteStatement.bindLong(8, workSpec2.initRecordTimeStamp);
                supportSQLiteStatement.bindLong(9, workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                supportSQLiteStatement.bindLong(10, workSpec2.isLayoutRequested);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(workSpec2.getAuthRequestContext));
                supportSQLiteStatement.bindLong(12, workSpec2.PlaceComponentResult);
                supportSQLiteStatement.bindLong(13, workSpec2.NetworkUserEntityData$$ExternalSyntheticLambda8);
                supportSQLiteStatement.bindLong(14, workSpec2.GetContactSyncConfig);
                supportSQLiteStatement.bindLong(15, workSpec2.PrepareContext);
                supportSQLiteStatement.bindLong(16, workSpec2.scheduleImpl ? 1L : 0L);
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(workSpec2.DatabaseTableConfigUtil));
                Constraints constraints = workSpec2.MyBillsEntityDataFactory;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(18, WorkTypeConverters.KClassImpl$Data$declaredNonStaticMembers$2(constraints.MyBillsEntityDataFactory));
                    supportSQLiteStatement.bindLong(19, constraints.MyBillsEntityDataFactory() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(20, constraints.getAuthRequestContext() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(21, constraints.BuiltInFictitiousFunctionClassFactory() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(22, constraints.PlaceComponentResult() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(23, constraints.scheduleImpl);
                    supportSQLiteStatement.bindLong(24, constraints.moveToNextValue);
                    byte[] MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(constraints.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (MyBillsEntityDataFactory == null) {
                        supportSQLiteStatement.bindNull(25);
                        return;
                    } else {
                        supportSQLiteStatement.bindBlob(25, MyBillsEntityDataFactory);
                        return;
                    }
                }
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
                supportSQLiteStatement.bindNull(22);
                supportSQLiteStatement.bindNull(23);
                supportSQLiteStatement.bindNull(24);
                supportSQLiteStatement.bindNull(25);
            }
        };
        this.getAuthRequestContext = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.getErrorConfigVersion = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.scheduleImpl = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.MyBillsEntityDataFactory = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.lookAheadTest = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.moveToNextValue = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void BuiltInFictitiousFunctionClassFactory(WorkSpec workSpec) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            this.PlaceComponentResult.insert((EntityInsertionAdapter<WorkSpec>) workSpec);
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void getAuthRequestContext(String str) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.getAuthRequestContext.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.getAuthRequestContext.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void getAuthRequestContext(String str, Data data) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.getErrorConfigVersion.acquire();
        byte[] authRequestContext = Data.getAuthRequestContext(data);
        if (authRequestContext == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, authRequestContext);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.getErrorConfigVersion.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void getAuthRequestContext(String str, long j) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.scheduleImpl.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.scheduleImpl.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.MyBillsEntityDataFactory.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.MyBillsEntityDataFactory.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int initRecordTimeStamp(String str) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.lookAheadTest.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.lookAheadTest.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int PlaceComponentResult(String str, long j) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.KClassImpl$Data$declaredNonStaticMembers$2.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.KClassImpl$Data$declaredNonStaticMembers$2.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int lookAheadTest() {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.NetworkUserEntityData$$ExternalSyntheticLambda0.acquire();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void moveToNextValue() {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.moveToNextValue.acquire();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.moveToNextValue.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final WorkSpec moveToNextValue(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        WorkSpec workSpec;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            authRequestContext15.bindNull(1);
        } else {
            authRequestContext15.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                Constraints constraints = new Constraints();
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext14));
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext16);
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext17);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext18);
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext19);
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext20));
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext21);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext22);
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext23);
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext24);
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext25) != 0;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext26));
                workSpec.MyBillsEntityDataFactory = constraints;
            } else {
                workSpec = null;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return workSpec;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec.IdAndState> getErrorConfigVersion(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                idAndState.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$10  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass10 implements Callable<List<String>> {
        final /* synthetic */ RoomSQLiteQuery KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ WorkSpecDao_Impl MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public List<String> call() throws Exception {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.beginTransaction();
            try {
                Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, false);
                try {
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
                    }
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                    return arrayList;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$2.close();
                }
            } finally {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.endTransaction();
            }
        }

        protected void finalize() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final WorkInfo.State PlaceComponentResult(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(0)) : null;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final WorkSpec.WorkInfoPojo scheduleImpl(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, true);
            try {
                int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                BuiltInFictitiousFunctionClassFactory(arrayMap);
                MyBillsEntityDataFactory(arrayMap2);
                WorkSpec.WorkInfoPojo workInfoPojo = null;
                if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                    ArrayList<String> arrayList = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2)) : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo2 = new WorkSpec.WorkInfoPojo();
                    workInfoPojo2.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    workInfoPojo2.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                    workInfoPojo2.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext4));
                    workInfoPojo2.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5);
                    workInfoPojo2.scheduleImpl = arrayList;
                    workInfoPojo2.getAuthRequestContext = arrayList2;
                    workInfoPojo = workInfoPojo2;
                }
                this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                return workInfoPojo;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                authRequestContext.MyBillsEntityDataFactory();
            }
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec.WorkInfoPojo> MyBillsEntityDataFactory(List<String> list) {
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                authRequestContext.bindNull(i);
            } else {
                authRequestContext.bindString(i, str);
            }
            i++;
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, true);
            try {
                int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "id");
                int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "state");
                int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2)) {
                        String string = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2)) {
                        String string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$22.moveToPosition(-1);
                BuiltInFictitiousFunctionClassFactory(arrayMap);
                MyBillsEntityDataFactory(arrayMap2);
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    ArrayList<String> arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                    workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext3));
                    workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22.getBlob(authRequestContext4));
                    workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext5);
                    workInfoPojo.scheduleImpl = arrayList2;
                    workInfoPojo.getAuthRequestContext = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                return arrayList;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                authRequestContext.MyBillsEntityDataFactory();
            }
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$11  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass11 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        final /* synthetic */ WorkSpecDao_Impl KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ RoomSQLiteQuery MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.beginTransaction();
            try {
                Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, true);
                try {
                    int authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                    int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                    int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                    int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext)) {
                            String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext)) {
                            String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(arrayMap);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(arrayMap2);
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        ArrayList arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? (ArrayList) arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : (ArrayList) arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                        workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                        workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext3));
                        workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4);
                        workInfoPojo.scheduleImpl = arrayList2;
                        workInfoPojo.getAuthRequestContext = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                    return arrayList;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$2.close();
                }
            } finally {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.endTransaction();
            }
        }

        protected void finalize() {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec.WorkInfoPojo> lookAheadTest(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, true);
            try {
                int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                BuiltInFictitiousFunctionClassFactory(arrayMap);
                MyBillsEntityDataFactory(arrayMap2);
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    ArrayList<String> arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                    workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext4));
                    workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5);
                    workInfoPojo.scheduleImpl = arrayList2;
                    workInfoPojo.getAuthRequestContext = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                return arrayList;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                authRequestContext.MyBillsEntityDataFactory();
            }
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final LiveData<List<WorkSpec.WorkInfoPojo>> DatabaseTableConfigUtil(String str) {
        final RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        InvalidationTracker invalidationTracker = this.BuiltInFictitiousFunctionClassFactory.getInvalidationTracker();
        Callable<List<WorkSpec.WorkInfoPojo>> callable = new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                try {
                    Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(WorkSpecDao_Impl.this.BuiltInFictitiousFunctionClassFactory, authRequestContext, true);
                    try {
                        int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                        int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                        int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                        int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                        ArrayMap arrayMap = new ArrayMap();
                        ArrayMap arrayMap2 = new ArrayMap();
                        while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                            if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                                if (((ArrayList) arrayMap.get(string)) == null) {
                                    arrayMap.put(string, new ArrayList());
                                }
                            }
                            if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                                if (((ArrayList) arrayMap2.get(string2)) == null) {
                                    arrayMap2.put(string2, new ArrayList());
                                }
                            }
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                        WorkSpecDao_Impl.this.BuiltInFictitiousFunctionClassFactory(arrayMap);
                        WorkSpecDao_Impl.this.MyBillsEntityDataFactory(arrayMap2);
                        ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                        while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                            ArrayList arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? (ArrayList) arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2)) : null;
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            ArrayList arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : (ArrayList) arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                            workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                            workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                            workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext4));
                            workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5);
                            workInfoPojo.scheduleImpl = arrayList2;
                            workInfoPojo.getAuthRequestContext = arrayList3;
                            arrayList.add(workInfoPojo);
                        }
                        WorkSpecDao_Impl.this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        KClassImpl$Data$declaredNonStaticMembers$2.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.BuiltInFictitiousFunctionClassFactory.endTransaction();
                }
            }

            protected void finalize() {
                authRequestContext.MyBillsEntityDataFactory();
            }
        };
        InvalidationLiveDataContainer invalidationLiveDataContainer = invalidationTracker.BuiltInFictitiousFunctionClassFactory;
        String[] BuiltInFictitiousFunctionClassFactory = invalidationTracker.BuiltInFictitiousFunctionClassFactory(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"});
        for (String str2 : BuiltInFictitiousFunctionClassFactory) {
            if (!invalidationTracker.initRecordTimeStamp.containsKey(str2.toLowerCase(Locale.US))) {
                StringBuilder sb = new StringBuilder();
                sb.append("There is no table with name ");
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return new RoomTrackingLiveData(invalidationLiveDataContainer.PlaceComponentResult, invalidationLiveDataContainer, callable, BuiltInFictitiousFunctionClassFactory);
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec.WorkInfoPojo> NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, true);
            try {
                int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2)) {
                        String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                BuiltInFictitiousFunctionClassFactory(arrayMap);
                MyBillsEntityDataFactory(arrayMap2);
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    ArrayList<String> arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                    workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext4));
                    workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5);
                    workInfoPojo.scheduleImpl = arrayList2;
                    workInfoPojo.getAuthRequestContext = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                return arrayList;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                authRequestContext.MyBillsEntityDataFactory();
            }
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$13  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass13 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        final /* synthetic */ RoomSQLiteQuery MyBillsEntityDataFactory;
        final /* synthetic */ WorkSpecDao_Impl PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.beginTransaction();
            try {
                Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, true);
                try {
                    int authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                    int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                    int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                    int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext)) {
                            String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext)) {
                            String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(arrayMap);
                    this.PlaceComponentResult.MyBillsEntityDataFactory(arrayMap2);
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        ArrayList arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? (ArrayList) arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : (ArrayList) arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                        workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                        workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext3));
                        workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4);
                        workInfoPojo.scheduleImpl = arrayList2;
                        workInfoPojo.getAuthRequestContext = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                    return arrayList;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$2.close();
                }
            } finally {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.endTransaction();
            }
        }

        protected void finalize() {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<Data> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(0)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<String> BuiltInFictitiousFunctionClassFactory(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<String> MyBillsEntityDataFactory(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<String> MyBillsEntityDataFactory() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final boolean getAuthRequestContext() {
        boolean z = false;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$14  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass14 implements Callable<Long> {
        final /* synthetic */ RoomSQLiteQuery PlaceComponentResult;
        final /* synthetic */ WorkSpecDao_Impl getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public Long call() throws Exception {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, false);
            try {
                Long l = null;
                if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() && !KClassImpl$Data$declaredNonStaticMembers$2.isNull(0)) {
                    l = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(0));
                }
                return l;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
            }
        }

        protected void finalize() {
            this.PlaceComponentResult.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec> BuiltInFictitiousFunctionClassFactory(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        authRequestContext15.bindLong(1, i);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            int i2 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                int i3 = authRequestContext9;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                int i4 = authRequestContext11;
                Constraints constraints = new Constraints();
                int i5 = authRequestContext;
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                int i6 = authRequestContext2;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                int i7 = i2;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(i7));
                int i8 = authRequestContext12;
                i2 = i7;
                int i9 = authRequestContext16;
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i9);
                authRequestContext16 = i9;
                int i10 = authRequestContext3;
                int i11 = authRequestContext17;
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i11);
                authRequestContext17 = i11;
                int i12 = authRequestContext18;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i12);
                int i13 = authRequestContext19;
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13);
                int i14 = authRequestContext20;
                authRequestContext19 = i13;
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i14));
                authRequestContext18 = i12;
                int i15 = authRequestContext21;
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i15);
                authRequestContext21 = i15;
                int i16 = authRequestContext22;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i16);
                authRequestContext22 = i16;
                int i17 = authRequestContext23;
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i17);
                authRequestContext23 = i17;
                int i18 = authRequestContext24;
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i18);
                int i19 = authRequestContext25;
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i19) != 0;
                int i20 = authRequestContext26;
                authRequestContext25 = i19;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i20));
                workSpec.MyBillsEntityDataFactory = constraints;
                arrayList.add(workSpec);
                authRequestContext26 = i20;
                authRequestContext24 = i18;
                authRequestContext12 = i8;
                authRequestContext9 = i3;
                authRequestContext11 = i4;
                authRequestContext2 = i6;
                authRequestContext = i5;
                authRequestContext20 = i14;
                authRequestContext3 = i10;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec> PlaceComponentResult() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        authRequestContext15.bindLong(1, 200L);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            int i = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                int i2 = authRequestContext9;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                int i3 = authRequestContext11;
                Constraints constraints = new Constraints();
                int i4 = authRequestContext;
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                int i5 = authRequestContext2;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                int i6 = i;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(i6));
                int i7 = authRequestContext12;
                i = i6;
                int i8 = authRequestContext16;
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i8);
                authRequestContext16 = i8;
                int i9 = authRequestContext3;
                int i10 = authRequestContext17;
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i10);
                authRequestContext17 = i10;
                int i11 = authRequestContext18;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i11);
                int i12 = authRequestContext19;
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i12);
                int i13 = authRequestContext20;
                authRequestContext19 = i12;
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13));
                authRequestContext18 = i11;
                int i14 = authRequestContext21;
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i14);
                authRequestContext21 = i14;
                int i15 = authRequestContext22;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i15);
                authRequestContext22 = i15;
                int i16 = authRequestContext23;
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i16);
                authRequestContext23 = i16;
                int i17 = authRequestContext24;
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i17);
                int i18 = authRequestContext25;
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i18) != 0;
                int i19 = authRequestContext26;
                authRequestContext25 = i18;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i19));
                workSpec.MyBillsEntityDataFactory = constraints;
                arrayList.add(workSpec);
                authRequestContext26 = i19;
                authRequestContext24 = i17;
                authRequestContext12 = i7;
                authRequestContext9 = i2;
                authRequestContext11 = i3;
                authRequestContext2 = i5;
                authRequestContext = i4;
                authRequestContext20 = i13;
                authRequestContext3 = i9;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec> BuiltInFictitiousFunctionClassFactory() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            int i = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                int i2 = authRequestContext9;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                int i3 = authRequestContext11;
                Constraints constraints = new Constraints();
                int i4 = authRequestContext;
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                int i5 = authRequestContext2;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                int i6 = i;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(i6));
                int i7 = authRequestContext13;
                i = i6;
                int i8 = authRequestContext16;
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i8);
                authRequestContext16 = i8;
                int i9 = authRequestContext3;
                int i10 = authRequestContext17;
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i10);
                authRequestContext17 = i10;
                int i11 = authRequestContext18;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i11);
                int i12 = authRequestContext19;
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i12);
                int i13 = authRequestContext20;
                authRequestContext19 = i12;
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13));
                authRequestContext18 = i11;
                int i14 = authRequestContext21;
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i14);
                authRequestContext21 = i14;
                int i15 = authRequestContext22;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i15);
                authRequestContext22 = i15;
                int i16 = authRequestContext23;
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i16);
                authRequestContext23 = i16;
                int i17 = authRequestContext24;
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i17);
                int i18 = authRequestContext25;
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i18) != 0;
                int i19 = authRequestContext26;
                authRequestContext25 = i18;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i19));
                workSpec.MyBillsEntityDataFactory = constraints;
                arrayList.add(workSpec);
                authRequestContext26 = i19;
                authRequestContext24 = i17;
                authRequestContext13 = i7;
                authRequestContext9 = i2;
                authRequestContext11 = i3;
                authRequestContext = i4;
                authRequestContext2 = i5;
                authRequestContext20 = i13;
                authRequestContext3 = i9;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec> KClassImpl$Data$declaredNonStaticMembers$2() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            int i = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                int i2 = authRequestContext9;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                int i3 = authRequestContext11;
                Constraints constraints = new Constraints();
                int i4 = authRequestContext;
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                int i5 = authRequestContext2;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                int i6 = i;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(i6));
                int i7 = authRequestContext13;
                i = i6;
                int i8 = authRequestContext16;
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i8);
                authRequestContext16 = i8;
                int i9 = authRequestContext3;
                int i10 = authRequestContext17;
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i10);
                authRequestContext17 = i10;
                int i11 = authRequestContext18;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i11);
                int i12 = authRequestContext19;
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i12);
                int i13 = authRequestContext20;
                authRequestContext19 = i12;
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13));
                authRequestContext18 = i11;
                int i14 = authRequestContext21;
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i14);
                authRequestContext21 = i14;
                int i15 = authRequestContext22;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i15);
                authRequestContext22 = i15;
                int i16 = authRequestContext23;
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i16);
                authRequestContext23 = i16;
                int i17 = authRequestContext24;
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i17);
                int i18 = authRequestContext25;
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i18) != 0;
                int i19 = authRequestContext26;
                authRequestContext25 = i18;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i19));
                workSpec.MyBillsEntityDataFactory = constraints;
                arrayList.add(workSpec);
                authRequestContext26 = i19;
                authRequestContext24 = i17;
                authRequestContext13 = i7;
                authRequestContext9 = i2;
                authRequestContext11 = i3;
                authRequestContext = i4;
                authRequestContext2 = i5;
                authRequestContext20 = i13;
                authRequestContext3 = i9;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final List<WorkSpec> KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        authRequestContext15.bindLong(1, j);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "required_network_type");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_charging");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_device_idle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_battery_not_low");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "requires_storage_not_low");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_content_update_delay");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "trigger_max_content_delay");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content_uri_triggers");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "worker_class_name");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input_merger_class_name");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "input");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "initial_delay");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "interval_duration");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "flex_duration");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_policy");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backoff_delay_duration");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "period_start_time");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "minimum_retention_duration");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "schedule_requested_at");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "run_in_foreground");
            int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "out_of_quota_policy");
            int i = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                int i2 = authRequestContext9;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                int i3 = authRequestContext11;
                Constraints constraints = new Constraints();
                int i4 = authRequestContext;
                constraints.MyBillsEntityDataFactory = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext));
                constraints.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2) != 0;
                constraints.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3) != 0;
                constraints.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4) != 0;
                constraints.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) != 0;
                int i5 = authRequestContext2;
                constraints.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                constraints.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                constraints.KClassImpl$Data$declaredNonStaticMembers$2 = WorkTypeConverters.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext10));
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                workSpec.moveToNextValue = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(authRequestContext13));
                int i6 = i;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(i6));
                int i7 = authRequestContext16;
                int i8 = authRequestContext12;
                i = i6;
                workSpec.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i7);
                int i9 = authRequestContext3;
                int i10 = authRequestContext17;
                workSpec.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i10);
                authRequestContext17 = i10;
                int i11 = authRequestContext18;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i11);
                int i12 = authRequestContext19;
                workSpec.isLayoutRequested = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i12);
                int i13 = authRequestContext20;
                authRequestContext19 = i12;
                workSpec.getAuthRequestContext = WorkTypeConverters.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13));
                authRequestContext18 = i11;
                int i14 = authRequestContext21;
                workSpec.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i14);
                authRequestContext21 = i14;
                int i15 = authRequestContext22;
                workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i15);
                authRequestContext22 = i15;
                int i16 = authRequestContext23;
                workSpec.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i16);
                authRequestContext23 = i16;
                int i17 = authRequestContext24;
                workSpec.PrepareContext = KClassImpl$Data$declaredNonStaticMembers$2.getLong(i17);
                int i18 = authRequestContext25;
                workSpec.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i18) != 0;
                int i19 = authRequestContext26;
                authRequestContext25 = i18;
                workSpec.DatabaseTableConfigUtil = WorkTypeConverters.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i19));
                workSpec.MyBillsEntityDataFactory = constraints;
                arrayList.add(workSpec);
                authRequestContext12 = i8;
                authRequestContext26 = i19;
                authRequestContext24 = i17;
                authRequestContext16 = i7;
                authRequestContext9 = i2;
                authRequestContext11 = i3;
                authRequestContext2 = i5;
                authRequestContext = i4;
                authRequestContext20 = i13;
                authRequestContext3 = i9;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State state, String... strArr) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("UPDATE workspec SET state=");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" WHERE id IN (");
        int length = strArr.length;
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, 1);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.BuiltInFictitiousFunctionClassFactory.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        compileStatement.bindLong(1, WorkTypeConverters.getAuthRequestContext(state));
        int length2 = strArr.length;
        for (int i = 0; i <= 0; i++) {
            String str = strArr[0];
            if (str == null) {
                compileStatement.bindNull(2);
            } else {
                compileStatement.bindString(2, str);
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList<String> arrayList;
        int i;
        while (true) {
            Set<String> keySet = arrayMap.keySet();
            if (keySet.isEmpty()) {
                return;
            }
            int i2 = 1;
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                while (true) {
                    i = 0;
                    while (i3 < size) {
                        int i4 = i3 << 1;
                        arrayMap2.put((String) arrayMap.moveToNextValue[i4], (ArrayList) arrayMap.moveToNextValue[i4 + 1]);
                        i3++;
                        i++;
                        if (i == 999) {
                            break;
                        }
                    }
                    BuiltInFictitiousFunctionClassFactory(arrayMap2);
                    arrayMap2 = new ArrayMap<>(999);
                }
                if (i <= 0) {
                    return;
                }
                arrayMap = arrayMap2;
            } else {
                StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
                int size2 = keySet.size();
                StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
                KClassImpl$Data$declaredNonStaticMembers$2.append(")");
                RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size2 + 0);
                for (String str : keySet) {
                    if (str == null) {
                        authRequestContext.bindNull(i2);
                    } else {
                        authRequestContext.bindString(i2, str);
                    }
                    i2++;
                }
                Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
                try {
                    int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, "work_spec_id");
                    if (KClassImpl$Data$declaredNonStaticMembers$23 == -1) {
                        return;
                    }
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(KClassImpl$Data$declaredNonStaticMembers$23) && (arrayList = arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(KClassImpl$Data$declaredNonStaticMembers$23))) != null) {
                            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$22.getString(0));
                        }
                    }
                    return;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList<Data> arrayList;
        int i;
        while (true) {
            Set<String> keySet = arrayMap.keySet();
            if (keySet.isEmpty()) {
                return;
            }
            int i2 = 1;
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                while (true) {
                    i = 0;
                    while (i3 < size) {
                        int i4 = i3 << 1;
                        arrayMap2.put((String) arrayMap.moveToNextValue[i4], (ArrayList) arrayMap.moveToNextValue[i4 + 1]);
                        i3++;
                        i++;
                        if (i == 999) {
                            break;
                        }
                    }
                    MyBillsEntityDataFactory(arrayMap2);
                    arrayMap2 = new ArrayMap<>(999);
                }
                if (i <= 0) {
                    return;
                }
                arrayMap = arrayMap2;
            } else {
                StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
                int size2 = keySet.size();
                StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
                KClassImpl$Data$declaredNonStaticMembers$2.append(")");
                RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size2 + 0);
                for (String str : keySet) {
                    if (str == null) {
                        authRequestContext.bindNull(i2);
                    } else {
                        authRequestContext.bindString(i2, str);
                    }
                    i2++;
                }
                Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext, false);
                try {
                    int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, "work_spec_id");
                    if (KClassImpl$Data$declaredNonStaticMembers$23 == -1) {
                        return;
                    }
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(KClassImpl$Data$declaredNonStaticMembers$23) && (arrayList = arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(KClassImpl$Data$declaredNonStaticMembers$23))) != null) {
                            arrayList.add(Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22.getBlob(0)));
                        }
                    }
                    return;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                }
            }
        }
    }
}
