package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes6.dex */
public class BeaconIntentProcessor {
    private static final String TAG = "BeaconIntentProcessor";

    public void handleIntent(Context context, Intent intent) {
        new IntentHandler().convertIntentsToCallbacks(context, intent);
    }
}
