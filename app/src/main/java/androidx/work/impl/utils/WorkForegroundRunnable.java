package androidx.work.impl.utils;

import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class WorkForegroundRunnable implements Runnable {
    static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("WorkForegroundRunnable");
    final ForegroundUpdater KClassImpl$Data$declaredNonStaticMembers$2;
    public final SettableFuture<Void> MyBillsEntityDataFactory = SettableFuture.PlaceComponentResult();
    final TaskExecutor PlaceComponentResult;
    final Context getAuthRequestContext;
    final WorkSpec lookAheadTest;
    final ListenableWorker scheduleImpl;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.getAuthRequestContext = context;
        this.lookAheadTest = workSpec;
        this.scheduleImpl = listenableWorker;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = foregroundUpdater;
        this.PlaceComponentResult = taskExecutor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.lookAheadTest.scheduleImpl || BuildCompat.MyBillsEntityDataFactory()) {
            this.MyBillsEntityDataFactory.getAuthRequestContext((SettableFuture<Void>) null);
            return;
        }
        final SettableFuture PlaceComponentResult = SettableFuture.PlaceComponentResult();
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().execute(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                PlaceComponentResult.PlaceComponentResult(WorkForegroundRunnable.this.scheduleImpl.getForegroundInfoAsync());
            }
        });
        PlaceComponentResult.addListener(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) PlaceComponentResult.get();
                    if (foregroundInfo == null) {
                        throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", WorkForegroundRunnable.this.lookAheadTest.newProxyInstance));
                    }
                    Logger.getAuthRequestContext().PlaceComponentResult(WorkForegroundRunnable.BuiltInFictitiousFunctionClassFactory, String.format("Updating notification for %s", WorkForegroundRunnable.this.lookAheadTest.newProxyInstance), new Throwable[0]);
                    WorkForegroundRunnable.this.scheduleImpl.setRunInForeground(true);
                    WorkForegroundRunnable.this.MyBillsEntityDataFactory.PlaceComponentResult(WorkForegroundRunnable.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(WorkForegroundRunnable.this.getAuthRequestContext, WorkForegroundRunnable.this.scheduleImpl.getId(), foregroundInfo));
                } catch (Throwable th) {
                    WorkForegroundRunnable.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
                }
            }
        }, this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
    }
}
