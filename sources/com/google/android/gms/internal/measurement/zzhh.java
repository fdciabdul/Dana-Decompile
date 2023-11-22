package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes7.dex */
public final /* synthetic */ class zzhh {
    public static Object zza(zzhi zzhiVar) {
        try {
            return zzhiVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhiVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
