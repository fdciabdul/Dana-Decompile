package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("BatteryChrgTracker");

    public BatteryChargingTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getAuthRequestContext() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r7.equals("android.intent.action.ACTION_POWER_DISCONNECTED") != false) goto L21;
     */
    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r7 = r7.getAction()
            if (r7 != 0) goto L7
            return
        L7:
            androidx.work.Logger r0 = androidx.work.Logger.getAuthRequestContext()
            java.lang.String r1 = androidx.work.impl.constraints.trackers.BatteryChargingTracker.PlaceComponentResult
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r7
            java.lang.String r5 = "Received %s"
            java.lang.String r3 = java.lang.String.format(r5, r3)
            java.lang.Throwable[] r5 = new java.lang.Throwable[r4]
            r0.PlaceComponentResult(r1, r3, r5)
            r7.hashCode()
            r0 = -1
            int r1 = r7.hashCode()
            r3 = 3
            r5 = 2
            switch(r1) {
                case -1886648615: goto L4a;
                case -54942926: goto L40;
                case 948344062: goto L36;
                case 1019184907: goto L2c;
                default: goto L2b;
            }
        L2b:
            goto L53
        L2c:
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L53
            r4 = 3
            goto L54
        L36:
            java.lang.String r1 = "android.os.action.CHARGING"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L53
            r4 = 2
            goto L54
        L40:
            java.lang.String r1 = "android.os.action.DISCHARGING"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L53
            r4 = 1
            goto L54
        L4a:
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L53
            goto L54
        L53:
            r4 = -1
        L54:
            if (r4 == 0) goto L6f
            if (r4 == r2) goto L69
            if (r4 == r5) goto L63
            if (r4 == r3) goto L5d
            return
        L5d:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.MyBillsEntityDataFactory(r7)
            return
        L63:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.MyBillsEntityDataFactory(r7)
            return
        L69:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.MyBillsEntityDataFactory(r7)
            return
        L6f:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.MyBillsEntityDataFactory(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryChargingTracker.BuiltInFictitiousFunctionClassFactory(android.content.Intent):void");
    }

    private static boolean PlaceComponentResult(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra != 2 && intExtra != 5) {
                return false;
            }
        } else if (intent.getIntExtra("plugged", 0) == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final /* synthetic */ Object MyBillsEntityDataFactory() {
        Intent registerReceiver = this.MyBillsEntityDataFactory.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf(PlaceComponentResult(registerReceiver));
    }
}
