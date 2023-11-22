package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    public static boolean isInstantApp(Context context) {
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zza;
            if (context2 == null || (bool = zzb) == null || context2 != applicationContext) {
                zzb = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzb = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        zzb = Boolean.FALSE;
                    }
                }
                zza = applicationContext;
                return zzb.booleanValue();
            }
            return bool.booleanValue();
        }
    }
}
