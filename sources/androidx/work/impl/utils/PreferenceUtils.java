package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes3.dex */
public class PreferenceUtils {
    public final WorkDatabase getAuthRequestContext;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.getAuthRequestContext = workDatabase;
    }

    /* renamed from: androidx.work.impl.utils.PreferenceUtils$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Function<Long, Long> {
        @Override // androidx.arch.core.util.Function
        public /* synthetic */ Long getAuthRequestContext(Long l) {
            Long l2 = l;
            return Long.valueOf(l2 != null ? l2.longValue() : 0L);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Long KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("reschedule_needed");
        return KClassImpl$Data$declaredNonStaticMembers$2 != null && KClassImpl$Data$declaredNonStaticMembers$2.longValue() == 1;
    }

    public static void MyBillsEntityDataFactory(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }
}
