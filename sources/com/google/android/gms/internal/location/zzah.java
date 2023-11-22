package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzaa) zzc.zza(parcel, zzaa.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzc();
        }
        return true;
    }
}
