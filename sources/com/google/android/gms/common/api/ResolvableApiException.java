package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

/* loaded from: classes3.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        getStatus().startResolutionForResult(activity, i);
    }
}
