package androidx.work.impl.utils;

import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes3.dex */
public class WorkProgressUpdater implements ProgressUpdater {
    static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("WorkProgressUpdater");
    final WorkDatabase BuiltInFictitiousFunctionClassFactory;
    final TaskExecutor KClassImpl$Data$declaredNonStaticMembers$2;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.BuiltInFictitiousFunctionClassFactory = workDatabase;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = taskExecutor;
    }

    @Override // androidx.work.ProgressUpdater
    public final ListenableFuture<Void> getAuthRequestContext(final UUID uuid, final Data data) {
        final SettableFuture PlaceComponentResult = SettableFuture.PlaceComponentResult();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new Runnable() { // from class: androidx.work.impl.utils.WorkProgressUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                WorkSpec moveToNextValue;
                String obj = uuid.toString();
                Logger.getAuthRequestContext().PlaceComponentResult(WorkProgressUpdater.MyBillsEntityDataFactory, String.format("Updating progress for %s (%s)", uuid, data), new Throwable[0]);
                WorkProgressUpdater.this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                try {
                    moveToNextValue = WorkProgressUpdater.this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion().moveToNextValue(obj);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (moveToNextValue != null) {
                    if (moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 == WorkInfo.State.RUNNING) {
                        WorkProgressUpdater.this.BuiltInFictitiousFunctionClassFactory.lookAheadTest().BuiltInFictitiousFunctionClassFactory(new WorkProgress(obj, data));
                    } else {
                        Logger.getAuthRequestContext().getAuthRequestContext(WorkProgressUpdater.MyBillsEntityDataFactory, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", obj), new Throwable[0]);
                    }
                    PlaceComponentResult.getAuthRequestContext((SettableFuture) null);
                    WorkProgressUpdater.this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
                    return;
                }
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
        });
        return PlaceComponentResult;
    }
}
