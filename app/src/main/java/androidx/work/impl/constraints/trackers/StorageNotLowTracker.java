package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class StorageNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("StorageNotLowTracker");

    public StorageNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getAuthRequestContext() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void BuiltInFictitiousFunctionClassFactory(Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            MyBillsEntityDataFactory((StorageNotLowTracker) Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            MyBillsEntityDataFactory((StorageNotLowTracker) Boolean.TRUE);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final /* synthetic */ Object MyBillsEntityDataFactory() {
        Context context = this.MyBillsEntityDataFactory;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        Boolean bool = Boolean.TRUE;
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return bool;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return bool;
        }
        return null;
    }
}
