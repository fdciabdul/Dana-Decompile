package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class DiagnosticsWorker extends Worker {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        WorkDatabase workDatabase = WorkManagerImpl.PlaceComponentResult(getApplicationContext()).lookAheadTest;
        WorkSpecDao errorConfigVersion = workDatabase.getErrorConfigVersion();
        WorkNameDao NetworkUserEntityData$$ExternalSyntheticLambda0 = workDatabase.NetworkUserEntityData$$ExternalSyntheticLambda0();
        WorkTagDao scheduleImpl = workDatabase.scheduleImpl();
        SystemIdInfoDao authRequestContext = workDatabase.getAuthRequestContext();
        List<WorkSpec> KClassImpl$Data$declaredNonStaticMembers$2 = errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<WorkSpec> KClassImpl$Data$declaredNonStaticMembers$22 = errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
        List<WorkSpec> PlaceComponentResult2 = errorConfigVersion.PlaceComponentResult();
        if (!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            Logger authRequestContext2 = Logger.getAuthRequestContext();
            String str = PlaceComponentResult;
            authRequestContext2.MyBillsEntityDataFactory(str, "Recently completed work:\n\n", new Throwable[0]);
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(str, BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl, authRequestContext, KClassImpl$Data$declaredNonStaticMembers$2), new Throwable[0]);
        }
        if (!KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
            Logger authRequestContext3 = Logger.getAuthRequestContext();
            String str2 = PlaceComponentResult;
            authRequestContext3.MyBillsEntityDataFactory(str2, "Running work:\n\n", new Throwable[0]);
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(str2, BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl, authRequestContext, KClassImpl$Data$declaredNonStaticMembers$22), new Throwable[0]);
        }
        if (!PlaceComponentResult2.isEmpty()) {
            Logger authRequestContext4 = Logger.getAuthRequestContext();
            String str3 = PlaceComponentResult;
            authRequestContext4.MyBillsEntityDataFactory(str3, "Enqueued work:\n\n", new Throwable[0]);
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(str3, BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl, authRequestContext, PlaceComponentResult2), new Throwable[0]);
        }
        return ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory();
    }

    private static String BuiltInFictitiousFunctionClassFactory(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (WorkSpec workSpec : list) {
            Integer num = null;
            SystemIdInfo authRequestContext = systemIdInfoDao.getAuthRequestContext(workSpec.getErrorConfigVersion);
            if (authRequestContext != null) {
                num = Integer.valueOf(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.getErrorConfigVersion, workSpec.newProxyInstance, num, workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7.name(), TextUtils.join(",", workNameDao.getAuthRequestContext(workSpec.getErrorConfigVersion)), TextUtils.join(",", workTagDao.BuiltInFictitiousFunctionClassFactory(workSpec.getErrorConfigVersion))));
        }
        return sb.toString();
    }
}
