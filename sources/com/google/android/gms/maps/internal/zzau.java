package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzau extends com.google.android.gms.internal.maps.zzb implements zzav {
    public zzau() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            com.google.android.gms.internal.maps.zzad zzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            boolean zzb2 = zzb(zzb);
            parcel2.writeNoException();
            parcel2.writeInt(zzb2 ? 1 : 0);
            return true;
        }
        return false;
    }
}
