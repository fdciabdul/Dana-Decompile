package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes7.dex */
public final class zzp extends zza implements zzr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzA() throws RemoteException {
        Parcel zzJ = zzJ(23, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzB() throws RemoteException {
        Parcel zzJ = zzJ(16, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzd() throws RemoteException {
        Parcel zzJ = zzJ(12, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zze() throws RemoteException {
        Parcel zzJ = zzJ(8, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzf() throws RemoteException {
        Parcel zzJ = zzJ(18, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzg() throws RemoteException {
        Parcel zzJ = zzJ(7, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final float zzh() throws RemoteException {
        Parcel zzJ = zzJ(14, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzi() throws RemoteException {
        Parcel zzJ = zzJ(20, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final IObjectWrapper zzj() throws RemoteException {
        Parcel zzJ = zzJ(25, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final LatLng zzk() throws RemoteException {
        Parcel zzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final LatLngBounds zzl() throws RemoteException {
        Parcel zzJ = zzJ(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) zzc.zza(zzJ, LatLngBounds.CREATOR);
        zzJ.recycle();
        return latLngBounds;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final String zzm() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzn() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzo(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzp(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzq(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzr(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzt(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzu(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLngBounds);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzw(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzx(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(15, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final void zzy(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzz(zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzrVar);
        Parcel zzJ = zzJ(19, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
