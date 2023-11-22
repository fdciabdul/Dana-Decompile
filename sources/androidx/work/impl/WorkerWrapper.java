package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.InputMergerFactory;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public class WorkerWrapper implements Runnable {
    static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("WorkerWrapper");
    Context BuiltInFictitiousFunctionClassFactory;
    private ForegroundProcessor DatabaseTableConfigUtil;
    private List<String> GetContactSyncConfig;
    volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Configuration NetworkUserEntityData$$ExternalSyntheticLambda0;
    private DependencyDao NetworkUserEntityData$$ExternalSyntheticLambda1;
    private WorkerParameters.RuntimeExtras NetworkUserEntityData$$ExternalSyntheticLambda2;
    private WorkTagDao NetworkUserEntityData$$ExternalSyntheticLambda7;
    private WorkDatabase NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PrepareContext;
    ListenableWorker getErrorConfigVersion;
    private List<Scheduler> initRecordTimeStamp;
    private String isLayoutRequested;
    WorkSpec moveToNextValue;
    private WorkSpecDao newProxyInstance;
    TaskExecutor scheduleImpl;
    ListenableWorker.Result lookAheadTest = ListenableWorker.Result.getAuthRequestContext();
    SettableFuture<Boolean> PlaceComponentResult = SettableFuture.PlaceComponentResult();
    ListenableFuture<ListenableWorker.Result> MyBillsEntityDataFactory = null;

    public WorkerWrapper(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult;
        this.scheduleImpl = builder.getErrorConfigVersion;
        this.DatabaseTableConfigUtil = builder.MyBillsEntityDataFactory;
        this.PrepareContext = builder.lookAheadTest;
        this.initRecordTimeStamp = builder.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.getAuthRequestContext;
        WorkDatabase workDatabase = builder.scheduleImpl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = workDatabase;
        this.newProxyInstance = workDatabase.getErrorConfigVersion();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.scheduleImpl();
    }

    @Override // java.lang.Runnable
    public void run() {
        Data PlaceComponentResult;
        List<String> BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(this.PrepareContext);
        this.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.PrepareContext);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : BuiltInFictitiousFunctionClassFactory) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        this.isLayoutRequested = sb.toString();
        if (MyBillsEntityDataFactory()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            WorkSpec moveToNextValue = this.newProxyInstance.moveToNextValue(this.PrepareContext);
            this.moveToNextValue = moveToNextValue;
            if (moveToNextValue == null) {
                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, String.format("Didn't find WorkSpec for id %s", this.PrepareContext), new Throwable[0]);
                KClassImpl$Data$declaredNonStaticMembers$2(false);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
            } else if (moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 != WorkInfo.State.ENQUEUED) {
                getAuthRequestContext();
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.moveToNextValue.newProxyInstance), new Throwable[0]);
            } else {
                if (this.moveToNextValue.getAuthRequestContext() || this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!(this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0) && currentTimeMillis < this.moveToNextValue.PlaceComponentResult()) {
                        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Delaying execution for %s because it is being executed before schedule.", this.moveToNextValue.newProxyInstance), new Throwable[0]);
                        KClassImpl$Data$declaredNonStaticMembers$2(true);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
                        return;
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
                if (this.moveToNextValue.getAuthRequestContext()) {
                    PlaceComponentResult = this.moveToNextValue.moveToNextValue;
                } else {
                    InputMergerFactory inputMergerFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
                    InputMerger MyBillsEntityDataFactory = InputMerger.MyBillsEntityDataFactory(this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    if (MyBillsEntityDataFactory == null) {
                        Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, String.format("Could not create Input Merger %s", this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1), new Throwable[0]);
                        scheduleImpl();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.moveToNextValue.moveToNextValue);
                    arrayList.addAll(this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext));
                    PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult(arrayList);
                }
                WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.PrepareContext), PlaceComponentResult, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda2, new WorkProgressUpdater(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.scheduleImpl), new WorkForegroundUpdater(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.DatabaseTableConfigUtil, this.scheduleImpl));
                if (this.getErrorConfigVersion == null) {
                    this.getErrorConfigVersion = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.moveToNextValue.newProxyInstance, workerParameters);
                }
                ListenableWorker listenableWorker = this.getErrorConfigVersion;
                if (listenableWorker == null) {
                    Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, String.format("Could not create Worker %s", this.moveToNextValue.newProxyInstance), new Throwable[0]);
                    scheduleImpl();
                } else if (listenableWorker.isUsed()) {
                    Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.moveToNextValue.newProxyInstance), new Throwable[0]);
                    scheduleImpl();
                } else {
                    this.getErrorConfigVersion.setUsed();
                    if (!NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                        getAuthRequestContext();
                    } else if (!MyBillsEntityDataFactory()) {
                        final SettableFuture PlaceComponentResult2 = SettableFuture.PlaceComponentResult();
                        WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.BuiltInFictitiousFunctionClassFactory, this.moveToNextValue, this.getErrorConfigVersion, workerParameters.getAuthRequestContext, this.scheduleImpl);
                        this.scheduleImpl.BuiltInFictitiousFunctionClassFactory().execute(workForegroundRunnable);
                        final SettableFuture<Void> settableFuture = workForegroundRunnable.MyBillsEntityDataFactory;
                        settableFuture.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.1
                            {
                                WorkerWrapper.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    settableFuture.get();
                                    Logger.getAuthRequestContext().PlaceComponentResult(WorkerWrapper.getAuthRequestContext, String.format("Starting work for %s", WorkerWrapper.this.moveToNextValue.newProxyInstance), new Throwable[0]);
                                    WorkerWrapper workerWrapper = WorkerWrapper.this;
                                    workerWrapper.MyBillsEntityDataFactory = workerWrapper.getErrorConfigVersion.startWork();
                                    PlaceComponentResult2.PlaceComponentResult(WorkerWrapper.this.MyBillsEntityDataFactory);
                                } catch (Throwable th) {
                                    PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(th);
                                }
                            }
                        }, this.scheduleImpl.BuiltInFictitiousFunctionClassFactory());
                        final String str2 = this.isLayoutRequested;
                        PlaceComponentResult2.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.2
                            {
                                WorkerWrapper.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) PlaceComponentResult2.get();
                                        if (result == null) {
                                            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(WorkerWrapper.getAuthRequestContext, String.format("%s returned a null result. Treating it as a failure.", WorkerWrapper.this.moveToNextValue.newProxyInstance), new Throwable[0]);
                                        } else {
                                            Logger.getAuthRequestContext().PlaceComponentResult(WorkerWrapper.getAuthRequestContext, String.format("%s returned a %s result.", WorkerWrapper.this.moveToNextValue.newProxyInstance, result), new Throwable[0]);
                                            WorkerWrapper.this.lookAheadTest = result;
                                        }
                                    } catch (InterruptedException e) {
                                        e = e;
                                        Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(WorkerWrapper.getAuthRequestContext, String.format("%s failed because it threw an exception/error", str2), e);
                                    } catch (CancellationException e2) {
                                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(WorkerWrapper.getAuthRequestContext, String.format("%s was cancelled", str2), e2);
                                    } catch (ExecutionException e3) {
                                        e = e3;
                                        Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(WorkerWrapper.getAuthRequestContext, String.format("%s failed because it threw an exception/error", str2), e);
                                    }
                                } finally {
                                    WorkerWrapper.this.BuiltInFictitiousFunctionClassFactory();
                                }
                            }
                        }, this.scheduleImpl.MyBillsEntityDataFactory());
                    }
                }
            }
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
        }
    }

    final void BuiltInFictitiousFunctionClassFactory() {
        if (!MyBillsEntityDataFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
            try {
                WorkInfo.State PlaceComponentResult = this.newProxyInstance.PlaceComponentResult(this.PrepareContext);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.lookAheadTest().PlaceComponentResult(this.PrepareContext);
                if (PlaceComponentResult == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(false);
                } else if (PlaceComponentResult == WorkInfo.State.RUNNING) {
                    ListenableWorker.Result result = this.lookAheadTest;
                    if (result instanceof ListenableWorker.Result.Success) {
                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, String.format("Worker result SUCCESS for %s", this.isLayoutRequested), new Throwable[0]);
                        if (this.moveToNextValue.getAuthRequestContext()) {
                            PlaceComponentResult();
                        } else {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
                            try {
                                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.SUCCEEDED, this.PrepareContext);
                                this.newProxyInstance.getAuthRequestContext(this.PrepareContext, ((ListenableWorker.Result.Success) this.lookAheadTest).PlaceComponentResult);
                                long currentTimeMillis = System.currentTimeMillis();
                                for (String str : this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(this.PrepareContext)) {
                                    if (this.newProxyInstance.PlaceComponentResult(str) == WorkInfo.State.BLOCKED && this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(str)) {
                                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                                        this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, str);
                                        this.newProxyInstance.getAuthRequestContext(str, currentTimeMillis);
                                    }
                                }
                                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
                                this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
                                KClassImpl$Data$declaredNonStaticMembers$2(false);
                            } catch (Throwable th) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
                                KClassImpl$Data$declaredNonStaticMembers$2(false);
                                throw th;
                            }
                        }
                    } else if (result instanceof ListenableWorker.Result.Retry) {
                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, String.format("Worker result RETRY for %s", this.isLayoutRequested), new Throwable[0]);
                        KClassImpl$Data$declaredNonStaticMembers$2();
                    } else {
                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, String.format("Worker result FAILURE for %s", this.isLayoutRequested), new Throwable[0]);
                        if (this.moveToNextValue.getAuthRequestContext()) {
                            PlaceComponentResult();
                        } else {
                            scheduleImpl();
                        }
                    }
                } else if (!PlaceComponentResult.isFinished()) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
            } finally {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            }
        }
        List<Scheduler> list = this.initRecordTimeStamp;
        if (list != null) {
            Iterator<Scheduler> it = list.iterator();
            while (it.hasNext()) {
                it.next().KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext);
            }
            Schedulers.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.initRecordTimeStamp);
        }
    }

    private void getAuthRequestContext() {
        WorkInfo.State PlaceComponentResult = this.newProxyInstance.PlaceComponentResult(this.PrepareContext);
        if (PlaceComponentResult == WorkInfo.State.RUNNING) {
            Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.PrepareContext), new Throwable[0]);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Status for %s is %s; not doing any work", this.PrepareContext, PlaceComponentResult), new Throwable[0]);
        KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    public final boolean MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Work interrupted for %s", this.isLayoutRequested), new Throwable[0]);
            if (this.newProxyInstance.PlaceComponentResult(this.PrepareContext) == null) {
                KClassImpl$Data$declaredNonStaticMembers$2(false);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(!r0.isFinished());
            }
            return true;
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        ListenableWorker listenableWorker;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8.getErrorConfigVersion().getAuthRequestContext()) {
                PackageManagerHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, RescheduleReceiver.class, false);
            }
            if (z) {
                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, this.PrepareContext);
                this.newProxyInstance.PlaceComponentResult(this.PrepareContext, -1L);
            }
            if (this.moveToNextValue != null && (listenableWorker = this.getErrorConfigVersion) != null && listenableWorker.isRunInForeground()) {
                this.DatabaseTableConfigUtil.lookAheadTest(this.PrepareContext);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            this.PlaceComponentResult.getAuthRequestContext((SettableFuture<Boolean>) Boolean.valueOf(z));
        } catch (Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            throw th;
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            boolean z = false;
            if (this.newProxyInstance.PlaceComponentResult(this.PrepareContext) == WorkInfo.State.ENQUEUED) {
                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.RUNNING, this.PrepareContext);
                this.newProxyInstance.NetworkUserEntityData$$ExternalSyntheticLambda2(this.PrepareContext);
                z = true;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
            return z;
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
        }
    }

    private void scheduleImpl() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            MyBillsEntityDataFactory(this.PrepareContext);
            this.newProxyInstance.getAuthRequestContext(this.PrepareContext, ((ListenableWorker.Result.Failure) this.lookAheadTest).getAuthRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    private void MyBillsEntityDataFactory(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.newProxyInstance.PlaceComponentResult(str2) != WorkInfo.State.CANCELLED) {
                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(str2));
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, this.PrepareContext);
            this.newProxyInstance.getAuthRequestContext(this.PrepareContext, System.currentTimeMillis());
            this.newProxyInstance.PlaceComponentResult(this.PrepareContext, -1L);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }

    private void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.beginTransaction();
        try {
            this.newProxyInstance.getAuthRequestContext(this.PrepareContext, System.currentTimeMillis());
            this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, this.PrepareContext);
            this.newProxyInstance.initRecordTimeStamp(this.PrepareContext);
            this.newProxyInstance.PlaceComponentResult(this.PrepareContext, -1L);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTransactionSuccessful();
        } finally {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.endTransaction();
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        List<Scheduler> BuiltInFictitiousFunctionClassFactory;
        WorkerParameters.RuntimeExtras KClassImpl$Data$declaredNonStaticMembers$2 = new WorkerParameters.RuntimeExtras();
        ForegroundProcessor MyBillsEntityDataFactory;
        ListenableWorker NetworkUserEntityData$$ExternalSyntheticLambda0;
        Context PlaceComponentResult;
        Configuration getAuthRequestContext;
        TaskExecutor getErrorConfigVersion;
        String lookAheadTest;
        WorkDatabase scheduleImpl;

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String str) {
            this.PlaceComponentResult = context.getApplicationContext();
            this.getErrorConfigVersion = taskExecutor;
            this.MyBillsEntityDataFactory = foregroundProcessor;
            this.getAuthRequestContext = configuration;
            this.scheduleImpl = workDatabase;
            this.lookAheadTest = str;
        }
    }
}
