package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("ConstraintTrkngWrkr");
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    final Object KClassImpl$Data$declaredNonStaticMembers$2;
    SettableFuture<ListenableWorker.Result> PlaceComponentResult;
    ListenableWorker getAuthRequestContext;
    WorkerParameters moveToNextValue;

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void MyBillsEntityDataFactory(List<String> list) {
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.moveToNextValue = workerParameters;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = SettableFuture.PlaceComponentResult();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.1
            @Override // java.lang.Runnable
            public void run() {
                final ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
                Object obj = constraintTrackingWorker.getInputData().MyBillsEntityDataFactory.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                String str = obj instanceof String ? (String) obj : null;
                if (TextUtils.isEmpty(str)) {
                    Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(ConstraintTrackingWorker.MyBillsEntityDataFactory, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.getAuthRequestContext());
                    return;
                }
                ListenableWorker authRequestContext = constraintTrackingWorker.getWorkerFactory().getAuthRequestContext(constraintTrackingWorker.getApplicationContext(), str, constraintTrackingWorker.moveToNextValue);
                constraintTrackingWorker.getAuthRequestContext = authRequestContext;
                if (authRequestContext == null) {
                    Logger.getAuthRequestContext().PlaceComponentResult(ConstraintTrackingWorker.MyBillsEntityDataFactory, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.getAuthRequestContext());
                    return;
                }
                WorkSpec moveToNextValue = WorkManagerImpl.PlaceComponentResult(constraintTrackingWorker.getApplicationContext()).lookAheadTest.getErrorConfigVersion().moveToNextValue(constraintTrackingWorker.getId().toString());
                if (moveToNextValue != null) {
                    WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                    workConstraintsTracker.BuiltInFictitiousFunctionClassFactory(Collections.singletonList(moveToNextValue));
                    if (workConstraintsTracker.BuiltInFictitiousFunctionClassFactory(constraintTrackingWorker.getId().toString())) {
                        Logger.getAuthRequestContext().PlaceComponentResult(ConstraintTrackingWorker.MyBillsEntityDataFactory, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                        try {
                            final ListenableFuture<ListenableWorker.Result> startWork = constraintTrackingWorker.getAuthRequestContext.startWork();
                            startWork.addListener(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    synchronized (ConstraintTrackingWorker.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                                        if (!ConstraintTrackingWorker.this.BuiltInFictitiousFunctionClassFactory) {
                                            ConstraintTrackingWorker.this.PlaceComponentResult.PlaceComponentResult(startWork);
                                        } else {
                                            ConstraintTrackingWorker.this.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.MyBillsEntityDataFactory());
                                        }
                                    }
                                }
                            }, constraintTrackingWorker.getBackgroundExecutor());
                            return;
                        } catch (Throwable th) {
                            Logger authRequestContext2 = Logger.getAuthRequestContext();
                            String str2 = ConstraintTrackingWorker.MyBillsEntityDataFactory;
                            authRequestContext2.PlaceComponentResult(str2, String.format("Delegated worker %s threw exception in startWork.", str), th);
                            synchronized (constraintTrackingWorker.KClassImpl$Data$declaredNonStaticMembers$2) {
                                if (constraintTrackingWorker.BuiltInFictitiousFunctionClassFactory) {
                                    Logger.getAuthRequestContext().PlaceComponentResult(str2, "Constraints were unmet, Retrying.", new Throwable[0]);
                                    constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.MyBillsEntityDataFactory());
                                    return;
                                }
                                constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.getAuthRequestContext());
                                return;
                            }
                        }
                    }
                    Logger.getAuthRequestContext().PlaceComponentResult(ConstraintTrackingWorker.MyBillsEntityDataFactory, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
                    constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.MyBillsEntityDataFactory());
                    return;
                }
                constraintTrackingWorker.PlaceComponentResult.getAuthRequestContext((SettableFuture<ListenableWorker.Result>) ListenableWorker.Result.getAuthRequestContext());
            }
        });
        return this.PlaceComponentResult;
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.getAuthRequestContext;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        this.getAuthRequestContext.stop();
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.getAuthRequestContext;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.ListenableWorker
    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.PlaceComponentResult(getApplicationContext()).getErrorConfigVersion;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void PlaceComponentResult(List<String> list) {
        Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }
    }
}
