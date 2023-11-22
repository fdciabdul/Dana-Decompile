package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("GreedyScheduler");
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    Boolean MyBillsEntityDataFactory;
    private final WorkManagerImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
    private DelayedWorkTracker PlaceComponentResult;
    private boolean lookAheadTest;
    private final WorkConstraintsTracker scheduleImpl;
    private final Set<WorkSpec> BuiltInFictitiousFunctionClassFactory = new HashSet();
    private final Object moveToNextValue = new Object();

    @Override // androidx.work.impl.Scheduler
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return false;
    }

    public GreedyScheduler(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = workManagerImpl;
        this.scheduleImpl = new WorkConstraintsTracker(context, taskExecutor, this);
        this.PlaceComponentResult = new DelayedWorkTracker(this, configuration.moveToNextValue);
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WorkSpec... workSpecArr) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = Boolean.valueOf(ProcessUtils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext));
        }
        if (!this.MyBillsEntityDataFactory.booleanValue()) {
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        PlaceComponentResult();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            long PlaceComponentResult = workSpec.PlaceComponentResult();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < PlaceComponentResult) {
                    DelayedWorkTracker delayedWorkTracker = this.PlaceComponentResult;
                    if (delayedWorkTracker != null) {
                        delayedWorkTracker.BuiltInFictitiousFunctionClassFactory(workSpec);
                    }
                } else if (workSpec.BuiltInFictitiousFunctionClassFactory()) {
                    if (Build.VERSION.SDK_INT >= 23 && workSpec.MyBillsEntityDataFactory.getAuthRequestContext()) {
                        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Ignoring WorkSpec %s, Requires device idle.", workSpec), new Throwable[0]);
                    } else if (Build.VERSION.SDK_INT >= 24 && workSpec.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", workSpec), new Throwable[0]);
                    } else {
                        hashSet.add(workSpec);
                        hashSet2.add(workSpec.getErrorConfigVersion);
                    }
                } else {
                    Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Starting work for %s", workSpec.getErrorConfigVersion), new Throwable[0]);
                    WorkManagerImpl workManagerImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StartWorkRunnable(workManagerImpl, workSpec.getErrorConfigVersion, null));
                }
            }
        }
        synchronized (this.moveToNextValue) {
            if (!hashSet.isEmpty()) {
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.BuiltInFictitiousFunctionClassFactory.addAll(hashSet);
                this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Runnable remove;
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = Boolean.valueOf(ProcessUtils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext));
        }
        if (!this.MyBillsEntityDataFactory.booleanValue()) {
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        PlaceComponentResult();
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Cancelling work ID %s", str), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.PlaceComponentResult;
        if (delayedWorkTracker != null && (remove = delayedWorkTracker.BuiltInFictitiousFunctionClassFactory.remove(str)) != null) {
            delayedWorkTracker.MyBillsEntityDataFactory.MyBillsEntityDataFactory(remove);
        }
        WorkManagerImpl workManagerImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StopWorkRunnable(workManagerImpl, str, false));
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void MyBillsEntityDataFactory(List<String> list) {
        for (String str : list) {
            Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            WorkManagerImpl workManagerImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StartWorkRunnable(workManagerImpl, str, null));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void PlaceComponentResult(List<String> list) {
        for (String str : list) {
            Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            WorkManagerImpl workManagerImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StopWorkRunnable(workManagerImpl, str, false));
        }
    }

    private void PlaceComponentResult() {
        if (this.lookAheadTest) {
            return;
        }
        Processor processor = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (processor.getAuthRequestContext) {
            processor.BuiltInFictitiousFunctionClassFactory.add(this);
        }
        this.lookAheadTest = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        androidx.work.Logger.getAuthRequestContext().PlaceComponentResult(androidx.work.impl.background.greedy.GreedyScheduler.getAuthRequestContext, java.lang.String.format("Stopping tracking for %s", r6), new java.lang.Throwable[0]);
        r5.BuiltInFictitiousFunctionClassFactory.remove(r1);
        r5.scheduleImpl.BuiltInFictitiousFunctionClassFactory(r5.BuiltInFictitiousFunctionClassFactory);
     */
    @Override // androidx.work.impl.ExecutionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onExecuted(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            java.lang.Object r7 = r5.moveToNextValue
            monitor-enter(r7)
            java.util.Set<androidx.work.impl.model.WorkSpec> r0 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L42
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L42
        L9:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L40
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L42
            androidx.work.impl.model.WorkSpec r1 = (androidx.work.impl.model.WorkSpec) r1     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = r1.getErrorConfigVersion     // Catch: java.lang.Throwable -> L42
            boolean r2 = r2.equals(r6)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L9
            androidx.work.Logger r0 = androidx.work.Logger.getAuthRequestContext()     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = androidx.work.impl.background.greedy.GreedyScheduler.getAuthRequestContext     // Catch: java.lang.Throwable -> L42
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "Stopping tracking for %s"
            java.lang.String r6 = java.lang.String.format(r6, r3)     // Catch: java.lang.Throwable -> L42
            java.lang.Throwable[] r3 = new java.lang.Throwable[r4]     // Catch: java.lang.Throwable -> L42
            r0.PlaceComponentResult(r2, r6, r3)     // Catch: java.lang.Throwable -> L42
            java.util.Set<androidx.work.impl.model.WorkSpec> r6 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L42
            r6.remove(r1)     // Catch: java.lang.Throwable -> L42
            androidx.work.impl.constraints.WorkConstraintsTracker r6 = r5.scheduleImpl     // Catch: java.lang.Throwable -> L42
            java.util.Set<androidx.work.impl.model.WorkSpec> r0 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L42
            r6.BuiltInFictitiousFunctionClassFactory(r0)     // Catch: java.lang.Throwable -> L42
        L40:
            monitor-exit(r7)
            return
        L42:
            r6 = move-exception
            monitor-exit(r7)
            goto L46
        L45:
            throw r6
        L46:
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.greedy.GreedyScheduler.onExecuted(java.lang.String, boolean):void");
    }
}
