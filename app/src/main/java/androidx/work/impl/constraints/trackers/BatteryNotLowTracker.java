package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;

/* loaded from: classes3.dex */
public class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("BatteryNotLowTracker");

    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getAuthRequestContext() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void BuiltInFictitiousFunctionClassFactory(Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            MyBillsEntityDataFactory((BatteryNotLowTracker) Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            MyBillsEntityDataFactory((BatteryNotLowTracker) Boolean.FALSE);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final /* synthetic */ Object MyBillsEntityDataFactory() {
        Intent registerReceiver = this.MyBillsEntityDataFactory.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf(registerReceiver.getIntExtra("status", -1) == 1 || ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra(H5MapRenderOptimizer.KEY_SCALE, -1)) > 0.15f);
    }
}
