package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class WorkDatabase extends RoomDatabase {
    private static final long getAuthRequestContext = TimeUnit.DAYS.toMillis(1);

    public abstract DependencyDao KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract PreferenceDao MyBillsEntityDataFactory();

    public abstract WorkNameDao NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract RawWorkInfoDao PlaceComponentResult();

    public abstract SystemIdInfoDao getAuthRequestContext();

    public abstract WorkSpecDao getErrorConfigVersion();

    public abstract WorkProgressDao lookAheadTest();

    public abstract WorkTagDao scheduleImpl();

    public static WorkDatabase getAuthRequestContext(final Context context, Executor executor, boolean z) {
        RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$2;
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2 = Room.KClassImpl$Data$declaredNonStaticMembers$2(context, WorkDatabase.class);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = true;
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = Room.KClassImpl$Data$declaredNonStaticMembers$2(context, WorkDatabase.class, WorkDatabasePathHelper.PlaceComponentResult());
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new SupportSQLiteOpenHelper.Factory() { // from class: androidx.work.impl.WorkDatabase.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
                    SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(context);
                    BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = configuration.PlaceComponentResult;
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = configuration.KClassImpl$Data$declaredNonStaticMembers$2;
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = true;
                    return new FrameworkSQLiteOpenHelperFactory().create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
                }
            };
        }
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = executor;
        RoomDatabase.Callback callback = new RoomDatabase.Callback() { // from class: androidx.work.impl.WorkDatabase.2
            @Override // androidx.room.RoomDatabase.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                supportSQLiteDatabase.beginTransaction();
                try {
                    supportSQLiteDatabase.execSQL(WorkDatabase.BuiltInFictitiousFunctionClassFactory());
                    supportSQLiteDatabase.setTransactionSuccessful();
                } finally {
                    supportSQLiteDatabase.endTransaction();
                }
            }
        };
        if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new ArrayList<>();
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.add(callback);
        RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3)).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6)).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.NetworkUserEntityData$$ExternalSyntheticLambda0).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.getErrorConfigVersion).KClassImpl$Data$declaredNonStaticMembers$2(new WorkDatabaseMigrations.WorkMigration9To10(context)).KClassImpl$Data$declaredNonStaticMembers$2(new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11)).KClassImpl$Data$declaredNonStaticMembers$2(WorkDatabaseMigrations.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue = false;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = true;
        return (WorkDatabase) KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory();
    }

    static String BuiltInFictitiousFunctionClassFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        sb.append(System.currentTimeMillis() - getAuthRequestContext);
        sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return sb.toString();
    }
}
