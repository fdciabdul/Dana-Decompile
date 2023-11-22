package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class DatabaseConfiguration {
    public final Context BuiltInFictitiousFunctionClassFactory;
    public final Executor DatabaseTableConfigUtil;
    public final Intent GetContactSyncConfig;
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final List<AutoMigrationSpec> MyBillsEntityDataFactory;
    public final File NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Set<Integer> NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final List<RoomDatabase.Callback> PlaceComponentResult;
    public final SupportSQLiteOpenHelper.Factory PrepareContext;
    public final boolean getAuthRequestContext;
    public final RoomDatabase.MigrationContainer getErrorConfigVersion;
    public final RoomDatabase.PrepackagedDatabaseCallback initRecordTimeStamp;
    public final List<Object> isLayoutRequested;
    public final RoomDatabase.JournalMode lookAheadTest;
    public final String moveToNextValue;
    public final Executor newProxyInstance;
    public final Callable<InputStream> scheduleImpl;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<Object> list2, List<AutoMigrationSpec> list3) {
        this.PrepareContext = factory;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.getErrorConfigVersion = migrationContainer;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = z;
        this.lookAheadTest = journalMode;
        this.DatabaseTableConfigUtil = executor;
        this.newProxyInstance = executor2;
        this.GetContactSyncConfig = intent;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = intent != null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = set;
        this.moveToNextValue = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = file;
        this.scheduleImpl = callable;
        this.initRecordTimeStamp = prepackagedDatabaseCallback;
        this.isLayoutRequested = list2 == null ? Collections.emptyList() : list2;
        this.MyBillsEntityDataFactory = list3 == null ? Collections.emptyList() : list3;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        Set<Integer> set;
        return !((i > i2) && this.KClassImpl$Data$declaredNonStaticMembers$2) && this.NetworkUserEntityData$$ExternalSyntheticLambda7 && ((set = this.NetworkUserEntityData$$ExternalSyntheticLambda8) == null || !set.contains(Integer.valueOf(i)));
    }
}
