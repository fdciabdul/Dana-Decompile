package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.internal.base.zaq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zac extends zaq {
    final /* synthetic */ GoogleApiAvailability zaa;
    private final Context zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.zaa = googleApiAvailability;
        this.zab = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            int isGooglePlayServicesAvailable = this.zaa.isGooglePlayServicesAvailable(this.zab);
            if (this.zaa.isUserResolvableError(isGooglePlayServicesAvailable)) {
                this.zaa.showErrorNotification(this.zab, isGooglePlayServicesAvailable);
                return;
            }
            return;
        }
        int i = message.what;
        StringBuilder sb = new StringBuilder(50);
        sb.append("Don't know how to handle this message: ");
        sb.append(i);
        InstrumentInjector.log_w("GoogleApiAvailability", sb.toString());
    }
}
