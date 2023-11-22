package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Schedulers {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {104, -34, -42, -1, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 52;
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("Schedulers");

    public static void PlaceComponentResult(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> list) {
        int i;
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao errorConfigVersion = workDatabase.getErrorConfigVersion();
        workDatabase.beginTransaction();
        try {
            if (Build.VERSION.SDK_INT == 23) {
                i = configuration.getErrorConfigVersion / 2;
            } else {
                i = configuration.getErrorConfigVersion;
            }
            List<WorkSpec> BuiltInFictitiousFunctionClassFactory2 = errorConfigVersion.BuiltInFictitiousFunctionClassFactory(i);
            List<WorkSpec> PlaceComponentResult = errorConfigVersion.PlaceComponentResult();
            if (BuiltInFictitiousFunctionClassFactory2.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<WorkSpec> it = BuiltInFictitiousFunctionClassFactory2.iterator();
                while (it.hasNext()) {
                    errorConfigVersion.PlaceComponentResult(it.next().getErrorConfigVersion, currentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (BuiltInFictitiousFunctionClassFactory2.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) BuiltInFictitiousFunctionClassFactory2.toArray(new WorkSpec[BuiltInFictitiousFunctionClassFactory2.size()]);
                for (Scheduler scheduler : list) {
                    if (scheduler.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        scheduler.KClassImpl$Data$declaredNonStaticMembers$2(workSpecArr);
                    }
                }
            }
            if (PlaceComponentResult.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) PlaceComponentResult.toArray(new WorkSpec[PlaceComponentResult.size()]);
                for (Scheduler scheduler2 : list) {
                    if (!scheduler2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        scheduler2.KClassImpl$Data$declaredNonStaticMembers$2(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    public static Scheduler PlaceComponentResult(Context context, WorkManagerImpl workManagerImpl) {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workManagerImpl);
            PackageManagerHelper.PlaceComponentResult(context, SystemJobService.class, true);
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return systemJobScheduler;
        }
        Scheduler authRequestContext = getAuthRequestContext(context);
        if (authRequestContext == null) {
            SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
            PackageManagerHelper.PlaceComponentResult(context, SystemAlarmService.class, true);
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, "Created SystemAlarmScheduler", new Throwable[0]);
            return systemAlarmScheduler;
        }
        return authRequestContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0042 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:22:0x0004, B:26:0x003a, B:28:0x0042, B:30:0x0071), top: B:36:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:22:0x0004, B:26:0x003a, B:28:0x0042, B:30:0x0071), top: B:36:0x0004 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0073 -> B:32:0x0077). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.work.impl.Scheduler getAuthRequestContext(android.content.Context r14) {
        /*
            java.lang.String r0 = "androidx.work.impl.background.gcm.GcmScheduler"
            r1 = 0
            r2 = 1
            java.lang.Class r3 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L81
            byte[] r5 = androidx.work.impl.Schedulers.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L81
            r6 = 3
            r5 = r5[r6]     // Catch: java.lang.Throwable -> L81
            int r5 = r5 + r2
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> L81
            byte[] r7 = androidx.work.impl.Schedulers.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L81
            r6 = r7[r6]     // Catch: java.lang.Throwable -> L81
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L81
            int r7 = r6 + 1
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L81
            int r7 = r7 * 4
            int r7 = r7 + 97
            int r5 = r5 * 4
            int r5 = 23 - r5
            byte[] r8 = androidx.work.impl.Schedulers.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L81
            int r6 = r6 + 4
            byte[] r9 = new byte[r5]     // Catch: java.lang.Throwable -> L81
            int r5 = r5 + (-1)
            if (r8 != 0) goto L33
            r11 = r7
            r10 = r9
            r12 = 0
            r7 = r5
            r9 = r8
            r5 = r4
            r8 = r6
            goto L77
        L33:
            r10 = r9
            r11 = 0
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
        L3a:
            byte r12 = (byte) r8     // Catch: java.lang.Throwable -> L81
            r10[r11] = r12     // Catch: java.lang.Throwable -> L81
            int r7 = r7 + r2
            int r12 = r11 + 1
            if (r11 != r6) goto L71
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L81
            r6.<init>(r10, r1)     // Catch: java.lang.Throwable -> L81
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> L81
            r4[r1] = r6     // Catch: java.lang.Throwable -> L81
            java.lang.reflect.Constructor r3 = r3.getConstructor(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L81
            r4[r1] = r14     // Catch: java.lang.Throwable -> L81
            java.lang.Object r14 = r3.newInstance(r4)     // Catch: java.lang.Throwable -> L81
            androidx.work.impl.Scheduler r14 = (androidx.work.impl.Scheduler) r14     // Catch: java.lang.Throwable -> L81
            androidx.work.Logger r3 = androidx.work.Logger.getAuthRequestContext()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = androidx.work.impl.Schedulers.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L81
            r5[r1] = r0     // Catch: java.lang.Throwable -> L81
            java.lang.String r0 = "Created %s"
            java.lang.String r0 = java.lang.String.format(r0, r5)     // Catch: java.lang.Throwable -> L81
            java.lang.Throwable[] r5 = new java.lang.Throwable[r1]     // Catch: java.lang.Throwable -> L81
            r3.PlaceComponentResult(r4, r0, r5)     // Catch: java.lang.Throwable -> L81
            return r14
        L71:
            r11 = r9[r7]     // Catch: java.lang.Throwable -> L81
            r13 = r7
            r7 = r6
            r6 = r8
            r8 = r13
        L77:
            int r11 = -r11
            int r6 = r6 + r11
            int r6 = r6 + (-8)
            r11 = r12
            r13 = r8
            r8 = r6
            r6 = r7
            r7 = r13
            goto L3a
        L81:
            r14 = move-exception
            androidx.work.Logger r0 = androidx.work.Logger.getAuthRequestContext()
            java.lang.String r3 = androidx.work.impl.Schedulers.MyBillsEntityDataFactory
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]
            r2[r1] = r14
            java.lang.String r14 = "Unable to create GCM Scheduler"
            r0.PlaceComponentResult(r3, r14, r2)
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.Schedulers.getAuthRequestContext(android.content.Context):androidx.work.impl.Scheduler");
    }

    private Schedulers() {
    }
}
