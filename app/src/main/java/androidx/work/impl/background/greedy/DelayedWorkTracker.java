package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DelayedWorkTracker {
    static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("DelayedWorkTracker");
    final Map<String, Runnable> BuiltInFictitiousFunctionClassFactory = new HashMap();
    final RunnableScheduler MyBillsEntityDataFactory;
    final GreedyScheduler PlaceComponentResult;

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, RunnableScheduler runnableScheduler) {
        this.PlaceComponentResult = greedyScheduler;
        this.MyBillsEntityDataFactory = runnableScheduler;
    }

    public final void BuiltInFictitiousFunctionClassFactory(final WorkSpec workSpec) {
        Runnable remove = this.BuiltInFictitiousFunctionClassFactory.remove(workSpec.getErrorConfigVersion);
        if (remove != null) {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(remove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.getAuthRequestContext().PlaceComponentResult(DelayedWorkTracker.KClassImpl$Data$declaredNonStaticMembers$2, String.format("Scheduling work %s", workSpec.getErrorConfigVersion), new Throwable[0]);
                DelayedWorkTracker.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(workSpec);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory.put(workSpec.getErrorConfigVersion, runnable);
        long currentTimeMillis = System.currentTimeMillis();
        this.MyBillsEntityDataFactory.getAuthRequestContext(workSpec.PlaceComponentResult() - currentTimeMillis, runnable);
    }
}
