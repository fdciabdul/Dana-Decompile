package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzbk extends com.google.android.gms.internal.location.zzb implements zzbl {
    public zzbk() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzbl zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzbl ? (zzbl) queryLocalInterface : new zzbj(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzd((Location) com.google.android.gms.internal.location.zzc.zza(parcel, Location.CREATOR));
            return true;
        }
        return false;
    }
}
