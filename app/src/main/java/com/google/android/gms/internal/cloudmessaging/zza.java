package com.google.android.gms.internal.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes3.dex */
public final class zza {
    public static final int zza;

    static {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 31 || (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'S' && Build.VERSION.CODENAME.charAt(0) <= 'Z')) {
            i = 33554432;
        }
        zza = i;
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }
}
