package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

/* loaded from: classes7.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static final String TAG = "FirebaseMessaging";

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    private static Intent createServiceIntent(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final int onMessageReceive(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            InstrumentInjector.log_e("FirebaseMessaging", "Failed to send message to service.", e);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final void onNotificationDismissed(Context context, Bundle bundle) {
        Intent createServiceIntent = createServiceIntent(context, CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS, bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(createServiceIntent)) {
            MessagingAnalytics.logNotificationDismiss(createServiceIntent);
        }
    }
}
