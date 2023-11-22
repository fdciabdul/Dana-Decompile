package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("SystemJobService");
    private WorkManagerImpl KClassImpl$Data$declaredNonStaticMembers$2;
    private final Map<String, JobParameters> getAuthRequestContext = new HashMap();

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(getApplicationContext());
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            Logger.getAuthRequestContext().getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (workManagerImpl != null) {
            Processor processor = workManagerImpl.KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (processor.getAuthRequestContext) {
                processor.BuiltInFictitiousFunctionClassFactory.remove(this);
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(jobParameters);
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.getAuthRequestContext) {
            if (this.getAuthRequestContext.containsKey(MyBillsEntityDataFactory)) {
                Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Job is already being executed by SystemJobService: %s", MyBillsEntityDataFactory), new Throwable[0]);
                return false;
            }
            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("onStartJob for %s", MyBillsEntityDataFactory), new Throwable[0]);
            this.getAuthRequestContext.put(MyBillsEntityDataFactory, jobParameters);
            WorkerParameters.RuntimeExtras runtimeExtras = null;
            if (Build.VERSION.SDK_INT >= 24) {
                runtimeExtras = new WorkerParameters.RuntimeExtras();
                if (jobParameters.getTriggeredContentUris() != null) {
                    runtimeExtras.KClassImpl$Data$declaredNonStaticMembers$2 = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    runtimeExtras.getAuthRequestContext = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    runtimeExtras.BuiltInFictitiousFunctionClassFactory = jobParameters.getNetwork();
                }
            }
            WorkManagerImpl workManagerImpl = this.KClassImpl$Data$declaredNonStaticMembers$2;
            workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StartWorkRunnable(workManagerImpl, MyBillsEntityDataFactory, runtimeExtras));
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(jobParameters);
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("onStopJob for %s", MyBillsEntityDataFactory), new Throwable[0]);
        synchronized (this.getAuthRequestContext) {
            this.getAuthRequestContext.remove(MyBillsEntityDataFactory);
        }
        WorkManagerImpl workManagerImpl = this.KClassImpl$Data$declaredNonStaticMembers$2;
        workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StopWorkRunnable(workManagerImpl, MyBillsEntityDataFactory, false));
        return !this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        JobParameters remove;
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.getAuthRequestContext) {
            remove = this.getAuthRequestContext.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    private static String MyBillsEntityDataFactory(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
