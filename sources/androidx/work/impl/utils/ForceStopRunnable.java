package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ForceStopRunnable implements Runnable {
    private static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("ForceStopRunnable");
    private static final long PlaceComponentResult = TimeUnit.DAYS.toMillis(3650);
    private final WorkManagerImpl KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;
    private int getAuthRequestContext = 0;

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = workManagerImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                while (true) {
                    WorkDatabasePathHelper.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                    Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "Performing cleanup operations.", new Throwable[0]);
                    try {
                        boolean BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
                        if (MyBillsEntityDataFactory()) {
                            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "Rescheduling Workers.", new Throwable[0]);
                            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory().MyBillsEntityDataFactory(new Preference("reschedule_needed"));
                        } else if (getAuthRequestContext()) {
                            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "Application was force-stopped, rescheduling.", new Throwable[0]);
                            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                        } else if (BuiltInFictitiousFunctionClassFactory2) {
                            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "Found unfinished work, scheduling it.", new Throwable[0]);
                            Schedulers.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                        }
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e) {
                        int i = this.getAuthRequestContext + 1;
                        this.getAuthRequestContext = i;
                        if (i >= 3) {
                            Logger authRequestContext = Logger.getAuthRequestContext();
                            String str = BuiltInFictitiousFunctionClassFactory;
                            authRequestContext.BuiltInFictitiousFunctionClassFactory(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                                Logger.getAuthRequestContext().PlaceComponentResult(str, "Routing exception to the specified exception handler", illegalStateException);
                            } else {
                                throw illegalStateException;
                            }
                        } else {
                            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Retrying after %s", Long.valueOf(i * 300)), e);
                            try {
                                Thread.sleep(this.getAuthRequestContext * 300);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private boolean getAuthRequestContext() {
        try {
            PendingIntent KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, BuildCompat.MyBillsEntityDataFactory() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.MyBillsEntityDataFactory.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i = 0; i < historicalProcessExitReasons.size(); i++) {
                        if (historicalProcessExitReasons.get(i).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e) {
            Logger.getAuthRequestContext().getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, "Ignoring exception", e);
            return true;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        boolean MyBillsEntityDataFactory = Build.VERSION.SDK_INT >= 23 ? SystemJobScheduler.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2) : false;
        WorkDatabase workDatabase = this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest;
        WorkSpecDao errorConfigVersion = workDatabase.getErrorConfigVersion();
        WorkProgressDao lookAheadTest = workDatabase.lookAheadTest();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> KClassImpl$Data$declaredNonStaticMembers$2 = errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
            boolean z = !KClassImpl$Data$declaredNonStaticMembers$2.isEmpty();
            if (z) {
                for (WorkSpec workSpec : KClassImpl$Data$declaredNonStaticMembers$2) {
                    errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, workSpec.getErrorConfigVersion);
                    errorConfigVersion.PlaceComponentResult(workSpec.getErrorConfigVersion, -1L);
                }
            }
            lookAheadTest.getAuthRequestContext();
            workDatabase.setTransactionSuccessful();
            return z || MyBillsEntityDataFactory;
        } finally {
            workDatabase.endTransaction();
        }
    }

    private boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Configuration configuration = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        if (TextUtils.isEmpty(configuration.PlaceComponentResult)) {
            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean PlaceComponentResult2 = ProcessUtils.PlaceComponentResult(this.MyBillsEntityDataFactory, configuration);
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Is default app process = %s", Boolean.valueOf(PlaceComponentResult2)), new Throwable[0]);
        return PlaceComponentResult2;
    }

    static void MyBillsEntityDataFactory(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(context, BuildCompat.MyBillsEntityDataFactory() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + PlaceComponentResult;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                alarmManager.set(0, currentTimeMillis, KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            Logger.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.MyBillsEntityDataFactory(context);
        }
    }

    private static PendingIntent KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return PendingIntent.getBroadcast(context, -1, intent, i);
    }
}
