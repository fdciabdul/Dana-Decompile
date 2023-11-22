package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SystemJobScheduler implements Scheduler {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("SystemJobScheduler");
    private final JobScheduler BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;
    private final WorkManagerImpl PlaceComponentResult;
    private final SystemJobInfoConverter getAuthRequestContext;

    @Override // androidx.work.impl.Scheduler
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return true;
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    private SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = workManagerImpl;
        this.BuiltInFictitiousFunctionClassFactory = jobScheduler;
        this.getAuthRequestContext = systemJobInfoConverter;
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WorkSpec... workSpecArr) {
        List<Integer> KClassImpl$Data$declaredNonStaticMembers$22;
        int MyBillsEntityDataFactory;
        WorkDatabase workDatabase = this.PlaceComponentResult.lookAheadTest;
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpec moveToNextValue = workDatabase.getErrorConfigVersion().moveToNextValue(workSpec.getErrorConfigVersion);
                if (moveToNextValue == null) {
                    Logger authRequestContext = Logger.getAuthRequestContext();
                    String str = KClassImpl$Data$declaredNonStaticMembers$2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Skipping scheduling ");
                    sb.append(workSpec.getErrorConfigVersion);
                    sb.append(" because it's no longer in the DB");
                    authRequestContext.getAuthRequestContext(str, sb.toString(), new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 != WorkInfo.State.ENQUEUED) {
                    Logger authRequestContext2 = Logger.getAuthRequestContext();
                    String str2 = KClassImpl$Data$declaredNonStaticMembers$2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Skipping scheduling ");
                    sb2.append(workSpec.getErrorConfigVersion);
                    sb2.append(" because it is no longer enqueued");
                    authRequestContext2.getAuthRequestContext(str2, sb2.toString(), new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo authRequestContext3 = workDatabase.getAuthRequestContext().getAuthRequestContext(workSpec.getErrorConfigVersion);
                    int MyBillsEntityDataFactory2 = authRequestContext3 != null ? authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2 : idGenerator.MyBillsEntityDataFactory(this.PlaceComponentResult.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult.getAuthRequestContext.lookAheadTest);
                    if (authRequestContext3 == null) {
                        this.PlaceComponentResult.lookAheadTest.getAuthRequestContext().MyBillsEntityDataFactory(new SystemIdInfo(workSpec.getErrorConfigVersion, MyBillsEntityDataFactory2));
                    }
                    getAuthRequestContext(workSpec, MyBillsEntityDataFactory2);
                    if (Build.VERSION.SDK_INT == 23 && (KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, workSpec.getErrorConfigVersion)) != null) {
                        int indexOf = KClassImpl$Data$declaredNonStaticMembers$22.indexOf(Integer.valueOf(MyBillsEntityDataFactory2));
                        if (indexOf >= 0) {
                            KClassImpl$Data$declaredNonStaticMembers$22.remove(indexOf);
                        }
                        if (!KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
                            MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$22.get(0).intValue();
                        } else {
                            MyBillsEntityDataFactory = idGenerator.MyBillsEntityDataFactory(this.PlaceComponentResult.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult.getAuthRequestContext.lookAheadTest);
                        }
                        getAuthRequestContext(workSpec, MyBillsEntityDataFactory);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    private void getAuthRequestContext(WorkSpec workSpec, int i) {
        int i2;
        JobInfo KClassImpl$Data$declaredNonStaticMembers$22 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(workSpec, i);
        Logger authRequestContext = Logger.getAuthRequestContext();
        String str = KClassImpl$Data$declaredNonStaticMembers$2;
        authRequestContext.PlaceComponentResult(str, String.format("Scheduling work ID %s Job ID %s", workSpec.getErrorConfigVersion, Integer.valueOf(i)), new Throwable[0]);
        try {
            if (this.BuiltInFictitiousFunctionClassFactory.schedule(KClassImpl$Data$declaredNonStaticMembers$22) == 0) {
                Logger.getAuthRequestContext().getAuthRequestContext(str, String.format("Unable to schedule work ID %s", workSpec.getErrorConfigVersion), new Throwable[0]);
                if (workSpec.scheduleImpl && workSpec.DatabaseTableConfigUtil == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.scheduleImpl = false;
                    Logger.getAuthRequestContext().PlaceComponentResult(str, String.format("Scheduling a non-expedited job (work ID %s)", workSpec.getErrorConfigVersion), new Throwable[0]);
                    getAuthRequestContext(workSpec, i);
                }
            }
        } catch (IllegalStateException e) {
            List<JobInfo> authRequestContext2 = getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
            int size = authRequestContext2 != null ? authRequestContext2.size() : 0;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(size);
            objArr[1] = Integer.valueOf(this.PlaceComponentResult.lookAheadTest.getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory().size());
            Configuration configuration = this.PlaceComponentResult.getAuthRequestContext;
            if (Build.VERSION.SDK_INT == 23) {
                i2 = configuration.getErrorConfigVersion / 2;
            } else {
                i2 = configuration.getErrorConfigVersion;
            }
            objArr[2] = Integer.valueOf(i2);
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", objArr);
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, format, new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, String.format("Unable to schedule %s", workSpec), th);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        List<Integer> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, str);
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null || KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
            return;
        }
        Iterator<Integer> it = KClassImpl$Data$declaredNonStaticMembers$22.iterator();
        while (it.hasNext()) {
            PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, it.next().intValue());
        }
        this.PlaceComponentResult.lookAheadTest.getAuthRequestContext().MyBillsEntityDataFactory(str);
    }

    private static void PlaceComponentResult(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static void MyBillsEntityDataFactory(Context context) {
        List<JobInfo> authRequestContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (authRequestContext = getAuthRequestContext(context, jobScheduler)) == null || authRequestContext.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = authRequestContext.iterator();
        while (it.hasNext()) {
            PlaceComponentResult(jobScheduler, it.next().getId());
        }
    }

    public static boolean MyBillsEntityDataFactory(Context context, WorkManagerImpl workManagerImpl) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> authRequestContext = getAuthRequestContext(context, jobScheduler);
        List<String> PlaceComponentResult = workManagerImpl.lookAheadTest.getAuthRequestContext().PlaceComponentResult();
        boolean z = false;
        HashSet hashSet = new HashSet(authRequestContext != null ? authRequestContext.size() : 0);
        if (authRequestContext != null && !authRequestContext.isEmpty()) {
            for (JobInfo jobInfo : authRequestContext) {
                String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(jobInfo);
                if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22)) {
                    hashSet.add(KClassImpl$Data$declaredNonStaticMembers$22);
                } else {
                    PlaceComponentResult(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = PlaceComponentResult.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (!hashSet.contains(it.next())) {
                Logger.getAuthRequestContext().PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Reconciling jobs", new Throwable[0]);
                z = true;
                break;
            }
        }
        if (z) {
            WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
            workDatabase.beginTransaction();
            try {
                WorkSpecDao errorConfigVersion = workDatabase.getErrorConfigVersion();
                Iterator<String> it2 = PlaceComponentResult.iterator();
                while (it2.hasNext()) {
                    errorConfigVersion.PlaceComponentResult(it2.next(), -1L);
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        return z;
    }

    private static List<JobInfo> getAuthRequestContext(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static List<Integer> KClassImpl$Data$declaredNonStaticMembers$2(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> authRequestContext = getAuthRequestContext(context, jobScheduler);
        if (authRequestContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : authRequestContext) {
            if (str.equals(KClassImpl$Data$declaredNonStaticMembers$2(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    return extras.getString("EXTRA_WORK_SPEC_ID");
                }
                return null;
            } catch (NullPointerException unused) {
                return null;
            }
        }
        return null;
    }
}
