package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.arch.core.util.Function;
import androidx.view.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class WorkManagerImpl extends WorkManager {
    public List<Scheduler> BuiltInFictitiousFunctionClassFactory;
    public Processor KClassImpl$Data$declaredNonStaticMembers$2;
    public Context MyBillsEntityDataFactory;
    private BroadcastReceiver.PendingResult NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    public PreferenceUtils PlaceComponentResult;
    public Configuration getAuthRequestContext;
    public TaskExecutor getErrorConfigVersion;
    public WorkDatabase lookAheadTest;
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = Logger.MyBillsEntityDataFactory("WorkManagerImpl");
    private static WorkManagerImpl scheduleImpl = null;
    private static WorkManagerImpl moveToNextValue = null;
    private static final Object initRecordTimeStamp = new Object();

    @Deprecated
    private static WorkManagerImpl BuiltInFictitiousFunctionClassFactory() {
        synchronized (initRecordTimeStamp) {
            WorkManagerImpl workManagerImpl = scheduleImpl;
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            return moveToNextValue;
        }
    }

    public static WorkManagerImpl PlaceComponentResult(Context context) {
        WorkManagerImpl BuiltInFictitiousFunctionClassFactory;
        synchronized (initRecordTimeStamp) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Configuration.Provider) {
                    MyBillsEntityDataFactory(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                    BuiltInFictitiousFunctionClassFactory = PlaceComponentResult(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
    
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (androidx.work.impl.WorkManagerImpl.moveToNextValue != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        androidx.work.impl.WorkManagerImpl.moveToNextValue = new androidx.work.impl.WorkManagerImpl(r4, r5, new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor(r5.scheduleImpl));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        androidx.work.impl.WorkManagerImpl.scheduleImpl = androidx.work.impl.WorkManagerImpl.moveToNextValue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void MyBillsEntityDataFactory(android.content.Context r4, androidx.work.Configuration r5) {
        /*
            java.lang.Object r0 = androidx.work.impl.WorkManagerImpl.initRecordTimeStamp
            monitor-enter(r0)
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.scheduleImpl     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L14
            androidx.work.impl.WorkManagerImpl r2 = androidx.work.impl.WorkManagerImpl.moveToNextValue     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto Lc
            goto L14
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L32
            throw r4     // Catch: java.lang.Throwable -> L32
        L14:
            if (r1 != 0) goto L30
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.moveToNextValue     // Catch: java.lang.Throwable -> L32
            if (r1 != 0) goto L2c
            androidx.work.impl.WorkManagerImpl r1 = new androidx.work.impl.WorkManagerImpl     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor r2 = new androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor     // Catch: java.lang.Throwable -> L32
            java.util.concurrent.Executor r3 = r5.scheduleImpl     // Catch: java.lang.Throwable -> L32
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L32
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl.moveToNextValue = r1     // Catch: java.lang.Throwable -> L32
        L2c:
            androidx.work.impl.WorkManagerImpl r4 = androidx.work.impl.WorkManagerImpl.moveToNextValue     // Catch: java.lang.Throwable -> L32
            androidx.work.impl.WorkManagerImpl.scheduleImpl = r4     // Catch: java.lang.Throwable -> L32
        L30:
            monitor-exit(r0)
            return
        L32:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.MyBillsEntityDataFactory(android.content.Context, androidx.work.Configuration):void");
    }

    private WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(R.bool.BuiltInFictitiousFunctionClassFactory));
    }

    private WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, boolean z) {
        this(context, configuration, taskExecutor, WorkDatabase.getAuthRequestContext(context.getApplicationContext(), taskExecutor.MyBillsEntityDataFactory(), z));
    }

    private WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        Logger.PlaceComponentResult(new Logger.LogcatLogger(configuration.BuiltInFictitiousFunctionClassFactory));
        List<Scheduler> asList = Arrays.asList(Schedulers.PlaceComponentResult(applicationContext, this), new GreedyScheduler(applicationContext, configuration, taskExecutor, this));
        Processor processor = new Processor(context, configuration, taskExecutor, workDatabase, asList);
        Context applicationContext2 = context.getApplicationContext();
        this.MyBillsEntityDataFactory = applicationContext2;
        this.getAuthRequestContext = configuration;
        this.getErrorConfigVersion = taskExecutor;
        this.lookAheadTest = workDatabase;
        this.BuiltInFictitiousFunctionClassFactory = asList;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = processor;
        this.PlaceComponentResult = new PreferenceUtils(workDatabase);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        if (Build.VERSION.SDK_INT >= 24 && applicationContext2.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.getErrorConfigVersion.getAuthRequestContext(new ForceStopRunnable(applicationContext2, this));
    }

    @Override // androidx.work.WorkManager
    public final Operation PlaceComponentResult(List<? extends WorkRequest> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new WorkContinuationImpl(this, list).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.work.WorkManager
    public final WorkContinuation getAuthRequestContext(List<OneTimeWorkRequest> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
        }
        return new WorkContinuationImpl(this, list);
    }

    @Override // androidx.work.WorkManager
    public final WorkContinuation getAuthRequestContext(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list);
    }

    @Override // androidx.work.WorkManager
    public final Operation PlaceComponentResult(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.work.WorkManager
    public final Operation getAuthRequestContext(String str) {
        CancelWorkRunnable authRequestContext = CancelWorkRunnable.getAuthRequestContext(str, this);
        this.getErrorConfigVersion.getAuthRequestContext(authRequestContext);
        return authRequestContext.getAuthRequestContext;
    }

    @Override // androidx.work.WorkManager
    public final Operation MyBillsEntityDataFactory(String str) {
        CancelWorkRunnable BuiltInFictitiousFunctionClassFactory = CancelWorkRunnable.BuiltInFictitiousFunctionClassFactory(str, this, true);
        this.getErrorConfigVersion.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
        return BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
    }

    /* renamed from: androidx.work.impl.WorkManagerImpl$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SettableFuture MyBillsEntityDataFactory;
        final /* synthetic */ PreferenceUtils getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            try {
                SettableFuture settableFuture = this.MyBillsEntityDataFactory;
                Long KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("last_cancel_all_time_ms");
                settableFuture.getAuthRequestContext((SettableFuture) Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.longValue() : 0L));
            } catch (Throwable th) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
            }
        }
    }

    @Override // androidx.work.WorkManager
    public final Operation getAuthRequestContext() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.getErrorConfigVersion.getAuthRequestContext(pruneWorkRunnable);
        return pruneWorkRunnable.BuiltInFictitiousFunctionClassFactory;
    }

    /* renamed from: androidx.work.impl.WorkManagerImpl$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Function<List<WorkSpec.WorkInfoPojo>, WorkInfo> {
        @Override // androidx.arch.core.util.Function
        public /* synthetic */ WorkInfo getAuthRequestContext(List<WorkSpec.WorkInfoPojo> list) {
            List<WorkSpec.WorkInfoPojo> list2 = list;
            if (list2 == null || list2.size() <= 0) {
                return null;
            }
            return list2.get(0).MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.WorkManager
    public final LiveData<List<WorkInfo>> BuiltInFictitiousFunctionClassFactory(String str) {
        return LiveDataUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest.getErrorConfigVersion().DatabaseTableConfigUtil(str), WorkSpec.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion);
    }

    @Override // androidx.work.WorkManager
    public final ListenableFuture<List<WorkInfo>> PlaceComponentResult(String str) {
        StatusRunnable<List<WorkInfo>> PlaceComponentResult = StatusRunnable.PlaceComponentResult(this, str);
        this.getErrorConfigVersion.MyBillsEntityDataFactory().execute(PlaceComponentResult);
        return PlaceComponentResult.MyBillsEntityDataFactory;
    }

    public final void PlaceComponentResult() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        }
        this.lookAheadTest.getErrorConfigVersion().lookAheadTest();
        Schedulers.PlaceComponentResult(this.getAuthRequestContext, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (initRecordTimeStamp) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            BroadcastReceiver.PendingResult pendingResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (pendingResult != null) {
                pendingResult.finish();
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            }
        }
    }

    public final void MyBillsEntityDataFactory(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (initRecordTimeStamp) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = pendingResult;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                pendingResult.finish();
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            }
        }
    }

    @Override // androidx.work.WorkManager
    public final Operation KClassImpl$Data$declaredNonStaticMembers$2(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        ExistingWorkPolicy existingWorkPolicy;
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP) {
            existingWorkPolicy = ExistingWorkPolicy.KEEP;
        } else {
            existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, Collections.singletonList(periodicWorkRequest)).KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
