package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;

/* loaded from: classes3.dex */
class Alarms {
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("Alarms");

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.KClassImpl$Data$declaredNonStaticMembers$2(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    private static void getAuthRequestContext(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, CommandHandler.KClassImpl$Data$declaredNonStaticMembers$2(context, str), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, j, service);
            } else {
                alarmManager.set(0, j, service);
            }
        }
    }

    private Alarms() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, WorkManagerImpl workManagerImpl, String str) {
        SystemIdInfoDao authRequestContext = workManagerImpl.lookAheadTest.getAuthRequestContext();
        SystemIdInfo authRequestContext2 = authRequestContext.getAuthRequestContext(str);
        if (authRequestContext2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(context, str, authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            authRequestContext.MyBillsEntityDataFactory(str);
        }
    }

    public static void getAuthRequestContext(Context context, WorkManagerImpl workManagerImpl, String str, long j) {
        WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
        SystemIdInfoDao authRequestContext = workDatabase.getAuthRequestContext();
        SystemIdInfo authRequestContext2 = authRequestContext.getAuthRequestContext(str);
        if (authRequestContext2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(context, str, authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
            getAuthRequestContext(context, str, authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, j);
            return;
        }
        int BuiltInFictitiousFunctionClassFactory = new IdGenerator(workDatabase).BuiltInFictitiousFunctionClassFactory();
        authRequestContext.MyBillsEntityDataFactory(new SystemIdInfo(str, BuiltInFictitiousFunctionClassFactory));
        getAuthRequestContext(context, str, BuiltInFictitiousFunctionClassFactory, j);
    }
}
