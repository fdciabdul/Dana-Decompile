package com.google.android.gms.location;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public final class zzbg extends com.google.android.gms.internal.location.zza implements zzbi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzbi
    public final void zzd(LocationAvailability locationAvailability) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.zzbi
    public final void zze(LocationResult locationResult) throws RemoteException {
        throw null;
    }
}
