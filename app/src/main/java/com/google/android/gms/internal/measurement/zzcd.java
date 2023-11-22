package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcd extends zzbm implements zzcf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzcf
    public final void zzd(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, bundle);
        zzc(1, zza);
    }
}
