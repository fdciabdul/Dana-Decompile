package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzbh extends com.google.android.gms.internal.location.zzb implements zzbi {
    public zzbh() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzbi zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzbi ? (zzbi) queryLocalInterface : new zzbg(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze((LocationResult) com.google.android.gms.internal.location.zzc.zza(parcel, LocationResult.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzd((LocationAvailability) com.google.android.gms.internal.location.zzc.zza(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
