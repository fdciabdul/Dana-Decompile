package com.google.android.play.core.appupdate;

import android.content.Context;

/* loaded from: classes2.dex */
public final class AppUpdateManagerFactory {
    private AppUpdateManagerFactory() {
    }

    public static AppUpdateManager create(Context context) {
        return zzb.zza(context).zza();
    }
}
