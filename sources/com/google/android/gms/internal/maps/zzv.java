package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes7.dex */
public final class zzv extends zza implements zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final int zzd() throws RemoteException {
        Parcel zzJ = zzJ(5, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zze() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final String zzf() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final void zzg() throws RemoteException {
        zzc(3, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzx
    public final boolean zzh(zzx zzxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzxVar);
        Parcel zzJ = zzJ(4, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
