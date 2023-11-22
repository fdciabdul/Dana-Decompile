package id.dana.data.risk.riskevent.sharetextbroadcast;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public abstract class ShareTextBroadcastReceiver extends BroadcastReceiver {
    public static final String BIZ_CODE = "bizCode";
    public static final String URL = "URL";
    private ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener;

    public abstract void doAction(ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener, ComponentName componentName, String str, String str2);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        String stringExtra = intent.getStringExtra("URL");
        String stringExtra2 = intent.getStringExtra("bizCode");
        if (componentName == null || stringExtra.isEmpty()) {
            return;
        }
        doAction(this.shareTextBroadcastReceiverListener, componentName, stringExtra, stringExtra2);
    }

    public void setListener(ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener) {
        this.shareTextBroadcastReceiverListener = shareTextBroadcastReceiverListener;
    }
}
