package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class au {
    public final Application AFKeystoreWrapper;
    public final SharedPreferences valueOf;

    public au(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.AFKeystoreWrapper = application;
        this.valueOf = ae.values(application);
    }

    public final boolean AFInAppEventType() {
        ae.values();
        return ae.valueOf(this.valueOf, "appsFlyerCount", false) == 0;
    }
}
