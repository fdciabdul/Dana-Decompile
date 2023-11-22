package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver getAuthRequestContext;

    public abstract void BuiltInFictitiousFunctionClassFactory(Intent intent);

    public abstract IntentFilter getAuthRequestContext();

    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.getAuthRequestContext = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent != null) {
                    BroadcastReceiverConstraintTracker.this.BuiltInFictitiousFunctionClassFactory(intent);
                }
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void PlaceComponentResult() {
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.MyBillsEntityDataFactory.registerReceiver(this.getAuthRequestContext, getAuthRequestContext());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.MyBillsEntityDataFactory.unregisterReceiver(this.getAuthRequestContext);
    }
}
