package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class Trackers {
    private static Trackers BuiltInFictitiousFunctionClassFactory;
    public BatteryNotLowTracker KClassImpl$Data$declaredNonStaticMembers$2;
    public BatteryChargingTracker MyBillsEntityDataFactory;
    public StorageNotLowTracker PlaceComponentResult;
    public NetworkStateTracker getAuthRequestContext;

    public static Trackers KClassImpl$Data$declaredNonStaticMembers$2(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = new Trackers(context, taskExecutor);
            }
            trackers = BuiltInFictitiousFunctionClassFactory;
        }
        return trackers;
    }

    private Trackers(Context context, TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.MyBillsEntityDataFactory = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.getAuthRequestContext = new NetworkStateTracker(applicationContext, taskExecutor);
        this.PlaceComponentResult = new StorageNotLowTracker(applicationContext, taskExecutor);
    }
}
