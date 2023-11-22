package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes3.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("WMFgUpdater");
    final WorkSpecDao KClassImpl$Data$declaredNonStaticMembers$2;
    private final TaskExecutor MyBillsEntityDataFactory;
    final ForegroundProcessor getAuthRequestContext;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.getAuthRequestContext = foregroundProcessor;
        this.MyBillsEntityDataFactory = taskExecutor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = workDatabase.getErrorConfigVersion();
    }

    @Override // androidx.work.ForegroundUpdater
    public final ListenableFuture<Void> getAuthRequestContext(final Context context, final UUID uuid, final ForegroundInfo foregroundInfo) {
        final SettableFuture PlaceComponentResult = SettableFuture.PlaceComponentResult();
        this.MyBillsEntityDataFactory.getAuthRequestContext(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!PlaceComponentResult.isCancelled()) {
                        String obj = uuid.toString();
                        WorkInfo.State PlaceComponentResult2 = WorkForegroundUpdater.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(obj);
                        if (PlaceComponentResult2 == null || PlaceComponentResult2.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(obj, foregroundInfo);
                        context.startService(SystemForegroundDispatcher.BuiltInFictitiousFunctionClassFactory(context, obj, foregroundInfo));
                    }
                    PlaceComponentResult.getAuthRequestContext((SettableFuture) null);
                } catch (Throwable th) {
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(th);
                }
            }
        });
        return PlaceComponentResult;
    }
}
