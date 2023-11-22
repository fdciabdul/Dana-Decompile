package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* loaded from: classes3.dex */
public final class zze extends com.google.android.gms.internal.maps.zza implements zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final int zzd() throws RemoteException {
        Parcel zzJ = zzJ(9, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final ICameraUpdateFactoryDelegate zze() throws RemoteException {
        ICameraUpdateFactoryDelegate zzbVar;
        Parcel zzJ = zzJ(4, zza());
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            zzbVar = queryLocalInterface instanceof ICameraUpdateFactoryDelegate ? (ICameraUpdateFactoryDelegate) queryLocalInterface : new zzb(readStrongBinder);
        }
        zzJ.recycle();
        return zzbVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapFragmentDelegate zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        IMapFragmentDelegate zzkVar;
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        Parcel zzJ = zzJ(2, zza);
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            zzkVar = queryLocalInterface instanceof IMapFragmentDelegate ? (IMapFragmentDelegate) queryLocalInterface : new zzk(readStrongBinder);
        }
        zzJ.recycle();
        return zzkVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapViewDelegate zzg(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException {
        IMapViewDelegate zzlVar;
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(zza, googleMapOptions);
        Parcel zzJ = zzJ(3, zza);
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzlVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            zzlVar = queryLocalInterface instanceof IMapViewDelegate ? (IMapViewDelegate) queryLocalInterface : new zzl(readStrongBinder);
        }
        zzJ.recycle();
        return zzlVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaFragmentDelegate zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        IStreetViewPanoramaFragmentDelegate zzbyVar;
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        Parcel zzJ = zzJ(8, zza);
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzbyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            zzbyVar = queryLocalInterface instanceof IStreetViewPanoramaFragmentDelegate ? (IStreetViewPanoramaFragmentDelegate) queryLocalInterface : new zzby(readStrongBinder);
        }
        zzJ.recycle();
        return zzbyVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IStreetViewPanoramaViewDelegate zzi(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        IStreetViewPanoramaViewDelegate zzbzVar;
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        com.google.android.gms.internal.maps.zzc.zzd(zza, streetViewPanoramaOptions);
        Parcel zzJ = zzJ(7, zza);
        IBinder readStrongBinder = zzJ.readStrongBinder();
        if (readStrongBinder == null) {
            zzbzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            zzbzVar = queryLocalInterface instanceof IStreetViewPanoramaViewDelegate ? (IStreetViewPanoramaViewDelegate) queryLocalInterface : new zzbz(readStrongBinder);
        }
        zzJ.recycle();
        return zzbzVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final com.google.android.gms.internal.maps.zzi zzj() throws RemoteException {
        Parcel zzJ = zzJ(5, zza());
        com.google.android.gms.internal.maps.zzi zzb = com.google.android.gms.internal.maps.zzh.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zza.writeInt(18020000);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzl(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zza.writeInt(i);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.maps.zzc.zze(zza, iObjectWrapper);
        zzc(11, zza);
    }
}
