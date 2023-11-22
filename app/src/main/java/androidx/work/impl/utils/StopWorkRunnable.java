package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

/* loaded from: classes3.dex */
public class StopWorkRunnable implements Runnable {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("StopWorkRunnable");
    private final String MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;
    private final WorkManagerImpl getAuthRequestContext;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String str, boolean z) {
        this.getAuthRequestContext = workManagerImpl;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean errorConfigVersion;
        WorkDatabase workDatabase = this.getAuthRequestContext.lookAheadTest;
        Processor processor = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        WorkSpecDao errorConfigVersion2 = workDatabase.getErrorConfigVersion();
        workDatabase.beginTransaction();
        try {
            boolean KClassImpl$Data$declaredNonStaticMembers$22 = processor.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            if (this.PlaceComponentResult) {
                errorConfigVersion = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0(this.MyBillsEntityDataFactory);
            } else {
                if (!KClassImpl$Data$declaredNonStaticMembers$22 && errorConfigVersion2.PlaceComponentResult(this.MyBillsEntityDataFactory) == WorkInfo.State.RUNNING) {
                    errorConfigVersion2.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.ENQUEUED, this.MyBillsEntityDataFactory);
                }
                errorConfigVersion = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion(this.MyBillsEntityDataFactory);
            }
            Logger.getAuthRequestContext().PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.MyBillsEntityDataFactory, Boolean.valueOf(errorConfigVersion)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
