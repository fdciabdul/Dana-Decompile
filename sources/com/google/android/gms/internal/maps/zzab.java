package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes3.dex */
public final class zzab extends zza implements zzad {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzA(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzB(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzC(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(27, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzD() throws RemoteException {
        zzc(11, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzE(zzad zzadVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzadVar);
        Parcel zzJ = zzJ(16, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzF() throws RemoteException {
        Parcel zzJ = zzJ(10, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzG() throws RemoteException {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzH() throws RemoteException {
        Parcel zzJ = zzJ(13, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzI() throws RemoteException {
        Parcel zzJ = zzJ(15, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzd() throws RemoteException {
        Parcel zzJ = zzJ(26, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zze() throws RemoteException {
        Parcel zzJ = zzJ(23, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzf() throws RemoteException {
        Parcel zzJ = zzJ(28, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() throws RemoteException {
        Parcel zzJ = zzJ(17, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel zzJ = zzJ(34, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzJ = zzJ(30, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final LatLng zzj() throws RemoteException {
        Parcel zzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzk() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzl() throws RemoteException {
        Parcel zzJ = zzJ(8, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzm() throws RemoteException {
        Parcel zzJ = zzJ(6, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzn() throws RemoteException {
        zzc(12, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzp(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(25, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzq(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzr(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzs(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzv(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzw(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzx(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzy(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(29, zza);
    }
}
