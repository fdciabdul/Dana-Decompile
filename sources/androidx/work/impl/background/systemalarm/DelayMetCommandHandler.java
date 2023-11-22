package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.utils.WorkTimer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("DelayMetCommandHandler");
    final SystemAlarmDispatcher BuiltInFictitiousFunctionClassFactory;
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    final int PlaceComponentResult;
    final WorkConstraintsTracker getErrorConfigVersion;
    final String lookAheadTest;
    PowerManager.WakeLock scheduleImpl;
    boolean MyBillsEntityDataFactory = false;
    private int moveToNextValue = 0;
    private final Object NetworkUserEntityData$$ExternalSyntheticLambda0 = new Object();

    public DelayMetCommandHandler(Context context, int i, String str, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = systemAlarmDispatcher;
        this.lookAheadTest = str;
        this.getErrorConfigVersion = new WorkConstraintsTracker(context, systemAlarmDispatcher.moveToNextValue, this);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void MyBillsEntityDataFactory(List<String> list) {
        if (list.contains(this.lookAheadTest)) {
            synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (this.moveToNextValue == 0) {
                    this.moveToNextValue = 1;
                    Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("onAllConstraintsMet for %s", this.lookAheadTest), new Throwable[0]);
                    if (!this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(this.lookAheadTest)) {
                        KClassImpl$Data$declaredNonStaticMembers$2();
                    } else {
                        WorkTimer workTimer = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
                        String str = this.lookAheadTest;
                        synchronized (workTimer.MyBillsEntityDataFactory) {
                            Logger.getAuthRequestContext().PlaceComponentResult(WorkTimer.getAuthRequestContext, String.format("Starting timer for %s", str), new Throwable[0]);
                            workTimer.getAuthRequestContext(str);
                            WorkTimer.WorkTimerRunnable workTimerRunnable = new WorkTimer.WorkTimerRunnable(workTimer, str);
                            workTimer.BuiltInFictitiousFunctionClassFactory.put(str, workTimerRunnable);
                            workTimer.KClassImpl$Data$declaredNonStaticMembers$2.put(str, this);
                            workTimer.PlaceComponentResult.schedule(workTimerRunnable, 600000L, TimeUnit.MILLISECONDS);
                        }
                    }
                } else {
                    Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Already started work for %s", this.lookAheadTest), new Throwable[0]);
                }
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        KClassImpl$Data$declaredNonStaticMembers$2();
        if (z) {
            Intent authRequestContext = CommandHandler.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest);
            SystemAlarmDispatcher systemAlarmDispatcher = this.BuiltInFictitiousFunctionClassFactory;
            systemAlarmDispatcher.lookAheadTest.post(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, authRequestContext, this.PlaceComponentResult));
        }
        if (this.MyBillsEntityDataFactory) {
            Intent MyBillsEntityDataFactory = CommandHandler.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.BuiltInFictitiousFunctionClassFactory;
            systemAlarmDispatcher2.lookAheadTest.post(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, MyBillsEntityDataFactory, this.PlaceComponentResult));
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public final void getAuthRequestContext(String str) {
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        getAuthRequestContext();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void PlaceComponentResult(List<String> list) {
        getAuthRequestContext();
    }

    public final void getAuthRequestContext() {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (this.moveToNextValue < 2) {
                this.moveToNextValue = 2;
                Logger authRequestContext = Logger.getAuthRequestContext();
                String str = getAuthRequestContext;
                authRequestContext.PlaceComponentResult(str, String.format("Stopping work for WorkSpec %s", this.lookAheadTest), new Throwable[0]);
                Intent MyBillsEntityDataFactory = CommandHandler.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest);
                SystemAlarmDispatcher systemAlarmDispatcher = this.BuiltInFictitiousFunctionClassFactory;
                systemAlarmDispatcher.lookAheadTest.post(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, MyBillsEntityDataFactory, this.PlaceComponentResult));
                if (this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest)) {
                    Logger.getAuthRequestContext().PlaceComponentResult(str, String.format("WorkSpec %s needs to be rescheduled", this.lookAheadTest), new Throwable[0]);
                    Intent authRequestContext2 = CommandHandler.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.BuiltInFictitiousFunctionClassFactory;
                    systemAlarmDispatcher2.lookAheadTest.post(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, authRequestContext2, this.PlaceComponentResult));
                } else {
                    Logger.getAuthRequestContext().PlaceComponentResult(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.lookAheadTest), new Throwable[0]);
                }
            } else {
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Already stopped work for %s", this.lookAheadTest), new Throwable[0]);
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.getErrorConfigVersion.MyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil.getAuthRequestContext(this.lookAheadTest);
            PowerManager.WakeLock wakeLock = this.scheduleImpl;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Releasing wakelock %s for WorkSpec %s", this.scheduleImpl, this.lookAheadTest), new Throwable[0]);
                this.scheduleImpl.release();
            }
        }
    }
}
