package com.google.android.gms.fido.fido2;

import android.app.Activity;
import android.content.IntentSender;

@Deprecated
/* loaded from: classes7.dex */
public interface Fido2PendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity activity, int i) throws IntentSender.SendIntentException;
}
