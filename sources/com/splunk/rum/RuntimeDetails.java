package com.splunk.rum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.io.File;

/* loaded from: classes.dex */
final class RuntimeDetails extends BroadcastReceiver {
    final File MyBillsEntityDataFactory;
    volatile Double PlaceComponentResult = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeDetails BuiltInFictitiousFunctionClassFactory(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        RuntimeDetails runtimeDetails = new RuntimeDetails(context.getFilesDir());
        context.registerReceiver(runtimeDetails, intentFilter);
        return runtimeDetails;
    }

    private RuntimeDetails(File file) {
        this.MyBillsEntityDataFactory = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long BuiltInFictitiousFunctionClassFactory() {
        return Runtime.getRuntime().freeMemory();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        double intExtra = intent.getIntExtra("level", -1);
        Double.isNaN(intExtra);
        Double.isNaN(r5);
        this.PlaceComponentResult = Double.valueOf((intExtra * 100.0d) / r5);
    }
}
