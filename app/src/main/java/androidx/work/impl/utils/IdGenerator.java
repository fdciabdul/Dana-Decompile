package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* loaded from: classes3.dex */
public class IdGenerator {
    private final WorkDatabase getAuthRequestContext;

    public IdGenerator(WorkDatabase workDatabase) {
        this.getAuthRequestContext = workDatabase;
    }

    public final int MyBillsEntityDataFactory(int i, int i2) {
        synchronized (IdGenerator.class) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2("next_job_scheduler_id");
            if (KClassImpl$Data$declaredNonStaticMembers$2 < i || KClassImpl$Data$declaredNonStaticMembers$2 > i2) {
                this.getAuthRequestContext.MyBillsEntityDataFactory().MyBillsEntityDataFactory(new Preference("next_job_scheduler_id", i + 1));
            } else {
                i = KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        return i;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (IdGenerator.class) {
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2("next_alarm_manager_id");
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.getAuthRequestContext.beginTransaction();
        try {
            Long KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(str);
            int intValue = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.intValue() : 0;
            this.getAuthRequestContext.MyBillsEntityDataFactory().MyBillsEntityDataFactory(new Preference(str, intValue != Integer.MAX_VALUE ? intValue + 1 : 0));
            this.getAuthRequestContext.setTransactionSuccessful();
            return intValue;
        } finally {
            this.getAuthRequestContext.endTransaction();
        }
    }

    public static void PlaceComponentResult(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }
}
