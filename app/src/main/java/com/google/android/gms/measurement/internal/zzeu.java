package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes7.dex */
public final class zzeu extends zzkn {
    public zzeu(zzkz zzkzVar) {
        super(zzkzVar);
    }

    public final boolean zza() {
        NetworkInfo activeNetworkInfo;
        zzW();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzs.zzau().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        activeNetworkInfo = null;
        if (activeNetworkInfo != null) {
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        return false;
    }
}
