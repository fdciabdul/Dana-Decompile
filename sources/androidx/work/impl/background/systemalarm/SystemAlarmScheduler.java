package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

/* loaded from: classes3.dex */
public class SystemAlarmScheduler implements Scheduler {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("SystemAlarmScheduler");
    private final Context MyBillsEntityDataFactory;

    @Override // androidx.work.impl.Scheduler
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return true;
    }

    public SystemAlarmScheduler(Context context) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, String.format("Scheduling work with workSpecId %s", workSpec.getErrorConfigVersion), new Throwable[0]);
            this.MyBillsEntityDataFactory.startService(CommandHandler.getAuthRequestContext(this.MyBillsEntityDataFactory, workSpec.getErrorConfigVersion));
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.MyBillsEntityDataFactory.startService(CommandHandler.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, str));
    }
}
