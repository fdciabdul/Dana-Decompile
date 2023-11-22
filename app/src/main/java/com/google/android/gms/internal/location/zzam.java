package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;

/* loaded from: classes3.dex */
public interface zzam extends IInterface {
    @Deprecated
    Location zzd() throws RemoteException;

    ICancelToken zze(CurrentLocationRequest currentLocationRequest, zzao zzaoVar) throws RemoteException;

    LocationAvailability zzf(String str) throws RemoteException;

    void zzg(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzak zzakVar) throws RemoteException;

    void zzh(LocationSettingsRequest locationSettingsRequest, zzaq zzaqVar, String str) throws RemoteException;

    void zzi(zzai zzaiVar) throws RemoteException;

    void zzj(LastLocationRequest lastLocationRequest, zzao zzaoVar) throws RemoteException;

    void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzl(PendingIntent pendingIntent) throws RemoteException;

    void zzm(com.google.android.gms.location.zzbx zzbxVar, zzak zzakVar) throws RemoteException;

    void zzn(PendingIntent pendingIntent, zzak zzakVar, String str) throws RemoteException;

    void zzo(String[] strArr, zzak zzakVar, String str) throws RemoteException;

    void zzp(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzq(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzr(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zzs(com.google.android.gms.location.zzl zzlVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzt(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback) throws RemoteException;

    @Deprecated
    void zzu(Location location) throws RemoteException;

    void zzv(Location location, IStatusCallback iStatusCallback) throws RemoteException;

    @Deprecated
    void zzw(boolean z) throws RemoteException;

    void zzx(boolean z, IStatusCallback iStatusCallback) throws RemoteException;

    void zzy(zzj zzjVar) throws RemoteException;

    void zzz(zzbh zzbhVar) throws RemoteException;
}
