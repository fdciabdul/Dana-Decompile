package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes7.dex */
public abstract class zzh extends com.google.android.gms.internal.maps.zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            com.google.android.gms.internal.maps.zzad zzb = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            IObjectWrapper zzc = zzc(zzb);
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.zzc.zze(parcel2, zzc);
        } else if (i != 2) {
            return false;
        } else {
            com.google.android.gms.internal.maps.zzad zzb2 = com.google.android.gms.internal.maps.zzac.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            IObjectWrapper zzb3 = zzb(zzb2);
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.zzc.zze(parcel2, zzb3);
        }
        return true;
    }
}
